package com.tencent.mobileqq.kandian.biz.ad;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdPopSheetDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyAdPopSheetBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private static final String a = "com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdPopSheetBrowserFragment";
  private String b;
  private String c;
  private String d;
  
  private void a()
  {
    Object localObject = getQBaseActivity().getIntent();
    if (localObject != null)
    {
      this.b = ((Intent)localObject).getStringExtra("h5url");
      this.c = ((Intent)localObject).getStringExtra("adrl");
      this.d = ((Intent)localObject).getStringExtra("traceId");
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate h5Url: ");
      localStringBuilder.append(this.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(this.b))
    {
      getQBaseActivity().finish();
      return;
    }
    localObject = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createReadInJoyAdPopSheetDialog(getQBaseActivity(), this.b, this.c, this.d);
    ((IRIJAdPopSheetDialog)localObject).a(new ReadInJoyAdPopSheetBrowserFragment.1(this));
    ((IRIJAdPopSheetDialog)localObject).show();
  }
  
  public void onFinalState(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super.onFinalState(paramBundle, paramWebViewKernelCallBack);
    if ((getSwiftTitleUI() != null) && (getSwiftTitleUI().a != null)) {
      getSwiftTitleUI().a.setVisibility(8);
    }
    if (getWebTitleBarInterface().a() != null) {
      getWebTitleBarInterface().a().setVisibility(8);
    }
    if ((getUIStyleHandler() != null) && (getUIStyleHandler().a != null)) {
      getUIStyleHandler().a.a(false);
    }
    getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(514);
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdPopSheetBrowserFragment
 * JD-Core Version:    0.7.0.1
 */