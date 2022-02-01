package com.tencent.mobileqq.flashshow.api.hybird;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

@KeepClassConstructor
public class FSTitleBarView
  extends SwiftIphoneTitleBarUI
{
  public FSTitleBarView(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity = paramActivity.getWindow();
      paramActivity.clearFlags(67108864);
      paramActivity.getDecorView().setSystemUiVisibility(1280);
      paramActivity.addFlags(-2147483648);
      paramActivity.setStatusBarColor(paramInt);
      paramActivity.setNavigationBarColor(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.k != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.k.getContext()) + DisplayUtil.a(this.k.getContext(), 52.0F), 0, 0);
        this.k.setLayoutParams(localLayoutParams);
      }
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setWarnToastVisible error");
      localException.printStackTrace();
    }
    super.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void b()
  {
    if (this.o != null) {
      this.o.setVisibility(8);
    }
    if (this.a.v != null) {
      this.a.v.setVisibility(8);
    }
  }
  
  public void c()
  {
    try
    {
      if (this.a.i != null)
      {
        Resources localResources = this.a.i.getResources();
        if (!this.b.v)
        {
          this.o.setBackgroundColor(localResources.getColor(2131166050));
          if ((this.a.r != null) && (this.a.r.getWebTitleBarInterface().l() != null))
          {
            ImmersiveUtils.setStatusTextColor(false, this.a.i.getWindow());
            a(this.a.i, localResources.getColor(2131166050));
            this.a.r.getWebTitleBarInterface().l().setBackgroundColor(localResources.getColor(2131166050));
          }
        }
        if ((this.b.R instanceof FSWebViewTitleStyle))
        {
          if (((FSWebViewTitleStyle)this.b.R).a == 0)
          {
            this.j.setImageDrawable(localResources.getDrawable(2130840374));
            int i = UIUtils.a(BaseApplicationImpl.getContext(), 14.0F);
            this.j.setPadding(i, i, i, i);
          }
          localObject = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.a.i, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).width = DisplayUtil.a(this.a.i, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).setMargins(DisplayUtil.a(this.a.i, 2.0F), 0, DisplayUtil.a(this.a.i, 8.0F), 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.d.setVisibility(8);
        }
        this.f.setTextColor(localResources.getColor(2131166063));
        this.f.setBackgroundDrawable(null);
        this.e.setTextColor(localResources.getColor(2131166063));
        this.e.getPaint().setFakeBoldText(true);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initDefaultThemeTitleBar error");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, ((StringBuilder)localObject).toString());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSTitleBarView
 * JD-Core Version:    0.7.0.1
 */