package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.miniapp.util.MiniAppJumpUtil;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12.ViewHolder;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import java.net.URL;
import java.util.List;
import tencent.im.babyq.babyq_cookie.BabyQCookie;

public class StructMsgForGeneralShare$GeneralClickHandler
  extends StructMsgClickHandler
{
  StructMsgForGeneralShare a;
  ChatMessage d;
  SessionInfo e;
  private String f;
  private String g;
  private String h;
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    super(paramQQAppInterface, paramView);
    this.a = paramStructMsgForGeneralShare;
    paramQQAppInterface = paramView.getTag();
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
    {
      paramQQAppInterface = (StructingMsgItemBuilder.StructingMsgViewHolder)paramQQAppInterface;
      this.d = paramQQAppInterface.q;
      this.e = paramQQAppInterface.d;
      return;
    }
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof ChatHistoryStructAdapter.HistoryStructItemHolder)))
    {
      paramQQAppInterface = (ChatHistoryStructAdapter.HistoryStructItemHolder)paramQQAppInterface;
      this.d = ((ChatMessage)paramQQAppInterface.f);
      this.e = new SessionInfo();
      this.e.b = this.d.frienduin;
      this.e.a = this.d.istroop;
      this.e.e = paramQQAppInterface.g;
      return;
    }
    if ((paramQQAppInterface instanceof MessageForStructing))
    {
      this.d = ((MessageForStructing)paramQQAppInterface);
      this.e = new SessionInfo();
      this.e.b = this.d.frienduin;
      this.e.a = this.d.istroop;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.1(this, paramBundle), 5, null, false);
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str;
    if (QLog.isColorLevel())
    {
      str = StructMsgForGeneralShare.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the share url is");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramString.contains("ciphertext")) {
      return false;
    }
    this.f = null;
    this.g = null;
    if ((paramString.startsWith("http://mobile.qzone.qq.com")) || (paramString.startsWith("https://mobile.qzone.qq.com"))) {}
    try
    {
      paramString = Uri.parse(paramString);
      str = paramString.getQueryParameter("a");
      if ("311".equals(str)) {
        return true;
      }
      if ("2".equals(str)) {
        return true;
      }
      if ("4".equals(str))
      {
        this.f = paramString.getQueryParameter("albumid");
        this.g = paramString.getQueryParameter("res_uin");
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e(StructMsgForGeneralShare.access$000(), 1, "isNotPermissionUGC catch an exception", paramString);
    }
    return false;
  }
  
  private boolean d(String paramString)
  {
    this.h = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("is_famous_space=1")) && (paramString.contains("qzone"))) {
      try
      {
        this.h = Uri.parse(paramString).getQueryParameter("hostuin");
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e(StructMsgForGeneralShare.access$000(), 1, "isForwardToNativeUserHome catch an exception", paramString);
      }
    }
    return false;
  }
  
  public boolean a(View paramView, String paramString)
  {
    if (this.a != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramView = paramView.findViewById(2131439157);
      int i = 1;
      Object localObject;
      if (paramView == null)
      {
        if (this.a.mStructMsgItemLists.size() <= 0) {
          i = 0;
        }
        if (QLog.isColorLevel())
        {
          paramString = StructMsgForGeneralShare.access$000();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("clickViewFlower error item:");
          if (i != 0) {
            paramView = ((AbsStructMsgElement)this.a.mStructMsgItemLists.get(0)).j;
          } else {
            paramView = "";
          }
          ((StringBuilder)localObject).append(paramView);
          QLog.i(paramString, 2, ((StringBuilder)localObject).toString());
        }
        return false;
      }
      paramView = (StructMsgItemLayout12.ViewHolder)paramView.getTag();
      if (paramView == null) {
        return false;
      }
      paramView = paramView.b;
      if ((paramView != null) && (paramView.size() > 0))
      {
        localObject = paramView.getString("groupCode");
        boolean bool1 = paramView.getBoolean("isSend");
        boolean bool2 = paramView.getBoolean("isReceive");
        if ((!bool1) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramString)) && (!bool2))
        {
          paramView = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
          if (paramView != null) {
            paramView = paramView.c(paramString);
          } else {
            paramView = null;
          }
          if (paramView != null) {
            ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).startTroopMemberChooseForFlowerActivity(paramView, this.b, (Activity)this.c, 1);
          }
          return true;
        }
        if (bool1)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            NearbyFlowerManager.a(this.b, "0X8006390");
            return true;
          }
          NearbyFlowerManager.a(this.b, "0X80060B3");
          return true;
        }
        if (bool2)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            NearbyFlowerManager.a(this.b, "0X8006391");
            return true;
          }
          NearbyFlowerManager.a(this.b, "0X80060B4");
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    Object localObject1 = paramString;
    Object localObject3 = "";
    if (QLog.isColorLevel())
    {
      str1 = StructMsgForGeneralShare.access$000();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("GeneralClickHandler clickWebMsg url = ");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.d(str1, 2, ((StringBuilder)localObject4).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    QQAppInterface localQQAppInterface = this.b;
    Context localContext = this.c;
    StructMsgForGeneralShare localStructMsgForGeneralShare = this.a;
    int i;
    Object localObject5;
    label151:
    Object localObject6;
    try
    {
      str1 = localStructMsgForGeneralShare.uin;
      if (localStructMsgForGeneralShare.uinType != 1) {
        break label3219;
      }
      i = 2;
      localObject4 = Long.toString(localStructMsgForGeneralShare.mSourceAppid);
      localObject5 = Integer.toString(localStructMsgForGeneralShare.mMsgServiceID);
      if ((localObject1 == null) || (paramString.length() <= 150)) {
        break label3224;
      }
      paramString = ((String)localObject1).substring(0, 150);
      localObject6 = new URL((String)localObject1).getHost();
      ReportController.b(null, "CliOper", "", str1, "0X80061B0", "0X80061B0", i, 0, (String)localObject4, (String)localObject5, paramString, (String)localObject6);
      if (QLog.isDebugVersion()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 4, String.format("the report params:%s,%s,%s,%s", new Object[] { localObject4, localObject5, paramString, localObject6 }));
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    paramString = (String)localObject1;
    if (this.a.mMsgServiceID == 107)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("&msgSeq=");
      paramString.append(this.a.uniseq);
      paramString.append("&resId=");
      paramString.append(this.a.mResid);
      paramString.append("&uin=");
      paramString.append(this.a.uin);
      paramString.append("&sessionType=");
      paramString.append(this.a.uinType);
      paramString = paramString.toString();
      if (StructMsgForGeneralShare.receiptServer == null)
      {
        StructMsgForGeneralShare.receiptServer = new StructMsgForGeneralShare.GeneralClickHandler.2(this, "receipt_msg");
        QIPCServerHelper.getInstance().register(StructMsgForGeneralShare.receiptServer);
      }
    }
    Object localObject4 = paramString.trim();
    boolean bool2 = ((String)localObject4).startsWith("https://gamecenter.qq.com");
    long l = AppShareIDUtil.c(localStructMsgForGeneralShare.mSourceAppid);
    String str1 = localQQAppInterface.getCurrentAccountUin();
    boolean bool1 = localContext instanceof BaseActivity;
    if (bool1)
    {
      localObject1 = ((BaseActivity)localContext).getChatFragment();
      if (localObject1 != null)
      {
        localObject1 = ((ChatFragment)localObject1).k();
        if ((localObject1 instanceof PublicAccountChatPie))
        {
          localObject1 = (PublicAccountChatPie)localObject1;
          ((PublicAccountChatPie)localObject1).cc += 1;
          ((PublicAccountChatPie)localObject1).ca += 1;
        }
      }
    }
    if (c((String)localObject4))
    {
      paramString = QZoneHelper.UserInfo.getInstance();
      paramString.qzone_uin = str1;
      paramString.nickname = localQQAppInterface.getCurrentNickname();
      if (TextUtils.isEmpty(this.f))
      {
        QZoneHelper.forwardToSharedFeedDetail((Activity)localContext, paramString, (String)localObject4, "mqqChat", -1);
        break label731;
      }
      localObject1 = new BaseBusinessAlbumInfo();
      ((BaseBusinessAlbumInfo)localObject1).mAlbumId = this.f;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(this.g)) {
          break label3230;
        }
        l = Long.parseLong(this.g);
        ((BaseBusinessAlbumInfo)localObject1).mUin = l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = StructMsgForGeneralShare.access$000();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("Parsing the albumOwnUin catch a NumberFormatException : ");
          ((StringBuilder)localObject5).append(localNumberFormatException.getMessage());
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject5).toString());
        }
      }
      ((BaseBusinessAlbumInfo)localObject1).mAlbumType = 0;
      ((BaseBusinessAlbumInfo)localObject1).isIndividualityAlbum = true;
      QZoneHelper.forwardToPersonalAlbumPhotoListV2((Activity)localContext, paramString, (BaseBusinessAlbumInfo)localObject1, -1, (String)localObject4);
      if ((d((String)localObject4)) && (!TextUtils.isEmpty(this.h)))
      {
        paramString = QZoneHelper.UserInfo.getInstance();
        paramString.qzone_uin = localNumberFormatException;
        paramString.nickname = localQQAppInterface.getCurrentNickname();
        QZoneHelper.forwardToUserHome((Activity)localContext, paramString, this.h, 0, 0, 0);
      }
      else
      {
        label731:
        if (QZoneHelper.forwardToQzoneDetailFromAIO((Activity)localContext, paramString, "biz_src_jc_aio")) {
          return true;
        }
        if (MiniAppLauncher.isMiniAppScheme((String)localObject4))
        {
          MiniAppLauncher.launchMiniAppByScheme(localContext, (String)localObject4, 1210);
          return true;
        }
        if ((((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl((String)localObject4)) || (localStructMsgForGeneralShare.mSourceAppid == 101458937L)) {
          break label3175;
        }
        if ((bool1) && (MiniAppJumpUtil.a((BaseActivity)localContext, paramString, localStructMsgForGeneralShare.message))) {
          return true;
        }
        if (StructMsgForGeneralShare.HandleMiniAppJump(localContext, paramString)) {
          return true;
        }
        if (((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(paramString)) {
          return true;
        }
        localObject6 = new Intent(localContext, QQBrowserDelegationActivity.class);
        ((Intent)localObject6).putExtra("param_force_internal_browser", true);
        localObject1 = localObject4;
        if (bool2) {
          localObject1 = HtmlOffline.a((String)localObject4, "platformId=qq_m");
        }
        String str2 = ((String)localObject1).trim();
        ((Intent)localObject6).putExtra("injectrecommend", false);
        ((Intent)localObject6).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject6).putExtra("url", str2);
        ((Intent)localObject6).putExtra("friendUin", localStructMsgForGeneralShare.uin);
        ((Intent)localObject6).putExtra("isAppShare", true);
        ((Intent)localObject6).putExtra("appShareID", l);
        ((Intent)localObject6).putExtra("uin_type", localStructMsgForGeneralShare.uinType);
        ((Intent)localObject6).putExtra("msg_id", Long.toString(localStructMsgForGeneralShare.msgId));
        ((Intent)localObject6).putExtra("puin", localStructMsgForGeneralShare.uin);
        ((Intent)localObject6).putExtra("self_uin", localNumberFormatException);
        if (localStructMsgForGeneralShare.message != null) {
          ((Intent)localObject6).putExtra("friend_uin", localStructMsgForGeneralShare.message.frienduin);
        }
        ((Intent)localObject6).putExtra("fromOneCLickCLose", true);
        if ((localStructMsgForGeneralShare.message == null) || (localStructMsgForGeneralShare.message.istroop != 1008)) {
          ((Intent)localObject6).putExtra("big_brother_source_key", "biz_src_jc_aio");
        }
        localObject5 = paramString;
        localObject1 = localObject3;
        localObject4 = localNumberFormatException;
        if (!TextUtils.isEmpty(str2))
        {
          localObject5 = paramString;
          localObject1 = localObject3;
          localObject4 = localNumberFormatException;
          if (Utils.c(localStructMsgForGeneralShare.uin))
          {
            String[] arrayOfString = str2.split("&");
            localObject5 = paramString;
            localObject1 = localObject3;
            localObject4 = localNumberFormatException;
            if (arrayOfString != null)
            {
              i = 0;
              for (;;)
              {
                localObject5 = paramString;
                localObject1 = localObject3;
                localObject4 = localNumberFormatException;
                if (i >= arrayOfString.length) {
                  break;
                }
                if (arrayOfString[i].contains("from_type"))
                {
                  localObject1 = arrayOfString[i].split("=");
                  if (localObject1 != null) {
                    if (localObject1.length == 2)
                    {
                      localObject1 = localObject1[1];
                      localObject4 = localStructMsgForGeneralShare.mMsg_I_ActionData.split(":");
                      if (localObject4 != null)
                      {
                        if (localObject4.length != 2) {
                          break label1450;
                        }
                        localObject4 = localObject4[1];
                        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
                          break label1450;
                        }
                        paramString = new Bundle();
                        paramString.putString("src_type", "internal");
                        paramString.putString("version", "1");
                        paramString.putString("callback_type", "scheme");
                        paramString.putString("callback_name", "open_card");
                        paramString.putString("uin", (String)localObject4);
                        paramString.putString("card_type", "group");
                        paramString.putString("authKey", null);
                        paramString.putString("from", "qrcode");
                        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                          paramString.putString("from_type", (String)localObject1);
                        }
                        paramString.putString("jump_from", "QRJumpActivity");
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append("mqqapi://card/show_pslcard?");
                        ((StringBuilder)localObject1).append(HttpUtil.encodeUrl(paramString));
                        paramString = JumpParser.a(localQQAppInterface, localContext, Uri.parse(((StringBuilder)localObject1).toString()).toString());
                        if (paramString != null) {
                          paramString.a();
                        }
                        return true;
                      }
                    }
                  }
                }
                label1450:
                i += 1;
              }
            }
          }
        }
        if (Aladdin.getConfig(261).getIntegerFromString("enable_floating_layer_style", 0) == 1)
        {
          QLog.d(StructMsgForGeneralShare.access$000(), 1, "enable_floating_layer_style = 1");
          if (((IReadInJoyFloatingWindowHelper)QRoute.api(IReadInJoyFloatingWindowHelper.class)).openFloatLayer(this.c, str2)) {
            return true;
          }
        }
        if ((!TextUtils.isEmpty(str2)) && ((((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianUrl(str2)) || (((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).isKanDianWebHost(str2))) && (((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).isViolaUrlFromWeb(str2)))
        {
          ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(localContext, null, ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).getviolaurlfromweb(str2), null);
          return true;
        }
        paramString = this.d;
        Object localObject2;
        if ((paramString != null) && (!paramString.isSend()) && (this.d.istroop == 0) && (Utils.c(this.d.frienduin)) && (!TextUtils.isEmpty(this.d.getExtInfoFromExtStr("guide_msg_cookie"))))
        {
          paramString = Utils.h(this.d.getExtInfoFromExtStr("guide_msg_cookie"));
          if (paramString != null)
          {
            localObject2 = new babyq_cookie.BabyQCookie();
            try
            {
              ((babyq_cookie.BabyQCookie)localObject2).mergeFrom(paramString);
              if (((babyq_cookie.BabyQCookie)localObject2).uint32_type.get() == 206) {
                this.b.getMessageFacade().d("babyq_game_tribe");
              }
            }
            catch (InvalidProtocolBufferMicroException paramString)
            {
              if (QLog.isColorLevel())
              {
                localObject2 = StructMsgForGeneralShare.access$000();
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("babbyq -> sendSpecialMessage:");
                ((StringBuilder)localObject3).append(paramString.getStackTrace());
                QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
              }
            }
          }
        }
        ((Intent)localObject6).putExtra("source_puin", localStructMsgForGeneralShare.source_puin);
        if (localStructMsgForGeneralShare.uinType == 0) {
          ((Intent)localObject6).putExtra("articalChannelId", 2);
        }
        for (;;)
        {
          break;
          if (localStructMsgForGeneralShare.uinType == 1)
          {
            ((Intent)localObject6).putExtra("articalChannelId", 3);
          }
          else if (localStructMsgForGeneralShare.uinType == 3000)
          {
            ((Intent)localObject6).putExtra("articalChannelId", 4);
          }
          else if (localStructMsgForGeneralShare.uinType == 1008)
          {
            ((Intent)localObject6).putExtra("articalChannelId", 1);
            ((Intent)localObject6).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
            ((Intent)localObject6).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(localStructMsgForGeneralShare.source_puin));
          }
        }
        AIOOpenWebMonitor.a((Intent)localObject6, localQQAppInterface, localStructMsgForGeneralShare.message);
        if ((((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(localQQAppInterface, localStructMsgForGeneralShare.uin) != -1) || (str2.startsWith("http://browserApp.p.qq.com/")))
        {
          ((Intent)localObject6).putExtra("is_public_account", true);
          paramString = new Bundle();
          paramString.putString("uin", localStructMsgForGeneralShare.uin);
          localObject2 = this.e;
          if (localObject2 != null)
          {
            paramString.putInt("uin_type", ((SessionInfo)localObject2).a);
            paramString.putString("uin_name", this.e.e);
          }
          paramString.putBoolean("switch_msg_btn", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).shouldUseWebviewSwitchFunction());
          ((Intent)localObject6).putExtras(paramString);
        }
        if (localStructMsgForGeneralShare.mMsgServiceID == 123)
        {
          if (localStructMsgForGeneralShare.uinType == 1)
          {
            bool2 = TroopConfessUtil.a(localQQAppInterface, localStructMsgForGeneralShare.uin, false);
            paramString = ((Intent)localObject6).getStringExtra("url");
            if ((bool2) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.uin)))
            {
              paramString = "https://ti.qq.com/honest-say/group.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&gc=$GCODE$&src_type=share&from=appstore_aio&adtag=qq_to_qq".replace("$GCODE$", NearbyURLSafeUtil.b(localStructMsgForGeneralShare.uin));
              ((Intent)localObject6).removeExtra("url");
              ((Intent)localObject6).putExtra("url", paramString);
              if (QLog.isColorLevel())
              {
                localObject1 = StructMsgForGeneralShare.access$000();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("GeneralClickHandler clickWebMsg confess groupUin:");
                ((StringBuilder)localObject2).append(localStructMsgForGeneralShare.uin);
                ((StringBuilder)localObject2).append(",paramUrl=");
                ((StringBuilder)localObject2).append(paramString);
                QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              }
              if (bool1)
              {
                localObject1 = ((BaseActivity)localContext).getChatFragment();
                if (localObject1 != null)
                {
                  localObject2 = ((ChatFragment)localObject1).getBaseActivity().getIntent();
                  ((Intent)localObject2).putExtra("url", paramString);
                  ((Intent)localObject2).putExtra("confess_half_screen_web", true);
                  paramString = ((ChatFragment)localObject1).k();
                  if ((paramString != null) && ((paramString instanceof TroopChatPie))) {
                    TroopConfessUtil.a((TroopChatPie)paramString);
                  }
                }
              }
            }
            if (!bool2)
            {
              QQToast.makeText(BaseApplicationImpl.getContext(), TroopConfessUtil.a, 0).show();
              return false;
            }
            ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.3(this, localQQAppInterface), 5, null, true);
            return true;
          }
          ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.4(this, localQQAppInterface), 5, null, true);
        }
        if (localStructMsgForGeneralShare.mMsgServiceID == 14)
        {
          paramString = this.e;
          if ((paramString != null) && (paramString.a == 1))
          {
            paramString = RobotUtils.a(localStructMsgForGeneralShare, this.e.b);
            if (!TextUtils.isEmpty(paramString))
            {
              ((Intent)localObject6).removeExtra("url");
              ((Intent)localObject6).putExtra("url", paramString);
              if (QLog.isColorLevel())
              {
                localObject2 = StructMsgForGeneralShare.access$000();
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("robot card, use new url:");
                ((StringBuilder)localObject3).append(localStructMsgForGeneralShare.uin);
                ((StringBuilder)localObject3).append(",paramUrl=");
                ((StringBuilder)localObject3).append(paramString);
                QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
              }
              ThreadManager.excute(new StructMsgForGeneralShare.GeneralClickHandler.5(this, paramString, localQQAppInterface), 16, null, true);
            }
            else if (QLog.isColorLevel())
            {
              paramString = StructMsgForGeneralShare.access$000();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("robot card, use old url:");
              ((StringBuilder)localObject2).append(localStructMsgForGeneralShare.uin);
              ((StringBuilder)localObject2).append(",paramUrl=");
              ((StringBuilder)localObject2).append(((Intent)localObject6).getStringExtra("url"));
              QLog.i(paramString, 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        i = 2;
        if ((localStructMsgForGeneralShare.mMsgServiceID == 83) || (localStructMsgForGeneralShare.mMsgServiceID == 108) || (localStructMsgForGeneralShare.mMsgServiceID == 114) || (localStructMsgForGeneralShare.mMsgServiceID == 116))
        {
          paramString = Uri.parse((String)localObject5);
          try
          {
            paramString = paramString.getQueryParameter("article_id");
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            paramString = (String)localObject1;
          }
          if (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgActionData)) {
            i = 1;
          }
          localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(i);
          ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, "", "0X8007555", "0X8007555", 0, 0, paramString, "", ((StringBuilder)localObject3).toString(), "");
          localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(i);
          ((IPublicAccountReportUtils)localObject2).reportPAinfoToLighthouse("0X8007555", "", paramString, "", ((StringBuilder)localObject3).toString(), "");
        }
        if (localStructMsgForGeneralShare.mSourceAppid == 1101244924L)
        {
          paramString = new StringBuilder();
          paramString.append("gene/index.html?uin=");
          paramString.append(localStructMsgForGeneralShare.currentAccountUin);
          ((Intent)localObject6).putExtra("BUDNLE_KEY_IS_MY_PROFILE", str2.contains(paramString.toString()));
          ((Intent)localObject6).setClass(localContext, MusicGeneQQBrowserActivity.class);
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localStructMsgForGeneralShare.message, (Intent)localObject6, str2);
        if ((!TextUtils.isEmpty(localStructMsgForGeneralShare.mContentTitle)) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!((String)localObject5).startsWith("https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128"))) {
          ((Intent)localObject6).putExtra("title", localStructMsgForGeneralShare.mContentTitle);
        }
        WebAccelerator.a(localContext, (Intent)localObject6, str2);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str2, "", "", "");
        if (bool2)
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(localQQAppInterface, (String)localObject4, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localStructMsgForGeneralShare.mSourceAppid), null, null, null);
        }
        else
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(localQQAppInterface, "sha_click", 1, "", "", String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
          paramString = this.d;
          if (paramString != null)
          {
            paramString = paramString.senderuin;
            if (52 == localStructMsgForGeneralShare.mMsgServiceID) {
              if (paramString.equals(localObject4)) {
                ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80052BB", "0X80052BB", 0, 0, "", "", "", "");
              } else {
                ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80052BC", "0X80052BC", 0, 0, "", "", "", "");
              }
            }
          }
        }
      }
      if ((this.a.message != null) && (this.a.message.istroop == 1008)) {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).addPublicAccountToRu(this.b, this.a.uin);
      }
      return false;
      label3175:
      paramString = new Bundle();
      paramString.putString("url", (String)localObject4);
      paramString.putBoolean("doc_from_aio", true);
      paramString.putString("tdsourcetag", "s_qq_aiomsg");
      TeamWorkDocEditBrowserActivity.a(localContext, paramString, false);
      return true;
      label3219:
      i = 1;
      break;
      label3224:
      paramString = (String)localObject1;
      break label151;
      label3230:
      l = 0L;
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = StructMsgForGeneralShare.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GeneralClickHandler clickPluginMsg actionData = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", actionDataA = ");
      localStringBuilder.append(paramString2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.b;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    paramString1 = JumpParser.a((BaseQQAppInterface)localObject, this.c, paramString1);
    if (paramString1 != null)
    {
      paramString2 = this.a;
      if ((paramString2 != null) && (paramString2.message != null) && (Utils.c(this.a.message.senderuin))) {
        paramString1.a("msg_uniseq", this.a.message.senderuin);
      }
      paramString1.a();
      paramString1 = this.a;
      if ((paramString1 != null) && (paramString1.message != null) && (this.a.message.istroop == 1008)) {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).addPublicAccountToRu(this.b, this.a.uin);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralShareMsg _ACTION_PLUGIN_ mContentOnClickListener: JumpAction is null.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler
 * JD-Core Version:    0.7.0.1
 */