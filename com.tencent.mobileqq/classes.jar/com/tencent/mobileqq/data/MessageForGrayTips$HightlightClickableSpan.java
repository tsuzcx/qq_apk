package com.tencent.mobileqq.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiManager;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ConfigableWordingSetter;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.doc.TencentDocGrayTipsUtils;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.graytip.CustomizeGrayTipsManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.miniapp.util.MiniAppJumpUtil;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
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
  private MessageForGrayTips.HighlightItem item;
  private WeakReference<QQAppInterface> mApp;
  MessageRecord message;
  
  public MessageForGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, MessageForGrayTips.HighlightItem paramHighlightItem, MessageRecord paramMessageRecord)
  {
    this.mApp = new WeakReference(paramQQAppInterface);
    this.context = paramContext;
    this.color = paramInt;
    this.item = paramHighlightItem;
    this.message = paramMessageRecord;
    if (paramMessageRecord != null) {
      this.frienduin = paramMessageRecord.frienduin;
    }
  }
  
  private void deleteFriend(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
      } while (!((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "deleteFriend " + paramString);
      }
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(paramString, (byte)2);
      MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, paramString));
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatSettingActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(16711681, paramString));
  }
  
  private void doAddFriendSafetyReport(QQAppInterface paramQQAppInterface)
  {
    if ((this.context instanceof BaseActivity))
    {
      Object localObject = (BaseActivity)this.context;
      Bundle localBundle = NewReportPlugin.a(this.message.frienduin, 0);
      NewReportPlugin.a((BaseActivity)localObject, this.message.frienduin, null, "1", null, this.message.selfuin, 25030, null, localBundle);
      localObject = this.message.getExtInfoFromExtStr("uint64_busi_type");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A561", "0X800A561", 1, 0, this.message.getExtInfoFromExtStr("uint64_busi_id"), (String)localObject, "web", "");
    }
  }
  
  private void onClickActionWeb(QQAppInterface paramQQAppInterface)
  {
    if ((this.message != null) && (this.message.msgtype == -2049)) {
      ReportCenter.a().a(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "", "", "2000", "2012", "0", false);
    }
    UniteGrayTipParam localUniteGrayTipParam;
    Object localObject1;
    if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
    {
      localUniteGrayTipParam = ((MessageForUniteGrayTip)this.message).tipParam;
      if (localUniteGrayTipParam != null)
      {
        if (localUniteGrayTipParam.b != 2359297) {
          break label259;
        }
        ReportController.b(null, "P_CliOper", "cmshow", "", "Apollo", "Invitetip_clk", 0, 0, "", "", "", "");
        ApolloDtReportUtil.a("aio_bubble", "apollo_tips", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(paramQQAppInterface)).b(ApolloDtReportUtil.a(this.message.istroop)).a(this.message.msg).b(this.frienduin).a());
        if (MutualMarkUtils.b(localUniteGrayTipParam.b))
        {
          if (!TextUtils.isEmpty(this.item.mMsgActionData)) {
            break label1556;
          }
          localObject1 = this.item.mMsg_A_ActionData;
          label207:
          MutualMarkBusinessLogicHelper.a(paramQQAppInterface, (MessageForUniteGrayTip)this.message, localUniteGrayTipParam.b, (String)localObject1);
        }
        AioApolloHelper.a(paramQQAppInterface, localUniteGrayTipParam);
      }
    }
    if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
    for (paramQQAppInterface = this.item.mMsg_A_ActionData;; paramQQAppInterface = this.item.mMsgActionData)
    {
      clickWebMsg(paramQQAppInterface);
      return;
      label259:
      if (localUniteGrayTipParam.b == 2359298)
      {
        ReportController.b(null, "P_CliOper", "cmshow", "", "Apollo", "clk_intro", 0, 0, "", "", "", "");
        break;
      }
      if (localUniteGrayTipParam.b == 2490369)
      {
        ReportController.b(null, "dc00898", "", "", "0X8007F12", "0X8007F12", 0, 0, "", "", "", "");
        break;
      }
      if (localUniteGrayTipParam.b == 2621441)
      {
        localObject1 = ((MessageForUniteGrayTip)this.message).appGuideTipsOpKey;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        break;
      }
      if (localUniteGrayTipParam.b == 3145729)
      {
        ReportController.b(null, "dc00898", "", "", "0X800812B", "0X800812B", 0, 0, "", "", "", "");
        break;
      }
      if (localUniteGrayTipParam.b == 131078)
      {
        VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "0");
        break;
      }
      int i;
      if (localUniteGrayTipParam.b == 2097154)
      {
        if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
        for (localObject1 = this.item.mMsg_A_ActionData;; localObject1 = this.item.mMsgActionData)
        {
          for (;;)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label656;
            }
            Object localObject2 = HttpUtil.decodeURL((String)localObject1);
            if (!((Map)localObject2).containsKey("type")) {
              break;
            }
            localObject2 = (String)((Map)localObject2).get("type");
            try
            {
              i = Integer.parseInt((String)localObject2);
              ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA6", i, 0, "", "", "", "");
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("reactive", 2, "parse url type error:" + (String)localObject1);
          break;
        }
        label656:
        break;
      }
      String str1;
      if (localUniteGrayTipParam.b == 655384)
      {
        str1 = this.message.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
        localObject1 = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject1 = "1";
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", (String)localObject1, "", "2"));
        break;
      }
      if (localUniteGrayTipParam.b == 2097153)
      {
        localObject1 = this.message.getExtInfoFromExtStr("friendIconType");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "aio_click", "", 0, 0, 0, "", (String)localObject1, "", "", "", "", "", 0, 0, 0, 0);
        if (((String)localObject1).equals("3"))
        {
          LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "2"));
          break;
        }
        if (!((String)localObject1).equals("6")) {
          break;
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "2"));
        break;
      }
      if (localUniteGrayTipParam.b == 655397)
      {
        String str2 = this.message.getExtInfoFromExtStr("uint64_busi_type");
        localObject1 = this.message.getExtInfoFromExtStr("uint64_busi_id");
        str1 = this.message.getExtInfoFromExtStr("uint64_templ_id");
        i = 3;
        if (this.message.istroop == 0)
        {
          i = 1;
          label912:
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject1, "" + str2, "web", "");
          if ("1008".equals(localObject1)) {
            ReportController.b(null, "dc00898", "", "", "0X800A639", "0X800A639", i - 1, 0, "", "", "", "");
          }
          if (("1062".equals(localObject1)) && ("12".equals(str2)))
          {
            str2 = this.message.getExtInfoFromExtStr("bytes_content");
            if (!TextUtils.isEmpty(str2))
            {
              if (!str2.contains("动作")) {
                break label1374;
              }
              ReportController.b(null, "dc00898", "", "", "0X800B43E", "0X800B43E", i, 0, "", "", "", "");
            }
          }
          label1092:
          if (PaiYiPaiMsgUtil.a(this.message))
          {
            int j = i;
            if (i != 1)
            {
              j = i;
              if (i != 2) {
                j = 10;
              }
            }
            ReportController.b(null, "dc00898", "", "", "0X800B525", "0X800B525", j, 0, "", "", "", "");
          }
          if (Long.valueOf((String)localObject1).equals(Long.valueOf(1021L))) {
            ReportController.b(null, "dc00898", "", "", "0X800AD83", "0X800AD83", 0, 0, "", "", "", "");
          }
          TogetherUtils.a((String)localObject1, localUniteGrayTipParam.a);
          if ((Long.valueOf((String)localObject1).equals(Long.valueOf(1038L))) && (!TextUtils.isEmpty(str1)))
          {
            if (!Long.valueOf(str1).equals(Long.valueOf(1111L))) {
              break label1415;
            }
            ReportController.b(null, "dc00898", "", "", "0X800B1A3", "0X800B1A3", 0, 0, "", "", "", "");
          }
        }
        for (;;)
        {
          if (!TroopLuckyCharacterUtil.a.contains(Long.valueOf((String)localObject1))) {
            break label1460;
          }
          i = (int)(Long.valueOf((String)localObject1).longValue() - 1069L);
          ReportController.b(paramQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_clk", 0, 0, "", "", "", "");
          ReportController.b(paramQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_clk", i + 1, 0, "", "", "", "");
          break;
          if (this.message.istroop != 1) {
            break label912;
          }
          i = 2;
          break label912;
          label1374:
          if (!str2.contains("效果")) {
            break label1092;
          }
          ReportController.b(null, "dc00898", "", "", "0X800B440", "0X800B440", i, 0, "", "", "", "");
          break label1092;
          label1415:
          if (Long.valueOf(str1).equals(Long.valueOf(1112L))) {
            ReportController.b(null, "dc00898", "", "", "0X800B1A5", "0X800B1A5", 0, 0, "", "", "", "");
          }
        }
        label1460:
        break;
      }
      if (localUniteGrayTipParam.b == 131090)
      {
        TroopEssenceUtil.a((QQAppInterface)this.mApp.get(), this.frienduin);
        TroopEssenceReportUtil.b((QQAppInterface)this.mApp.get(), this.frienduin);
        break;
      }
      if (localUniteGrayTipParam.b != 656397) {
        break;
      }
      GameMsgUtil.a(GameMsgChatPie.h, "1", "145", "920", "92005", "207654", localUniteGrayTipParam.c, "", "20", "");
      break;
      label1556:
      localObject1 = this.item.mMsgActionData;
      break label207;
    }
  }
  
  private void showDeleteDialog(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = HardCodeUtil.a(2131706611);
    if (this.item.mMsg_A_ActionData != null) {
      paramQQAppInterface = this.item.mMsg_A_ActionData;
    }
    DialogUtil.a(this.context, null, paramQQAppInterface, null, 2131690800, 2131691845, new MessageForGrayTips.HightlightClickableSpan.4(this), new MessageForGrayTips.HightlightClickableSpan.5(this)).show();
  }
  
  /* Error */
  public boolean clickAppMsg(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc_w 546
    //   11: iconst_2
    //   12: new 84	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 548
    //   22: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 550
    //   32: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 554	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:parsePackageNameAndData	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   56: invokevirtual 560	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   59: astore 4
    //   61: aload 4
    //   63: aload_2
    //   64: iconst_0
    //   65: aaload
    //   66: iconst_1
    //   67: invokevirtual 566	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   70: ifnull +257 -> 327
    //   73: aload 4
    //   75: aload_2
    //   76: iconst_0
    //   77: aaload
    //   78: invokevirtual 570	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   81: astore 4
    //   83: aload_2
    //   84: iconst_1
    //   85: aaload
    //   86: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +15 -> 104
    //   92: aload 4
    //   94: aload_2
    //   95: iconst_1
    //   96: aaload
    //   97: invokestatic 576	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   100: invokevirtual 582	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   103: pop
    //   104: aload 4
    //   106: ifnull +219 -> 325
    //   109: aload_0
    //   110: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   113: getfield 238	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   116: sipush 1008
    //   119: if_icmpeq +121 -> 240
    //   122: aload 4
    //   124: ldc_w 584
    //   127: ldc_w 586
    //   130: invokevirtual 590	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload_0
    //   135: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   138: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   141: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   144: getstatic 593	com/tencent/mobileqq/app/BusinessHandlerFactory:STARTAPPCHECK_HANDLER	Ljava/lang/String;
    //   147: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   150: checkcast 595	com/tencent/mobileqq/app/StartAppCheckHandler
    //   153: astore 5
    //   155: aload 4
    //   157: ldc_w 597
    //   160: ldc_w 599
    //   163: invokevirtual 590	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   166: pop
    //   167: aload 4
    //   169: ldc_w 601
    //   172: ldc 161
    //   174: invokevirtual 590	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   177: pop
    //   178: aload 4
    //   180: ldc_w 603
    //   183: ldc 145
    //   185: invokevirtual 590	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   188: pop
    //   189: aload 4
    //   191: ldc_w 605
    //   194: ldc_w 607
    //   197: invokevirtual 590	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   200: pop
    //   201: aload 4
    //   203: ldc_w 609
    //   206: aload_0
    //   207: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   210: invokevirtual 615	java/lang/Object:getClass	()Ljava/lang/Class;
    //   213: invokevirtual 620	java/lang/Class:getName	()Ljava/lang/String;
    //   216: invokevirtual 590	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   219: pop
    //   220: aload 5
    //   222: aload_2
    //   223: iconst_0
    //   224: aaload
    //   225: invokevirtual 623	java/lang/String:trim	()Ljava/lang/String;
    //   228: aload_0
    //   229: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   232: aload 4
    //   234: invokevirtual 626	com/tencent/mobileqq/app/StartAppCheckHandler:b	(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    //   237: goto +88 -> 325
    //   240: aload 4
    //   242: ldc_w 584
    //   245: ldc_w 628
    //   248: invokestatic 634	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   251: checkcast 628	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   254: aload_0
    //   255: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   258: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   261: invokeinterface 637 2 0
    //   266: invokevirtual 590	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   269: pop
    //   270: goto -136 -> 134
    //   273: astore_2
    //   274: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +13 -> 290
    //   280: ldc_w 639
    //   283: iconst_2
    //   284: ldc_w 641
    //   287: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   294: aload 4
    //   296: invokevirtual 645	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   299: goto +26 -> 325
    //   302: astore_2
    //   303: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +13 -> 319
    //   309: ldc 82
    //   311: iconst_2
    //   312: aload_2
    //   313: invokevirtual 648	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   316: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_0
    //   320: aload_1
    //   321: invokevirtual 289	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickWebMsg	(Ljava/lang/String;)Z
    //   324: ireturn
    //   325: iconst_1
    //   326: istore_3
    //   327: iload_3
    //   328: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	HightlightClickableSpan
    //   0	329	1	paramString1	String
    //   0	329	2	paramString2	String
    //   1	327	3	bool	boolean
    //   59	236	4	localObject	Object
    //   153	68	5	localStartAppCheckHandler	com.tencent.mobileqq.app.StartAppCheckHandler
    // Exception table:
    //   from	to	target	type
    //   109	134	273	java/lang/Exception
    //   134	237	273	java/lang/Exception
    //   240	270	273	java/lang/Exception
    //   61	104	302	android/content/pm/PackageManager$NameNotFoundException
    //   109	134	302	android/content/pm/PackageManager$NameNotFoundException
    //   134	237	302	android/content/pm/PackageManager$NameNotFoundException
    //   240	270	302	android/content/pm/PackageManager$NameNotFoundException
    //   274	290	302	android/content/pm/PackageManager$NameNotFoundException
    //   290	299	302	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public boolean clickPluginMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, "HightlightClickableSpan clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    String str;
    if (!TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.equals("null", paramString2)) {}
    }
    else
    {
      str = paramString1;
    }
    try
    {
      paramString1 = JumpParser.a((QQAppInterface)this.mApp.get(), this.context, str);
      if (paramString1 != null)
      {
        paramString1.b();
        paramString1.a();
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
    return true;
  }
  
  public boolean clickWebMsg(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))) {
            break label133;
          }
          if (!paramString.equals("cmd://openGiftPanel")) {
            break;
          }
        } while (!(this.context instanceof FragmentActivity));
        paramString = ((FragmentActivity)this.context).getChatFragment();
      } while ((paramString == null) || (paramString.a() == null));
      paramString.a().m(true);
      return true;
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("mqzone://arouse/lovermainpage")) || (this.mApp == null));
    LoverZoneUtils.a((QQAppInterface)this.mApp.get(), this.context, 2080, "");
    return false;
    label133:
    if (paramString.equals("http://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=")) {
      ReportController.b(null, "CliOper", "", "", "0X80070EB", "0X80070EB", 0, 0, "", "", "", "");
    }
    TencentDocGrayTipsUtils.a(paramString);
    if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.b == 131078))
    {
      TroopEnterEffectManager.a("Grp_AIO", "grey_clk", new String[] { this.message.frienduin });
      SharedPreUtils.r(this.context, ((BaseActivity)this.context).app.getCurrentAccountUin(), this.message.frienduin);
    }
    if ((this.message != null) && (this.message.istroop == 1) && (MiniAppJumpUtil.a((BaseActivity)this.context, paramString, this.message)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "mini app jump handled");
      }
      return true;
    }
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("key_isReadModeEnabled", true);
    String str;
    if (this.message == null) {
      str = "biz_src_jc_aio";
    }
    for (;;)
    {
      localIntent.putExtra("big_brother_source_key", str);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.message, localIntent, paramString);
      this.context.startActivity(localIntent);
      paramString = (QQAppInterface)this.mApp.get();
      if ((paramString != null) && ((this.message instanceof MessageForGrayTips)) && (String.valueOf(11).equals(this.message.getExtInfoFromExtStr("gray_tips_serviceType")))) {
        ReportController.b(paramString, "dc00898", "", "", "0X8009328", "0X8009328", 0, 0, "", "", "", "");
      }
      return true;
      if (this.message.istroop == 1008) {
        str = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.message.frienduin);
      } else {
        str = "biz_src_jc_aio";
      }
    }
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public MessageRecord getMessage()
  {
    return this.message;
  }
  
  public void onClick(View paramView)
  {
    if ((this.item == null) || (this.mApp == null) || (this.mApp.get() == null)) {}
    Object localObject2;
    Object localObject1;
    int i;
    label520:
    label587:
    label2298:
    Object localObject4;
    label902:
    label2482:
    label2535:
    boolean bool1;
    long l;
    int j;
    Object localObject5;
    Object localObject6;
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
                                                      localObject2 = (QQAppInterface)this.mApp.get();
                                                    } while (localObject2 == null);
                                                    switch (this.item.actionType)
                                                    {
                                                    case 8: 
                                                    case 9: 
                                                    case 22: 
                                                    case 23: 
                                                    case 35: 
                                                    case 37: 
                                                    case 49: 
                                                    default: 
                                                      return;
                                                    case 1: 
                                                      onClickActionWeb((QQAppInterface)localObject2);
                                                      return;
                                                    case 3: 
                                                      if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.b == 655397))
                                                      {
                                                        paramView = this.message.getExtInfoFromExtStr("uint64_busi_type");
                                                        localObject1 = this.message.getExtInfoFromExtStr("uint64_busi_id");
                                                        i = 3;
                                                        if (this.message.istroop != 0) {
                                                          break label520;
                                                        }
                                                        i = 1;
                                                      }
                                                      for (;;)
                                                      {
                                                        ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject1, "" + paramView, "mqq", "");
                                                        clickPluginMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                        return;
                                                        if (this.message.istroop == 1) {
                                                          i = 2;
                                                        }
                                                      }
                                                    case 2: 
                                                      clickAppMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                      return;
                                                    case 4: 
                                                      if (((TroopManager)((QQAppInterface)this.mApp.get()).getManager(QQManagerFactory.TROOP_MANAGER)).b(this.frienduin) != null) {
                                                        break;
                                                      }
                                                      i = 2;
                                                      paramView = TroopInfoActivity.a(this.frienduin, 4);
                                                      paramView.putInt("t_s_f", 1001);
                                                      TroopUtils.a(this.context, paramView, i);
                                                      return;
                                                    case 17: 
                                                      localObject1 = new Intent(this.context, PermisionPrivacyActivity.class);
                                                      if (this.message != null) {}
                                                      for (paramView = this.message.getExtInfoFromExtStr("scrollflag");; paramView = null)
                                                      {
                                                        if (!TextUtils.isEmpty(paramView))
                                                        {
                                                          ((Intent)localObject1).putExtra("scrollflag", paramView);
                                                          ReportController.b((AppRuntime)this.mApp.get(), "P_CliOper", "invite_friend", "", "auto_pass", "clk_set_entry", 0, 0, this.frienduin, "", "", "");
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
                                                localObject1 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(QQManagerFactory.TROOP_MANAGER);
                                                if (localObject1 == null) {
                                                  break;
                                                }
                                                localObject1 = ((TroopManager)localObject1).b(this.frienduin);
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
                                              paramView.putExtra("title", this.context.getResources().getString(2131697571));
                                              paramView.putExtra("isTroopNick", true);
                                              paramView.putExtra("default_text", (String)localObject2);
                                              paramView.putExtra("max_num", 60);
                                              paramView.putExtra("default_hint", HardCodeUtil.a(2131706619));
                                              paramView.putExtra("auto_remark", true);
                                              this.context.startActivity(paramView);
                                              return;
                                              paramView = new TroopInfoData();
                                              paramView.troopUin = this.frienduin;
                                              localObject1 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(QQManagerFactory.TROOP_MANAGER);
                                            } while (localObject1 == null);
                                            localObject1 = ((TroopManager)localObject1).b(this.frienduin);
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
                                            paramView = new Intent(this.context, QQBrowserActivity.class);
                                            localObject1 = MutualMarkConfProcessor.a().a(this.frienduin);
                                            if (QLog.isColorLevel()) {
                                              QLog.d("MessageForGrayTips", 2, String.format("goToC2CWebPage, url: %s", new Object[] { localObject1 }));
                                            }
                                            paramView.putExtra("url", (String)localObject1);
                                            paramView.putExtra("finish_animation_out_to_right", true);
                                            paramView.putExtra("is_wrap_content", true);
                                            paramView.putExtra("hide_left_button", false);
                                            if (this.context != null) {
                                              this.context.startActivity(paramView);
                                            }
                                            if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
                                            {
                                              paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                              if ((paramView != null) && (2097154 == paramView.b)) {
                                                ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA7", 0, 0, "", "", "", "");
                                              }
                                              if (paramView != null) {
                                                MutualMarkBusinessLogicHelper.b((QQAppInterface)localObject2, (MessageForUniteGrayTip)this.message, paramView.b);
                                              }
                                            }
                                          } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                          paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                        } while ((paramView == null) || (2097155 != paramView.b));
                                        ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "0X800A1BD", "0X800A1BD", 0, 0, "", "", "", "");
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
                                        paramView.putExtra("param_done_button_wording", this.context.getString(2131697287));
                                        paramView.putExtra("param_only_friends", true);
                                        paramView.putExtra("param_is_troop_admin", true);
                                        paramView.putExtra("param_title", this.context.getString(2131696046));
                                        paramView.putExtra("param_max", 100);
                                        this.context.startActivity(paramView);
                                        return;
                                        paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(QQManagerFactory.TROOP_MANAGER)).c(this.frienduin);
                                      } while (paramView == null);
                                      localObject1 = new Intent(this.context, EditInfoActivity.class);
                                      ((Intent)localObject1).putExtra("edit_type", 2);
                                      ((Intent)localObject1).putExtra("title", HardCodeUtil.a(2131706631));
                                      if (paramView.hasSetNewTroopName) {
                                        ((Intent)localObject1).putExtra("default_text", paramView.troopname);
                                      }
                                      ((Intent)localObject1).putExtra("max_num", 96);
                                      ((Intent)localObject1).putExtra("canPostNull", false);
                                      ((Activity)this.context).startActivityForResult((Intent)localObject1, 13010);
                                      return;
                                      HWTroopUtils.a(this.context, this.frienduin);
                                      TroopReportor.a("Grp_edu", "Grp_AIO", "graybar_showmore", 0, 0, new String[] { this.frienduin });
                                      return;
                                    } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                    paramView = (MessageForUniteGrayTip)this.message;
                                  } while (this.mApp == null);
                                  localObject1 = (QidianHandler)((QQAppInterface)this.mApp.get()).getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
                                } while (localObject1 == null);
                                ((QidianHandler)localObject1).a(paramView.extUin, paramView.masterUin, paramView.taskId, paramView.uniseq, paramView.istroop);
                                return;
                                paramView = new Intent(this.context, EditActivity.class);
                                paramView.putExtra("title", 2131693420).putExtra("current", this.item.remark).putExtra("action", 103).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("multiLine", false);
                                if ((this.context instanceof BaseActivity)) {
                                  ((BaseActivity)this.context).startActivityForResult(paramView, 13008);
                                }
                                for (;;)
                                {
                                  ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "0X800797A", "0X800797A", 0, 0, "", "", "", "");
                                  if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                    break;
                                  }
                                  ReportController.b((AppRuntime)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setRefTips_clk", 0, 0, "", "", "", "");
                                  return;
                                  this.context.startActivity(paramView);
                                }
                                paramView = new Intent(this.context, MoveToGroupActivity.class);
                                i = this.item.groupId;
                                if ((i != -1) && ((i != 0) || (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)))) {
                                  break label7218;
                                }
                                localObject1 = ((FriendsManager)((QQAppInterface)this.mApp.get()).getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.frienduin);
                                if (localObject1 != null)
                                {
                                  i = ((Friends)localObject1).groupid;
                                  paramView.putExtra("friendUin", this.frienduin).putExtra("mgid", (byte)i);
                                  if (!(this.context instanceof BaseActivity)) {
                                    break label2482;
                                  }
                                  ((BaseActivity)this.context).startActivityForResult(paramView, 13009);
                                }
                                for (;;)
                                {
                                  ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "0X8007979", "0X8007979", 0, 0, "", "", "", "");
                                  if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                    break;
                                  }
                                  if (QLog.isDevelopLevel()) {
                                    QLog.i("MessageForGrayTips", 4, String.format(Locale.getDefault(), "ACTION_FRIEND_GROUP_SETTING gid: %s, groupId: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.item.groupId) }));
                                  }
                                  ReportController.b((AppRuntime)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setGrpTips_clk", 0, 0, "", "", "", "");
                                  return;
                                  i = 0;
                                  break label2298;
                                  this.context.startActivity(paramView);
                                }
                                if ((this.message == null) || (this.message.msg == null)) {
                                  break;
                                }
                                paramView = this.message.msg.substring(this.item.start, this.item.end);
                                localObject1 = this.item.mMsgActionData;
                                localObject2 = this.item.mMsg_A_ActionData;
                              } while ((localObject1 == null) || (localObject2 == null) || (!(this.context instanceof FragmentActivity)));
                              localObject4 = ((FragmentActivity)this.context).getChatFragment();
                            } while ((localObject4 == null) || (((ChatFragment)localObject4).a() == null));
                            localObject4 = ((ChatFragment)localObject4).a();
                            ((BaseChatPie)localObject4).a.setText("");
                            localObject1 = AtTroopMemberSpan.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, (String)localObject1, (String)localObject2, false, ((BaseChatPie)localObject4).a, true);
                            ((BaseChatPie)localObject4).a.setText((CharSequence)localObject1);
                            ((BaseChatPie)localObject4).a.append(paramView);
                            ((BaseChatPie)localObject4).a.setSelection(((BaseChatPie)localObject4).a.getText().length());
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
                                localObject4 = ((FragmentActivity)this.context).getChatFragment();
                                if ((localObject4 == null) || (((ChatFragment)localObject4).a() == null)) {
                                  break;
                                }
                                localObject4 = ((ChatFragment)localObject4).a();
                                if (!TextUtils.isEmpty((CharSequence)localObject2))
                                {
                                  bool1 = true;
                                  paramView = AtTroopMemberSpan.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, paramView, (String)localObject1, false, ((BaseChatPie)localObject4).a, true, bool1);
                                  ((BaseChatPie)localObject4).a.setText(paramView);
                                  ((BaseChatPie)localObject4).a.append((CharSequence)localObject2);
                                  ((BaseChatPie)localObject4).a.setSelection(((BaseChatPie)localObject4).a.getText().length());
                                  return;
                                }
                              }
                              catch (JSONException paramView)
                              {
                                paramView.printStackTrace();
                                return;
                              }
                              bool1 = false;
                            }
                            StoryPlayerLauncher.a(this.context, this.item.mMsgActionData, "HightLight_Feed_Id", 1005);
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
                              if (!paramView.h()) {
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
                        } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                        paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                        i = Scene.a(Scene.a(paramView.d, 0));
                        paramView = Scene.a(paramView.d, 1);
                        BatchAddFriendData.a(this.context, (QQAppInterface)this.mApp.get(), this.item.mMsgActionData, this.item.mMsg_A_ActionData, i, paramView);
                        return;
                        localObject4 = this.frienduin;
                        i = this.message.istroop;
                        j = this.message.getConfessTopicId();
                        localObject5 = new ConfessInfo();
                        ((ConfessInfo)localObject5).parseFromJsonStr(this.message.getExtInfoFromExtStr("ext_key_confess_info"));
                      } while ((!(this.context instanceof FragmentActivity)) || (((FragmentActivity)this.context).isFinishing()) || (UinTypeUtil.a(i) != 1032));
                      localObject6 = ((FragmentActivity)this.context).getChatFragment().a();
                      localObject1 = null;
                      paramView = (View)localObject1;
                      if (localObject6 != null)
                      {
                        paramView = (View)localObject1;
                        if ((localObject6 instanceof ConfessChatPie)) {
                          paramView = (ConfessChatPie)localObject6;
                        }
                      }
                    } while (paramView == null);
                    paramView = DialogUtil.a(this.context, 0, ConfessConfig.f, ConfessConfig.g, 2131690800, 2131694615, new MessageForGrayTips.HightlightClickableSpan.1(this, (QQAppInterface)localObject2, (String)localObject4, i, j, (ConfessInfo)localObject5, paramView), new MessageForGrayTips.HightlightClickableSpan.2(this));
                  } while (((FragmentActivity)this.context).isFinishing());
                  paramView.show();
                  return;
                } while (!(this.context instanceof FragmentActivity));
                paramView = ((FragmentActivity)this.context).getChatFragment();
              } while ((paramView == null) || (paramView.a() == null));
              paramView = paramView.a();
            } while (!(paramView instanceof BusinessCmrTmpChatPie));
            ((BusinessCmrTmpChatPie)paramView).i(this.item.mMsgActionData);
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
      if ((((BaseChatPie)localObject1).a != null) && (((BaseChatPie)localObject1).a.getEditableText() != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MessageForGrayTips", 2, "revoke msg clickspan chatpie input is null");
    return;
    ((BaseChatPie)localObject1).a.getEditableText().clear();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
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
        ((BaseChatPie)localObject1).a.setText(paramView);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForGrayTips", 2, "revoke msg clickspan json exception,input only text String", localJSONException);
        ((BaseChatPie)localObject1).a.setText(paramView);
        continue;
        j = 0;
      }
      j = ((BaseChatPie)localObject1).a.getText().length();
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "revoke msg click handle input length =" + i);
      }
      ((BaseChatPie)localObject1).d = "";
      ((BaseChatPie)localObject1).a.setSelection(i);
      ((BaseChatPie)localObject1).ax();
      return;
      i = 0;
      if (i < ((JSONArray)localObject2).length())
      {
        localObject4 = ((JSONArray)localObject2).getJSONObject(i);
        localObject5 = ((JSONObject)localObject4).optString(MessageConstants.k);
        int n = ((JSONObject)localObject4).optInt(MessageConstants.l);
        localObject4 = new JSONArray((String)localObject5);
        if ((localObject4 != null) && (((JSONArray)localObject4).length() == 0))
        {
          ((BaseChatPie)localObject1).a.setText(paramView);
        }
        else
        {
          label3850:
          if (j < ((JSONArray)localObject4).length())
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            int i1 = ((JSONObject)localObject5).optInt("startPos");
            int k = ((JSONObject)localObject5).optInt("textLen");
            ((JSONObject)localObject5).optInt("flag");
            localObject5 = ((JSONObject)localObject5).optString("uin");
            localObject6 = paramView.substring(i1 + 1, k + i1);
            int m = ((BaseChatPie)localObject1).a.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            Object localObject7 = paramView.substring(k, i1);
            ((BaseChatPie)localObject1).a.getEditableText().insert(k, (CharSequence)localObject7);
            localObject7 = (QQAppInterface)this.mApp.get();
            Context localContext = this.context;
            String str = this.frienduin;
            XEditTextEx localXEditTextEx = ((BaseChatPie)localObject1).a;
            if (n != 1) {
              break label7239;
            }
            bool1 = true;
            label4011:
            localObject5 = AtTroopMemberSpan.a((QQAppInterface)localObject7, localContext, str, (String)localObject5, (String)localObject6, false, localXEditTextEx, bool1);
            if ((localObject5 == null) || (((SpannableString)localObject5).length() == 0)) {
              break;
            }
            m = ((BaseChatPie)localObject1).a.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            ((BaseChatPie)localObject1).a.getEditableText().insert(k, (CharSequence)localObject5);
            if (j != ((JSONArray)localObject4).length() - 1) {
              break;
            }
            m = ((BaseChatPie)localObject1).a.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            if (k > paramView.length() - 1) {
              break;
            }
            localObject5 = paramView.substring(k, paramView.length());
            ((BaseChatPie)localObject1).a.getEditableText().insert(k, (CharSequence)localObject5);
            break;
          }
          i += 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("MessageForGrayTips", 2, "revoke msg click handle at info is empty");
          }
          ((BaseChatPie)localObject1).a.setText(paramView);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!(this.message instanceof MessageForUniteGrayTip)) {
              break label7207;
            }
            paramView = (MessageForUniteGrayTip)this.message;
            if (paramView.istroop != 0) {
              continue;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              continue;
            }
            i = 1;
            ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
          }
          catch (RuntimeException paramView)
          {
            boolean bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("MessageForGrayTips", 1, "0X800A613", paramView);
            continue;
          }
          ChatActivityFacade.a(this.context, localJSONException, (ChatMessage)this.message);
          return;
          i = 2;
          continue;
          if (paramView.istroop == 1)
          {
            bool1 = TroopUtils.a(localJSONException, this.message.frienduin, localJSONException.getCurrentUin());
            bool2 = TroopUtils.b(localJSONException, this.message.frienduin, localJSONException.getCurrentUin());
            localObject1 = paramView.tipParam.c;
            localObject4 = HardCodeUtil.a(2131706623) + localJSONException.getApp().getString(2131697704);
            if (bool1)
            {
              if (((String)localObject1).startsWith((String)localObject4))
              {
                i = 3;
                break label7245;
              }
              if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
                break label7248;
              }
              i = 4;
              break label7245;
            }
            if (bool2)
            {
              if (((String)localObject1).startsWith((String)localObject4))
              {
                i = 5;
                break label7245;
              }
              if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
                break label7254;
              }
              i = 6;
              break label7245;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label7260;
            }
            i = 7;
            break label7245;
          }
          if (paramView.istroop == 3000)
          {
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label7266;
            }
            i = 9;
          }
          else
          {
            bool1 = paramView.senderuin.equals(localJSONException.getCurrentAccountUin());
            if (bool1)
            {
              i = 11;
            }
            else
            {
              i = 12;
              continue;
              if ((!(this.context instanceof ChatActivity)) && (!(this.context instanceof SplashActivity))) {
                break;
              }
              paramView = (FragmentActivity)this.context;
              if ((paramView.getChatFragment() != null) && (paramView.getChatFragment().a() != null) && ((this.message instanceof ChatMessage)))
              {
                paramView.getChatFragment().a().a((ChatMessage)this.message);
                ((TroopEnterEffectManager)localJSONException.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER)).a(this.item.mMsgActionData);
                if (QLog.isColorLevel()) {
                  QLog.d("TroopEnterEffect", 2, "click nolongerPrompt id = " + this.item.mMsgActionData);
                }
              }
              if ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
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
              VasWebviewUtil.reportCommercialDrainage(localJSONException.getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "3");
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
              VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "1");
              return;
              if ((this.mApp.get() == null) || (this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
                break;
              }
              LoverZoneUtils.a((QQAppInterface)this.mApp.get(), this.context, 2080, "6");
              return;
              if (TeamWorkUtils.a()) {
                break;
              }
              try
              {
                paramView = String.valueOf(this.item.uin);
                localObject1 = this.item.mMsg_A_ActionData;
                localObject3 = this.item.mMsgActionData.split("@#@");
                localObject4 = localObject3[0];
                l = Long.parseLong(localObject3[1]);
                i = this.message.istroop;
                localObject1 = TeamWorkUtils.a((String)localObject4, paramView, (String)localObject1);
                QLog.i("MessageForGrayTips" + TeamWorkConstants.i, 1, "click to modify tencent docs auth. frienduin = " + paramView + ", uinType = " + i + ", msgSeq = " + l + ", docsGrayTipsInfo = " + localObject1);
                if (localObject1 == null) {
                  break;
                }
                if (((DocsGrayTipsInfo)localObject1).s.equals(TeamWorkConstants.k))
                {
                  paramView = ((DocsGrayTipsInfo)localObject1).t;
                  if (TextUtils.isEmpty(paramView)) {
                    break;
                  }
                  TeamWorkUtils.a(this.context, paramView);
                  ReportController.b(null, "dc00898", "", "", "0X8009C79", "0X8009C79", 0, 0, "", "", "", "");
                  return;
                }
              }
              catch (Exception paramView)
              {
                QLog.e("MessageForGrayTips" + TeamWorkConstants.i, 1, " docs gray tips action exception =" + paramView.toString());
                return;
              }
            }
          }
        }
        paramView = (TeamWorkHandler)((QQAppInterface)this.mApp.get()).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
        if (i == 1)
        {
          paramView.b((DocsGrayTipsInfo)localObject1, l);
          return;
        }
        paramView.a((DocsGrayTipsInfo)localObject1, l);
        return;
        Object localObject3 = (QQAppInterface)this.mApp.get();
        if ((localObject3 == null) || (!ConfessConfig.a((AppInterface)localObject3))) {
          break;
        }
        if (this.message.isSelfConfessor()) {
          paramView = ((QQAppInterface)localObject3).getAccount();
        }
        for (localObject1 = this.message.frienduin;; localObject1 = ((QQAppInterface)localObject3).getAccount())
        {
          ConfessConfig.b((QQAppInterface)localObject3, UinTypeUtil.a(this.message.frienduin, this.message.istroop, this.message.getConfessTopicId()), false);
          localObject4 = (ConfessHandler)((QQAppInterface)localObject3).getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER);
          if (localObject4 != null) {
            ((ConfessHandler)localObject4).notifyUI(9, true, new Object[] { this.message.frienduin, Integer.valueOf(this.message.getConfessTopicId()), Integer.valueOf(this.message.istroop) });
          }
          ConfessConfig.a((AppInterface)localObject3, this.context, paramView, (String)localObject1, this.message.getConfessTopicId(), this.message.isSelfConfessor());
          ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "0X8009574", "0X8009574", 0, 0, this.message.getConfessTopicId() + "", "", paramView, (String)localObject1);
          return;
          paramView = this.message.frienduin;
        }
        i = this.message.istroop;
        if ((i != 1044) && (i != 1045)) {
          break;
        }
        LimitChatUtil.a(this.context, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
        return;
        if (this.context == null) {
          break;
        }
        if (SettingsConfigHelper.a((AppInterface)localObject3)) {
          PublicFragmentActivity.a(this.context, NewTempMsgSettingFragment.class);
        }
        for (;;)
        {
          j = 0;
          try
          {
            i = Integer.parseInt(this.item.mMsgActionData);
            ReportController.b(null, "dc00898", "", "", "0X800997A", "0X800997A", i, i, "", "", "", "");
            return;
            PublicFragmentActivity.a(this.context, TempMsgSettingFragment.class);
          }
          catch (NumberFormatException paramView)
          {
            for (;;)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("MessageForGrayTips", 2, "NumberFormatException: " + this.item.mMsgActionData);
                i = j;
              }
            }
          }
        }
        paramView = TroopInfoActivity.a(this.item.mMsgActionData, 2);
        paramView.putInt("t_s_f", 1000);
        TroopUtils.a(this.context, paramView, 2);
        ReportController.b(null, "dc00898", "", "", "0X800997B", "0X800997B", 0, 0, "", "", "", "");
        return;
        if (MsgNotifyPushDialog.d) {
          this.context.startActivity(MsgNotifyPushDialog.a);
        }
        for (;;)
        {
          try
          {
            i = Integer.parseInt(this.item.mMsgActionData);
            ReportController.b(null, "dc00898", "", "", "0X8009AD0", "0X8009AD0", i, i, "", "", "", "");
            return;
          }
          catch (NumberFormatException paramView) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MessageForGrayTips", 2, "NumberFormatException: " + this.item.mMsgActionData);
          return;
          if (this.mApp != null) {
            ThreadManager.executeOnSubThread(new MessageForGrayTips.HightlightClickableSpan.3(this));
          } else if (QLog.isColorLevel()) {
            QLog.d("MessageForGrayTips", 2, "ACTION_FROM_MESSAGE_GOTO_PUSH_NOTIFICATION_SWITCH_SETTING= mApp==null");
          }
        }
        TogetherControlManager.a((QQAppInterface)this.mApp.get()).a((BaseActivity)this.context, 2, 1, this.message.frienduin, 0L, 10, new Bundle());
        return;
        if (SettingsConfigHelper.a((AppInterface)localObject3))
        {
          paramView = new Intent();
          PublicFragmentActivity.a(this.context, paramView, AssistantSettingFragment.class);
          return;
        }
        paramView = new Intent(this.context, AssistantSettingActivity.class);
        this.context.startActivity(paramView);
        return;
        paramView = this.item.mMsg_A_ActionData;
        localObject1 = this.item.mMsgActionData;
        if ((!TextUtils.isEmpty(paramView)) && (paramView.contains("docs.qq.com/form"))) {
          TeamWorkUtils.a(this.context, paramView, (String)localObject1);
        }
        for (;;)
        {
          ReportController.b(null, "dc00898", "", this.frienduin, "0X8009FD1", "0X8009FD1", 0, 0, "", "", "", "");
          return;
          if (TeamWorkUtils.a(paramView)) {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.context, paramView, 0, null);
          }
        }
        if ((this.context instanceof FragmentActivity))
        {
          paramView = ((FragmentActivity)this.context).getChatFragment();
          if ((paramView != null) && (paramView.a() != null))
          {
            paramView = paramView.a();
            if ((paramView instanceof FriendChatPie)) {
              ((FriendChatPie)paramView).a();
            }
          }
        }
        ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "0X800A013", "0X800A013", 0, 0, "", "", "", "");
        return;
        paramView = new ProfileActivity.AllInOne(this.item.mMsgActionData, 1);
        ProfileActivity.b(this.context, paramView);
        return;
        showDeleteDialog((QQAppInterface)this.mApp.get());
        return;
        if (this.message == null) {
          break;
        }
        if (this.message.istroop == 1)
        {
          ListenTogetherUtils.a((QQAppInterface)localObject3, this.context, 1, this.frienduin, 0);
          return;
        }
        if (this.message.istroop != 0) {
          break;
        }
        ListenTogetherUtils.a((QQAppInterface)this.mApp.get(), this.context, 2, this.frienduin, 0);
        return;
        if (this.message == null) {
          break;
        }
        ListenTogetherUtils.a(this.context, this.message.istroop, this.frienduin);
        return;
        if (!(this.context instanceof FragmentActivity)) {
          break;
        }
        paramView = ((FragmentActivity)this.context).getChatFragment();
        if ((paramView == null) || (paramView.a() == null) || (!(paramView.a() instanceof TroopChatPie))) {
          break;
        }
        paramView = (TroopChatPie)paramView.a();
        localObject1 = paramView.b();
        if ((TextUtils.isEmpty(this.frienduin)) || (!this.frienduin.equals(localObject1)) || (!(this.message instanceof ChatMessage))) {
          break;
        }
        ((SpecWordEmotionThinkHelper)paramView.a(41)).a(1);
        ((TroopManager)((QQAppInterface)localObject3).getManager(QQManagerFactory.TROOP_MANAGER)).a().a((QQAppInterface)localObject3, this.context, paramView.a, this.frienduin, 0, (ChatMessage)this.message);
        com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.c = 3;
        com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.a = this.message.senderuin;
        new ReportTask((QQAppInterface)localObject3).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_bar").a(new String[] { localObject1, "", "" + TroopUtils.b((QQAppInterface)localObject3, (String)localObject1) }).a();
        return;
        paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(QQManagerFactory.TROOP_MANAGER)).c(this.frienduin);
        localObject1 = new ArrayList(Arrays.asList(this.item.mMsgActionData.split(",")));
        LpReportInfo_pf00064.allReport(40, 3, 2);
        QZoneHelper.forwardToTroopUploadPhoto((Activity)this.context, ((QQAppInterface)localObject3).getCurrentUin(), 1, 0, Long.parseLong(this.frienduin), paramView.troopname, "$RecentAlbumId", AlbumConstants.d, (ArrayList)localObject1, -1, 0, 3);
        return;
        i = QzoneConfig.getInstance().getConfig("aio_qzone_troop_gray_tips", "troop_gray_tips_cool_down", 24);
        paramView = String.format(HardCodeUtil.a(2131720183), new Object[] { Integer.valueOf(i) });
        QQToast.a(BaseApplication.getContext(), 0, paramView, 0).a();
        LocalMultiProcConfig.putLong4Uin("aio_qzone_troop_gray_tips", System.currentTimeMillis() / 1000L + i * 60 * 60, this.item.uin);
        ChatActivityFacade.a(this.context, (QQAppInterface)localObject3, (ChatMessage)this.message);
        LpReportInfo_pf00064.allReport(40, 3, 3);
        return;
        TroopUtils.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsg_A_ActionData, this.item.mMsgActionData);
        return;
        TroopUtils.a((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData);
        return;
        TroopUtils.a((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
        return;
        doAddFriendSafetyReport((QQAppInterface)localObject3);
        return;
        CustomizeGrayTipsManager.a((QQAppInterface)localObject3, this.context, "1", this.message.istroop);
        return;
        AioLimitColdPalaceHelper.a(this.context);
        return;
        TroopEssenceUtil.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsgActionData);
        return;
        ((PaiYiPaiManager)((QQAppInterface)localObject3).getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a(this);
        TroopUtils.b((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
        return;
        paramView = ((QQAppInterface)localObject3).getHandler(ChatActivity.class);
        if (paramView == null) {
          break;
        }
        localObject1 = (IApolloManagerService)((QQAppInterface)localObject3).getRuntimeService(IApolloManagerService.class, "all");
        ((IApolloManagerService)localObject1).setOpenType(1);
        try
        {
          ((IApolloManagerService)localObject1).setOpenType(Integer.parseInt(this.item.mMsgActionData));
          label7036:
          paramView.obtainMessage(49).sendToTarget();
          if (this.message == null) {
            break;
          }
          VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "opencm_guideword_click", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.message.istroop), 0, new String[0]);
          ApolloDtReportUtil.a("aio_bubble", "apollo_tips", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a((QQAppInterface)localObject3)).b(ApolloDtReportUtil.a(this.message.istroop)).a(this.message.msg).b(this.frienduin).a());
          return;
          TroopShortcutBarUtil.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsgActionData);
          return;
          TroopShortcutBarUtil.a((QQAppInterface)this.mApp.get(), this.frienduin, this.item.mMsgActionData);
          return;
        }
        catch (Throwable localThrowable)
        {
          break label7036;
        }
      }
      label7207:
      i = -1;
      continue;
      paramView = "";
      break label2535;
      label7218:
      break label2298;
      paramView = "";
      break label902;
      i = 1;
      break label587;
      j += 1;
      break label3850;
      label7239:
      bool1 = false;
      break label4011;
      for (;;)
      {
        label7245:
        break;
        label7248:
        i = 8;
        continue;
        label7254:
        i = 8;
        continue;
        label7260:
        i = 8;
      }
      label7266:
      i = 10;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */