package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeItemJava
{
  private static final String EXTENSION_JPG = "jpg";
  private static final String EXTENSION_PNG = "png";
  public int activateTriggerCount = 0;
  public int activateTriggerTotalCount = 0;
  public int activateTriggerType = 0;
  public boolean alwaysTriggered;
  public String content;
  public int countTriggerType;
  public boolean enableExpressionConfigRemap;
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
  public TriggerCtrlItem triggerCtrlItem;
  public ArrayList<String> triggerState;
  public String triggerType;
  
  public boolean getHide()
  {
    if (this.triggerCtrlItem.isTriggered()) {
      return this.needShow ^ true;
    }
    return false;
  }
  
  public String getTexture(String paramString)
  {
    if (!this.triggerCtrlItem.isTriggered()) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.modelId);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.content);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.content);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.triggerCtrlItem.getFrameIndex());
    ((StringBuilder)localObject).append(".");
    String str = ((StringBuilder)localObject).toString();
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append("png");
    localObject = paramString.toString();
    paramString = (String)localObject;
    if (!new File((String)localObject).exists())
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append("jpg");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public int getTriggerTypeInt()
  {
    try
    {
      int i = Integer.parseInt(this.triggerType);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      break label10;
    }
    return PTFaceAttr.PTExpression.FACE_DETECT.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.NodeItemJava
 * JD-Core Version:    0.7.0.1
 */