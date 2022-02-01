package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.openapi.util.SwitchFaceUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaskImagesInitializer
  extends Feature
{
  private static final String REALTIME_BEAUTY_ASSETS_DIR = "realtimeBeauty";
  private static final String TAG = "MaskImagesInitializer";
  private static final ModelInfo[] additionalBeautyImages = { new ModelInfo(false, "realtimeBeauty", "female_beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_normal.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_softlight.png"), new ModelInfo(false, "realtimeBeauty", "male_beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "male_beauty_normal.png") };
  private static final ModelInfo[] basicBeautyImages;
  private static final ModelInfo[] beautyImages;
  private static final ModelInfo[] colorToneImages = { new ModelInfo(true, "realtimeBeauty", "color_tone_baixi.png"), new ModelInfo(true, "realtimeBeauty", "color_tone_hongrun.png") };
  private static final ModelInfo faceColorImage = new ModelInfo(true, true, "realtimeBeauty", "facecolor.png", 0);
  private static final ModelInfo[] faceOffImages = { new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "noeyegray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "nomouthgray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "allgray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "crazyfacegray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceheadcropgray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceMask_skin.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceoffmask.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceMaskCos3D.png"), new ModelInfo(false, "camera/camera_video/defaultmask/", "default_brush_point.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceoffnose.png"), new ModelInfo(false, "realtimeBeauty/", "lipsMask.png") };
  private boolean loadBitmapsWhenInit = true;
  
  static
  {
    beautyImages = new ModelInfo[] { new ModelInfo(false, "realtimeBeauty", "eyemask.jpg"), new ModelInfo(false, "realtimeBeauty", "eyedarken.jpg"), new ModelInfo(false, "realtimeBeauty", "teeth.png"), new ModelInfo(false, "realtimeBeauty", "wrinkles2.jpg"), new ModelInfo(false, "realtimeBeauty", "lipsMask.png"), new ModelInfo(false, "realtimeBeauty", "beauty_normal.png"), new ModelInfo(false, "realtimeBeauty", "beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "beauty_softlight.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_normal.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_softlight.png"), new ModelInfo(false, "realtimeBeauty", "male_beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "male_beauty_normal.png") };
    basicBeautyImages = new ModelInfo[] { new ModelInfo(false, "realtimeBeauty", "eyemask.jpg"), new ModelInfo(false, "realtimeBeauty", "eyedarken.jpg"), new ModelInfo(false, "realtimeBeauty", "teeth.png"), new ModelInfo(false, "realtimeBeauty", "wrinkles2.jpg"), new ModelInfo(false, "realtimeBeauty", "lipsMask.png"), new ModelInfo(false, "realtimeBeauty", "beauty_normal.png"), new ModelInfo(false, "realtimeBeauty", "beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "beauty_softlight.png") };
  }
  
  private void initBeautyMaskImages(String paramString)
  {
    HashSet localHashSet = new HashSet();
    ModelInfo[] arrayOfModelInfo = beautyImages;
    int k = arrayOfModelInfo.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(arrayOfModelInfo[i].fileName);
      i += 1;
    }
    VideoMemoryManager.getInstance().loadBeautyCacheBitmap(paramString, "assets://realtimeBeauty", localHashSet, false);
    localHashSet = new HashSet();
    arrayOfModelInfo = colorToneImages;
    k = arrayOfModelInfo.length;
    i = j;
    while (i < k)
    {
      localHashSet.add(arrayOfModelInfo[i].fileName);
      i += 1;
    }
    VideoMemoryManager.getInstance().loadBeautyCacheBitmap(paramString, "assets://realtimeBeauty", localHashSet, true);
  }
  
  public void clear()
  {
    this.isInited = false;
    VideoMemoryManager.getInstance().clearBeautyCache();
  }
  
  public Bitmap decodeBitmap(ModelInfo paramModelInfo, boolean paramBoolean)
  {
    if (AEModule.getContext() == null) {
      return null;
    }
    String str = paramModelInfo.getFullAssetsPathNoPrefix();
    if (isModelFileInAssets(paramModelInfo))
    {
      paramModelInfo = new StringBuilder();
      paramModelInfo.append("assets://");
      paramModelInfo.append(str);
      paramModelInfo = paramModelInfo.toString();
    }
    else
    {
      paramModelInfo = getModelFinalPath(paramModelInfo);
    }
    if (paramBoolean) {
      return TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramModelInfo);
    }
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramModelInfo, 1);
  }
  
  public Bitmap decodeFaceColorBitmap()
  {
    ModelInfo localModelInfo = faceColorImage;
    return decodeBitmap(localModelInfo, localModelInfo.isEncrypted());
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    if (isExternalResources()) {
      str = getFinalResourcesDir();
    } else {
      str = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = str;
    if (str == null) {
      localObject = "assets://realtimeBeauty";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    String str = localStringBuilder.toString();
    localObject = colorToneImages;
    int m = localObject.length;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (paramString.equals(localObject[i].fileName))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0) {
      return TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(str);
    }
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str, 1);
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, faceOffImages);
    Collections.addAll(localArrayList, beautyImages);
    Collections.addAll(localArrayList, colorToneImages);
    Collections.addAll(localArrayList, new ModelInfo[] { faceColorImage });
    return localArrayList;
  }
  
  public String getName()
  {
    return "MaskImages";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public void initAdditionaleautyMaskImages()
  {
    boolean bool = isExternalResources();
    Object localObject2 = null;
    if (bool) {
      localObject1 = getFinalResourcesDir();
    } else {
      localObject1 = null;
    }
    HashSet localHashSet = new HashSet();
    ModelInfo[] arrayOfModelInfo = additionalBeautyImages;
    int j = arrayOfModelInfo.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(arrayOfModelInfo[i].fileName);
      i += 1;
    }
    VideoMemoryManager.getInstance().loadBeautyCacheBitmap((String)localObject1, "assets://realtimeBeauty", localHashSet, false);
    Object localObject1 = localObject2;
    if (isExternalResources()) {
      localObject1 = getFinalResourcesDir();
    }
    initBeautyMaskImages((String)localObject1);
  }
  
  public void initBasicBeautyMaskImages()
  {
    boolean bool = isExternalResources();
    Object localObject2 = null;
    if (bool) {
      localObject1 = getFinalResourcesDir();
    } else {
      localObject1 = null;
    }
    HashSet localHashSet = new HashSet();
    ModelInfo[] arrayOfModelInfo = basicBeautyImages;
    int k = arrayOfModelInfo.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(arrayOfModelInfo[i].fileName);
      i += 1;
    }
    VideoMemoryManager.getInstance().loadBeautyCacheBitmap((String)localObject1, "assets://realtimeBeauty", localHashSet, false);
    localHashSet = new HashSet();
    arrayOfModelInfo = colorToneImages;
    k = arrayOfModelInfo.length;
    i = j;
    while (i < k)
    {
      localHashSet.add(arrayOfModelInfo[i].fileName);
      i += 1;
    }
    VideoMemoryManager.getInstance().loadBeautyCacheBitmap((String)localObject1, "assets://realtimeBeauty", localHashSet, true);
    Object localObject1 = localObject2;
    if (isExternalResources()) {
      localObject1 = getFinalResourcesDir();
    }
    initBeautyMaskImages((String)localObject1);
  }
  
  public void initBeautyMaskImages()
  {
    String str;
    if (isExternalResources()) {
      str = getFinalResourcesDir();
    } else {
      str = null;
    }
    initBeautyMaskImages(str);
  }
  
  protected boolean initImpl()
  {
    FaceOffUtil.setNoEyeGrayImagePath(getModelFinalPath(faceOffImages[0]));
    FaceOffUtil.setNoMouthGrayImagePath(getModelFinalPath(faceOffImages[1]));
    FaceOffUtil.setCrazyFacePath(getModelFinalPath(faceOffImages[3]));
    FaceOffUtil.setCropHeadFacePath(getModelFinalPath(faceOffImages[4]));
    FaceOffUtil.setFaceMaskSkinPath(getModelFinalPath(faceOffImages[5]));
    FaceOffUtil.setCrazyMaskPath(getModelFinalPath(faceOffImages[6]));
    FaceOffUtil.setCrazyMaskCos3DPath(getModelFinalPath(faceOffImages[7]));
    FaceOffUtil.setMaskBrushPointPath(getModelFinalPath(faceOffImages[8]));
    FaceOffUtil.setGrayFileNoseMask(getModelFinalPath(faceOffImages[9]));
    FaceOffUtil.setCrazyLipsMaskPath(getModelFinalPath(faceOffImages[10]));
    SwitchFaceUtil.setNoEyeGrayImagePath(getModelFinalPath(faceOffImages[0]));
    SwitchFaceUtil.setNoMouthGrayImagePath(getModelFinalPath(faceOffImages[1]));
    SwitchFaceUtil.setAllGrayImagePath(getModelFinalPath(faceOffImages[2]));
    if (this.loadBitmapsWhenInit)
    {
      String str;
      if (isExternalResources()) {
        str = getFinalResourcesDir();
      } else {
        str = null;
      }
      initBeautyMaskImages(str);
    }
    return true;
  }
  
  public boolean isLoadBitmapsWhenInit()
  {
    return this.loadBitmapsWhenInit;
  }
  
  public void setLoadBitmapsWhenInit(boolean paramBoolean)
  {
    this.loadBitmapsWhenInit = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.MaskImagesInitializer
 * JD-Core Version:    0.7.0.1
 */