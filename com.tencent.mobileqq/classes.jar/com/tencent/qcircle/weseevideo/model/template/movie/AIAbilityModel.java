package com.tencent.qcircle.weseevideo.model.template.movie;

import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import java.util.ArrayList;
import java.util.List;

public class AIAbilityModel
{
  public static final String AI_KEY = "effectType";
  public static final String BACKGROUND_DETECT_VALUE = "portraitDetect";
  private AIAbilityModel.AIAbilityType aiAbilityType = AIAbilityModel.AIAbilityType.ORDINARY;
  private List<Integer> aiEffectIndexs = new ArrayList();
  private int mTotalNeedClips;
  private List<MediaClipModel> replaceBeforeDetectVideos = new ArrayList();
  private List<MediaClipModel> videos = new ArrayList();
  
  public List<MediaClipModel> getAfterAiProcessClips()
  {
    return this.videos;
  }
  
  public AIAbilityModel.AIAbilityType getAiAbilityType()
  {
    return this.aiAbilityType;
  }
  
  public List<Integer> getAiEffectIndexs()
  {
    return this.aiEffectIndexs;
  }
  
  public List<MediaClipModel> getReplaceBeforeDetectVideos()
  {
    return this.replaceBeforeDetectVideos;
  }
  
  public int getTotalNeedClips()
  {
    return this.mTotalNeedClips;
  }
  
  public void setAiAbilityType(AIAbilityModel.AIAbilityType paramAIAbilityType)
  {
    this.aiAbilityType = paramAIAbilityType;
  }
  
  public void setTotalNeedClips(int paramInt)
  {
    this.mTotalNeedClips = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel
 * JD-Core Version:    0.7.0.1
 */