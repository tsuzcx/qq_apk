package com.tencent.ttpic.openapi.filter;

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
import java.util.Map;
import java.util.Set;

public class TransformFilter
  extends VideoFilterBase
{
  public static final int DISTORTION_LIST_MAX_SIZE = 60;
  private static final List<DistortionItem> EMPTY;
  private static final int XCOORD_NUM = 50;
  private static final int YCOORD_NUM = 66;
  private static final List<Integer> chinFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14) });
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
    leftFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8) });
    rightFacePoints = Arrays.asList(new Integer[] { Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18) });
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
    float f;
    if (paramFloat > paramDouble2) {
      f = (float)paramDouble2;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramFloat >= paramDouble1);
    return (float)paramDouble1;
  }
  
  private List<DistortionItem> getNextFrame(int paramInt)
  {
    String str = this.mFaceMeshItem.id + "_" + paramInt;
    ArrayList localArrayList;
    if (!this.mMeshCache.containsKey(str))
    {
      localArrayList = new ArrayList();
      Object localObject = FileUtils.load(AEModule.getContext(), this.dataPath + "/" + this.mFaceMeshItem.id, str + ".json");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = GsonUtils.optJsonArray(GsonUtils.json2JsonObject((String)localObject), VideoMaterial.FIELD.DISTORTION_LIST.value);
          if (localObject != null)
          {
            int i = Math.min(60, ((JsonArray)localObject).size());
            paramInt = 0;
            while (paramInt < i)
            {
              DistortionItem localDistortionItem = new DistortionItem();
              JsonObject localJsonObject = ((JsonArray)localObject).get(paramInt).getAsJsonObject();
              localDistortionItem.position = GsonUtils.optInt(localJsonObject, VideoMaterial.DISTORTION_ITEM_FILED.POSITION.value);
              localDistortionItem.distortion = GsonUtils.optInt(localJsonObject, VideoMaterial.DISTORTION_ITEM_FILED.DISTORTION.value);
              localDistortionItem.direction = GsonUtils.optInt(localJsonObject, VideoMaterial.DISTORTION_ITEM_FILED.DIRECTION.value);
              localDistortionItem.radius = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterial.DISTORTION_ITEM_FILED.RADIUS.value));
              localDistortionItem.strength = ((float)GsonUtils.optDouble(localJsonObject, VideoMaterial.DISTORTION_ITEM_FILED.STRENGH.value));
              localDistortionItem.x = GsonUtils.optInt(localJsonObject, VideoMaterial.DISTORTION_ITEM_FILED.X.value);
              localDistortionItem.y = GsonUtils.optInt(localJsonObject, VideoMaterial.DISTORTION_ITEM_FILED.Y.value);
              localArrayList.add(localDistortionItem);
              paramInt += 1;
            }
          }
          this.mMeshCache.put(str, localArrayList);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return (List)this.mMeshCache.get(str);
  }
  
  private float getStrengthAdjust()
  {
    float f = 1.0F;
    if (DeviceInstance.getInstance().isOppoX909Device()) {
      f = 0.2F;
    }
    return f;
  }
  
  private float my_smoothstep(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = clamp((paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1), 0.0D, 1.0D);
    double d = paramFloat1 * paramFloat1;
    return (float)((3.0D - paramFloat1 * 2.0D) * d);
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
    if ((paramFloat1 >= -0.0F) || (!leftFacePoints.contains(Integer.valueOf(paramInt))))
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
      f1 = 1.0F * Math.max(1.0F - (Math.abs(paramFloat1) - 0.0F) * 0.7F / (1.6F - 0.0F), 0.0F);
    }
    paramFloat1 = f1;
    if (paramFloat2 < -0.6D)
    {
      paramFloat1 = f1;
      if (chinFacePoints.contains(Integer.valueOf(paramInt)))
      {
        double d = f1;
        paramFloat1 = (float)(Math.max(1.0D - 0.7F * (Math.abs(paramFloat2) - 0.6D), 0.0D) * d);
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
    int i = 0;
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
    if ((paramList == null) || (paramList.size() < 131)) {
      return;
    }
    float f3 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
    float f4 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
    float f1 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
    float f2 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
    f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
    f1 = (float)Math.sqrt(f2 * f2 + f1 * f1) / f3;
    f2 = ((PointF)paramList.get(9)).x;
    f3 = ((PointF)paramList.get(84)).x;
    f4 = -((PointF)paramList.get(9)).y;
    float f5 = ((PointF)paramList.get(84)).y;
    f2 = (float)(Math.atan2(f2 - f3, f5 + f4) + 3.141592653589793D);
    f3 = this.height / this.width;
    f4 = (float)(2.0D / (this.width * this.mFaceDetScale));
    f5 = (float)(2.0D / (this.height * this.mFaceDetScale));
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    PointF localPointF3 = new PointF();
    int i = 0;
    label342:
    if (i < 131) {
      if ((i < 99) || (i > 106)) {
        break label373;
      }
    }
    for (;;)
    {
      i += 1;
      break label342;
      break;
      label373:
      localPointF1.x = (((PointF)paramList.get(i)).x * f4 - 1.0F);
      localPointF1.y = (((PointF)paramList.get(i)).y * f5 - 1.0F);
      int j = 0;
      if (j < this.meshs.length)
      {
        if (this.meshs[j].type <= 0) {}
        float f8;
        float f7;
        label777:
        do
        {
          for (;;)
          {
            j += 1;
            break;
            localPointF2.x = ((this.meshs[j].point.x + this.meshs[j].offsetX) * f4 - 1.0F);
            localPointF2.y = (((this.meshs[j].point.y + this.meshs[j].offsetY) * f5 - 1.0F) * f3);
            localPointF3.x = localPointF1.x;
            localPointF1.y *= f3;
            f6 = AlgoUtils.getDistance(localPointF2, localPointF3);
            if (f6 < this.meshs[j].radius)
            {
              f8 = f6 / this.meshs[j].radius;
              f6 = localPointF2.x - localPointF3.x;
              f7 = (localPointF2.y - localPointF3.y) / f3;
              if (this.meshs[j].type == 1)
              {
                f8 = (float)(1.5D * (1.0D - Math.sin(f8 * 3.1415D * 0.5D)) * this.meshs[j].strength);
                localPointF1.x -= f6 * f8;
                localPointF1.y -= f8 * f7;
              }
              else
              {
                if (this.meshs[j].type != 2) {
                  break label777;
                }
                f8 = (float)(Math.cos(1.57075D * f8) * this.meshs[j].strength);
                localPointF1.x = (f6 * f8 + localPointF1.x);
                localPointF1.y = (f8 * f7 + localPointF1.y);
              }
            }
          }
        } while (this.meshs[j].type != 3);
        float f6 = (float)(Math.cos(f8 * 1.57075D) * this.meshs[j].radius * 0.5D / f1 * this.meshs[j].strength);
        PointF localPointF4 = new PointF(f1, f1 / f3);
        if (this.meshs[j].direction == 1.0F)
        {
          f7 = localPointF4.x;
          localPointF4.x = (-f6 * f7);
          localPointF4.y = 0.0F;
        }
        for (;;)
        {
          localPointF1.x = ((float)(localPointF1.x + (localPointF4.x * Math.cos(f2) - localPointF4.y * Math.sin(f2))));
          double d1 = localPointF1.y;
          double d2 = localPointF4.y;
          double d3 = Math.cos(f2);
          localPointF1.y = ((float)((localPointF4.x * Math.sin(f2) + d2 * d3) / f3 + d1));
          break;
          if (this.meshs[j].direction == 2.0F)
          {
            localPointF4.x = 0.0F;
            f7 = localPointF4.y;
            localPointF4.y = (-f6 * f7);
          }
          else if (this.meshs[j].direction == 3.0F)
          {
            localPointF4.x = (f6 * localPointF4.x);
            localPointF4.y = 0.0F;
          }
          else if (this.meshs[j].direction == 4.0F)
          {
            localPointF4.x = 0.0F;
            localPointF4.y = (f6 * localPointF4.y);
          }
          else if (this.meshs[j].direction == 5.0F)
          {
            localPointF4.x *= -f6;
            f7 = localPointF4.y;
            localPointF4.y = (-f6 * f7);
          }
          else if (this.meshs[j].direction == 6.0F)
          {
            localPointF4.x *= f6;
            f7 = localPointF4.y;
            localPointF4.y = (-f6 * f7);
          }
          else if (this.meshs[j].direction == 7.0F)
          {
            localPointF4.x *= -f6;
            localPointF4.y = (f6 * localPointF4.y);
          }
          else if (this.meshs[j].direction == 8.0F)
          {
            localPointF4.x *= f6;
            localPointF4.y = (f6 * localPointF4.y);
          }
          else
          {
            localPointF4.x = 0.0F;
            localPointF4.y = 0.0F;
          }
        }
      }
      ((PointF)paramList.get(i)).x = ((localPointF1.x + 1.0F) / f4);
      ((PointF)paramList.get(i)).y = ((localPointF1.y + 1.0F) / f5);
    }
  }
  
  public void updateFaceFeatures_new(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 90) || (this.mFaceAngle == null)) {
      return;
    }
    float f3 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
    float f4 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
    float f1 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
    float f2 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
    f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
    float f7 = (float)Math.sqrt(f2 * f2 + f1 * f1) / f3;
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    f3 = -((PointF)paramList.get(9)).y;
    f4 = ((PointF)paramList.get(84)).y;
    f1 = (float)(Math.atan2(f1 - f2, f4 + f3) + 3.141592653589793D);
    f2 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, this.mFaceAngle[1] * 1.5D));
    float f8 = (float)Math.tan(f2);
    float f9 = (float)Math.cos(f2);
    float f10 = (float)Math.cos(f1);
    float f11 = (float)Math.sin(f1);
    float f12 = this.height / this.width;
    float f13 = (float)(2.0D / (this.width * this.mFaceDetScale));
    float f14 = (float)(2.0D / (this.height * this.mFaceDetScale));
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    PointF localPointF3 = new PointF();
    PointF localPointF4 = new PointF();
    PointF localPointF5 = new PointF();
    PointF localPointF6 = new PointF();
    PointF localPointF7 = new PointF();
    int i = 0;
    label430:
    if (i < paramList.size()) {
      if ((i < 99) || (i > 106)) {
        break label464;
      }
    }
    for (;;)
    {
      i += 1;
      break label430;
      break;
      label464:
      localPointF1.x = (((PointF)paramList.get(i)).x * f13 - 1.0F);
      localPointF1.y = (((PointF)paramList.get(i)).y * f14 - 1.0F);
      int j = 0;
      if (j < this.meshs.length)
      {
        if (this.meshs[j].type <= 0) {}
        for (;;)
        {
          j += 1;
          break;
          localPointF2.x = ((this.meshs[j].point.x + this.meshs[j].offsetX) * f13 - 1.0F);
          localPointF2.y = (((this.meshs[j].point.y + this.meshs[j].offsetY) * f14 - 1.0F) * f12);
          localPointF5.x = localPointF1.x;
          localPointF1.y *= f12;
          localPointF5.x -= localPointF2.x;
          localPointF5.y -= localPointF2.y;
          localPointF4.x = (localPointF3.x * f10 + localPointF3.y * f11);
          localPointF4.y = (localPointF3.y * f10 - localPointF3.x * f11);
          f2 = Math.abs(localPointF4.x);
          f1 = Math.abs(localPointF4.y);
          if ((float)Math.sqrt(f2 * f2 + f1 * f1) * 0.5D <= this.meshs[j].radius)
          {
            f3 = f7 + localPointF4.x * f8;
            if (f3 > 0.0D)
            {
              f3 = clamp(f3, 1.0D, 5.0D);
              f2 = f3 / f7 * f2;
              f4 = f3 / f7 * f1;
              f1 = f2;
              if (f3 > 2.5F) {
                f1 = f2 / (1.0F - (1.0F - f9) * my_smoothstep(0.0F, 0.05F, f3 - 2.5F));
              }
              f2 = (float)Math.sqrt(f1 * f1 + f4 * f4);
              f1 = f2;
              if (this.meshs[j].type > 1) {
                f1 = (float)(f2 / 1.2D);
              }
              if (f1 < this.meshs[j].radius)
              {
                localPointF6.x = f9;
                localPointF6.y = 1.0F;
                if (f3 < 2.5D) {
                  localPointF6.x = (1.0F - (1.0F - my_smoothstep(0.0F, 0.1F, 2.5F - f3)) * (1.0F - f9));
                }
                float f15 = f1 / this.meshs[j].radius;
                f2 = this.screenRatioX;
                f1 = this.screenRatioY;
                f4 = 1.0F;
                float f6 = 1.0F;
                float f5 = 1.0F;
                f3 = 0.5625F;
                if (this.meshVersion < 2)
                {
                  f2 = 1.0F;
                  f1 = 1.0F;
                  f4 = 0.5625F;
                  f6 = this.screenRatioX;
                  f5 = this.screenRatioY;
                  f3 = 1.0F;
                }
                float f17 = (localPointF2.x - localPointF5.x) / f6 / 1.2F;
                float f16 = (localPointF2.y - localPointF5.y) / f5 / 1.2F;
                if (this.meshs[j].type == 1)
                {
                  f3 = 1.2F * (1.0F - my_smoothstep(0.0F, 1.0F, f15)) * this.meshs[j].strength;
                  f4 = f17 * f3;
                  f3 *= f16;
                  localPointF7.x = ((f4 * f10 + f3 * f11) * localPointF6.x);
                  localPointF7.y = ((f3 * f10 - f4 * f11) * localPointF6.y);
                  localPointF1.x -= (localPointF7.x * f10 - localPointF7.y * f11) / f2;
                  localPointF1.y -= (localPointF7.y * f10 + localPointF7.x * f11) / f1;
                }
                else if (this.meshs[j].type == 2)
                {
                  f3 = (1.0F - my_smoothstep(0.0F, 1.0F, f15)) * this.meshs[j].strength;
                  f4 = f17 * f3;
                  f3 *= f16;
                  localPointF7.x = ((f4 * f10 + f3 * f11) * localPointF6.x);
                  localPointF7.y = ((f3 * f10 - f4 * f11) * localPointF6.y);
                  localPointF1.x += (localPointF7.x * f10 - localPointF7.y * f11) / f2;
                  localPointF1.y += (localPointF7.y * f10 + localPointF7.x * f11) / f1;
                }
                else
                {
                  if (this.meshs[j].type == 3)
                  {
                    f15 = 1.0F - f15 * f15;
                    f15 = f15 * my_smoothstep(0.0F, 1.0F, f15) * this.meshs[j].radius * 0.5F * this.meshs[j].strength;
                    localPointF7.x = (1.0F / f6);
                    localPointF7.y = (1.0F / f5);
                    if (this.meshs[j].direction == 1.0F)
                    {
                      localPointF7.x *= -f15;
                      localPointF7.y = 0.0F;
                    }
                    for (;;)
                    {
                      localPointF7.x *= localPointF6.x;
                      localPointF7.y *= localPointF6.y;
                      localPointF7.y = (f3 * localPointF7.y);
                      localPointF1.x += (localPointF7.x * f10 - localPointF7.y * f11) / f2;
                      localPointF1.y += (localPointF7.y * f10 + localPointF7.x * f11) * f4 / f1;
                      break;
                      if (this.meshs[j].direction == 2.0F)
                      {
                        localPointF7.x = 0.0F;
                        localPointF7.y *= -f15;
                      }
                      else if (this.meshs[j].direction == 3.0F)
                      {
                        localPointF7.x *= f15;
                        localPointF7.y = 0.0F;
                      }
                      else if (this.meshs[j].direction == 4.0F)
                      {
                        localPointF7.x = 0.0F;
                        localPointF7.y *= f15;
                      }
                      else if (this.meshs[j].direction == 5.0F)
                      {
                        localPointF7.x *= -f15;
                        localPointF7.y *= -f15;
                      }
                      else if (this.meshs[j].direction == 6.0F)
                      {
                        localPointF7.x *= f15;
                        localPointF7.y *= -f15;
                      }
                      else if (this.meshs[j].direction == 7.0F)
                      {
                        localPointF7.x *= -f15;
                        localPointF7.y *= f15;
                      }
                      else if (this.meshs[j].direction == 8.0F)
                      {
                        localPointF7.x *= f15;
                        localPointF7.y *= f15;
                      }
                      else
                      {
                        localPointF7.x = 0.0F;
                        localPointF7.y = 0.0F;
                      }
                    }
                  }
                  if (this.meshs[j].type <= 5)
                  {
                    f15 = 1.0F - f15 * f15;
                    f15 = f15 * my_smoothstep(0.0F, 1.0F, f15) * this.meshs[j].radius * 0.5F * this.meshs[j].strength;
                    f6 = (float)Math.cos(this.meshs[j].direction) * f15 / f6;
                    f5 = f15 * (float)Math.sin(this.meshs[j].direction) / f5;
                    localPointF7.x = (f6 * f10 + f5 * f11);
                    localPointF7.y = (f5 * f10 - f6 * f11);
                    localPointF7.x *= localPointF6.x;
                    localPointF7.y *= localPointF6.y;
                    localPointF7.y = (f3 * localPointF7.y);
                    localPointF1.x += (localPointF7.x * f10 - localPointF7.y * f11) / f2;
                    localPointF1.y += (localPointF7.y * f10 + localPointF7.x * f11) * f4 / f1;
                  }
                }
              }
            }
          }
        }
      }
      ((PointF)paramList.get(i)).x = ((localPointF1.x + 1.0F) / f13);
      ((PointF)paramList.get(i)).y = ((localPointF1.y + 1.0F) / f14);
    }
  }
  
  public void updateParams(List<PointF> paramList, Set<Integer> paramSet, double paramDouble, float[] paramArrayOfFloat)
  {
    Arrays.fill(this.flatMesh, -1.0F);
    Object localObject = VideoMaterial.copyList(paramList);
    if ((localObject == null) || (((List)localObject).size() < 90) || (CollectionUtils.isEmpty(this.items)) || (!VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet)))
    {
      addParam(new UniformParam.Float4sParam("item", this.flatMesh));
      addParam(new UniformParam.FloatParam("faceRatio", 1.0F));
      return;
    }
    List localList = TransformUtil.getFullPoints((List)localObject);
    float f1 = ((PointF)localList.get(18)).x - ((PointF)localList.get(0)).x;
    float f4 = ((PointF)localList.get(18)).y - ((PointF)localList.get(0)).y;
    float f2 = ((PointF)localList.get(9)).x - ((PointF)localList.get(89)).x;
    float f3 = ((PointF)localList.get(9)).y - ((PointF)localList.get(89)).y;
    f1 = (float)Math.sqrt(f1 * f1 + f4 * f4);
    f3 = (float)Math.sqrt(f3 * f3 + f2 * f2) / f1;
    f2 = ((PointF)localList.get(9)).x;
    f4 = ((PointF)localList.get(84)).x;
    float f5 = -((PointF)localList.get(9)).y;
    float f6 = ((PointF)localList.get(84)).y;
    f4 = (float)(Math.atan2(f2 - f4, f6 + f5) + 3.141592653589793D);
    paramList = new PointF((float)(((PointF)localList.get(9)).x * 2.0F / paramDouble / this.width - 1.0D), (float)(((PointF)localList.get(9)).y * 2.0F / paramDouble / this.height - 1.0D) * this.height / this.width);
    paramSet = new PointF((float)(((PointF)localList.get(89)).x * 2.0F / paramDouble / this.width - 1.0D), (float)(((PointF)localList.get(89)).y * 2.0F / paramDouble / this.height - 1.0D) * this.height / this.width);
    f5 = AlgoUtils.getDistance(paramList, paramSet);
    f6 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat[1] * 1.5D));
    float f7 = (float)Math.tan(f6);
    f2 = (float)Math.cos(f6);
    float f8 = ((PointF)localList.get(43)).x;
    float f9 = (((PointF)localList.get(9)).x - ((PointF)localList.get(43)).x) / 3.0F;
    float f10 = ((PointF)localList.get(43)).y;
    localObject = new PointF(f8 + f9, (((PointF)localList.get(9)).y - ((PointF)localList.get(43)).y) / 3.0F + f10);
    ((PointF)localObject).x = ((float)(2.0F * ((PointF)localObject).x / paramDouble / this.width - 1.0D));
    ((PointF)localObject).y = ((float)(2.0F * ((PointF)localObject).y / paramDouble / this.height - 1.0D) * this.height / this.width);
    f8 = ((PointF)localList.get(53)).x;
    f9 = (((PointF)localList.get(9)).x - ((PointF)localList.get(53)).x) / 3.0F;
    f10 = ((PointF)localList.get(53)).y;
    PointF localPointF1 = new PointF(f8 + f9, (((PointF)localList.get(9)).y - ((PointF)localList.get(53)).y) / 3.0F + f10);
    localPointF1.x = ((float)(2.0F * localPointF1.x / paramDouble / this.width - 1.0D));
    localPointF1.y = ((float)(2.0F * localPointF1.y / paramDouble / this.height - 1.0D) * this.height / this.width);
    f8 = AlgoUtils.getDistance((PointF)localObject, localPointF1);
    f9 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat[0] * 1.4D));
    f10 = (float)Math.tan(f9);
    float f11 = (float)Math.cos(f9);
    float f12 = (float)Math.cos(f4);
    float f13 = (float)Math.sin(f4);
    int j = localList.size();
    int i = 0;
    float f14;
    float f15;
    while (i < this.items.size())
    {
      paramArrayOfFloat = (DistortionItem)this.items.get(i);
      this.meshs[i].type = paramArrayOfFloat.distortion;
      if (paramArrayOfFloat.position < j) {
        this.meshs[i].point = ((PointF)localList.get(paramArrayOfFloat.position));
      }
      f14 = getStrengthAdjust();
      this.meshs[i].strength = (f14 * paramArrayOfFloat.strength * yawPitchStrengthAdjust(f7, f10, paramArrayOfFloat.position));
      this.meshs[i].radius = ((float)(paramArrayOfFloat.radius * f1 / paramDouble / Math.min(this.width, this.height) / 375.0D));
      f14 = paramArrayOfFloat.x * f2;
      f15 = paramArrayOfFloat.y * f11;
      this.meshs[i].offsetX = ((f14 * f12 + f15 * f13) * f1 / 375.0F);
      this.meshs[i].offsetY = ((f14 * f13 - f15 * f12) * f1 / 375.0F);
      this.meshs[i].direction = paramArrayOfFloat.direction;
      if ((paramArrayOfFloat.distortion == 4) || (paramArrayOfFloat.distortion == 5))
      {
        PointF localPointF2 = (PointF)localList.get(paramArrayOfFloat.direction);
        f14 = (paramArrayOfFloat.targetDx * f12 * f2 + paramArrayOfFloat.targetDy * f13 * f11) * f1 / 375.0F;
        f15 = (paramArrayOfFloat.targetDx * f13 * f2 - paramArrayOfFloat.targetDy * f12 * f11) * f1 / 375.0F;
        this.meshs[i].direction = ((float)Math.atan2(f15 + localPointF2.y - this.meshs[i].point.y - this.meshs[i].offsetY, localPointF2.x + f14 - this.meshs[i].point.x - this.meshs[i].offsetX));
        if (paramArrayOfFloat.distortion == 5) {
          this.meshs[i].direction = (3.141593F + this.meshs[i].direction);
        }
      }
      this.meshs[i].faceDegree = f4;
      this.meshs[i].faceRatio = f3;
      i += 1;
    }
    i = this.items.size();
    while (i < 60)
    {
      this.meshs[i].type = -1;
      i += 1;
    }
    j = 0;
    i = 0;
    while (i < this.items.size())
    {
      paramArrayOfFloat = this.flatMesh;
      int k = j + 1;
      paramArrayOfFloat[j] = this.meshs[i].type;
      paramArrayOfFloat = this.flatMesh;
      j = k + 1;
      paramArrayOfFloat[k] = this.meshs[i].strength;
      f11 = (float)(2.0F * (this.meshs[i].point.x + this.meshs[i].offsetX) / paramDouble / this.width - 1.0D);
      f12 = (float)(2.0F * (this.meshs[i].point.y + this.meshs[i].offsetY) / paramDouble / this.height - 1.0D);
      paramArrayOfFloat = this.flatMesh;
      k = j + 1;
      paramArrayOfFloat[j] = (this.screenRatioX * f11);
      paramArrayOfFloat = this.flatMesh;
      j = k + 1;
      paramArrayOfFloat[k] = (this.screenRatioY * f12);
      f2 = AlgoUtils.distanceOfPoint2Line(paramList, paramSet, f5, new PointF(f11, this.height * f12 / this.width)) * f7;
      f1 = f2;
      if ((paramList.x - paramSet.x) * (f12 - paramSet.y) - (paramList.y - paramSet.y) * (f11 - paramSet.x) > 0.0F) {
        f1 = -f2;
      }
      f2 = AlgoUtils.distanceOfPoint2Line((PointF)localObject, localPointF1, f8, new PointF(f11, this.height * f12 / this.width));
      f13 = ((PointF)localObject).x;
      f14 = localPointF1.x;
      f15 = localPointF1.y;
      float f16 = ((PointF)localObject).y;
      float f17 = localPointF1.y;
      if ((f12 - f15) * (f13 - f14) - (f11 - localPointF1.x) * (f16 - f17) > 0.0F) {
        f2 = -(f2 * f10);
      }
      f1 += 2.5F;
      this.meshs[i].radius = (this.meshs[i].radius * 2.5F / f1);
      paramArrayOfFloat = this.flatMesh;
      k = j + 1;
      paramArrayOfFloat[j] = this.meshs[i].radius;
      paramArrayOfFloat = this.flatMesh;
      j = k + 1;
      paramArrayOfFloat[k] = this.meshs[i].direction;
      paramArrayOfFloat = this.flatMesh;
      k = j + 1;
      paramArrayOfFloat[j] = f1;
      paramArrayOfFloat = this.flatMesh;
      j = k + 1;
      paramArrayOfFloat[k] = 0.0F;
      i += 1;
    }
    addParam(new UniformParam.FloatParam("faceRatio", f3));
    addParam(new UniformParam.FloatParam("sin_roll", (float)Math.sin(f4)));
    addParam(new UniformParam.FloatParam("cos_roll", (float)Math.cos(f4)));
    addParam(new UniformParam.FloatParam("tan_yaw", (float)Math.tan(f6)));
    addParam(new UniformParam.FloatParam("cos_yaw", (float)Math.cos(f6)));
    addParam(new UniformParam.FloatParam("tan_pitch", (float)Math.tan(f9)));
    addParam(new UniformParam.FloatParam("cos_pitch", (float)Math.cos(f9)));
    addParam(new UniformParam.IntParam("itemCount", this.items.size()));
    addParam(new UniformParam.Float4sParam("item", this.flatMesh));
  }
  
  public void updatePreview(Object paramObject)
  {
    if (!(paramObject instanceof PTDetectInfo)) {}
    PTDetectInfo localPTDetectInfo;
    do
    {
      return;
      localPTDetectInfo = (PTDetectInfo)paramObject;
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
    } while (!this.needReCaculateFace);
    updateFaceFeatures_new(localPTDetectInfo.transformPoints);
  }
  
  public void updateStrength(float paramFloat)
  {
    this.anotherStrength = paramFloat;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    float f3 = 1.0F;
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    float f2 = this.height / this.width;
    if (f2 > 1.0F) {}
    for (float f1 = 1.0F;; f1 = 1.0F / f2)
    {
      this.screenRatioX = f1;
      f1 = f3;
      if (f2 > 1.0F) {
        f1 = f2;
      }
      this.screenRatioY = f1;
      addParam(new UniformParam.FloatParam("screenRatioX", this.screenRatioX));
      addParam(new UniformParam.FloatParam("screenRatioY", this.screenRatioY));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TransformFilter
 * JD-Core Version:    0.7.0.1
 */