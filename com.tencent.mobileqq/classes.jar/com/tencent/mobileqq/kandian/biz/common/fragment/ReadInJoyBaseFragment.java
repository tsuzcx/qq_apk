package com.tencent.mobileqq.kandian.biz.common.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.colornote.api.IColorNoteReportUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyBaseFragmentEntryPath;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public abstract class ReadInJoyBaseFragment
  extends QPublicBaseFragment
  implements MessageObserver
{
  private int a = -1;
  private Bundle b;
  protected LayoutInflater e;
  public boolean f = false;
  protected boolean g = false;
  protected boolean h = false;
  public ReadInJoyBaseFragment.OnNofityVisibleCallback i;
  public CallHotwordChange j;
  public int k;
  public boolean l = false;
  
  public static int c(int paramInt)
  {
    Integer localInteger = ((IReadInJoyBaseFragmentEntryPath)QRoute.api(IReadInJoyBaseFragmentEntryPath.class)).get(paramInt);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainVideoTab()) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInSplashActivity(getActivity()))) {
      return;
    }
    d(paramMessageRecord);
    u().kandianMergeMessageReaded(paramMessageRecord);
    u().notificationTabRedNumsChange();
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyRecommendFeedsFragment(this))) {
      ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).reportInsideTabPushRedPnt(paramMessageRecord);
    }
  }
  
  private void w()
  {
    this.b = getArguments();
    Bundle localBundle = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBundle != null)
    {
      bool1 = bool2;
      if (localBundle.getBoolean("is_xtab_mode", false)) {
        bool1 = true;
      }
    }
    this.l = bool1;
  }
  
  private void x()
  {
    View localView = getView();
    if (localView != null)
    {
      int m;
      if (c()) {
        m = b();
      } else {
        m = 0;
      }
      int n;
      if (q()) {
        n = r();
      } else {
        n = 0;
      }
      if ((m > 0) || (n > 0)) {
        localView.setPadding(0, m, 0, n);
      }
    }
  }
  
  private int y()
  {
    int m;
    try
    {
      Resources localResources = getActivity().getResources();
      m = localResources.getDimensionPixelSize(2131299920);
      n = localResources.getDimensionPixelSize(2131299578);
      int i1 = localResources.getDimensionPixelSize(2131299580);
      int i2 = ImmersiveUtils.getStatusBarHeight(getActivity());
      m = m + n + i1 + i2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      m = 0;
    }
    int n = m;
    if (m <= 0)
    {
      m = ViewUtils.dpToPx(80.5F);
      n = ImmersiveUtils.getStatusBarHeight(getActivity()) + m;
    }
    return n;
  }
  
  private int z()
  {
    return this.b.getInt("channel_padding_top", y());
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(MessageRecord paramMessageRecord)
  {
    c(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    c(paramMessageRecord);
  }
  
  public void a(ReadInJoyBaseFragment.OnNofityVisibleCallback paramOnNofityVisibleCallback)
  {
    this.i = paramOnNofityVisibleCallback;
  }
  
  public void a(CallHotwordChange paramCallHotwordChange, int paramInt)
  {
    this.j = paramCallHotwordChange;
    this.k = paramInt;
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = ReadInJoyBaseFragment.class.getSimpleName();
    paramBundle = new StringBuilder();
    paramBundle.append(getClass().getSimpleName());
    paramBundle.append(" notifyShowSelf");
    QLog.d(paramActivity, 2, paramBundle.toString());
    if (u() != null) {
      u().addMsgObserver(this);
    }
    ((IVideoAutoPlayController)QRoute.api(IVideoAutoPlayController.class)).setChannelId(d());
    if (this.h)
    {
      int m = d();
      if (m != -1)
      {
        ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).enterChannel(m);
        paramActivity = (Integer)RIJChannelViewpagerEnterPathHelper.a().remove(Integer.valueOf(m));
        if (paramActivity != null)
        {
          ((IReadInJoyBaseFragmentEntryPath)QRoute.api(IReadInJoyBaseFragmentEntryPath.class)).put(m, paramActivity.intValue());
          if ((((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) && (paramActivity.intValue() == 0)) {
            ((IRIJChannelReporter)QRoute.api(IRIJChannelReporter.class)).reportForEnterChannel(m, "306");
          }
        }
        else
        {
          ((IReadInJoyBaseFragmentEntryPath)QRoute.api(IReadInJoyBaseFragmentEntryPath.class)).put(m, 2);
          ((IRIJChannelReporter)QRoute.api(IRIJChannelReporter.class)).reportForEnterChannel(m, "301");
        }
        QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "notifyShowSelf, channelID = ", Integer.valueOf(m), ", entryPath = ", Integer.valueOf(c(m)) });
      }
    }
    paramActivity = this.i;
    if (paramActivity != null) {
      paramActivity.j_(true);
    }
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).adSuperMaskServiceSetChannelId(d());
    paramActivity = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
    paramBundle = new StringBuilder();
    paramBundle.append("setSuperMaskChannelId ");
    paramBundle.append(d());
    paramBundle.append(" notifyShowSelf ");
    paramActivity.adSuperMaskLog(paramBundle.toString());
  }
  
  public int b()
  {
    if (this.l) {
      return z();
    }
    return y();
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).refreshSubscriptionUnReadNum();
    c(paramMessageRecord);
  }
  
  public boolean c()
  {
    return (this.h) && ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyViolaChannelFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyBBCircleFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyFragmentWithSubChannel(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyAdHippyFragment(this)) || (this.l));
  }
  
  public abstract int d();
  
  public boolean e()
  {
    return this.g;
  }
  
  public void f()
  {
    getActivity().finish();
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    Object localObject = ReadInJoyBaseFragment.class.getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" notifyHideSelf");
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (u() != null) {
      u().removeMsgObserver(this);
    }
    if (this.h)
    {
      int m = d();
      if ((m != -1) && (((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isChannelShow(m))) {
        n();
      }
      if (m != -1) {
        ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).exitChannel(m, this.a, p());
      }
    }
    localObject = this.i;
    if (localObject != null) {
      ((ReadInJoyBaseFragment.OnNofityVisibleCallback)localObject).j_(false);
    }
  }
  
  public void l() {}
  
  public boolean m()
  {
    return false;
  }
  
  public void n() {}
  
  public boolean o()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    w();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = paramLayoutInflater;
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (u() != null) {
      u().removeMsgObserver(this);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    x();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public String p()
  {
    return "0";
  }
  
  public boolean q()
  {
    return (this.h) && ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyViolaChannelFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyFragmentWithSubChannel(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoySubChannelFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyAdHippyFragment(this)));
  }
  
  public int r()
  {
    try
    {
      int m = getActivity().getResources().getDimensionPixelSize(2131297771);
      return m;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public int s()
  {
    return this.a;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, isVisibleToUser = ", Boolean.valueOf(paramBoolean), ", mIsShowingSelf = ", Boolean.valueOf(this.g) });
    this.g = paramBoolean;
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, mChannelID = ", Integer.valueOf(d()) });
    if (paramBoolean)
    {
      a(false, getActivity(), null);
      return;
    }
    k();
  }
  
  public void t() {}
  
  protected IKanDianMergeManager u()
  {
    return (IKanDianMergeManager)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getRuntimeService(IKanDianMergeManager.class, "");
  }
  
  public Activity v()
  {
    return getQBaseActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment
 * JD-Core Version:    0.7.0.1
 */