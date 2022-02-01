package com.tencent.mobileqq.kandian.glue.webplugin;

import com.tencent.mobileqq.kandian.biz.share.ShowShareMenuProcessor;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "processMap", "", "", "Lcom/tencent/mobileqq/kandian/biz/share/ShowShareMenuProcessor;", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "BaseTribePluginProcessor", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TribeWebViewPlugin
  extends WebViewPlugin
{
  public static final TribeWebViewPlugin.Companion a;
  private final Map<String, ShowShareMenuProcessor> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginTribeWebViewPlugin$Companion = new TribeWebViewPlugin.Companion(null);
  }
  
  public TribeWebViewPlugin()
  {
    this.jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(TuplesKt.to("showShareMenu", new ShowShareMenuProcessor(this)));
  }
  
  protected boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    Object localObject = (CharSequence)paramString3;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      localObject = (ShowShareMenuProcessor)this.jdField_a_of_type_JavaUtilMap.get(paramString3);
      if (localObject != null)
      {
        if (paramVarArgs.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0) {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        } else {
          paramJsBridgeListener = new JSONObject();
        }
        ((ShowShareMenuProcessor)localObject).a(paramJsBridgeListener);
        return true;
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.TribeWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */