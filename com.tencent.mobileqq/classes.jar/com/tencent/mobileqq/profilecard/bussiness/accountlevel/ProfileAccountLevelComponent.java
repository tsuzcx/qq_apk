package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import QQService.EVIPSPEC;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class ProfileAccountLevelComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfileAccountLevelComponent";
  private ProfileCardInfo mCardInfo;
  private CardObserver mCardObserver = new ProfileAccountLevelComponent.1(this);
  private boolean mDarenIconEnable;
  protected boolean mIsFromArkBabyQ;
  private long mLastGoToQQVipWebTime;
  
  public ProfileAccountLevelComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
    this.mCardInfo = paramProfileCardInfo;
  }
  
  private void getLoginDaySwitch()
  {
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.mApp, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getLoginDaysSwitch(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void gotoQQVipWeb(int paramInt)
  {
    Object localObject2;
    Object localObject1;
    String str1;
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 40) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
    {
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      localObject1 = "qita";
      if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.mApp.getCurrentAccountUin().equals(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label564;
      }
      str1 = IndividuationUrlHelper.a("vipPersonalCardMaster");
      label111:
      if (this.mApp.getCurrentAccountUin().equals(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label591;
      }
    }
    label181:
    label585:
    label591:
    for (String str2 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; str2 = "0")
    {
      StringBuilder localStringBuilder = new StringBuilder(str1);
      if (str1.contains("?"))
      {
        localStringBuilder.append("&platform=1");
        localStringBuilder.append("&qq=").append(str2);
        localStringBuilder.append("&adtag=").append((String)localObject1);
        localStringBuilder.append("&aid=").append((String)localObject2);
        if (paramInt == 1) {
          localStringBuilder.append("&jumplevelset=1");
        }
        localObject1 = localStringBuilder.toString();
        long l = System.currentTimeMillis();
        if (ProfileActivity.a(this.mLastGoToQQVipWebTime, l))
        {
          this.mLastGoToQQVipWebTime = l;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileAccountLevelComponent", 2, String.format("gotoQQVipWeb url=%s", new Object[] { localObject1 }));
          }
          localObject2 = new Intent(this.mActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("uin", this.mApp.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.mActivity.startActivity((Intent)localObject2);
          localObject1 = this.mApp;
          if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label585;
          }
        }
      }
      for (paramInt = 23;; paramInt = 24)
      {
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "vip", "logo_in", paramInt, 0, "", "", "", "");
        return;
        if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
          localObject1 = "geren";
          break;
        }
        if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
          localObject1 = "qun";
          break;
        }
        if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
          localObject1 = "taolunzu";
          break;
        }
        if (ProfileActivity.AllInOne.h(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
          localObject1 = "qita";
          break;
        }
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
        localObject1 = "qita";
        break;
        str1 = IndividuationUrlHelper.a("vipPersonalCardCustom");
        break label111;
        localStringBuilder.append("?platform=1");
        break label181;
      }
    }
  }
  
  private boolean makeOrRefreshAccountLevel(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = needShowAccountLevel(paramCard);
    boolean bool3 = this.mConfigHelper.a(12);
    boolean bool4 = ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountLevelComponent", 2, String.format("makeOrRefreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s isDefaultProfile=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
    }
    if ((!bool2) || ((bool3) && (bool4)))
    {
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return true;
      }
    }
    else
    {
      if (this.mViewContainer == null)
      {
        View localView = this.mDiyHelper.getDiyView(getProfileContentKey());
        paramCard = localView;
        if (localView == null)
        {
          paramCard = this.mActivity.getLayoutInflater().inflate(2131561531, null);
          ProfileAccountLevelReport.reportAccountLevelVisible(this.mApp, (ProfileCardInfo)this.mData);
        }
        this.mViewContainer = paramCard;
      }
      for (;;)
      {
        paramCard = (ProfileQQLevelView)((View)this.mViewContainer).findViewById(2131374727);
        paramCard.update((ProfileCardInfo)this.mData, this.mIsFromArkBabyQ);
        paramCard.setClickable(false);
        updateDarenView();
        updateNumPAGView();
        updateNoticeView(paramBoolean);
        ((View)this.mViewContainer).setTag(new DataTag(69, null));
        ((View)this.mViewContainer).setOnClickListener(this);
        paramCard = (ImageView)((View)this.mViewContainer).findViewById(2131363027);
        updateItemTheme((View)this.mViewContainer, null, null, paramCard);
        return bool1;
        bool1 = false;
      }
    }
    return false;
  }
  
  private void updateNoticeView(boolean paramBoolean)
  {
    if ((QQLevelIconProcessor.c().mIsNotifyPayment) && (paramBoolean) && (LocaleManager.a()))
    {
      Object localObject = (VasExtensionManager)this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER);
      int i = ((VasExtensionManager)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelComponent", 2, String.format("updateNoticeView noticeValue=%s", new Object[] { Integer.valueOf(i) }));
      }
      if ((i != 0) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
      {
        String str = VasExtensionManager.a(i);
        if (!TextUtils.isEmpty(str))
        {
          ((VasExtensionManager)localObject).a(0);
          localObject = (TextView)((View)this.mViewContainer).findViewById(2131374726);
          ((TextView)localObject).setText(str);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setOnClickListener(new ProfileAccountLevelComponent.2(this, (TextView)localObject, i));
        }
      }
    }
  }
  
  public String getComponentName()
  {
    return "ProfileAccountLevelComponent";
  }
  
  public int getComponentType()
  {
    return 1021;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_account_level_info";
  }
  
  protected void handleAccountLevelClick()
  {
    gotoQQVipWeb(0);
    int j = VipInfoHandler.a(this.mApp, this.mApp.getCurrentUin(), false);
    int i;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType == 0) {
        i = 99999;
      }
    }
    for (;;)
    {
      ReportController.b(this.mApp, "dc00898", "", "", "0X800A8C1", "0X800A8C1", j, 0, String.valueOf(j), "", "", "");
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break;
      }
      ReportController.b(this.mApp, "CliOper", "", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A775", i, 0, "", "", "", "");
      return;
      i = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType;
      continue;
      i = 99999;
    }
    ReportController.b(this.mApp, "CliOper", "", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A774", i, 0, "", "", "", "");
    ReportController.b(this.mApp, "dc00898", "", "", "0X800A8C2", "0X800A8C2", j, 0, String.valueOf(j), "", "", "");
  }
  
  protected void handleDarenIconClick()
  {
    ReportController.b(this.mApp, "CliOper", "", "", "0X800A9C2", "0X800A9C2", 0, 0, "", "", "", "");
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      gotoQQVipWeb(0);
      return;
    }
    Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.mApp.getCurrentAccountUin());
    localIntent.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=card");
    localIntent.putExtra("hide_more_button", true);
    this.mActivity.startActivity(localIntent);
  }
  
  protected void handleVipNumPagViewClick(View paramView, String paramString)
  {
    if ((paramView instanceof QQValuePagView)) {
      ((QQValuePagView)paramView).a("card", paramString);
    }
  }
  
  protected boolean needShowAccountLevel(Card paramCard)
  {
    boolean bool5;
    boolean bool4;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (this.mIsFromArkBabyQ)
    {
      bool5 = false;
      bool4 = false;
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelComponent", 2, String.format("makeOrRefreshAccountLevelInfoView showAccountInfo=%s vipOpen=%s superVipOpen=%s enterprise=%s prettyNumber=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
      }
      return bool3;
      if (paramCard != null)
      {
        bool1 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
        bool2 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
        if ((paramCard.lUserFlag & 1L) == 1L)
        {
          bool4 = true;
          label117:
          if ((paramCard.lUserFlag & 0x400) != 1024L) {
            break label175;
          }
        }
        boolean bool6;
        label175:
        for (bool5 = true;; bool5 = false)
        {
          if (!ProfileActivity.AllInOne.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            break label181;
          }
          bool3 = bool2;
          bool2 = bool1;
          bool6 = true;
          bool1 = bool3;
          bool3 = bool6;
          break;
          bool4 = false;
          break label117;
        }
        label181:
        if ((bool2) || (bool1) || (paramCard.iQQLevel >= 0))
        {
          bool3 = bool2;
          bool2 = bool1;
          bool6 = true;
          bool1 = bool3;
          bool3 = bool6;
        }
        else
        {
          bool3 = bool2;
          bool2 = bool1;
          bool6 = false;
          bool1 = bool3;
          bool3 = bool6;
        }
      }
      else
      {
        bool5 = false;
        bool4 = false;
        bool1 = false;
        bool2 = false;
        bool3 = false;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    int i = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag)) {
      switch (((DataTag)localObject).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      handleDarenIconClick();
      if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
      {
        if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          i = 1;
          label103:
          localObject = this.mApp;
          if (i == 0) {
            break label129;
          }
        }
        label129:
        for (i = 2;; i = 4)
        {
          ProfileAccountLevelReport.reportAccountDarenClick((QQAppInterface)localObject, i);
          break;
          i = 0;
          break label103;
        }
        handleAccountLevelClick();
        if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
        {
          if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            label167:
            localObject = this.mApp;
            if (i == 0) {
              break label193;
            }
          }
          label193:
          for (i = j;; i = 4)
          {
            ProfileAccountLevelReport.reportAccountLevelClick((QQAppInterface)localObject, i);
            break;
            i = 0;
            break label167;
          }
          if ((this.mCardInfo != null) && (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
            handleVipNumPagViewClick(paramView, this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          }
        }
      }
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null) {
      this.mIsFromArkBabyQ = paramBaseActivity.getBooleanExtra("key_from_ark_babyq", false);
    }
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.mCardObserver);
      getLoginDaySwitch();
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    this.mCardInfo = paramProfileCardInfo;
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshAccountLevel(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
  
  public void onDestroy()
  {
    QQValueInfoManage.a().a("card");
    if (this.mApp != null) {
      this.mApp.removeObserver(this.mCardObserver);
    }
    super.onDestroy();
  }
  
  protected void updateDarenView()
  {
    FrameLayout localFrameLayout;
    if (this.mViewContainer != null)
    {
      localFrameLayout = (FrameLayout)((View)this.mViewContainer).findViewById(2131365534);
      if (localFrameLayout != null)
      {
        localFrameLayout.setOnClickListener(this);
        localFrameLayout.setTag(new DataTag(100, null));
        if (!this.mDarenIconEnable) {
          break label60;
        }
        localFrameLayout.setVisibility(0);
      }
    }
    return;
    label60:
    localFrameLayout.setVisibility(8);
  }
  
  protected void updateNumPAGView()
  {
    if (this.mViewContainer != null)
    {
      ViewGroup localViewGroup = (ViewGroup)((View)this.mViewContainer).findViewById(2131372696);
      if (localViewGroup != null)
      {
        localViewGroup.setOnClickListener(this);
        localViewGroup.setTag(new DataTag(104, null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent
 * JD-Core Version:    0.7.0.1
 */