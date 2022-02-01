package com.tencent.qcircle.weseevideo.model.template.auto;

import android.text.TextUtils;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import java.util.ArrayList;
import java.util.List;

public class AutomaticMediaTemplateModel
{
  public static final String SCALE_MODE_ASPECT_FILL = "aspectFill";
  public static final String SCALE_MODE_ASPECT_FIT = "aspectFit";
  public static final String TEMPLATE_ASSET_PATH = "pag";
  private AEFrameModel aeFrameModel;
  private String assetDir = "";
  private String imagePagAssetDir = "";
  private boolean isRhythmTemplate;
  private boolean isSwitchToTemplateByUser;
  private ArrayList<TAVTransitionAutomaticEffect> mTransitionEffects;
  private int randomIndex;
  private int randomType;
  private String rhythmEffectID;
  private List<Integer> rhythmSecondEffectIndices = new ArrayList();
  private List<MovieSegmentModel> rhythmSegmentModels = new ArrayList();
  private String templateDir = "";
  private String templateFileName = "";
  
  public void clearAllRhythmCache()
  {
    setRhythmTemplate(false);
    setRhythmEffectID(null);
    clearSegmentModels();
    clearTransitionEffects();
    clearSecondEffectIndices();
    setRandomIndex(0);
    setRandomType(0);
  }
  
  public void clearSecondEffectIndices()
  {
    List localList = this.rhythmSecondEffectIndices;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void clearSegmentModels()
  {
    List localList = this.rhythmSegmentModels;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void clearTransitionEffects()
  {
    ArrayList localArrayList = this.mTransitionEffects;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public AEFrameModel getAEFrameModel()
  {
    return this.aeFrameModel;
  }
  
  public String getAssetDir()
  {
    return this.assetDir;
  }
  
  public String getImagePagAssetDir()
  {
    return this.imagePagAssetDir;
  }
  
  public int getRandomIndex()
  {
    return this.randomIndex;
  }
  
  public int getRandomType()
  {
    return this.randomType;
  }
  
  public String getRhythmEffectID()
  {
    return this.rhythmEffectID;
  }
  
  public List<Integer> getRhythmSecondEffectIndices()
  {
    return this.rhythmSecondEffectIndices;
  }
  
  public List<MovieSegmentModel> getRhythmSegmentModels()
  {
    return this.rhythmSegmentModels;
  }
  
  public String getTemplateDir()
  {
    return this.templateDir;
  }
  
  public String getTemplateFileName()
  {
    return this.templateFileName;
  }
  
  public ArrayList<TAVTransitionAutomaticEffect> getTransitionEffects()
  {
    return this.mTransitionEffects;
  }
  
  public boolean isContainSegments()
  {
    List localList = this.rhythmSegmentModels;
    return (localList != null) && (!localList.isEmpty());
  }
  
  public boolean isEmpty()
  {
    return (TextUtils.isEmpty(this.assetDir)) && (TextUtils.isEmpty(this.templateDir)) && (TextUtils.isEmpty(this.templateFileName));
  }
  
  public boolean isRhythmTemplate()
  {
    return this.isRhythmTemplate;
  }
  
  public boolean isSwitchToTemplateByUser()
  {
    return this.isSwitchToTemplateByUser;
  }
  
  public void setAEFrameModel(AEFrameModel paramAEFrameModel)
  {
    this.aeFrameModel = paramAEFrameModel;
  }
  
  public void setAssetDir(String paramString)
  {
    this.assetDir = paramString;
  }
  
  public void setImagePagAssetDir(String paramString)
  {
    this.imagePagAssetDir = paramString;
  }
  
  public void setRandomIndex(int paramInt)
  {
    this.randomIndex = paramInt;
  }
  
  public void setRandomType(int paramInt)
  {
    this.randomType = paramInt;
  }
  
  public void setRhythmEffectID(String paramString)
  {
    this.rhythmEffectID = paramString;
  }
  
  public void setRhythmSecondEffectIndices(List<Integer> paramList)
  {
    this.rhythmSecondEffectIndices = paramList;
  }
  
  public void setRhythmSegmentModels(List<MovieSegmentModel> paramList)
  {
    this.rhythmSegmentModels = paramList;
  }
  
  public void setRhythmTemplate(boolean paramBoolean)
  {
    this.isRhythmTemplate = paramBoolean;
  }
  
  public void setSwitchToTemplateByUser(boolean paramBoolean)
  {
    this.isSwitchToTemplateByUser = paramBoolean;
  }
  
  public void setTemplateDir(String paramString)
  {
    this.templateDir = paramString;
  }
  
  public void setTemplateFileName(String paramString)
  {
    this.templateFileName = paramString;
  }
  
  public void setTransitionEffects(ArrayList<TAVTransitionAutomaticEffect> paramArrayList)
  {
    this.mTransitionEffects = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel
 * JD-Core Version:    0.7.0.1
 */