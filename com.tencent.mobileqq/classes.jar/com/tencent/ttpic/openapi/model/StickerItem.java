package com.tencent.ttpic.openapi.model;

import android.util.Pair;
import com.tencent.ttpic.filter.juyoujinggame.UKYOScorePositions;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.util.FramePositionsBean;
import com.tencent.ttpic.particle.GPUParticleConfig;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.ttpic.trigger.TriggerTimeUpdater;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StickerItem
{
  public ArrayList<StickerItem.TriggerArea> activateTriggerArea;
  public int activateTriggerCount;
  public int activateTriggerCountOnce;
  public int activateTriggerTotalCount;
  public int activateTriggerType;
  public int[] activeParts;
  public AgeRange ageRange;
  public int[] alignFacePoints;
  public float alpha = 1.0F;
  public boolean alwaysTriggered;
  public int[] anchorPoint;
  public double[] anchorPointAudio;
  public float angle = 0.0F;
  public int aspectMode = 0;
  public String audio;
  public int audioLoopCount;
  public boolean audioNeedAdjust;
  public List<Pair<Float, Double>> audioScaleFactorMap = new ArrayList();
  public int audioTriggerType;
  public StickerItem.ValueRange audioValueRange;
  public int blendMode;
  public int bodyTriggerDirection;
  public int bodyTriggerDistance;
  public int bodyTriggerPoint;
  public double bodyTriggerTimeGap;
  public CharmRange charmRange;
  public String comicLutFilter;
  public int comicOrderMode = 0;
  public String countExternalTriggerWords;
  public int countTriggerType;
  public CpRange cpRange;
  public String crazyFacePath;
  public int delayedTriggedTime = 0;
  public String dexName;
  public String[] disableDetectors;
  public String displacementLutPath;
  public float displacementX;
  public float displacementY;
  public int dx = 0;
  public int dy = 0;
  public int extarTypeHeight;
  public String externalTriggerWords;
  public int extraTypeWidth;
  public int fabbyPart = 0;
  public int fabbyTotalParts = 1;
  public int featureStatType;
  public StickerItem.ValueRange featureStatValueRange;
  public double filterAlphaGradientDuration;
  public int filterOrderMode;
  public float fingerMusicClockTime;
  public boolean followPhoneAngle = false;
  public double frameDuration;
  public FramePositionsBean framePositionsBean;
  public int[] frameSize;
  public int frameType;
  public int frames;
  public GenderRange genderRange;
  public int genderType = 0;
  public GPUParticleConfig gpuParticleConfig;
  public String hairLutName;
  public Integer hairMaskType;
  public int height;
  public double[] hotArea;
  public String id;
  public int isCanDiyPitcureVideo = 0;
  public boolean isFabbyMvItem = false;
  public boolean isStrokeBlur;
  public int lazyLoad;
  public int lockTriggerCountUntilFail;
  public String lutFilterName;
  public int markMode;
  public String maskLut;
  public String maskType;
  public int maxScaledWidth;
  public int minScaledWidth;
  public String name;
  public int needCrop;
  public int needHandRotation;
  public boolean orienting;
  public int originalScaleFactor;
  public ParticleConfig particleConfig;
  public int personID = -1;
  public int playBPM;
  public int playCount;
  public int playFirstSyncMode;
  public int playMode;
  public String pluginFilterPath;
  public PopularRange popularRange;
  public double[] position;
  public UKYOScorePositions positionsUKYO;
  public int preTriggerType;
  public int randomGroupNum;
  public int redPacketEndFrame;
  public int redPacketStartFrame;
  public int relativeScaleType;
  public int renderId = 0;
  public int[] rotateType;
  public float scale = 1.0F;
  public int scaleDirection;
  public int scaleFactor;
  public int[] scalePivots;
  public int snapshotTime = 0;
  public VideoMaterial.ITEM_SOURCE_TYPE sourceType;
  public int stickerType;
  public float[] strokeColor;
  public double strokeGap;
  public int strokeStyle;
  public int strokeType;
  public double strokeWidth;
  public String styleFilter;
  public String subFolder;
  public int support3D;
  public String textureMaterials;
  public int transformType;
  public Transition transition;
  public int triggedTimes = 0;
  public ArrayList<StickerItem.TriggerArea> triggerArea;
  public int triggerFingerIndex;
  public int triggerFrameDurationTime;
  public int triggerFrameStartTime;
  public int triggerHandPoint;
  public int triggerMode;
  public ArrayList<String> triggerState;
  public StickerItem.ValueRange triggerStateRange;
  public TriggerTimeUpdater triggerTimeUpdater;
  private String triggerType;
  public String triggerWords;
  public int type;
  public float[] uvValues;
  public int width;
  public int zIndex;
  public float[] zoomFocusPoint;
  public float zoomHeight;
  public List<Pair<Float, Double>> zoomScale;
  public int zoomType;
  public float zoomWidth;
  
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
  
  public String getTriggerTypeString()
  {
    return this.triggerType;
  }
  
  public boolean isDBTriggered()
  {
    int i = this.audioTriggerType;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isDisplacementMaterial()
  {
    return (this.displacementX > 0.0F) || (this.displacementY > 0.0F);
  }
  
  public void setTriggerType(String paramString)
  {
    this.triggerType = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickerItem{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", triggerType=");
    localStringBuilder.append(this.triggerType);
    localStringBuilder.append(", alwaysTriggered=");
    localStringBuilder.append(this.alwaysTriggered);
    localStringBuilder.append(", playCount=");
    localStringBuilder.append(this.playCount);
    localStringBuilder.append(", frameDuration=");
    localStringBuilder.append(this.frameDuration);
    localStringBuilder.append(", frames=");
    localStringBuilder.append(this.frames);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", position=");
    localStringBuilder.append(Arrays.toString(this.position));
    localStringBuilder.append(", audio='");
    localStringBuilder.append(this.audio);
    localStringBuilder.append('\'');
    localStringBuilder.append(", anchorPoint=");
    localStringBuilder.append(Arrays.toString(this.anchorPoint));
    localStringBuilder.append(", alignFacePoints=");
    localStringBuilder.append(Arrays.toString(this.alignFacePoints));
    localStringBuilder.append(", scalePivots=");
    localStringBuilder.append(Arrays.toString(this.scalePivots));
    localStringBuilder.append(", scaleFactor=");
    localStringBuilder.append(this.scaleFactor);
    localStringBuilder.append(", support3D=");
    localStringBuilder.append(this.support3D);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.StickerItem
 * JD-Core Version:    0.7.0.1
 */