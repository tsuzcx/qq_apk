package com.tencent.ttpic.trigger;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.TriggerArea;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriggerConfig
{
  public final int BODY_TRIGGER_ANGLE_TOLERANCE = 15;
  public int activateTriggerCount;
  public int activateTriggerCountOnce;
  public int activateTriggerTotalCount;
  public int activateTriggerType;
  public boolean alwaysTriggered;
  public boolean audioNeedAdjust;
  public List<Pair<Float, Double>> audioScaleFactorMap;
  public int audioTriggerType;
  public StickerItem.ValueRange audioValueRange;
  public int bodyTriggerDirection;
  public int bodyTriggerDistance;
  public int bodyTriggerPoint;
  public double bodyTriggerTimeGap;
  public String countExternalTriggerWords;
  public int countTriggerType;
  public String externalTriggerWords;
  public double[] hotArea;
  public int hotAreaEndFrame;
  public int hotAreaStartFrame;
  private int isTriggerTypeInteger = 0;
  public int lockTriggerCountUntilFail;
  public int playCount;
  public int preTriggerType;
  public int randomGroupNum;
  public boolean renderForBitmap;
  private StickerItem stickerItem;
  public ArrayList<StickerItem.TriggerArea> triggerArea;
  public int triggerFrameDurationTime;
  public int triggerFrameStartTime;
  public int triggerHandPoint;
  public String triggerType;
  private Pattern triggerWordsPattern;
  
  public TriggerConfig()
  {
    this.triggerType = String.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value);
  }
  
  public TriggerConfig(FaceMeshItem paramFaceMeshItem)
  {
    this.alwaysTriggered = paramFaceMeshItem.alwaysTriggered;
    this.triggerType = paramFaceMeshItem.getTriggerTypeString();
    this.playCount = paramFaceMeshItem.playCount;
    this.externalTriggerWords = paramFaceMeshItem.externalTriggerWords;
  }
  
  public TriggerConfig(FaceItem paramFaceItem)
  {
    this.preTriggerType = paramFaceItem.preTriggerType;
    this.countTriggerType = paramFaceItem.countTriggerType;
    this.activateTriggerCount = paramFaceItem.activateTriggerCount;
    this.activateTriggerTotalCount = paramFaceItem.activateTriggerTotalCount;
    this.randomGroupNum = paramFaceItem.randomGroupNum;
    this.alwaysTriggered = paramFaceItem.alwaysTriggered;
    this.triggerType = paramFaceItem.getTriggerTypeString();
    this.playCount = paramFaceItem.playCount;
    this.externalTriggerWords = paramFaceItem.externalTriggerWords;
  }
  
  public TriggerConfig(FaceStyleItem paramFaceStyleItem)
  {
    this.triggerType = paramFaceStyleItem.getTriggerTypeString();
    this.alwaysTriggered = paramFaceStyleItem.alwaysTriggered;
    this.playCount = paramFaceStyleItem.playCount;
  }
  
  public TriggerConfig(NodeItemJava paramNodeItemJava)
  {
    this.preTriggerType = paramNodeItemJava.getTriggerTypeInt();
    this.alwaysTriggered = paramNodeItemJava.alwaysTriggered;
    this.triggerType = paramNodeItemJava.triggerType;
    this.countTriggerType = paramNodeItemJava.countTriggerType;
    this.activateTriggerCount = paramNodeItemJava.activateTriggerCount;
    this.activateTriggerTotalCount = paramNodeItemJava.activateTriggerTotalCount;
    this.playCount = paramNodeItemJava.playCount;
    this.externalTriggerWords = paramNodeItemJava.externalTriggerWords;
  }
  
  public TriggerConfig(StickerItem paramStickerItem)
  {
    this.preTriggerType = paramStickerItem.preTriggerType;
    this.countTriggerType = paramStickerItem.countTriggerType;
    this.activateTriggerCount = paramStickerItem.activateTriggerCount;
    this.activateTriggerTotalCount = paramStickerItem.activateTriggerTotalCount;
    this.activateTriggerType = paramStickerItem.activateTriggerType;
    this.lockTriggerCountUntilFail = paramStickerItem.lockTriggerCountUntilFail;
    this.randomGroupNum = paramStickerItem.randomGroupNum;
    this.alwaysTriggered = paramStickerItem.alwaysTriggered;
    this.triggerType = paramStickerItem.getTriggerTypeString();
    this.audioTriggerType = paramStickerItem.audioTriggerType;
    this.audioNeedAdjust = paramStickerItem.audioNeedAdjust;
    this.audioValueRange = paramStickerItem.audioValueRange;
    this.audioScaleFactorMap = paramStickerItem.audioScaleFactorMap;
    this.playCount = paramStickerItem.playCount;
    this.bodyTriggerPoint = paramStickerItem.bodyTriggerPoint;
    this.bodyTriggerDirection = paramStickerItem.bodyTriggerDirection;
    this.bodyTriggerDistance = paramStickerItem.bodyTriggerDistance;
    this.bodyTriggerTimeGap = paramStickerItem.bodyTriggerTimeGap;
    this.triggerFrameStartTime = paramStickerItem.triggerFrameStartTime;
    this.triggerFrameDurationTime = paramStickerItem.triggerFrameDurationTime;
    this.hotAreaStartFrame = paramStickerItem.redPacketStartFrame;
    this.hotAreaEndFrame = paramStickerItem.redPacketEndFrame;
    this.hotArea = paramStickerItem.hotArea;
    this.triggerArea = paramStickerItem.triggerArea;
    this.triggerHandPoint = paramStickerItem.triggerHandPoint;
    this.activateTriggerCountOnce = paramStickerItem.activateTriggerCountOnce;
    this.externalTriggerWords = paramStickerItem.externalTriggerWords;
    this.countExternalTriggerWords = paramStickerItem.countExternalTriggerWords;
    this.stickerItem = paramStickerItem;
  }
  
  public TriggerConfig(CosFun.CosFunItem paramCosFunItem)
  {
    this.triggerType = String.valueOf(paramCosFunItem.getTriggerType());
    this.externalTriggerWords = paramCosFunItem.externalTriggerWords;
  }
  
  private boolean doIntegerCheck(String paramString)
  {
    Pattern localPattern = Pattern.compile("^[-\\+]?[\\d]*$");
    return (!TextUtils.isEmpty(paramString)) && (localPattern.matcher(paramString).matches());
  }
  
  public static int getTriggerTypeInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return PTFaceAttr.PTExpression.FACE_DETECT.value;
  }
  
  public int getBodyTriggerAngle()
  {
    switch (this.bodyTriggerDirection)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 45;
    case 2: 
      return 90;
    case 3: 
      return 135;
    case 4: 
      return 180;
    case 5: 
      return 225;
    case 6: 
      return 270;
    }
    return 315;
  }
  
  public StickerItem getStickerItem()
  {
    return this.stickerItem;
  }
  
  public String getStickerItemId()
  {
    if (this.stickerItem != null) {
      return this.stickerItem.id;
    }
    return null;
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
  
  public String getTriggerTypeString()
  {
    return this.triggerType;
  }
  
  public boolean isDBTriggered()
  {
    return (this.stickerItem != null) && (this.stickerItem.isDBTriggered());
  }
  
  public boolean isRenderForBitmap()
  {
    return this.renderForBitmap;
  }
  
  public boolean isSentenceTriggered(String paramString)
  {
    if (this.triggerWordsPattern == null) {
      return false;
    }
    return this.triggerWordsPattern.matcher(paramString).find();
  }
  
  public boolean isTypeInteger()
  {
    if (this.isTriggerTypeInteger == 0) {
      if (!doIntegerCheck(this.triggerType)) {
        break label35;
      }
    }
    label35:
    for (int i = 1;; i = 2)
    {
      this.isTriggerTypeInteger = i;
      if (this.isTriggerTypeInteger != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    this.renderForBitmap = paramBoolean;
  }
  
  public void setTriggerWords(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.triggerWordsPattern = Pattern.compile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.trigger.TriggerConfig
 * JD-Core Version:    0.7.0.1
 */