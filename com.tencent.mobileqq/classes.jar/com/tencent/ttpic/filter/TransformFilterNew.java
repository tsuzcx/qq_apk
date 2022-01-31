package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.util.TransformUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransformFilterNew
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/TransformFragmentShader.dat").replace("\\s+", " ");
  private static final int MESH_DISTORTION_TYPE_COUNT = 30;
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/TransformVertexShader.dat").replace("\\s+", " ");
  private static final int XCOORD_NUM = 50;
  private static final int YCOORD_NUM = 66;
  private String dataPath;
  private List<DistortionItem> mCurDistortionItemList;
  private FaceMeshItem mFaceMeshItem;
  private long mFrameStartTime;
  private List<PointF> mFullscreenVertices;
  private List<PointF> mInitTextureCoordinates;
  private int mLastMeshIndex = -1;
  private Map<String, List<DistortionItem>> mMeshCache = new HashMap();
  private boolean mMeshCleared = false;
  private boolean mTriggered = false;
  private MeshDistortionType[] meshs = new MeshDistortionType[30];
  
  public TransformFilterNew(FaceMeshItem paramFaceMeshItem, String paramString)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER, null);
    this.mFaceMeshItem = paramFaceMeshItem;
    this.dataPath = paramString;
    initCoordinates();
    initParams();
  }
  
  private void clearMesh()
  {
    int i = 0;
    while (i < 30)
    {
      addParam(new Param.IntParam(String.format("items[%d].type", new Object[] { Integer.valueOf(i) }), -1));
      i += 1;
    }
    this.mLastMeshIndex = -1;
    this.mCurDistortionItemList = null;
  }
  
  private List<DistortionItem> getNextFrame(int paramInt)
  {
    LogUtil.e("qhz", "getNextFrame: " + paramInt);
    String str = this.mFaceMeshItem.id + "_" + paramInt;
    ArrayList localArrayList;
    if (!this.mMeshCache.containsKey(str))
    {
      localArrayList = new ArrayList();
      Object localObject = VideoFileUtil.load(this.dataPath + "/" + this.mFaceMeshItem.id, str + ".json");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject).optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
          if (localObject != null)
          {
            paramInt = 0;
            while (paramInt < ((JSONArray)localObject).length())
            {
              DistortionItem localDistortionItem = new DistortionItem();
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(paramInt);
              localDistortionItem.position = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
              localDistortionItem.distortion = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
              localDistortionItem.direction = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
              localDistortionItem.radius = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
              localDistortionItem.strength = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
              localDistortionItem.x = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
              localDistortionItem.y = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
              localArrayList.add(localDistortionItem);
              paramInt += 1;
            }
          }
          this.mMeshCache.put(str, localArrayList);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return (List)this.mMeshCache.get(str);
  }
  
  private void initCoordinates()
  {
    this.mFullscreenVertices = VideoMaterialUtil.genFullScreenVertices(50, 66, -1.0F, 1.0F, -1.0F, 1.0F);
    this.mInitTextureCoordinates = VideoMaterialUtil.genFullScreenVertices(50, 66, 0.0F, 1.0F, 0.0F, 1.0F);
  }
  
  private boolean needClearMaterial()
  {
    return (this.mFaceMeshItem.triggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && (!this.mTriggered);
  }
  
  private void updateMeshParam(List<PointF> paramList, FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    long l = this.mFrameStartTime;
    int i = 0;
    if (this.mFaceMeshItem.frameType == 0)
    {
      int j = (int)((paramLong - l) / Math.max(this.mFaceMeshItem.frameDuration, 1.0D)) % Math.max(this.mFaceMeshItem.frames, 1);
      i = j;
      if (!this.mMeshCleared)
      {
        i = j;
        if (j == this.mLastMeshIndex) {
          updateMeshParam(this.mCurDistortionItemList, paramList);
        }
      }
    }
    else if (this.mFaceMeshItem.frameType == 1)
    {
      i = (int)((VideoFilterUtil.getFaceStatus(paramFaceRangeStatus, this.mFaceMeshItem.featureStatType, this.mFaceMeshItem.featureStatValueRange) - this.mFaceMeshItem.featureStatValueRange.min) / ((this.mFaceMeshItem.featureStatValueRange.max - this.mFaceMeshItem.featureStatValueRange.min) / this.mFaceMeshItem.frames));
    }
    paramFaceRangeStatus = getNextFrame(i);
    if ((paramFaceRangeStatus == null) || (paramFaceRangeStatus.isEmpty()) || (needClearMaterial()))
    {
      clearMesh();
      return;
    }
    updateMeshParam(paramFaceRangeStatus, paramList);
    this.mCurDistortionItemList = paramFaceRangeStatus;
    this.mMeshCleared = false;
    this.mLastMeshIndex = i;
  }
  
  private void updateMeshParam(List<DistortionItem> paramList, List<PointF> paramList1)
  {
    if ((VideoUtil.isEmpty(paramList)) || (VideoUtil.isEmpty(paramList1))) {}
    for (;;)
    {
      return;
      paramList1 = TransformUtil.getFullPoints(paramList1);
      float f1 = ((PointF)paramList1.get(18)).x - ((PointF)paramList1.get(0)).x;
      float f2 = (((PointF)paramList1.get(9)).y - ((PointF)paramList1.get(89)).y) / f1;
      float f3 = (float)Math.atan((((PointF)paramList1.get(9)).x - ((PointF)paramList1.get(84)).x) / (-((PointF)paramList1.get(9)).y + ((PointF)paramList1.get(84)).y));
      int j = paramList1.size();
      int i = 0;
      while (i < paramList.size())
      {
        DistortionItem localDistortionItem = (DistortionItem)paramList.get(i);
        this.meshs[i].type = localDistortionItem.distortion;
        this.meshs[i].strength = localDistortionItem.strength;
        if (localDistortionItem.position < j) {
          this.meshs[i].point = ((PointF)paramList1.get(localDistortionItem.position));
        }
        this.meshs[i].radius = ((float)(localDistortionItem.radius * f1 / this.mScreenScale / this.width / 375.0D));
        this.meshs[i].direction = localDistortionItem.direction;
        this.meshs[i].faceDegree = f3;
        this.meshs[i].faceRatio = f2;
        i += 1;
      }
      i = paramList.size();
      while (i < 30)
      {
        this.meshs[i].type = -1;
        i += 1;
      }
      i = 0;
      while (i < 30)
      {
        addParam(new Param.IntParam(String.format("items[%d].type", new Object[] { Integer.valueOf(i) }), this.meshs[i].type));
        addParam(new Param.FloatParam(String.format("items[%d].strength", new Object[] { Integer.valueOf(i) }), this.meshs[i].strength));
        addParam(new Param.Float2fParam(String.format("items[%d].point", new Object[] { Integer.valueOf(i) }), (float)(2.0F * this.meshs[i].point.x / this.mScreenScale / this.width - 1.0D), (float)(2.0F * this.meshs[i].point.y / this.mScreenScale / this.height - 1.0D)));
        addParam(new Param.FloatParam(String.format("items[%d].radius", new Object[] { Integer.valueOf(i) }), this.meshs[i].radius));
        addParam(new Param.IntParam(String.format("items[%d].direction", new Object[] { Integer.valueOf(i) }), this.meshs[i].direction));
        addParam(new Param.FloatParam(String.format("items[%d].faceDegree", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceDegree));
        addParam(new Param.FloatParam(String.format("items[%d].faceRatio", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceRatio));
        i += 1;
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVertices.toArray(new PointF[0])));
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinates.toArray(new PointF[0])));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(6651);
  }
  
  public FaceMeshItem getFaceMeshItem()
  {
    return this.mFaceMeshItem;
  }
  
  public void initParams()
  {
    addParam(new Param.FloatParam("screenRatio", 0.0F));
    int i = 0;
    while (i < 30)
    {
      this.meshs[i] = new MeshDistortionType();
      addParam(new Param.IntParam(String.format("items[%d].type", new Object[] { Integer.valueOf(i) }), this.meshs[i].type));
      addParam(new Param.FloatParam(String.format("items[%d].strength", new Object[] { Integer.valueOf(i) }), this.meshs[i].strength));
      addParam(new Param.Float2fParam(String.format("items[%d].point", new Object[] { Integer.valueOf(i) }), this.meshs[i].point.x, this.meshs[i].point.y));
      addParam(new Param.FloatParam(String.format("items[%d].radius", new Object[] { Integer.valueOf(i) }), this.meshs[i].radius));
      addParam(new Param.IntParam(String.format("items[%d].direction", new Object[] { Integer.valueOf(i) }), this.meshs[i].direction));
      addParam(new Param.FloatParam(String.format("items[%d].faceDegree", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceDegree));
      addParam(new Param.FloatParam(String.format("items[%d].faceRatio", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceRatio));
      i += 1;
    }
  }
  
  protected void updateActionTriggered(FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    if ((this.mFaceMeshItem != null) && (VideoPreviewFaceOutlineDetector.getInstance().detectExpression(this.mFaceMeshItem.triggerType)) && (VideoFilterUtil.isStatusTriggered(paramFaceRangeStatus, this.mFaceMeshItem.featureStatType, this.mFaceMeshItem.featureStatValueRange)))
    {
      if (!this.mTriggered) {
        this.mFrameStartTime = paramLong;
      }
      this.mTriggered = true;
    }
    while ((this.mFaceMeshItem == null) || (!this.mFaceMeshItem.alwaysTriggered)) {
      return;
    }
    this.mTriggered = false;
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    paramList = VideoMaterialUtil.copyList(paramList);
    paramArrayOfFloat = VideoPreviewFaceOutlineDetector.getInstance().detectFaceRangeStatus(paramList);
    updateActionTriggered(paramArrayOfFloat, paramLong);
    if ((paramList == null) || (paramList.size() < 90) || (needClearMaterial()))
    {
      clearMesh();
      this.mTriggered = false;
      this.mMeshCleared = true;
      return;
    }
    updateMeshParam(paramList, paramArrayOfFloat, paramLong);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.FloatParam("screenRatio", this.height / this.width));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransformFilterNew
 * JD-Core Version:    0.7.0.1
 */