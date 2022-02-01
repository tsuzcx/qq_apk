package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopAioNotificationBar
  extends TroopAioAgent
  implements View.OnClickListener, Animation.AnimationListener
{
  protected Animation a;
  protected List<TroopAIONotifyItem> a;
  private View jdField_b_of_type_AndroidViewView;
  protected Animation b;
  private boolean jdField_b_of_type_Boolean = false;
  private View c;
  protected Animation c;
  
  public TroopAioNotificationBar()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewAnimationAnimation != null))
      {
        View localView = this.jdField_c_of_type_AndroidViewView;
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.jdField_b_of_type_AndroidViewView.clearAnimation();
          this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
      }
    }
  }
  
  private void a(TroopAIONotifyItem paramTroopAIONotifyItem)
  {
    if (paramTroopAIONotifyItem == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("notifyItem : ");
      ((StringBuilder)localObject1).append(paramTroopAIONotifyItem.toString());
      QLog.d("TroopAioNotificationBar", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (URLThemeImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379145);
    try
    {
      Object localObject2 = new URL(paramTroopAIONotifyItem.icon);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ImageUtil.e();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
      if (((URLDrawable)localObject2).getStatus() == 2) {
        ((URLDrawable)localObject2).restartDownload();
      }
      ((URLThemeImageView)localObject1).setImageDrawable((Drawable)localObject2);
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379148)).setText(paramTroopAIONotifyItem.title);
      localObject1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379147);
      ((TextView)localObject1).setText(paramTroopAIONotifyItem.summary);
      if (TextUtils.isEmpty(paramTroopAIONotifyItem.summary)) {
        ((TextView)localObject1).setVisibility(8);
      } else {
        ((TextView)localObject1).setVisibility(0);
      }
      ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379144)).setBackgroundResource(2130851086);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130851084);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130851085);
      return;
    }
    catch (MalformedURLException paramTroopAIONotifyItem)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioNotificationBar", 2, paramTroopAIONotifyItem.toString());
      }
    }
  }
  
  private void f()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioNotificationBar.1(this));
      return;
    }
    a(-1);
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8)
    {
      Object localObject = this.jdField_b_of_type_AndroidViewView;
      if ((localObject != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null))
      {
        ((View)localObject).clearAnimation();
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localObject = this.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = (TroopAIONotifyItem)this.jdField_a_of_type_JavaUtilList.get(0);
          if ((localObject != null) && (((TroopAIONotifyItem)localObject).hideMode == 1)) {
            TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (TroopAIONotifyItem)localObject);
          }
          QQAppInterface localQQAppInterface;
          String str;
          StringBuilder localStringBuilder;
          if ((localObject != null) && (((TroopAIONotifyItem)localObject).type == 1))
          {
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(((TroopAIONotifyItem)localObject).appId);
            ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_notice", 0, 0, str, "", localStringBuilder.toString(), "");
          }
          else if ((localObject != null) && (((TroopAIONotifyItem)localObject).type == 2))
          {
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(((TroopAIONotifyItem)localObject).appId);
            ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_oper_notice", 0, 0, str, "", localStringBuilder.toString(), "");
          }
        }
      }
    }
    b();
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void a(List<TroopAIONotifyItem> paramList)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView == null) {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560607, null);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      paramList = new RelativeLayout.LayoutParams(-2, -2);
      paramList.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      paramList.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, paramList);
    }
    paramList = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = TroopAioMsgNavigateBar.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131379333, 2131374119, 2131374255, 2131374250 });
    if (i > 0) {
      paramList.addRule(3, i);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131379143);
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    a((TroopAIONotifyItem)this.jdField_a_of_type_JavaUtilList.get(0));
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844014);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  boolean a()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() != 8);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    }
    if (this.jdField_c_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
  }
  
  protected void d()
  {
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).clearAnimation();
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
  }
  
  public void e()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioNotificationBar.2(this));
      return;
    }
    g();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel())
      {
        paramAnimation = new StringBuilder();
        paramAnimation.append("onAnimationEnd: list.size=");
        paramAnimation.append(i);
        paramAnimation.append(", mArrowImageRotated:");
        paramAnimation.append(this.jdField_b_of_type_Boolean);
        QLog.d("TroopAioNotificationBar", 2, paramAnimation.toString());
      }
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopAioNotificationBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    else
    {
      int i = paramView.getId();
      if (i != 2131362331)
      {
        if ((i == 2131379143) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo != null))
        {
          Object localObject1 = this.jdField_a_of_type_JavaUtilList;
          if ((localObject1 != null) && (((List)localObject1).size() != 0))
          {
            localObject1 = (TroopAIONotifyItem)this.jdField_a_of_type_JavaUtilList.remove(0);
            Object localObject2;
            String str;
            StringBuilder localStringBuilder;
            if (((TroopAIONotifyItem)localObject1).type == 1)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(((TroopAIONotifyItem)localObject1).appId);
              ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_notice", 0, 0, str, "", localStringBuilder.toString(), "");
            }
            else if (((TroopAIONotifyItem)localObject1).type == 2)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(((TroopAIONotifyItem)localObject1).appId);
              ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_oper_notice", 0, 0, str, "", localStringBuilder.toString(), "");
            }
            if (((TroopAIONotifyItem)localObject1).url.startsWith("http"))
            {
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", ((TroopAIONotifyItem)localObject1).url);
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject2, ((TroopAIONotifyItem)localObject1).url);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
            else if (((TroopAIONotifyItem)localObject1).url.startsWith("mqqapi"))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) {
                JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((TroopAIONotifyItem)localObject1).url).a();
              } else {
                this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(((TroopAIONotifyItem)localObject1).url)));
              }
            }
            if (((TroopAIONotifyItem)localObject1).hideMode == 2) {
              TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (TroopAIONotifyItem)localObject1);
            }
            f();
          }
        }
      }
      else {
        f();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNotificationBar
 * JD-Core Version:    0.7.0.1
 */