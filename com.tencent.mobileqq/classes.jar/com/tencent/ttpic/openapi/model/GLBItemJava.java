package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.util.ArrayList;
import java.util.List;

public class GLBItemJava
{
  public List<AnimationItem> animationList = new ArrayList();
  public float blendShapeAdjustAlpha = 0.7F;
  public BloomParam bloom;
  public CharmRange charmRange;
  public List<DynamicBoneItem> dynamicBoneItems = new ArrayList();
  public int enableSSAO;
  public List<EyeNodeItem> eyeNodeList = new ArrayList();
  public int[] flip = { 0, 0, 0 };
  public String folder;
  public int iblIntensity;
  public String iblPath;
  public int iblRotation;
  public LightItem lightItem = new LightItem();
  public List<NodeItemJava> nodeList = new ArrayList();
  public int order;
  public String path;
  public int positionType;
  public float[] rotate = { 0.0F, 0.0F, 0.0F };
  public int[] rotateType = { 1, 1, 1 };
  public float[] scale = { 1.0F, 1.0F, 1.0F };
  public float[] translate = { 0.0F, 0.0F, 0.0F };
  public TriggerCtrlItem triggerCtrlItem;
  
  public int isHit()
  {
    if (this.charmRange == null) {
      return 0;
    }
    if ((this.triggerCtrlItem.isTriggered()) && (this.charmRange.isHit())) {
      return 1;
    }
    return 2;
  }
  
  public void reset()
  {
    this.triggerCtrlItem.reset();
  }
  
  public void updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.GLBItemJava
 * JD-Core Version:    0.7.0.1
 */