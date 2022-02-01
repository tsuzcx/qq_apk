package com.tencent.weseevideo.model.template.light;

import com.tencent.weishi.module.publisher.interfaces.XffectsDownloadListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.MovieController;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/weseevideo/model/template/light/LightTemplateMediaBuilder$replaceLightPresetData$1", "Lcom/tencent/weishi/module/publisher/interfaces/XffectsDownloadListener;", "onDownloadFailed", "", "url", "", "onDownloadSucceed", "path", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LightTemplateMediaBuilder$replaceLightPresetData$1
  implements XffectsDownloadListener
{
  LightTemplateMediaBuilder$replaceLightPresetData$1(HashMap paramHashMap, MovieController paramMovieController) {}
  
  public void onDownloadFailed(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
  }
  
  public void onDownloadSucceed(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    ((Map)this.$filledPresetData).put("user.avatar", paramString2);
    this.$movieController.setPresetData(this.$filledPresetData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightTemplateMediaBuilder.replaceLightPresetData.1
 * JD-Core Version:    0.7.0.1
 */