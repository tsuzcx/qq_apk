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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QQLevelIconProcessor;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class ProfileAccountLevelComponent
  extends AbsQQProfileContentComponent
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
      localTempGetProfileDetailProcessor.getLoginDaysSwitch(((ProfileCardInfo)this.mData).allInOne.uin);
    }
  }
  
  private void gotoQQVipWeb(int paramInt)
  {
    int i = ((ProfileCardInfo)this.mData).allInOne.pa;
    Object localObject1 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
    String str1 = "qita";
    Object localObject2;
    if ((i != 40) && (((ProfileCardInfo)this.mData).allInOne.pa != 41) && (((ProfileCardInfo)this.mData).allInOne.pa != 58))
    {
      if ((((ProfileCardInfo)this.mData).allInOne.pa != 1) && (((ProfileCardInfo)this.mData).allInOne.pa != 0))
      {
        if ((((ProfileCardInfo)this.mData).allInOne.pa != 20) && (((ProfileCardInfo)this.mData).allInOne.pa != 21))
        {
          if (((ProfileCardInfo)this.mData).allInOne.pa == 46)
          {
            localObject1 = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
            localObject2 = "taolunzu";
          }
          else
          {
            localObject2 = str1;
            if (ProfilePAUtils.isPaTypeTempTalk(((ProfileCardInfo)this.mData).allInOne))
            {
              localObject1 = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
              localObject2 = str1;
            }
          }
        }
        else
        {
          localObject1 = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
          localObject2 = "qun";
        }
      }
      else {
        localObject2 = "geren";
      }
    }
    else
    {
      localObject1 = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      localObject2 = str1;
    }
    if ((((ProfileCardInfo)this.mData).allInOne.pa != 0) && (!this.mApp.getCurrentAccountUin().equals(((ProfileCardInfo)this.mData).allInOne.uin))) {
      str1 = IndividuationUrlHelper.a("vipPersonalCardCustom");
    } else {
      str1 = IndividuationUrlHelper.a("vipPersonalCardMaster");
    }
    String str2;
    if (!this.mApp.getCurrentAccountUin().equals(((ProfileCardInfo)this.mData).allInOne.uin)) {
      str2 = ((ProfileCardInfo)this.mData).allInOne.uin;
    } else {
      str2 = "0";
    }
    StringBuilder localStringBuilder = new StringBuilder(str1);
    if (str1.contains("?")) {
      localStringBuilder.append("&platform=1");
    } else {
      localStringBuilder.append("?platform=1");
    }
    localStringBuilder.append("&qq=");
    localStringBuilder.append(str2);
    localStringBuilder.append("&adtag=");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("&aid=");
    localStringBuilder.append((String)localObject1);
    if (paramInt == 1) {
      localStringBuilder.append("&jumplevelset=1");
    }
    localObject1 = localStringBuilder.toString();
    long l = System.currentTimeMillis();
    if (ProfileUtils.isValidClick(this.mLastGoToQQVipWebTime, l))
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
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        paramInt = 23;
      } else {
        paramInt = 24;
      }
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "vip", "logo_in", paramInt, 0, "", "", "", "");
    }
  }
  
  private boolean makeOrRefreshAccountLevel(Card paramCard, boolean paramBoolean)
  {
    boolean bool3 = needShowAccountLevel(paramCard);
    boolean bool4 = this.mConfigHelper.isSwitchEnable(12);
    boolean bool5 = ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData);
    boolean bool6 = QLog.isColorLevel();
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool6) {
      QLog.d("ProfileAccountLevelComponent", 2, String.format("makeOrRefreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s isDefaultProfile=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
    }
    if ((bool3) && ((!bool4) || (!bool5)))
    {
      if (this.mViewContainer == null)
      {
        paramCard = this.mActivity.getLayoutInflater().inflate(2131627728, null);
        ProfileAccountLevelReport.reportAccountLevelVisible(this.mQQAppInterface, (ProfileCardInfo)this.mData);
        this.mViewContainer = paramCard;
      }
      else
      {
        bool1 = false;
      }
      paramCard = (ProfileQQLevelView)((View)this.mViewContainer).findViewById(2131442358);
      paramCard.update((ProfileCardInfo)this.mData, this.mIsFromArkBabyQ);
      paramCard.setClickable(false);
      updateDarenView();
      updateNumPAGView();
      updateNoticeView(paramBoolean);
      ((View)this.mViewContainer).setTag(new DataTag(69, null));
      ((View)this.mViewContainer).setOnClickListener(this);
      paramCard = (ImageView)((View)this.mViewContainer).findViewById(2131428774);
      updateItemTheme((View)this.mViewContainer, null, null, paramCard);
    }
    else if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    paramCard = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
    if (paramCard.isDiy())
    {
      ((View)this.mViewContainer).setBackgroundResource(2130839624);
      ((View)this.mViewContainer).setClickable(false);
      paramCard.updateLevelForDeepDiy((View)this.mViewContainer);
    }
    return bool1;
  }
  
  private void updateNoticeView(boolean paramBoolean)
  {
    if ((QQLevelIconProcessor.e().mIsNotifyPayment) && (paramBoolean) && (LocaleManager.a()))
    {
      Object localObject = (VasExtensionManager)this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER);
      int i = ((VasExtensionManager)localObject).b();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelComponent", 2, String.format("updateNoticeView noticeValue=%s", new Object[] { Integer.valueOf(i) }));
      }
      if ((i != 0) && (((ProfileCardInfo)this.mData).allInOne.pa == 0))
      {
        String str = VasExtensionManager.b(i);
        if (!TextUtils.isEmpty(str))
        {
          ((VasExtensionManager)localObject).a(0);
          localObject = (TextView)((View)this.mViewContainer).findViewById(2131442357);
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
    return "map_key_account_level";
  }
  
  protected void handleAccountLevelClick()
  {
    gotoQQVipWeb(0);
    int k = VipInfoHandler.a(this.mQQAppInterface, this.mApp.getCurrentUin(), false);
    Card localCard = ((ProfileCardInfo)this.mData).card;
    int j = 99999;
    int i = j;
    if (localCard != null) {
      if (((ProfileCardInfo)this.mData).card.mQQLevelType == 0) {
        i = j;
      } else {
        i = ((ProfileCardInfo)this.mData).card.mQQLevelType;
      }
    }
    ReportController.b(this.mApp, "dc00898", "", "", "0X800A8C1", "0X800A8C1", k, 0, String.valueOf(k), "", "", "");
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A775", i, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.mApp, "CliOper", "", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A774", i, 0, "", "", "", "");
    ReportController.b(this.mApp, "dc00898", "", "", "0X800A8C2", "0X800A8C2", k, 0, String.valueOf(k), "", "", "");
  }
  
  protected void handleDarenIconClick()
  {
    ReportController.b(this.mApp, "CliOper", "", "", "0X800A9C2", "0X800A9C2", 0, 0, "", "", "", "");
    int i;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
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
    boolean bool3;
    boolean bool4;
    boolean bool1;
    boolean bool2;
    boolean bool5;
    if ((!this.mIsFromArkBabyQ) && (paramCard != null))
    {
      bool3 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool4 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      if ((paramCard.lUserFlag & 1L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((paramCard.lUserFlag & 0x400) == 1024L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool6;
      if (((!ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo)this.mData).allInOne)) || (ProfilePAUtils.isFromGuild(((ProfileCardInfo)this.mData).allInOne.pa))) && (!bool4) && (!bool3) && (paramCard.iQQLevel < 0))
      {
        bool6 = false;
        bool5 = bool1;
        bool1 = bool6;
      }
      else
      {
        bool6 = true;
        bool5 = bool1;
        bool1 = bool6;
      }
    }
    else
    {
      bool1 = false;
      bool3 = false;
      bool4 = false;
      bool5 = false;
      bool2 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountLevelComponent", 2, String.format("makeOrRefreshAccountLevelInfoView showAccountInfo=%s vipOpen=%s superVipOpen=%s enterprise=%s prettyNumber=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool2) }));
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag))
    {
      int m = ((DataTag)localObject).a;
      int i = 2;
      int k = 1;
      int j = 1;
      if (m != 69)
      {
        if (m != 100)
        {
          if (m == 104)
          {
            localObject = this.mCardInfo;
            if ((localObject != null) && (((ProfileCardInfo)localObject).card != null)) {
              handleVipNumPagViewClick(paramView, this.mCardInfo.card.uin);
            }
          }
        }
        else
        {
          handleDarenIconClick();
          if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
          {
            if (((ProfileCardInfo)this.mData).allInOne.pa != 0) {
              j = 0;
            }
            localObject = this.mQQAppInterface;
            if (j == 0) {
              i = 4;
            }
            ProfileAccountLevelReport.reportAccountDarenClick((QQAppInterface)localObject, i);
          }
        }
      }
      else
      {
        handleAccountLevelClick();
        if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
        {
          if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
            j = k;
          } else {
            j = 0;
          }
          localObject = this.mQQAppInterface;
          if (j == 0) {
            i = 4;
          }
          ProfileAccountLevelReport.reportAccountLevelClick((QQAppInterface)localObject, i);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null) {
      this.mIsFromArkBabyQ = paramQBaseActivity.getBooleanExtra("key_from_ark_babyq", false);
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
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshAccountLevel(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
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
    if (this.mViewContainer != null)
    {
      FrameLayout localFrameLayout = (FrameLayout)((View)this.mViewContainer).findViewById(2131431576);
      if (localFrameLayout != null)
      {
        localFrameLayout.setOnClickListener(this);
        localFrameLayout.setTag(new DataTag(100, null));
        if (this.mDarenIconEnable)
        {
          localFrameLayout.setVisibility(0);
          return;
        }
        localFrameLayout.setVisibility(8);
      }
    }
  }
  
  protected void updateNumPAGView()
  {
    if (this.mViewContainer != null)
    {
      ViewGroup localViewGroup = (ViewGroup)((View)this.mViewContainer).findViewById(2131439784);
      if (localViewGroup != null)
      {
        localViewGroup.setOnClickListener(this);
        localViewGroup.setTag(new DataTag(104, null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent
 * JD-Core Version:    0.7.0.1
 */