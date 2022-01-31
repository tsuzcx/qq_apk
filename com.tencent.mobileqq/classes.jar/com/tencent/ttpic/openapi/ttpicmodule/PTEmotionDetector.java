package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.PTEmotionAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.util.youtu.EmotionDetector;
import java.util.Map;
import java.util.Set;

public class PTEmotionDetector
  extends IDetect
{
  public static final EmotionDetectorInitliazer EMOTION_DETECTOR = new EmotionDetectorInitliazer();
  public static final String TAG = "PTEmotionDetector";
  private PTEmotionAttr mPTEmotionAttr;
  
  public void clear()
  {
    EMOTION_DETECTOR.destroy();
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if (!EMOTION_DETECTOR.isFunctionReady()) {
      return null;
    }
    int i = paramAIParam.getWidth();
    int j = paramAIParam.getHeight();
    if (paramAIParam.getScale(getModuleType()) != null) {}
    for (Float localFloat = paramAIParam.getScale(getModuleType());; localFloat = Float.valueOf(1.0F))
    {
      paramAIParam = (PTFaceAttr)paramAIParam.getAIAttr().getRealtimeData(AEDetectorType.FACE.value);
      if (paramAIParam == null) {
        return EmotionUtil.getDefaultEmotionAttr();
      }
      this.mPTEmotionAttr = ((PTEmotionAttr)EMOTION_DETECTOR.getEmotionDetector().detectSmile(paramAIInput.getBytes(localFloat.floatValue()), (int)(i * localFloat.floatValue()), (int)(j * localFloat.floatValue()), EmotionUtil.genEmotionInfo(paramAIParam, localFloat.floatValue())));
      return this.mPTEmotionAttr;
    }
  }
  
  public String getModuleName()
  {
    return "PTEmotionDetector";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.EMOTION.value;
  }
  
  public boolean init()
  {
    return EMOTION_DETECTOR.init();
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    EMOTION_DETECTOR.setSoDirOverrideFeatureManager(paramString1);
    EMOTION_DETECTOR.setResourceDirOverrideFeatureManager(paramString2);
    return EMOTION_DETECTOR.init();
  }
  
  public void onModuleUninstall() {}
  
  public boolean reInit()
  {
    return EMOTION_DETECTOR.init();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr)
  {
    if (this.mPTEmotionAttr == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramAIAttr = (PTFaceAttr)paramAIAttr.getRealtimeData(AEDetectorType.FACE.value);
      } while ((paramAIAttr == null) || (!this.mPTEmotionAttr.isSmile()));
      Set localSet = paramAIAttr.getTriggeredExpression();
      localSet.add(Integer.valueOf(PTFaceAttr.PTExpression.SMILE.value));
      paramAIAttr.setTriggeredExpression(localSet);
      l = System.currentTimeMillis();
      paramAIAttr = (FaceActionCounter)paramAIAttr.getFaceActionCounter().get(Integer.valueOf(PTFaceAttr.PTExpression.SMILE.value));
    } while ((paramAIAttr == null) || (l - paramAIAttr.updateTime <= 1000L));
    paramAIAttr.count += 1;
    paramAIAttr.updateTime = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector
 * JD-Core Version:    0.7.0.1
 */