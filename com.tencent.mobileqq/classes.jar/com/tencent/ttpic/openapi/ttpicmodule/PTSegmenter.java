package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.SegmentImpl;
import com.tencent.ttpic.util.MustRunOnGLThread;

public class PTSegmenter
  extends IDetect
{
  public static final SegmentInitializer SEGMENT = new SegmentInitializer();
  public static final String TAG = PTSegmenter.class.getSimpleName();
  
  public static void setUseSmallModel(boolean paramBoolean)
  {
    SEGMENT.setUseSmallModel(paramBoolean);
  }
  
  public void clear()
  {
    SEGMENT.destroy();
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if (!SEGMENT.isFunctionReady()) {}
    while ((paramAIInput == null) || (paramAIInput.getInput("frame") == null)) {
      return null;
    }
    return SEGMENT.getSegmentImpl().detectFrame((Frame)paramAIInput.getInput("frame"), paramAIParam.getRotation(), true);
  }
  
  public String getModuleName()
  {
    return TAG;
  }
  
  public String getModuleType()
  {
    return AEDetectorType.SEGMENT.value;
  }
  
  @MustRunOnGLThread
  public boolean init()
  {
    return SEGMENT.initGL();
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    SEGMENT.setSoDirOverrideFeatureManager(paramString1);
    SEGMENT.setResourceDirOverrideFeatureManager(paramString2);
    return SEGMENT.init();
  }
  
  public void onModuleUninstall()
  {
    SEGMENT.setUseSmallModel(false);
  }
  
  public boolean reInit()
  {
    return SEGMENT.init();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter
 * JD-Core Version:    0.7.0.1
 */