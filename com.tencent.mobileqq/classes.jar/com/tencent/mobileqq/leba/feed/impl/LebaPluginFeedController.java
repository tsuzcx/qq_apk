package com.tencent.mobileqq.leba.feed.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaMainBizProxy;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedController;
import com.tencent.mobileqq.leba.feed.LebaFeedUtil;
import com.tencent.mobileqq.leba.feed.LebaPluginsFeedView;
import com.tencent.mobileqq.leba.more.LebaMoreFragment;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaPluginFeedController
  implements LebaItemListener, ILebaPluginFeedController
{
  LebaRedTouchBase a = new LebaPluginFeedController.LebaFeedRedTouch(null);
  LebaMainBizProxy b = new LebaMainBizProxy();
  private Context c;
  private AppRuntime d;
  private QBaseActivity e;
  private LebaPluginsFeedView f;
  private ResourcePluginListener g = new LebaPluginFeedController.3(this);
  
  public LebaPluginFeedController(Context paramContext, AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    this.c = paramContext;
    this.d = paramAppRuntime;
    this.e = paramQBaseActivity;
  }
  
  public View a()
  {
    if (this.f == null)
    {
      QLog.i("LebaPluginFeedController", 1, "getPluginView new LebaPluginsFeedView");
      this.f = new LebaPluginsFeedView(this.c);
      this.f.a(this.c, this.d, this.a, this);
    }
    QLog.i("LebaPluginFeedController", 1, "getPluginView");
    return this.f;
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem)
  {
    QLog.i("LebaPluginFeedController", 1, "onMoreClick");
    QPublicFragmentActivity.start(this.c, LebaMoreFragment.class);
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPluginClick position=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("LebaPluginFeedController", 1, ((StringBuilder)localObject).toString());
    localObject = new LebaClickReportInfo();
    ((LebaClickReportInfo)localObject).d = false;
    this.b.a(paramView, paramLebaViewItem, (LebaClickReportInfo)localObject);
  }
  
  public void a(List<LebaViewItem> paramList, boolean paramBoolean)
  {
    if ((this.e != null) && (this.f != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshData showList = ");
      Object localObject;
      if (paramList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramList.size());
      }
      localStringBuilder.append(localObject);
      QLog.i("LebaPluginFeedController", 1, localStringBuilder.toString());
      this.e.runOnUiThread(new LebaPluginFeedController.2(this, paramList, paramBoolean));
      return;
    }
    QLog.i("LebaPluginFeedController", 1, "mActivity == null || mPluginView == null");
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("LebaPluginFeedController", 1, "reloadData");
    ThreadManager.excute(new LebaPluginFeedController.1(this, paramBoolean), 160, null, true);
  }
  
  public void b()
  {
    QLog.i("LebaPluginFeedController", 1, "onTabClick");
  }
  
  public void c()
  {
    QLog.i("LebaPluginFeedController", 1, "onCreate");
    Object localObject = new LebaPluginFeedController.RealProxy();
    ((LebaPluginFeedController.RealProxy)localObject).a = this;
    this.b.a((ILebaProxy)localObject);
    this.b.i();
    localObject = (ILebaHelperService)this.d.getRuntimeService(ILebaHelperService.class, "multi");
    ((ILebaHelperService)localObject).initLebaHelper();
    ((ILebaHelperService)localObject).addLebaListener(this.g);
  }
  
  public void d()
  {
    QLog.i("LebaPluginFeedController", 1, "onResume");
    this.b.a(false);
    this.b.f();
    LebaFeedUtil.a(true);
    a(true);
    ((ILebaHelperService)this.d.getRuntimeService(ILebaHelperService.class, "multi")).checkModleAndRefesh();
  }
  
  public void e()
  {
    QLog.i("LebaPluginFeedController", 1, "onPause");
    this.b.d();
    this.a.a(this.d);
  }
  
  public void f()
  {
    QLog.i("LebaPluginFeedController", 1, "onStop");
  }
  
  public void g()
  {
    QLog.i("LebaPluginFeedController", 1, "onAccountChanged");
    l();
  }
  
  public void h() {}
  
  public void i()
  {
    QLog.i("LebaPluginFeedController", 1, "onPostThemeChanged");
    LebaPluginsFeedView localLebaPluginsFeedView = this.f;
    if (localLebaPluginsFeedView != null) {
      localLebaPluginsFeedView.b();
    }
  }
  
  public AppRuntime j()
  {
    return this.d;
  }
  
  public QBaseActivity k()
  {
    return this.e;
  }
  
  public void l()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.impl.LebaPluginFeedController
 * JD-Core Version:    0.7.0.1
 */