package com.tencent.mobileqq.wxmini.impl.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wxmini/impl/wxapi/WXEntryActivity;", "Landroid/app/Activity;", "()V", "handleWxaAPI", "", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "Companion", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class WXEntryActivity
  extends Activity
{
  @Deprecated
  public static final WXEntryActivity.Companion a = new WXEntryActivity.Companion(null);
  
  private final void a(Intent paramIntent)
  {
    try
    {
      QLog.d("wxmini.WXEntryActivity", 1, "handleWxaAPI");
      WxMiniSDKImpl.a.c().handleIntent((Context)this, paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWxaAPI e=");
      localStringBuilder.append(paramIntent);
      Log.e("wxmini.WXEntryActivity", localStringBuilder.toString());
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("wxmini.WXEntryActivity", 1, "onCreate");
    if (getIntent() != null)
    {
      paramBundle = getIntent();
      if (paramBundle == null) {
        Intrinsics.throwNpe();
      }
      a(paramBundle);
      finish();
      return;
    }
    finish();
  }
  
  protected void onNewIntent(@Nullable Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d("wxmini.WXEntryActivity", 1, "onNewIntent");
    if (paramIntent != null)
    {
      a(paramIntent);
      finish();
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */