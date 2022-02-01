package com.tencent.ttpic.openapi.ttpicmodule.module_rgb_depth;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIInput.DataSize;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.ttpicmodule.RGBDepthImpl;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.nio.ByteBuffer;
import java.util.Map;

public class PTRGBDepth
  extends IDetect
{
  public static volatile int DETECT_TYPE = 0;
  public static final RGBDepthInitializer RGB_DEPTH;
  public static final String TAG = AEDetectorType.RGB_DEPTH.value;
  
  static
  {
    RGB_DEPTH = new RGBDepthInitializer();
  }
  
  public static void setUseSmallModel(boolean paramBoolean)
  {
    RGB_DEPTH.setUseSmallModel(paramBoolean);
  }
  
  public void clear()
  {
    RGB_DEPTH.getSegmentImpl().destroy();
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    Object localObject2 = null;
    if ((paramAIInput == null) || (paramAIInput.getInput("frame") == null)) {
      return null;
    }
    int k = paramAIParam.getBytesDataSizeWidth(getModuleType()).intValue();
    int m = paramAIParam.getBytesDataSizeHeight(getModuleType()).intValue();
    int n = paramAIParam.getRotation();
    int j = 0;
    Object localObject1 = paramAIParam.getModuleParam(TAG);
    int i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((Map)localObject1).containsKey("depthDetectType"))
      {
        i = j;
        if (((Map)localObject1).get("depthDetectType") != null) {
          i = ((Integer)((Map)localObject1).get("depthDetectType")).intValue();
        }
      }
    }
    if (i != DETECT_TYPE)
    {
      DETECT_TYPE = i;
      RGB_DEPTH.reloadModel(DETECT_TYPE);
    }
    localObject1 = localObject2;
    if (k > 0)
    {
      localObject1 = localObject2;
      if (m > 0)
      {
        paramAIInput = paramAIInput.getSizedBytes(new AIInput.DataSize(k, m));
        localObject1 = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject1).copyPixelsFromBuffer(ByteBuffer.wrap(paramAIInput));
      }
    }
    return RGB_DEPTH.getSegmentImpl().detectFrame((Bitmap)localObject1, n, paramAIParam.getRotationMatrix(), paramAIParam.getSurfaceTime());
  }
  
  public String getModuleName()
  {
    return TAG;
  }
  
  public String getModuleType()
  {
    return TAG;
  }
  
  @MustRunOnGLThread
  public boolean init()
  {
    DETECT_TYPE = 0;
    RGB_DEPTH.getSegmentImpl().init();
    return RGB_DEPTH.initGL();
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    RGB_DEPTH.setSoDirOverrideFeatureManager(paramString1);
    RGB_DEPTH.setResourceDirOverrideFeatureManager(paramString2);
    return RGB_DEPTH.init();
  }
  
  public void onModuleUninstall()
  {
    RGB_DEPTH.setUseSmallModel(false);
    RGB_DEPTH.destroy();
  }
  
  public boolean reloadModel()
  {
    return RGB_DEPTH.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_rgb_depth.PTRGBDepth
 * JD-Core Version:    0.7.0.1
 */