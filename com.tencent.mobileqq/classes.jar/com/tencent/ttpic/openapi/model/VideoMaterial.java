package com.tencent.ttpic.openapi.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.filter.juyoujinggame.UKYOGameSetting;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable.Info;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.light.LightAsset;

public class VideoMaterial
{
  public static final String CRAZYFACE_FACE_COLOR2 = "imageFaceColor2";
  public static final String CRAZYFACE_FACE_COLOR_RANGE = "faceColorRange";
  public static final String[] DEVICE_NEED_COPY_TRANSFORM = { "A1001", "SM-N9006", "vivo_X5Max_L", "vivo_X5Max_L", "vivo_X5V", "vivo_Y23L" };
  public static final int INVALID_INT_FIELD_VALUE = -999999;
  public static final int INVALID_ONLY_ONE_GESTURE = -1;
  public static final String MP4_SUFFIX = ".mp4";
  public static final String PARAMS_FILE_NAME = "params";
  public static final String PNG_SUFFIX = ".png";
  public static final double SCALE_DIFF = 100.0D;
  public static final int SIZE_FACE_ANGLE = 3;
  public static final int SIZE_FACE_POINT = 90;
  public static FilenameFilter mPngFilter = new VideoMaterial.2();
  private float[] arShaderPlanOffset = { 0.0F, 0.0F, 0.0F };
  private CosFun cosFun;
  private String dataPath;
  private List<DistortionItem> distortionItemList;
  private DoodleItem doodleItem;
  private FabbyParts fabbyParts;
  private List<FaceItem> faceOffItemList;
  private String id;
  private boolean isAR3DMaterial;
  private boolean isFreezeFrameRequired = false;
  LightAsset lightAsset;
  private boolean loadImageFromCache = true;
  private List<MultiViewerItem> multiViewerItemList = new ArrayList();
  private int shaderType;
  private LazyLoadAnimationDrawable.Info tipsDrawableInfo;
  
  public static List<PointF> arrayToPointList(int[][] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      localArrayList.add(new PointF(paramArrayOfInt[i][0], paramArrayOfInt[i][1]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static int calSampleSize(long paramLong1, long paramLong2)
  {
    int j;
    if (paramLong1 <= 0L)
    {
      j = 128;
      return j;
    }
    int i = 1;
    for (;;)
    {
      j = i;
      if (paramLong2 <= paramLong1) {
        break;
      }
      i <<= 1;
      paramLong2 >>= 2;
    }
  }
  
  public static List<PointF> copyList(List<PointF> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localArrayList.add(new PointF(localPointF.x, localPointF.y));
    }
    return localArrayList;
  }
  
  public static void flipYPoints(List<PointF> paramList, int paramInt) {}
  
  public static float[] flipYPoints(float[] paramArrayOfFloat, int paramInt)
  {
    return paramArrayOfFloat;
  }
  
  public static int genFullScreenVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = 1;
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return -1;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    paramArrayOfFloat[0] = getCoordinate(paramFloat1, paramFloat2, 0);
    paramArrayOfFloat[1] = getCoordinate(paramFloat3, paramFloat4, 0);
    int j = 0;
    if (j < paramInt1)
    {
      int k;
      if (j % 2 == 0)
      {
        int m = 0;
        k = i;
        i = m;
        while (i < paramInt2)
        {
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i);
          k += 1;
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i + 1);
          k += 1;
          i += 1;
        }
        paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
        paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, paramInt2);
      }
      for (i = k + 1;; i = k + 1)
      {
        j += 1;
        break;
        k = i;
        i = paramInt2;
        while (i > 0)
        {
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i);
          k += 1;
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i - 1);
          k += 1;
          i -= 1;
        }
        paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
        paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, 0);
      }
    }
    return 0;
  }
  
  public static List<PointF> genFullScreenVertices(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return localArrayList;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, 0), getCoordinate(paramFloat3, paramFloat4, 0)));
    int i = 0;
    label69:
    int j;
    if (i < paramInt1)
    {
      if (i % 2 != 0) {
        break label207;
      }
      j = 0;
      while (j < paramInt2)
      {
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, j)));
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i), getCoordinate(paramFloat3, paramFloat4, j + 1)));
        j += 1;
      }
      localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, paramInt2)));
    }
    for (;;)
    {
      i += 1;
      break label69;
      break;
      label207:
      j = paramInt2;
      while (j > 0)
      {
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, j)));
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i), getCoordinate(paramFloat3, paramFloat4, j - 1)));
        j -= 1;
      }
      localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, 0)));
    }
  }
  
  public static int getAllImageSize(String paramString)
  {
    int j = 0;
    String[] arrayOfString;
    int i;
    if (paramString.startsWith("assets://"))
    {
      try
      {
        arrayOfString = AEModule.getContext().getAssets().list(FileUtils.getRealPath(paramString));
        i = j;
        if (arrayOfString == null) {
          return i;
        }
        if (arrayOfString.length == 0) {
          return 0;
        }
        paramString = BitmapUtils.getBitmapSize(AEModule.getContext(), paramString + File.separator + arrayOfString[0]);
        i = j;
        if (paramString == null) {
          return i;
        }
        i = paramString.x;
        j = paramString.y;
        int k = arrayOfString.length;
        return 0 + k * (j * i * 4);
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return 0;
      }
    }
    else
    {
      arrayOfString = new File(paramString).list(mPngFilter);
      i = j;
      if (arrayOfString != null)
      {
        i = j;
        if (arrayOfString.length != 0)
        {
          paramString = BitmapUtils.getBitmapSize(AEModule.getContext(), paramString + File.separator + arrayOfString[0]);
          i = j;
          if (paramString != null)
          {
            i = paramString.x;
            j = paramString.y;
            i = 0 + arrayOfString.length * (j * i * 4);
          }
        }
      }
    }
    return i;
  }
  
  private static float getCoordinate(float paramFloat1, float paramFloat2, int paramInt)
  {
    return paramInt * paramFloat2 + paramFloat1;
  }
  
  public static String getMaterialId(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      paramString = paramString.split(File.separator);
      int i = paramString.length - 1;
      while (i >= 0)
      {
        if (!TextUtils.isEmpty(paramString[i])) {
          return paramString[i];
        }
        i -= 1;
      }
    }
  }
  
  public static boolean isAllFreezeFrameTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value;
  }
  
  public static boolean isAudioTextTriggerType(int paramInt)
  {
    return (300 <= paramInt) && (paramInt <= 311);
  }
  
  public static boolean isBody2AnchorItem(StickerItem paramStickerItem)
  {
    return (isBodyDetectItem(paramStickerItem)) && (paramStickerItem.anchorPoint != null) && (paramStickerItem.anchorPoint.length >= 4) && (paramStickerItem.alignFacePoints != null) && (paramStickerItem.alignFacePoints.length >= 2);
  }
  
  public static boolean isBody4AnchorItem(StickerItem paramStickerItem)
  {
    return (isBodyDetectItem(paramStickerItem)) && (paramStickerItem.anchorPoint != null) && (paramStickerItem.anchorPoint.length >= 8) && (paramStickerItem.alignFacePoints != null) && (paramStickerItem.alignFacePoints.length >= 4);
  }
  
  public static boolean isBodyDetectItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type);
  }
  
  public static boolean isBodyDetectType(int paramInt)
  {
    return paramInt == 400;
  }
  
  public static boolean isBodyTriggerType(int paramInt)
  {
    return paramInt == 401;
  }
  
  public static boolean isCatItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.CAT.type);
  }
  
  public static boolean isCatTriggerType(int paramInt)
  {
    return paramInt == 700;
  }
  
  public static boolean isEmptyItem(FaceItem paramFaceItem)
  {
    return (paramFaceItem == null) || ((TextUtils.isEmpty(paramFaceItem.id)) && (TextUtils.isEmpty(paramFaceItem.faceExchangeImage))) || ((!TextUtils.isEmpty(paramFaceItem.id)) && (paramFaceItem.id.equals("action"))) || ((!TextUtils.isEmpty(paramFaceItem.id)) && (paramFaceItem.id.equals("audio")));
  }
  
  public static boolean isEmptyItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem == null) || (TextUtils.isEmpty(paramStickerItem.id)) || (paramStickerItem.id.equals("action")) || (paramStickerItem.id.equals("audio"));
  }
  
  public static boolean isExternalWordsTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.EXTERNAL_WORDS.value;
  }
  
  public static boolean isFaceItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.TRANSPARENT.type));
  }
  
  public static boolean isFaceTriggerType(int paramInt)
  {
    return paramInt < 200;
  }
  
  public static boolean isGestureItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.GESTURE.type);
  }
  
  public static boolean isGestureTriggerType(int paramInt)
  {
    return ((200 <= paramInt) && (paramInt <= 214)) || (paramInt == 220);
  }
  
  public static boolean isHotAreaTriggerItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {}
    while ((paramStickerItem.triggerArea == null) || (paramStickerItem.triggerArea.size() <= 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean isStarItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STAR.type);
  }
  
  public static boolean isTimeTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.TIME_TRIGGER.value;
  }
  
  public static boolean isTouchTriggerType(int paramInt)
  {
    return paramInt == PTFaceAttr.PTExpression.TAP_SCREEN.value;
  }
  
  public static float[][] listToFloatArray(List<PointF> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = new float[0][];
      return localObject;
    }
    int i = paramList.size();
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { i, 2 });
    i = 0;
    for (;;)
    {
      localObject = arrayOfFloat;
      if (i >= paramList.size()) {
        break;
      }
      arrayOfFloat[i][0] = ((PointF)paramList.get(i)).x;
      arrayOfFloat[i][1] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
  }
  
  public static int[][] listToIntArray(List<PointF> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = new int[0][];
      return localObject;
    }
    int i = paramList.size();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    i = 0;
    for (;;)
    {
      localObject = arrayOfInt;
      if (i >= paramList.size()) {
        break;
      }
      arrayOfInt[i][0] = ((int)((PointF)paramList.get(i)).x);
      arrayOfInt[i][1] = ((int)((PointF)paramList.get(i)).y);
      i += 1;
    }
  }
  
  public static VideoMaterial loadLightAsset(String paramString)
  {
    VideoMaterial localVideoMaterial = new VideoMaterial();
    localVideoMaterial.setDataPath(paramString);
    localVideoMaterial.setId(getMaterialId(paramString));
    localVideoMaterial.lightAsset = LightAsset.Load(paramString, 0);
    return localVideoMaterial;
  }
  
  public static boolean needCopyTransform()
  {
    boolean bool2 = false;
    String str1 = DeviceInstance.getInstance().getDeviceName().trim();
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = DEVICE_NEED_COPY_TRANSFORM;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str2 = arrayOfString[i];
        if (str1.toLowerCase().endsWith(str2.toLowerCase())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean needRenderStar(StarParam paramStarParam)
  {
    return (paramStarParam != null) && (paramStarParam.starStrength >= 0.0F);
  }
  
  public static float[] toFlatArray(List<PointF> paramList)
  {
    if (paramList == null) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[paramList.size() * 2];
    int i = 0;
    if (i < paramList.size())
    {
      PointF localPointF = (PointF)paramList.get(i);
      if (localPointF == null) {}
      for (;;)
      {
        i += 1;
        break;
        arrayOfFloat[(i * 2)] = localPointF.x;
        arrayOfFloat[(i * 2 + 1)] = localPointF.y;
      }
    }
    return arrayOfFloat;
  }
  
  public static float[] toFlatArray(PointF[] paramArrayOfPointF)
  {
    Object localObject;
    if (paramArrayOfPointF == null)
    {
      localObject = new float[0];
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        float[] arrayOfFloat = new float[paramArrayOfPointF.length * 2];
        i = 0;
        localObject = arrayOfFloat;
        if (i >= paramArrayOfPointF.length) {
          break;
        }
        if (paramArrayOfPointF[i] != null)
        {
          arrayOfFloat[(i * 2)] = paramArrayOfPointF[i].x;
          arrayOfFloat[(i * 2 + 1)] = paramArrayOfPointF[i].y;
        }
      }
      catch (OutOfMemoryError paramArrayOfPointF)
      {
        paramArrayOfPointF.printStackTrace();
        return new float[0];
      }
      i += 1;
    }
  }
  
  public void createTipsDrawableInfo(Resources paramResources, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int j = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      localObject1 = new File(paramString1 + File.separator + paramString2);
    } while (!((File)localObject1).isDirectory());
    paramString1 = new ArrayList();
    Object localObject1 = ((File)localObject1).listFiles();
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      localObject2 = localObject1[i];
      if (!((File)localObject2).getName().startsWith(".")) {
        paramString1.add(localObject2);
      }
      i += 1;
    }
    localObject1 = new int[paramString1.size()];
    i = 0;
    while (i < paramString1.size())
    {
      localObject2 = ((File)paramString1.get(i)).getName();
      localObject1[i] = Integer.parseInt(((String)localObject2).substring(paramString2.length() + 1, ((String)localObject2).lastIndexOf(46)));
      i += 1;
    }
    paramString2 = new Integer[localObject1.length];
    i = 0;
    while (i < localObject1.length)
    {
      paramString2[i] = Integer.valueOf(i);
      i += 1;
    }
    Arrays.sort(paramString2, new VideoMaterial.1(this, (int[])localObject1));
    Object localObject2 = new int[localObject1.length];
    i = j;
    while (i < paramString2.length - 1)
    {
      localObject2[i] = ((localObject1[paramString2[(i + 1)].intValue()] - localObject1[paramString2[i].intValue()]) * paramInt1);
      i += 1;
    }
    if (paramString2.length >= 1)
    {
      i = localObject1[paramString2[(paramString2.length - 1)].intValue()];
      localObject2[(paramString2.length - 1)] = ((paramInt2 - i) * paramInt1);
    }
    this.tipsDrawableInfo = new LazyLoadAnimationDrawable.Info(paramResources, paramString1, (int[])localObject2, paramString2);
  }
  
  public float[] getArShaderPlanOffset()
  {
    return this.arShaderPlanOffset;
  }
  
  public CosFun getCosFun()
  {
    return this.cosFun;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public List<DistortionItem> getDistortionItemList()
  {
    return this.distortionItemList;
  }
  
  public DoodleItem getDoodleItem()
  {
    return this.doodleItem;
  }
  
  public FabbyParts getFabbyParts()
  {
    return this.fabbyParts;
  }
  
  public List<FaceFeatureItem> getFaceFeatureItemList()
  {
    return null;
  }
  
  public List<FaceItem> getFaceOffItemList()
  {
    return this.faceOffItemList;
  }
  
  public List<GLBItemJava> getGlbList()
  {
    return null;
  }
  
  public List<StickerItem> getHeadCropItemList()
  {
    return null;
  }
  
  public String getId()
  {
    if (((this.id == null) || (this.id.length() == 0)) && (this.dataPath != null) && (this.dataPath.length() > 0)) {
      this.id = getMaterialId(this.dataPath);
    }
    return this.id;
  }
  
  public boolean getIsAR3DMaterial()
  {
    return this.isAR3DMaterial;
  }
  
  public List<StickerItem> getItemList()
  {
    return null;
  }
  
  public LightAsset getLightAsset()
  {
    return this.lightAsset;
  }
  
  public List<MultiViewerItem> getMultiViewerItemList()
  {
    return this.multiViewerItemList;
  }
  
  public int getShaderType()
  {
    return this.shaderType;
  }
  
  public LazyLoadAnimationDrawable getTipsDrawable()
  {
    if (this.tipsDrawableInfo == null) {
      return null;
    }
    return new LazyLoadAnimationDrawable(this.tipsDrawableInfo);
  }
  
  public String getTipsIcon()
  {
    return null;
  }
  
  public String getTipsText()
  {
    return null;
  }
  
  public UKYOGameSetting getUkyoGameSetting()
  {
    return null;
  }
  
  public boolean hasInnerBeauty()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("materialLUT.enable"));
  }
  
  public boolean hasMultiViewer()
  {
    return (this.multiViewerItemList != null) && (this.multiViewerItemList.size() > 0);
  }
  
  public boolean isAR3DMaterial()
  {
    return getIsAR3DMaterial();
  }
  
  public boolean isAudio2textMaterial()
  {
    return false;
  }
  
  public boolean isCosFunMaterial()
  {
    return getCosFun() != null;
  }
  
  public boolean isCyberpunkMaterial()
  {
    return (this.lightAsset != null) && (this.lightAsset.needCyberpunkStyleAbility());
  }
  
  public boolean isEditableWatermark()
  {
    return (this.lightAsset != null) && (this.lightAsset.isEditableWatermarkMaterial());
  }
  
  public boolean isFace3DMaterial()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.face3d"));
  }
  
  public boolean isFaceMarkingMaterial()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("todo"));
  }
  
  public boolean isFreezeFrameRequired()
  {
    return this.isFreezeFrameRequired;
  }
  
  public boolean isGestureDetectMaterial()
  {
    if (this.lightAsset != null) {
      return this.lightAsset.needRenderAbility("ai.hand");
    }
    return false;
  }
  
  public boolean isNeedFreezeFrame()
  {
    return this.isFreezeFrameRequired;
  }
  
  public boolean isParticleMaterial()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("material.particle"));
  }
  
  public boolean isSticker3DMaterial()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("material.sticker3d"));
  }
  
  public boolean isTNNMaterial()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.gan"));
  }
  
  public boolean isUse3DMMTransform()
  {
    return isFace3DMaterial();
  }
  
  public boolean isUseMesh()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("material.mesh"));
  }
  
  public boolean isWatermarkMaterial()
  {
    return (this.lightAsset != null) && (this.lightAsset.isWatermarkMaterial());
  }
  
  public boolean need3DMM()
  {
    return (isSticker3DMaterial()) || (isFace3DMaterial()) || (needPout());
  }
  
  public boolean needAce3D()
  {
    return isSticker3DMaterial();
  }
  
  public boolean needBodyDetect()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.body"));
  }
  
  public boolean needBodySegment()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.segment"));
  }
  
  public boolean needDetectCat()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.catFace"));
  }
  
  public boolean needDetectGender()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.gender"));
  }
  
  public boolean needFaceInfo()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.face"));
  }
  
  public boolean needHairSegment()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.segmentHair"));
  }
  
  public boolean needHandDetect()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.hand"));
  }
  
  public boolean needHeadSegment()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.headInset"));
  }
  
  public boolean needPag()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("material.pag"));
  }
  
  public boolean needPout()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("material.pout"));
  }
  
  public boolean needRGBDepth()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.rgbDepth"));
  }
  
  public boolean needResetWhenRecord()
  {
    return (this.lightAsset != null) && (this.lightAsset.nativeResetWhenStartRecord());
  }
  
  public boolean needSkySegment()
  {
    return (this.lightAsset != null) && (this.lightAsset.needRenderAbility("ai.segmentSky"));
  }
  
  public LightAsset reloadLightAsset()
  {
    return LightAsset.Load(this.dataPath, 0);
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDoodleItem(DoodleItem paramDoodleItem)
  {
    this.doodleItem = paramDoodleItem;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setShaderType(int paramInt)
  {
    this.shaderType = paramInt;
  }
  
  public String toString()
  {
    return "VideoMaterial{dataPath='" + this.dataPath + '\'' + ", faceOffItemList=" + this.faceOffItemList + ", distortionItemList=" + this.distortionItemList + ", multiViewerItemList=" + this.multiViewerItemList + ", id='" + this.id + '\'' + ", useMesh=" + isUseMesh() + ", segmentRequired=" + needBodySegment() + ", fabbyParts=" + this.fabbyParts + ", needFaceInfo=" + needFaceInfo() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.VideoMaterial
 * JD-Core Version:    0.7.0.1
 */