package com.tencent.qcircle.weseevideo.model;

import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieMediaTemplateModel;
import java.io.File;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/WSTemplateManager;", "", "()V", "AE_FRAME_TEMPLATE_JSON", "", "clearMediaTemplateModel", "", "mediaModel", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "updateAutoTemplate", "templateDir", "templateJsonName", "isSwitchToTemplateByUser", "", "updateLightTemplate", "updateMovieTemplate", "updateTemplate", "type", "", "args", "", "(Lcom/tencent/qcircle/weseevideo/model/MediaModel;ILjava/lang/String;Z[Ljava/lang/String;)V", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSTemplateManager
{
  private static final String AE_FRAME_TEMPLATE_JSON = "template.json";
  public static final WSTemplateManager INSTANCE = new WSTemplateManager();
  
  @JvmStatic
  public static final void clearMediaTemplateModel(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    paramMediaModel = paramMediaModel.getMediaTemplateModel();
    paramMediaModel.setLightMediaTemplateModel(new LightMediaTemplateModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 32767, null));
    paramMediaModel.setAutomaticMediaTemplateModel(new AutomaticMediaTemplateModel());
    paramMediaModel.setMovieMediaTemplateModel(new MovieMediaTemplateModel());
  }
  
  private final void updateAutoTemplate(MediaModel paramMediaModel, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramMediaModel == null) {
      return;
    }
    clearMediaTemplateModel(paramMediaModel);
    MediaTemplateModel localMediaTemplateModel = paramMediaModel.getMediaTemplateModel();
    Object localObject1 = new File(paramString1, paramString2);
    Object localObject2 = new File(paramString1, "template.json");
    if ((com.tencent.qcircle.weseevideo.model.utils.FileUtils.exists(paramString1)) && (com.tencent.qcircle.weseevideo.model.utils.FileUtils.exists(((File)localObject1).getAbsolutePath())))
    {
      localObject1 = new AutomaticMediaTemplateModel();
      if ((ModelExtKt.isImageMode(paramMediaModel)) && (com.tencent.qcircle.weseevideo.model.utils.FileUtils.exists(paramString1)) && (((File)localObject2).exists()))
      {
        localObject2 = org.light.utils.FileUtils.readFile(((File)localObject2).getAbsolutePath());
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "org.light.utils.FileUtil…emplateJson.absolutePath)");
        localObject2 = (AEFrameModel)GsonUtils.json2Obj(new String((byte[])localObject2, Charsets.UTF_8), (Type)AEFrameModel.class);
        if (localObject2 != null) {
          ((AEFrameModel)localObject2).setFrameColor(paramMediaModel.getMediaEffectModel().getIntParam("FRAME_PARAMS_KEY_COLOR"));
        }
        ((AutomaticMediaTemplateModel)localObject1).setAEFrameModel((AEFrameModel)localObject2);
      }
      ((AutomaticMediaTemplateModel)localObject1).setTemplateDir(paramString1);
      ((AutomaticMediaTemplateModel)localObject1).setTemplateFileName(paramString2);
      if ((Intrinsics.areEqual("1", paramMediaModel.getMediaEffectModel().getParam("FRAME_PARAMS_KEY_IS_ON")) ^ true)) {
        ((AutomaticMediaTemplateModel)localObject1).setImagePagAssetDir("pag");
      }
      ((AutomaticMediaTemplateModel)localObject1).setSwitchToTemplateByUser(paramBoolean);
      localMediaTemplateModel.setAutomaticMediaTemplateModel((AutomaticMediaTemplateModel)localObject1);
    }
  }
  
  private final void updateLightTemplate(MediaModel paramMediaModel, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramMediaModel == null) {
      return;
    }
    clearMediaTemplateModel(paramMediaModel);
    paramMediaModel = paramMediaModel.getMediaTemplateModel();
    paramString2 = new File(paramString1, paramString2);
    if ((com.tencent.qcircle.weseevideo.model.utils.FileUtils.exists(paramString1)) && (com.tencent.qcircle.weseevideo.model.utils.FileUtils.exists(paramString2.getAbsolutePath())))
    {
      paramString1 = new LightMediaTemplateModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 32767, null);
      paramMediaModel.setLightMediaTemplateModel(paramString1);
      paramString1.setFilePath(paramString2.getAbsolutePath());
      paramString1.setSwitchByUser(paramBoolean);
    }
  }
  
  private final void updateMovieTemplate(MediaModel paramMediaModel, String paramString, boolean paramBoolean)
  {
    if (paramMediaModel == null) {
      return;
    }
    clearMediaTemplateModel(paramMediaModel);
    paramMediaModel = paramMediaModel.getMediaTemplateModel();
    paramString = com.tencent.qcircle.weseevideo.model.utils.FileUtils.getFilePathBySuffix(paramString, ".pag");
    if (com.tencent.qcircle.weseevideo.model.utils.FileUtils.exists(paramString))
    {
      MovieMediaTemplateModel localMovieMediaTemplateModel = new MovieMediaTemplateModel();
      paramMediaModel.setMovieMediaTemplateModel(localMovieMediaTemplateModel);
      localMovieMediaTemplateModel.setFilePath(paramString);
    }
  }
  
  @JvmStatic
  public static final void updateTemplate(@Nullable MediaModel paramMediaModel, int paramInt, @NotNull String paramString, boolean paramBoolean, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateDir");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return;
        }
        if (paramVarArgs.length == 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((paramInt ^ 0x1) != 0) {
          INSTANCE.updateLightTemplate(paramMediaModel, paramString, paramVarArgs[0], paramBoolean);
        }
      }
      else
      {
        if (paramVarArgs.length == 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((paramInt ^ 0x1) != 0) {
          INSTANCE.updateAutoTemplate(paramMediaModel, paramString, paramVarArgs[0], paramBoolean);
        }
      }
    }
    else {
      INSTANCE.updateMovieTemplate(paramMediaModel, paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.WSTemplateManager
 * JD-Core Version:    0.7.0.1
 */