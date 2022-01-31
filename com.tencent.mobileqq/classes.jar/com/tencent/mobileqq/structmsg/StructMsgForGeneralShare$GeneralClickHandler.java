package com.tencent.mobileqq.structmsg;

import ahty;
import ahtz;
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
    ThreadManager.post(new ahty(this, paramBundle), 5, null, false);
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject3 = this.jdField_a_of_type_AndroidContentContext;
    StructMsgForGeneralShare localStructMsgForGeneralShare = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
    Object localObject1 = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mMsgServiceID == 107)
    {
      localObject1 = paramString + "&msgSeq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uniseq + "&resId=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mResid + "&uin=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin + "&sessionType=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uinType;
      if (StructMsgForGeneralShare.receiptServer == null) {
        StructMsgForGeneralShare.receiptServer = new ahtz(this, "receipt_msg");
      }
      QIPCServerHelper.getInstance().register(StructMsgForGeneralShare.receiptServer);
    }
    paramString = ((String)localObject1).trim();
    boolean bool = paramString.startsWith("http://gamecenter.qq.com");
    long l = AppShareIDUtil.a(localStructMsgForGeneralShare.mSourceAppid);
    String str = ((QQAppInterface)localObject2).getCurrentAccountUin();
    Object localObject5;
    if ((localObject3 instanceof FragmentActivity))
    {
      localObject4 = ((FragmentActivity)localObject3).getChatFragment();
      if (localObject4 != null)
      {
        localObject4 = ((ChatFragment)localObject4).a();
        if ((localObject4 instanceof PublicAccountChatPie))
        {
          localObject5 = (PublicAccountChatPie)localObject4;
          ((PublicAccountChatPie)localObject5).v += 1;
          localObject4 = (PublicAccountChatPie)localObject4;
          ((PublicAccountChatPie)localObject4).t += 1;
        }
      }
    }
    if (c(paramString))
    {
      localObject1 = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = str;
      ((QZoneHelper.UserInfo)localObject1).b = ((QQAppInterface)localObject2).getCurrentNickname();
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        QZoneHelper.a((Activity)localObject3, (QZoneHelper.UserInfo)localObject1, paramString, "mqqChat", -1);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.istroop == 1008)) {
        PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
      }
      return false;
      localObject2 = new BaseBusinessAlbumInfo();
      ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(this.b)) {
            continue;
          }
          l = Long.parseLong(this.b);
          ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_Long = l;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "Parsing the albumOwnUin catch a NumberFormatException : " + localNumberFormatException.getMessage());
          continue;
        }
        ((BaseBusinessAlbumInfo)localObject2).c = 0;
        ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_Boolean = true;
        QZoneHelper.a((Activity)localObject3, (QZoneHelper.UserInfo)localObject1, (BaseBusinessAlbumInfo)localObject2, -1, paramString);
        break;
        l = 0L;
      }
      if ((!d(paramString)) || (TextUtils.isEmpty(this.c))) {
        break;
      }
      paramString = QZoneHelper.UserInfo.a();
      paramString.jdField_a_of_type_JavaLangString = str;
      paramString.b = ((QQAppInterface)localObject2).getCurrentNickname();
      QZoneHelper.a((Activity)localObject3, paramString, this.c, 0, 0, 0);
    }
    if (TeamWorkUtils.a(paramString))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("url", paramString);
      TeamWorkDocEditBrowserActivity.a((Context)localObject3, (Bundle)localObject1, false);
      return true;
    }
    if (StructingMsgItemBuilder.a((QQAppInterface)localObject2, (ChatMessage)localNumberFormatException.message))
    {
      paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("url", (String)localObject1);
      paramString.putExtra("troopUin", localNumberFormatException.message.frienduin);
      paramString.putExtra("articalChannelId", 3);
      paramString.putExtra("key_isReadModeEnabled", true);
      if (localNumberFormatException.message.istroop == 0) {
        paramString.putExtra("friend_uin", localNumberFormatException.message.frienduin);
      }
      if (localNumberFormatException.message.istroop == 1) {
        paramString.putExtra("groupUin", localNumberFormatException.message.frienduin);
      }
      if (localNumberFormatException.message.istroop == 3000) {
        paramString.putExtra("dicussgroup_uin", localNumberFormatException.message.frienduin);
      }
      paramString.putExtra("friendUin", localNumberFormatException.message.senderuin);
      paramString.putExtra("uinType", localNumberFormatException.message.istroop);
      paramString.putExtra("fromAio", true);
      if ((localNumberFormatException.message instanceof MessageForStructing)) {
        paramString.putExtra("msgseq", ((MessageForStructing)localNumberFormatException.message).shmsgseq);
      }
      localObject3 = ((TroopTopicMgr)((QQAppInterface)localObject2).getManager(97)).a((ChatMessage)localNumberFormatException.message);
      if (localObject3 != null) {
        paramString.putExtra("is_zan", ((TroopTopicDetailInfo)localObject3).mIsZan);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      try
      {
        paramString = new URL((String)localObject1).getHost();
        ReportController.b((QQAppInterface)localObject2, "dc00899", "Grp_talk", "", "obj", "link_detail", 0, 0, "" + localNumberFormatException.message.frienduin, paramString, "", URLEncoder.encode((String)localObject1, "utf-8"));
        return false;
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(StructMsgForGeneralShare.access$000(), 2, "isDomainInWhiteList exception: " + paramString.getMessage());
          }
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(StructMsgForGeneralShare.access$000(), 2, "isDomainInWhiteList exception: " + paramString.getMessage());
          }
        }
      }
    }
    Object localObject4 = new Intent((Context)localObject3, QQBrowserDelegationActivity.class);
    ((Intent)localObject4).putExtra("param_force_internal_browser", true);
    if (bool) {
      paramString = HtmlOffline.a(paramString, "platformId=qq_m");
    }
    for (;;)
    {
      localObject5 = paramString.trim();
      ((Intent)localObject4).putExtra("injectrecommend", false);
      ((Intent)localObject4).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject4).putExtra("url", (String)localObject5);
      ((Intent)localObject4).putExtra("friendUin", localNumberFormatException.uin);
      ((Intent)localObject4).putExtra("isAppShare", true);
      ((Intent)localObject4).putExtra("appShareID", l);
      ((Intent)localObject4).putExtra("uin_type", localNumberFormatException.uinType);
      ((Intent)localObject4).putExtra("msg_id", Long.toString(localNumberFormatException.msgId));
      ((Intent)localObject4).putExtra("puin", localNumberFormatException.uin);
      ((Intent)localObject4).putExtra("self_uin", str);
      if (localNumberFormatException.message != null) {
        ((Intent)localObject4).putExtra("friend_uin", localNumberFormatException.message.frienduin);
      }
      int i;
      Object localObject6;
      if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (Utils.b(localNumberFormatException.uin)))
      {
        paramString = ((String)localObject5).split("&");
        if (paramString != null)
        {
          i = 0;
          while (i < paramString.length)
          {
            if (paramString[i].contains("from_type"))
            {
              localObject6 = paramString[i].split("=");
              if ((localObject6 != null) && (localObject6.length == 2))
              {
                localObject6 = localObject6[1];
                Object localObject7 = localNumberFormatException.mMsg_I_ActionData.split(":");
                if ((localObject7 != null) && (localObject7.length == 2))
                {
                  localObject7 = localObject7[1];
                  if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject7)))
                  {
                    paramString = new Bundle();
                    paramString.putString("src_type", "internal");
                    paramString.putString("version", "1");
                    paramString.putString("callback_type", "scheme");
                    paramString.putString("callback_name", "open_card");
                    paramString.putString("uin", (String)localObject7);
                    paramString.putString("card_type", "group");
                    paramString.putString("authKey", null);
                    paramString.putString("from", "qrcode");
                    if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                      paramString.putString("from_type", (String)localObject6);
                    }
                    paramString.putString("jump_from", "QRJumpActivity");
                    paramString = JumpParser.a((QQAppInterface)localObject2, (Context)localObject3, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(paramString)).toString());
                    if (paramString != null) {
                      paramString.b();
                    }
                    return true;
                  }
                }
              }
            }
            i += 1;
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("guide_msg_cookie"))))
      {
        paramString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("guide_msg_cookie"));
        if (paramString != null) {
          localObject6 = new babyq_cookie.BabyQCookie();
        }
      }
      for (;;)
      {
        try
        {
          ((babyq_cookie.BabyQCookie)localObject6).mergeFrom(paramString);
          if (((babyq_cookie.BabyQCookie)localObject6).uint32_type.get() == 206) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("babyq_game_tribe");
          }
          ((Intent)localObject4).putExtra("source_puin", localNumberFormatException.source_puin);
          if (localNumberFormatException.uinType == 0)
          {
            ((Intent)localObject4).putExtra("articalChannelId", 2);
            AIOOpenWebMonitor.a((Intent)localObject4, (QQAppInterface)localObject2, localNumberFormatException.message);
            if ((PublicAccountUtil.a((QQAppInterface)localObject2, localNumberFormatException.uin) != -1) || (((String)localObject5).startsWith("http://browserApp.p.qq.com/")))
            {
              ((Intent)localObject4).setClass((Context)localObject3, PublicAccountBrowser.class);
              paramString = new Bundle();
              paramString.putString("uin", localNumberFormatException.uin);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
              {
                paramString.putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                paramString.putString("uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              }
              paramString.putBoolean("switch_msg_btn", PublicAccountUtil.a());
              ((Intent)localObject4).putExtras(paramString);
            }
            if ((localNumberFormatException.mMsgServiceID == 83) || (localNumberFormatException.mMsgServiceID == 108) || (localNumberFormatException.mMsgServiceID == 114) || (localNumberFormatException.mMsgServiceID == 116))
            {
              paramString = "";
              localObject1 = Uri.parse((String)localObject1);
            }
          }
          try
          {
            localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
            paramString = (String)localObject1;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
            StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject2, "sha_click", 1, "", "", String.valueOf(localNumberFormatException.mSourceAppid));
          }
          if (TextUtils.isEmpty(localNumberFormatException.mMsgActionData)) {
            break label2372;
          }
          i = 1;
          PublicAccountReportUtils.a(null, "", "0X8007555", "0X8007555", 0, 0, paramString, "", "" + i, "");
          PublicAccountReportUtils.a("0X8007555", "", paramString, "", "" + i, "");
          if (localNumberFormatException.mSourceAppid == 1101244924L)
          {
            ((Intent)localObject4).putExtra("BUDNLE_KEY_IS_MY_PROFILE", ((String)localObject5).contains("gene/index.html?uin=" + localNumberFormatException.currentAccountUin));
            ((Intent)localObject4).setClass((Context)localObject3, MusicGeneQQBrowserActivity.class);
          }
          PublicAccountUtil.a(localNumberFormatException.message, (Intent)localObject4, (String)localObject5);
          WebAccelerator.a((Context)localObject3, (Intent)localObject4, (String)localObject5);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject5, "", "", "");
          ReportController.b(null, "CliOper", "", "", "0X80061B0", "0X80061B0", 0, 0, "", "", "", "");
          if (bool) {
            StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject2, str, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localNumberFormatException.mSourceAppid), null, null, null);
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
            ((Intent)localObject4).putExtra("articalChannelId", 3);
            continue;
          }
          if (localNumberFormatException.uinType == 3000)
          {
            ((Intent)localObject4).putExtra("articalChannelId", 4);
            continue;
          }
          if (localNumberFormatException.uinType != 1008) {
            continue;
          }
          ((Intent)localObject4).putExtra("articalChannelId", 1);
          ((Intent)localObject4).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
        if (52 != localNumberFormatException.mMsgServiceID) {
          break;
        }
        if (paramString.equals(str))
        {
          ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X80052BB", "0X80052BB", 0, 0, "", "", "", "");
          break;
        }
        ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X80052BC", "0X80052BC", 0, 0, "", "", "", "");
        break;
        label2372:
        i = 2;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler
 * JD-Core Version:    0.7.0.1
 */