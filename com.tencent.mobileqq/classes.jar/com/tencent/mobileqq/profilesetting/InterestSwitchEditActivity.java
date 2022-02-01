package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  private RecyclerView a;
  private ProfileBasePrivacySettingAdapter b;
  private CardSettingHandler c;
  private Card d;
  private ProfileConfig e = null;
  private ArrayList<ProfileDisplaySettingItem> f = new ArrayList();
  private CardSettingObserver g = new InterestSwitchEditActivity.1(this);
  private ProfileBasePrivacySettingAdapter.PrivacySettingClickListener h = new InterestSwitchEditActivity.2(this);
  private LinearLayoutManager i = new InterestSwitchEditActivity.3(this, this);
  
  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, InterestSwitchEditActivity.class);
  }
  
  private void a()
  {
    if (this.f != null)
    {
      Object localObject = ProfileSettingUtils.a.a(42505, this.f);
      int j = ProfileSettingUtils.a.a(42505, this.d, this.app);
      if (localObject != null)
      {
        localObject = this.app;
        if (j == 1) {
          j = 1;
        } else {
          j = 2;
        }
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B5F0", "0X800B5F0", j, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt, ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    int j = d(paramProfileDisplaySettingItem);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800B1D8", "0X800B1D8", j, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D9", "0X800B1D9", j, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800B1D7", "0X800B1D7", j, 0, "", "", "", "");
  }
  
  private void a(ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    QQAppInterface localQQAppInterface;
    int j;
    switch (paramProfileDisplaySettingItem.b())
    {
    default: 
    case 42425: 
      if (!paramProfileDisplaySettingItem.h())
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B479", "0X800B479", 0, 0, "", "", "", "");
        return;
      }
      break;
    case 42377: 
      ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileSettingBtnClick(paramProfileDisplaySettingItem.h());
      return;
    case 42356: 
      ReportController.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
      return;
    case 42340: 
      localQQAppInterface = this.app;
      if (paramProfileDisplaySettingItem.h()) {
        j = 1;
      } else {
        j = 2;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A7DA", "qq_vip", j, 0, "", "", "", "");
      return;
    case 42172: 
      if (paramProfileDisplaySettingItem.h())
      {
        ReportController.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      return;
    case 42128: 
      localQQAppInterface = this.app;
      if (paramProfileDisplaySettingItem.h()) {
        j = 1;
      } else {
        j = 2;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", j, 0, "", "", "", "");
    }
  }
  
  private void a(ProfileDisplaySettingItem paramProfileDisplaySettingItem, int paramInt)
  {
    if ((paramProfileDisplaySettingItem != null) && (paramProfileDisplaySettingItem.b() != -1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ReqSetSettingItem(paramProfileDisplaySettingItem.b(), paramProfileDisplaySettingItem.e(), paramInt));
      paramProfileDisplaySettingItem.c(paramInt);
      paramProfileDisplaySettingItem.a(true);
      this.c.b(localArrayList);
    }
  }
  
  private void b()
  {
    this.b.a(this.f);
  }
  
  private void b(ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    RecyclerView localRecyclerView = (RecyclerView)View.inflate(this, 2131627682, null);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    ActionSheetPrivacySelectAdapter localActionSheetPrivacySelectAdapter = new ActionSheetPrivacySelectAdapter(this, paramProfileDisplaySettingItem);
    localActionSheetPrivacySelectAdapter.a(new InterestSwitchEditActivity.4(this, paramProfileDisplaySettingItem, localActionSheet));
    paramProfileDisplaySettingItem = new ArrayList();
    paramProfileDisplaySettingItem.add(new ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean(0, getString(2131892814)));
    paramProfileDisplaySettingItem.add(new ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean(1, getString(2131892831)));
    paramProfileDisplaySettingItem.add(new ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean(2, getString(2131892832)));
    localActionSheetPrivacySelectAdapter.a(paramProfileDisplaySettingItem);
    localRecyclerView.setAdapter(localActionSheetPrivacySelectAdapter);
    localActionSheet.addView(localRecyclerView);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setRoundCornerTop(true);
    if (!isFinishing()) {
      localActionSheet.show();
    }
  }
  
  private void c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      ProfileDisplaySettingItem localProfileDisplaySettingItem = (ProfileDisplaySettingItem)localIterator.next();
      if (localProfileDisplaySettingItem.b() != -1) {
        localArrayList.add(Integer.valueOf(localProfileDisplaySettingItem.b()));
      }
    }
    this.c.a(localArrayList);
  }
  
  private void c(ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    switch (paramProfileDisplaySettingItem.b())
    {
    default: 
      return;
    case 41623: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D4", "0X800B1D4", 0, 0, "", "", "", "");
      return;
    case 41622: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D3", "0X800B1D3", 0, 0, "", "", "", "");
      return;
    case 41619: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1CE", "0X800B1CE", 0, 0, "", "", "", "");
      return;
    case 41618: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1CF", "0X800B1CF", 0, 0, "", "", "", "");
      return;
    case 41614: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D1", "0X800B1D1", 0, 0, "", "", "", "");
      return;
    case 41613: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D2", "0X800B1D2", 0, 0, "", "", "", "");
      return;
    case 41611: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1CC", "0X800B1CC", 0, 0, "", "", "", "");
      return;
    case 41610: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D5", "0X800B1D5", 0, 0, "", "", "", "");
      return;
    case 41609: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D6", "0X800B1D6", 0, 0, "", "", "", "");
      return;
    case 41607: 
      ReportController.b(this.app, "dc00898", "", "", "0X800B1CD", "0X800B1CD", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800B1D0", "0X800B1D0", 0, 0, "", "", "", "");
  }
  
  private int d(ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    if (paramProfileDisplaySettingItem == null) {
      return -1;
    }
    switch (paramProfileDisplaySettingItem.b())
    {
    default: 
      return -1;
    case 41623: 
      return 10;
    case 41622: 
      return 9;
    case 41619: 
      return 4;
    case 41618: 
      return 5;
    case 41614: 
      return 7;
    case 41613: 
      return 8;
    case 41611: 
      return 1;
    case 41610: 
      return 2;
    case 41609: 
      return 3;
    case 41607: 
      return 11;
    }
    return 6;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627681);
    this.app.addObserver(this.g);
    setTitle(getString(2131892787));
    this.a = ((RecyclerView)findViewById(2131429341));
    this.b = new ProfileBasePrivacySettingAdapter(this, this.h);
    this.a.setLayoutManager(this.i);
    this.a.setAdapter(this.b);
    this.e = new ProfileConfig(this.app, null);
    boolean bool = this.e.isSwitchEnable(11);
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileSettingExposure(bool);
    this.d = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.app.getCurrentUin());
    this.f.clear();
    ProfileSettingUtils.a.a(this.app, this.d, this.e, this.f);
    a();
    bool = ProfileSettingUtils.a.a(this.f);
    this.c = ((CardSettingHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER));
    if (bool) {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show(getTitleBarHeight());
      } else {
        c();
      }
    }
    b();
    if (QLog.isColorLevel()) {
      QLog.i("InterestSwitchEditActivity", 2, String.format("doOnCreate needReq=%s items=%s", new Object[] { Boolean.valueOf(bool), this.f }));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ProfileConfig localProfileConfig = this.e;
    if (localProfileConfig != null)
    {
      localProfileConfig.destroy();
      this.e = null;
    }
    this.app.removeObserver(this.g);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileSettingPageVisitExit();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileSettingPageVisitEnter();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_switches_changed", Boolean.valueOf(ProfileSettingUtils.a.b(this.f)));
    ProfileDisplaySettingItem localProfileDisplaySettingItem = ProfileSettingUtils.a.a(42377, this.f);
    if ((localProfileDisplaySettingItem != null) && (localProfileDisplaySettingItem.f()) && (localProfileDisplaySettingItem.h())) {
      localIntent.putExtra("key_weishi_switch", true);
    }
    localProfileDisplaySettingItem = ProfileSettingUtils.a.a(42128, this.f);
    if ((localProfileDisplaySettingItem != null) && (localProfileDisplaySettingItem.f())) {
      localIntent.putExtra("key_personality_label_switch", localProfileDisplaySettingItem.h());
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */