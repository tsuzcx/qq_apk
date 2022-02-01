package com.tencent.qcircle.weseevideo.model.template.movie;

import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.model.utils.Utils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.util.ArrayList;
import java.util.List;

public class MovieMediaTemplateModel
{
  private String filePath = "";
  private boolean isAsset;
  private boolean isRedPacketTemplate = false;
  private AIAbilityModel mAiAbility = new AIAbilityModel();
  private CMTime maxDuration;
  private CMTime minDuration;
  private ArrayList<MovieSegmentModel> movieSegmentModels = new ArrayList();
  private ArrayList<MovieStickerTextModel> movieStickerTextModels = new ArrayList();
  private String movieTemplateCateId;
  private String movieTemplateId = "";
  private String movieTemplateType;
  private String segmentInfo;
  
  public void clearAIAbilityModel()
  {
    this.mAiAbility.setAiAbilityType(AIAbilityModel.AIAbilityType.ORDINARY);
    this.mAiAbility.getReplaceBeforeDetectVideos().clear();
    this.mAiAbility.getAfterAiProcessClips().clear();
    this.mAiAbility.setTotalNeedClips(0);
    this.mAiAbility.getAiEffectIndexs().clear();
  }
  
  public void clearSegmentModels()
  {
    ArrayList localArrayList = this.movieSegmentModels;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MovieMediaTemplateModel)paramObject;
      if ((this.isAsset == paramObject.isAsset) && (this.isRedPacketTemplate == paramObject.isRedPacketTemplate) && (Utils.equals(this.filePath, paramObject.filePath)) && (Utils.equals(this.movieTemplateId, paramObject.movieTemplateId)) && (Utils.equals(this.movieTemplateCateId, paramObject.movieTemplateCateId)))
      {
        Object localObject = this.movieSegmentModels;
        ArrayList localArrayList = paramObject.movieSegmentModels;
        if (((localObject == localArrayList) || ((localObject != null) && (((ArrayList)localObject).equals(localArrayList)))) && (Utils.equals(this.segmentInfo, paramObject.segmentInfo)))
        {
          localObject = this.maxDuration;
          if ((localObject != null) && (((CMTime)localObject).equalsTo(paramObject.maxDuration)))
          {
            localObject = this.movieStickerTextModels;
            localArrayList = paramObject.movieStickerTextModels;
            if ((localObject == localArrayList) || ((localObject != null) && (((ArrayList)localObject).equals(localArrayList))))
            {
              localObject = this.minDuration;
              if ((localObject != null) && (((CMTime)localObject).equals(paramObject.minDuration)) && (Utils.equals(this.movieTemplateType, paramObject.movieTemplateType))) {
                return true;
              }
            }
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public AIAbilityModel getAiAbilityModel()
  {
    return this.mAiAbility;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public CMTime getMaxDuration()
  {
    return this.maxDuration;
  }
  
  public CMTime getMinDuration()
  {
    return this.minDuration;
  }
  
  public ArrayList<MovieSegmentModel> getMovieSegmentModels()
  {
    return this.movieSegmentModels;
  }
  
  public ArrayList<MovieStickerTextModel> getMovieStickerTextModels()
  {
    return this.movieStickerTextModels;
  }
  
  public String getMovieTemplateCateId()
  {
    return this.movieTemplateCateId;
  }
  
  public String getMovieTemplateId()
  {
    return this.movieTemplateId;
  }
  
  public String getMovieTemplateType()
  {
    return this.movieTemplateType;
  }
  
  public String getSegmentInfo()
  {
    return this.segmentInfo;
  }
  
  public boolean isAsset()
  {
    return this.isAsset;
  }
  
  public boolean isContainSegments()
  {
    ArrayList localArrayList = this.movieSegmentModels;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
  
  public boolean isEmpty()
  {
    return (TextUtils.isEmpty(this.filePath)) || (!FileUtils.exists(this.filePath));
  }
  
  public boolean isRedPacketTemplate()
  {
    return this.isRedPacketTemplate;
  }
  
  public void setAiAbility(AIAbilityModel paramAIAbilityModel)
  {
    this.mAiAbility = paramAIAbilityModel;
  }
  
  public void setAsset(boolean paramBoolean)
  {
    this.isAsset = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMaxDuration(CMTime paramCMTime)
  {
    this.maxDuration = paramCMTime;
  }
  
  public void setMinDuration(CMTime paramCMTime)
  {
    this.minDuration = paramCMTime;
  }
  
  public void setMovieSegmentModels(ArrayList<MovieSegmentModel> paramArrayList)
  {
    this.movieSegmentModels = paramArrayList;
  }
  
  public void setMovieStickerTextModels(ArrayList<MovieStickerTextModel> paramArrayList)
  {
    this.movieStickerTextModels = paramArrayList;
  }
  
  public void setMovieTemplateCateId(String paramString)
  {
    this.movieTemplateCateId = paramString;
  }
  
  public void setMovieTemplateId(String paramString)
  {
    this.movieTemplateId = paramString;
  }
  
  public void setMovieTemplateType(String paramString)
  {
    this.movieTemplateType = paramString;
  }
  
  public void setRedPacketTemplate(boolean paramBoolean)
  {
    this.isRedPacketTemplate = paramBoolean;
  }
  
  public void setSegmentInfo(String paramString)
  {
    this.segmentInfo = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MovieMediaTemplateModel{isAsset=");
    localStringBuilder.append(this.isAsset);
    localStringBuilder.append(", filePath='");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", movieTemplateId='");
    localStringBuilder.append(this.movieTemplateId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", movieTemplateCateId='");
    localStringBuilder.append(this.movieTemplateCateId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", movieSegmentModels=");
    localStringBuilder.append(this.movieSegmentModels);
    localStringBuilder.append(", segmentInfo='");
    localStringBuilder.append(this.segmentInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", maxDuration=");
    localStringBuilder.append(this.maxDuration);
    localStringBuilder.append(", isRedPacketTemplate=");
    localStringBuilder.append(this.isRedPacketTemplate);
    localStringBuilder.append(", movieStickerTextModels=");
    localStringBuilder.append(this.movieStickerTextModels);
    localStringBuilder.append(", movieTemplateType= ");
    localStringBuilder.append(this.movieTemplateType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.movie.MovieMediaTemplateModel
 * JD-Core Version:    0.7.0.1
 */