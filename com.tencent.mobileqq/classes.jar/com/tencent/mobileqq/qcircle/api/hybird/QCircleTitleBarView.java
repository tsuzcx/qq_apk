package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qroute.QRoute;
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
public class QCircleTitleBarView
  extends SwiftIphoneTitleBarUI
{
  public QCircleTitleBarView(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
  }
  
  public void a()
  {
    super.a();
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
    for (;;)
    {
      try
      {
        if (this.a.i != null)
        {
          Resources localResources = this.a.i.getResources();
          if (!this.b.v)
          {
            localObject = this.o;
            bool = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode();
            j = 2131167018;
            if (!bool) {
              break label702;
            }
            i = 2131167018;
            ((ViewGroup)localObject).setBackgroundColor(localResources.getColor(i));
            if ((this.a.r != null) && (this.a.r.getWebTitleBarInterface().l() != null))
            {
              if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                break label709;
              }
              bool = true;
              ImmersiveUtils.setStatusTextColor(bool, this.a.i.getWindow());
              localObject = (IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class);
              Activity localActivity = this.a.i;
              if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                break label714;
              }
              i = 2131167018;
              ((IQCircleCommonUtil)localObject).setStatusBarColor(localActivity, localResources.getColor(i));
              localObject = this.a.r.getWebTitleBarInterface().l();
              if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                break label721;
              }
              i = j;
              ((View)localObject).setBackgroundColor(localResources.getColor(i));
            }
          }
          if ((this.b.R instanceof QCircleWebViewTitleStyle))
          {
            j = ((QCircleWebViewTitleStyle)this.b.R).a;
            i = 2130845155;
            if (j != 0)
            {
              if (j != 1)
              {
                if (j != 2)
                {
                  if (j != 3)
                  {
                    this.j.setImageDrawable(localResources.getDrawable(2130845155));
                    this.j.setBackgroundResource(2130845166);
                    i = UIUtils.a(BaseApplicationImpl.getContext(), 14.0F);
                    this.j.setPadding(i, i, i, i);
                  }
                  else
                  {
                    this.j.setImageDrawable(localResources.getDrawable(2130845042));
                  }
                }
                else {
                  this.j.setImageDrawable(localResources.getDrawable(2130845041));
                }
              }
              else {
                this.j.setImageDrawable(localResources.getDrawable(2130845040));
              }
            }
            else
            {
              localObject = this.j;
              if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                i = 2130845156;
              }
              ((FadeIconImageView)localObject).setImageDrawable(localResources.getDrawable(i));
              i = UIUtils.a(BaseApplicationImpl.getContext(), 14.0F);
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
          localObject = this.f;
          bool = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode();
          int j = 2131167031;
          if (!bool) {
            break label728;
          }
          i = 2131167031;
          ((TextView)localObject).setTextColor(localResources.getColor(i));
          this.f.setBackgroundDrawable(null);
          localObject = this.e;
          if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            break label735;
          }
          i = j;
          ((TextView)localObject).setTextColor(localResources.getColor(i));
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
      return;
      label702:
      int i = 2131167017;
      continue;
      label709:
      boolean bool = false;
      continue;
      label714:
      i = 2131167017;
      continue;
      label721:
      i = 2131167017;
      continue;
      label728:
      i = 2131167030;
      continue;
      label735:
      i = 2131167030;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleTitleBarView
 * JD-Core Version:    0.7.0.1
 */