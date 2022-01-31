package com.tencent.ttpic.openapi.model;

import com.google.android.filament.Engine;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeItemJava
{
  public String EXTENSION_JPG = "jpg";
  public String EXTENSION_PNG = "png";
  public int activateTriggerCount = 0;
  public int activateTriggerTotalCount = 0;
  public int activateTriggerType = 0;
  public int alwaysTriggered = 1;
  public String content;
  public int countTriggerType;
  public List<AnimojiExpressionJava> expressionConfigList = new ArrayList();
  public Map<String, Integer> expressionOrderList = new HashMap();
  public String externalTriggerWords;
  public int frameDuration = 83;
  public int frames = 1;
  public String material;
  public String modelId;
  public String name;
  public int needFaceMesh = 0;
  public boolean needShow = true;
  public int playCount = 0;
  public int rotateRequied = 0;
  private boolean show = true;
  public TriggerCtrlItem triggerCtrlItem;
  public String triggerType;
  
  public void destroy(Engine paramEngine) {}
  
  public boolean getHide()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.triggerCtrlItem.isTriggered())
    {
      bool1 = bool2;
      if (!this.needShow) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getTexture(String paramString)
  {
    if (!this.triggerCtrlItem.isTriggered()) {
      paramString = null;
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = paramString + File.separator + this.modelId + File.separator + this.content + File.separator + this.content + "_" + this.triggerCtrlItem.getFrameIndex() + ".";
      str1 = str2 + this.EXTENSION_PNG;
      paramString = str1;
    } while (new File(str1).exists());
    return str2 + this.EXTENSION_JPG;
  }
  
  public int getTriggerTypeInt()
  {
    try
    {
      int i = Integer.parseInt(this.triggerType);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return PTFaceAttr.PTExpression.FACE_DETECT.value;
  }
  
  public void reset() {}
  
  public void updateActionTriggered(PTDetectInfo paramPTDetectInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.NodeItemJava
 * JD-Core Version:    0.7.0.1
 */