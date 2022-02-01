package com.tencent.mobileqq.profilecard.base.container;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.OnCancelAction;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qqexpand.profilecard.IExpandProfileComponentUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;

public class ProfileBottomContainer
  extends AbsQQProfileContainer
  implements View.OnClickListener, IProfileBottomContainer
{
  private static final int BTNS_STYLE_ADD = 6;
  private static final int BTNS_STYLE_ADD_CALL = 5;
  private static final int BTNS_STYLE_ADD_CHAT = 3;
  private static final int BTNS_STYLE_ADD_CHAT_CALL = 2;
  private static final int BTNS_STYLE_CALL = 8;
  private static final int BTNS_STYLE_CHAT = 7;
  private static final int BTNS_STYLE_CHAT_CALL = 4;
  private static final int BTNS_STYLE_EDIT = 1;
  private static final int BTNS_STYLE_NONE = 0;
  private static final int BTNS_STYLE_SAVE = 10;
  private static final int BTNS_STYLE_SAVE_ADD = 11;
  private static final int BTNS_STYLE_TROOP_MEM_SEND_GIFT = 12;
  private static final int BTN_INDEX_BLUE_ONE = 4;
  private static final int BTN_INDEX_EDIT = 1;
  private static final int BTN_INDEX_ICON = 0;
  private static final int BTN_INDEX_SEND_OR_ADD = 2;
  private static final int BTN_INDEX_VIP_CARD = 0;
  private static final int BTN_INDEX_WHITE_ONE = 1;
  private static final int BTN_INDEX_WHITE_THREE = 3;
  private static final int BTN_INDEX_WHITE_TWO = 2;
  private static final int BTN_STYLE_BLUE = 2;
  private static final int BTN_STYLE_ICON = 0;
  private static final int BTN_STYLE_WHITE = 1;
  private static final String GIVE_BUTTON_URL = "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}";
  private static final int[] HANDLE_UPDATE_BTN_GROUP_INNER_TYPE = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12 };
  private static final String KEY_GIVE_GIFT_BUTTON_IN_PROFILE_URL = "give_gift_button_in_profile_url";
  private static final String TAG = "ProfileBottomContainer";
  private Dialog addFriendDialog;
  private LinearLayout mBtnsContainer;
  private boolean mIsFromArkBabyQ;
  private RedTouch mTemplateCardRedTouch;
  private BusinessInfoCheckUpdate.AppInfo mTemplateRedPointInfo;
  
  public ProfileBottomContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public static void addFriend(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo, Dialog paramDialog)
  {
    Object localObject = paramQBaseActivity.getIntent().getBundleExtra("profile_extra");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Bundle)localObject).getBoolean("from_babyq", false)) {
        bool1 = true;
      }
    }
    ProfileBottomContainer.SourceParam localSourceParam = new ProfileBottomContainer.SourceParam();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFriend, begin, sourceParam == ");
      localStringBuilder.append(localSourceParam);
      QLog.i("ProfileBottomContainer", 2, localStringBuilder.toString());
    }
    setSourceParamValue1(paramProfileCardInfo, localSourceParam, bool1);
    setSourceParamValue2(paramProfileCardInfo, localSourceParam, bool1);
    setSourceParamValue3(paramProfileCardInfo, localSourceParam, bool1);
    setSourceParamValue4(paramProfileCardInfo, localSourceParam, bool1);
    setSourceParamValue5(paramProfileCardInfo, localSourceParam, bool1);
    setSourceParamValue6(paramProfileCardInfo, localSourceParam, bool1, (Bundle)localObject);
    setSourceParamValue7(paramProfileCardInfo, localSourceParam, bool1);
    setSourceParamValue8(paramProfileCardInfo, localSourceParam, bool1);
    int i = localSourceParam.sourceId;
    int j = localSourceParam.subSourceId;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addFriend, end, sourceParam == ");
      ((StringBuilder)localObject).append(localSourceParam);
      QLog.i("ProfileBottomContainer", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 3045) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
    }
    if (i == 3094) {
      ReportController.a(paramQQAppInterface, "dc00898", "", paramProfileCardInfo.allInOne.uin, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(j), ExtendFriendReport.d(), ExtendFriendReport.a(paramQQAppInterface), ExtendFriendReport.f());
    }
    if (addFriendSourceFromNearby(paramQQAppInterface, paramQBaseActivity, paramProfileCardInfo, paramDialog, i)) {
      return;
    }
    if (paramProfileCardInfo.card != null) {
      paramQQAppInterface = ProfileCardUtil.a(paramQQAppInterface.getApplicationContext(), paramProfileCardInfo.card.shGender, paramProfileCardInfo.card.age, paramProfileCardInfo.card.strCountry, paramProfileCardInfo.card.strProvince, paramProfileCardInfo.card.strCity);
    } else {
      paramQQAppInterface = "";
    }
    if ((paramProfileCardInfo.allInOne.pa != 32) && (paramProfileCardInfo.allInOne.pa != 31) && (paramProfileCardInfo.allInOne.pa != 51) && (paramProfileCardInfo.allInOne.pa != 50) && (paramProfileCardInfo.allInOne.pa != 34) && (paramProfileCardInfo.allInOne.pa != 36) && (paramProfileCardInfo.allInOne.pa != 53) && (paramProfileCardInfo.allInOne.pa != 29))
    {
      jumpLaunchAddFriendWithCardInfoAndTroop(paramQBaseActivity, paramProfileCardInfo, bool1, i, j, paramQQAppInterface);
      return;
    }
    jumpLaunchAddFriendWithCardInfo(paramQBaseActivity, paramProfileCardInfo, i, j, paramQQAppInterface);
  }
  
  private void addFriendInner()
  {
    boolean bool;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 96) {
      bool = ((IExpandProfileComponentUtils)QRoute.api(IExpandProfileComponentUtils.class)).interceptAddFriend(this.mComponentCenter, (ProfileCardInfo)this.mData);
    } else {
      bool = false;
    }
    if (!bool) {
      addFriend(this.mQQAppInterface, this.mActivity, (ProfileCardInfo)this.mData, this.addFriendDialog);
    }
  }
  
  private static boolean addFriendSourceFromNearby(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo, Dialog paramDialog, int paramInt)
  {
    if ((paramInt == 3007) && (!LBSHandler.a(paramQQAppInterface, paramProfileCardInfo.allInOne.uin)))
    {
      Dialog localDialog = paramDialog;
      if (paramDialog == null) {
        localDialog = LBSHandler.a(paramQBaseActivity, paramQBaseActivity.getString(2131892080), new ProfileBottomContainer.9(paramQQAppInterface, paramQBaseActivity, paramProfileCardInfo), new ProfileBottomContainer.10());
      }
      if ((!localDialog.isShowing()) && (!paramQBaseActivity.isFinishing())) {
        localDialog.show();
      }
      return true;
    }
    return false;
  }
  
  public static void enterAudioCall(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    int i = ProfileCardUtil.b(paramProfileCardInfo.allInOne);
    String str3 = getCallNickName(paramProfileCardInfo, paramQQAppInterface);
    String str1;
    String str2;
    if (ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne))
    {
      str1 = paramProfileCardInfo.allInOne.uin;
      str2 = null;
    }
    else
    {
      if ((paramProfileCardInfo.allInOne.pa == 53) && (paramProfileCardInfo.contactCard != null) && (!TextUtils.isEmpty(paramProfileCardInfo.contactCard.uin)))
      {
        str1 = paramProfileCardInfo.contactCard.uin;
        i = 0;
      }
      else
      {
        str1 = null;
      }
      str2 = ProfileUtils.getMobileNumberWithNationCode(paramProfileCardInfo.allInOne);
    }
    if (i == 1000) {
      paramProfileCardInfo = paramProfileCardInfo.allInOne.troopUin;
    }
    for (;;)
    {
      break;
      if (i == 1004) {
        paramProfileCardInfo = paramProfileCardInfo.allInOne.discussUin;
      } else {
        paramProfileCardInfo = null;
      }
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramQBaseActivity, 1, i, str1)) {
      return;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramQBaseActivity, i, str1, str3, str2, true, paramProfileCardInfo, true, true, null, "from_internal");
  }
  
  public static void enterChat(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    AllInOne localAllInOne = paramProfileCardInfo.allInOne;
    int j = ProfileCardUtil.b(localAllInOne);
    if ((localAllInOne.preWinUin != null) && (localAllInOne.preWinUin.length() > 0) && (localAllInOne.preWinType != 3000) && (localAllInOne.preWinType != 1) && (localAllInOne.preWinType != 2) && (localAllInOne.preWinType != 1033) && (localAllInOne.preWinType != 1034) && (localAllInOne.preWinType != 1044) && (localAllInOne.preWinType != 1045) && (localAllInOne.preWinUin.equals(localAllInOne.uin)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramQBaseActivity.setResult(0, paramQQAppInterface);
      paramQBaseActivity.finish();
      return;
    }
    String str2 = localAllInOne.uin;
    int i = j;
    String str1 = str2;
    if (ProfilePAUtils.isPaTypeStrangerInContact(localAllInOne)) {
      if (localAllInOne.pa == 53)
      {
        if ((paramProfileCardInfo.contactCard != null) && (!TextUtils.isEmpty(paramProfileCardInfo.contactCard.uin)))
        {
          str1 = paramProfileCardInfo.contactCard.uin;
          i = 0;
        }
        else
        {
          i = 1006;
          str1 = str2;
        }
      }
      else
      {
        str1 = ProfileUtils.getMobileNumberWithNationCode(localAllInOne);
        i = j;
      }
    }
    enterChat(paramQQAppInterface, paramQBaseActivity, paramProfileCardInfo, str1, i);
  }
  
  private static void enterChat(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo, String paramString, int paramInt)
  {
    boolean bool;
    if (paramQBaseActivity.getIntent() != null) {
      bool = paramQBaseActivity.getIntent().getBooleanExtra("key_need_track_back", false);
    } else {
      bool = false;
    }
    Intent localIntent;
    if (bool) {
      localIntent = new Intent(paramQBaseActivity, ChatActivity.class);
    } else {
      localIntent = new Intent(paramQBaseActivity, SplashActivity.class);
    }
    AIOUtils.a(localIntent, null);
    localIntent.putExtra("PREVIOUS_WINDOW", ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass().getName());
    localIntent.putExtra("PREVIOUS_UIN", paramProfileCardInfo.allInOne.uin);
    if (paramQBaseActivity.getIntent().getExtras() != null) {
      localIntent.putExtra("cSpecialFlag", paramQBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramProfileCardInfo.allInOne.chatEntrance != 0) {
      localIntent.putExtra("entrance", paramProfileCardInfo.allInOne.chatEntrance);
    }
    String str = getCallNickName(paramProfileCardInfo, paramQQAppInterface);
    if (str == null) {
      paramString = "";
    } else {
      paramString = str;
    }
    localIntent.putExtra("uinname", paramString);
    if (!TextUtils.isEmpty(paramProfileCardInfo.allInOne.troopUin)) {
      localIntent.putExtra("troop_uin", paramProfileCardInfo.allInOne.troopUin);
    } else if (!TextUtils.isEmpty(paramProfileCardInfo.allInOne.discussUin)) {
      localIntent.putExtra("troop_uin", paramProfileCardInfo.allInOne.discussUin);
    }
    if (!TextUtils.isEmpty(paramProfileCardInfo.allInOne.troopCode)) {
      localIntent.putExtra("troop_code", paramProfileCardInfo.allInOne.troopCode);
    }
    if (paramInt == 1009) {
      localIntent.putExtra("rich_status_sig", paramProfileCardInfo.allInOne.chatCookie);
    }
    if (paramInt == 1001) {
      localIntent.putExtra("rich_accost_sig", paramProfileCardInfo.allInOne.chatCookie);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileBottomContainer", 2, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { Utils.i(paramProfileCardInfo.allInOne.uin), Utils.i(str), Utils.b(paramProfileCardInfo.allInOne.chatCookie) }));
    }
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramProfileCardInfo.allInOne.uin);
      if ((paramQQAppInterface != null) && ((CrmUtils.a(paramQQAppInterface.cSpecialFlag)) || (QidianManager.b(paramQQAppInterface.cSpecialFlag)))) {
        localIntent.putExtra("chat_subType", 1);
      }
    }
    localIntent.putExtra("hidden_aio_msg_source", 2);
    paramQBaseActivity.startActivity(localIntent);
  }
  
  private void enterChatByTroopMember()
  {
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    AIOUtils.a(localIntent, null);
    localIntent.putExtra("uin", ((ProfileCardInfo)this.mData).allInOne.uin);
    localIntent.putExtra("PREVIOUS_WINDOW", this.mActivity.getClass().getName());
    localIntent.putExtra("PREVIOUS_UIN", ((ProfileCardInfo)this.mData).allInOne.uin);
    Object localObject = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((!((ProfileCardInfo)this.mData).troopMemberCard.isFriend) && ((localObject == null) || (!((FriendsManager)localObject).n(((ProfileCardInfo)this.mData).allInOne.uin)))) {
      localIntent.putExtra("uintype", 1000);
    } else {
      localIntent.putExtra("uintype", 0);
    }
    String str = ContactUtils.d(this.mQQAppInterface, ((ProfileCardInfo)this.mData).troopUin, ((ProfileCardInfo)this.mData).allInOne.uin);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = ((ProfileCardInfo)this.mData).troopMemberCard.nick;
    }
    localIntent.putExtra("uinname", (String)localObject);
    localIntent.putExtra("troop_code", ((ProfileCardInfo)this.mData).troopUin);
    localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      ((TroopManager)localObject).a(((ProfileCardInfo)this.mData).troopUin, new ProfileBottomContainer.6(this, localIntent));
    }
  }
  
  private void enterChatInner()
  {
    if (((ProfileCardInfo)this.mData).isTroopMemberCard)
    {
      enterChatByTroopMember();
      return;
    }
    if (ProfilePAUtils.isFromExtendFriend(((ProfileCardInfo)this.mData).allInOne))
    {
      ((IExpandMsgSendHelper)QRoute.api(IExpandMsgSendHelper.class)).sendMsg(this.mQQAppInterface, ((ProfileCardInfo)this.mData).allInOne, new ProfileBottomContainer.5(this));
      return;
    }
    enterChat(this.mQQAppInterface, this.mActivity, (ProfileCardInfo)this.mData);
  }
  
  private static String getCallNickName(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    int i = ProfileCardUtil.b(paramProfileCardInfo.allInOne);
    Object localObject2 = null;
    Object localObject1 = null;
    if (i == 0)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty(null)) {
        paramQQAppInterface = paramProfileCardInfo.nameArray[4];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramProfileCardInfo.allInOne.remark;
      }
    }
    else if ((i != 1000) && (i != 1020))
    {
      if (i == 1021)
      {
        paramQQAppInterface = paramProfileCardInfo.nameArray[2];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramProfileCardInfo.allInOne.circleName;
        }
      }
      else if (i == 1004)
      {
        localObject1 = localObject2;
        if (paramProfileCardInfo.allInOne.troopUin != null) {
          localObject1 = ContactUtils.a(paramQQAppInterface, paramProfileCardInfo.allInOne.troopUin, paramProfileCardInfo.allInOne.uin);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (ProfilePAUtils.isPaTypeStrangerInContact(paramProfileCardInfo.allInOne)) {
          localObject1 = paramProfileCardInfo.nameArray[3];
        }
      }
    }
    else
    {
      paramQQAppInterface = paramProfileCardInfo.nameArray[1];
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramProfileCardInfo.allInOne.troopNickName;
      }
    }
    paramQQAppInterface = (QQAppInterface)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramQQAppInterface = paramProfileCardInfo.nameArray[0];
    }
    localObject1 = paramQQAppInterface;
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      localObject1 = paramProfileCardInfo.allInOne.nickname;
    }
    return localObject1;
  }
  
  private void handleAddFriendClick()
  {
    if (QSecFramework.c().a(1001).booleanValue()) {
      QSecFramework.c().a(5, 0, 2, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(6), "addfriend", null }, null);
    }
    addFriendInner();
    if (((ProfileCardInfo)this.mData).allInOne.profileEntryType == 119) {
      ReportController.b(this.mApp, "dc01160", "", "", "0X800A410", "0X800A410", 0, 0, "", "", "", "");
    }
    if (Utils.c(((ProfileCardInfo)this.mData).allInOne.uin)) {
      ReportController.b(this.mApp, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
    }
    ProfileCardReport.reportAddFriendClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
  }
  
  private void handleChatClick()
  {
    if (((ProfileCardInfo)this.mData).allInOne.profileEntryType == 126)
    {
      DialogUtil.a(this.mActivity, 230, "", this.mActivity.getString(2131889144), this.mActivity.getString(2131889648), this.mActivity.getString(2131889143), new ProfileBottomContainer.3(this), new ProfileBottomContainer.4(this)).show();
    }
    else
    {
      enterChatInner();
      if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
        new ReportTask(this.mQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { ((ProfileCardInfo)this.mData).troopUin }).a();
      }
    }
    ProfileCardReport.reportChatClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
  }
  
  private void handleEditClick()
  {
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      ProfileCardUtils.openProfileEdit(this.mQQAppInterface, this.mActivity, (ProfileCardInfo)this.mData);
      ReportController.b(this.mApp, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
      new ReportTask(this.mQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("edit_clk").a(new String[] { ((ProfileCardInfo)this.mData).troopUin }).a();
      ProfileCardReport.reportProfileEditClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
    }
  }
  
  private void handleFreeCallClick()
  {
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 2;
    VideoActionSheet localVideoActionSheet = VideoActionSheet.a(this.mActivity);
    localVideoActionSheet.addButton(2131917335);
    localVideoActionSheet.addButton(2131917349);
    localVideoActionSheet.addCancelButton(2131887648);
    localVideoActionSheet.setOnDismissListener(new ProfileBottomContainer.7(this));
    localVideoActionSheet.setOnButtonClickListener(new ProfileBottomContainer.8(this, arrayOfInt, localVideoActionSheet));
    localVideoActionSheet.show();
    ProfileCardReport.reportVideoCallClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
  }
  
  private void handleGivePresentClick()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "give_gift_button_in_profile_url", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = ((ProfileCardInfo)this.mData).allInOne.uin;
      Object localObject2 = new Date(System.currentTimeMillis());
      localObject2 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_");
      localStringBuilder.append((String)localObject2);
      str = str.replace("{to_uin}", localStringBuilder.toString());
    }
    else
    {
      str = null;
    }
    Object localObject1 = new Intent(this.mActivity, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", str);
    this.mActivity.startActivity((Intent)localObject1);
    ProfileCardReport.reportGivePresentClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
  }
  
  private void handleSaveContactClick()
  {
    ProfileBottomContainer.1 local1 = new ProfileBottomContainer.1(this);
    Object localObject = new ProfileBottomContainer.2(this);
    localObject = new DenyRunnable(this.mActivity, (DenyRunnable.OnCancelAction)localObject);
    PermissionChecker.a(this.mActivity, local1, (Runnable)localObject);
  }
  
  private void handleTemplateClick(View paramView, DataTag paramDataTag)
  {
    View localView = paramView.findViewById(2131449075);
    ViewParent localViewParent = paramView.getParent();
    paramView = localView;
    if ((localViewParent instanceof View)) {
      paramView = ((View)localViewParent).findViewById(2131449075);
    }
    int i = 1;
    if (paramView != null)
    {
      if (paramView.getVisibility() == 0) {
        i = 0;
      }
      paramView.setVisibility(8);
    }
    else
    {
      i = 1;
    }
    reportRedPointClicked();
    if (paramDataTag.a == 92) {
      paramView = "profileType=custom";
    } else {
      paramView = "";
    }
    ProfileCardUtil.a(this.mActivity, this.mApp.getCurrentAccountUin(), "inside.myCardButton", i, 3, 1, paramView, true, 41);
    ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8006681", 0, 0, "", "", "", "");
    ReportController.b(this.mApp, "dc00898", "", "", "0X8007EB5", "0X8007EB5", 0, 0, "", "", "", "");
    if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
      VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) || (((ProfileCardInfo)this.mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)) {
      VasWebviewUtil.a("", "card_gameking", "clkcard_owner", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo)this.mData).card.lCurrentStyleId));
    }
    ProfileCardReport.reportTemplateClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
  }
  
  private void handleTemplateClickForDiy(View paramView, DataTag paramDataTag)
  {
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E3B", 2, 0, "", "", "", "");
    if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
      VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    handleTemplateClick(paramView, paramDataTag);
  }
  
  private void handleTroopSendGiftClick()
  {
    Object localObject1 = ContactUtils.a(this.mQQAppInterface, ((ProfileCardInfo)this.mData).card.uin, ((ProfileCardInfo)this.mData).troopUin, 1, 0);
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("big_brother_ref_source_key", "biz_src_hdsp_liwu");
    TroopGiftUtil.a(this.mActivity, ((ProfileCardInfo)this.mData).troopUin, ((ProfileCardInfo)this.mData).card.uin, (String)localObject1, "profilecard", this.mQQAppInterface, (Map)localObject2);
    ProfileCardReport.reportTroopProfileCardGivePresentClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
    localObject1 = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).f(((ProfileCardInfo)this.mData).troopUin);
    if (localObject1 != null)
    {
      int i;
      if (((TroopInfo)localObject1).isTroopOwner(this.mApp.getCurrentAccountUin())) {
        i = 0;
      } else if (((TroopInfo)localObject1).isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
      localObject2 = this.mApp;
      String str = ((ProfileCardInfo)this.mData).troopUin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, str, localStringBuilder.toString(), "", "");
      ReportController.b(this.mApp, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, ((ProfileCardInfo)this.mData).troopUin, "4", TroopMemberCardUtils.a(TroopMemberCardUtils.a((TroopInfo)localObject1, ((ProfileCardInfo)this.mData).card.uin)), "");
      new ReportTask(this.mQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("flower_clk").a(new String[] { ((ProfileCardInfo)this.mData).troopUin }).a();
    }
  }
  
  private void handleUpdateBtnGroupInner1(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = true;
    if (paramInt != 1) {
      return;
    }
    if (((ProfileCardInfo)this.mData).isTroopMemberCard)
    {
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        updateBtn(this.mBtnsContainer.getChildAt(0), 23, 2131892782, 1, 2131888160);
      }
      updateBtn(this.mBtnsContainer.getChildAt(1), 81, 2131890849, 1, 2131888107);
    }
    else if (QVipUtils.a(this.mQQAppInterface))
    {
      updateBtn(this.mBtnsContainer.getChildAt(0), 92, 2131892783, 1, 2131892783);
      updateBtn(this.mBtnsContainer.getChildAt(1), 81, 2131890849, 1, 2131888107);
    }
    else
    {
      updateBtn(this.mBtnsContainer.getChildAt(0), 23, 2131892782, 1, 2131888160);
      updateBtn(this.mBtnsContainer.getChildAt(1), 81, 2131890849, 1, 2131888107);
    }
    FriendsManager localFriendsManager = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null) {
      paramBoolean1 = localFriendsManager.n(this.mApp.getCurrentUin());
    }
    if ((((ProfileCardInfo)this.mData).allInOne.pa == 0) && (!paramBoolean1))
    {
      updateBtn(this.mBtnsContainer.getChildAt(2), 7, 2131890826, 2, 2131888094);
      return;
    }
    updateBtn(this.mBtnsContainer.getChildAt(2), 8, 2131916257, 2, 2131888177);
  }
  
  private void handleUpdateBtnGroupInner2(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      updateBtn(this.mBtnsContainer.getChildAt(4), 8, 2131916257, 2, 2131888177);
      return;
    case 6: 
      updateBtn(this.mBtnsContainer.getChildAt(4), 7, 2131890826, 2, 2131888094);
      return;
    case 5: 
      updateBtn(this.mBtnsContainer.getChildAt(1), 7, 2131890826, 1, 2131888094);
      updateBtn(this.mBtnsContainer.getChildAt(2), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
      return;
    case 4: 
      updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
      if ((!paramBoolean2) && (!StudyModeManager.h()))
      {
        updateBtn(this.mBtnsContainer.getChildAt(2), 95, 2131896704, 1, 2131896704);
        ReportController.b(this.mApp, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
      }
      updateBtn(this.mBtnsContainer.getChildAt(4), 8, 2131916257, 2, 2131888177);
      return;
    case 3: 
      updateBtn(this.mBtnsContainer.getChildAt(1), 7, 2131890826, 1, 2131888094);
      updateBtn(this.mBtnsContainer.getChildAt(4), 8, 2131916257, 2, 2131888177);
      return;
    }
    updateBtn(this.mBtnsContainer.getChildAt(1), 7, 2131890826, 1, 2131888094);
    updateBtn(this.mBtnsContainer.getChildAt(2), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
    updateBtn(this.mBtnsContainer.getChildAt(4), 8, 2131916257, 2, 2131888177);
  }
  
  private void handleUpdateBtnGroupInner3(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return;
    case 12: 
      if (ProfilePAUtils.isPaTypeCanAddAsFriend(((ProfileCardInfo)this.mData).allInOne)) {
        updateBtn(this.mBtnsContainer.getChildAt(1), 7, 2131890826, 1, 2131888094);
      } else {
        updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
      }
      if ((!paramBoolean2) && (!StudyModeManager.h())) {
        updateBtn(this.mBtnsContainer.getChildAt(2), 77, 2131896704, 1, 2131896704);
      }
      updateBtn(this.mBtnsContainer.getChildAt(4), 8, 2131916257, 2, 2131888177);
      return;
    case 11: 
      updateBtn(this.mBtnsContainer.getChildAt(1), 59, 2131890899, 1, 2131890899);
      updateBtn(this.mBtnsContainer.getChildAt(4), 7, 2131890826, 2, 2131888094);
      return;
    case 10: 
      updateBtn(this.mBtnsContainer.getChildAt(1), 59, 2131890899, 1, 2131890899);
      return;
    }
    updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
  }
  
  private void initBottomBtns(LinearLayout paramLinearLayout)
  {
    Object localObject2 = this.mActivity.getResources();
    Object localObject1 = this.mActivity.getLayoutInflater();
    paramLinearLayout.removeAllViews();
    int i = ((Resources)localObject2).getDimensionPixelSize(2131297060);
    int j = ((Resources)localObject2).getDimensionPixelSize(2131297060);
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (((ProfileCardInfo)this.mData).allInOne.pa != 33))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((((ProfileCardInfo)this.mData).allInOne.pa == 0) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).allInOne.uin)))
      {
        localObject2 = ((LayoutInflater)localObject1).inflate(2131628445, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
        this.mTemplateCardRedTouch = new RedTouch(this.mActivity, (View)localObject2).b(30.0F).c(30.0F).a();
        if (this.mTemplateCardRedTouch != null) {
          updateTemplateRedTouch();
        }
        localObject2 = ((LayoutInflater)localObject1).inflate(2131628445, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
        localObject2 = ((LayoutInflater)localObject1).inflate(2131627664, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
      }
      if (((ProfileCardInfo)this.mData).allInOne.pa != 0)
      {
        localObject2 = ((LayoutInflater)localObject1).inflate(2131627680, null);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
        localObject2 = ((LayoutInflater)localObject1).inflate(2131627749, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
        localObject2 = ((LayoutInflater)localObject1).inflate(2131627749, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
        localObject2 = ((LayoutInflater)localObject1).inflate(2131627749, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
        localObject1 = ((LayoutInflater)localObject1).inflate(2131627664, null);
        localObject2 = new LinearLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = j;
        paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
    }
  }
  
  private void initViews()
  {
    if (this.mViewContainer != null)
    {
      this.mActivity.getLayoutInflater().inflate(2131627665, (ViewGroup)this.mViewContainer);
      this.mBtnsContainer = ((LinearLayout)((FrameLayout)this.mViewContainer).findViewById(2131430077));
      initBottomBtns(this.mBtnsContainer);
      ((FrameLayout)this.mViewContainer).setVisibility(8);
      this.mBtnsContainer.setVisibility(8);
    }
  }
  
  private boolean isNeedHandleUpdateBtnGroupInnerDefault(int paramInt)
  {
    int[] arrayOfInt = HANDLE_UPDATE_BTN_GROUP_INNER_TYPE;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static void jumpLaunchAddFriendWithCardInfo(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = ProfileUtils.getCardContactInfo(paramProfileCardInfo.allInOne);
    if ((localObject2 != null) && (((ProfileContactInfo)localObject2).phoneNumber != null) && (((ProfileContactInfo)localObject2).phoneNumber.length() > 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((ProfileContactInfo)localObject2).phoneNationalCode);
      ((StringBuilder)localObject1).append(((ProfileContactInfo)localObject2).phoneNumber);
      String str = ((StringBuilder)localObject1).toString();
      localObject1 = ((ProfileContactInfo)localObject2).phoneName;
      if (TextUtils.isEmpty(((ProfileContactInfo)localObject2).phoneName))
      {
        if (!TextUtils.isEmpty(paramProfileCardInfo.nameArray[3])) {
          localObject1 = paramProfileCardInfo.nameArray[3];
        }
        for (;;)
        {
          break;
          if (!TextUtils.isEmpty(paramProfileCardInfo.nameArray[0]))
          {
            localObject1 = paramProfileCardInfo.nameArray[0];
          }
          else
          {
            if (TextUtils.isEmpty(paramProfileCardInfo.profileName.a.b)) {
              break;
            }
            localObject1 = paramProfileCardInfo.profileName.a.b;
          }
        }
      }
      localObject2 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
      localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramQBaseActivity, 2, str, null, paramInt1, paramInt2, (String)localObject1, null, ((Class)localObject2).getName(), paramQBaseActivity.getString(2131887625), null);
      ((Intent)localObject1).putExtra("param_return_profilecard_pa", paramProfileCardInfo.allInOne.pa);
      ((Intent)localObject1).putExtra("key_param_age_area", paramString);
      ProfileActivity.a(paramQBaseActivity, (Intent)localObject1, paramProfileCardInfo);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramQBaseActivity, (Intent)localObject1);
    }
  }
  
  private static void jumpLaunchAddFriendWithCardInfoAndTroop(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = null;
    if ((3004 == paramInt1) && (!TextUtils.isEmpty(paramProfileCardInfo.allInOne.troopUin))) {}
    for (Object localObject1 = paramProfileCardInfo.allInOne.troopUin;; localObject1 = paramProfileCardInfo.allInOne.discussUin)
    {
      localObject3 = localObject1;
      break label74;
      if ((3005 != paramInt1) || (TextUtils.isEmpty(paramProfileCardInfo.allInOne.discussUin))) {
        break;
      }
    }
    Object localObject3 = null;
    label74:
    if ((paramProfileCardInfo.allInOne.pa != 71) && (paramProfileCardInfo.allInOne.pa != 72))
    {
      if ((paramProfileCardInfo.allInOne.pa != 77) && (paramProfileCardInfo.allInOne.pa != 82) && (paramProfileCardInfo.allInOne.pa != 81) && (paramProfileCardInfo.allInOne.pa != 83) && (paramProfileCardInfo.allInOne.pa != 84) && (paramProfileCardInfo.allInOne.pa != 101) && (paramProfileCardInfo.allInOne.pa != 103) && (paramProfileCardInfo.allInOne.pa != 102) && (paramProfileCardInfo.allInOne.pa != 107))
      {
        localObject1 = localObject2;
        if (paramProfileCardInfo.allInOne.pa != 110) {}
      }
      else
      {
        localObject1 = paramProfileCardInfo.nameArray[5];
      }
    }
    else {
      localObject1 = paramProfileCardInfo.nameArray[2];
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramProfileCardInfo.nameArray[0];
    }
    localObject1 = paramQBaseActivity.getIntent().getStringExtra("param_return_addr");
    if (localObject1 != null)
    {
      paramString = AddContactsActivity.class.getName();
      if (((String)localObject1).equals(QidianProfileCardActivity.class.getName())) {
        paramString = (String)localObject1;
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramProfileCardInfo.profileName.a.b;
      }
      paramString = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramQBaseActivity, 1, paramProfileCardInfo.allInOne.uin, localObject3, paramInt1, paramInt2, (String)localObject1, null, paramString, paramQBaseActivity.getString(2131887625), null);
      paramString.putExtra("from_babyq", paramBoolean);
      ProfileActivity.a(paramQBaseActivity, paramString, paramProfileCardInfo);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramQBaseActivity, paramString);
      return;
    }
    localObject1 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
    localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramQBaseActivity, 1, paramProfileCardInfo.allInOne.uin, localObject3, paramInt1, paramInt2, (String)localObject2, null, ((Class)localObject1).getName(), paramQBaseActivity.getString(2131887625), null);
    ((Intent)localObject1).putExtra("from_babyq", paramBoolean);
    ProfileActivity.a(paramQBaseActivity, (Intent)localObject1, paramProfileCardInfo);
    if (paramInt1 == 3094)
    {
      ((Intent)localObject1).putExtra("entrance", paramQBaseActivity.getIntent().getIntExtra("entrance", 2));
      ((Intent)localObject1).removeExtra("param_return_addr");
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramQBaseActivity, (Intent)localObject1);
      return;
    }
    ((Intent)localObject1).putExtra("key_param_age_area", paramString);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(paramQBaseActivity, (Intent)localObject1, 1000);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void reportRedPointClicked()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = this.mTemplateRedPointInfo;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      ((RedTouchManager)this.mApp.getManager(QQManagerFactory.MGR_RED_TOUCH)).c(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      this.mTemplateRedPointInfo = null;
    }
  }
  
  private void resetAllBtnGone()
  {
    int j = this.mBtnsContainer.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mBtnsContainer.getChildAt(i);
      if (localView != null) {
        localView.setVisibility(8);
      }
      i += 1;
    }
  }
  
  public static void setSourceParamValue1(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 3)
    {
      if (i != 35)
      {
        if (i != 37)
        {
          if (i != 58)
          {
            if (i != 75)
            {
              if (i != 21)
              {
                if (i != 22) {
                  return;
                }
                paramSourceParam.sourceId = 3004;
                paramSourceParam.subSourceId = 3;
                return;
              }
              paramSourceParam.sourceId = 3004;
              paramSourceParam.subSourceId = paramProfileCardInfo.allInOne.subSourceId;
              return;
            }
            paramSourceParam.sourceId = 3017;
            paramSourceParam.subSourceId = 1;
            return;
          }
          paramSourceParam.sourceId = 3007;
          paramSourceParam.subSourceId = 1;
          return;
        }
        paramSourceParam.sourceId = 3020;
        paramSourceParam.subSourceId = paramProfileCardInfo.allInOne.subSourceId;
        return;
      }
      paramSourceParam.sourceId = 3001;
      paramSourceParam.subSourceId = 1;
      return;
    }
    paramSourceParam.sourceId = 3002;
    paramSourceParam.subSourceId = paramProfileCardInfo.allInOne.subSourceId;
  }
  
  public static void setSourceParamValue2(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 2)
    {
      if (i != 4) {
        if (i != 25)
        {
          if (i != 27)
          {
            if (i != 74)
            {
              if (i != 77)
              {
                if ((i != 41) && (i != 42))
                {
                  if ((i != 46) && (i != 47)) {
                    return;
                  }
                  paramSourceParam.sourceId = 3005;
                  paramSourceParam.subSourceId = 1;
                  return;
                }
                paramSourceParam.sourceId = 3007;
                paramSourceParam.subSourceId = 2;
              }
            }
            else
            {
              paramSourceParam.sourceId = 3008;
              paramSourceParam.subSourceId = 11;
            }
          }
          else
          {
            paramSourceParam.sourceId = 3041;
            paramSourceParam.subSourceId = 11;
          }
        }
        else
        {
          paramSourceParam.sourceId = 3041;
          paramSourceParam.subSourceId = 12;
          return;
        }
      }
      paramSourceParam.sourceId = 3003;
      return;
    }
    paramSourceParam.sourceId = 3008;
    paramSourceParam.subSourceId = 12;
  }
  
  public static void setSourceParamValue3(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if ((i != 19) && (i != 26))
    {
      if (i != 34) {
        if (i != 120)
        {
          if (i != 23)
          {
            if (i != 24)
            {
              if (i != 31)
              {
                if (i != 32)
                {
                  if (i != 97)
                  {
                    if (i != 98) {
                      return;
                    }
                    paramSourceParam.sourceId = 3096;
                    paramSourceParam.subSourceId = 1;
                    return;
                  }
                  paramSourceParam.sourceId = 3095;
                  paramSourceParam.subSourceId = 1;
                  return;
                }
                paramSourceParam.sourceId = 3009;
              }
            }
            else
            {
              paramSourceParam.sourceId = 3042;
              paramSourceParam.subSourceId = 1;
            }
          }
          else
          {
            paramSourceParam.sourceId = 3037;
            paramSourceParam.subSourceId = 1;
          }
        }
        else
        {
          paramSourceParam.sourceId = 3037;
          paramSourceParam.subSourceId = 2;
          return;
        }
      }
      paramSourceParam.sourceId = 3006;
      paramSourceParam.subSourceId = 13;
      if (paramBoolean)
      {
        paramSourceParam.sourceId = 3084;
        paramSourceParam.subSourceId = 1;
      }
    }
  }
  
  public static void setSourceParamValue4(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 29)
    {
      if ((i != 56) && (i != 57)) {}
      switch (i)
      {
      default: 
        return;
      case 53: 
        paramSourceParam.sourceId = 3068;
        paramSourceParam.subSourceId = 1;
        if (!paramBoolean) {
          break;
        }
        paramSourceParam.sourceId = 3084;
        return;
      case 52: 
        paramSourceParam.sourceId = 3003;
        paramSourceParam.subSourceId = 1;
        return;
      case 51: 
        paramSourceParam.sourceId = 3009;
        paramSourceParam.subSourceId = 1;
        return;
      case 50: 
        paramSourceParam.sourceId = 3006;
        paramSourceParam.subSourceId = 1;
        return;
        paramSourceParam.sourceId = 3013;
        return;
      }
    }
    else
    {
      paramSourceParam.sourceId = 3075;
      if ((paramProfileCardInfo.allInOne.subSourceId != 16) && (paramProfileCardInfo.allInOne.subSourceId != 17))
      {
        paramSourceParam.subSourceId = 1;
        return;
      }
      paramSourceParam.sourceId = 3006;
      paramSourceParam.subSourceId = paramProfileCardInfo.allInOne.subSourceId;
    }
  }
  
  public static void setSourceParamValue5(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 36)
    {
      if (i != 61)
      {
        if (i != 78)
        {
          if (i != 82)
          {
            switch (i)
            {
            default: 
              return;
            case 71: 
            case 72: 
              paramSourceParam.sourceId = 3003;
              paramSourceParam.subSourceId = 2;
              return;
            }
            if (paramProfileCardInfo.allInOne.profileEntryType == 127) {
              paramSourceParam.sourceId = 3048;
            } else {
              paramSourceParam.sourceId = 3071;
            }
            paramSourceParam.subSourceId = 1;
            return;
          }
          paramSourceParam.sourceId = 3045;
          paramSourceParam.subSourceId = 21;
          return;
        }
        paramSourceParam.sourceId = 3022;
        paramSourceParam.subSourceId = 1;
        if (paramBoolean)
        {
          paramSourceParam.sourceId = 3083;
          paramSourceParam.subSourceId = 1;
        }
      }
      else
      {
        paramSourceParam.sourceId = 3011;
      }
    }
    else
    {
      paramSourceParam.sourceId = 3014;
      paramSourceParam.subSourceId = 1;
    }
  }
  
  public static void setSourceParamValue6(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 81)
    {
      if (i != 107)
      {
        if (i != 110)
        {
          if (i != 83)
          {
            if (i != 84)
            {
              switch (i)
              {
              default: 
                return;
              case 103: 
                paramSourceParam.sourceId = 3045;
                paramSourceParam.subSourceId = 20;
                return;
              case 102: 
                paramSourceParam.sourceId = 3045;
                paramSourceParam.subSourceId = 25;
                return;
              }
              paramSourceParam.sourceId = 3045;
              paramSourceParam.subSourceId = 24;
              return;
            }
            paramSourceParam.sourceId = 3045;
            paramSourceParam.subSourceId = 4;
            return;
          }
          paramSourceParam.sourceId = 3045;
          paramSourceParam.subSourceId = 3;
          if (paramBoolean)
          {
            paramSourceParam.sourceId = 3083;
            paramSourceParam.subSourceId = 1;
          }
        }
        else
        {
          paramSourceParam.sourceId = 3045;
          i = 0;
          if (paramBundle != null) {
            i = paramBundle.getInt("tabID", 0);
          }
          paramSourceParam.subSourceId = i;
        }
      }
      else
      {
        paramSourceParam.sourceId = 3045;
        paramSourceParam.subSourceId = 28;
      }
    }
    else
    {
      paramSourceParam.sourceId = 3045;
      paramSourceParam.subSourceId = 23;
    }
  }
  
  public static void setSourceParamValue7(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 95)
    {
      if (i != 96)
      {
        if (i != 108)
        {
          if (i != 109)
          {
            if (i != 111)
            {
              if (i != 112)
              {
                switch (i)
                {
                default: 
                  return;
                case 106: 
                  paramSourceParam.sourceId = 3018;
                  paramSourceParam.subSourceId = 1;
                  return;
                case 105: 
                  paramSourceParam.sourceId = 3072;
                  paramSourceParam.subSourceId = 12;
                  return;
                }
                paramSourceParam.sourceId = 3072;
                paramSourceParam.subSourceId = 11;
                return;
              }
              paramSourceParam.sourceId = 3004;
              paramSourceParam.subSourceId = 23;
              return;
            }
            if (paramProfileCardInfo.allInOne.profileEntryType == 118)
            {
              paramSourceParam.sourceId = 3022;
              paramSourceParam.subSourceId = 3;
              return;
            }
            if (paramProfileCardInfo.allInOne.profileEntryType == 121)
            {
              paramSourceParam.sourceId = 3022;
              paramSourceParam.subSourceId = 2;
            }
          }
          else
          {
            paramSourceParam.sourceId = 3041;
            paramSourceParam.subSourceId = 15;
          }
        }
        else
        {
          paramSourceParam.sourceId = 3041;
          paramSourceParam.subSourceId = 14;
        }
      }
      else
      {
        paramSourceParam.sourceId = 3094;
        paramSourceParam.subSourceId = paramProfileCardInfo.allInOne.subSourceId;
      }
    }
    else
    {
      paramSourceParam.sourceId = 3092;
      paramSourceParam.subSourceId = 1;
    }
  }
  
  public static void setSourceParamValue8(ProfileCardInfo paramProfileCardInfo, ProfileBottomContainer.SourceParam paramSourceParam, boolean paramBoolean)
  {
    switch (paramProfileCardInfo.allInOne.pa)
    {
    case 114: 
    default: 
      return;
    case 118: 
      paramSourceParam.sourceId = 3047;
      paramSourceParam.subSourceId = 2;
      return;
    case 117: 
      paramSourceParam.sourceId = 3076;
      paramSourceParam.subSourceId = 6;
      return;
    case 116: 
      paramSourceParam.sourceId = 3076;
      paramSourceParam.subSourceId = 4;
      return;
    case 115: 
      paramSourceParam.sourceId = 3050;
      paramSourceParam.subSourceId = 1;
      return;
    }
    paramSourceParam.sourceId = 3004;
    paramSourceParam.subSourceId = paramProfileCardInfo.allInOne.subSourceId;
  }
  
  private void updateBtn(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    updateBtn(paramView, paramInt1, this.mActivity.getString(paramInt2), paramInt3, this.mActivity.getString(paramInt4), 0);
  }
  
  private void updateBtn(View paramView, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      DataTag localDataTag = new DataTag(paramInt1, null);
      if (paramInt2 == 0)
      {
        paramView = (ImageButton)paramView.findViewById(2131435503);
        paramView.setTag(localDataTag);
        paramView.setOnClickListener(this);
        paramView.setImageResource(paramInt3);
        paramView.setContentDescription(paramString2);
        return;
      }
      paramView = (Button)paramView.findViewById(2131448897);
      paramView.setTag(localDataTag);
      paramView.setOnClickListener(this);
      paramView.setContentDescription(paramString2);
      paramView.setText(paramString1);
      paramView.setSingleLine();
      paramInt3 = 2131168041;
      if (paramInt2 == 2) {
        paramInt2 = 2131168041;
      } else {
        paramInt2 = 2131168043;
      }
      if (ThemeUtil.isInNightMode(this.mApp)) {
        paramInt2 = paramInt3;
      }
      paramView.setTextColor(this.mActivity.getResources().getColor(paramInt2));
      if ((7 == paramInt1) && (QSecFramework.c().a(1001).booleanValue())) {
        QSecFramework.c().a(5, 0, 1, new Object[] { Integer.valueOf(1), paramView }, null);
      }
    }
  }
  
  private void updateBtnGroup(boolean paramBoolean)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool5 = false;
    if (bool1) {
      QLog.d("ProfileBottomContainer", 2, String.format("updateBtns isNetRet=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      updateBtnGroupInner(1);
      return;
    }
    if (((ProfileCardInfo)this.mData).allInOne.pa == 53)
    {
      updateBtnGroupFromContact();
      return;
    }
    boolean bool3 = ProfilePAUtils.isPaTypeCanAddAsFriend(((ProfileCardInfo)this.mData).allInOne);
    paramBoolean = ProfilePAUtils.isPaTypeCanTalk(((ProfileCardInfo)this.mData).allInOne);
    bool1 = ProfilePAUtils.isPaTypeCanFreeCall(((ProfileCardInfo)this.mData).allInOne);
    if (((ProfileCardInfo)this.mData).allInOne.profileEntryType == 113)
    {
      paramBoolean = false;
      bool1 = false;
    }
    boolean bool2 = paramBoolean;
    boolean bool4 = bool3;
    if (Utils.c(((ProfileCardInfo)this.mData).allInOne.uin))
    {
      bool1 = bool3;
      if (this.mIsFromArkBabyQ)
      {
        bool1 = false;
        paramBoolean = false;
      }
      bool2 = false;
      bool4 = bool1;
      bool1 = bool2;
      bool2 = paramBoolean;
    }
    paramBoolean = bool2;
    if (ProfilePAUtils.isFromExtendFriend(((ProfileCardInfo)this.mData).allInOne))
    {
      paramBoolean = bool2;
      if (((ProfileCardInfo)this.mData).allInOne.extendFriendVoiceCode != null)
      {
        paramBoolean = bool2;
        if (((ProfileCardInfo)this.mData).allInOne.extendFriendVoiceCode.length > 0) {
          paramBoolean = true;
        }
      }
    }
    if (!ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)this.mData).allInOne)) {
      bool1 = bool5;
    }
    updateBtnGroupByParamCombination(bool4, paramBoolean, bool1);
  }
  
  private void updateBtnGroupByParamCombination(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean2) && (((ProfileCardInfo)this.mData).isTroopMemberCard))
    {
      updateBtnGroupInner(12);
      return;
    }
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3))
    {
      updateBtnGroupInner(2);
      return;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      updateBtnGroupInner(3);
      return;
    }
    if ((paramBoolean2) && (paramBoolean3))
    {
      updateBtnGroupInner(4);
      return;
    }
    if ((paramBoolean1) && (paramBoolean3))
    {
      updateBtnGroupInner(5);
      return;
    }
    if (paramBoolean1)
    {
      updateBtnGroupInner(6);
      return;
    }
    if (paramBoolean2)
    {
      updateBtnGroupInner(7);
      return;
    }
    if (paramBoolean3)
    {
      updateBtnGroupInner(5);
      return;
    }
    updateBtnGroupInner(0);
  }
  
  private void updateBtnGroupFromContact()
  {
    if (((ProfileCardInfo)this.mData).contactCard.bindQQ)
    {
      if (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).contactCard.uin))
      {
        if (TextUtils.equals(((ProfileCardInfo)this.mData).contactCard.uin, this.mApp.getCurrentAccountUin()))
        {
          updateBtnGroupInner(0);
          return;
        }
        updateBtnGroupInner(4);
        return;
      }
      if (((IPhoneContactService)this.mApp.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(((ProfileCardInfo)this.mData).contactCard.mobileNo) != null)
      {
        int i;
        if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
          i = 12;
        } else {
          i = 2;
        }
        updateBtnGroupInner(i);
        return;
      }
      updateBtnGroupInner(11);
      return;
    }
    updateBtnGroupInner(10);
  }
  
  private void updateBtnGroupInner(int paramInt)
  {
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool1 = ((ProfileCardInfo)this.mData).isTroopMemberCard;
    boolean bool2 = true;
    if ((bool1) && (((TroopManager)localObject).Z(((ProfileCardInfo)this.mData).troopUin)))
    {
      localObject = ((TroopManager)localObject).g(((ProfileCardInfo)this.mData).troopUin);
      ProfileTroopMemInfoComponent localProfileTroopMemInfoComponent = (ProfileTroopMemInfoComponent)this.mComponentCenter.getComponent(1013);
      if (localProfileTroopMemInfoComponent != null) {
        localProfileTroopMemInfoComponent.checkAndUpdateTroopInfo((TroopInfo)localObject);
      }
      if ((!((TroopInfo)localObject).isTroopAdmin(((ProfileCardInfo)this.mData).allInOne.uin)) && (!((TroopInfo)localObject).isTroopOwner(((ProfileCardInfo)this.mData).allInOne.uin)))
      {
        bool1 = false;
        bool2 = false;
      }
      else
      {
        bool1 = true;
      }
    }
    else
    {
      bool1 = false;
    }
    resetAllBtnGone();
    handleUpdateBtnGroupInner1(paramInt, bool2, bool1);
    handleUpdateBtnGroupInner2(paramInt, bool2, bool1);
    handleUpdateBtnGroupInner3(paramInt, bool2, bool1);
    if ((paramInt == 0) || (!isNeedHandleUpdateBtnGroupInnerDefault(paramInt))) {
      bool2 = false;
    }
    localObject = (FrameLayout)this.mViewContainer;
    int i = 8;
    if (bool2) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((FrameLayout)localObject).setVisibility(paramInt);
    localObject = this.mBtnsContainer;
    paramInt = i;
    if (bool2) {
      paramInt = 0;
    }
    ((LinearLayout)localObject).setVisibility(paramInt);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void updateTemplateRedTouch()
  {
    if (this.mTemplateCardRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.mApp.getRuntimeService(IRedTouchManager.class, "");
      this.mTemplateRedPointInfo = localIRedTouchManager.getAppInfoByPath(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      this.mTemplateCardRedTouch.a(this.mTemplateRedPointInfo);
      localIRedTouchManager.onReportRedPointExposure(this.mTemplateRedPointInfo);
    }
  }
  
  public void addFriend()
  {
    addFriendInner();
  }
  
  public String getComponentName()
  {
    return "ProfileBottomContainer";
  }
  
  public int getComponentType()
  {
    return 107;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      int i = localDataTag.a;
      if (i != 7)
      {
        if (i != 8)
        {
          if (i != 20)
          {
            if (i != 23)
            {
              if (i != 59)
              {
                if (i != 77)
                {
                  if (i != 81)
                  {
                    if (i != 92)
                    {
                      if (i == 95) {
                        handleGivePresentClick();
                      }
                    }
                    else {
                      handleTemplateClickForDiy(paramView, localDataTag);
                    }
                  }
                  else {
                    handleEditClick();
                  }
                }
                else {
                  handleTroopSendGiftClick();
                }
              }
              else {
                handleSaveContactClick();
              }
            }
            else {
              handleTemplateClick(paramView, localDataTag);
            }
          }
          else {
            handleFreeCallClick();
          }
        }
        else {
          handleChatClick();
        }
      }
      else {
        handleAddFriendClick();
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
    initViews();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    updateBtnGroup(paramProfileCardInfo.isNetRet);
    return bool;
  }
  
  public void onDestroy()
  {
    Dialog localDialog = this.addFriendDialog;
    if ((localDialog != null) && (localDialog.isShowing()))
    {
      this.addFriendDialog.dismiss();
      this.addFriendDialog = null;
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    updateTemplateRedTouch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer
 * JD-Core Version:    0.7.0.1
 */