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
  protected List<TroopAIONotifyItem> d = new ArrayList();
  protected Animation e = null;
  protected Animation f = null;
  protected Animation g = null;
  private View h;
  private boolean i = false;
  private View j;
  
  private void a(int paramInt)
  {
    if (this.M)
    {
      this.i = false;
      if ((this.h != null) && (this.f != null))
      {
        View localView = this.j;
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.h.clearAnimation();
          this.h.startAnimation(this.f);
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
    Object localObject1 = (URLThemeImageView)this.h.findViewById(2131447881);
    try
    {
      Object localObject2 = new URL(paramTroopAIONotifyItem.icon);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ImageUtil.j();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
      if (((URLDrawable)localObject2).getStatus() == 2) {
        ((URLDrawable)localObject2).restartDownload();
      }
      ((URLThemeImageView)localObject1).setImageDrawable((Drawable)localObject2);
      ((TextView)this.h.findViewById(2131447884)).setText(paramTroopAIONotifyItem.title);
      localObject1 = (TextView)this.h.findViewById(2131447883);
      ((TextView)localObject1).setText(paramTroopAIONotifyItem.summary);
      if (TextUtils.isEmpty(paramTroopAIONotifyItem.summary)) {
        ((TextView)localObject1).setVisibility(8);
      } else {
        ((TextView)localObject1).setVisibility(0);
      }
      ((ImageView)this.h.findViewById(2131447880)).setBackgroundResource(2130853321);
      if (ThemeUtil.isInNightMode(this.D))
      {
        this.h.setBackgroundResource(2130853319);
        return;
      }
      this.h.setBackgroundResource(2130853320);
      return;
    }
    catch (MalformedURLException paramTroopAIONotifyItem)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioNotificationBar", 2, paramTroopAIONotifyItem.toString());
      }
    }
  }
  
  private void e()
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
    if (this.j.getVisibility() == 8)
    {
      Object localObject = this.h;
      if ((localObject != null) && (this.e != null))
      {
        ((View)localObject).clearAnimation();
        this.h.startAnimation(this.e);
        this.j.setVisibility(0);
        this.h.setVisibility(0);
        localObject = this.d;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = (TroopAIONotifyItem)this.d.get(0);
          if ((localObject != null) && (((TroopAIONotifyItem)localObject).hideMode == 1)) {
            TroopAioNotifyManager.a(this.D, (TroopAIONotifyItem)localObject);
          }
          QQAppInterface localQQAppInterface;
          String str;
          StringBuilder localStringBuilder;
          if ((localObject != null) && (((TroopAIONotifyItem)localObject).type == 1))
          {
            localQQAppInterface = this.D;
            str = this.F.b;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(((TroopAIONotifyItem)localObject).appId);
            ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_notice", 0, 0, str, "", localStringBuilder.toString(), "");
          }
          else if ((localObject != null) && (((TroopAIONotifyItem)localObject).type == 2))
          {
            localQQAppInterface = this.D;
            str = this.F.b;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(((TroopAIONotifyItem)localObject).appId);
            ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_oper_notice", 0, 0, str, "", localStringBuilder.toString(), "");
          }
        }
      }
    }
    w();
  }
  
  protected void a()
  {
    if (this.e == null)
    {
      this.e = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.e.setDuration(500L);
      this.e.setAnimationListener(this);
    }
    if (this.f == null)
    {
      this.f = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.f.setDuration(500L);
      this.f.setAnimationListener(this);
    }
    if (this.g == null)
    {
      this.g = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.g.setDuration(500L);
      this.g.setFillAfter(true);
    }
  }
  
  public void a(List<TroopAIONotifyItem> paramList)
  {
    if (!this.M) {
      return;
    }
    this.d = paramList;
    if (this.G == null) {
      return;
    }
    if (this.j == null) {
      this.j = LayoutInflater.from(this.E).inflate(2131626652, null);
    }
    if (this.G.indexOfChild(this.j) == -1)
    {
      paramList = new RelativeLayout.LayoutParams(-2, -2);
      paramList.topMargin = DisplayUtil.a(this.E, 18.0F);
      paramList.addRule(11);
      this.G.addView(this.j, paramList);
    }
    paramList = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    int k = TroopAioMsgNavigateBar.a(this.G, new int[] { 2131448070, 2131442214, 2131442350, 2131442345 });
    if (k > 0) {
      paramList.addRule(3, k);
    }
    if (this.h == null) {
      this.h = this.j.findViewById(2131447879);
    }
    this.j.setBackgroundResource(17170445);
    this.j.setVisibility(8);
    a((TroopAIONotifyItem)this.d.get(0));
    this.h.setBackgroundResource(2130844969);
    this.h.setOnClickListener(this);
  }
  
  protected void b()
  {
    if (this.j != null)
    {
      localObject = this.h;
      if (localObject != null)
      {
        ((View)localObject).clearAnimation();
        this.j.setVisibility(8);
        localObject = (ViewGroup)this.j.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.j);
        }
      }
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.e = null;
    this.f = null;
    this.g = null;
  }
  
  boolean c()
  {
    View localView = this.j;
    return (localView != null) && (localView.getVisibility() != 8);
  }
  
  public void d()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioNotificationBar.2(this));
      return;
    }
    g();
  }
  
  public View f()
  {
    return this.j;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.f))
    {
      int k = this.d.size();
      if (QLog.isColorLevel())
      {
        paramAnimation = new StringBuilder();
        paramAnimation.append("onAnimationEnd: list.size=");
        paramAnimation.append(k);
        paramAnimation.append(", mArrowImageRotated:");
        paramAnimation.append(this.i);
        QLog.d("TroopAioNotificationBar", 2, paramAnimation.toString());
      }
      this.h.clearAnimation();
      this.j.setVisibility(8);
      this.h.setVisibility(8);
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
      int k = paramView.getId();
      if (k != 2131427931)
      {
        if ((k == 2131447879) && (this.F != null))
        {
          Object localObject1 = this.d;
          if ((localObject1 != null) && (((List)localObject1).size() != 0))
          {
            localObject1 = (TroopAIONotifyItem)this.d.remove(0);
            Object localObject2;
            String str;
            StringBuilder localStringBuilder;
            if (((TroopAIONotifyItem)localObject1).type == 1)
            {
              localObject2 = this.D;
              str = this.F.b;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(((TroopAIONotifyItem)localObject1).appId);
              ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_notice", 0, 0, str, "", localStringBuilder.toString(), "");
            }
            else if (((TroopAIONotifyItem)localObject1).type == 2)
            {
              localObject2 = this.D;
              str = this.F.b;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(((TroopAIONotifyItem)localObject1).appId);
              ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_oper_notice", 0, 0, str, "", localStringBuilder.toString(), "");
            }
            if (((TroopAIONotifyItem)localObject1).url.startsWith("http"))
            {
              localObject2 = new Intent(this.E, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", ((TroopAIONotifyItem)localObject1).url);
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject2, ((TroopAIONotifyItem)localObject1).url);
              this.E.startActivity((Intent)localObject2);
            }
            else if (((TroopAIONotifyItem)localObject1).url.startsWith("mqqapi"))
            {
              if ((this.D instanceof QQAppInterface)) {
                JumpParser.a(this.D, this.E, ((TroopAIONotifyItem)localObject1).url).a();
              } else {
                this.E.startActivity(new Intent(this.E, JumpActivity.class).setData(Uri.parse(((TroopAIONotifyItem)localObject1).url)));
              }
            }
            if (((TroopAIONotifyItem)localObject1).hideMode == 2) {
              TroopAioNotifyManager.a(this.D, (TroopAIONotifyItem)localObject1);
            }
            e();
          }
        }
      }
      else {
        e();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNotificationBar
 * JD-Core Version:    0.7.0.1
 */