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
import com.tencent.biz.richframework.delegate.impl.RFLog;
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
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext()) + DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 52.0F), 0, 0);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
    }
    catch (Exception localException)
    {
      RFLog.e("WebLog_SwiftIphoneTitleBarUI", RFLog.USR, "setWarnToastVisible error");
      localException.printStackTrace();
    }
    super.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    }
  }
  
  public void c()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity != null)
        {
          Resources localResources = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getResources();
          if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m)
          {
            localObject = this.jdField_a_of_type_AndroidViewViewGroup;
            bool = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode();
            j = 2131166281;
            if (!bool) {
              break label706;
            }
            i = 2131166281;
            ((ViewGroup)localObject).setBackgroundColor(localResources.getColor(i));
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a() != null))
            {
              if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                break label713;
              }
              bool = true;
              ImmersiveUtils.setStatusTextColor(bool, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getWindow());
              localObject = (IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class);
              Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity;
              if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                break label718;
              }
              i = 2131166281;
              ((IQCircleCommonUtil)localObject).setStatusBarColor(localActivity, localResources.getColor(i));
              localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a();
              if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                break label725;
              }
              i = j;
              ((View)localObject).setBackgroundColor(localResources.getColor(i));
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.a instanceof QCircleWebViewTitleStyle))
          {
            j = ((QCircleWebViewTitleStyle)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.a).a;
            i = 2130844114;
            if (j != 0)
            {
              if (j != 1)
              {
                if (j != 2)
                {
                  if (j != 3)
                  {
                    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localResources.getDrawable(2130844114));
                    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setBackgroundResource(2130844123);
                    i = UIUtils.a(BaseApplicationImpl.getContext(), 14.0F);
                    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setPadding(i, i, i, i);
                  }
                  else
                  {
                    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localResources.getDrawable(2130844084));
                  }
                }
                else {
                  this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localResources.getDrawable(2130844083));
                }
              }
              else {
                this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localResources.getDrawable(2130844082));
              }
            }
            else
            {
              localObject = this.jdField_a_of_type_ComTencentWidgetFadeIconImageView;
              if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                i = 2130844115;
              }
              ((FadeIconImageView)localObject).setImageDrawable(localResources.getDrawable(i));
              i = UIUtils.a(BaseApplicationImpl.getContext(), 14.0F);
              this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setPadding(i, i, i, i);
            }
            localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 52.0F);
            ((RelativeLayout.LayoutParams)localObject).width = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 52.0F);
            ((RelativeLayout.LayoutParams)localObject).setMargins(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 2.0F), 0, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 8.0F), 0);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
            this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          localObject = this.c;
          bool = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode();
          int j = 2131166294;
          if (!bool) {
            break label732;
          }
          i = 2131166294;
          ((TextView)localObject).setTextColor(localResources.getColor(i));
          this.c.setBackgroundDrawable(null);
          localObject = this.b;
          if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            break label739;
          }
          i = j;
          ((TextView)localObject).setTextColor(localResources.getColor(i));
          this.b.getPaint().setFakeBoldText(true);
          return;
        }
      }
      catch (Exception localException)
      {
        i = RFLog.USR;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initDefaultThemeTitleBar error");
        ((StringBuilder)localObject).append(localException.getMessage());
        RFLog.e("WebLog_SwiftIphoneTitleBarUI", i, ((StringBuilder)localObject).toString());
        localException.printStackTrace();
      }
      return;
      label706:
      int i = 2131166280;
      continue;
      label713:
      boolean bool = false;
      continue;
      label718:
      i = 2131166280;
      continue;
      label725:
      i = 2131166280;
      continue;
      label732:
      i = 2131166293;
      continue;
      label739:
      i = 2131166293;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleTitleBarView
 * JD-Core Version:    0.7.0.1
 */