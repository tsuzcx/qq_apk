package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriggerConfig
{
  public final int BODY_TRIGGER_ANGLE_TOLERANCE = 15;
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public boolean alwaysTriggered;
  public boolean audioNeedAdjust;
  public List<Pair<Float, Double>> audioScaleFactorMap;
  public int audioTriggerType;
  public StickerItem.ValueRange audioValueRange;
  public int bodyTriggerDirection;
  public int bodyTriggerDistance;
  public int bodyTriggerPoint;
  public double bodyTriggerTimeGap;
  public int countTriggerType;
  public double[] hotArea;
  public int hotAreaEndFrame;
  public int hotAreaStartFrame;
  public int lockTriggerCountUntilFail;
  public int playCount;
  public int preTriggerType;
  public int randomGroupNum;
  public boolean renderForBitmap;
  private StickerItem stickerItem;
  public int triggerFrameDurationTime;
  public int triggerFrameStartTime;
  private String triggerType;
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
  }
  
  public TriggerConfig(FaceStyleItem paramFaceStyleItem)
  {
    this.triggerType = paramFaceStyleItem.getTriggerTypeString();
  }
  
  public TriggerConfig(NodeItemJava paramNodeItemJava)
  {
    this.preTriggerType = paramNodeItemJava.getTriggerTypeInt();
    if (paramNodeItemJava.alwaysTriggered == 1) {}
    for (;;)
    {
      this.alwaysTriggered = bool;
      this.triggerType = paramNodeItemJava.triggerType;
      this.countTriggerType = paramNodeItemJava.countTriggerType;
      this.activateTriggerCount = paramNodeItemJava.activateTriggerCount;
      this.activateTriggerTotalCount = paramNodeItemJava.activateTriggerTotalCount;
      this.playCount = paramNodeItemJava.playCount;
      return;
      bool = false;
    }
  }
  
  public TriggerConfig(StickerItem paramStickerItem)
  {
    this.preTriggerType = paramStickerItem.preTriggerType;
    this.countTriggerType = paramStickerItem.countTriggerType;
    this.activateTriggerCount = paramStickerItem.activateTriggerCount;
    this.activateTriggerTotalCount = paramStickerItem.activateTriggerTotalCount;
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
    this.stickerItem = paramStickerItem;
  }
  
  public TriggerConfig(CosFun.CosFunItem paramCosFunItem)
  {
    this.triggerType = String.valueOf(paramCosFunItem.getTriggerType());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.TriggerConfig
 * JD-Core Version:    0.7.0.1
 */