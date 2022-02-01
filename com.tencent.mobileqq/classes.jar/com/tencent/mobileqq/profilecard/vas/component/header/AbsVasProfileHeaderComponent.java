package com.tencent.mobileqq.profilecard.vas.component.header;

import SummaryCardTaf.SSummaryCardRsp;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;

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
  
  private void dismissDialog()
  {
    if ((this.mSettingDialog != null) && (this.mSettingDialog.isShowing())) {}
    try
    {
      this.mSettingDialog.dismiss();
      label24:
      this.mSettingDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private String getMyCoverType()
  {
    if (!TextUtils.isEmpty(this.mMyCoverType)) {
      return this.mMyCoverType;
    }
    ThreadManager.post(new AbsVasProfileHeaderComponent.6(this), 8, null, true);
    return "-1";
  }
  
  private void handleJueBanClick()
  {
    ProfileCardUtil.a(this.mActivity, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.strActiveUrl);
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "0", "", "", "");
      return;
    }
    ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "1", "", "", "");
  }
  
  private void handleTemplateHeaderClick(String paramString)
  {
    if (((this.mHeaderView instanceof ProfileBaseView)) || (this.mApp == null)) {
      return;
    }
    String str = this.mApp.getCurrentAccountUin();
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(str))
    {
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", "", VipUtils.a(this.mApp, str));
      ownerTemplateHeaderClick(str);
      return;
    }
    visitorTemplateHeaderClick(paramString, str);
    ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileActivity.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", VipUtils.a(this.mApp, str));
    str = this.mActivity.getString(2131717094);
    ReportController.b(this.mApp, "dc00898", "", "", "", "0X800A4C0", 0, 0, "", "", "", "");
    ActionSheet localActionSheet = ActionSheet.create(this.mActivity);
    localActionSheet.addButton(2131717231, 1);
    localActionSheet.addButton(str, 1);
    localActionSheet.addButton(2131690800, 1);
    localActionSheet.setOnButtonClickListener(new AbsVasProfileHeaderComponent.5(this, localActionSheet, paramString));
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void ownerTemplateHeaderClick(String paramString)
  {
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.j) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.i)) {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_owner", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
    }
    String str;
    StringBuilder localStringBuilder;
    if (((ProfileCardInfo)this.mData).b)
    {
      str = this.mApp.getCurrentAccountUin();
      localStringBuilder = new StringBuilder().append("");
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label202;
      }
    }
    label202:
    for (int i = 1;; i = 2)
    {
      VasWebviewUtil.reportCommercialDrainage(str, "group_card", "click_cover", "", 0, 0, 0, "", "", i, "", "", "", "", 0, 0, 0, 0);
      ProfileCardUtil.a(this.mActivity, paramString, "inside.myCardBackground", 1, 0, 1, "", true);
      return;
    }
  }
  
  private boolean saveCardId2DB(long paramLong1, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, long paramLong2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.a(this.mActivity.getCurrentAccountUin());
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
    ProfileCardUtil.a(this.mApp, paramLong1, paramLong2, null, paramLong3, paramString);
    this.mUIHandler.postDelayed(this.mDismissRunnable, 30000L);
  }
  
  private void showOpenVipPromptDialog()
  {
    String str1;
    String str2;
    if (!this.mActivity.isFinishing())
    {
      cancelOpenVipPromptDialog();
      if (this.needType != 1) {
        break label76;
      }
      str1 = this.mActivity.getString(2131695087);
      str2 = HardCodeUtil.a(2131704948);
    }
    for (;;)
    {
      this.mOpenVipServicePromptDialog = DialogUtil.a(this.mActivity, 0, str1, str2, 2131695078, 2131695079, this.mRightButtonClickListener, this.mLeftButtonClickListener);
      this.mOpenVipServicePromptDialog.show();
      return;
      label76:
      if (this.needType == 2)
      {
        str1 = this.mActivity.getString(2131695080);
        str2 = HardCodeUtil.a(2131704954);
      }
      else if (this.needType == 3)
      {
        str1 = this.mActivity.getString(2131698667);
        str2 = HardCodeUtil.a(2131704926);
      }
      else if (this.needType == 4)
      {
        str1 = this.mActivity.getString(2131719906);
        str2 = "开通QQ大会员即可使用该名片";
      }
      else
      {
        str1 = this.mActivity.getString(2131695080);
        str2 = HardCodeUtil.a(2131704958);
      }
    }
  }
  
  private void showOpenVipPromptDialog(SSummaryCardRsp paramSSummaryCardRsp)
  {
    if (!this.mActivity.isFinishing())
    {
      if (TextUtils.isEmpty(paramSSummaryCardRsp.strActiveCardUrl)) {
        break label150;
      }
      if (!QLog.isColorLevel()) {
        break label98;
      }
      QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to " + paramSSummaryCardRsp.strActiveCardUrl);
    }
    for (;;)
    {
      ProfileCardUtil.a(this.mActivity, paramSSummaryCardRsp.bgid, paramSSummaryCardRsp.strActiveCardUrl);
      return;
      label98:
      QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to url");
    }
    label150:
    cancelOpenVipPromptDialog();
    String str1 = this.mActivity.getString(2131698667);
    String str2 = paramSSummaryCardRsp.emsg;
    int i = paramSSummaryCardRsp.payType;
    String str3 = paramSSummaryCardRsp.aid;
    if ((TextUtils.isEmpty(str3)) || (i <= 0) || (i == 3) || (i > 7))
    {
      QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " and aid=" + str3 + " pay type=" + i);
      Toast.makeText(this.mActivity, 2131695140, 0).show();
      return;
    }
    QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card show:" + str2 + " and aid=" + str3 + " pay type=" + i);
    this.mOpenVipServicePromptDialog = DialogUtil.a(this.mActivity, 0, str1, str2, 2131695078, 2131695079, new AbsVasProfileHeaderComponent.7(this, str3, i), this.mLeftButtonClickListener);
    this.mOpenVipServicePromptDialog.show();
  }
  
  private void showProgressDialog()
  {
    try
    {
      if (!this.mActivity.isFinishing())
      {
        this.mSettingDialog = new QQProgressDialog(this.mActivity);
        this.mSettingDialog.setCancelable(false);
        this.mSettingDialog.c(2131695142);
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
      if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.j) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_visitor", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
      }
    }
    while (!"CLICK_BANNER".equals(paramString1)) {
      return;
    }
    ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", VipUtils.a(this.mApp, paramString2));
  }
  
  protected void cancelOpenVipPromptDialog()
  {
    if (this.mOpenVipServicePromptDialog != null)
    {
      this.mOpenVipServicePromptDialog.dismiss();
      this.mOpenVipServicePromptDialog = null;
    }
  }
  
  public final int getComponentType()
  {
    return 1002;
  }
  
  public void handleSubMessage(Message paramMessage)
  {
    super.handleSubMessage(paramMessage);
  }
  
  public void handleUIMessage(Message paramMessage)
  {
    super.handleUIMessage(paramMessage);
    if (paramMessage.what == 13)
    {
      if (!((Boolean)paramMessage.obj).booleanValue()) {
        break label106;
      }
      paramMessage = new ProfileActivity.AllInOne(this.mApp.getCurrentAccountUin(), 0);
      paramMessage.jdField_h_of_type_JavaLangString = this.mApp.getCurrentNickname();
      paramMessage.g = 1;
      paramMessage.jdField_h_of_type_Int = 5;
      if ((this.mData != null) && (!((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.mApp.getCurrentAccountUin()))) {
        ProfileActivity.a(this.mActivity, paramMessage);
      }
    }
    return;
    label106:
    Toast.makeText(this.mActivity.getApplicationContext(), 2131695143, 0).show();
  }
  
  public boolean hasPhotoWall()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = new Intent(this.mActivity, FriendProfileCardActivity.class);
    paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(this.mApp.getCurrentAccountUin(), 0));
    paramIntent.putExtra("diyTextEditResult", true);
    this.mActivity.startActivity(paramIntent);
    this.mActivity.finish();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof DataTag)) {
      localObject = (DataTag)paramView.getTag();
    }
    switch (((DataTag)localObject).jdField_a_of_type_Int)
    {
    default: 
    case 34: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        handleJueBanClick();
      }
    case 29: 
      if (!(((DataTag)localObject).jdField_a_of_type_JavaLangObject instanceof String)) {
        break;
      }
    }
    for (Object localObject = (String)((DataTag)localObject).jdField_a_of_type_JavaLangObject;; localObject = "CLICK_HEADER_BG")
    {
      handleTemplateHeaderClick((String)localObject);
      break;
      VipQidHelper.a(this.mActivity, (ProfileCardInfo)this.mData);
      break;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent
 * JD-Core Version:    0.7.0.1
 */