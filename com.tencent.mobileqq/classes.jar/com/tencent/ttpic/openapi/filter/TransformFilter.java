package com.tencent.ttpic.openapi.filter;

import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float4sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.openapi.model.VideoMaterial.FIELD;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.ttpic.util.TransformUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.List<Landroid.graphics.PointF;>;
import java.util.Map;
import java.util.Set;

public class TransformFilter
  extends VideoFilterBase
{
  public static final int DISTORTION_LIST_MAX_SIZE = 60;
  private static final List<DistortionItem> EMPTY;
  private static final int XCOORD_NUM = 50;
  private static final int YCOORD_NUM = 66;
  private static final List<Integer> chinFacePoints;
  private static final List<Integer> leftFacePoints;
  private static List<PointF> mFullscreenVerticesPortrait = VideoMaterial.genFullScreenVertices(52, 68, -1.04F, 1.04F, -1.030303F, 1.030303F);
  private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterial.genFullScreenVertices(52, 68, -0.02F, 1.02F, -0.01515152F, 1.015152F);
  private static final List<Integer> rightFacePoints;
  float anotherStrength = 1.0F;
  private String dataPath;
  private float[] flatMesh = new float[480];
  private int frameIndex = 0;
  private List<DistortionItem> items;
  private float[] mFaceAngle;
  private FaceMeshItem mFaceMeshItem;
  private int mLastMeshIndex = -1;
  private Map<String, List<DistortionItem>> mMeshCache = new HashMap();
  private int meshVersion = 2;
  private MeshDistortionType[] meshs = new MeshDistortionType[60];
  private boolean needReCaculateFace = false;
  private float screenRatioX = 1.0F;
  private float screenRatioY = 1.0F;
  private List<StickerItem> stickerItems;
  
  static
  {
    EMPTY = new ArrayList();
    Integer localInteger1 = Integer.valueOf(4);
    Integer localInteger2 = Integer.valueOf(5);
    Integer localInteger3 = Integer.valueOf(6);
    Integer localInteger4 = Integer.valueOf(7);
    Integer localInteger5 = Integer.valueOf(8);
    leftFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), localInteger1, localInteger2, localInteger3, localInteger4, localInteger5 });
    Integer localInteger6 = Integer.valueOf(10);
    Integer localInteger7 = Integer.valueOf(11);
    rightFacePoints = Arrays.asList(new Integer[] { localInteger6, localInteger7, Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18) });
    chinFacePoints = Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3, localInteger4, localInteger5, Integer.valueOf(9), localInteger6, localInteger7, Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14) });
  }
  
  public TransformFilter(FaceMeshItem paramFaceMeshItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.TRANSFORM));
    this.mFaceMeshItem = paramFaceMeshItem;
    this.dataPath = paramString;
    this.items = EMPTY;
    setRenderMode(1);
    initParams();
  }
  
  public TransformFilter(List<DistortionItem> paramList, List<StickerItem> paramList1)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.TRANSFORM));
    this.items = paramList;
    this.stickerItems = paramList1;
    setRenderMode(1);
    initParams();
  }
  
  private float clamp(float paramFloat, double paramDouble1, double paramDouble2)
  {
    double d = paramFloat;
    if (d > paramDouble2) {
      return (float)paramDouble2;
    }
    if (d < paramDouble1) {
      paramFloat = (float)paramDouble1;
    }
    return paramFloat;
  }
  
  private List<DistortionItem> getNextFrame(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mFaceMeshItem.id);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    ArrayList localArrayList;
    if (!this.mMeshCache.containsKey(localObject1))
    {
      localArrayList = new ArrayList();
      Object localObject2 = AEModule.getContext();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.dataPath);
      ((StringBuilder)localObject3).append("/");
      ((StringBuilder)localObject3).append(this.mFaceMeshItem.id);
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(".json");
      localObject2 = FileUtils.load((Context)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        try
        {
          localObject2 = GsonUtils.optJsonArray(GsonUtils.json2JsonObject((String)localObject2), VideoMaterial.FIELD.DISTORTION_LIST.value);
          if (localObject2 != null)
          {
            int i = Math.min(60, ((JsonArray)localObject2).size());
            paramInt = 0;
            while (paramInt < i)
            {
              localObject3 = new DistortionItem();
              localObject4 = ((JsonArray)localObject2).get(paramInt).getAsJsonObject();
              ((DistortionItem)localObject3).position = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.POSITION.value);
              ((DistortionItem)localObject3).distortion = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.DISTORTION.value);
              ((DistortionItem)localObject3).direction = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.DIRECTION.value);
              ((DistortionItem)localObject3).radius = ((float)GsonUtils.optDouble((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.RADIUS.value));
              ((DistortionItem)localObject3).strength = ((float)GsonUtils.optDouble((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.STRENGH.value));
              ((DistortionItem)localObject3).x = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.X.value);
              ((DistortionItem)localObject3).y = GsonUtils.optInt((JsonObject)localObject4, VideoMaterial.DISTORTION_ITEM_FILED.Y.value);
              localArrayList.add(localObject3);
              paramInt += 1;
            }
          }
          this.mMeshCache.put(localObject1, localArrayList);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return (List)this.mMeshCache.get(localObject1);
  }
  
  private float getStrengthAdjust()
  {
    if (DeviceInstance.getInstance().isOppoX909Device()) {
      return 0.2F;
    }
    return 1.0F;
  }
  
  private float my_smoothstep(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = clamp((paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1), 0.0D, 1.0D);
    double d1 = paramFloat1 * paramFloat1;
    double d2 = paramFloat1;
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (float)(d1 * (3.0D - d2 * 2.0D));
  }
  
  private void updateMeshParam()
  {
    int i = this.frameIndex;
    if (i == this.mLastMeshIndex) {
      return;
    }
    this.items = getNextFrame(i);
    this.mLastMeshIndex = i;
  }
  
  private float yawPitchStrengthAdjust(float paramFloat1, float paramFloat2, int paramInt)
  {
    float f2 = 1.0F;
    float f1;
    if ((paramFloat1 >= 0.0F) || (!leftFacePoints.contains(Integer.valueOf(paramInt))))
    {
      f1 = f2;
      if (paramFloat1 > 0.0F)
      {
        f1 = f2;
        if (!rightFacePoints.contains(Integer.valueOf(paramInt))) {}
      }
    }
    else
    {
      f1 = 1.0F * Math.max(1.0F - (Math.abs(paramFloat1) - 0.0F) * 0.7F / 1.6F, 0.0F);
    }
    paramFloat1 = f1;
    if (paramFloat2 < -0.6D)
    {
      paramFloat1 = f1;
      if (chinFacePoints.contains(Integer.valueOf(paramInt)))
      {
        double d1 = f1;
        double d2 = 0.7F;
        double d3 = Math.abs(paramFloat2);
        Double.isNaN(d3);
        Double.isNaN(d2);
        d2 = Math.max(1.0D - d2 * (d3 - 0.6D), 0.0D);
        Double.isNaN(d1);
        paramFloat1 = (float)(d1 * d2);
      }
    }
    return paramFloat1;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
  }
  
  public List<DistortionItem> getDistortionItems()
  {
    return this.items;
  }
  
  public FaceMeshItem getFaceMeshItem()
  {
    return this.mFaceMeshItem;
  }
  
  public void initAttribParams()
  {
    setPositions(VideoMaterial.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterial.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(7125);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("screenRatioX", 0.0F));
    addParam(new UniformParam.FloatParam("screenRatioY", 0.0F));
    addParam(new UniformParam.Float4sParam("item", this.flatMesh));
    addParam(new UniformParam.FloatParam("faceRatio", 1.0F));
    addParam(new UniformParam.FloatParam("sin_roll", 0.0F));
    addParam(new UniformParam.FloatParam("cos_roll", 0.0F));
    addParam(new UniformParam.FloatParam("tan_yaw", 0.0F));
    addParam(new UniformParam.FloatParam("cos_yaw", 0.0F));
    addParam(new UniformParam.FloatParam("tan_pitch", 0.0F));
    addParam(new UniformParam.FloatParam("cos_pitch", 0.0F));
    int i = 0;
    addParam(new UniformParam.IntParam("itemCount", 0));
    addParam(new UniformParam.IntParam("meshVersion", this.meshVersion));
    while (i < 60)
    {
      this.meshs[i] = new MeshDistortionType();
      i += 1;
    }
  }
  
  public boolean isNeedStop()
  {
    return this.dataPath != null;
  }
  
  public void reset() {}
  
  public void setDistortionItems(List<DistortionItem> paramList)
  {
    this.items = paramList;
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.frameIndex = paramInt;
  }
  
  public void setNeedReCaculateFace(boolean paramBoolean)
  {
    this.needReCaculateFace = paramBoolean;
  }
  
  public void stopTransform()
  {
    this.items = EMPTY;
    this.mLastMeshIndex = -1;
  }
  
  public void updateFaceFeatures(List<PointF> paramList)
  {
    Object localObject1 = this;
    if (paramList != null)
    {
      if (paramList.size() < 131) {
        return;
      }
      float f3 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
      float f4 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
      float f1 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
      float f2 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
      f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      f1 = (float)Math.sqrt(f1 * f1 + f2 * f2) / f3;
      f2 = ((PointF)paramList.get(9)).x;
      f3 = ((PointF)paramList.get(84)).x;
      f4 = -((PointF)paramList.get(9)).y;
      float f5 = ((PointF)paramList.get(84)).y;
      f5 = (float)(Math.atan2(f2 - f3, f4 + f5) + 3.141592653589793D);
      float f6 = ((TransformFilter)localObject1).height / ((TransformFilter)localObject1).width;
      double d1 = ((TransformFilter)localObject1).width;
      double d2 = ((TransformFilter)localObject1).mFaceDetScale;
      Double.isNaN(d1);
      f2 = (float)(2.0D / (d1 * d2));
      d1 = ((TransformFilter)localObject1).height;
      d2 = ((TransformFilter)localObject1).mFaceDetScale;
      Double.isNaN(d1);
      f3 = (float)(2.0D / (d1 * d2));
      PointF localPointF = new PointF();
      Object localObject2 = new PointF();
      localObject1 = new PointF();
      int i = 0;
      while (i < 131)
      {
        if ((i >= 99) && (i <= 106))
        {
          f4 = f3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          f3 = f1;
          localObject1 = localObject3;
          f1 = f4;
        }
        else
        {
          localPointF.x = (((PointF)paramList.get(i)).x * f2 - 1.0F);
          localPointF.y = (((PointF)paramList.get(i)).y * f3 - 1.0F);
          int j = 0;
          for (;;)
          {
            localObject3 = this;
            Object localObject4 = ((TransformFilter)localObject3).meshs;
            if (j >= localObject4.length) {
              break;
            }
            if (localObject4[j].type > 0)
            {
              ((PointF)localObject2).x = ((localObject3.meshs[j].point.x + localObject3.meshs[j].offsetX) * f2 - 1.0F);
              ((PointF)localObject2).y = (((localObject3.meshs[j].point.y + localObject3.meshs[j].offsetY) * f3 - 1.0F) * f6);
              ((PointF)localObject1).x = localPointF.x;
              ((PointF)localObject1).y = (localPointF.y * f6);
              f4 = AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
              if (f4 < localObject3.meshs[j].radius)
              {
                float f8 = f4 / localObject3.meshs[j].radius;
                f4 = ((PointF)localObject2).x - ((PointF)localObject1).x;
                float f7 = (((PointF)localObject2).y - ((PointF)localObject1).y) / f6;
                if (localObject3.meshs[j].type == 1)
                {
                  d1 = f8;
                  Double.isNaN(d1);
                  d1 = Math.sin(d1 * 3.1415D * 0.5D);
                  d2 = localObject3.meshs[j].strength;
                  Double.isNaN(d2);
                  f8 = (float)(d2 * ((1.0D - d1) * 1.5D));
                  localPointF.x -= f4 * f8;
                  localPointF.y -= f7 * f8;
                }
                for (;;)
                {
                  break;
                  if (localObject3.meshs[j].type == 2)
                  {
                    d1 = f8;
                    Double.isNaN(d1);
                    d1 = Math.cos(d1 * 1.57075D);
                    d2 = localObject3.meshs[j].strength;
                    Double.isNaN(d2);
                    f8 = (float)(d1 * d2);
                    localPointF.x += f4 * f8;
                    localPointF.y += f7 * f8;
                  }
                  else if (localObject3.meshs[j].type == 3)
                  {
                    d1 = f8;
                    Double.isNaN(d1);
                    d1 = Math.cos(d1 * 1.57075D);
                    d2 = localObject3.meshs[j].radius;
                    Double.isNaN(d2);
                    double d3 = f1;
                    Double.isNaN(d3);
                    d1 = d1 * d2 * 0.5D / d3;
                    d2 = localObject3.meshs[j].strength;
                    Double.isNaN(d2);
                    f7 = (float)(d1 * d2);
                    localObject4 = new PointF(f1, f1 / f6);
                    if (localObject3.meshs[j].direction == 1.0F)
                    {
                      ((PointF)localObject4).x *= -f7;
                      ((PointF)localObject4).y = 0.0F;
                    }
                    else if (localObject3.meshs[j].direction == 2.0F)
                    {
                      ((PointF)localObject4).x = 0.0F;
                      ((PointF)localObject4).y *= -f7;
                    }
                    else if (localObject3.meshs[j].direction == 3.0F)
                    {
                      ((PointF)localObject4).x *= f7;
                      ((PointF)localObject4).y = 0.0F;
                    }
                    else if (localObject3.meshs[j].direction == 4.0F)
                    {
                      ((PointF)localObject4).x = 0.0F;
                      ((PointF)localObject4).y *= f7;
                    }
                    else if (localObject3.meshs[j].direction == 5.0F)
                    {
                      f4 = ((PointF)localObject4).x;
                      f7 = -f7;
                      ((PointF)localObject4).x = (f4 * f7);
                      ((PointF)localObject4).y *= f7;
                    }
                    else if (localObject3.meshs[j].direction == 6.0F)
                    {
                      ((PointF)localObject4).x *= f7;
                      ((PointF)localObject4).y *= -f7;
                    }
                    else if (localObject3.meshs[j].direction == 7.0F)
                    {
                      ((PointF)localObject4).x *= -f7;
                      ((PointF)localObject4).y *= f7;
                    }
                    else if (localObject3.meshs[j].direction == 8.0F)
                    {
                      ((PointF)localObject4).x *= f7;
                      ((PointF)localObject4).y *= f7;
                    }
                    else
                    {
                      ((PointF)localObject4).x = 0.0F;
                      ((PointF)localObject4).y = 0.0F;
                    }
                    d2 = localPointF.x;
                    d3 = ((PointF)localObject4).x;
                    d1 = f5;
                    double d4 = Math.cos(d1);
                    Double.isNaN(d3);
                    f4 = ((PointF)localObject4).y;
                    double d5 = f4;
                    double d6 = Math.sin(d1);
                    Double.isNaN(d5);
                    Double.isNaN(d2);
                    localPointF.x = ((float)(d2 + (d3 * d4 - d5 * d6)));
                    d2 = localPointF.y;
                    d3 = ((PointF)localObject4).y;
                    d4 = Math.cos(d1);
                    Double.isNaN(d3);
                    d5 = ((PointF)localObject4).x;
                    d1 = Math.sin(d1);
                    Double.isNaN(d5);
                    d6 = f6;
                    Double.isNaN(d6);
                    d1 = (d3 * d4 + d5 * d1) / d6;
                    Double.isNaN(d2);
                    localPointF.y = ((float)(d2 + d1));
                    break;
                  }
                }
              }
            }
            j += 1;
          }
          f4 = f1;
          f1 = f3;
          localObject3 = localObject1;
          ((PointF)paramList.get(i)).x = ((localPointF.x + 1.0F) / f2);
          ((PointF)paramList.get(i)).y = ((localPointF.y + 1.0F) / f1);
          localObject1 = localObject2;
          f3 = f4;
          localObject2 = localObject3;
        }
        i += 1;
        Object localObject3 = localObject2;
        f4 = f1;
        f1 = f3;
        f3 = f4;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
  }
  
  public void updateFaceFeatures_new(List<PointF> paramList)
  {
    Object localObject7 = paramList;
    if ((localObject7 != null) && (paramList.size() >= 90))
    {
      if (this.mFaceAngle == null) {
        return;
      }
      float f3 = ((PointF)((List)localObject7).get(18)).x - ((PointF)((List)localObject7).get(0)).x;
      float f4 = ((PointF)((List)localObject7).get(18)).y - ((PointF)((List)localObject7).get(0)).y;
      float f1 = ((PointF)((List)localObject7).get(9)).x - ((PointF)((List)localObject7).get(89)).x;
      float f2 = ((PointF)((List)localObject7).get(9)).y - ((PointF)((List)localObject7).get(89)).y;
      f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      float f13 = (float)Math.sqrt(f1 * f1 + f2 * f2) / f3;
      f1 = ((PointF)((List)localObject7).get(9)).x;
      f2 = ((PointF)((List)localObject7).get(84)).x;
      f3 = -((PointF)((List)localObject7).get(9)).y;
      f4 = ((PointF)((List)localObject7).get(84)).y;
      f1 = (float)(Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D);
      double d1 = this.mFaceAngle[1];
      Double.isNaN(d1);
      d1 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.5D));
      f3 = (float)Math.tan(d1);
      float f5 = (float)Math.cos(d1);
      d1 = f1;
      float f14 = (float)Math.cos(d1);
      float f15 = (float)Math.sin(d1);
      f4 = this.height / this.width;
      d1 = this.width;
      double d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      f1 = (float)(2.0D / (d1 * d2));
      d1 = this.height;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      f2 = (float)(2.0D / (d1 * d2));
      PointF localPointF = new PointF();
      Object localObject6 = new PointF();
      Object localObject4 = new PointF();
      Object localObject5 = new PointF();
      Object localObject2 = new PointF();
      Object localObject3 = new PointF();
      Object localObject1 = new PointF();
      int j = 0;
      while (j < paramList.size())
      {
        if ((j >= 99) && (j <= 106))
        {
          localObject8 = localObject5;
          localObject9 = localObject6;
          f6 = f3;
          f7 = f4;
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject5 = localObject3;
          localObject1 = localObject4;
          f4 = f1;
          localObject4 = localObject8;
          f3 = f2;
          localObject3 = localObject9;
          f2 = f6;
          f1 = f7;
        }
        else
        {
          f6 = ((PointF)((List)localObject7).get(j)).x;
          localPointF.x = (f6 * f1 - 1.0F);
          localPointF.y = (((PointF)((List)localObject7).get(j)).y * f2 - 1.0F);
          int i = 0;
          for (;;)
          {
            localObject7 = this.meshs;
            if (i >= localObject7.length) {
              break;
            }
            if (localObject7[i].type > 0)
            {
              ((PointF)localObject6).x = ((this.meshs[i].point.x + this.meshs[i].offsetX) * f1 - 1.0F);
              ((PointF)localObject6).y = (((this.meshs[i].point.y + this.meshs[i].offsetY) * f2 - 1.0F) * f4);
              ((PointF)localObject2).x = localPointF.x;
              ((PointF)localObject2).y = (localPointF.y * f4);
              ((PointF)localObject2).x -= ((PointF)localObject6).x;
              ((PointF)localObject2).y -= ((PointF)localObject6).y;
              ((PointF)localObject5).x = (((PointF)localObject4).x * f14 + ((PointF)localObject4).y * f15);
              ((PointF)localObject5).y = (((PointF)localObject4).y * f14 - ((PointF)localObject4).x * f15);
              f7 = Math.abs(((PointF)localObject5).x);
              f6 = Math.abs(((PointF)localObject5).y);
              d1 = (float)Math.sqrt(f7 * f7 + f6 * f6);
              Double.isNaN(d1);
              if (d1 * 0.5D <= this.meshs[i].radius)
              {
                do
                {
                  f8 = f13 + ((PointF)localObject5).x * f3;
                } while (f8 <= 0.0D);
                int k = i;
                localObject8 = localObject2;
                localObject7 = localObject3;
                float f8 = clamp(f8, 1.0D, 5.0D);
                float f9 = f8 / f13;
                f7 *= f9;
                f9 = f6 * f9;
                f6 = f7;
                if (f8 > 2.5F) {
                  f6 = f7 / (1.0F - (1.0F - f5) * my_smoothstep(0.0F, 0.05F, f8 - 2.5F));
                }
                f7 = (float)Math.sqrt(f6 * f6 + f9 * f9);
                f6 = f7;
                if (this.meshs[k].type > 1)
                {
                  d1 = f7;
                  Double.isNaN(d1);
                  f6 = (float)(d1 / 1.2D);
                }
                if (f6 < this.meshs[k].radius)
                {
                  ((PointF)localObject7).x = f5;
                  ((PointF)localObject7).y = 1.0F;
                  if (f8 < 2.5D) {
                    ((PointF)localObject7).x = (1.0F - (1.0F - f5) * (1.0F - my_smoothstep(0.0F, 0.1F, 2.5F - f8)));
                  }
                  float f16 = f6 / this.meshs[k].radius;
                  float f11 = this.screenRatioX;
                  f7 = this.screenRatioY;
                  float f10;
                  if (this.meshVersion < 2)
                  {
                    f6 = 1.0F;
                    f12 = 1.0F;
                    f8 = 1.0F;
                    f9 = 0.5625F;
                    f10 = f7;
                    f7 = f12;
                  }
                  else
                  {
                    f6 = f11;
                    f10 = 1.0F;
                    f11 = 1.0F;
                    f8 = 0.5625F;
                    f9 = 1.0F;
                  }
                  float f17 = (((PointF)localObject6).x - localObject8.x) / f11 / 1.2F;
                  float f12 = (((PointF)localObject6).y - localObject8.y) / f10 / 1.2F;
                  if (this.meshs[k].type == 1)
                  {
                    f9 = (1.0F - my_smoothstep(0.0F, 1.0F, f16)) * 1.2F * this.meshs[k].strength;
                    f8 = f17 * f9;
                    f9 = f12 * f9;
                    f10 = ((PointF)localObject7).x;
                    localObject8 = localObject1;
                    localObject8.x = ((f8 * f14 + f9 * f15) * f10);
                    localObject8.y = (((PointF)localObject7).y * (f9 * f14 - f8 * f15));
                    localPointF.x -= (localObject8.x * f14 - localObject8.y * f15) / f6;
                    localPointF.y -= (localObject8.y * f14 + localObject8.x * f15) / f7;
                  }
                  for (;;)
                  {
                    break;
                    localObject8 = localObject1;
                    if (this.meshs[k].type == 2)
                    {
                      f8 = (1.0F - my_smoothstep(0.0F, 1.0F, f16)) * this.meshs[k].strength;
                      f9 = f17 * f8;
                      f8 = f12 * f8;
                      localObject8.x = ((f9 * f14 + f8 * f15) * ((PointF)localObject7).x);
                      localObject8.y = (((PointF)localObject7).y * (f8 * f14 - f9 * f15));
                      localPointF.x += (localObject8.x * f14 - localObject8.y * f15) / f6;
                      localPointF.y += (localObject8.y * f14 + localObject8.x * f15) / f7;
                    }
                    else if (this.meshs[k].type == 3)
                    {
                      f12 = 1.0F - f16 * f16;
                      f12 = f12 * my_smoothstep(0.0F, 1.0F, f12) * this.meshs[k].radius * 0.5F * this.meshs[k].strength;
                      localObject8.x = (1.0F / f11);
                      localObject8.y = (1.0F / f10);
                      if (this.meshs[k].direction == 1.0F)
                      {
                        localObject8.x *= -f12;
                        localObject8.y = 0.0F;
                      }
                      else if (this.meshs[k].direction == 2.0F)
                      {
                        localObject8.x = 0.0F;
                        localObject8.y *= -f12;
                      }
                      else if (this.meshs[k].direction == 3.0F)
                      {
                        localObject8.x *= f12;
                        localObject8.y = 0.0F;
                      }
                      else if (this.meshs[k].direction == 4.0F)
                      {
                        localObject8.x = 0.0F;
                        localObject8.y *= f12;
                      }
                      else if (this.meshs[k].direction == 5.0F)
                      {
                        f10 = localObject8.x;
                        f11 = -f12;
                        localObject8.x = (f10 * f11);
                        localObject8.y *= f11;
                      }
                      else if (this.meshs[k].direction == 6.0F)
                      {
                        localObject8.x *= f12;
                        localObject8.y *= -f12;
                      }
                      else if (this.meshs[k].direction == 7.0F)
                      {
                        localObject8.x *= -f12;
                        localObject8.y *= f12;
                      }
                      else if (this.meshs[k].direction == 8.0F)
                      {
                        localObject8.x *= f12;
                        localObject8.y *= f12;
                      }
                      else
                      {
                        localObject8.x = 0.0F;
                        localObject8.y = 0.0F;
                      }
                      localObject8.x *= ((PointF)localObject7).x;
                      localObject8.y *= ((PointF)localObject7).y;
                      localObject8.y *= f8;
                      localPointF.x += (localObject8.x * f14 - localObject8.y * f15) / f6;
                      localPointF.y += (localObject8.y * f14 + localObject8.x * f15) * f9 / f7;
                    }
                    else if (this.meshs[k].type <= 5)
                    {
                      f12 = 1.0F - f16 * f16;
                      f12 = f12 * my_smoothstep(0.0F, 1.0F, f12) * this.meshs[k].radius * 0.5F * this.meshs[k].strength;
                      f11 = (float)Math.cos(this.meshs[k].direction) * f12 / f11;
                      f10 = f12 * (float)Math.sin(this.meshs[k].direction) / f10;
                      localObject8.x = (f11 * f14 + f10 * f15);
                      localObject8.y = (f10 * f14 - f11 * f15);
                      localObject8.x *= ((PointF)localObject7).x;
                      localObject8.y *= ((PointF)localObject7).y;
                      localObject8.y *= f8;
                      localPointF.x += (localObject8.x * f14 - localObject8.y * f15) / f6;
                      localPointF.y += (localObject8.y * f14 + localObject8.x * f15) * f9 / f7;
                    }
                  }
                }
              }
            }
            i += 1;
          }
          localObject7 = paramList;
          localObject8 = localObject4;
          localObject4 = localObject5;
          f6 = f1;
          f7 = f2;
          f2 = f3;
          f1 = f4;
          localObject9 = localObject1;
          localObject5 = localObject3;
          ((PointF)((List)localObject7).get(j)).x = ((localPointF.x + 1.0F) / f6);
          ((PointF)((List)localObject7).get(j)).y = ((localPointF.y + 1.0F) / f7);
          localObject3 = localObject6;
          f3 = f7;
          f4 = f6;
          localObject1 = localObject8;
          localObject6 = localObject2;
          localObject2 = localObject9;
        }
        j += 1;
        Object localObject8 = localObject5;
        float f6 = f4;
        localObject5 = localObject4;
        Object localObject9 = localObject3;
        float f7 = f2;
        f4 = f1;
        localObject3 = localObject2;
        localObject2 = localObject6;
        localObject4 = localObject1;
        f1 = f6;
        localObject6 = localObject9;
        f2 = f3;
        f3 = f7;
        localObject1 = localObject3;
        localObject3 = localObject8;
      }
    }
  }
  
  public void updateParams(List<PointF> paramList, Set<Integer> paramSet, double paramDouble, float[] paramArrayOfFloat)
  {
    Arrays.fill(this.flatMesh, -1.0F);
    Object localObject1 = VideoMaterial.copyList(paramList);
    if ((localObject1 != null) && (((List)localObject1).size() >= 90) && (!CollectionUtils.isEmpty(this.items)) && (VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet)))
    {
      localObject1 = TransformUtil.getFullPoints((List)localObject1);
      float f3 = ((PointF)((List)localObject1).get(18)).x - ((PointF)((List)localObject1).get(0)).x;
      float f4 = ((PointF)((List)localObject1).get(18)).y - ((PointF)((List)localObject1).get(0)).y;
      float f1 = ((PointF)((List)localObject1).get(9)).x - ((PointF)((List)localObject1).get(89)).x;
      float f2 = ((PointF)((List)localObject1).get(9)).y - ((PointF)((List)localObject1).get(89)).y;
      float f6 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      float f7 = (float)Math.sqrt(f1 * f1 + f2 * f2) / f6;
      f1 = ((PointF)((List)localObject1).get(9)).x;
      f2 = ((PointF)((List)localObject1).get(84)).x;
      f3 = -((PointF)((List)localObject1).get(9)).y;
      f4 = ((PointF)((List)localObject1).get(84)).y;
      f3 = (float)(Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D);
      double d1 = ((PointF)((List)localObject1).get(9)).x * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      double d2 = this.width;
      Double.isNaN(d2);
      f1 = (float)(d1 / d2 - 1.0D);
      d1 = ((PointF)((List)localObject1).get(9)).y * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d2 = this.height;
      Double.isNaN(d2);
      PointF localPointF = new PointF(f1, (float)(d1 / d2 - 1.0D) * this.height / this.width);
      d1 = ((PointF)((List)localObject1).get(89)).x * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d2 = this.width;
      Double.isNaN(d2);
      f1 = (float)(d1 / d2 - 1.0D);
      d1 = ((PointF)((List)localObject1).get(89)).y * 2.0F;
      Double.isNaN(d1);
      d1 /= paramDouble;
      d2 = this.height;
      Double.isNaN(d2);
      Object localObject2 = new PointF(f1, (float)(d1 / d2 - 1.0D) * this.height / this.width);
      f1 = AlgoUtils.getDistance(localPointF, (PointF)localObject2);
      d1 = paramArrayOfFloat[1];
      Double.isNaN(d1);
      d1 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d1 * 1.5D));
      float f8 = (float)Math.tan(d1);
      float f9 = (float)Math.cos(d1);
      paramList = new PointF(((PointF)((List)localObject1).get(43)).x + (((PointF)((List)localObject1).get(9)).x - ((PointF)((List)localObject1).get(43)).x) / 3.0F, ((PointF)((List)localObject1).get(43)).y + (((PointF)((List)localObject1).get(9)).y - ((PointF)((List)localObject1).get(43)).y) / 3.0F);
      d2 = paramList.x * 2.0F;
      Double.isNaN(d2);
      d2 /= paramDouble;
      double d3 = this.width;
      Double.isNaN(d3);
      paramList.x = ((float)(d2 / d3 - 1.0D));
      d2 = paramList.y * 2.0F;
      Double.isNaN(d2);
      d2 /= paramDouble;
      d3 = this.height;
      Double.isNaN(d3);
      paramList.y = ((float)(d2 / d3 - 1.0D) * this.height / this.width);
      paramSet = new PointF(((PointF)((List)localObject1).get(53)).x + (((PointF)((List)localObject1).get(9)).x - ((PointF)((List)localObject1).get(53)).x) / 3.0F, ((PointF)((List)localObject1).get(53)).y + (((PointF)((List)localObject1).get(9)).y - ((PointF)((List)localObject1).get(53)).y) / 3.0F);
      d2 = paramSet.x * 2.0F;
      Double.isNaN(d2);
      d2 /= paramDouble;
      d3 = this.width;
      Double.isNaN(d3);
      paramSet.x = ((float)(d2 / d3 - 1.0D));
      d2 = paramSet.y * 2.0F;
      Double.isNaN(d2);
      d2 /= paramDouble;
      d3 = this.height;
      Double.isNaN(d3);
      paramSet.y = ((float)(d2 / d3 - 1.0D) * this.height / this.width);
      f2 = AlgoUtils.getDistance(paramList, paramSet);
      int k = 0;
      d2 = paramArrayOfFloat[0];
      Double.isNaN(d2);
      d2 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, d2 * 1.4D));
      f4 = (float)Math.tan(d2);
      paramArrayOfFloat = (float[])localObject2;
      float f10 = (float)Math.cos(d2);
      d3 = f3;
      float f11 = (float)Math.cos(d3);
      float f5 = (float)Math.sin(d3);
      int i = ((List)localObject1).size();
      int j = 0;
      double d4;
      double d5;
      while (j < this.items.size())
      {
        localObject2 = (DistortionItem)this.items.get(j);
        this.meshs[j].type = ((DistortionItem)localObject2).distortion;
        if (((DistortionItem)localObject2).position < i) {
          this.meshs[j].point = ((PointF)((List)localObject1).get(((DistortionItem)localObject2).position));
        }
        float f12 = getStrengthAdjust();
        this.meshs[j].strength = (((DistortionItem)localObject2).strength * f12 * yawPitchStrengthAdjust(f8, f4, ((DistortionItem)localObject2).position));
        Object localObject3 = this.meshs[j];
        d4 = ((DistortionItem)localObject2).radius * f6;
        Double.isNaN(d4);
        d4 /= paramDouble;
        d5 = Math.min(this.width, this.height);
        Double.isNaN(d5);
        ((MeshDistortionType)localObject3).radius = ((float)(d4 / d5 / 375.0D));
        f12 = ((DistortionItem)localObject2).x * f9;
        float f13 = ((DistortionItem)localObject2).y * f10;
        localObject3 = this.meshs;
        localObject3[j].offsetX = ((f12 * f11 + f13 * f5) * f6 / 375.0F);
        localObject3[j].offsetY = ((f12 * f5 - f13 * f11) * f6 / 375.0F);
        localObject3[j].direction = ((DistortionItem)localObject2).direction;
        if ((((DistortionItem)localObject2).distortion != 4) && (((DistortionItem)localObject2).distortion != 5)) {
          break label1678;
        }
        localObject3 = (PointF)((List)localObject1).get(((DistortionItem)localObject2).direction);
        f12 = (((DistortionItem)localObject2).targetDx * f11 * f9 + ((DistortionItem)localObject2).targetDy * f5 * f10) * f6 / 375.0F;
        f13 = (((DistortionItem)localObject2).targetDx * f5 * f9 - ((DistortionItem)localObject2).targetDy * f11 * f10) * f6 / 375.0F;
        this.meshs[j].direction = ((float)Math.atan2(((PointF)localObject3).y + f13 - this.meshs[j].point.y - this.meshs[j].offsetY, ((PointF)localObject3).x + f12 - this.meshs[j].point.x - this.meshs[j].offsetX));
        if (((DistortionItem)localObject2).distortion == 5)
        {
          localObject2 = this.meshs;
          localObject2[j].direction += 3.141593F;
        }
        label1678:
        localObject2 = this.meshs;
        localObject2[j].faceDegree = f3;
        localObject2[j].faceRatio = f7;
        j += 1;
      }
      localObject2 = paramSet;
      i = this.items.size();
      while (i < 60)
      {
        this.meshs[i].type = -1;
        i += 1;
      }
      i = 0;
      paramSet = localPointF;
      localObject1 = paramList;
      paramList = (List<PointF>)localObject2;
      j = k;
      while (i < this.items.size())
      {
        localObject2 = this.flatMesh;
        k = j + 1;
        localObject2[j] = this.meshs[i].type;
        localObject2 = this.flatMesh;
        j = k + 1;
        localObject2[k] = this.meshs[i].strength;
        d4 = (this.meshs[i].point.x + this.meshs[i].offsetX) * 2.0F;
        Double.isNaN(d4);
        d4 /= paramDouble;
        d5 = this.width;
        Double.isNaN(d5);
        f5 = (float)(d4 / d5 - 1.0D);
        d4 = (this.meshs[i].point.y + this.meshs[i].offsetY) * 2.0F;
        Double.isNaN(d4);
        d4 /= paramDouble;
        d5 = this.height;
        Double.isNaN(d5);
        f6 = (float)(d4 / d5 - 1.0D);
        localObject2 = this.flatMesh;
        k = j + 1;
        localObject2[j] = (this.screenRatioX * f5);
        j = k + 1;
        localObject2[k] = (this.screenRatioY * f6);
        f4 = AlgoUtils.distanceOfPoint2Line(paramSet, paramArrayOfFloat, f1, new PointF(f5, this.height * f6 / this.width)) * f8;
        f3 = f4;
        if ((paramSet.x - paramArrayOfFloat.x) * (f6 - paramArrayOfFloat.y) - (paramSet.y - paramArrayOfFloat.y) * (f5 - paramArrayOfFloat.x) > 0.0F) {
          f3 = -f4;
        }
        AlgoUtils.distanceOfPoint2Line((PointF)localObject1, paramList, f2, new PointF(f5, this.height * f6 / this.width));
        f4 = ((PointF)localObject1).x;
        f4 = paramList.x;
        f4 = paramList.y;
        f4 = ((PointF)localObject1).y;
        f4 = paramList.y;
        f4 = paramList.x;
        f3 = 2.5F + f3;
        localObject2 = this.meshs;
        localObject2[i].radius = (localObject2[i].radius * 2.5F / f3);
        localObject2 = this.flatMesh;
        k = j + 1;
        localObject2[j] = this.meshs[i].radius;
        localObject2 = this.flatMesh;
        j = k + 1;
        localObject2[k] = this.meshs[i].direction;
        localObject2 = this.flatMesh;
        k = j + 1;
        localObject2[j] = f3;
        j = k + 1;
        localObject2[k] = 0.0F;
        i += 1;
      }
      addParam(new UniformParam.FloatParam("faceRatio", f7));
      addParam(new UniformParam.FloatParam("sin_roll", (float)Math.sin(d3)));
      addParam(new UniformParam.FloatParam("cos_roll", (float)Math.cos(d3)));
      addParam(new UniformParam.FloatParam("tan_yaw", (float)Math.tan(d1)));
      addParam(new UniformParam.FloatParam("cos_yaw", (float)Math.cos(d1)));
      addParam(new UniformParam.FloatParam("tan_pitch", (float)Math.tan(d2)));
      addParam(new UniformParam.FloatParam("cos_pitch", (float)Math.cos(d2)));
      addParam(new UniformParam.IntParam("itemCount", this.items.size()));
      addParam(new UniformParam.Float4sParam("item", this.flatMesh));
      return;
    }
    addParam(new UniformParam.Float4sParam("item", this.flatMesh));
    addParam(new UniformParam.FloatParam("faceRatio", 1.0F));
  }
  
  public void updatePreview(Object paramObject)
  {
    if (!(paramObject instanceof PTDetectInfo)) {
      return;
    }
    PTDetectInfo localPTDetectInfo = (PTDetectInfo)paramObject;
    paramObject = localPTDetectInfo.faceAngles;
    if ((localPTDetectInfo.phoneAngle == 90.0F) || (localPTDetectInfo.phoneAngle == 270.0F))
    {
      paramObject = new float[3];
      paramObject[0] = (-localPTDetectInfo.faceAngles[1]);
      paramObject[1] = (-localPTDetectInfo.faceAngles[0]);
      paramObject[2] = localPTDetectInfo.faceAngles[2];
    }
    if (this.dataPath != null) {
      updateMeshParam();
    }
    updateParams(localPTDetectInfo.facePoints, localPTDetectInfo.triggeredExpression, this.mFaceDetScale, paramObject);
    this.mFaceAngle = localPTDetectInfo.faceAngles;
    if (this.needReCaculateFace) {
      updateFaceFeatures_new(localPTDetectInfo.transformPoints);
    }
  }
  
  public void updateStrength(float paramFloat)
  {
    this.anotherStrength = paramFloat;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    float f2 = this.height / this.width;
    float f1;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    } else {
      f1 = 1.0F / f2;
    }
    this.screenRatioX = f1;
    if (f2 > 1.0F) {
      f1 = f2;
    } else {
      f1 = 1.0F;
    }
    this.screenRatioY = f1;
    addParam(new UniformParam.FloatParam("screenRatioX", this.screenRatioX));
    addParam(new UniformParam.FloatParam("screenRatioY", this.screenRatioY));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TransformFilter
 * JD-Core Version:    0.7.0.1
 */