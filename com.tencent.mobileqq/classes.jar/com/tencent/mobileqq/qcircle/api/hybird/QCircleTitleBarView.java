package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QCircleTitleBarView
  extends SwiftIphoneTitleBarUI
{
  public QCircleTitleBarView(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext()) + DisplayUtil.b(this.jdField_a_of_type_AndroidViewView.getContext(), 52.0F), 0, 0);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      super.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        RFLog.e("WebLog_SwiftIphoneTitleBarUI", RFLog.USR, "setWarnToastVisible error");
        localException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity == null) {
          break label696;
        }
        localResources = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getResources();
        if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.m)
        {
          localObject = this.jdField_a_of_type_AndroidViewViewGroup;
          if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            break label697;
          }
          i = 2131166270;
          ((ViewGroup)localObject).setBackgroundColor(localResources.getColor(i));
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSystemBarComp != null))
          {
            if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
              break label703;
            }
            bool = true;
            ImmersiveUtils.setStatusTextColor(bool, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getWindow());
            localObject = (IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class);
            Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity;
            if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
              break label708;
            }
            i = 2131166270;
            ((IQCircleCommonUtil)localObject).setStatusBarColor(localActivity, localResources.getColor(i));
            localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSystemBarComp;
            if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
              break label714;
            }
            i = 2131166270;
            ((View)localObject).setBackgroundColor(localResources.getColor(i));
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.a instanceof QCircleWebViewTitleStyle)) {}
        switch (((QCircleWebViewTitleStyle)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.a).a)
        {
        case 0: 
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localResources.getDrawable(2130844212));
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setBackgroundResource(2130844221);
          i = UIUtils.a(BaseApplicationImpl.getContext(), 14.0F);
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setPadding(i, i, i, i);
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).width = DisplayUtil.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).setMargins(DisplayUtil.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 8.0F), 0, DisplayUtil.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity, 8.0F), 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localObject = this.c;
          if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            break label681;
          }
          i = 2131166283;
          ((TextView)localObject).setTextColor(localResources.getColor(i));
          this.c.setBackgroundDrawable(null);
          localObject = this.b;
          if (!((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
            break label687;
          }
          i = 2131166283;
          ((TextView)localObject).setTextColor(localResources.getColor(i));
          return;
        }
      }
      catch (Exception localException)
      {
        Resources localResources;
        Object localObject;
        RFLog.e("WebLog_SwiftIphoneTitleBarUI", RFLog.USR, "initDefaultThemeTitleBar error" + localException.getMessage());
        localException.printStackTrace();
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetFadeIconImageView;
      if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode())
      {
        i = 2130844213;
        ((FadeIconImageView)localObject).setImageDrawable(localResources.getDrawable(i));
        localObject = this.jdField_a_of_type_ComTencentWidgetFadeIconImageView;
        if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode())
        {
          i = 2130844222;
          ((FadeIconImageView)localObject).setBackgroundResource(i);
          i = UIUtils.a(BaseApplicationImpl.getContext(), 14.0F);
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setPadding(i, i, i, i);
        }
      }
      else
      {
        i = 2130844212;
        continue;
      }
      int i = 2130844221;
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130844179));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130844180));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130844181));
      continue;
      label681:
      i = 2131166282;
      continue;
      label687:
      i = 2131166282;
      continue;
      continue;
      label696:
      return;
      label697:
      i = 2131166269;
      continue;
      label703:
      boolean bool = false;
      continue;
      label708:
      i = 2131166269;
      continue;
      label714:
      i = 2131166269;
    }
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleTitleBarView
 * JD-Core Version:    0.7.0.1
 */