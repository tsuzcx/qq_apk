package com.tencent.mobileqq.structmsg;

import aimu;
import aimv;
import aimw;
import aimx;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12.ViewHolder;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.babyq.babyq_cookie.BabyQCookie;

public class StructMsgForGeneralShare$GeneralClickHandler
  extends StructMsgClickHandler
{
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  StructMsgForGeneralShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    super(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = paramStructMsgForGeneralShare;
    paramQQAppInterface = paramView.getTag();
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
    {
      paramQQAppInterface = (StructingMsgItemBuilder.StructingMsgViewHolder)paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    }
    while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof ChatHistoryStructAdapter.HistoryStructItemHolder))) {
      return;
    }
    paramQQAppInterface = (ChatHistoryStructAdapter.HistoryStructItemHolder)paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)paramQQAppInterface.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramQQAppInterface.jdField_a_of_type_JavaLangString;
  }
  
  private void a(Bundle paramBundle)
  {
    ThreadManager.post(new aimu(this, paramBundle), 5, null, false);
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "the share url is" + paramString);
      }
      if (!paramString.contains("ciphertext"))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.b = null;
        if ((paramString.startsWith("http://mobile.qzone.qq.com")) || (paramString.startsWith("https://mobile.qzone.qq.com"))) {
          try
          {
            paramString = Uri.parse(paramString);
            String str = paramString.getQueryParameter("a");
            if ("311".equals(str)) {
              return true;
            }
            if ("2".equals(str)) {
              return true;
            }
            if ("4".equals(str))
            {
              this.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("albumid");
              this.b = paramString.getQueryParameter("res_uin");
              return true;
            }
          }
          catch (Exception paramString)
          {
            QLog.e(StructMsgForGeneralShare.access$000(), 1, "isNotPermissionUGC catch an exception", paramString);
          }
        }
      }
    }
    return false;
  }
  
  private boolean d(String paramString)
  {
    this.c = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("is_famous_space=1")) && (paramString.contains("qzone"))) {
      try
      {
        this.c = Uri.parse(paramString).getQueryParameter("hostuin");
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e(StructMsgForGeneralShare.access$000(), 1, "isForwardToNativeUserHome catch an exception", paramString);
        return false;
      }
    }
    return false;
  }
  
  public boolean a(View paramView, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare == null) || (TextUtils.isEmpty(paramString))) {}
    label44:
    Object localObject;
    label111:
    label113:
    do
    {
      return false;
      paramView = paramView.findViewById(2131362107);
      if (paramView == null)
      {
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mStructMsgItemLists.size() > 0)
        {
          i = 1;
          if (!QLog.isColorLevel()) {
            break label111;
          }
          paramString = StructMsgForGeneralShare.access$000();
          localObject = new StringBuilder().append("clickViewFlower error item:");
          if (i == 0) {
            break label113;
          }
        }
        for (paramView = ((AbsStructMsgElement)this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mStructMsgItemLists.get(0)).h;; paramView = "")
        {
          QLog.i(paramString, 2, paramView);
          return false;
          i = 0;
          break label44;
          break;
        }
      }
      paramView = (StructMsgItemLayout12.ViewHolder)paramView.getTag();
    } while (paramView == null);
    paramView = paramView.a;
    boolean bool2;
    if ((paramView != null) && (paramView.size() > 0))
    {
      localObject = paramView.getString("groupCode");
      boolean bool1 = paramView.getBoolean("isSend");
      bool2 = paramView.getBoolean("isReceive");
      if ((!bool1) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramString)) && (!bool2))
      {
        paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if (paramView != null) {}
        for (paramView = paramView.a(paramString);; paramView = null)
        {
          if (paramView != null) {
            HotChatUtil.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, 1);
          }
          return true;
        }
      }
      if (!bool1) {
        break label284;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label272;
      }
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006390");
    }
    for (;;)
    {
      return true;
      label272:
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80060B3");
      continue;
      label284:
      if (bool2) {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006391");
        } else {
          NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80060B4");
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickWebMsg url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject4 = this.jdField_a_of_type_AndroidContentContext;
    StructMsgForGeneralShare localStructMsgForGeneralShare = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
    for (;;)
    {
      try
      {
        str2 = localStructMsgForGeneralShare.uin;
        if (localStructMsgForGeneralShare.uinType != 1) {
          continue;
        }
        i = 2;
        localObject5 = Long.toString(localStructMsgForGeneralShare.mSourceAppid);
        localObject6 = Integer.toString(localStructMsgForGeneralShare.mMsgServiceID);
        if ((paramString == null) || (paramString.length() <= 150)) {
          continue;
        }
        localObject1 = paramString.substring(0, 150);
      }
      catch (Exception localException1)
      {
        String str2;
        Object localObject1;
        boolean bool;
        localException1.printStackTrace();
        continue;
        localObject3 = new BaseBusinessAlbumInfo();
        ((BaseBusinessAlbumInfo)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        try
        {
          if (TextUtils.isEmpty(this.b)) {
            continue;
          }
          l = Long.parseLong(this.b);
          ((BaseBusinessAlbumInfo)localObject3).jdField_a_of_type_Long = l;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "Parsing the albumOwnUin catch a NumberFormatException : " + localNumberFormatException.getMessage());
          continue;
        }
        ((BaseBusinessAlbumInfo)localObject3).c = 0;
        ((BaseBusinessAlbumInfo)localObject3).jdField_a_of_type_Boolean = true;
        QZoneHelper.a((Activity)localObject4, localException1, (BaseBusinessAlbumInfo)localObject3, -1, paramString);
        continue;
        long l = 0L;
        continue;
        if ((!d(paramString)) || (TextUtils.isEmpty(this.c))) {
          continue;
        }
        paramString = QZoneHelper.UserInfo.a();
        paramString.jdField_a_of_type_JavaLangString = str2;
        paramString.b = ((QQAppInterface)localObject3).getCurrentNickname();
        QZoneHelper.a((Activity)localObject4, paramString, this.c, 0, 0, 0);
        continue;
        if (!TeamWorkUtils.a(paramString)) {
          continue;
        }
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putString("url", paramString);
        TeamWorkDocEditBrowserActivity.a((Context)localObject4, (Bundle)localObject2, false);
        return true;
        if (!StructingMsgItemBuilder.a((QQAppInterface)localObject3, (ChatMessage)localNumberFormatException.message)) {
          continue;
        }
        paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("url", (String)localObject2);
        paramString.putExtra("troopUin", localNumberFormatException.message.frienduin);
        paramString.putExtra("articalChannelId", 3);
        paramString.putExtra("key_isReadModeEnabled", true);
        if (localNumberFormatException.message.istroop != 0) {
          continue;
        }
        paramString.putExtra("friend_uin", localNumberFormatException.message.frienduin);
        if (localNumberFormatException.message.istroop != 1) {
          continue;
        }
        paramString.putExtra("groupUin", localNumberFormatException.message.frienduin);
        if (localNumberFormatException.message.istroop != 3000) {
          continue;
        }
        paramString.putExtra("dicussgroup_uin", localNumberFormatException.message.frienduin);
        paramString.putExtra("friendUin", localNumberFormatException.message.senderuin);
        paramString.putExtra("uinType", localNumberFormatException.message.istroop);
        paramString.putExtra("fromAio", true);
        if (!(localNumberFormatException.message instanceof MessageForStructing)) {
          continue;
        }
        paramString.putExtra("msgseq", ((MessageForStructing)localNumberFormatException.message).shmsgseq);
        localObject4 = ((TroopTopicMgr)((QQAppInterface)localObject3).getManager(97)).a((ChatMessage)localNumberFormatException.message);
        if (localObject4 == null) {
          continue;
        }
        paramString.putExtra("is_zan", ((TroopTopicDetailInfo)localObject4).mIsZan);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
        try
        {
          paramString = new URL((String)localObject2).getHost();
          ReportController.b((QQAppInterface)localObject3, "dc00899", "Grp_talk", "", "obj", "link_detail", 0, 0, "" + localNumberFormatException.message.frienduin, paramString, "", URLEncoder.encode((String)localObject2, "utf-8"));
          return false;
        }
        catch (MalformedURLException paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "isDomainInWhiteList exception: " + paramString.getMessage());
          continue;
        }
        catch (UnsupportedEncodingException paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "isDomainInWhiteList exception: " + paramString.getMessage());
          continue;
        }
        Object localObject5 = new Intent((Context)localObject4, QQBrowserDelegationActivity.class);
        ((Intent)localObject5).putExtra("param_force_internal_browser", true);
        if (!bool) {
          continue;
        }
        paramString = HtmlOffline.a(paramString, "platformId=qq_m");
        Object localObject6 = paramString.trim();
        ((Intent)localObject5).putExtra("injectrecommend", false);
        ((Intent)localObject5).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject5).putExtra("url", (String)localObject6);
        ((Intent)localObject5).putExtra("friendUin", localNumberFormatException.uin);
        ((Intent)localObject5).putExtra("isAppShare", true);
        ((Intent)localObject5).putExtra("appShareID", l);
        ((Intent)localObject5).putExtra("uin_type", localNumberFormatException.uinType);
        ((Intent)localObject5).putExtra("msg_id", Long.toString(localNumberFormatException.msgId));
        ((Intent)localObject5).putExtra("puin", localNumberFormatException.uin);
        ((Intent)localObject5).putExtra("self_uin", str2);
        if (localNumberFormatException.message == null) {
          continue;
        }
        ((Intent)localObject5).putExtra("friend_uin", localNumberFormatException.message.frienduin);
        if ((TextUtils.isEmpty((CharSequence)localObject6)) || (!Utils.b(localNumberFormatException.uin))) {
          continue;
        }
        paramString = ((String)localObject6).split("&");
        if (paramString == null) {
          continue;
        }
        int i = 0;
        if (i >= paramString.length) {
          continue;
        }
        if (!paramString[i].contains("from_type")) {
          continue;
        }
        Object localObject7 = paramString[i].split("=");
        if ((localObject7 == null) || (localObject7.length != 2)) {
          continue;
        }
        localObject7 = localObject7[1];
        Object localObject8 = localNumberFormatException.mMsg_I_ActionData.split(":");
        if ((localObject8 == null) || (localObject8.length != 2)) {
          continue;
        }
        localObject8 = localObject8[1];
        if ((TextUtils.isEmpty((CharSequence)localObject7)) || (TextUtils.isEmpty((CharSequence)localObject8))) {
          continue;
        }
        paramString = new Bundle();
        paramString.putString("src_type", "internal");
        paramString.putString("version", "1");
        paramString.putString("callback_type", "scheme");
        paramString.putString("callback_name", "open_card");
        paramString.putString("uin", (String)localObject8);
        paramString.putString("card_type", "group");
        paramString.putString("authKey", null);
        paramString.putString("from", "qrcode");
        if (TextUtils.isEmpty((CharSequence)localObject7)) {
          continue;
        }
        paramString.putString("from_type", (String)localObject7);
        paramString.putString("jump_from", "QRJumpActivity");
        paramString = JumpParser.a((QQAppInterface)localObject3, (Context)localObject4, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(paramString)).toString());
        if (paramString == null) {
          continue;
        }
        paramString.b();
        return true;
        i += 1;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 0) || (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("guide_msg_cookie")))) {
          continue;
        }
        paramString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("guide_msg_cookie"));
        if (paramString == null) {
          continue;
        }
        localObject7 = new babyq_cookie.BabyQCookie();
        try
        {
          ((babyq_cookie.BabyQCookie)localObject7).mergeFrom(paramString);
          if (((babyq_cookie.BabyQCookie)localObject7).uint32_type.get() == 206) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("babyq_game_tribe");
          }
          ((Intent)localObject5).putExtra("source_puin", localNumberFormatException.source_puin);
          if (localNumberFormatException.uinType == 0)
          {
            ((Intent)localObject5).putExtra("articalChannelId", 2);
            AIOOpenWebMonitor.a((Intent)localObject5, (QQAppInterface)localObject3, localNumberFormatException.message);
            if ((PublicAccountUtil.a((QQAppInterface)localObject3, localNumberFormatException.uin) != -1) || (((String)localObject6).startsWith("http://browserApp.p.qq.com/")))
            {
              ((Intent)localObject5).setClass((Context)localObject4, PublicAccountBrowser.class);
              paramString = new Bundle();
              paramString.putString("uin", localNumberFormatException.uin);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
              {
                paramString.putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                paramString.putString("uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              }
              paramString.putBoolean("switch_msg_btn", PublicAccountUtil.a());
              ((Intent)localObject5).putExtras(paramString);
            }
            if ((localNumberFormatException.mMsgServiceID == 116) || (localNumberFormatException.mMsgServiceID == 123))
            {
              if (localNumberFormatException.uinType != 1) {
                continue;
              }
              paramString = ((Intent)localObject5).getStringExtra("url");
              if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(localNumberFormatException.uin)))
              {
                paramString = String.format("%s&gc=%s", new Object[] { paramString, NearbyURLSafeUtil.a(localNumberFormatException.uin) });
                if (QLog.isColorLevel()) {
                  QLog.i(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickWebMsg confess groupUin:" + localNumberFormatException.uin);
                }
                ((Intent)localObject5).removeExtra("url");
                ((Intent)localObject5).putExtra("url", paramString);
              }
              ThreadManager.post(new aimw(this, (QQAppInterface)localObject3), 5, null, true);
            }
            if ((localNumberFormatException.mMsgServiceID == 83) || (localNumberFormatException.mMsgServiceID == 108) || (localNumberFormatException.mMsgServiceID == 114) || (localNumberFormatException.mMsgServiceID == 116))
            {
              paramString = "";
              localObject2 = Uri.parse((String)localObject2);
            }
          }
          try
          {
            localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
            paramString = (String)localObject2;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            continue;
            StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject3, "sha_click", 1, "", "", String.valueOf(localNumberFormatException.mSourceAppid));
          }
          if (TextUtils.isEmpty(localNumberFormatException.mMsgActionData)) {
            continue;
          }
          i = 1;
          PublicAccountReportUtils.a(null, "", "0X8007555", "0X8007555", 0, 0, paramString, "", "" + i, "");
          PublicAccountReportUtils.a("0X8007555", "", paramString, "", "" + i, "");
          if (localNumberFormatException.mSourceAppid == 1101244924L)
          {
            ((Intent)localObject5).putExtra("BUDNLE_KEY_IS_MY_PROFILE", ((String)localObject6).contains("gene/index.html?uin=" + localNumberFormatException.currentAccountUin));
            ((Intent)localObject5).setClass((Context)localObject4, MusicGeneQQBrowserActivity.class);
          }
          PublicAccountUtil.a(localNumberFormatException.message, (Intent)localObject5, (String)localObject6);
          WebAccelerator.a((Context)localObject4, (Intent)localObject5, (String)localObject6);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject6, "", "", "");
          if (bool) {
            StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject3, str2, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localNumberFormatException.mSourceAppid), null, null, null);
          }
        }
        catch (InvalidProtocolBufferMicroException paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "babbyq -> sendSpecialMessage:" + paramString.getStackTrace());
          continue;
          if (localNumberFormatException.uinType == 1)
          {
            ((Intent)localObject5).putExtra("articalChannelId", 3);
            continue;
          }
          if (localNumberFormatException.uinType == 3000)
          {
            ((Intent)localObject5).putExtra("articalChannelId", 4);
            continue;
          }
          if (localNumberFormatException.uinType != 1008) {
            continue;
          }
          ((Intent)localObject5).putExtra("articalChannelId", 1);
          ((Intent)localObject5).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
          continue;
          ThreadManager.post(new aimx(this, (QQAppInterface)localObject3), 5, null, true);
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
          continue;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
        if (52 != localNumberFormatException.mMsgServiceID) {
          continue;
        }
        if (!paramString.equals(str2)) {
          continue;
        }
        ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "0X80052BB", "0X80052BB", 0, 0, "", "", "", "");
        continue;
        ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "0X80052BC", "0X80052BC", 0, 0, "", "", "", "");
        continue;
        i = 2;
        continue;
        continue;
        String str1 = paramString;
        continue;
      }
      localObject7 = new URL(paramString).getHost();
      ReportController.b(null, "CliOper", "", str2, "0X80061B0", "0X80061B0", i, 0, (String)localObject5, (String)localObject6, (String)localObject1, (String)localObject7);
      if (QLog.isDebugVersion()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 4, String.format("the report params:%s,%s,%s,%s", new Object[] { localObject5, localObject6, localObject1, localObject7 }));
      }
      localObject1 = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mMsgServiceID == 107)
      {
        localObject1 = paramString + "&msgSeq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uniseq + "&resId=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mResid + "&uin=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin + "&sessionType=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uinType;
        if (StructMsgForGeneralShare.receiptServer == null) {
          StructMsgForGeneralShare.receiptServer = new aimv(this, "receipt_msg");
        }
        QIPCServerHelper.getInstance().register(StructMsgForGeneralShare.receiptServer);
      }
      paramString = ((String)localObject1).trim();
      bool = paramString.startsWith("http://gamecenter.qq.com");
      l = AppShareIDUtil.a(localStructMsgForGeneralShare.mSourceAppid);
      str2 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      if ((localObject4 instanceof FragmentActivity))
      {
        localObject5 = ((FragmentActivity)localObject4).getChatFragment();
        if (localObject5 != null)
        {
          localObject5 = ((ChatFragment)localObject5).a();
          if ((localObject5 instanceof PublicAccountChatPie))
          {
            localObject6 = (PublicAccountChatPie)localObject5;
            ((PublicAccountChatPie)localObject6).v += 1;
            localObject5 = (PublicAccountChatPie)localObject5;
            ((PublicAccountChatPie)localObject5).t += 1;
          }
        }
      }
      if (!c(paramString)) {
        continue;
      }
      localObject1 = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = str2;
      ((QZoneHelper.UserInfo)localObject1).b = ((QQAppInterface)localObject3).getCurrentNickname();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      QZoneHelper.a((Activity)localObject4, (QZoneHelper.UserInfo)localObject1, paramString, "mqqChat", -1);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.istroop == 1008)) {
        PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
      }
      return false;
      i = 1;
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickPluginMsg actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString1 = JumpParser.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (paramString1 == null) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.senderuin))) {
        paramString1.a("msg_uniseq", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.senderuin);
      }
      paramString1.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.istroop == 1008)) {
        PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
      }
      return true;
      paramString1 = paramString2;
    }
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralShareMsg _ACTION_PLUGIN_ mContentOnClickListener: JumpAction is null.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler
 * JD-Core Version:    0.7.0.1
 */