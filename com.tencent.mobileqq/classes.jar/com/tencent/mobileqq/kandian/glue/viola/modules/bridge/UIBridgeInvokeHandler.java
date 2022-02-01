package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.danmaku.edit.EditDanmakuDialog;
import com.tencent.common.danmaku.edit.listener.EditDanmakuListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import cooperation.liveroom.LiveRoomProxyActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/UIBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "arouseReadInJoyNativeCommentView", "", "params", "Lorg/json/JSONObject;", "callbackId", "", "arouseTkdBarragePublisher", "biuCommentAladdinConfig", "callBackId", "nameSpace", "openPluginView", "register", "showCommentEditor", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UIBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final UIBridgeInvokeHandler.Companion a = new UIBridgeInvokeHandler.Companion(null);
  
  public UIBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("url");
    } else {
      paramJSONObject = null;
    }
    paramString = d().getActivity();
    if ((paramString != null) && (paramJSONObject != null))
    {
      int i;
      if (((CharSequence)paramJSONObject).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        LiveRoomProxyActivity.open(paramString, paramJSONObject, "Readinjoy feeds");
      }
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optBoolean("isAlbum", true))
      {
        d().arouseReadInJoyNativeCommentView(paramJSONObject, paramString);
        return;
      }
      String str;
      if (TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        str = paramString;
      } else {
        str = paramJSONObject.optString("callback");
      }
      ReadInJoyLegacyUtils.a(paramJSONObject, str, (CallCommentJs)new UIBridgeInvokeHandler.arouseReadInJoyNativeCommentView..inlined.also.lambda.1(this, paramString));
    }
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    UiApiPlugin.a(true, paramString, (CallCommentJs)new UIBridgeInvokeHandler.biuCommentAladdinConfig.1(this));
  }
  
  private final void d(JSONObject paramJSONObject, String paramString)
  {
    UiApiPlugin.a(paramJSONObject, paramString, c());
  }
  
  private final void e(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = c();
    if (localObject != null)
    {
      int i;
      if (paramJSONObject != null) {
        i = paramJSONObject.optInt("maximum", 14);
      } else {
        i = 14;
      }
      String str1;
      if (paramJSONObject != null)
      {
        str1 = paramJSONObject.optString("placeHolder", "发条友善的弹幕");
        if (str1 != null) {}
      }
      else
      {
        str1 = "发条友善的弹幕";
      }
      String str2;
      if (paramJSONObject != null)
      {
        str2 = paramJSONObject.optString("lastContent");
        if (str2 != null) {}
      }
      else
      {
        str2 = "";
      }
      localObject = new EditDanmakuDialog((Context)localObject);
      ((EditDanmakuDialog)localObject).a(i);
      ((EditDanmakuDialog)localObject).a(str1);
      ((EditDanmakuDialog)localObject).b(str2);
      ((EditDanmakuDialog)localObject).c("#02CAFC");
      ((EditDanmakuDialog)localObject).a((EditDanmakuListener)new UIBridgeInvokeHandler.arouseTkdBarragePublisher..inlined.let.lambda.1(i, str1, str2, this, paramJSONObject, paramString));
      ((EditDanmakuDialog)localObject).show();
    }
  }
  
  public void a()
  {
    UIBridgeInvokeHandler localUIBridgeInvokeHandler = (UIBridgeInvokeHandler)this;
    a("openPluginView", (Function2)new UIBridgeInvokeHandler.register.1(localUIBridgeInvokeHandler));
    a("arouseReadInJoyNativeCommentView", (Function2)new UIBridgeInvokeHandler.register.2(localUIBridgeInvokeHandler));
    a("biuCommentAladdinConfig", (Function2)new UIBridgeInvokeHandler.register.3(localUIBridgeInvokeHandler));
    a("showCommentEditor", (Function2)new UIBridgeInvokeHandler.register.4(localUIBridgeInvokeHandler));
    a("arouseTkdBarragePublisher", (Function2)new UIBridgeInvokeHandler.register.5(localUIBridgeInvokeHandler));
    a("showTips", (Function2)new UIBridgeInvokeHandler.register.6(this));
    a("openPage", (Function2)new UIBridgeInvokeHandler.register.7(this));
    a("openUrl", (Function2)new UIBridgeInvokeHandler.register.8(this));
    a("setTitle", (Function2)new UIBridgeInvokeHandler.register.9(this));
    a("pageVisibility", (Function2)new UIBridgeInvokeHandler.register.10(this));
    a("popBack", (Function2)new UIBridgeInvokeHandler.register.11(this));
    a("suspensionPopBack", (Function2)new UIBridgeInvokeHandler.register.12(this));
    a("setNavBtn", (Function2)new UIBridgeInvokeHandler.register.13(this));
    a("showDialog", (Function2)new UIBridgeInvokeHandler.register.14(this));
    a("showShareMenu", (Function2)new UIBridgeInvokeHandler.register.15(this));
    a("canOpenPage", (Function2)new UIBridgeInvokeHandler.register.16(this));
    a("setNavBar", (Function2)new UIBridgeInvokeHandler.register.17(this));
    a("setRightDragToGoBackParams", (Function2)new UIBridgeInvokeHandler.register.18(this));
    a("showActionSheet", (Function2)new UIBridgeInvokeHandler.register.19(this));
    a("violaTitleBarClick", (Function2)new UIBridgeInvokeHandler.register.20(this));
    a("sharePicMessage", (Function2)new UIBridgeInvokeHandler.register.21(this));
    a("isNightMode", (Function2)new UIBridgeInvokeHandler.register.22(this));
    a("addViolaPageByUrl", (Function2)new UIBridgeInvokeHandler.register.23(this));
    a("disableSwitcher", (Function2)new UIBridgeInvokeHandler.register.24(this));
    a("getCurrentTotalConsumeTime", (Function2)new UIBridgeInvokeHandler.register.25(this));
  }
  
  @NotNull
  public String b()
  {
    return "ui";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.UIBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */