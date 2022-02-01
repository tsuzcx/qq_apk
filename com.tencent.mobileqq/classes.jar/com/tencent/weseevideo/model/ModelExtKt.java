package com.tencent.weseevideo.model;

import com.tencent.weseevideo.model.template.MediaTemplateModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isAutoTemplate", "", "Lcom/tencent/weseevideo/model/MediaModel;", "isLightTemplate", "isMovieTemplate", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class ModelExtKt
{
  public static final boolean isAutoTemplate(@Nullable MediaModel paramMediaModel)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if ((paramMediaModel != null) && (!paramMediaModel.isAutoTemplateEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean isLightTemplate(@Nullable MediaModel paramMediaModel)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if ((paramMediaModel != null) && (!paramMediaModel.isLightTemplateEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean isMovieTemplate(@Nullable MediaModel paramMediaModel)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if ((paramMediaModel != null) && (!paramMediaModel.isMovieTemplateEmpty())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.ModelExtKt
 * JD-Core Version:    0.7.0.1
 */