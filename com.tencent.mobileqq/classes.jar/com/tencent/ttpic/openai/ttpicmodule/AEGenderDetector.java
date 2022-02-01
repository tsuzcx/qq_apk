package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTGenderAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.TNNGenderDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class AEGenderDetector
  extends IDetect
{
  public static final AEGenderDetectorInitializer GENDER_DETECTOR = new AEGenderDetectorInitializer();
  public static final String TAG = "AEGenderDetector";
  public static final AEGenderDetectorOld aeGenderDetectorOld = new AEGenderDetectorOld();
  
  public void clear()
  {
    GENDER_DETECTOR.destroy();
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if (paramAIInput == null) {}
    Object localObject1;
    int i;
    int j;
    int k;
    boolean bool;
    do
    {
      float f;
      do
      {
        do
        {
          return null;
          localObject1 = paramAIParam.getScale(getModuleType());
        } while (localObject1 == null);
        f = ((Float)localObject1).floatValue();
        i = (int)(paramAIParam.getWidth() * f);
        j = (int)(paramAIParam.getHeight() * f);
        k = paramAIParam.getRotation();
        paramAIParam = paramAIParam.getModuleParam(AEDetectorType.GENDER_DETECT.value);
      } while ((paramAIParam == null) || (!paramAIParam.containsKey("faceInfoList")) || (paramAIParam.get("faceInfoList") == null));
      localObject1 = (PTFaceAttr)paramAIParam.get("faceInfoList");
      bool = ((Boolean)paramAIParam.get("resetGender")).booleanValue();
      paramAIParam = ((PTFaceAttr)localObject1).getFaceInfoList();
      localObject1 = ((PTFaceAttr)localObject1).getFaceStatusList();
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      localObject2 = paramAIInput.getBytes(f);
    } while (localObject2 == null);
    paramAIInput = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Object localObject2 = ByteBuffer.wrap((byte[])localObject2);
    ((ByteBuffer)localObject2).rewind();
    paramAIInput.copyPixelsFromBuffer((Buffer)localObject2);
    for (;;)
    {
      localObject2 = new PTGenderAttr();
      if (bool) {
        aeGenderDetectorOld.reset();
      }
      Bitmap localBitmap = BitmapUtils.rotateBitmap(paramAIInput, (-k + 360) % 360);
      AEProfiler.getInstance().start(AEDetectorType.GENDER_DETECT.value);
      aeGenderDetectorOld.detectGenderAndUpdateFaceInfo(localBitmap, localBitmap.getWidth(), localBitmap.getHeight(), paramAIParam);
      long l = AEProfiler.getInstance().end(AEDetectorType.GENDER_DETECT.value);
      AEProfiler.getInstance().add(1, AEDetectorType.GENDER_DETECT.value, l);
      i = 0;
      while ((paramAIParam != null) && (i < paramAIParam.size()))
      {
        FaceInfo localFaceInfo = (FaceInfo)paramAIParam.get(i);
        ((FaceStatus)((List)localObject1).get(i)).gender = localFaceInfo.gender;
        ((PTGenderAttr)localObject2).addGenderInfo(localFaceInfo.faceId, localFaceInfo.rect, localFaceInfo.gender, localFaceInfo.curGender, 0.0F);
        i += 1;
      }
      BitmapUtils.recycle(localBitmap);
      BitmapUtils.recycle(paramAIInput);
      return localObject2;
      paramAIInput = null;
    }
  }
  
  public String getModuleName()
  {
    return "AEGenderDetector";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.GENDER_DETECT.value;
  }
  
  public boolean init()
  {
    return (GENDER_DETECTOR.initGL()) && (aeGenderDetectorOld.init());
  }
  
  public boolean init(String paramString1, String paramString2)
  {
    FeatureManager.Features.RAPID_NET_GENDER_DETECT.setSoDirOverrideFeatureManager(paramString1);
    FeatureManager.Features.RAPID_NET_GENDER_DETECT.setResourceDirOverrideFeatureManager(paramString2);
    return onModuleInstall(paramString1, paramString2);
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    GENDER_DETECTOR.setSoDirOverrideFeatureManager(paramString1);
    GENDER_DETECTOR.setResourceDirOverrideFeatureManager(paramString2);
    return GENDER_DETECTOR.init();
  }
  
  public void onModuleUninstall()
  {
    GENDER_DETECTOR.destroy();
  }
  
  public boolean reloadModel()
  {
    return GENDER_DETECTOR.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetector
 * JD-Core Version:    0.7.0.1
 */