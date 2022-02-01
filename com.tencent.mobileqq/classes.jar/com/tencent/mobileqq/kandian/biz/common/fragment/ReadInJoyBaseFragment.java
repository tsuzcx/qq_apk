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
  private int jdField_a_of_type_Int = -1;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected LayoutInflater a;
  public ReadInJoyBaseFragment.OnNofityVisibleCallback a;
  public CallHotwordChange a;
  public boolean a;
  public int b;
  protected boolean b;
  protected boolean c = false;
  public boolean d = false;
  
  public ReadInJoyBaseFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static int a(int paramInt)
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
    a().kandianMergeMessageReaded(paramMessageRecord);
    a().notificationTabRedNumsChange();
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyRecommendFeedsFragment(this))) {
      ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).reportInsideTabPushRedPnt(paramMessageRecord);
    }
  }
  
  private int e()
  {
    int i;
    try
    {
      Resources localResources = getActivity().getResources();
      i = localResources.getDimensionPixelSize(2131299168);
      j = localResources.getDimensionPixelSize(2131298861);
      int k = localResources.getDimensionPixelSize(2131298863);
      int m = ImmersiveUtils.getStatusBarHeight(getActivity());
      i = i + j + k + m;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    int j = i;
    if (i <= 0)
    {
      i = ViewUtils.b(80.5F);
      j = ImmersiveUtils.getStatusBarHeight(getActivity()) + i;
    }
    return j;
  }
  
  private int f()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getInt("channel_padding_top", e());
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBundle != null)
    {
      bool1 = bool2;
      if (localBundle.getBoolean("is_xtab_mode", false)) {
        bool1 = true;
      }
    }
    this.d = bool1;
  }
  
  private void j()
  {
    View localView = getView();
    if (localView != null)
    {
      int i;
      if (a()) {
        i = a();
      } else {
        i = 0;
      }
      int j;
      if (e()) {
        j = c();
      } else {
        j = 0;
      }
      if ((i > 0) || (j > 0)) {
        localView.setPadding(0, i, 0, j);
      }
    }
  }
  
  public int a()
  {
    if (this.d) {
      return f();
    }
    return e();
  }
  
  public Activity a()
  {
    return getQBaseActivity();
  }
  
  protected IKanDianMergeManager a()
  {
    return (IKanDianMergeManager)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getRuntimeService(IKanDianMergeManager.class, "");
  }
  
  public String a()
  {
    return "0";
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment$OnNofityVisibleCallback = paramOnNofityVisibleCallback;
  }
  
  public void a(CallHotwordChange paramCallHotwordChange, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange = paramCallHotwordChange;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = ReadInJoyBaseFragment.class.getSimpleName();
    paramBundle = new StringBuilder();
    paramBundle.append(getClass().getSimpleName());
    paramBundle.append(" notifyShowSelf");
    QLog.d(paramActivity, 2, paramBundle.toString());
    if (a() != null) {
      a().addMsgObserver(this);
    }
    ((IVideoAutoPlayController)QRoute.api(IVideoAutoPlayController.class)).setChannelId(b());
    if (this.c)
    {
      int i = b();
      if (i != -1)
      {
        ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).enterChannel(i);
        paramActivity = (Integer)RIJChannelViewpagerEnterPathHelper.a().remove(Integer.valueOf(i));
        if (paramActivity != null)
        {
          ((IReadInJoyBaseFragmentEntryPath)QRoute.api(IReadInJoyBaseFragmentEntryPath.class)).put(i, paramActivity.intValue());
          if ((((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) && (paramActivity.intValue() == 0)) {
            ((IRIJChannelReporter)QRoute.api(IRIJChannelReporter.class)).reportForEnterChannel(i, "306");
          }
        }
        else
        {
          ((IReadInJoyBaseFragmentEntryPath)QRoute.api(IReadInJoyBaseFragmentEntryPath.class)).put(i, 2);
          ((IRIJChannelReporter)QRoute.api(IRIJChannelReporter.class)).reportForEnterChannel(i, "301");
        }
        QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "notifyShowSelf, channelID = ", Integer.valueOf(i), ", entryPath = ", Integer.valueOf(a(i)) });
      }
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment$OnNofityVisibleCallback;
    if (paramActivity != null) {
      paramActivity.e_(true);
    }
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).adSuperMaskServiceSetChannelId(b());
    paramActivity = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
    paramBundle = new StringBuilder();
    paramBundle.append("setSuperMaskChannelId ");
    paramBundle.append(b());
    paramBundle.append(" notifyShowSelf ");
    paramActivity.adSuperMaskLog(paramBundle.toString());
  }
  
  public boolean a()
  {
    return (this.c) && ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyViolaChannelFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyBBCircleFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyFragmentWithSubChannel(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyAdHippyFragment(this)) || (this.d));
  }
  
  public void aA_() {}
  
  public void az_() {}
  
  public abstract int b();
  
  public void b()
  {
    getActivity().finish();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).refreshSubscriptionUnReadNum();
    c(paramMessageRecord);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int c()
  {
    try
    {
      int i = getActivity().getResources().getDimensionPixelSize(2131297336);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void d() {}
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    Object localObject = ReadInJoyBaseFragment.class.getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" notifyHideSelf");
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (a() != null) {
      a().removeMsgObserver(this);
    }
    if (this.c)
    {
      int i = b();
      if ((i != -1) && (((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isChannelShow(i))) {
        g();
      }
      if (i != -1) {
        ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).exitChannel(i, this.jdField_a_of_type_Int, a());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment$OnNofityVisibleCallback;
    if (localObject != null) {
      ((ReadInJoyBaseFragment.OnNofityVisibleCallback)localObject).e_(false);
    }
  }
  
  public boolean e()
  {
    return (this.c) && ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyViolaChannelFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyFragmentWithSubChannel(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoySubChannelFragment(this)) || (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyAdHippyFragment(this)));
  }
  
  public void f() {}
  
  public void g() {}
  
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
    i();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
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
    if (a() != null) {
      a().removeMsgObserver(this);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    j();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, isVisibleToUser = ", Boolean.valueOf(paramBoolean), ", mIsShowingSelf = ", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    this.jdField_b_of_type_Boolean = paramBoolean;
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, mChannelID = ", Integer.valueOf(b()) });
    if (paramBoolean)
    {
      a(false, getActivity(), null);
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment
 * JD-Core Version:    0.7.0.1
 */