package com.tencent.ttpic.model;

import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.util.Arrays;

public class StickerItem
{
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public AgeRange ageRange;
  public int[] alignFacePoints;
  public boolean alwaysTriggered;
  public int[] anchorPoint;
  public int aspectMode = 0;
  public String audio;
  public int blendMode;
  public CharmRange charmRange;
  public int countTriggerType;
  public CpRange cpRange;
  public int fabbyPart = 0;
  public int fabbyTotalParts = 1;
  public int featureStatType;
  public FeatureStatValueRange featureStatValueRange;
  public double frameDuration;
  public int frameType;
  public int frames;
  public GenderRange genderRange;
  public int height;
  public String id;
  public boolean isFabbyMvItem = false;
  public int markMode;
  public String name;
  public int personID = -1;
  public int playCount;
  public PopularRange popularRange;
  public double[] position;
  public int preTriggerType;
  public int scaleFactor;
  public int[] scalePivots;
  public VideoMaterialUtil.ITEM_SOURCE_TYPE sourceType;
  public int stickerType;
  public String subFolder;
  public int support3D;
  public int triggerType;
  public int type;
  public int width;
  public WMGroup wmGroup;
  
  public String toString()
  {
    return "StickerItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", type=" + this.type + ", triggerType=" + this.triggerType + ", alwaysTriggered=" + this.alwaysTriggered + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + ", anchorPoint=" + Arrays.toString(this.anchorPoint) + ", alignFacePoints=" + Arrays.toString(this.alignFacePoints) + ", scalePivots=" + Arrays.toString(this.scalePivots) + ", scaleFactor=" + this.scaleFactor + ", support3D=" + this.support3D + '}';
  }
  
  public static class FeatureStatValueRange
  {
    public double max;
    public double min;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.StickerItem
 * JD-Core Version:    0.7.0.1
 */