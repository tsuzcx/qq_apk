package com.tencent.mobileqq.kandian.glue.webplugin;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin$BaseTribePluginProcessor;", "", "plugin", "Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin;", "(Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin;)V", "getPlugin", "()Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin;", "process", "", "json", "Lorg/json/JSONObject;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class TribeWebViewPlugin$BaseTribePluginProcessor
{
  @NotNull
  private final TribeWebViewPlugin a;
  
  public TribeWebViewPlugin$BaseTribePluginProcessor(@NotNull TribeWebViewPlugin paramTribeWebViewPlugin)
  {
    this.a = paramTribeWebViewPlugin;
  }
  
  @NotNull
  public final TribeWebViewPlugin a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.TribeWebViewPlugin.BaseTribePluginProcessor
 * JD-Core Version:    0.7.0.1
 */