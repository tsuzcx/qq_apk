package com.tencent.mobileqq.wxmini.impl.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wxmini/impl/ui/WxMiniDemoActivity;", "Landroid/app/Activity;", "()V", "copyAssetToFile", "", "context", "Landroid/content/Context;", "assetFileName", "", "destFileName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "refreshAuthState", "Companion", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class WxMiniDemoActivity
  extends Activity
{
  public static final WxMiniDemoActivity.Companion a = new WxMiniDemoActivity.Companion(null);
  
  @SuppressLint({"SetTextI18n"})
  private final void a()
  {
    Log.i("RuntimeSDKDemo.WxMiniDemoActivity", "refreshAuthState");
    WxMiniSDKImpl.a.c().checkAuthState((TdiAuthCheckStateListener)new WxMiniDemoActivity.refreshAuthState.1(this));
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(1862467584);
    if (!WxMiniSDKImpl.a.a())
    {
      paramBundle = WxMiniSDKImpl.a;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.sApplication");
      paramBundle.a((Context)localBaseApplicationImpl);
    }
    ((Button)findViewById(1862402050)).setOnClickListener((View.OnClickListener)new WxMiniDemoActivity.onCreate.1(this));
    ((Button)findViewById(1862402051)).setOnClickListener((View.OnClickListener)new WxMiniDemoActivity.onCreate.2(this));
    ((Button)findViewById(1862402052)).setOnClickListener((View.OnClickListener)new WxMiniDemoActivity.onCreate.3(this));
    ((Button)findViewById(1862402048)).setOnClickListener((View.OnClickListener)new WxMiniDemoActivity.onCreate.4(this));
    ((Button)findViewById(1862402049)).setOnClickListener((View.OnClickListener)new WxMiniDemoActivity.onCreate.5(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
    Log.i("RuntimeSDKDemo.WxMiniDemoActivity", "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity
 * JD-Core Version:    0.7.0.1
 */