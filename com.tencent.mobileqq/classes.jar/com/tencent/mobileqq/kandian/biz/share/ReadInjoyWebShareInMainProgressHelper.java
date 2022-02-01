package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper.CallBack;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareInMainProgressHelper;", "Lcom/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper;", "activity", "Landroid/app/Activity;", "appInterface", "Lcom/tencent/common/app/AppInterface;", "readInjoyWebShareHelperCallBack", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$CallBack;", "(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$CallBack;)V", "codeShareQzone", "", "currentUrl", "", "publicUin", "seq", "uin", "callBackToJs", "", "result", "getActivity", "getAppInterface", "getCurrentUrl", "getPublicUin", "getReadinjoyShareToWxConfig", "callback", "Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;", "getUin", "onActivityResult", "intent", "Landroid/content/Intent;", "requestCode", "", "resultCode", "(Landroid/content/Intent;Ljava/lang/Byte;I)V", "onFontSizeChange", "index", "textSizeRatio", "", "release", "sendToComputer", "content", "shareResultCallback", "action", "successed", "", "data", "showShareActionSheet", "bundle", "Landroid/os/Bundle;", "startActivityForResult", "switchRequestCode", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInjoyWebShareInMainProgressHelper
  extends AbstractReadInjoyWebShareHelper
{
  public static final ReadInjoyWebShareInMainProgressHelper.Companion e = new ReadInjoyWebShareInMainProgressHelper.Companion(null);
  private int f;
  private int g;
  private String h;
  private String i;
  private String j;
  private Activity k;
  private AppInterface l;
  private IReadInjoyWebShareHelper.CallBack m;
  
  public ReadInjoyWebShareInMainProgressHelper(@Nullable Activity paramActivity, @Nullable AppInterface paramAppInterface, @Nullable IReadInjoyWebShareHelper.CallBack paramCallBack)
  {
    this.k = paramActivity;
    this.l = paramAppInterface;
    this.m = paramCallBack;
    this.f = -1;
    this.h = "";
    this.i = "";
    this.j = "";
  }
  
  public int a(byte paramByte)
  {
    if (paramByte != 2) {
      return paramByte;
    }
    return this.g;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("methodName", "onFontSizeChange");
    localBundle.putInt("seq", this.f);
    localBundle.putInt("index", paramInt);
    localBundle.putFloat("textSizeRatio", paramFloat);
    IReadInjoyWebShareHelper.CallBack localCallBack = this.m;
    if (localCallBack != null) {
      localCallBack.a(165, localBundle);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, @Nullable String paramString)
  {
    ReadInJoyShareHelperV2.a.a(paramInt, paramBoolean, paramString);
  }
  
  public void a(@Nullable Intent paramIntent, byte paramByte)
  {
    Activity localActivity = this.k;
    if (localActivity != null) {
      localActivity.startActivity(paramIntent);
    }
    if (paramByte == 1)
    {
      a("qq_friend", true);
      return;
    }
    if (paramByte == 2) {
      a("qzone", true);
    }
  }
  
  public void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    String str1 = paramBundle.getString("data");
    this.f = paramBundle.getInt("seq");
    this.g = paramBundle.getInt("code_share_qzone_key");
    String str2 = paramBundle.getString("uin_key", "");
    Intrinsics.checkExpressionValueIsNotNull(str2, "bundle.getString(ReadInj…HelperAction.UIN_KEY, \"\")");
    this.h = str2;
    str2 = paramBundle.getString("public_uin_key", "");
    Intrinsics.checkExpressionValueIsNotNull(str2, "bundle.getString(ReadInj…ction.PUBLIC_UIN_KEY, \"\")");
    this.i = str2;
    paramBundle = paramBundle.getString("current_url_key", "");
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "bundle.getString(ReadInj…tion.CURRENT_URL_KEY, \"\")");
    this.j = paramBundle;
    a(str1);
  }
  
  protected void a(@NotNull ITroopMemberApiClientApi.Callback paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCallback, "callback");
    Bundle localBundle = new Bundle();
    localBundle.putInt("readinjoy_to_wx_config", ReadInJoyHelper.L(RIJQQAppInterfaceUtil.e()));
    paramCallback.callback(localBundle);
  }
  
  protected void a(@Nullable String paramString, @NotNull ITroopMemberApiClientApi.Callback paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCallback, "callback");
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof DataLineHandler))
        {
          bool1 = bool2;
          if (((DataLineHandler)localObject).a(paramString, 0).longValue() > 0L) {
            bool1 = true;
          }
        }
      }
      paramString = new Bundle();
      paramString.putBoolean("isSuccess", bool1);
      paramCallback.callback(paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @NotNull
  public Activity b()
  {
    Activity localActivity = this.k;
    if (localActivity == null) {
      Intrinsics.throwNpe();
    }
    return localActivity;
  }
  
  public void b(@Nullable String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("result", paramString);
    localBundle.putInt("seq", this.f);
    localBundle.putString("methodName", "callBackToJs");
    paramString = this.m;
    if (paramString != null) {
      paramString.a(165, localBundle);
    }
  }
  
  @NotNull
  public AppInterface c()
  {
    AppInterface localAppInterface = this.l;
    if (localAppInterface == null) {
      Intrinsics.throwNpe();
    }
    return localAppInterface;
  }
  
  @NotNull
  public String d()
  {
    return this.h;
  }
  
  @NotNull
  public String e()
  {
    return this.i;
  }
  
  public void f()
  {
    this.k = ((Activity)null);
    this.l = ((AppInterface)null);
    this.m = ((IReadInjoyWebShareHelper.CallBack)null);
    a();
  }
  
  @NotNull
  protected String g()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareInMainProgressHelper
 * JD-Core Version:    0.7.0.1
 */