package com.tencent.mobileqq.data;

import accb;
import accc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.utils.BatchAddFriendData;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Locale;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForGrayTips$HightlightClickableSpan
  extends ClickableSpan
  implements MessageForGrayTips.HightlightClickInterface
{
  int color = -1;
  private Context context;
  String frienduin;
  private MessageForGrayTips.HightlightItem item;
  private WeakReference mApp;
  MessageRecord message;
  
  public MessageForGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, MessageForGrayTips.HightlightItem paramHightlightItem, MessageRecord paramMessageRecord)
  {
    this.mApp = new WeakReference(paramQQAppInterface);
    this.context = paramContext;
    this.color = paramInt;
    this.item = paramHightlightItem;
    this.message = paramMessageRecord;
    if (paramMessageRecord != null) {
      this.frienduin = paramMessageRecord.frienduin;
    }
  }
  
  public boolean clickAppMsg(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, " clickAppMsg actionData = " + paramString1 + "actionDataA" + paramString2);
    }
    paramString2 = parsePackageNameAndData(paramString1, paramString2);
    Object localObject = this.context.getPackageManager();
    try
    {
      if (((PackageManager)localObject).getPackageInfo(paramString2[0], 1) != null)
      {
        localObject = ((PackageManager)localObject).getLaunchIntentForPackage(paramString2[0]);
        if (!TextUtils.isEmpty(paramString2[1])) {
          ((Intent)localObject).setData(Uri.parse(paramString2[1]));
        }
      }
      try
      {
        StartAppCheckHandler localStartAppCheckHandler = (StartAppCheckHandler)((QQAppInterface)this.mApp.get()).a(23);
        ((Intent)localObject).putExtra("report_open_type", "graytipsmsg");
        ((Intent)localObject).putExtra("report_url", "");
        ((Intent)localObject).putExtra("report_from", "1");
        ((Intent)localObject).putExtra("report_click_origin", "AIOTail");
        ((Intent)localObject).putExtra("report_class_name", this.context.getClass().getName());
        localStartAppCheckHandler.b(paramString2[0].trim(), this.context, (Intent)localObject);
        bool = true;
        return bool;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
          }
          this.context.startActivity((Intent)localObject);
        }
      }
      return clickWebMsg(paramString1);
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, paramString2.getMessage());
      }
    }
  }
  
  public boolean clickPluginMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, "HightlightClickableSpan clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {}
    try
    {
      for (;;)
      {
        JumpParser.a((QQAppInterface)this.mApp.get(), this.context, paramString1).b();
        return true;
        paramString1 = paramString2;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HightlightClickableSpan", 2, paramString1.getMessage(), paramString1);
        }
      }
    }
  }
  
  public boolean clickWebMsg(String paramString)
  {
    boolean bool2 = false;
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
    {
      boolean bool1 = bool2;
      if (paramString.equals("cmd://openGiftPanel"))
      {
        bool1 = bool2;
        if ((this.context instanceof FragmentActivity))
        {
          paramString = ((FragmentActivity)this.context).getChatFragment();
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.a() != null)
            {
              paramString.a().k(true);
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    if (paramString.equals("http://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=")) {
      ReportController.b(null, "CliOper", "", "", "0X80070EB", "0X80070EB", 0, 0, "", "", "", "");
    }
    if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.b == 131078))
    {
      TroopEnterEffectManager.a("Grp_AIO", "grey_clk", new String[] { this.message.frienduin });
      SharedPreUtils.t(this.context, ((BaseActivity)this.context).app.getCurrentAccountUin(), this.message.frienduin);
    }
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("key_isReadModeEnabled", true);
    PublicAccountUtil.a(this.message, localIntent, paramString);
    this.context.startActivity(localIntent);
    paramString = (QQAppInterface)this.mApp.get();
    if ((paramString != null) && ((this.message instanceof MessageForGrayTips)) && (String.valueOf(11).equals(this.message.getExtInfoFromExtStr("gray_tips_serviceType")))) {
      ReportController.b(paramString, "dc00898", "", "", "0X8009328", "0X8009328", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((this.item == null) || (this.mApp == null) || (this.mApp.get() == null)) {}
    label360:
    int i;
    label663:
    Object localObject1;
    label978:
    Object localObject2;
    label2095:
    label2279:
    Object localObject3;
    label2332:
    int j;
    Object localObject4;
    Object localObject5;
    do
    {
      do
      {
        long l;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    return;
                                                    if (QLog.isColorLevel()) {
                                                      QLog.d("MessageForGrayTips", 2, "revoke msg onClick==>item actionType:" + this.item.actionType);
                                                    }
                                                    switch (this.item.actionType)
                                                    {
                                                    case 8: 
                                                    case 9: 
                                                    default: 
                                                      return;
                                                    case 1: 
                                                      if ((this.message != null) && (this.message.msgtype == -2049)) {
                                                        ReportCenter.a().a(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "", "", "2000", "2012", "0", false);
                                                      }
                                                      if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
                                                      {
                                                        paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                                        if (paramView != null)
                                                        {
                                                          if (paramView.b != 2359297) {
                                                            break label360;
                                                          }
                                                          ReportController.b(null, "P_CliOper", "cmshow", "", "Apollo", "Invitetip_clk", 0, 0, "", "", "", "");
                                                        }
                                                      }
                                                      if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
                                                      for (paramView = this.item.mMsg_A_ActionData;; paramView = this.item.mMsgActionData)
                                                      {
                                                        clickWebMsg(paramView);
                                                        return;
                                                        if (paramView.b == 2359298)
                                                        {
                                                          ReportController.b(null, "P_CliOper", "cmshow", "", "Apollo", "clk_intro", 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (paramView.b == 2490369)
                                                        {
                                                          ReportController.b(null, "dc00898", "", "", "0X8007F12", "0X8007F12", 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (paramView.b == 2621441)
                                                        {
                                                          paramView = ((MessageForUniteGrayTip)this.message).appGuideTipsOpKey;
                                                          if (TextUtils.isEmpty(paramView)) {
                                                            break;
                                                          }
                                                          ReportController.b(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (paramView.b == 3145729)
                                                        {
                                                          ReportController.b(null, "dc00898", "", "", "0X800812B", "0X800812B", 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (paramView.b != 131078) {
                                                          break;
                                                        }
                                                        VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).c(), "style", "0X8009133", "", 1, 0, 0, "", "", "0");
                                                        break;
                                                      }
                                                    case 3: 
                                                      clickPluginMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                      return;
                                                    case 2: 
                                                      clickAppMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                      return;
                                                    case 4: 
                                                      if (((TroopManager)((QQAppInterface)this.mApp.get()).getManager(51)).a(this.frienduin) != null) {
                                                        break;
                                                      }
                                                      i = 2;
                                                      paramView = TroopInfoActivity.a(this.frienduin, 4);
                                                      paramView.putInt("t_s_f", 1001);
                                                      ChatSettingForTroop.a(this.context, paramView, i);
                                                      return;
                                                    case 17: 
                                                      localObject1 = new Intent(this.context, PermisionPrivacyActivity.class);
                                                      if (this.message != null) {}
                                                      for (paramView = this.message.getExtInfoFromExtStr("scrollflag");; paramView = null)
                                                      {
                                                        if (!TextUtils.isEmpty(paramView))
                                                        {
                                                          ((Intent)localObject1).putExtra("scrollflag", paramView);
                                                          ReportController.b((QQAppInterface)this.mApp.get(), "P_CliOper", "invite_friend", "", "auto_pass", "clk_set_entry", 0, 0, this.frienduin, "", "", "");
                                                        }
                                                        this.context.startActivity((Intent)localObject1);
                                                        return;
                                                      }
                                                    case 5: 
                                                      paramView = (QQAppInterface)this.mApp.get();
                                                    }
                                                  } while ((this.context == null) || (paramView == null));
                                                  TroopMemberCardUtils.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                  return;
                                                  paramView = (QQAppInterface)this.mApp.get();
                                                } while ((this.context == null) || (paramView == null));
                                                TroopMemberCardUtils.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                paramView = paramView.getCurrentAccountUin();
                                                localObject1 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(51);
                                                if (localObject1 == null) {
                                                  break;
                                                }
                                                localObject1 = ((TroopManager)localObject1).a(this.frienduin);
                                                if (localObject1 == null) {
                                                  break;
                                                }
                                                if (((TroopInfo)localObject1).isTroopOwner(paramView)) {}
                                                for (paramView = "1";; paramView = "2")
                                                {
                                                  TroopReportor.a("Grp_manage", "recall_msg", "clk_mberName", 0, 0, new String[] { this.frienduin, paramView });
                                                  return;
                                                }
                                              } while (this.context == null);
                                              paramView = new Intent(this.context, EditInfoActivity.class);
                                              localObject1 = String.valueOf(this.item.uin);
                                              localObject2 = ContactUtils.h((QQAppInterface)this.mApp.get(), this.frienduin, (String)localObject1);
                                              paramView.putExtra("edit_type", 0);
                                              paramView.putExtra("troopUin", this.frienduin);
                                              paramView.putExtra("uin", (String)localObject1);
                                              paramView.putExtra("title", this.context.getResources().getString(2131430598));
                                              paramView.putExtra("isTroopNick", true);
                                              paramView.putExtra("default_text", (String)localObject2);
                                              paramView.putExtra("max_num", 60);
                                              paramView.putExtra("default_hint", "未设置");
                                              paramView.putExtra("auto_remark", true);
                                              this.context.startActivity(paramView);
                                              return;
                                              paramView = new TroopInfoData();
                                              paramView.troopUin = this.frienduin;
                                              localObject1 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(51);
                                            } while (localObject1 == null);
                                            localObject1 = ((TroopManager)localObject1).a(this.frienduin);
                                            if (localObject1 != null)
                                            {
                                              paramView.updateForTroopChatSetting((TroopInfo)localObject1, this.context.getResources(), ((QQAppInterface)this.mApp.get()).getCurrentAccountUin());
                                              paramView.isMember = true;
                                            }
                                            new TroopShareUtility((SplashActivity)this.context, paramView).a(paramView);
                                            return;
                                            if (QLog.isColorLevel()) {
                                              QLog.d("reactive", 2, "onclick graytip");
                                            }
                                            ReportController.b(null, "dc00898", "", "", "0X8007603", "0X8007603", 0, 0, "", "", "", "");
                                            paramView = new Intent(this.context, ShowReactiveActivity.class);
                                            paramView.putExtra("friendUin", this.frienduin);
                                          } while (!(this.context instanceof BaseActivity));
                                          ((BaseActivity)this.context).startActivityForResult(paramView, 13006);
                                          return;
                                          if (QLog.isColorLevel()) {
                                            QLog.d("specialCare", 2, "onclick graytip");
                                          }
                                          paramView = new Intent(this.context, QQSpecialCareSettingActivity.class);
                                          paramView.putExtra("key_friend_uin", this.frienduin);
                                          paramView.putExtra("key_start_from", 1);
                                          if ((this.context instanceof BaseActivity)) {
                                            this.context.startActivity(paramView);
                                          }
                                          VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "Care", "CareTipClick", "", 1, 0, 0, null, this.item.mMsgActionData, null);
                                          return;
                                          paramView = new Intent(this.context, SelectMemberActivity.class);
                                          paramView.putExtra("param_groupcode", this.frienduin);
                                          paramView.putExtra("param_type", 1);
                                          paramView.putExtra("param_subtype", 1);
                                          paramView.putExtra("param_done_button_wording", this.context.getString(2131430620));
                                          paramView.putExtra("param_only_friends", true);
                                          paramView.putExtra("param_is_troop_admin", true);
                                          paramView.putExtra("param_title", this.context.getString(2131430203));
                                          this.context.startActivity(paramView);
                                          return;
                                        } while (((TroopManager)((QQAppInterface)this.mApp.get()).getManager(51)).b(this.frienduin) == null);
                                        paramView = new Intent(this.context, EditInfoActivity.class);
                                        paramView.putExtra("edit_type", 0);
                                        paramView.putExtra("title", "编辑群聊名称");
                                        paramView.putExtra("max_num", 30);
                                        paramView.putExtra("canPostNull", false);
                                        ((Activity)this.context).startActivityForResult(paramView, 13010);
                                        return;
                                        HWTroopUtils.a(this.context, this.frienduin);
                                        TroopReportor.a("Grp_edu", "Grp_AIO", "graybar_showmore", 0, 0, new String[] { this.frienduin });
                                        return;
                                      } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                      paramView = (MessageForUniteGrayTip)this.message;
                                    } while (this.mApp == null);
                                    localObject1 = (QidianHandler)((QQAppInterface)this.mApp.get()).a(85);
                                  } while (localObject1 == null);
                                  ((QidianHandler)localObject1).a(paramView.extUin, paramView.masterUin, paramView.taskId, paramView.uniseq, paramView.istroop);
                                  return;
                                  paramView = new Intent(this.context, EditActivity.class);
                                  paramView.putExtra("title", 2131433507).putExtra("current", this.item.remark).putExtra("action", 103).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("multiLine", false);
                                  if ((this.context instanceof BaseActivity)) {
                                    ((BaseActivity)this.context).startActivityForResult(paramView, 13008);
                                  }
                                  for (;;)
                                  {
                                    ReportController.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800797A", "0X800797A", 0, 0, "", "", "", "");
                                    if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                      break;
                                    }
                                    ReportController.b((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setRefTips_clk", 0, 0, "", "", "", "");
                                    return;
                                    this.context.startActivity(paramView);
                                  }
                                  paramView = new Intent(this.context, MoveToGroupActivity.class);
                                  i = this.item.groupId;
                                  if ((i != -1) && ((i != 0) || (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)))) {
                                    break label4465;
                                  }
                                  localObject1 = ((FriendsManager)((QQAppInterface)this.mApp.get()).getManager(50)).c(this.frienduin);
                                  if (localObject1 != null)
                                  {
                                    i = ((Friends)localObject1).groupid;
                                    paramView.putExtra("friendUin", this.frienduin).putExtra("mgid", (byte)i);
                                    if (!(this.context instanceof BaseActivity)) {
                                      break label2279;
                                    }
                                    ((BaseActivity)this.context).startActivityForResult(paramView, 13009);
                                  }
                                  for (;;)
                                  {
                                    ReportController.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X8007979", "0X8007979", 0, 0, "", "", "", "");
                                    if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                      break;
                                    }
                                    if (QLog.isDevelopLevel()) {
                                      QLog.i("MessageForGrayTips", 4, String.format(Locale.getDefault(), "ACTION_FRIEND_GROUP_SETTING gid: %s, groupId: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.item.groupId) }));
                                    }
                                    ReportController.b((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setGrpTips_clk", 0, 0, "", "", "", "");
                                    return;
                                    i = 0;
                                    break label2095;
                                    this.context.startActivity(paramView);
                                  }
                                  if ((this.message == null) || (this.message.msg == null)) {
                                    break;
                                  }
                                  paramView = this.message.msg.substring(this.item.start, this.item.end);
                                  localObject1 = this.item.mMsgActionData;
                                  localObject2 = this.item.mMsg_A_ActionData;
                                } while ((localObject1 == null) || (localObject2 == null) || (!(this.context instanceof FragmentActivity)));
                                localObject3 = ((FragmentActivity)this.context).getChatFragment();
                              } while ((localObject3 == null) || (((ChatFragment)localObject3).a() == null));
                              localObject3 = ((ChatFragment)localObject3).a();
                              ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
                              localObject1 = AtTroopMemberSpan.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, (String)localObject1, (String)localObject2, false, ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                              ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject1);
                              ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.append(paramView);
                              ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
                              return;
                              for (;;)
                              {
                                try
                                {
                                  localObject2 = new JSONObject(this.item.mMsgActionData);
                                  paramView = ((JSONObject)localObject2).optString("uin");
                                  localObject1 = ((JSONObject)localObject2).optString("name");
                                  localObject2 = ((JSONObject)localObject2).optString("text");
                                  if ((paramView == null) || (localObject1 == null) || (!(this.context instanceof FragmentActivity))) {
                                    break;
                                  }
                                  localObject3 = ((FragmentActivity)this.context).getChatFragment();
                                  if ((localObject3 == null) || (((ChatFragment)localObject3).a() == null)) {
                                    break;
                                  }
                                  localObject3 = ((ChatFragment)localObject3).a();
                                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                                  {
                                    bool = true;
                                    paramView = AtTroopMemberSpan.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, paramView, (String)localObject1, false, ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx, true, bool);
                                    ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
                                    ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.append((CharSequence)localObject2);
                                    ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(((BaseChatPie)localObject3).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
                                    return;
                                  }
                                }
                                catch (JSONException paramView)
                                {
                                  paramView.printStackTrace();
                                  return;
                                }
                                bool = false;
                              }
                              StoryPlayVideoActivity.a(this.context, this.item.mMsgActionData, 1005);
                              StoryReportor.a("story_grp", "aio_grey", 0, 0, new String[] { "", "", "", "" });
                              return;
                              paramView = this.item.mMsgActionData;
                            } while (TextUtils.isEmpty(paramView));
                            for (;;)
                            {
                              try
                              {
                                l = Long.parseLong(paramView);
                                if (!(this.context instanceof FragmentActivity)) {
                                  break;
                                }
                                paramView = ((FragmentActivity)this.context).getChatFragment().a();
                                if (!paramView.f()) {
                                  break;
                                }
                                paramView.a(10, l, 0, null);
                                EmojiStickerManager.a().b = 0;
                                if (this.message == null) {
                                  break;
                                }
                                paramView = "1";
                                if (this.message.istroop == 1)
                                {
                                  paramView = "2";
                                  VasWebviewUtil.reportCommercialDrainage("", "Stick", "ClickTip", paramView, 1, 0, 0, null, "", "");
                                  return;
                                }
                              }
                              catch (Exception paramView)
                              {
                                paramView = paramView;
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.e("MessageForGrayTips", 2, "", paramView);
                                return;
                              }
                              finally {}
                              if (this.message.istroop == 3000) {
                                paramView = "3";
                              }
                            }
                            paramView = new Intent(this.context, GoldMsgSettingActivity.class);
                            paramView.putExtra("goldmsg_frienduin", this.frienduin);
                            paramView.putExtra("goldmsg_setting_type", this.message.istroop);
                            paramView.putExtra("goldmsg_fromgreytips", true);
                            this.context.startActivity(paramView);
                            return;
                          } while (!(this.context instanceof FragmentActivity));
                          paramView = ((FragmentActivity)this.context).getChatFragment();
                        } while ((paramView == null) || (paramView.a() == null));
                        paramView = paramView.a();
                        paramView.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("@babyQ");
                        paramView.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection("@babyQ".length());
                        paramView = this.item.mMsgActionData;
                        i = Integer.parseInt(this.item.mMsg_A_ActionData);
                        ArkAppDataReport.b((QQAppInterface)this.mApp.get(), paramView, i);
                        return;
                        BatchAddFriendData.a(this.context, (QQAppInterface)this.mApp.get(), this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                        return;
                        localObject2 = this.frienduin;
                        i = this.message.istroop;
                        j = this.message.getConfessTopicId();
                        localObject3 = new ConfessInfo();
                        ((ConfessInfo)localObject3).parseFromJsonStr(this.message.getExtInfoFromExtStr("ext_key_confess_info"));
                        localObject4 = (QQAppInterface)this.mApp.get();
                      } while ((localObject4 == null) || (!(this.context instanceof FragmentActivity)) || (((FragmentActivity)this.context).isFinishing()) || (MsgProxyUtils.a(i) != 1032));
                      localObject5 = ((FragmentActivity)this.context).getChatFragment().a();
                      localObject1 = null;
                      paramView = (View)localObject1;
                      if (localObject5 != null)
                      {
                        paramView = (View)localObject1;
                        if ((localObject5 instanceof ConfessChatPie)) {
                          paramView = (ConfessChatPie)localObject5;
                        }
                      }
                    } while (paramView == null);
                    paramView = DialogUtil.b(this.context, 0, "确认永久屏蔽？", "永久屏蔽后，你将不再收到对方的坦白说消息，此操作不可撤销，确认永久屏蔽吗？", 2131433029, 2131433030, new accb(this, (QQAppInterface)localObject4, (String)localObject2, i, j, (ConfessInfo)localObject3, paramView), new accc(this));
                  } while (((FragmentActivity)this.context).isFinishing());
                  paramView.show();
                  return;
                } while (!(this.context instanceof FragmentActivity));
                paramView = ((FragmentActivity)this.context).getChatFragment();
              } while ((paramView == null) || (paramView.a() == null));
              paramView = paramView.a();
            } while (!(paramView instanceof BusinessCmrTmpChatPie));
            ((BusinessCmrTmpChatPie)paramView).bi();
            return;
            if (!BaseChatItemLayout.a) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MessageForGrayTips", 2, "revoke msg multi msg select forward,return click");
          return;
        } while (!(this.context instanceof FragmentActivity));
        paramView = this.item.mMsgActionData;
        localObject2 = this.item.mMsg_A_ActionData;
        if (QLog.isColorLevel())
        {
          l = 0L;
          if (!TextUtils.isEmpty(paramView)) {
            l = paramView.length();
          }
          QLog.d("MessageForGrayTips", 2, new Object[] { "revoke msg click handle msg length =", Long.valueOf(l) });
        }
        localObject1 = ((FragmentActivity)this.context).getChatFragment();
      } while ((localObject1 == null) || (((ChatFragment)localObject1).a() == null));
      UniteGrayTipUtil.a(this.message);
      localObject1 = ((ChatFragment)localObject1).a();
      if ((((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText() != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MessageForGrayTips", 2, "revoke msg clickspan chatpie input is null");
    return;
    ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().clear();
    label3574:
    int k;
    label3652:
    int m;
    label3758:
    Object localObject6;
    Context localContext;
    String str;
    XEditTextEx localXEditTextEx;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      int n;
      for (;;)
      {
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MessageForGrayTips", 2, "revoke msg clickspan handle at info is null");
          }
          ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MessageForGrayTips", 2, "revoke msg clickspan json exception,input only text String", localJSONException);
          ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
          continue;
          j = 0;
        }
        j = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
        i = j;
        if (j < 0) {
          i = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "revoke msg click handle input length =" + i);
        }
        ((BaseChatPie)localObject1).jdField_a_of_type_JavaLangString = "";
        ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(i);
        ((BaseChatPie)localObject1).ar();
        return;
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = ((JSONObject)localObject3).optString(MessageConstants.k);
          n = ((JSONObject)localObject3).optInt(MessageConstants.l);
          localObject3 = new JSONArray((String)localObject4);
          if ((localObject3 == null) || (((JSONArray)localObject3).length() != 0)) {
            continue;
          }
          ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
        }
      }
      if (j < ((JSONArray)localObject3).length())
      {
        localObject4 = ((JSONArray)localObject3).getJSONObject(j);
        int i1 = ((JSONObject)localObject4).optInt("startPos");
        k = ((JSONObject)localObject4).optInt("textLen");
        ((JSONObject)localObject4).optInt("flag");
        localObject4 = ((JSONObject)localObject4).optString("uin");
        localObject5 = paramView.substring(i1 + 1, k + i1);
        m = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd();
        k = m;
        if (m < 0) {
          k = 0;
        }
        localObject6 = paramView.substring(k, i1);
        ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(k, (CharSequence)localObject6);
        localObject6 = (QQAppInterface)this.mApp.get();
        localContext = this.context;
        str = this.frienduin;
        localXEditTextEx = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx;
        if (n != 1) {
          break label4486;
        }
      }
    }
    label4486:
    for (boolean bool = true;; bool = false)
    {
      localObject4 = AtTroopMemberSpan.a((QQAppInterface)localObject6, localContext, str, (String)localObject4, (String)localObject5, false, localXEditTextEx, bool);
      if ((localObject4 != null) && (((SpannableString)localObject4).length() != 0))
      {
        m = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd();
        k = m;
        if (m < 0) {
          k = 0;
        }
        ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(k, (CharSequence)localObject4);
        if (j == ((JSONArray)localObject3).length() - 1)
        {
          m = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd();
          k = m;
          if (m < 0) {
            k = 0;
          }
          if (k <= paramView.length() - 1)
          {
            localObject4 = paramView.substring(k, paramView.length());
            ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(k, (CharSequence)localObject4);
            break label4479;
            i += 1;
            break label3652;
            if (QLog.isColorLevel()) {
              QLog.d("MessageForGrayTips", 2, "revoke msg click handle at info is empty");
            }
            ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
            break label3574;
            paramView = (QQAppInterface)this.mApp.get();
            if ((paramView == null) || ((!(this.context instanceof ChatActivity)) && (!(this.context instanceof SplashActivity)))) {
              break;
            }
            localObject1 = (FragmentActivity)this.context;
            if ((((FragmentActivity)localObject1).getChatFragment() != null) && (((FragmentActivity)localObject1).getChatFragment().a() != null) && ((this.message instanceof ChatMessage)))
            {
              ((FragmentActivity)localObject1).getChatFragment().a().b((ChatMessage)this.message);
              ((TroopEnterEffectManager)paramView.getManager(230)).a(this.item.mMsgActionData);
              if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect", 2, "click nolongerPrompt id = " + this.item.mMsgActionData);
              }
            }
            if ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
              break;
            }
            localObject1 = ((MessageForUniteGrayTip)this.message).tipParam;
            if (localObject1 == null) {
              break;
            }
            switch (((UniteGrayTipParam)localObject1).b)
            {
            default: 
              return;
            }
            VasWebviewUtil.reportCommercialDrainage(paramView.c(), "style", "0X8009133", "", 1, 0, 0, "", "", "3");
            return;
            if (this.context != null) {
              VasH5PayUtil.a(this.item.mMsgActionData, this.context);
            }
            if ((this.mApp.get() == null) || (this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
              break;
            }
            paramView = ((MessageForUniteGrayTip)this.message).tipParam;
            if (paramView == null) {
              break;
            }
            switch (paramView.b)
            {
            default: 
              return;
            }
            VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).c(), "style", "0X8009133", "", 1, 0, 0, "", "", "1");
            return;
            paramView = "";
            break label2332;
            label4465:
            break label2095;
            paramView = "";
            break label978;
            i = 1;
            break label663;
          }
        }
      }
      label4479:
      j += 1;
      break label3758;
    }
  }
  
  protected final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label52;
      }
    }
    label52:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label63;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label63:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.color == -1) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    }
    for (;;)
    {
      paramTextPaint.setUnderlineText(false);
      return;
      paramTextPaint.setColor(this.color);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */