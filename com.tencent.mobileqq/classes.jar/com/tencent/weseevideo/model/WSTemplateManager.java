package com.tencent.weseevideo.model;

import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.weseevideo.model.template.movie.MovieMediaTemplateModel;
import com.tencent.weseevideo.model.utils.FileUtils;
import java.io.File;

public class WSTemplateManager
{
  private static void updateAutoTemplate(MediaModel paramMediaModel, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramMediaModel == null) {
      return;
    }
    MediaTemplateModel localMediaTemplateModel = paramMediaModel.getMediaTemplateModel();
    if ((FileUtils.exists(paramString1)) && (FileUtils.exists(paramString1 + File.separator + paramString2)))
    {
      AutomaticMediaTemplateModel localAutomaticMediaTemplateModel = new AutomaticMediaTemplateModel();
      localMediaTemplateModel.setAutomaticMediaTemplateModel(localAutomaticMediaTemplateModel);
      localAutomaticMediaTemplateModel.setTemplateDir(paramString1);
      localAutomaticMediaTemplateModel.setTemplateFileName(paramString2);
      localAutomaticMediaTemplateModel.setSwitchToTemplateByUser(paramBoolean);
      paramMediaModel.setMediaTemplateModel(localMediaTemplateModel);
      return;
    }
    paramMediaModel = new AutomaticMediaTemplateModel();
    paramMediaModel.clearAllRhythmCache();
    localMediaTemplateModel.setAutomaticMediaTemplateModel(paramMediaModel);
    localMediaTemplateModel.setMovieMediaTemplateModel(new MovieMediaTemplateModel());
  }
  
  private static void updateMovieTemplate(MediaModel paramMediaModel, String paramString, boolean paramBoolean)
  {
    MediaTemplateModel localMediaTemplateModel = paramMediaModel.getMediaTemplateModel();
    paramString = FileUtils.getFilePathBySuffix(paramString, ".pag");
    if (FileUtils.exists(paramString))
    {
      MovieMediaTemplateModel localMovieMediaTemplateModel = new MovieMediaTemplateModel();
      localMediaTemplateModel.setMovieMediaTemplateModel(localMovieMediaTemplateModel);
      localMovieMediaTemplateModel.setFilePath(paramString);
      paramMediaModel.setMediaTemplateModel(localMediaTemplateModel);
      return;
    }
    localMediaTemplateModel.setMovieMediaTemplateModel(new MovieMediaTemplateModel());
  }
  
  public static void updateTemplate(MediaModel paramMediaModel, int paramInt, String paramString, boolean paramBoolean, String... paramVarArgs)
  {
    if (paramInt == 1) {
      updateMovieTemplate(paramMediaModel, paramString, paramBoolean);
    }
    while ((paramInt != 2) || (paramVarArgs.length <= 0)) {
      return;
    }
    updateAutoTemplate(paramMediaModel, paramString, paramVarArgs[0], paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.WSTemplateManager
 * JD-Core Version:    0.7.0.1
 */