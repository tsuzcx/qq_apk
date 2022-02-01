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
  private LinearLayoutManager jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager = new InterestSwitchEditActivity.3(this, this);
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ProfileConfig jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig = null;
  private CardSettingHandler jdField_a_of_type_ComTencentMobileqqProfilesettingCardSettingHandler;
  private CardSettingObserver jdField_a_of_type_ComTencentMobileqqProfilesettingCardSettingObserver = new InterestSwitchEditActivity.1(this);
  private ProfileBasePrivacySettingAdapter.PrivacySettingClickListener jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter$PrivacySettingClickListener = new InterestSwitchEditActivity.2(this);
  private ProfileBasePrivacySettingAdapter jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter;
  private ArrayList<ProfileDisplaySettingItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private int a(ProfileDisplaySettingItem paramProfileDisplaySettingItem)
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
  
  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, InterestSwitchEditActivity.class);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Object localObject = ProfileSettingUtils.a.a(42505, this.jdField_a_of_type_JavaUtilArrayList);
      int i = ProfileSettingUtils.a.a(42505, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.app);
      if (localObject != null)
      {
        localObject = this.app;
        if (i == 1) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B5F0", "0X800B5F0", i, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt, ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    int i = a(paramProfileDisplaySettingItem);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800B1D8", "0X800B1D8", i, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800B1D9", "0X800B1D9", i, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800B1D7", "0X800B1D7", i, 0, "", "", "", "");
  }
  
  private void a(ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    QQAppInterface localQQAppInterface;
    int i;
    switch (paramProfileDisplaySettingItem.b())
    {
    default: 
    case 42425: 
      if (!paramProfileDisplaySettingItem.b())
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B479", "0X800B479", 0, 0, "", "", "", "");
        return;
      }
      break;
    case 42377: 
      ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileSettingBtnClick(paramProfileDisplaySettingItem.b());
      return;
    case 42356: 
      ReportController.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
      return;
    case 42340: 
      localQQAppInterface = this.app;
      if (paramProfileDisplaySettingItem.b()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
      return;
    case 42172: 
      if (paramProfileDisplaySettingItem.b())
      {
        ReportController.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      return;
    case 42128: 
      localQQAppInterface = this.app;
      if (paramProfileDisplaySettingItem.b()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
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
      this.jdField_a_of_type_ComTencentMobileqqProfilesettingCardSettingHandler.b(localArrayList);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b(ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    RecyclerView localRecyclerView = (RecyclerView)View.inflate(this, 2131561326, null);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    ActionSheetPrivacySelectAdapter localActionSheetPrivacySelectAdapter = new ActionSheetPrivacySelectAdapter(this, paramProfileDisplaySettingItem);
    localActionSheetPrivacySelectAdapter.a(new InterestSwitchEditActivity.4(this, paramProfileDisplaySettingItem, localActionSheet));
    paramProfileDisplaySettingItem = new ArrayList();
    paramProfileDisplaySettingItem.add(new ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean(0, getString(2131695086)));
    paramProfileDisplaySettingItem.add(new ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean(1, getString(2131695103)));
    paramProfileDisplaySettingItem.add(new ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean(2, getString(2131695104)));
    localActionSheetPrivacySelectAdapter.a(paramProfileDisplaySettingItem);
    localRecyclerView.setAdapter(localActionSheetPrivacySelectAdapter);
    localActionSheet.addView(localRecyclerView);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setRoundCornerTop(true);
    if (!isFinishing()) {
      localActionSheet.show();
    }
  }
  
  private void c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ProfileDisplaySettingItem localProfileDisplaySettingItem = (ProfileDisplaySettingItem)localIterator.next();
      if (localProfileDisplaySettingItem.b() != -1) {
        localArrayList.add(Integer.valueOf(localProfileDisplaySettingItem.b()));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilesettingCardSettingHandler.a(localArrayList);
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
    super.setContentView(2131561325);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilesettingCardSettingObserver);
    setTitle(getString(2131695059));
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)findViewById(2131363443));
    this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter = new ProfileBasePrivacySettingAdapter(this, this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter$PrivacySettingClickListener);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig = new ProfileConfig(this.app, null);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig.isSwitchEnable(11);
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileSettingExposure(bool);
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.app.getCurrentUin());
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ProfileSettingUtils.a.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig, this.jdField_a_of_type_JavaUtilArrayList);
    a();
    bool = ProfileSettingUtils.a.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqProfilesettingCardSettingHandler = ((CardSettingHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER));
    if (bool) {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        QQToast.a(BaseApplicationImpl.sApplication, 2131694422, 0).b(getTitleBarHeight());
      } else {
        c();
      }
    }
    b();
    if (QLog.isColorLevel()) {
      QLog.i("InterestSwitchEditActivity", 2, String.format("doOnCreate needReq=%s items=%s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_JavaUtilArrayList }));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ProfileConfig localProfileConfig = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig;
    if (localProfileConfig != null)
    {
      localProfileConfig.destroy();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilesettingCardSettingObserver);
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
    localIntent.putExtra("param_switches_changed", Boolean.valueOf(ProfileSettingUtils.a.b(this.jdField_a_of_type_JavaUtilArrayList)));
    ProfileDisplaySettingItem localProfileDisplaySettingItem = ProfileSettingUtils.a.a(42377, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localProfileDisplaySettingItem != null) && (localProfileDisplaySettingItem.a()) && (localProfileDisplaySettingItem.b())) {
      localIntent.putExtra("key_weishi_switch", true);
    }
    localProfileDisplaySettingItem = ProfileSettingUtils.a.a(42128, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localProfileDisplaySettingItem != null) && (localProfileDisplaySettingItem.a())) {
      localIntent.putExtra("key_personality_label_switch", localProfileDisplaySettingItem.b());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */