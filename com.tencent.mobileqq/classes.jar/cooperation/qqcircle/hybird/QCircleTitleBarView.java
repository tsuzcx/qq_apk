package cooperation.qqcircle.hybird;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bieo;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.utils.QCircleCommonUtil;

public class QCircleTitleBarView
  extends bieo
{
  public QCircleTitleBarView(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
  }
  
  public void initDefaultThemeTitleBar()
  {
    for (;;)
    {
      try
      {
        if (this.mUIStyleHandler.mHostActivity == null) {
          break;
        }
        localObject = this.mUIStyleHandler.mHostActivity.getResources();
        if (!this.mUIStyle.isTransparentTitleAndClickable)
        {
          this.titleContainer.setBackgroundColor(QCircleCommonUtil.getDefaultThemeColor(false));
          if ((this.mUIStyleHandler.mHostFragment != null) && (this.mUIStyleHandler.mHostFragment.mSystemBarComp != null))
          {
            ImmersiveUtils.a(true, this.mUIStyleHandler.mHostActivity.getWindow());
            this.mUIStyleHandler.mHostFragment.mSystemBarComp.setBackgroundColor(QCircleCommonUtil.getDefaultThemeColor(false));
          }
        }
        if ((this.mUIStyle.mTitleStyle instanceof QCircleWebViewTitleStyle)) {}
        switch (((QCircleWebViewTitleStyle)this.mUIStyle.mTitleStyle).mLeftBackIcon)
        {
        case 0: 
          this.leftCloseView.setImageDrawable(((Resources)localObject).getDrawable(2130844035));
          this.leftCloseView.setBackgroundResource(2130844041);
          i = UIUtils.dip2px(BaseApplicationImpl.getContext(), 14.0F);
          this.leftCloseView.setPadding(i, i, i, i);
          localObject = (RelativeLayout.LayoutParams)this.leftCloseView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.dip2px(this.mUIStyleHandler.mHostActivity, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).width = DisplayUtil.dip2px(this.mUIStyleHandler.mHostActivity, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).setMargins(DisplayUtil.dip2px(this.mUIStyleHandler.mHostActivity, 8.0F), 0, DisplayUtil.dip2px(this.mUIStyleHandler.mHostActivity, 8.0F), 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          this.leftCloseView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.leftView.setVisibility(8);
          this.rightViewText.setTextColor(-16777216);
          this.centerView.setTextColor(-16777216);
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "initDefaultThemeTitleBar error" + localException.getMessage());
        localException.printStackTrace();
        return;
      }
      this.leftCloseView.setImageDrawable(((Resources)localObject).getDrawable(2130844035));
      this.leftCloseView.setBackgroundResource(2130844041);
      i = UIUtils.dip2px(BaseApplicationImpl.getContext(), 14.0F);
      this.leftCloseView.setPadding(i, i, i, i);
      continue;
      this.leftCloseView.setImageDrawable(localException.getDrawable(2130844007));
      continue;
      this.leftCloseView.setImageDrawable(localException.getDrawable(2130844008));
      continue;
      this.leftCloseView.setImageDrawable(localException.getDrawable(2130844009));
    }
  }
  
  public void initPreView()
  {
    if (this.titleContainer != null) {
      this.titleContainer.setVisibility(8);
    }
    if (this.mUIStyleHandler.mLoadingProgressBar != null) {
      this.mUIStyleHandler.mLoadingProgressBar.setVisibility(8);
    }
  }
  
  public void initTitleContainer()
  {
    super.initTitleContainer();
  }
  
  public void setWarnToastVisible(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.mWarnToastView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mWarnToastView.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.mWarnToastView.getContext()) + DisplayUtil.dip2px(this.mWarnToastView.getContext(), 52.0F), 0, 0);
        this.mWarnToastView.setLayoutParams(localLayoutParams);
      }
      super.setWarnToastVisible(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setWarnToastVisible error");
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hybird.QCircleTitleBarView
 * JD-Core Version:    0.7.0.1
 */