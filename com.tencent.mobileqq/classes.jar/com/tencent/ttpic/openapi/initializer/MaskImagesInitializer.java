package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.openapi.util.SwitchFaceUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaskImagesInitializer
  extends Feature
{
  private static final String REALTIME_BEAUTY_ASSETS_DIR = "realtimeBeauty";
  private static final String TAG = MaskImagesInitializer.class.getSimpleName();
  private static final ModelInfo[] beautyImages = { new ModelInfo(false, "realtimeBeauty", "eyemask.jpg"), new ModelInfo(false, "realtimeBeauty", "eyedarken.jpg"), new ModelInfo(false, "realtimeBeauty", "teeth.png"), new ModelInfo(false, "realtimeBeauty", "wrinkles2.jpg"), new ModelInfo(false, "realtimeBeauty", "lipsMask.png"), new ModelInfo(false, "realtimeBeauty", "beauty_normal.png"), new ModelInfo(false, "realtimeBeauty", "beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "beauty_softlight.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_normal.png"), new ModelInfo(false, "realtimeBeauty", "female_beauty_softlight.png"), new ModelInfo(false, "realtimeBeauty", "male_beauty_multiply.png"), new ModelInfo(false, "realtimeBeauty", "male_beauty_normal.png") };
  private static final ModelInfo[] colorToneImages = { new ModelInfo(true, "realtimeBeauty", "color_tone_baixi.png"), new ModelInfo(true, "realtimeBeauty", "color_tone_hongrun.png") };
  private static final ModelInfo faceColorImage = new ModelInfo(true, true, "realtimeBeauty", "facecolor.png", 0);
  private static final ModelInfo[] faceOffImages = { new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "noeyegray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "nomouthgray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "allgray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "crazyfacegray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceheadcropgray.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceMask_skin.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceoffmask.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceMaskCos3D.png"), new ModelInfo(false, "camera/camera_video/defaultmask/", "default_brush_point.png"), new ModelInfo(false, "camera/camera_video/faceOff/grayImages/", "faceoffnose.png"), new ModelInfo(false, "realtimeBeauty/", "lipsMask.png") };
  
  private void initBeautyMaskImages(String paramString)
  {
    int j = 0;
    HashSet localHashSet = new HashSet();
    ModelInfo[] arrayOfModelInfo = beautyImages;
    int k = arrayOfModelInfo.length;
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
    if (isModelFileInAssets(paramModelInfo)) {}
    for (paramModelInfo = "assets://" + str; paramBoolean; paramModelInfo = getModelFinalPath(paramModelInfo)) {
      return TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramModelInfo);
    }
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramModelInfo, 1);
  }
  
  public Bitmap decodeFaceColorBitmap()
  {
    return decodeBitmap(faceColorImage, faceColorImage.isEncrypted());
  }
  
  protected boolean destroyImpl()
  {
    return false;
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
    if (isExternalResources()) {}
    for (String str = getFinalResourcesDir();; str = null)
    {
      initBeautyMaskImages(str);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.MaskImagesInitializer
 * JD-Core Version:    0.7.0.1
 */