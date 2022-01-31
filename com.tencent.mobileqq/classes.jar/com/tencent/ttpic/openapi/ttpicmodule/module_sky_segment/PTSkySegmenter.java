package com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIInput.DataSize;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.ttpicmodule.SkySegmentImpl;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.nio.ByteBuffer;

public class PTSkySegmenter
  extends IDetect
{
  public static final SkySegmentInitializer SKY_SEGMENT = new SkySegmentInitializer();
  public static final String TAG = "PTSkySegmenter";
  
  public static void setUseSmallModel(boolean paramBoolean)
  {
    SKY_SEGMENT.setUseSmallModel(paramBoolean);
  }
  
  public void clear()
  {
    SKY_SEGMENT.getSegmentImpl().destroy();
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    Object localObject2 = null;
    if ((paramAIInput == null) || (paramAIInput.getInput("frame") == null)) {
      return null;
    }
    int i = paramAIParam.getBytesDataSizeWidth(getModuleType()).intValue();
    int j = paramAIParam.getBytesDataSizeHeight(getModuleType()).intValue();
    int k = paramAIParam.getRotation();
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (j > 0)
      {
        paramAIInput = paramAIInput.getSizedBytes(new AIInput.DataSize(i, j));
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject1).copyPixelsFromBuffer(ByteBuffer.wrap(paramAIInput));
      }
    }
    return SKY_SEGMENT.getSegmentImpl().detectFrame((Bitmap)localObject1, k, paramAIParam.getRotationMatrix(), paramAIParam.getSurfaceTime());
  }
  
  public String getModuleName()
  {
    return "PTSkySegmenter";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.SKY_SEGMENT.value;
  }
  
  @MustRunOnGLThread
  public boolean init()
  {
    SKY_SEGMENT.getSegmentImpl().init();
    return SKY_SEGMENT.initGL();
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    SKY_SEGMENT.setSoDirOverrideFeatureManager(paramString1);
    SKY_SEGMENT.setResourceDirOverrideFeatureManager(paramString2);
    return SKY_SEGMENT.init();
  }
  
  public void onModuleUninstall()
  {
    SKY_SEGMENT.setUseSmallModel(false);
    SKY_SEGMENT.destroy();
  }
  
  public boolean reInit()
  {
    return SKY_SEGMENT.init();
  }
  
  public boolean reloadModel()
  {
    return SKY_SEGMENT.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter
 * JD-Core Version:    0.7.0.1
 */