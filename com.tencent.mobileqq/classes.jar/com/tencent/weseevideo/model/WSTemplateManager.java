package com.tencent.weseevideo.model;

import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.weseevideo.model.template.movie.MovieMediaTemplateModel;
import com.tencent.weseevideo.model.utils.FileUtils;
import java.io.File;

public class WSTemplateManager
{
  private static void clearMediaTemplateModel(MediaModel paramMediaModel)
  {
    paramMediaModel = paramMediaModel.getMediaTemplateModel();
    Object localObject = new LightMediaTemplateModel();
    ((LightMediaTemplateModel)localObject).clearSegmentModels();
    paramMediaModel.setLightMediaTemplateModel((LightMediaTemplateModel)localObject);
    localObject = new AutomaticMediaTemplateModel();
    ((AutomaticMediaTemplateModel)localObject).clearAllRhythmCache();
    paramMediaModel.setAutomaticMediaTemplateModel((AutomaticMediaTemplateModel)localObject);
    paramMediaModel.setMovieMediaTemplateModel(new MovieMediaTemplateModel());
  }
  
  private static void updateAutoTemplate(MediaModel paramMediaModel, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramMediaModel == null) {}
    MediaTemplateModel localMediaTemplateModel;
    do
    {
      return;
      clearMediaTemplateModel(paramMediaModel);
      localMediaTemplateModel = paramMediaModel.getMediaTemplateModel();
    } while ((!FileUtils.exists(paramString1)) || (!FileUtils.exists(paramString1 + File.separator + paramString2)));
    AutomaticMediaTemplateModel localAutomaticMediaTemplateModel = new AutomaticMediaTemplateModel();
    localMediaTemplateModel.setAutomaticMediaTemplateModel(localAutomaticMediaTemplateModel);
    localAutomaticMediaTemplateModel.setTemplateDir(paramString1);
    localAutomaticMediaTemplateModel.setTemplateFileName(paramString2);
    if (!"1".equals(paramMediaModel.getMediaEffectModel().getParam("FRAME_PARAMS_KEY_IS_ON"))) {
      localAutomaticMediaTemplateModel.setImagePagAssetDir("pag");
    }
    localAutomaticMediaTemplateModel.setSwitchToTemplateByUser(paramBoolean);
  }
  
  private static void updateLightTemplate(MediaModel paramMediaModel, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramMediaModel == null) {}
    do
    {
      return;
      clearMediaTemplateModel(paramMediaModel);
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      paramString2 = new File(paramString1, paramString2);
    } while ((!FileUtils.exists(paramString1)) || (!FileUtils.exists(paramString2.getAbsolutePath())));
    paramString1 = new LightMediaTemplateModel();
    paramMediaModel.setLightMediaTemplateModel(paramString1);
    paramString1.setFilePath(paramString2.getAbsolutePath());
    paramString1.setSwitchByUser(paramBoolean);
  }
  
  private static void updateMovieTemplate(MediaModel paramMediaModel, String paramString, boolean paramBoolean)
  {
    if (paramMediaModel == null) {}
    do
    {
      return;
      clearMediaTemplateModel(paramMediaModel);
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      paramString = FileUtils.getFilePathBySuffix(paramString, ".pag");
    } while (!FileUtils.exists(paramString));
    MovieMediaTemplateModel localMovieMediaTemplateModel = new MovieMediaTemplateModel();
    paramMediaModel.setMovieMediaTemplateModel(localMovieMediaTemplateModel);
    localMovieMediaTemplateModel.setFilePath(paramString);
  }
  
  public static void updateTemplate(MediaModel paramMediaModel, int paramInt, String paramString, boolean paramBoolean, String... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        updateMovieTemplate(paramMediaModel, paramString, paramBoolean);
        return;
      } while (paramVarArgs.length <= 0);
      updateAutoTemplate(paramMediaModel, paramString, paramVarArgs[0], paramBoolean);
      return;
    } while (paramVarArgs.length <= 0);
    updateLightTemplate(paramMediaModel, paramString, paramVarArgs[0], paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.WSTemplateManager
 * JD-Core Version:    0.7.0.1
 */