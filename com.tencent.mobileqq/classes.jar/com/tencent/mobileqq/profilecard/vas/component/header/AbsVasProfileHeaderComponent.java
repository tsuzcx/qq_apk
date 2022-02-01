package com.tencent.mobileqq.profilecard.vas.component.header;

import SummaryCardTaf.SSummaryCardRsp;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;

public abstract class AbsVasProfileHeaderComponent
  extends AbsProfileHeaderComponent
{
  private static final int SET_STYLE_AND_BGW_AIT_TIME = 30000;
  private static final String TAG = "AbsVasProfileHeaderComponent";
  private static final int UI_MSG_SAVE_CARD_RESULT = 13;
  private Runnable mDismissRunnable = new AbsVasProfileHeaderComponent.1(this);
  private DialogInterface.OnClickListener mLeftButtonClickListener = new AbsVasProfileHeaderComponent.3(this);
  private String mMyCoverType = null;
  private QQCustomDialog mOpenVipServicePromptDialog = null;
  private DialogInterface.OnClickListener mRightButtonClickListener = new AbsVasProfileHeaderComponent.2(this);
  private CardObserver mSetCardObserver = new AbsVasProfileHeaderComponent.4(this);
  private QQProgressDialog mSettingDialog;
  private int needType = 0;
  
  public AbsVasProfileHeaderComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void addAnimationListener(String paramString, ActionSheet paramActionSheet)
  {
    paramActionSheet.setOnButtonClickListener(new AbsVasProfileHeaderComponent.5(this, paramString, paramActionSheet));
  }
  
  private boolean checkNeedType(Pair<Integer, SSummaryCardRsp> paramPair)
  {
    if (((Integer)paramPair.first).intValue() == 101107)
    {
      this.needType = 1;
    }
    else if (((Integer)paramPair.first).intValue() == 101108)
    {
      this.needType = 2;
    }
    else if (((Integer)paramPair.first).intValue() == 101111)
    {
      this.needType = 3;
    }
    else
    {
      if (((Integer)paramPair.first).intValue() != 12002) {
        break label92;
      }
      this.needType = 4;
    }
    return false;
    label92:
    this.needType = 5;
    showOpenVipPromptDialog((SSummaryCardRsp)paramPair.second);
    return true;
  }
  
  private void dismissDialog()
  {
    QQProgressDialog localQQProgressDialog = this.mSettingDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.mSettingDialog.dismiss();
      label23:
      this.mSettingDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  private void enterPersonalityCardMall(String paramString)
  {
    if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
      VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) || (((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)) {
      VasWebviewUtil.a("", "card_gameking", "clk_morecard", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentStyleId));
    }
    String str1 = getMyCoverType();
    if ((str1 != null) && (str1.equals("CustomCover"))) {
      str1 = "oldCustom=1";
    } else {
      str1 = "";
    }
    QBaseActivity localQBaseActivity = this.mActivity;
    String str2 = this.mApp.getCurrentAccountUin();
    if (paramString.equals("CLICK_HEADER_BG")) {
      paramString = "inside.friendCardBackground";
    } else {
      paramString = "inside.blackBar";
    }
    ProfileCardUtil.a(localQBaseActivity, str2, paramString, 1, 1, 1, str1, false, 42);
  }
  
  private String getMyCoverType()
  {
    if (!TextUtils.isEmpty(this.mMyCoverType)) {
      return this.mMyCoverType;
    }
    ThreadManager.post(new AbsVasProfileHeaderComponent.6(this), 8, null, true);
    return "-1";
  }
  
  private void handleDiyBackground()
  {
    if ((((ProfileCardInfo)this.mData).card.lCurrentBgId != 160L) && (((ProfileCardInfo)this.mData).card.lCurrentBgId != 1600L) && ((!ProfileCardUtil.e(((ProfileCardInfo)this.mData).card.getBgTypeArray())) || (((ProfileCardInfo)this.mData).card.cardType == 2) || (((ProfileCardInfo)this.mData).card.dynamicCardFlag == 1)))
    {
      if (ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo)this.mData).card.lCurrentStyleId))
      {
        QVipUtils.a(((ProfileCardInfo)this.mData).card, this.mQQAppInterface, this.mActivity);
        ReportController.b(this.mApp, "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
        return;
      }
      if ((!TextUtils.isEmpty(((ProfileCardInfo)this.mData).card.diyText)) && (((ProfileCardInfo)this.mData).card.diyTextFontId != 0))
      {
        if ((this instanceof VasProfileHeaderSimpleComponent)) {
          ((VasProfileHeaderSimpleComponent)this).goToDiyCardEditPage();
        }
      }
      else
      {
        setStyleAndBg(((ProfileCardInfo)this.mData).card.lCurrentStyleId, ((ProfileCardInfo)this.mData).card.lCurrentBgId, ((ProfileCardInfo)this.mData).card.backgroundColor, ((ProfileCardInfo)this.mData).card.strExtInfo);
        ReportController.b(this.mApp, "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
      }
    }
    else
    {
      Toast.makeText(this.mActivity, 2131892858, 0).show();
    }
  }
  
  private void handleJueBanClick()
  {
    ProfileCardUtil.a(this.mActivity, ((ProfileCardInfo)this.mData).card.lCurrentBgId, ((ProfileCardInfo)this.mData).card.strActiveUrl);
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "0", "", "", "");
      return;
    }
    ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "1", "", "", "");
  }
  
  private void handleTemplateHeaderClick(String paramString)
  {
    ActionSheet localActionSheet;
    if (!(this.mHeaderView instanceof ProfileBaseView))
    {
      if (this.mApp == null) {
        return;
      }
      String str = this.mApp.getCurrentAccountUin();
      if (((ProfileCardInfo)this.mData).allInOne.uin.equals(str))
      {
        ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(((ProfileCardInfo)this.mData).card.lCurrentBgId), "", "", VipUtils.a(this.mApp, str));
        ownerTemplateHeaderClick(str);
        return;
      }
      visitorTemplateHeaderClick(paramString, str);
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(((ProfileCardInfo)this.mData).allInOne)), Long.toString(((ProfileCardInfo)this.mData).card.lCurrentBgId), "", VipUtils.a(this.mApp, str));
      str = this.mActivity.getString(2131914225);
      ReportController.b(this.mApp, "dc00898", "", "", "", "0X800A4C0", 0, 0, "", "", "", "");
      localActionSheet = ActionSheet.create(this.mActivity);
      localActionSheet.addButton(2131914363, 1);
      localActionSheet.addButton(str, 1);
      localActionSheet.addButton(2131887648, 1);
      addAnimationListener(paramString, localActionSheet);
    }
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void openVipServicePromptDialog(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.mOpenVipServicePromptDialog = DialogUtil.a(this.mActivity, 0, paramString1, paramString2, 2131892796, 2131892797, new AbsVasProfileHeaderComponent.7(this, paramString3, paramInt), this.mLeftButtonClickListener);
    this.mOpenVipServicePromptDialog.show();
  }
  
  private void ownerTemplateHeaderClick(String paramString)
  {
    if ((((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) || (((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)) {
      VasWebviewUtil.a("", "card_gameking", "clkbkgd_owner", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentStyleId));
    }
    if (((ProfileCardInfo)this.mData).isTroopMemberCard)
    {
      String str = this.mApp.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      int i;
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        i = 1;
      } else {
        i = 2;
      }
      localStringBuilder.append(i);
      VasWebviewUtil.a(str, "group_card", "click_cover", "", 0, 0, 0, "", "", localStringBuilder.toString(), "", "", "", "", 0, 0, 0, 0);
    }
    ProfileCardUtil.a(this.mActivity, paramString, "inside.myCardBackground", 1, 0, 1, "", true, 40);
  }
  
  private boolean saveCardId2DB(long paramLong1, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, long paramLong2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.f(this.mActivity.getAppRuntime().getCurrentAccountUin());
    if ((localCard != null) && (paramLong1 >= 0L))
    {
      localCard.lCurrentStyleId = paramLong1;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString1;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      localCard.cardId = paramLong2;
      if (TextUtils.isEmpty(localCard.diyComplicatedInfo)) {
        localCard.diyComplicatedInfo = paramString2;
      }
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AbsVasProfileHeaderComponent", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void setStyleAndBg(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    dismissDialog();
    showProgressDialog();
    ProfileCardUtil.a(this.mQQAppInterface, paramLong1, paramLong2, null, paramLong3, paramString);
    this.mUIHandler.postDelayed(this.mDismissRunnable, 30000L);
  }
  
  private void showOpenVipPromptDialog()
  {
    if (!this.mActivity.isFinishing())
    {
      cancelOpenVipPromptDialog();
      int i = this.needType;
      String str1;
      String str2;
      if (i == 1)
      {
        str1 = this.mActivity.getString(2131892805);
        str2 = HardCodeUtil.a(2131902914);
      }
      for (;;)
      {
        break;
        if (i == 2)
        {
          str1 = this.mActivity.getString(2131892798);
          str2 = HardCodeUtil.a(2131902920);
        }
        else if (i == 3)
        {
          str1 = this.mActivity.getString(2131896694);
          str2 = HardCodeUtil.a(2131902893);
        }
        else if (i == 4)
        {
          str1 = this.mActivity.getString(2131917239);
          str2 = "开通QQ大会员即可使用该名片";
        }
        else
        {
          str1 = this.mActivity.getString(2131892798);
          str2 = HardCodeUtil.a(2131902924);
        }
      }
      this.mOpenVipServicePromptDialog = DialogUtil.a(this.mActivity, 0, str1, str2, 2131892796, 2131892797, this.mRightButtonClickListener, this.mLeftButtonClickListener);
      this.mOpenVipServicePromptDialog.show();
    }
  }
  
  private void showOpenVipPromptDialog(SSummaryCardRsp paramSSummaryCardRsp)
  {
    if (!this.mActivity.isFinishing())
    {
      if (!TextUtils.isEmpty(paramSSummaryCardRsp.strActiveCardUrl))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("set friend profile card failed code=");
          ((StringBuilder)localObject1).append(paramSSummaryCardRsp.res);
          ((StringBuilder)localObject1).append(" bgid=");
          ((StringBuilder)localObject1).append(paramSSummaryCardRsp.bgid);
          ((StringBuilder)localObject1).append(" and jump to ");
          ((StringBuilder)localObject1).append(paramSSummaryCardRsp.strActiveCardUrl);
          QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, ((StringBuilder)localObject1).toString());
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("set friend profile card failed code=");
          ((StringBuilder)localObject1).append(paramSSummaryCardRsp.res);
          ((StringBuilder)localObject1).append(" bgid=");
          ((StringBuilder)localObject1).append(paramSSummaryCardRsp.bgid);
          ((StringBuilder)localObject1).append(" and jump to url");
          QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, ((StringBuilder)localObject1).toString());
        }
        ProfileCardUtil.a(this.mActivity, paramSSummaryCardRsp.bgid, paramSSummaryCardRsp.strActiveCardUrl);
        return;
      }
      cancelOpenVipPromptDialog();
      Object localObject2 = this.mActivity.getString(2131896694);
      String str = paramSSummaryCardRsp.emsg;
      int i = paramSSummaryCardRsp.payType;
      Object localObject1 = paramSSummaryCardRsp.aid;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i > 0) && (i != 3) && (i <= 7))
      {
        paramSSummaryCardRsp = new StringBuilder();
        paramSSummaryCardRsp.append("set friend profile card show:");
        paramSSummaryCardRsp.append(str);
        paramSSummaryCardRsp.append(" and aid=");
        paramSSummaryCardRsp.append((String)localObject1);
        paramSSummaryCardRsp.append(" pay type=");
        paramSSummaryCardRsp.append(i);
        QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, paramSSummaryCardRsp.toString());
        openVipServicePromptDialog((String)localObject2, str, i, (String)localObject1);
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set friend profile card failed code=");
      ((StringBuilder)localObject2).append(paramSSummaryCardRsp.res);
      ((StringBuilder)localObject2).append(" and aid=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" pay type=");
      ((StringBuilder)localObject2).append(i);
      QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, ((StringBuilder)localObject2).toString());
      Toast.makeText(this.mActivity, 2131892858, 0).show();
    }
  }
  
  private void showProgressDialog()
  {
    try
    {
      if (!this.mActivity.isFinishing())
      {
        this.mSettingDialog = new QQProgressDialog(this.mActivity);
        this.mSettingDialog.setCancelable(false);
        this.mSettingDialog.c(2131892860);
        this.mSettingDialog.show();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void visitorTemplateHeaderClick(String paramString1, String paramString2)
  {
    if ("CLICK_HEADER_BG".equals(paramString1))
    {
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "1", "", "", VipUtils.a(this.mApp, paramString2));
      if ((((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) || (((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)) {
        VasWebviewUtil.a("", "card_gameking", "clkbkgd_visitor", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentStyleId));
      }
    }
    else if ("CLICK_BANNER".equals(paramString1))
    {
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", VipUtils.a(this.mApp, paramString2));
    }
  }
  
  protected void cancelOpenVipPromptDialog()
  {
    QQCustomDialog localQQCustomDialog = this.mOpenVipServicePromptDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.mOpenVipServicePromptDialog = null;
    }
  }
  
  public final int getComponentType()
  {
    return 1002;
  }
  
  protected void handleSubMessage(Message paramMessage)
  {
    super.handleSubMessage(paramMessage);
  }
  
  protected void handleUIMessage(Message paramMessage)
  {
    super.handleUIMessage(paramMessage);
    if (paramMessage.what == 13) {
      if (((Boolean)paramMessage.obj).booleanValue())
      {
        paramMessage = new AllInOne(this.mApp.getCurrentAccountUin(), 0);
        paramMessage.nickname = this.mApp.getCurrentNickname();
        paramMessage.lastActivity = 1;
        paramMessage.profileEntryType = 5;
        if ((this.mData != null) && (!((ProfileCardInfo)this.mData).allInOne.uin.equals(this.mApp.getCurrentAccountUin()))) {
          ProfileUtils.openProfileCard(this.mActivity, paramMessage);
        }
      }
      else
      {
        Toast.makeText(this.mActivity.getApplicationContext(), 2131892861, 0).show();
      }
    }
  }
  
  public boolean hasPhotoWall()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof DataTag))
    {
      Object localObject = (DataTag)paramView.getTag();
      int i = ((DataTag)localObject).a;
      if (i != 29)
      {
        if (i != 34)
        {
          if (i == 105) {
            VipQidHelper.a(this.mActivity, (ProfileCardInfo)this.mData);
          }
        }
        else {
          handleJueBanClick();
        }
      }
      else
      {
        if ((((DataTag)localObject).b instanceof String)) {
          localObject = (String)((DataTag)localObject).b;
        } else {
          localObject = "CLICK_HEADER_BG";
        }
        handleTemplateHeaderClick((String)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mViewContainer != null) {
      ((FrameLayout)this.mViewContainer).setOnClickListener(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.mApp.addObserver(this.mSetCardObserver);
  }
  
  public void onStop()
  {
    super.onStop();
    this.mApp.removeObserver(this.mSetCardObserver);
  }
  
  public void setContainerView(FrameLayout paramFrameLayout)
  {
    super.setContainerView(paramFrameLayout);
    paramFrameLayout.setTag(new DataTag(29, null));
    paramFrameLayout.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent
 * JD-Core Version:    0.7.0.1
 */