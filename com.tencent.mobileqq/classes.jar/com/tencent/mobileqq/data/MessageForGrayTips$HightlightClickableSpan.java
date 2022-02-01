package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.doc.TencentDocGrayTipsUtils;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.miniapp.util.MiniAppJumpUtil;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class MessageForGrayTips$HightlightClickableSpan
  extends ClickableSpan
  implements MessageForGrayTips.HightlightClickInterface
{
  int color = -1;
  private Context context;
  String frienduin;
  private GrayTipsMessageConstants.HighlightItem item;
  private WeakReference<QQAppInterface> mApp;
  MessageRecord message;
  
  public MessageForGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, GrayTipsMessageConstants.HighlightItem paramHighlightItem, MessageRecord paramMessageRecord)
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
    if (paramQQAppInterface != null)
    {
      if (paramString == null) {
        return;
      }
      if (((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteFriend ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("MessageForGrayTips", 2, ((StringBuilder)localObject).toString());
        }
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(paramString, (byte)2);
        Object localObject = paramQQAppInterface.getHandler(ChatActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(16711681, paramString));
        }
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatSettingActivity.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(16711681, paramString));
        }
      }
    }
  }
  
  private void doAddFriendSafetyReport(QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.context;
    if ((localObject instanceof BaseActivity))
    {
      localObject = (BaseActivity)localObject;
      Bundle localBundle = NewReportPlugin.a(this.message.frienduin, 0);
      NewReportPlugin.a((QBaseActivity)localObject, this.message.frienduin, null, "1", null, this.message.selfuin, 25030, null, localBundle);
      localObject = this.message.getExtInfoFromExtStr("uint64_busi_type");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A561", "0X800A561", 1, 0, this.message.getExtInfoFromExtStr("uint64_busi_id"), (String)localObject, "web", "");
    }
  }
  
  private void onClickActionWeb(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = this.message;
    if ((localObject1 != null) && (((MessageRecord)localObject1).msgtype == -2049)) {
      ReportCenter.a().a(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "", "", "2000", "2012", "0", false);
    }
    localObject1 = this.message;
    UniteGrayTipParam localUniteGrayTipParam;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForUniteGrayTip)))
    {
      localUniteGrayTipParam = ((MessageForUniteGrayTip)localObject1).tipParam;
      if (localUniteGrayTipParam != null) {
        if (localUniteGrayTipParam.i == 2359298)
        {
          ReportController.b(null, "P_CliOper", "cmshow", "", "Apollo", "clk_intro", 0, 0, "", "", "", "");
        }
        else if (localUniteGrayTipParam.i == 2490369)
        {
          ReportController.b(null, "dc00898", "", "", "0X8007F12", "0X8007F12", 0, 0, "", "", "", "");
        }
        else if (localUniteGrayTipParam.i == 2621441)
        {
          localObject1 = ((MessageForUniteGrayTip)this.message).appGuideTipsOpKey;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
          }
        }
        else if (localUniteGrayTipParam.i == 3145729)
        {
          ReportController.b(null, "dc00898", "", "", "0X800812B", "0X800812B", 0, 0, "", "", "", "");
        }
        else if (localUniteGrayTipParam.i == 131078)
        {
          VasWebviewUtil.a(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "0");
        }
        else if (localUniteGrayTipParam.i == 2097154)
        {
          if (TextUtils.isEmpty(this.item.mMsgActionData)) {
            localObject1 = this.item.mMsgAActionData;
          } else {
            localObject1 = this.item.mMsgActionData;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1371;
          }
          localObject2 = HttpUtil.decodeURL((String)localObject1);
          if (!((Map)localObject2).containsKey("type")) {
            break label1371;
          }
          localObject2 = (String)((Map)localObject2).get("type");
        }
      }
    }
    try
    {
      i = Integer.parseInt((String)localObject2);
      ReportController.b((AppRuntime)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA6", i, 0, "", "", "", "");
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label414:
      String str;
      Object localObject3;
      StringBuilder localStringBuilder;
      label1371:
      break label414;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse url type error:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("reactive", 2, ((StringBuilder)localObject2).toString());
      break label1371;
      if (localUniteGrayTipParam.i == 655384)
      {
        localObject2 = this.message.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "1";
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", (String)localObject1, "", "2"));
      }
      else if (localUniteGrayTipParam.i == 2097153)
      {
        localObject1 = this.message.getExtInfoFromExtStr("friendIconType");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          VasWebviewUtil.a(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "aio_click", "", 0, 0, 0, "", (String)localObject1, "", "", "", "", "", 0, 0, 0, 0);
          if (((String)localObject1).equals("3")) {
            LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "2"));
          } else if (((String)localObject1).equals("6")) {
            LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "2"));
          }
        }
      }
      else if (localUniteGrayTipParam.i == 655397)
      {
        str = this.message.getExtInfoFromExtStr("uint64_busi_type");
        localObject1 = this.message.getExtInfoFromExtStr("uint64_busi_id");
        localObject2 = this.message.getExtInfoFromExtStr("uint64_templ_id");
        if (this.message.istroop == 0) {
          i = 1;
        } else if (this.message.istroop == 1) {
          i = 2;
        } else {
          i = 3;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(str);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, (String)localObject3, localStringBuilder.toString(), "web", "");
        if ("1008".equals(localObject1)) {
          ReportController.b(null, "dc00898", "", "", "0X800A639", "0X800A639", i - 1, 0, "", "", "", "");
        }
        if (("1062".equals(localObject1)) && ("12".equals(str)))
        {
          str = this.message.getExtInfoFromExtStr("bytes_content");
          if (!TextUtils.isEmpty(str)) {
            if (str.contains("动作")) {
              ReportController.b(null, "dc00898", "", "", "0X800B43E", "0X800B43E", i, 0, "", "", "", "");
            } else if (str.contains("效果")) {
              ReportController.b(null, "dc00898", "", "", "0X800B440", "0X800B440", i, 0, "", "", "", "");
            }
          }
        }
        if (PaiYiPaiMsgUtil.a(this.message))
        {
          if ((i != 1) && (i != 2)) {
            i = 10;
          }
          ReportController.b(null, "dc00898", "", "", "0X800B525", "0X800B525", i, 0, "", "", "", "");
        }
        if (Long.valueOf((String)localObject1).equals(Long.valueOf(1021L))) {
          ReportController.b(null, "dc00898", "", "", "0X800AD83", "0X800AD83", 0, 0, "", "", "", "");
        }
        TogetherUtils.a((String)localObject1, localUniteGrayTipParam.e);
        if ((Long.valueOf((String)localObject1).equals(Long.valueOf(1038L))) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          if (Long.valueOf((String)localObject2).equals(Long.valueOf(1111L))) {
            ReportController.b(null, "dc00898", "", "", "0X800B1A3", "0X800B1A3", 0, 0, "", "", "", "");
          } else if (Long.valueOf((String)localObject2).equals(Long.valueOf(1112L))) {
            ReportController.b(null, "dc00898", "", "", "0X800B1A5", "0X800B1A5", 0, 0, "", "", "", "");
          }
        }
        if (TroopLuckyCharacterConstant.a.contains(Long.valueOf((String)localObject1)))
        {
          i = (int)(Long.valueOf((String)localObject1).longValue() - 1069L);
          ReportController.b(paramQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_clk", 0, 0, "", "", "", "");
          ReportController.b(paramQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_clk", i + 1, 0, "", "", "", "");
        }
      }
      else if (localUniteGrayTipParam.i == 131090)
      {
        TroopEssenceUtil.b((QQAppInterface)this.mApp.get(), this.frienduin);
        TroopEssenceReportUtil.b((QQAppInterface)this.mApp.get(), this.frienduin);
      }
      else if (localUniteGrayTipParam.i == 656397)
      {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.bi, "1", "145", "920", "92005", "207654", localUniteGrayTipParam.g, "", "20", "");
      }
    }
    if (MutualMarkUtils.c(localUniteGrayTipParam.i))
    {
      if (TextUtils.isEmpty(this.item.mMsgActionData)) {
        localObject1 = this.item.mMsgAActionData;
      } else {
        localObject1 = this.item.mMsgActionData;
      }
      MutualMarkBusinessLogicHelper.a(paramQQAppInterface, (MessageForUniteGrayTip)this.message, localUniteGrayTipParam.i, (String)localObject1);
    }
    AioApolloHelper.a(paramQQAppInterface, localUniteGrayTipParam);
    if (TextUtils.isEmpty(this.item.mMsgActionData)) {
      paramQQAppInterface = this.item.mMsgAActionData;
    } else {
      paramQQAppInterface = this.item.mMsgActionData;
    }
    clickWebMsg(paramQQAppInterface);
  }
  
  private void showDeleteDialog(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = HardCodeUtil.a(2131904484);
    if (this.item.mMsgAActionData != null) {
      paramQQAppInterface = this.item.mMsgAActionData;
    }
    DialogUtil.a(this.context, null, paramQQAppInterface, null, 2131887648, 2131888729, new MessageForGrayTips.HightlightClickableSpan.4(this), new MessageForGrayTips.HightlightClickableSpan.5(this)).show();
  }
  
  public boolean clickAppMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" clickAppMsg actionData = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("actionDataA");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("HightlightClickableSpan", 2, ((StringBuilder)localObject).toString());
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
        if (localObject == null) {}
      }
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      int i;
      StartAppCheckHandler localStartAppCheckHandler;
      label288:
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, paramString2.getMessage());
      }
      return clickWebMsg(paramString1);
    }
    try
    {
      i = this.message.istroop;
      if (i != 1008) {
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_aio");
      } else {
        ((Intent)localObject).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.message.frienduin));
      }
      localStartAppCheckHandler = (StartAppCheckHandler)((QQAppInterface)this.mApp.get()).getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER);
      ((Intent)localObject).putExtra("report_open_type", "graytipsmsg");
      ((Intent)localObject).putExtra("report_url", "");
      ((Intent)localObject).putExtra("report_from", "1");
      ((Intent)localObject).putExtra("report_click_origin", "AIOTail");
      ((Intent)localObject).putExtra("report_class_name", this.context.getClass().getName());
      localStartAppCheckHandler.b(paramString2[0].trim(), this.context, (Intent)localObject);
      return true;
    }
    catch (Exception paramString2)
    {
      break label288;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
    }
    this.context.startActivity((Intent)localObject);
    return true;
    return false;
  }
  
  public boolean clickPluginMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HightlightClickableSpan clickPluginMsg  actionData = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", actionDataA = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("HightlightClickableSpan", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      if (TextUtils.equals("null", paramString2)) {
        localObject = paramString1;
      } else {
        localObject = paramString2;
      }
    }
    try
    {
      paramString1 = JumpParser.a((BaseQQAppInterface)this.mApp.get(), this.context, (String)localObject);
      if (paramString1 != null)
      {
        paramString1.g();
        paramString1.a();
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HightlightClickableSpan", 2, paramString1.getMessage(), paramString1);
      }
    }
    return true;
  }
  
  public boolean clickWebMsg(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      if (paramString.equals("http://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=")) {
        ReportController.b(null, "CliOper", "", "", "0X80070EB", "0X80070EB", 0, 0, "", "", "", "");
      }
      TencentDocGrayTipsUtils.a(paramString);
      Object localObject = this.message;
      if ((localObject != null) && ((localObject instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject).tipParam.i == 131078))
      {
        if (this.mApp.get() != null) {
          ((ITroopEnterEffectService)((QQAppInterface)this.mApp.get()).getRuntimeService(ITroopEnterEffectService.class, "all")).report("Grp_AIO", "grey_clk", new String[] { this.message.frienduin });
        }
        localObject = this.context;
        SharedPreUtils.t((Context)localObject, ((BaseActivity)localObject).app.getCurrentAccountUin(), this.message.frienduin);
      }
      localObject = this.message;
      if ((localObject != null) && (((MessageRecord)localObject).istroop == 1) && (MiniAppJumpUtil.a((BaseActivity)this.context, paramString, this.message)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "mini app jump handled");
        }
        return true;
      }
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("key_isReadModeEnabled", true);
      MessageRecord localMessageRecord = this.message;
      localObject = "biz_src_jc_aio";
      if ((localMessageRecord != null) && (localMessageRecord.istroop == 1008)) {
        localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.message.frienduin);
      }
      localIntent.putExtra("big_brother_source_key", (String)localObject);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.message, localIntent, paramString);
      this.context.startActivity(localIntent);
      paramString = (QQAppInterface)this.mApp.get();
      if ((paramString != null) && ((this.message instanceof MessageForGrayTips)) && (String.valueOf(11).equals(this.message.getExtInfoFromExtStr("gray_tips_serviceType")))) {
        ReportController.b(paramString, "dc00898", "", "", "0X8009328", "0X8009328", 0, 0, "", "", "", "");
      }
      return true;
    }
    if (paramString.equals("cmd://openGiftPanel"))
    {
      paramString = this.context;
      if ((paramString instanceof BaseActivity))
      {
        paramString = ((BaseActivity)paramString).getChatFragment();
        if ((paramString != null) && (paramString.k() != null))
        {
          ((GiftPanelHelper)paramString.k().q(136)).b(true);
          return true;
        }
      }
    }
    else if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("mqzone://arouse/lovermainpage")))
    {
      paramString = this.mApp;
      if (paramString != null) {
        LoverZoneUtils.a((QQAppInterface)paramString.get(), this.context, 2080, "");
      }
    }
    return false;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public MessageRecord getMessage()
  {
    return this.message;
  }
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4: ifnull +7877 -> 7881
    //   7: aload_0
    //   8: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +7868 -> 7881
    //   16: aload_1
    //   17: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   20: ifnonnull +4 -> 24
    //   23: return
    //   24: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: istore 8
    //   29: iconst_2
    //   30: istore_2
    //   31: iload 8
    //   33: ifeq +41 -> 74
    //   36: new 82	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   43: astore_1
    //   44: aload_1
    //   45: ldc_w 752
    //   48: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   57: getfield 755	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:actionType	I
    //   60: invokevirtual 758	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 91
    //   66: iconst_2
    //   67: aload_1
    //   68: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   78: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   81: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   84: astore 12
    //   86: aload 12
    //   88: ifnonnull +4 -> 92
    //   91: return
    //   92: aload_0
    //   93: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   96: getfield 755	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:actionType	I
    //   99: istore_3
    //   100: ldc 145
    //   102: astore_1
    //   103: iload_3
    //   104: tableswitch	default:+288 -> 392, 1:+7771->7875, 2:+7751->7855, 3:+7560->7664, 4:+7495->7599, 5:+7417->7521, 6:+7308->7412, 7:+7186->7290, 8:+288->392, 9:+288->392, 10:+7149->7253, 11:+6833->6937, 12:+6751->6855, 13:+6558->6662, 14:+6273->6377, 15:+6082->6186, 16:+5878->5982, 17:+5775->5879, 18:+5719->5823, 19:+5555->5659, 20:+5383->5487, 21:+5274->5378, 22:+288->392, 23:+288->392, 24:+5195->5299, 25:+5063->5167, 26:+5005->5109, 27:+4221->4325, 28:+4039->4143, 29:+3834->3938, 30:+3733->3837, 31:+3551->3655, 32:+3501->3605, 33:+3085->3189, 34:+2834->2938, 35:+288->392, 36:+2782->2886, 37:+288->392, 38:+2600->2704, 39:+2542->2646, 40:+2404->2508, 41:+2384->2488, 42:+2256->2360, 43:+2170->2274, 44:+2145->2249, 45:+2130->2234, 46:+2063->2167, 47:+1652->1756, 48:+1377->1481, 49:+288->392, 50:+1278->1382, 51:+1176->1280, 52:+1140->1244, 53:+1107->1211, 54:+1067->1171, 55:+1060->1164, 56:+1041->1145, 57:+1022->1126, 58:+993->1097, 59:+968->1072, 60:+925->1029, 61:+885->989, 62:+856->960, 63:+831->935, 64:+813->917, 65:+626->730, 66:+459->563, 67:+334->438, 68:+289->393
    //   393: aload_0
    //   394: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   397: astore_1
    //   398: aload_1
    //   399: instanceof 137
    //   402: ifeq +7479 -> 7881
    //   405: aload_1
    //   406: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   409: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   412: astore_1
    //   413: aload_1
    //   414: ifnull +7467 -> 7881
    //   417: aload_1
    //   418: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   421: instanceof 442
    //   424: ifeq +7457 -> 7881
    //   427: aload_1
    //   428: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   431: checkcast 442	com/tencent/mobileqq/activity/aio/rebuild/GameMsgChatPie
    //   434: invokevirtual 761	com/tencent/mobileqq/activity/aio/rebuild/GameMsgChatPie:bD	()V
    //   437: return
    //   438: getstatic 767	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:ad	Z
    //   441: ifeq +4 -> 445
    //   444: return
    //   445: aload_0
    //   446: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   449: astore_1
    //   450: aload_1
    //   451: instanceof 137
    //   454: ifeq +7427 -> 7881
    //   457: aload_1
    //   458: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   461: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   464: astore_1
    //   465: aload_1
    //   466: ifnull +7415 -> 7881
    //   469: aload_1
    //   470: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   473: ifnull +7408 -> 7881
    //   476: aload_1
    //   477: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   480: astore_1
    //   481: aload_1
    //   482: instanceof 769
    //   485: ifeq +35 -> 520
    //   488: aload_1
    //   489: invokevirtual 773	com/tencent/mobileqq/activity/aio/core/BaseChatPie:bv	()Lcom/tencent/mobileqq/activity/aio/core/AIOContext;
    //   492: invokevirtual 778	com/tencent/mobileqq/activity/aio/core/AIOContext:e	()Lcom/tencent/mobileqq/activity/aio/core/msglist/MsgList;
    //   495: invokevirtual 783	com/tencent/mobileqq/activity/aio/core/msglist/MsgList:b	()Lcom/tencent/mobileqq/activity/aio/coreui/msglist/ListUI;
    //   498: checkcast 785	com/tencent/mobileqq/activity/aio/coreui/msglist/TroopListUI
    //   501: invokevirtual 789	com/tencent/mobileqq/activity/aio/coreui/msglist/TroopListUI:y	()Lcom/tencent/mobileqq/activity/aio/oneclickjump/JumpStateMachineController;
    //   504: getstatic 795	com/tencent/mobileqq/activity/aio/oneclickjump/JumpState:GRAY_TIP_CLICK	Lcom/tencent/mobileqq/activity/aio/oneclickjump/JumpState;
    //   507: invokevirtual 800	com/tencent/mobileqq/activity/aio/oneclickjump/JumpStateMachineController:a	(Lcom/tencent/mobileqq/activity/aio/oneclickjump/JumpState;)V
    //   510: ldc 91
    //   512: iconst_1
    //   513: ldc_w 802
    //   516: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: return
    //   520: ldc_w 804
    //   523: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   526: checkcast 804	com/tencent/mobileqq/guild/temp/api/IGuildFeatureAdapterApi
    //   529: aload_1
    //   530: invokeinterface 807 2 0
    //   535: ifeq +7346 -> 7881
    //   538: ldc_w 804
    //   541: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   544: checkcast 804	com/tencent/mobileqq/guild/temp/api/IGuildFeatureAdapterApi
    //   547: aload_1
    //   548: invokeinterface 810 2 0
    //   553: ldc 91
    //   555: iconst_1
    //   556: ldc_w 812
    //   559: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: return
    //   563: aload_0
    //   564: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   567: astore_1
    //   568: aload_1
    //   569: ifnull +7312 -> 7881
    //   572: new 548	android/content/Intent
    //   575: dup
    //   576: aload_1
    //   577: ldc_w 687
    //   580: invokespecial 690	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   583: astore_1
    //   584: aload_1
    //   585: ldc_w 692
    //   588: ldc_w 814
    //   591: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   594: pop
    //   595: aload_0
    //   596: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   599: aload_1
    //   600: invokevirtual 609	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   603: new 816	org/json/JSONObject
    //   606: dup
    //   607: invokespecial 817	org/json/JSONObject:<init>	()V
    //   610: astore_1
    //   611: aload_1
    //   612: ldc_w 819
    //   615: ldc_w 821
    //   618: invokevirtual 825	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   621: pop
    //   622: aload_1
    //   623: ldc_w 827
    //   626: ldc_w 829
    //   629: invokevirtual 825	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   632: pop
    //   633: aload_1
    //   634: ldc_w 831
    //   637: ldc_w 833
    //   640: invokevirtual 825	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   643: pop
    //   644: aload_1
    //   645: ldc_w 835
    //   648: aload 12
    //   650: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   653: invokevirtual 825	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   656: pop
    //   657: aload_1
    //   658: ldc_w 837
    //   661: aload 12
    //   663: invokevirtual 841	com/tencent/mobileqq/app/QQAppInterface:getAppid	()I
    //   666: invokestatic 705	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   669: invokevirtual 825	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: ldc_w 843
    //   676: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   679: checkcast 843	com/tencent/mobileqq/newnearby/INearbyCGIReporter
    //   682: aload_1
    //   683: invokeinterface 847 2 0
    //   688: return
    //   689: astore_1
    //   690: new 82	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   697: astore 12
    //   699: aload 12
    //   701: ldc_w 849
    //   704: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 12
    //   710: aload_1
    //   711: invokevirtual 850	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   714: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: ldc 91
    //   720: iconst_1
    //   721: aload 12
    //   723: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: return
    //   730: aload 12
    //   732: ldc 116
    //   734: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   737: astore_1
    //   738: aload_1
    //   739: ifnull +7142 -> 7881
    //   742: aload 12
    //   744: ldc_w 852
    //   747: ldc_w 659
    //   750: invokevirtual 663	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   753: checkcast 852	com/tencent/mobileqq/apollo/api/IApolloManagerService
    //   756: astore 13
    //   758: aload 13
    //   760: iconst_1
    //   761: invokeinterface 856 2 0
    //   766: aload 13
    //   768: aload_0
    //   769: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   772: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   775: invokestatic 285	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   778: invokeinterface 856 2 0
    //   783: aload_1
    //   784: bipush 49
    //   786: invokevirtual 859	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   789: invokevirtual 864	android/os/Message:sendToTarget	()V
    //   792: aload_0
    //   793: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   796: ifnull +7085 -> 7881
    //   799: aload 12
    //   801: ldc 216
    //   803: ldc 218
    //   805: ldc_w 866
    //   808: ldc_w 868
    //   811: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   814: checkcast 868	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   817: aload_0
    //   818: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   821: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   824: invokeinterface 872 2 0
    //   829: iconst_0
    //   830: iconst_0
    //   831: anewarray 279	java/lang/String
    //   834: invokestatic 877	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   837: ldc_w 879
    //   840: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   843: checkcast 879	com/tencent/mobileqq/apollo/statistics/product/api/IApolloDtReportHelper
    //   846: astore_1
    //   847: aload_1
    //   848: ldc_w 881
    //   851: ldc_w 883
    //   854: ldc_w 833
    //   857: new 885	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder
    //   860: dup
    //   861: invokespecial 886	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:<init>	()V
    //   864: aload_1
    //   865: aload 12
    //   867: invokeinterface 890 2 0
    //   872: invokevirtual 893	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:a	(I)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   875: aload_1
    //   876: aload_0
    //   877: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   880: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   883: invokeinterface 894 2 0
    //   888: invokevirtual 896	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:b	(I)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   891: aload_0
    //   892: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   895: getfield 899	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   898: invokevirtual 902	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   901: aload_0
    //   902: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   905: invokevirtual 904	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   908: invokevirtual 907	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:a	()Ljava/util/HashMap;
    //   911: invokeinterface 910 5 0
    //   916: return
    //   917: aload 12
    //   919: getstatic 913	com/tencent/mobileqq/app/QQManagerFactory:PAI_YI_PAI_MANAGER	I
    //   922: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   925: checkcast 915	com/tencent/mobileqq/activity/aio/avatardoubletap/PaiYiPaiManager
    //   928: aload_0
    //   929: invokevirtual 917	com/tencent/mobileqq/activity/aio/avatardoubletap/PaiYiPaiManager:a	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;)V
    //   932: goto +57 -> 989
    //   935: aload_0
    //   936: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   939: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   942: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   945: aload_0
    //   946: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   949: aload_0
    //   950: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   953: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   956: invokestatic 922	com/tencent/mobileqq/troop/shortcutbar/TroopShortcutBarUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   959: return
    //   960: aload_0
    //   961: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   964: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   967: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   970: aload_0
    //   971: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   974: aload_0
    //   975: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   978: aload_0
    //   979: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   982: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   985: invokestatic 925	com/tencent/mobileqq/troop/shortcutbar/TroopShortcutBarUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   988: return
    //   989: aload_0
    //   990: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   993: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   996: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   999: aload_0
    //   1000: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1003: aload_0
    //   1004: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1007: aload_0
    //   1008: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1011: aload_0
    //   1012: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1015: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1018: aload_0
    //   1019: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1022: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   1025: invokestatic 930	com/tencent/mobileqq/troop/utils/TroopUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1028: return
    //   1029: aload_0
    //   1030: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1033: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1036: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1039: invokestatic 935	com/tencent/mobileqq/together/TogetherControlManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/together/TogetherControlManager;
    //   1042: aload_0
    //   1043: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1046: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   1049: iconst_2
    //   1050: iconst_1
    //   1051: aload_0
    //   1052: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1055: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1058: lconst_0
    //   1059: bipush 10
    //   1061: new 937	android/os/Bundle
    //   1064: dup
    //   1065: invokespecial 938	android/os/Bundle:<init>	()V
    //   1068: invokevirtual 941	com/tencent/mobileqq/together/TogetherControlManager:a	(Lcom/tencent/mobileqq/app/BaseActivity;IILjava/lang/String;JILandroid/os/Bundle;)V
    //   1071: return
    //   1072: aload_0
    //   1073: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1076: astore_1
    //   1077: aload_1
    //   1078: ifnull +6803 -> 7881
    //   1081: aload_0
    //   1082: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1085: aload_1
    //   1086: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1089: aload_0
    //   1090: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1093: invokestatic 946	com/tencent/mobileqq/listentogether/ListenTogetherUtils:a	(Landroid/content/Context;ILjava/lang/String;)V
    //   1096: return
    //   1097: aload_0
    //   1098: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1101: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1104: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1107: aload_0
    //   1108: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1111: aload_0
    //   1112: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1115: aload_0
    //   1116: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1119: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1122: invokestatic 947	com/tencent/mobileqq/troop/essencemsg/TroopEssenceUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1125: return
    //   1126: ldc_w 949
    //   1129: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1132: checkcast 949	com/tencent/mobileqq/qqexpand/chat/IAioColdPalaceHelper
    //   1135: aload_0
    //   1136: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1139: invokeinterface 953 2 0
    //   1144: return
    //   1145: aload 12
    //   1147: aload_0
    //   1148: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1151: ldc 145
    //   1153: aload_0
    //   1154: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1157: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1160: invokestatic 958	com/tencent/mobileqq/graytip/CustomizeGrayTipsManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   1163: return
    //   1164: aload_0
    //   1165: aload 12
    //   1167: invokespecial 960	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:doAddFriendSafetyReport	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   1170: return
    //   1171: aload_0
    //   1172: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1175: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1178: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1181: aload_0
    //   1182: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1185: aload_0
    //   1186: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1189: aload_0
    //   1190: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1193: aload_0
    //   1194: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1197: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1200: aload_0
    //   1201: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1204: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   1207: invokestatic 962	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1210: return
    //   1211: aload_0
    //   1212: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1215: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1218: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1221: aload_0
    //   1222: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1225: aload_0
    //   1226: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1229: aload_0
    //   1230: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1233: aload_0
    //   1234: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1237: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1240: invokestatic 965	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;)V
    //   1243: return
    //   1244: aload_0
    //   1245: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1248: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1251: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1254: aload_0
    //   1255: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1258: aload_0
    //   1259: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1262: aload_0
    //   1263: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1266: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   1269: aload_0
    //   1270: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1273: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1276: invokestatic 968	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1279: return
    //   1280: invokestatic 974	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1283: ldc_w 976
    //   1286: ldc_w 978
    //   1289: bipush 24
    //   1291: invokevirtual 982	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   1294: istore_2
    //   1295: ldc_w 983
    //   1298: invokestatic 488	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1301: iconst_1
    //   1302: anewarray 586	java/lang/Object
    //   1305: dup
    //   1306: iconst_0
    //   1307: iload_2
    //   1308: invokestatic 986	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1311: aastore
    //   1312: invokestatic 990	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1315: astore_1
    //   1316: invokestatic 995	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1319: iconst_0
    //   1320: aload_1
    //   1321: iconst_0
    //   1322: invokestatic 1001	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1325: invokevirtual 1004	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   1328: pop
    //   1329: ldc_w 976
    //   1332: invokestatic 1009	java/lang/System:currentTimeMillis	()J
    //   1335: ldc2_w 1010
    //   1338: ldiv
    //   1339: iload_2
    //   1340: bipush 60
    //   1342: imul
    //   1343: bipush 60
    //   1345: imul
    //   1346: i2l
    //   1347: ladd
    //   1348: aload_0
    //   1349: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1352: getfield 1015	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   1355: invokestatic 1021	cooperation/qzone/LocalMultiProcConfig:putLong4Uin	(Ljava/lang/String;JJ)V
    //   1358: aload_0
    //   1359: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1362: aload 12
    //   1364: aload_0
    //   1365: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1368: checkcast 1023	com/tencent/mobileqq/data/ChatMessage
    //   1371: invokestatic 1028	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1374: bipush 40
    //   1376: iconst_3
    //   1377: iconst_3
    //   1378: invokestatic 1034	cooperation/qzone/report/lp/LpReportInfo_pf00064:allReport	(III)V
    //   1381: return
    //   1382: aload_0
    //   1383: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1386: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1389: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1392: getstatic 1037	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1395: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1398: checkcast 1039	com/tencent/mobileqq/app/TroopManager
    //   1401: aload_0
    //   1402: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1405: invokevirtual 1042	com/tencent/mobileqq/app/TroopManager:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1408: astore_1
    //   1409: new 1044	java/util/ArrayList
    //   1412: dup
    //   1413: aload_0
    //   1414: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1417: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1420: ldc_w 1046
    //   1423: invokevirtual 1050	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1426: invokestatic 1056	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   1429: invokespecial 1059	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   1432: astore 13
    //   1434: bipush 40
    //   1436: iconst_3
    //   1437: iconst_2
    //   1438: invokestatic 1034	cooperation/qzone/report/lp/LpReportInfo_pf00064:allReport	(III)V
    //   1441: aload_0
    //   1442: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1445: checkcast 1061	android/app/Activity
    //   1448: aload 12
    //   1450: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1453: iconst_1
    //   1454: iconst_0
    //   1455: aload_0
    //   1456: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1459: invokestatic 1065	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1462: aload_1
    //   1463: getfield 1070	com/tencent/mobileqq/data/troop/TroopInfo:troopname	Ljava/lang/String;
    //   1466: ldc_w 1072
    //   1469: getstatic 1076	com/tencent/mobileqq/utils/AlbumConstants:d	Ljava/lang/String;
    //   1472: aload 13
    //   1474: iconst_m1
    //   1475: iconst_0
    //   1476: iconst_3
    //   1477: invokestatic 1082	cooperation/qzone/QZoneHelper:forwardToTroopUploadPhoto	(Landroid/app/Activity;Ljava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;III)V
    //   1480: return
    //   1481: aload_0
    //   1482: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1485: astore_1
    //   1486: aload_1
    //   1487: instanceof 137
    //   1490: ifeq +6391 -> 7881
    //   1493: aload_1
    //   1494: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   1497: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1500: astore_1
    //   1501: aload_1
    //   1502: ifnull +6379 -> 7881
    //   1505: aload_1
    //   1506: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1509: ifnull +6372 -> 7881
    //   1512: aload_1
    //   1513: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1516: instanceof 769
    //   1519: ifeq +6362 -> 7881
    //   1522: aload_1
    //   1523: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1526: checkcast 769	com/tencent/mobileqq/activity/aio/core/TroopChatPie
    //   1529: astore 13
    //   1531: aload 13
    //   1533: invokevirtual 1085	com/tencent/mobileqq/activity/aio/core/TroopChatPie:ae	()Ljava/lang/String;
    //   1536: astore_1
    //   1537: aload 12
    //   1539: getstatic 1088	com/tencent/mobileqq/app/QQManagerFactory:TROOP_GAG_MANAGER	I
    //   1542: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1545: checkcast 1090	com/tencent/mobileqq/troop/utils/TroopGagMgr
    //   1548: aload_1
    //   1549: iconst_1
    //   1550: invokevirtual 1093	com/tencent/mobileqq/troop/utils/TroopGagMgr:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/troopgag/data/SelfGagInfo;
    //   1553: astore 14
    //   1555: aload_0
    //   1556: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1559: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1562: ifne +6319 -> 7881
    //   1565: aload_0
    //   1566: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1569: aload_1
    //   1570: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1573: ifeq +6308 -> 7881
    //   1576: aload_0
    //   1577: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1580: instanceof 1023
    //   1583: ifeq +6298 -> 7881
    //   1586: aload 14
    //   1588: getfield 1097	com/tencent/mobileqq/troop/troopgag/data/SelfGagInfo:b	Z
    //   1591: ifne +6290 -> 7881
    //   1594: aload 13
    //   1596: bipush 41
    //   1598: invokevirtual 1098	com/tencent/mobileqq/activity/aio/core/TroopChatPie:q	(I)Lcom/tencent/mobileqq/activity/aio/helper/IHelper;
    //   1601: checkcast 1100	com/tencent/mobileqq/activity/aio/helper/SpecWordEmotionThinkHelper
    //   1604: iconst_1
    //   1605: invokevirtual 1102	com/tencent/mobileqq/activity/aio/helper/SpecWordEmotionThinkHelper:a	(I)V
    //   1608: aload 12
    //   1610: getstatic 1037	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1613: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1616: checkcast 1039	com/tencent/mobileqq/app/TroopManager
    //   1619: invokevirtual 1106	com/tencent/mobileqq/app/TroopManager:p	()Lcom/tencent/mobileqq/app/TroopManager$ConfigableWordingSetter;
    //   1622: aload 12
    //   1624: aload_0
    //   1625: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1628: aload 13
    //   1630: getfield 1110	com/tencent/mobileqq/activity/aio/core/TroopChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   1633: aload_0
    //   1634: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1637: iconst_0
    //   1638: aload_0
    //   1639: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1642: checkcast 1023	com/tencent/mobileqq/data/ChatMessage
    //   1645: invokevirtual 1115	com/tencent/mobileqq/app/TroopManager$ConfigableWordingSetter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/EditText;Ljava/lang/String;ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   1648: iconst_3
    //   1649: putstatic 1119	com/tencent/mobileqq/activity/aio/item/TroopPobingItemBuilder:a	I
    //   1652: aload_0
    //   1653: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1656: getfield 1122	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   1659: putstatic 1125	com/tencent/mobileqq/activity/aio/item/TroopPobingItemBuilder:w	Ljava/lang/String;
    //   1662: new 1127	com/tencent/mobileqq/statistics/ReportTask
    //   1665: dup
    //   1666: aload 12
    //   1668: invokespecial 1130	com/tencent/mobileqq/statistics/ReportTask:<init>	(Lmqq/app/AppRuntime;)V
    //   1671: ldc_w 417
    //   1674: invokevirtual 1133	com/tencent/mobileqq/statistics/ReportTask:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1677: ldc_w 419
    //   1680: invokevirtual 1135	com/tencent/mobileqq/statistics/ReportTask:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1683: ldc_w 1137
    //   1686: invokevirtual 1139	com/tencent/mobileqq/statistics/ReportTask:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1689: ldc_w 1141
    //   1692: invokevirtual 1143	com/tencent/mobileqq/statistics/ReportTask:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1695: astore 13
    //   1697: new 82	java/lang/StringBuilder
    //   1700: dup
    //   1701: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1704: astore 14
    //   1706: aload 14
    //   1708: ldc 161
    //   1710: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: aload 14
    //   1716: aload 12
    //   1718: aload_1
    //   1719: invokestatic 1146	com/tencent/mobileqq/troop/utils/TroopUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   1722: invokevirtual 758	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1725: pop
    //   1726: aload 13
    //   1728: iconst_3
    //   1729: anewarray 279	java/lang/String
    //   1732: dup
    //   1733: iconst_0
    //   1734: aload_1
    //   1735: aastore
    //   1736: dup
    //   1737: iconst_1
    //   1738: ldc 161
    //   1740: aastore
    //   1741: dup
    //   1742: iconst_2
    //   1743: aload 14
    //   1745: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1748: aastore
    //   1749: invokevirtual 1149	com/tencent/mobileqq/statistics/ReportTask:a	([Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1752: invokevirtual 1151	com/tencent/mobileqq/statistics/ReportTask:a	()V
    //   1755: return
    //   1756: aload_0
    //   1757: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1760: instanceof 202
    //   1763: ifeq +6154 -> 7917
    //   1766: aload_0
    //   1767: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1770: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   1773: astore_1
    //   1774: aload_1
    //   1775: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   1778: ifne +23 -> 1801
    //   1781: aload_1
    //   1782: getfield 1153	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1785: aload 12
    //   1787: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1790: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1793: ifeq +273 -> 2066
    //   1796: iconst_1
    //   1797: istore_2
    //   1798: goto +268 -> 2066
    //   1801: aload_1
    //   1802: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   1805: iconst_1
    //   1806: if_icmpne +208 -> 2014
    //   1809: aload 12
    //   1811: aload_0
    //   1812: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1815: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1818: aload 12
    //   1820: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1823: invokestatic 1156	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Z
    //   1826: istore 8
    //   1828: ldc_w 1158
    //   1831: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1834: checkcast 1158	com/tencent/mobileqq/troop/utils/api/ITroopUtilsApi
    //   1837: aload 12
    //   1839: aload_0
    //   1840: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1843: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1846: aload 12
    //   1848: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1851: invokeinterface 1162 4 0
    //   1856: istore 9
    //   1858: aload_1
    //   1859: getfield 206	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   1862: getfield 456	com/tencent/mobileqq/graytip/UniteGrayTipParam:g	Ljava/lang/String;
    //   1865: astore 13
    //   1867: new 82	java/lang/StringBuilder
    //   1870: dup
    //   1871: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1874: astore 14
    //   1876: aload 14
    //   1878: ldc_w 1163
    //   1881: invokestatic 488	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1884: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: pop
    //   1888: aload 14
    //   1890: aload 12
    //   1892: invokevirtual 1166	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1895: ldc_w 1167
    //   1898: invokevirtual 1170	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1901: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: pop
    //   1905: aload 14
    //   1907: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1910: astore 14
    //   1912: iload 8
    //   1914: ifeq +38 -> 1952
    //   1917: aload 13
    //   1919: aload 14
    //   1921: invokevirtual 644	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1924: ifeq +8 -> 1932
    //   1927: iconst_3
    //   1928: istore_2
    //   1929: goto +137 -> 2066
    //   1932: aload_1
    //   1933: getfield 1153	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1936: aload 12
    //   1938: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1941: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1944: ifeq +5955 -> 7899
    //   1947: iconst_4
    //   1948: istore_2
    //   1949: goto +117 -> 2066
    //   1952: iload 9
    //   1954: ifeq +39 -> 1993
    //   1957: aload 13
    //   1959: aload 14
    //   1961: invokevirtual 644	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1964: ifeq +8 -> 1972
    //   1967: iconst_5
    //   1968: istore_2
    //   1969: goto +97 -> 2066
    //   1972: aload_1
    //   1973: getfield 1153	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1976: aload 12
    //   1978: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1981: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1984: ifeq +5915 -> 7899
    //   1987: bipush 6
    //   1989: istore_2
    //   1990: goto +76 -> 2066
    //   1993: aload_1
    //   1994: getfield 1153	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1997: aload 12
    //   1999: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2002: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2005: ifeq +5894 -> 7899
    //   2008: bipush 7
    //   2010: istore_2
    //   2011: goto +55 -> 2066
    //   2014: aload_1
    //   2015: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   2018: sipush 3000
    //   2021: if_icmpne +24 -> 2045
    //   2024: aload_1
    //   2025: getfield 1153	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   2028: aload 12
    //   2030: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2033: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2036: ifeq +5869 -> 7905
    //   2039: bipush 9
    //   2041: istore_2
    //   2042: goto +24 -> 2066
    //   2045: aload_1
    //   2046: getfield 1153	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   2049: aload 12
    //   2051: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2054: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2057: ifeq +5854 -> 7911
    //   2060: bipush 11
    //   2062: istore_2
    //   2063: goto +3 -> 2066
    //   2066: aload_0
    //   2067: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2070: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2073: checkcast 287	mqq/app/AppRuntime
    //   2076: astore_1
    //   2077: new 82	java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   2084: astore 13
    //   2086: aload 13
    //   2088: iload_2
    //   2089: invokevirtual 758	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2092: pop
    //   2093: aload 13
    //   2095: ldc 161
    //   2097: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2100: pop
    //   2101: aload_1
    //   2102: ldc 223
    //   2104: ldc 161
    //   2106: ldc 161
    //   2108: ldc_w 1172
    //   2111: ldc_w 1172
    //   2114: iconst_0
    //   2115: iconst_0
    //   2116: aload 13
    //   2118: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2121: ldc 161
    //   2123: ldc 161
    //   2125: ldc 161
    //   2127: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2130: goto +20 -> 2150
    //   2133: astore_1
    //   2134: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2137: ifeq +13 -> 2150
    //   2140: ldc 91
    //   2142: iconst_1
    //   2143: ldc_w 1172
    //   2146: aload_1
    //   2147: invokestatic 1174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2150: aload_0
    //   2151: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2154: aload 12
    //   2156: aload_0
    //   2157: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2160: checkcast 1023	com/tencent/mobileqq/data/ChatMessage
    //   2163: invokestatic 1028	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   2166: return
    //   2167: aload_0
    //   2168: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2171: astore_1
    //   2172: aload_1
    //   2173: ifnull +5708 -> 7881
    //   2176: aload_1
    //   2177: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2180: iconst_1
    //   2181: if_icmpne +19 -> 2200
    //   2184: aload 12
    //   2186: aload_0
    //   2187: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2190: iconst_1
    //   2191: aload_0
    //   2192: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2195: iconst_0
    //   2196: invokestatic 1177	com/tencent/mobileqq/listentogether/ListenTogetherUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;ILjava/lang/String;I)V
    //   2199: return
    //   2200: aload_0
    //   2201: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2204: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2207: ifne +5674 -> 7881
    //   2210: aload_0
    //   2211: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2214: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2217: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   2220: aload_0
    //   2221: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2224: iconst_2
    //   2225: aload_0
    //   2226: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2229: iconst_0
    //   2230: invokestatic 1177	com/tencent/mobileqq/listentogether/ListenTogetherUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;ILjava/lang/String;I)V
    //   2233: return
    //   2234: aload_0
    //   2235: aload_0
    //   2236: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2239: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2242: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   2245: invokespecial 1179	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:showDeleteDialog	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   2248: return
    //   2249: new 1181	com/tencent/mobileqq/profilecard/data/AllInOne
    //   2252: dup
    //   2253: aload_0
    //   2254: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2257: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2260: iconst_1
    //   2261: invokespecial 1184	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   2264: astore_1
    //   2265: aload_0
    //   2266: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2269: aload_1
    //   2270: invokestatic 1190	com/tencent/mobileqq/profilecard/utils/ProfileUtils:openProfileCard	(Landroid/content/Context;Lcom/tencent/mobileqq/profilecard/data/AllInOne;)V
    //   2273: return
    //   2274: aload_0
    //   2275: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2278: astore_1
    //   2279: aload_1
    //   2280: instanceof 137
    //   2283: ifeq +41 -> 2324
    //   2286: aload_1
    //   2287: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   2290: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   2293: astore_1
    //   2294: aload_1
    //   2295: ifnull +29 -> 2324
    //   2298: aload_1
    //   2299: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   2302: ifnull +22 -> 2324
    //   2305: aload_1
    //   2306: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   2309: astore_1
    //   2310: aload_1
    //   2311: instanceof 1192
    //   2314: ifeq +10 -> 2324
    //   2317: aload_1
    //   2318: checkcast 1192	com/tencent/mobileqq/activity/aio/core/FriendChatPie
    //   2321: invokevirtual 1195	com/tencent/mobileqq/activity/aio/core/FriendChatPie:bA	()V
    //   2324: aload_0
    //   2325: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2328: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2331: checkcast 287	mqq/app/AppRuntime
    //   2334: ldc 223
    //   2336: ldc 161
    //   2338: ldc 161
    //   2340: ldc_w 1197
    //   2343: ldc_w 1197
    //   2346: iconst_0
    //   2347: iconst_0
    //   2348: ldc 161
    //   2350: ldc 161
    //   2352: ldc 161
    //   2354: ldc 161
    //   2356: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2359: return
    //   2360: aload_0
    //   2361: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2364: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   2367: astore_1
    //   2368: aload_0
    //   2369: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2372: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2375: astore 12
    //   2377: aload_1
    //   2378: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2381: ifne +38 -> 2419
    //   2384: aload_1
    //   2385: ldc_w 1199
    //   2388: invokevirtual 356	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2391: ifeq +28 -> 2419
    //   2394: ldc_w 1201
    //   2397: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2400: checkcast 1201	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   2403: aload_0
    //   2404: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2407: aload_1
    //   2408: aload 12
    //   2410: invokeinterface 1205 4 0
    //   2415: pop
    //   2416: goto +43 -> 2459
    //   2419: ldc_w 1201
    //   2422: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2425: checkcast 1201	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   2428: aload_1
    //   2429: invokeinterface 1208 2 0
    //   2434: ifeq +25 -> 2459
    //   2437: ldc_w 1210
    //   2440: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2443: checkcast 1210	com/tencent/mobileqq/mini/api/IMiniAppService
    //   2446: aload_0
    //   2447: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2450: aload_1
    //   2451: iconst_0
    //   2452: aconst_null
    //   2453: invokeinterface 1214 5 0
    //   2458: pop
    //   2459: aconst_null
    //   2460: ldc 223
    //   2462: ldc 161
    //   2464: aload_0
    //   2465: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2468: ldc_w 1216
    //   2471: ldc_w 1216
    //   2474: iconst_0
    //   2475: iconst_0
    //   2476: ldc 161
    //   2478: ldc 161
    //   2480: ldc 161
    //   2482: ldc 161
    //   2484: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2487: return
    //   2488: new 548	android/content/Intent
    //   2491: dup
    //   2492: invokespecial 1217	android/content/Intent:<init>	()V
    //   2495: astore_1
    //   2496: aload_0
    //   2497: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2500: aload_1
    //   2501: ldc_w 1219
    //   2504: invokestatic 1224	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   2507: return
    //   2508: getstatic 1228	com/tencent/mobileqq/app/msgnotify/MsgNotifyPushDialog:y	Z
    //   2511: ifeq +16 -> 2527
    //   2514: aload_0
    //   2515: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2518: getstatic 1231	com/tencent/mobileqq/app/msgnotify/MsgNotifyPushDialog:n	Landroid/content/Intent;
    //   2521: invokevirtual 609	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2524: goto +39 -> 2563
    //   2527: aload_0
    //   2528: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2531: ifnull +17 -> 2548
    //   2534: new 1233	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$3
    //   2537: dup
    //   2538: aload_0
    //   2539: invokespecial 1234	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$3:<init>	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;)V
    //   2542: invokestatic 1240	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   2545: goto +18 -> 2563
    //   2548: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2551: ifeq +12 -> 2563
    //   2554: ldc 91
    //   2556: iconst_2
    //   2557: ldc_w 1242
    //   2560: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2563: aload_0
    //   2564: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2567: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2570: invokestatic 285	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2573: istore_2
    //   2574: aconst_null
    //   2575: ldc 223
    //   2577: ldc 161
    //   2579: ldc 161
    //   2581: ldc_w 1244
    //   2584: ldc_w 1244
    //   2587: iload_2
    //   2588: iload_2
    //   2589: ldc 161
    //   2591: ldc 161
    //   2593: ldc 161
    //   2595: ldc 161
    //   2597: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2600: return
    //   2601: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2604: ifeq +5277 -> 7881
    //   2607: new 82	java/lang/StringBuilder
    //   2610: dup
    //   2611: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   2614: astore_1
    //   2615: aload_1
    //   2616: ldc_w 1246
    //   2619: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: pop
    //   2623: aload_1
    //   2624: aload_0
    //   2625: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2628: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2631: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2634: pop
    //   2635: ldc 91
    //   2637: iconst_2
    //   2638: aload_1
    //   2639: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2642: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2645: return
    //   2646: aload_0
    //   2647: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2650: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2653: iconst_2
    //   2654: invokestatic 1249	com/tencent/mobileqq/troop/utils/TroopInfoUIUtil:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   2657: astore_1
    //   2658: aload_1
    //   2659: ldc_w 1251
    //   2662: sipush 1000
    //   2665: invokevirtual 1254	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2668: aload_0
    //   2669: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2672: aload_1
    //   2673: iconst_2
    //   2674: invokestatic 1257	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   2677: aconst_null
    //   2678: ldc 223
    //   2680: ldc 161
    //   2682: ldc 161
    //   2684: ldc_w 1259
    //   2687: ldc_w 1259
    //   2690: iconst_0
    //   2691: iconst_0
    //   2692: ldc 161
    //   2694: ldc 161
    //   2696: ldc 161
    //   2698: ldc 161
    //   2700: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2703: return
    //   2704: aload_0
    //   2705: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2708: ifnull +5173 -> 7881
    //   2711: new 548	android/content/Intent
    //   2714: dup
    //   2715: invokespecial 1217	android/content/Intent:<init>	()V
    //   2718: astore_1
    //   2719: aload_1
    //   2720: ldc_w 1261
    //   2723: aload_0
    //   2724: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2727: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2730: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2733: pop
    //   2734: aload_0
    //   2735: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2738: aload_1
    //   2739: ldc_w 1266
    //   2742: invokestatic 1224	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   2745: aload_0
    //   2746: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2749: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2752: invokestatic 285	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2755: istore_2
    //   2756: aload_0
    //   2757: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2760: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   2763: invokestatic 285	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2766: istore_3
    //   2767: goto +65 -> 2832
    //   2770: iconst_0
    //   2771: istore_2
    //   2772: new 82	java/lang/StringBuilder
    //   2775: dup
    //   2776: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   2779: astore_1
    //   2780: aload_1
    //   2781: ldc_w 1246
    //   2784: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2787: pop
    //   2788: aload_1
    //   2789: aload_0
    //   2790: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2793: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2796: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2799: pop
    //   2800: aload_1
    //   2801: ldc_w 1268
    //   2804: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: pop
    //   2808: aload_1
    //   2809: aload_0
    //   2810: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2813: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   2816: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2819: pop
    //   2820: ldc 91
    //   2822: iconst_1
    //   2823: aload_1
    //   2824: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2827: invokestatic 1270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2830: iconst_0
    //   2831: istore_3
    //   2832: aconst_null
    //   2833: ldc 223
    //   2835: ldc 161
    //   2837: ldc 161
    //   2839: ldc_w 1272
    //   2842: ldc_w 1272
    //   2845: iload_2
    //   2846: iload_2
    //   2847: ldc 161
    //   2849: ldc 161
    //   2851: ldc 161
    //   2853: ldc 161
    //   2855: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2858: aload 12
    //   2860: ldc 223
    //   2862: ldc 161
    //   2864: ldc 161
    //   2866: ldc_w 1274
    //   2869: ldc_w 1274
    //   2872: iload_3
    //   2873: iconst_0
    //   2874: ldc 161
    //   2876: ldc 161
    //   2878: ldc 161
    //   2880: ldc 161
    //   2882: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2885: return
    //   2886: aload_0
    //   2887: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2890: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2893: istore_2
    //   2894: iload_2
    //   2895: sipush 1044
    //   2898: if_icmpeq +10 -> 2908
    //   2901: iload_2
    //   2902: sipush 1045
    //   2905: if_icmpne +4976 -> 7881
    //   2908: ldc_w 1276
    //   2911: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2914: checkcast 1276	com/tencent/mobileqq/qqexpand/chat/ILimitChatUtils
    //   2917: aload_0
    //   2918: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2921: aload_0
    //   2922: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2925: aload_0
    //   2926: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2929: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2932: invokeinterface 1279 4 0
    //   2937: return
    //   2938: aload_0
    //   2939: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2942: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2945: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   2948: astore 13
    //   2950: aload 13
    //   2952: ifnull +4929 -> 7881
    //   2955: aload 13
    //   2957: invokestatic 1284	com/tencent/mobileqq/confess/ConfessConfig:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   2960: ifeq +4921 -> 7881
    //   2963: aload_0
    //   2964: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2967: invokevirtual 1287	com/tencent/mobileqq/data/MessageRecord:isSelfConfessor	()Z
    //   2970: ifeq +21 -> 2991
    //   2973: aload 13
    //   2975: invokevirtual 1290	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2978: astore_1
    //   2979: aload_0
    //   2980: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2983: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2986: astore 12
    //   2988: goto +18 -> 3006
    //   2991: aload_0
    //   2992: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2995: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2998: astore_1
    //   2999: aload 13
    //   3001: invokevirtual 1290	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3004: astore 12
    //   3006: aload 13
    //   3008: aload_0
    //   3009: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3012: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3015: aload_0
    //   3016: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3019: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3022: aload_0
    //   3023: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3026: invokevirtual 1293	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   3029: invokestatic 1298	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   3032: iconst_0
    //   3033: invokestatic 1301	com/tencent/mobileqq/confess/ConfessConfig:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Z
    //   3036: pop
    //   3037: aload 13
    //   3039: getstatic 1304	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFESS_HANDLER	Ljava/lang/String;
    //   3042: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3045: checkcast 1306	com/tencent/mobileqq/confess/ConfessHandler
    //   3048: astore 14
    //   3050: aload 14
    //   3052: ifnull +51 -> 3103
    //   3055: aload 14
    //   3057: bipush 9
    //   3059: iconst_1
    //   3060: iconst_3
    //   3061: anewarray 586	java/lang/Object
    //   3064: dup
    //   3065: iconst_0
    //   3066: aload_0
    //   3067: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3070: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3073: aastore
    //   3074: dup
    //   3075: iconst_1
    //   3076: aload_0
    //   3077: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3080: invokevirtual 1293	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   3083: invokestatic 986	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3086: aastore
    //   3087: dup
    //   3088: iconst_2
    //   3089: aload_0
    //   3090: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3093: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3096: invokestatic 986	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3099: aastore
    //   3100: invokevirtual 1310	com/tencent/mobileqq/confess/ConfessHandler:notifyUI	(IZLjava/lang/Object;)V
    //   3103: aload 13
    //   3105: aload_0
    //   3106: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3109: aload_1
    //   3110: aload 12
    //   3112: aload_0
    //   3113: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3116: invokevirtual 1293	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   3119: aload_0
    //   3120: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3123: invokevirtual 1287	com/tencent/mobileqq/data/MessageRecord:isSelfConfessor	()Z
    //   3126: invokestatic 1313	com/tencent/mobileqq/confess/ConfessConfig:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IZ)V
    //   3129: new 82	java/lang/StringBuilder
    //   3132: dup
    //   3133: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3136: astore 14
    //   3138: aload 14
    //   3140: aload_0
    //   3141: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3144: invokevirtual 1293	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   3147: invokevirtual 758	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3150: pop
    //   3151: aload 14
    //   3153: ldc 161
    //   3155: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3158: pop
    //   3159: aload 13
    //   3161: ldc 223
    //   3163: ldc 161
    //   3165: ldc 161
    //   3167: ldc_w 1315
    //   3170: ldc_w 1315
    //   3173: iconst_0
    //   3174: iconst_0
    //   3175: aload 14
    //   3177: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3180: ldc 161
    //   3182: aload_1
    //   3183: aload 12
    //   3185: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3188: return
    //   3189: ldc_w 1201
    //   3192: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3195: checkcast 1201	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   3198: invokeinterface 1318 1 0
    //   3203: ifeq +4 -> 3207
    //   3206: return
    //   3207: aload_0
    //   3208: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3211: getfield 1015	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   3214: invokestatic 1321	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3217: astore_1
    //   3218: aload_0
    //   3219: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3222: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   3225: astore 12
    //   3227: aload_0
    //   3228: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3231: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   3234: ldc_w 1323
    //   3237: invokevirtual 1050	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3240: astore 13
    //   3242: aload 13
    //   3244: iconst_0
    //   3245: aaload
    //   3246: astore 14
    //   3248: aload 13
    //   3250: iconst_1
    //   3251: aaload
    //   3252: invokestatic 1065	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   3255: lstore 10
    //   3257: aload_0
    //   3258: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3261: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3264: istore_2
    //   3265: ldc_w 1201
    //   3268: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3271: checkcast 1201	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   3274: aload 14
    //   3276: aload_1
    //   3277: aload 12
    //   3279: invokeinterface 1327 4 0
    //   3284: astore 12
    //   3286: new 82	java/lang/StringBuilder
    //   3289: dup
    //   3290: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3293: astore 13
    //   3295: aload 13
    //   3297: ldc 91
    //   3299: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3302: pop
    //   3303: aload 13
    //   3305: getstatic 1332	com/tencent/mobileqq/teamwork/TeamWorkConstants:j	Ljava/lang/String;
    //   3308: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: pop
    //   3312: aload 13
    //   3314: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3317: astore 13
    //   3319: new 82	java/lang/StringBuilder
    //   3322: dup
    //   3323: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3326: astore 14
    //   3328: aload 14
    //   3330: ldc_w 1334
    //   3333: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: pop
    //   3337: aload 14
    //   3339: aload_1
    //   3340: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3343: pop
    //   3344: aload 14
    //   3346: ldc_w 1336
    //   3349: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3352: pop
    //   3353: aload 14
    //   3355: iload_2
    //   3356: invokevirtual 758	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3359: pop
    //   3360: aload 14
    //   3362: ldc_w 1338
    //   3365: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3368: pop
    //   3369: aload 14
    //   3371: lload 10
    //   3373: invokevirtual 1341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3376: pop
    //   3377: aload 14
    //   3379: ldc_w 1343
    //   3382: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3385: pop
    //   3386: aload 14
    //   3388: aload 12
    //   3390: invokevirtual 1346	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3393: pop
    //   3394: aload 13
    //   3396: iconst_1
    //   3397: aload 14
    //   3399: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3402: invokestatic 1348	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3405: aload 12
    //   3407: ifnull +4474 -> 7881
    //   3410: aload 12
    //   3412: getfield 1353	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:s	Ljava/lang/String;
    //   3415: getstatic 1356	com/tencent/mobileqq/teamwork/TeamWorkConstants:l	Ljava/lang/String;
    //   3418: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3421: ifeq +63 -> 3484
    //   3424: aload 12
    //   3426: getfield 1358	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:t	Ljava/lang/String;
    //   3429: astore_1
    //   3430: aload_1
    //   3431: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3434: ifne +4447 -> 7881
    //   3437: ldc_w 1201
    //   3440: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3443: checkcast 1201	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   3446: aload_0
    //   3447: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3450: aload_1
    //   3451: invokeinterface 1362 3 0
    //   3456: pop
    //   3457: aconst_null
    //   3458: ldc 223
    //   3460: ldc 161
    //   3462: ldc 161
    //   3464: ldc_w 1364
    //   3467: ldc_w 1364
    //   3470: iconst_0
    //   3471: iconst_0
    //   3472: ldc 161
    //   3474: ldc 161
    //   3476: ldc 161
    //   3478: ldc 161
    //   3480: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3483: return
    //   3484: aload_0
    //   3485: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3488: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3491: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   3494: getstatic 1367	com/tencent/mobileqq/app/BusinessHandlerFactory:TEAM_WORK_HANDLER	Ljava/lang/String;
    //   3497: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3500: checkcast 1369	com/tencent/mobileqq/teamwork/api/ITeamWorkHandler
    //   3503: astore_1
    //   3504: iload_2
    //   3505: iconst_1
    //   3506: if_icmpne +14 -> 3520
    //   3509: aload_1
    //   3510: aload 12
    //   3512: lload 10
    //   3514: invokeinterface 1373 4 0
    //   3519: return
    //   3520: aload_1
    //   3521: aload 12
    //   3523: lload 10
    //   3525: invokeinterface 1376 4 0
    //   3530: return
    //   3531: astore_1
    //   3532: new 82	java/lang/StringBuilder
    //   3535: dup
    //   3536: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3539: astore 12
    //   3541: aload 12
    //   3543: ldc 91
    //   3545: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3548: pop
    //   3549: aload 12
    //   3551: getstatic 1332	com/tencent/mobileqq/teamwork/TeamWorkConstants:j	Ljava/lang/String;
    //   3554: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3557: pop
    //   3558: aload 12
    //   3560: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3563: astore 12
    //   3565: new 82	java/lang/StringBuilder
    //   3568: dup
    //   3569: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3572: astore 13
    //   3574: aload 13
    //   3576: ldc_w 1378
    //   3579: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3582: pop
    //   3583: aload 13
    //   3585: aload_1
    //   3586: invokevirtual 1379	java/lang/Exception:toString	()Ljava/lang/String;
    //   3589: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: pop
    //   3593: aload 12
    //   3595: iconst_1
    //   3596: aload 13
    //   3598: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3601: invokestatic 1270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3604: return
    //   3605: aload_0
    //   3606: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3609: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3612: ifnull +4269 -> 7881
    //   3615: aload_0
    //   3616: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3619: astore_1
    //   3620: aload_1
    //   3621: ifnull +4260 -> 7881
    //   3624: aload_1
    //   3625: instanceof 202
    //   3628: ifeq +4253 -> 7881
    //   3631: aload_0
    //   3632: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3635: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3638: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   3641: aload_0
    //   3642: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3645: sipush 2080
    //   3648: ldc_w 333
    //   3651: invokestatic 739	com/tencent/mobileqq/loverzone/LoverZoneUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;ILjava/lang/String;)V
    //   3654: return
    //   3655: aload_0
    //   3656: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   3659: astore 13
    //   3661: aload_0
    //   3662: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3665: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3668: istore_2
    //   3669: aload_0
    //   3670: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3673: invokevirtual 1293	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   3676: istore_3
    //   3677: new 1381	com/tencent/mobileqq/confess/ConfessInfo
    //   3680: dup
    //   3681: invokespecial 1382	com/tencent/mobileqq/confess/ConfessInfo:<init>	()V
    //   3684: astore 14
    //   3686: aload 14
    //   3688: aload_0
    //   3689: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3692: ldc_w 1384
    //   3695: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   3698: invokevirtual 1387	com/tencent/mobileqq/confess/ConfessInfo:parseFromJsonStr	(Ljava/lang/String;)V
    //   3701: aload_0
    //   3702: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3705: astore_1
    //   3706: aload_1
    //   3707: instanceof 137
    //   3710: ifeq +4171 -> 7881
    //   3713: aload_1
    //   3714: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3717: invokevirtual 1390	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   3720: ifne +4161 -> 7881
    //   3723: iload_2
    //   3724: invokestatic 1392	com/tencent/imcore/message/UinTypeUtil:e	(I)I
    //   3727: sipush 1032
    //   3730: if_icmpne +4151 -> 7881
    //   3733: aload_0
    //   3734: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3737: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3740: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3743: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   3746: astore_1
    //   3747: aload_1
    //   3748: ifnull +18 -> 3766
    //   3751: aload_1
    //   3752: instanceof 1394
    //   3755: ifeq +11 -> 3766
    //   3758: aload_1
    //   3759: checkcast 1394	com/tencent/mobileqq/activity/aio/rebuild/ConfessChatPie
    //   3762: astore_1
    //   3763: goto +5 -> 3768
    //   3766: aconst_null
    //   3767: astore_1
    //   3768: aload_1
    //   3769: ifnonnull +4 -> 3773
    //   3772: return
    //   3773: aload_0
    //   3774: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3777: iconst_0
    //   3778: getstatic 1397	com/tencent/mobileqq/confess/ConfessConfig:f	Ljava/lang/String;
    //   3781: getstatic 1398	com/tencent/mobileqq/confess/ConfessConfig:g	Ljava/lang/String;
    //   3784: ldc_w 489
    //   3787: ldc_w 1399
    //   3790: new 1401	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$1
    //   3793: dup
    //   3794: aload_0
    //   3795: aload 12
    //   3797: aload 13
    //   3799: iload_2
    //   3800: iload_3
    //   3801: aload 14
    //   3803: aload_1
    //   3804: invokespecial 1404	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$1:<init>	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IILcom/tencent/mobileqq/confess/ConfessInfo;Lcom/tencent/mobileqq/activity/aio/rebuild/ConfessChatPie;)V
    //   3807: new 1406	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$2
    //   3810: dup
    //   3811: aload_0
    //   3812: invokespecial 1407	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$2:<init>	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;)V
    //   3815: invokestatic 1410	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3818: astore_1
    //   3819: aload_0
    //   3820: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3823: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3826: invokevirtual 1390	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   3829: ifne +4052 -> 7881
    //   3832: aload_1
    //   3833: invokevirtual 508	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   3836: return
    //   3837: aload_0
    //   3838: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3841: ifnull +17 -> 3858
    //   3844: aload_0
    //   3845: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3848: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   3851: aload_0
    //   3852: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3855: invokestatic 1415	com/tencent/mobileqq/vas/VasH5PayUtil:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   3858: aload_0
    //   3859: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3862: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3865: ifnull +4016 -> 7881
    //   3868: aload_0
    //   3869: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3872: astore_1
    //   3873: aload_1
    //   3874: ifnull +4007 -> 7881
    //   3877: aload_1
    //   3878: instanceof 202
    //   3881: ifeq +4000 -> 7881
    //   3884: aload_1
    //   3885: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   3888: getfield 206	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   3891: astore_1
    //   3892: aload_1
    //   3893: ifnull +3988 -> 7881
    //   3896: aload_1
    //   3897: getfield 211	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   3900: ldc 239
    //   3902: if_icmpeq +4 -> 3906
    //   3905: return
    //   3906: aload_0
    //   3907: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3910: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3913: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   3916: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   3919: ldc 244
    //   3921: ldc 246
    //   3923: ldc 161
    //   3925: iconst_1
    //   3926: iconst_0
    //   3927: iconst_0
    //   3928: ldc 161
    //   3930: ldc 161
    //   3932: ldc 145
    //   3934: invokestatic 251	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3937: return
    //   3938: aload_0
    //   3939: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3942: astore_1
    //   3943: aload_1
    //   3944: instanceof 116
    //   3947: ifne +10 -> 3957
    //   3950: aload_1
    //   3951: instanceof 1417
    //   3954: ifeq +3927 -> 7881
    //   3957: aload_0
    //   3958: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3961: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3964: astore_1
    //   3965: aload_1
    //   3966: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3969: ifnull +111 -> 4080
    //   3972: aload_1
    //   3973: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3976: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   3979: ifnull +101 -> 4080
    //   3982: aload_0
    //   3983: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3986: instanceof 1023
    //   3989: ifeq +91 -> 4080
    //   3992: aload_1
    //   3993: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3996: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   3999: aload_0
    //   4000: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4003: checkcast 1023	com/tencent/mobileqq/data/ChatMessage
    //   4006: invokevirtual 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   4009: aload 12
    //   4011: ldc_w 657
    //   4014: ldc_w 659
    //   4017: invokevirtual 663	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   4020: checkcast 657	com/tencent/mobileqq/troop/entereffect/api/ITroopEnterEffectService
    //   4023: aload_0
    //   4024: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4027: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   4030: invokeinterface 1423 2 0
    //   4035: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4038: ifeq +42 -> 4080
    //   4041: new 82	java/lang/StringBuilder
    //   4044: dup
    //   4045: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   4048: astore_1
    //   4049: aload_1
    //   4050: ldc_w 1425
    //   4053: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4056: pop
    //   4057: aload_1
    //   4058: aload_0
    //   4059: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4062: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   4065: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4068: pop
    //   4069: ldc_w 1427
    //   4072: iconst_2
    //   4073: aload_1
    //   4074: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4077: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4080: aload_0
    //   4081: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4084: astore_1
    //   4085: aload_1
    //   4086: ifnull +3795 -> 7881
    //   4089: aload_1
    //   4090: instanceof 202
    //   4093: ifeq +3788 -> 7881
    //   4096: aload_1
    //   4097: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   4100: getfield 206	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   4103: astore_1
    //   4104: aload_1
    //   4105: ifnull +3776 -> 7881
    //   4108: aload_1
    //   4109: getfield 211	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   4112: ldc 239
    //   4114: if_icmpeq +4 -> 4118
    //   4117: return
    //   4118: aload 12
    //   4120: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4123: ldc 244
    //   4125: ldc 246
    //   4127: ldc 161
    //   4129: iconst_1
    //   4130: iconst_0
    //   4131: iconst_0
    //   4132: ldc 161
    //   4134: ldc 161
    //   4136: ldc_w 323
    //   4139: invokestatic 251	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4142: return
    //   4143: aload_0
    //   4144: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   4147: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   4150: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   4153: astore 12
    //   4155: aload_0
    //   4156: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4159: astore 13
    //   4161: aload 13
    //   4163: ifnull +3718 -> 7881
    //   4166: aload 12
    //   4168: ifnull +3713 -> 7881
    //   4171: aload_0
    //   4172: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4175: astore 14
    //   4177: new 82	java/lang/StringBuilder
    //   4180: dup
    //   4181: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   4184: astore 15
    //   4186: aload 15
    //   4188: ldc 161
    //   4190: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4193: pop
    //   4194: aload 15
    //   4196: aload_0
    //   4197: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4200: getfield 1015	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   4203: invokevirtual 1341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4206: pop
    //   4207: aload 12
    //   4209: aload 13
    //   4211: aload 14
    //   4213: aload 15
    //   4215: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4218: iconst_4
    //   4219: iconst_m1
    //   4220: invokestatic 1432	com/tencent/mobileqq/profile/TroopMemberCardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   4223: aload 12
    //   4225: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4228: astore 12
    //   4230: aload_0
    //   4231: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   4234: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   4237: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   4240: getstatic 1037	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   4243: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4246: checkcast 1039	com/tencent/mobileqq/app/TroopManager
    //   4249: astore 13
    //   4251: aload 13
    //   4253: ifnull +39 -> 4292
    //   4256: aload 13
    //   4258: aload_0
    //   4259: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4262: invokevirtual 1434	com/tencent/mobileqq/app/TroopManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   4265: astore 13
    //   4267: aload 13
    //   4269: ifnull +23 -> 4292
    //   4272: aload 13
    //   4274: aload 12
    //   4276: invokevirtual 1437	com/tencent/mobileqq/data/troop/TroopInfo:isTroopOwner	(Ljava/lang/String;)Z
    //   4279: ifeq +6 -> 4285
    //   4282: goto +13 -> 4295
    //   4285: ldc_w 304
    //   4288: astore_1
    //   4289: goto +6 -> 4295
    //   4292: ldc 161
    //   4294: astore_1
    //   4295: ldc_w 1439
    //   4298: ldc_w 1441
    //   4301: ldc_w 1443
    //   4304: iconst_0
    //   4305: iconst_0
    //   4306: iconst_2
    //   4307: anewarray 279	java/lang/String
    //   4310: dup
    //   4311: iconst_0
    //   4312: aload_0
    //   4313: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4316: aastore
    //   4317: dup
    //   4318: iconst_1
    //   4319: aload_1
    //   4320: aastore
    //   4321: invokestatic 1448	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   4324: return
    //   4325: getstatic 767	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:ad	Z
    //   4328: ifeq +19 -> 4347
    //   4331: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4334: ifeq +12 -> 4346
    //   4337: ldc 91
    //   4339: iconst_2
    //   4340: ldc_w 1450
    //   4343: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4346: return
    //   4347: aload_0
    //   4348: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4351: instanceof 137
    //   4354: ifeq +3527 -> 7881
    //   4357: aload_0
    //   4358: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4361: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   4364: astore_1
    //   4365: aload_0
    //   4366: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4369: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   4372: astore 13
    //   4374: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4377: ifeq +44 -> 4421
    //   4380: lconst_0
    //   4381: lstore 10
    //   4383: aload_1
    //   4384: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4387: ifne +10 -> 4397
    //   4390: aload_1
    //   4391: invokevirtual 1453	java/lang/String:length	()I
    //   4394: i2l
    //   4395: lstore 10
    //   4397: ldc 91
    //   4399: iconst_2
    //   4400: iconst_2
    //   4401: anewarray 586	java/lang/Object
    //   4404: dup
    //   4405: iconst_0
    //   4406: ldc_w 1455
    //   4409: aastore
    //   4410: dup
    //   4411: iconst_1
    //   4412: lload 10
    //   4414: invokestatic 379	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4417: aastore
    //   4418: invokestatic 1458	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   4421: aload_0
    //   4422: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4425: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   4428: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   4431: astore 12
    //   4433: aload 12
    //   4435: ifnull +3446 -> 7881
    //   4438: aload 12
    //   4440: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   4443: ifnull +3438 -> 7881
    //   4446: aload_0
    //   4447: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4450: invokestatic 1463	com/tencent/mobileqq/graytip/UniteGrayTipUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   4453: aload 12
    //   4455: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   4458: astore 12
    //   4460: aload 12
    //   4462: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4465: ifnull +628 -> 5093
    //   4468: aload 12
    //   4470: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4473: invokevirtual 1470	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4476: ifnonnull +6 -> 4482
    //   4479: goto +614 -> 5093
    //   4482: aload 12
    //   4484: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4487: invokevirtual 1470	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4490: invokeinterface 1475 1 0
    //   4495: aload 13
    //   4497: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4500: ifne +479 -> 4979
    //   4503: new 1477	org/json/JSONArray
    //   4506: dup
    //   4507: aload 13
    //   4509: invokespecial 1479	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   4512: astore 13
    //   4514: aload 13
    //   4516: invokevirtual 1480	org/json/JSONArray:length	()I
    //   4519: ifne +3403 -> 7922
    //   4522: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4525: ifeq +12 -> 4537
    //   4528: ldc 91
    //   4530: iconst_2
    //   4531: ldc_w 1482
    //   4534: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4537: aload 12
    //   4539: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4542: aload_1
    //   4543: invokevirtual 1486	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   4546: goto +457 -> 5003
    //   4549: iload_2
    //   4550: aload 13
    //   4552: invokevirtual 1480	org/json/JSONArray:length	()I
    //   4555: if_icmpge +448 -> 5003
    //   4558: aload 13
    //   4560: iload_2
    //   4561: invokevirtual 1490	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   4564: astore 14
    //   4566: aload 14
    //   4568: getstatic 1494	com/tencent/mobileqq/service/message/MessageConstants:k	Ljava/lang/String;
    //   4571: invokevirtual 1497	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4574: astore 15
    //   4576: aload 14
    //   4578: getstatic 1498	com/tencent/mobileqq/service/message/MessageConstants:l	Ljava/lang/String;
    //   4581: invokevirtual 1501	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4584: istore 6
    //   4586: new 1477	org/json/JSONArray
    //   4589: dup
    //   4590: aload 15
    //   4592: invokespecial 1479	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   4595: astore 14
    //   4597: aload 14
    //   4599: invokevirtual 1480	org/json/JSONArray:length	()I
    //   4602: ifne +3325 -> 7927
    //   4605: aload 12
    //   4607: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4610: aload_1
    //   4611: invokevirtual 1486	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   4614: goto +389 -> 5003
    //   4617: iload_3
    //   4618: aload 14
    //   4620: invokevirtual 1480	org/json/JSONArray:length	()I
    //   4623: if_icmpge +315 -> 4938
    //   4626: aload 14
    //   4628: iload_3
    //   4629: invokevirtual 1490	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   4632: astore 15
    //   4634: aload 15
    //   4636: ldc_w 1503
    //   4639: invokevirtual 1501	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4642: istore 7
    //   4644: aload 15
    //   4646: ldc_w 1505
    //   4649: invokevirtual 1501	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4652: istore 4
    //   4654: aload 15
    //   4656: ldc_w 1507
    //   4659: invokevirtual 1501	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4662: pop
    //   4663: aload 15
    //   4665: ldc_w 1508
    //   4668: invokevirtual 1497	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4671: astore 15
    //   4673: aload_1
    //   4674: iload 7
    //   4676: iconst_1
    //   4677: iadd
    //   4678: iload 4
    //   4680: iload 7
    //   4682: iadd
    //   4683: invokevirtual 1512	java/lang/String:substring	(II)Ljava/lang/String;
    //   4686: astore 16
    //   4688: aload 12
    //   4690: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4693: invokevirtual 1515	com/tencent/widget/XEditTextEx:getSelectionEnd	()I
    //   4696: istore 5
    //   4698: iload 5
    //   4700: istore 4
    //   4702: iload 5
    //   4704: ifge +6 -> 4710
    //   4707: iconst_0
    //   4708: istore 4
    //   4710: aload_1
    //   4711: iload 4
    //   4713: iload 7
    //   4715: invokevirtual 1512	java/lang/String:substring	(II)Ljava/lang/String;
    //   4718: astore 17
    //   4720: aload 12
    //   4722: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4725: invokevirtual 1470	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4728: iload 4
    //   4730: aload 17
    //   4732: invokeinterface 1519 3 0
    //   4737: pop
    //   4738: aload_0
    //   4739: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   4742: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   4745: checkcast 287	mqq/app/AppRuntime
    //   4748: astore 17
    //   4750: aload_0
    //   4751: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4754: astore 18
    //   4756: aload_0
    //   4757: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4760: astore 19
    //   4762: aload 12
    //   4764: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4767: astore 20
    //   4769: iload 6
    //   4771: iconst_1
    //   4772: if_icmpne +3160 -> 7932
    //   4775: iconst_1
    //   4776: istore 8
    //   4778: goto +3 -> 4781
    //   4781: aload 17
    //   4783: aload 18
    //   4785: aload 19
    //   4787: aload 15
    //   4789: aload 16
    //   4791: iconst_0
    //   4792: aload 20
    //   4794: iload 8
    //   4796: invokestatic 1524	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lmqq/app/AppRuntime;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/EditText;Z)Landroid/text/SpannableString;
    //   4799: astore 15
    //   4801: aload 15
    //   4803: ifnull +128 -> 4931
    //   4806: aload 15
    //   4808: invokevirtual 1527	android/text/SpannableString:length	()I
    //   4811: ifne +6 -> 4817
    //   4814: goto +117 -> 4931
    //   4817: aload 12
    //   4819: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4822: invokevirtual 1515	com/tencent/widget/XEditTextEx:getSelectionEnd	()I
    //   4825: istore 5
    //   4827: iload 5
    //   4829: istore 4
    //   4831: iload 5
    //   4833: ifge +6 -> 4839
    //   4836: iconst_0
    //   4837: istore 4
    //   4839: aload 12
    //   4841: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4844: invokevirtual 1470	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4847: iload 4
    //   4849: aload 15
    //   4851: invokeinterface 1519 3 0
    //   4856: pop
    //   4857: iload_3
    //   4858: aload 14
    //   4860: invokevirtual 1480	org/json/JSONArray:length	()I
    //   4863: iconst_1
    //   4864: isub
    //   4865: if_icmpne +66 -> 4931
    //   4868: aload 12
    //   4870: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4873: invokevirtual 1515	com/tencent/widget/XEditTextEx:getSelectionEnd	()I
    //   4876: istore 5
    //   4878: iload 5
    //   4880: istore 4
    //   4882: iload 5
    //   4884: ifge +6 -> 4890
    //   4887: iconst_0
    //   4888: istore 4
    //   4890: iload 4
    //   4892: aload_1
    //   4893: invokevirtual 1453	java/lang/String:length	()I
    //   4896: iconst_1
    //   4897: isub
    //   4898: if_icmpgt +33 -> 4931
    //   4901: aload_1
    //   4902: iload 4
    //   4904: aload_1
    //   4905: invokevirtual 1453	java/lang/String:length	()I
    //   4908: invokevirtual 1512	java/lang/String:substring	(II)Ljava/lang/String;
    //   4911: astore 15
    //   4913: aload 12
    //   4915: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4918: invokevirtual 1470	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4921: iload 4
    //   4923: aload 15
    //   4925: invokeinterface 1519 3 0
    //   4930: pop
    //   4931: iload_3
    //   4932: iconst_1
    //   4933: iadd
    //   4934: istore_3
    //   4935: goto -318 -> 4617
    //   4938: iload_2
    //   4939: iconst_1
    //   4940: iadd
    //   4941: istore_2
    //   4942: goto -393 -> 4549
    //   4945: astore 13
    //   4947: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4950: ifeq +17 -> 4967
    //   4953: ldc 91
    //   4955: iconst_2
    //   4956: ldc_w 1529
    //   4959: aload 13
    //   4961: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4964: goto +3 -> 4967
    //   4967: aload 12
    //   4969: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4972: aload_1
    //   4973: invokevirtual 1486	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   4976: goto +27 -> 5003
    //   4979: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4982: ifeq +12 -> 4994
    //   4985: ldc 91
    //   4987: iconst_2
    //   4988: ldc_w 1531
    //   4991: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4994: aload 12
    //   4996: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   4999: aload_1
    //   5000: invokevirtual 1486	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   5003: aload 12
    //   5005: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   5008: invokevirtual 1534	com/tencent/widget/XEditTextEx:getText	()Landroid/text/Editable;
    //   5011: invokeinterface 1535 1 0
    //   5016: istore_3
    //   5017: iload_3
    //   5018: istore_2
    //   5019: iload_3
    //   5020: ifge +5 -> 5025
    //   5023: iconst_0
    //   5024: istore_2
    //   5025: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5028: ifeq +35 -> 5063
    //   5031: new 82	java/lang/StringBuilder
    //   5034: dup
    //   5035: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   5038: astore_1
    //   5039: aload_1
    //   5040: ldc_w 1537
    //   5043: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5046: pop
    //   5047: aload_1
    //   5048: iload_2
    //   5049: invokevirtual 758	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5052: pop
    //   5053: ldc 91
    //   5055: iconst_2
    //   5056: aload_1
    //   5057: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5060: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5063: aload 12
    //   5065: bipush 111
    //   5067: invokevirtual 727	com/tencent/mobileqq/activity/aio/core/BaseChatPie:q	(I)Lcom/tencent/mobileqq/activity/aio/helper/IHelper;
    //   5070: checkcast 1539	com/tencent/mobileqq/activity/aio/helper/AIODraftHelper
    //   5073: ldc 161
    //   5075: putfield 1540	com/tencent/mobileqq/activity/aio/helper/AIODraftHelper:e	Ljava/lang/String;
    //   5078: aload 12
    //   5080: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   5083: iload_2
    //   5084: invokevirtual 1543	com/tencent/widget/XEditTextEx:setSelection	(I)V
    //   5087: aload 12
    //   5089: invokevirtual 1546	com/tencent/mobileqq/activity/aio/core/BaseChatPie:aF	()V
    //   5092: return
    //   5093: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5096: ifeq +2785 -> 7881
    //   5099: ldc 91
    //   5101: iconst_2
    //   5102: ldc_w 1548
    //   5105: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5108: return
    //   5109: aload_0
    //   5110: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5113: astore_1
    //   5114: aload_1
    //   5115: instanceof 137
    //   5118: ifeq +2763 -> 7881
    //   5121: aload_1
    //   5122: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   5125: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   5128: astore_1
    //   5129: aload_1
    //   5130: ifnull +2751 -> 7881
    //   5133: aload_1
    //   5134: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5137: ifnull +2744 -> 7881
    //   5140: aload_1
    //   5141: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5144: astore_1
    //   5145: aload_1
    //   5146: instanceof 1550
    //   5149: ifeq +2732 -> 7881
    //   5152: aload_1
    //   5153: checkcast 1550	com/tencent/mobileqq/activity/aio/rebuild/BusinessCmrTmpChatPie
    //   5156: aload_0
    //   5157: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5160: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5163: invokevirtual 1552	com/tencent/mobileqq/activity/aio/rebuild/BusinessCmrTmpChatPie:e	(Ljava/lang/String;)V
    //   5166: return
    //   5167: aload_0
    //   5168: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5171: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5174: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   5177: getstatic 1037	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   5180: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5183: checkcast 1039	com/tencent/mobileqq/app/TroopManager
    //   5186: aload_0
    //   5187: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5190: invokevirtual 1042	com/tencent/mobileqq/app/TroopManager:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   5193: astore_1
    //   5194: aload_1
    //   5195: ifnull +2686 -> 7881
    //   5198: new 548	android/content/Intent
    //   5201: dup
    //   5202: invokespecial 1217	android/content/Intent:<init>	()V
    //   5205: astore 12
    //   5207: aload 12
    //   5209: ldc_w 1554
    //   5212: iconst_1
    //   5213: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5216: pop
    //   5217: aload 12
    //   5219: ldc_w 1556
    //   5222: iconst_2
    //   5223: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5226: pop
    //   5227: aload 12
    //   5229: ldc_w 1558
    //   5232: ldc_w 1559
    //   5235: invokestatic 488	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5238: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5241: pop
    //   5242: aload_1
    //   5243: getfield 1562	com/tencent/mobileqq/data/troop/TroopInfo:hasSetNewTroopName	Z
    //   5246: ifeq +16 -> 5262
    //   5249: aload 12
    //   5251: ldc_w 1564
    //   5254: aload_1
    //   5255: getfield 1070	com/tencent/mobileqq/data/troop/TroopInfo:troopname	Ljava/lang/String;
    //   5258: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5261: pop
    //   5262: aload 12
    //   5264: ldc_w 1566
    //   5267: bipush 96
    //   5269: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5272: pop
    //   5273: aload 12
    //   5275: ldc_w 1568
    //   5278: iconst_0
    //   5279: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   5282: pop
    //   5283: aload_0
    //   5284: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5287: aload 12
    //   5289: ldc_w 1570
    //   5292: sipush 13010
    //   5295: invokestatic 1575	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;I)V
    //   5298: return
    //   5299: aload_0
    //   5300: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5303: astore_1
    //   5304: aload_1
    //   5305: ifnull +2576 -> 7881
    //   5308: aload_1
    //   5309: instanceof 202
    //   5312: ifeq +2569 -> 7881
    //   5315: aload_1
    //   5316: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   5319: getfield 206	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   5322: astore_1
    //   5323: aload_1
    //   5324: getfield 1577	com/tencent/mobileqq/graytip/UniteGrayTipParam:p	Ljava/lang/String;
    //   5327: iconst_0
    //   5328: invokestatic 1582	com/tencent/mobileqq/troopAddFrd/Scene:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   5331: invokestatic 1584	com/tencent/mobileqq/troopAddFrd/Scene:a	(Ljava/lang/String;)I
    //   5334: istore_2
    //   5335: aload_1
    //   5336: getfield 1577	com/tencent/mobileqq/graytip/UniteGrayTipParam:p	Ljava/lang/String;
    //   5339: iconst_1
    //   5340: invokestatic 1582	com/tencent/mobileqq/troopAddFrd/Scene:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   5343: astore_1
    //   5344: aload_0
    //   5345: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5348: aload_0
    //   5349: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5352: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5355: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   5358: aload_0
    //   5359: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5362: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5365: aload_0
    //   5366: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5369: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   5372: iload_2
    //   5373: aload_1
    //   5374: invokestatic 1589	com/tencent/mobileqq/relationx/batchAdd/BatchAddFriendData:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   5377: return
    //   5378: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5381: ifeq +13 -> 5394
    //   5384: ldc_w 1591
    //   5387: iconst_2
    //   5388: ldc_w 1593
    //   5391: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5394: new 548	android/content/Intent
    //   5397: dup
    //   5398: aload_0
    //   5399: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5402: ldc_w 1595
    //   5405: invokespecial 690	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5408: astore_1
    //   5409: aload_1
    //   5410: ldc_w 1597
    //   5413: aload_0
    //   5414: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5417: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5420: pop
    //   5421: aload_1
    //   5422: ldc_w 1599
    //   5425: iconst_1
    //   5426: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5429: pop
    //   5430: aload_0
    //   5431: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5434: astore 12
    //   5436: aload 12
    //   5438: instanceof 137
    //   5441: ifeq +9 -> 5450
    //   5444: aload 12
    //   5446: aload_1
    //   5447: invokevirtual 609	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5450: aload_0
    //   5451: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5454: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5457: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   5460: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5463: ldc_w 1601
    //   5466: ldc_w 1603
    //   5469: ldc 161
    //   5471: iconst_1
    //   5472: iconst_0
    //   5473: iconst_0
    //   5474: aconst_null
    //   5475: aload_0
    //   5476: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5479: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5482: aconst_null
    //   5483: invokestatic 251	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5486: return
    //   5487: aload_0
    //   5488: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5491: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5494: astore 12
    //   5496: aload 12
    //   5498: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5501: ifne +2380 -> 7881
    //   5504: aload 12
    //   5506: invokestatic 1065	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5509: lstore 10
    //   5511: aload_0
    //   5512: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5515: instanceof 137
    //   5518: ifeq +2363 -> 7881
    //   5521: aload_0
    //   5522: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5525: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   5528: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   5531: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5534: astore 12
    //   5536: aload 12
    //   5538: invokevirtual 1606	com/tencent/mobileqq/activity/aio/core/BaseChatPie:ab	()Z
    //   5541: ifeq +2340 -> 7881
    //   5544: aload 12
    //   5546: invokevirtual 773	com/tencent/mobileqq/activity/aio/core/BaseChatPie:bv	()Lcom/tencent/mobileqq/activity/aio/core/AIOContext;
    //   5549: invokevirtual 778	com/tencent/mobileqq/activity/aio/core/AIOContext:e	()Lcom/tencent/mobileqq/activity/aio/core/msglist/MsgList;
    //   5552: invokevirtual 1609	com/tencent/mobileqq/activity/aio/core/msglist/MsgList:d	()Lcom/tencent/mobileqq/activity/aio/coreui/msglist/Scroller;
    //   5555: bipush 10
    //   5557: lload 10
    //   5559: iconst_0
    //   5560: invokevirtual 1614	com/tencent/mobileqq/activity/aio/coreui/msglist/Scroller:a	(IJI)V
    //   5563: invokestatic 1619	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   5566: iconst_0
    //   5567: putfield 1620	com/tencent/mobileqq/emoticon/EmojiStickerManager:i	I
    //   5570: aload_0
    //   5571: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5574: ifnull +2307 -> 7881
    //   5577: aload_0
    //   5578: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5581: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   5584: iconst_1
    //   5585: if_icmpne +10 -> 5595
    //   5588: ldc_w 304
    //   5591: astore_1
    //   5592: goto +2346 -> 7938
    //   5595: aload_0
    //   5596: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5599: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   5602: sipush 3000
    //   5605: if_icmpne +2333 -> 7938
    //   5608: ldc_w 323
    //   5611: astore_1
    //   5612: goto +2326 -> 7938
    //   5615: ldc 161
    //   5617: ldc_w 1622
    //   5620: ldc_w 1624
    //   5623: aload_1
    //   5624: iconst_1
    //   5625: iconst_0
    //   5626: iconst_0
    //   5627: aconst_null
    //   5628: ldc 161
    //   5630: ldc 161
    //   5632: invokestatic 251	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5635: return
    //   5636: astore_1
    //   5637: goto +20 -> 5657
    //   5640: astore_1
    //   5641: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5644: ifeq +2237 -> 7881
    //   5647: ldc 91
    //   5649: iconst_2
    //   5650: ldc 161
    //   5652: aload_1
    //   5653: invokestatic 1626	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5656: return
    //   5657: aload_1
    //   5658: athrow
    //   5659: aload_0
    //   5660: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5663: ifnull +2218 -> 7881
    //   5666: new 548	android/content/Intent
    //   5669: dup
    //   5670: invokespecial 1217	android/content/Intent:<init>	()V
    //   5673: astore_1
    //   5674: aload_0
    //   5675: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5678: getfield 1015	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   5681: invokestatic 1321	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5684: astore 12
    //   5686: aload_0
    //   5687: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5690: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5693: checkcast 1628	com/tencent/common/app/AppInterface
    //   5696: aload_0
    //   5697: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5700: aload 12
    //   5702: invokestatic 1633	com/tencent/mobileqq/utils/ContactUtils:c	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5705: astore 13
    //   5707: aload_1
    //   5708: ldc_w 1554
    //   5711: iconst_5
    //   5712: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5715: pop
    //   5716: aload_1
    //   5717: ldc_w 1556
    //   5720: iconst_0
    //   5721: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5724: pop
    //   5725: aload_1
    //   5726: ldc_w 1635
    //   5729: aload_0
    //   5730: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5733: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5736: pop
    //   5737: aload_1
    //   5738: ldc_w 1508
    //   5741: aload 12
    //   5743: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5746: pop
    //   5747: aload_1
    //   5748: ldc_w 1558
    //   5751: aload_0
    //   5752: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5755: invokevirtual 1639	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   5758: ldc_w 1640
    //   5761: invokevirtual 1643	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   5764: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5767: pop
    //   5768: aload_1
    //   5769: ldc_w 1564
    //   5772: aload 13
    //   5774: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5777: pop
    //   5778: aload_1
    //   5779: ldc_w 1566
    //   5782: bipush 60
    //   5784: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5787: pop
    //   5788: aload_1
    //   5789: ldc_w 1645
    //   5792: ldc_w 1646
    //   5795: invokestatic 488	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5798: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5801: pop
    //   5802: aload_1
    //   5803: ldc_w 1648
    //   5806: iconst_1
    //   5807: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   5810: pop
    //   5811: aload_0
    //   5812: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5815: aload_1
    //   5816: ldc_w 1570
    //   5819: invokestatic 1651	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V
    //   5822: return
    //   5823: aload_0
    //   5824: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5827: aload_0
    //   5828: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5831: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5834: ldc_w 1653
    //   5837: sipush 1005
    //   5840: invokestatic 1658	com/tencent/biz/qqstory/playvideo/StoryPlayerLauncher:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   5843: ldc_w 1660
    //   5846: ldc_w 1662
    //   5849: iconst_0
    //   5850: iconst_0
    //   5851: iconst_4
    //   5852: anewarray 279	java/lang/String
    //   5855: dup
    //   5856: iconst_0
    //   5857: ldc 161
    //   5859: aastore
    //   5860: dup
    //   5861: iconst_1
    //   5862: ldc 161
    //   5864: aastore
    //   5865: dup
    //   5866: iconst_2
    //   5867: ldc 161
    //   5869: aastore
    //   5870: dup
    //   5871: iconst_3
    //   5872: ldc 161
    //   5874: aastore
    //   5875: invokestatic 1667	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   5878: return
    //   5879: aconst_null
    //   5880: astore_1
    //   5881: new 548	android/content/Intent
    //   5884: dup
    //   5885: aload_0
    //   5886: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5889: ldc_w 1669
    //   5892: invokespecial 690	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5895: astore 12
    //   5897: aload_0
    //   5898: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5901: astore 13
    //   5903: aload 13
    //   5905: ifnull +12 -> 5917
    //   5908: aload 13
    //   5910: ldc_w 1671
    //   5913: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   5916: astore_1
    //   5917: aload_1
    //   5918: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5921: ifne +51 -> 5972
    //   5924: aload 12
    //   5926: ldc_w 1671
    //   5929: aload_1
    //   5930: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5933: pop
    //   5934: aload_0
    //   5935: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5938: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5941: checkcast 287	mqq/app/AppRuntime
    //   5944: ldc 214
    //   5946: ldc_w 1673
    //   5949: ldc 161
    //   5951: ldc_w 1675
    //   5954: ldc_w 1677
    //   5957: iconst_0
    //   5958: iconst_0
    //   5959: aload_0
    //   5960: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5963: ldc 161
    //   5965: ldc 161
    //   5967: ldc 161
    //   5969: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5972: aload_0
    //   5973: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5976: aload 12
    //   5978: invokevirtual 609	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5981: return
    //   5982: aload_0
    //   5983: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5986: astore_1
    //   5987: aload_1
    //   5988: ifnull +38 -> 6026
    //   5991: aload_1
    //   5992: getfield 899	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   5995: ifnull +31 -> 6026
    //   5998: aload_0
    //   5999: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   6002: getfield 899	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   6005: aload_0
    //   6006: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6009: getfield 1680	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:start	I
    //   6012: aload_0
    //   6013: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6016: getfield 1683	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:end	I
    //   6019: invokevirtual 1512	java/lang/String:substring	(II)Ljava/lang/String;
    //   6022: astore_1
    //   6023: goto +6 -> 6029
    //   6026: ldc 161
    //   6028: astore_1
    //   6029: aload_0
    //   6030: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6033: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6036: astore 12
    //   6038: aload_0
    //   6039: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6042: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   6045: astore 13
    //   6047: aload 12
    //   6049: ifnull +1832 -> 7881
    //   6052: aload 13
    //   6054: ifnull +1827 -> 7881
    //   6057: aload_0
    //   6058: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6061: astore 14
    //   6063: aload 14
    //   6065: instanceof 137
    //   6068: ifeq +1813 -> 7881
    //   6071: aload 14
    //   6073: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   6076: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   6079: astore 14
    //   6081: aload 14
    //   6083: ifnull +1798 -> 7881
    //   6086: aload 14
    //   6088: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   6091: ifnull +1790 -> 7881
    //   6094: aload 14
    //   6096: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   6099: astore 14
    //   6101: aload 14
    //   6103: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6106: ldc 161
    //   6108: invokevirtual 1486	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   6111: aload_0
    //   6112: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6115: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6118: checkcast 287	mqq/app/AppRuntime
    //   6121: aload_0
    //   6122: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6125: aload_0
    //   6126: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6129: aload 12
    //   6131: aload 13
    //   6133: iconst_0
    //   6134: aload 14
    //   6136: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6139: iconst_1
    //   6140: invokestatic 1524	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lmqq/app/AppRuntime;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/EditText;Z)Landroid/text/SpannableString;
    //   6143: astore 12
    //   6145: aload 14
    //   6147: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6150: aload 12
    //   6152: invokevirtual 1486	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   6155: aload 14
    //   6157: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6160: aload_1
    //   6161: invokevirtual 1685	com/tencent/widget/XEditTextEx:append	(Ljava/lang/CharSequence;)V
    //   6164: aload 14
    //   6166: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6169: aload 14
    //   6171: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6174: invokevirtual 1534	com/tencent/widget/XEditTextEx:getText	()Landroid/text/Editable;
    //   6177: invokeinterface 1535 1 0
    //   6182: invokevirtual 1543	com/tencent/widget/XEditTextEx:setSelection	(I)V
    //   6185: return
    //   6186: new 816	org/json/JSONObject
    //   6189: dup
    //   6190: aload_0
    //   6191: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6194: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6197: invokespecial 1686	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6200: astore 13
    //   6202: aload 13
    //   6204: ldc_w 1508
    //   6207: invokevirtual 1497	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6210: astore_1
    //   6211: aload 13
    //   6213: ldc_w 1688
    //   6216: invokevirtual 1497	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6219: astore 12
    //   6221: aload 13
    //   6223: ldc_w 1690
    //   6226: invokevirtual 1497	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6229: astore 13
    //   6231: aload_1
    //   6232: ifnull +1649 -> 7881
    //   6235: aload 12
    //   6237: ifnull +1644 -> 7881
    //   6240: aload_0
    //   6241: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6244: instanceof 137
    //   6247: ifeq +1634 -> 7881
    //   6250: aload_0
    //   6251: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6254: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   6257: invokevirtual 715	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   6260: astore 14
    //   6262: aload 14
    //   6264: ifnull +1617 -> 7881
    //   6267: aload 14
    //   6269: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   6272: ifnull +1609 -> 7881
    //   6275: aload 14
    //   6277: invokevirtual 721	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   6280: astore 14
    //   6282: aload 13
    //   6284: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6287: ifne +1654 -> 7941
    //   6290: iconst_1
    //   6291: istore 8
    //   6293: goto +3 -> 6296
    //   6296: aload_0
    //   6297: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6300: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6303: checkcast 287	mqq/app/AppRuntime
    //   6306: aload_0
    //   6307: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6310: aload_0
    //   6311: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6314: aload_1
    //   6315: aload 12
    //   6317: iconst_0
    //   6318: aload 14
    //   6320: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6323: iconst_1
    //   6324: iload 8
    //   6326: invokestatic 1693	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lmqq/app/AppRuntime;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/EditText;ZZ)Landroid/text/SpannableString;
    //   6329: astore_1
    //   6330: aload 14
    //   6332: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6335: aload_1
    //   6336: invokevirtual 1486	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   6339: aload 14
    //   6341: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6344: aload 13
    //   6346: invokevirtual 1685	com/tencent/widget/XEditTextEx:append	(Ljava/lang/CharSequence;)V
    //   6349: aload 14
    //   6351: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6354: aload 14
    //   6356: getfield 1464	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	Lcom/tencent/widget/XEditTextEx;
    //   6359: invokevirtual 1534	com/tencent/widget/XEditTextEx:getText	()Landroid/text/Editable;
    //   6362: invokeinterface 1535 1 0
    //   6367: invokevirtual 1543	com/tencent/widget/XEditTextEx:setSelection	(I)V
    //   6370: return
    //   6371: astore_1
    //   6372: aload_1
    //   6373: invokevirtual 1696	org/json/JSONException:printStackTrace	()V
    //   6376: return
    //   6377: new 548	android/content/Intent
    //   6380: dup
    //   6381: aload_0
    //   6382: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6385: ldc_w 1698
    //   6388: invokespecial 690	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6391: astore_1
    //   6392: aload_0
    //   6393: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6396: getfield 1701	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:groupId	I
    //   6399: istore_3
    //   6400: iload_3
    //   6401: iconst_m1
    //   6402: if_icmpeq +27 -> 6429
    //   6405: iload_3
    //   6406: istore_2
    //   6407: iload_3
    //   6408: ifne +65 -> 6473
    //   6411: iload_3
    //   6412: istore_2
    //   6413: ldc_w 1703
    //   6416: aload_0
    //   6417: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6420: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6423: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6426: ifeq +47 -> 6473
    //   6429: aload_0
    //   6430: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6433: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6436: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   6439: getstatic 62	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   6442: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6445: checkcast 70	com/tencent/mobileqq/app/FriendsManager
    //   6448: aload_0
    //   6449: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6452: invokevirtual 1707	com/tencent/mobileqq/app/FriendsManager:m	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   6455: astore 12
    //   6457: aload 12
    //   6459: ifnull +12 -> 6471
    //   6462: aload 12
    //   6464: getfield 1712	com/tencent/mobileqq/data/Friends:groupid	I
    //   6467: istore_2
    //   6468: goto +5 -> 6473
    //   6471: iconst_0
    //   6472: istore_2
    //   6473: aload_1
    //   6474: ldc_w 1714
    //   6477: aload_0
    //   6478: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6481: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6484: ldc_w 1716
    //   6487: iload_2
    //   6488: i2b
    //   6489: invokevirtual 1719	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   6492: pop
    //   6493: aload_0
    //   6494: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6497: astore 12
    //   6499: aload 12
    //   6501: instanceof 137
    //   6504: ifeq +18 -> 6522
    //   6507: aload 12
    //   6509: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   6512: aload_1
    //   6513: sipush 13009
    //   6516: invokevirtual 1723	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   6519: goto +9 -> 6528
    //   6522: aload 12
    //   6524: aload_1
    //   6525: invokevirtual 609	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6528: aload_0
    //   6529: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6532: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6535: checkcast 287	mqq/app/AppRuntime
    //   6538: ldc 223
    //   6540: ldc 161
    //   6542: ldc 161
    //   6544: ldc_w 1725
    //   6547: ldc_w 1725
    //   6550: iconst_0
    //   6551: iconst_0
    //   6552: ldc 161
    //   6554: ldc 161
    //   6556: ldc 161
    //   6558: ldc 161
    //   6560: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6563: ldc_w 1703
    //   6566: aload_0
    //   6567: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6570: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6573: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6576: ifeq +1305 -> 7881
    //   6579: invokestatic 1728	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6582: ifeq +42 -> 6624
    //   6585: ldc 91
    //   6587: iconst_4
    //   6588: invokestatic 1734	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   6591: ldc_w 1736
    //   6594: iconst_2
    //   6595: anewarray 586	java/lang/Object
    //   6598: dup
    //   6599: iconst_0
    //   6600: iload_2
    //   6601: invokestatic 986	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6604: aastore
    //   6605: dup
    //   6606: iconst_1
    //   6607: aload_0
    //   6608: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6611: getfield 1701	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:groupId	I
    //   6614: invokestatic 986	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6617: aastore
    //   6618: invokestatic 1739	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6621: invokestatic 1348	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6624: aload_0
    //   6625: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6628: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6631: checkcast 287	mqq/app/AppRuntime
    //   6634: ldc_w 417
    //   6637: ldc_w 1741
    //   6640: ldc 161
    //   6642: ldc_w 1743
    //   6645: ldc_w 1745
    //   6648: iconst_0
    //   6649: iconst_0
    //   6650: ldc 161
    //   6652: ldc 161
    //   6654: ldc 161
    //   6656: ldc 161
    //   6658: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6661: return
    //   6662: new 548	android/content/Intent
    //   6665: dup
    //   6666: aload_0
    //   6667: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6670: ldc_w 1747
    //   6673: invokespecial 690	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6676: astore_1
    //   6677: aload_1
    //   6678: ldc_w 1558
    //   6681: ldc_w 1748
    //   6684: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6687: ldc_w 1750
    //   6690: aload_0
    //   6691: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6694: getfield 1753	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:remark	Ljava/lang/String;
    //   6697: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6700: ldc_w 831
    //   6703: bipush 103
    //   6705: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6708: ldc_w 1755
    //   6711: bipush 96
    //   6713: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6716: ldc_w 1568
    //   6719: iconst_1
    //   6720: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6723: ldc_w 1757
    //   6726: iconst_0
    //   6727: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6730: pop
    //   6731: aload_0
    //   6732: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6735: astore 12
    //   6737: aload 12
    //   6739: instanceof 137
    //   6742: ifeq +18 -> 6760
    //   6745: aload 12
    //   6747: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   6750: aload_1
    //   6751: sipush 13008
    //   6754: invokevirtual 1723	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   6757: goto +9 -> 6766
    //   6760: aload 12
    //   6762: aload_1
    //   6763: invokevirtual 609	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6766: aload_0
    //   6767: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6770: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6773: checkcast 287	mqq/app/AppRuntime
    //   6776: ldc 223
    //   6778: ldc 161
    //   6780: ldc 161
    //   6782: ldc_w 1759
    //   6785: ldc_w 1759
    //   6788: iconst_0
    //   6789: iconst_0
    //   6790: ldc 161
    //   6792: ldc 161
    //   6794: ldc 161
    //   6796: ldc 161
    //   6798: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6801: ldc_w 1703
    //   6804: aload_0
    //   6805: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6808: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6811: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6814: ifeq +1067 -> 7881
    //   6817: aload_0
    //   6818: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6821: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6824: checkcast 287	mqq/app/AppRuntime
    //   6827: ldc_w 417
    //   6830: ldc_w 1741
    //   6833: ldc 161
    //   6835: ldc_w 1743
    //   6838: ldc_w 1761
    //   6841: iconst_0
    //   6842: iconst_0
    //   6843: ldc 161
    //   6845: ldc 161
    //   6847: ldc 161
    //   6849: ldc 161
    //   6851: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6854: return
    //   6855: aload_0
    //   6856: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   6859: astore_1
    //   6860: aload_1
    //   6861: ifnull +1020 -> 7881
    //   6864: aload_1
    //   6865: instanceof 202
    //   6868: ifeq +1013 -> 7881
    //   6871: aload_1
    //   6872: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   6875: astore_1
    //   6876: aload_0
    //   6877: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6880: astore 12
    //   6882: aload 12
    //   6884: ifnull +997 -> 7881
    //   6887: aload 12
    //   6889: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6892: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   6895: getstatic 1764	com/tencent/mobileqq/app/BusinessHandlerFactory:QIDIAN_HANDLER	Ljava/lang/String;
    //   6898: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   6901: checkcast 1766	com/tencent/qidian/controller/QidianHandler
    //   6904: astore 12
    //   6906: aload 12
    //   6908: ifnull +973 -> 7881
    //   6911: aload 12
    //   6913: aload_1
    //   6914: getfield 1769	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:extUin	Ljava/lang/String;
    //   6917: aload_1
    //   6918: getfield 1772	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:masterUin	Ljava/lang/String;
    //   6921: aload_1
    //   6922: getfield 1775	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:taskId	Ljava/lang/String;
    //   6925: aload_1
    //   6926: getfield 1778	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:uniseq	J
    //   6929: aload_1
    //   6930: getfield 1152	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   6933: invokevirtual 1781	com/tencent/qidian/controller/QidianHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V
    //   6936: return
    //   6937: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6940: ifeq +13 -> 6953
    //   6943: ldc_w 295
    //   6946: iconst_2
    //   6947: ldc_w 1593
    //   6950: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6953: aconst_null
    //   6954: ldc 223
    //   6956: ldc 161
    //   6958: ldc 161
    //   6960: ldc_w 1783
    //   6963: ldc_w 1783
    //   6966: iconst_0
    //   6967: iconst_0
    //   6968: ldc 161
    //   6970: ldc 161
    //   6972: ldc 161
    //   6974: ldc 161
    //   6976: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6979: new 548	android/content/Intent
    //   6982: dup
    //   6983: aload_0
    //   6984: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6987: ldc_w 687
    //   6990: invokespecial 690	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6993: astore_1
    //   6994: invokestatic 1788	com/tencent/mobileqq/config/business/MutualMarkConfProcessor:a	()Lcom/tencent/mobileqq/config/business/MutualMarkConfBean;
    //   6997: aload_0
    //   6998: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7001: invokevirtual 1792	com/tencent/mobileqq/config/business/MutualMarkConfBean:d	(Ljava/lang/String;)Ljava/lang/String;
    //   7004: astore 13
    //   7006: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7009: ifeq +24 -> 7033
    //   7012: ldc 91
    //   7014: iconst_2
    //   7015: ldc_w 1794
    //   7018: iconst_1
    //   7019: anewarray 586	java/lang/Object
    //   7022: dup
    //   7023: iconst_0
    //   7024: aload 13
    //   7026: aastore
    //   7027: invokestatic 990	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7030: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7033: aload_1
    //   7034: ldc_w 692
    //   7037: aload 13
    //   7039: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7042: pop
    //   7043: aload_1
    //   7044: ldc_w 1796
    //   7047: iconst_1
    //   7048: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7051: pop
    //   7052: aload_1
    //   7053: ldc_w 1798
    //   7056: iconst_1
    //   7057: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7060: pop
    //   7061: aload_1
    //   7062: ldc_w 1800
    //   7065: iconst_0
    //   7066: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7069: pop
    //   7070: aload_0
    //   7071: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7074: astore 13
    //   7076: aload 13
    //   7078: ifnull +9 -> 7087
    //   7081: aload 13
    //   7083: aload_1
    //   7084: invokevirtual 609	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   7087: aload_0
    //   7088: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7091: astore_1
    //   7092: aload_1
    //   7093: ifnull +86 -> 7179
    //   7096: aload_1
    //   7097: instanceof 202
    //   7100: ifeq +79 -> 7179
    //   7103: aload_1
    //   7104: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7107: getfield 206	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7110: astore_1
    //   7111: aload_1
    //   7112: ifnull +47 -> 7159
    //   7115: ldc 252
    //   7117: aload_1
    //   7118: getfield 211	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   7121: if_icmpne +38 -> 7159
    //   7124: aload_0
    //   7125: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7128: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7131: checkcast 287	mqq/app/AppRuntime
    //   7134: ldc 223
    //   7136: ldc 161
    //   7138: ldc 161
    //   7140: ldc_w 289
    //   7143: ldc_w 1802
    //   7146: iconst_0
    //   7147: iconst_0
    //   7148: ldc 161
    //   7150: ldc 161
    //   7152: ldc 161
    //   7154: ldc 161
    //   7156: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7159: aload_1
    //   7160: ifnull +19 -> 7179
    //   7163: aload 12
    //   7165: aload_0
    //   7166: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7169: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7172: aload_1
    //   7173: getfield 211	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   7176: invokestatic 1805	com/tencent/mobileqq/mutualmark/MutualMarkBusinessLogicHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/graytip/MessageForUniteGrayTip;I)V
    //   7179: aload_0
    //   7180: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7183: astore_1
    //   7184: aload_1
    //   7185: ifnull +696 -> 7881
    //   7188: aload_1
    //   7189: instanceof 202
    //   7192: ifeq +689 -> 7881
    //   7195: aload_1
    //   7196: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7199: getfield 206	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7202: astore_1
    //   7203: aload_1
    //   7204: ifnull +677 -> 7881
    //   7207: ldc_w 1806
    //   7210: aload_1
    //   7211: getfield 211	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   7214: if_icmpne +667 -> 7881
    //   7217: aload_0
    //   7218: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7221: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7224: checkcast 287	mqq/app/AppRuntime
    //   7227: ldc 223
    //   7229: ldc 161
    //   7231: ldc 161
    //   7233: ldc_w 1808
    //   7236: ldc_w 1808
    //   7239: iconst_0
    //   7240: iconst_0
    //   7241: ldc 161
    //   7243: ldc 161
    //   7245: ldc 161
    //   7247: ldc 161
    //   7249: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7252: return
    //   7253: aload_0
    //   7254: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7257: aload_0
    //   7258: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7261: invokestatic 1813	com/tencent/mobileqq/troop/utils/HWTroopUtils:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   7264: ldc_w 1815
    //   7267: ldc_w 419
    //   7270: ldc_w 1817
    //   7273: iconst_0
    //   7274: iconst_0
    //   7275: iconst_1
    //   7276: anewarray 279	java/lang/String
    //   7279: dup
    //   7280: iconst_0
    //   7281: aload_0
    //   7282: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7285: aastore
    //   7286: invokestatic 1448	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   7289: return
    //   7290: new 548	android/content/Intent
    //   7293: dup
    //   7294: invokespecial 1217	android/content/Intent:<init>	()V
    //   7297: astore_1
    //   7298: aload_1
    //   7299: ldc_w 1819
    //   7302: aload_0
    //   7303: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7306: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7309: pop
    //   7310: aload_1
    //   7311: ldc_w 1821
    //   7314: iconst_1
    //   7315: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7318: pop
    //   7319: aload_1
    //   7320: ldc_w 1823
    //   7323: iconst_1
    //   7324: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7327: pop
    //   7328: aload_1
    //   7329: ldc_w 1825
    //   7332: aload_0
    //   7333: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7336: ldc_w 1826
    //   7339: invokevirtual 1827	android/content/Context:getString	(I)Ljava/lang/String;
    //   7342: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7345: pop
    //   7346: aload_1
    //   7347: ldc_w 1829
    //   7350: iconst_1
    //   7351: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7354: pop
    //   7355: aload_1
    //   7356: ldc_w 1831
    //   7359: iconst_1
    //   7360: invokevirtual 697	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7363: pop
    //   7364: aload_1
    //   7365: ldc_w 1833
    //   7368: aload_0
    //   7369: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7372: ldc_w 1834
    //   7375: invokevirtual 1827	android/content/Context:getString	(I)Ljava/lang/String;
    //   7378: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7381: pop
    //   7382: aload_1
    //   7383: ldc_w 1836
    //   7386: bipush 100
    //   7388: invokevirtual 1264	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7391: pop
    //   7392: ldc_w 1838
    //   7395: invokestatic 440	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   7398: checkcast 1838	com/tencent/mobileqq/selectmember/api/ISelectMemberApi
    //   7401: aload_0
    //   7402: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7405: aload_1
    //   7406: invokeinterface 1842 3 0
    //   7411: return
    //   7412: new 1844	com/tencent/mobileqq/troop/data/TroopInfoData
    //   7415: dup
    //   7416: invokespecial 1845	com/tencent/mobileqq/troop/data/TroopInfoData:<init>	()V
    //   7419: astore_1
    //   7420: aload_1
    //   7421: aload_0
    //   7422: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7425: putfield 1847	com/tencent/mobileqq/troop/data/TroopInfoData:troopUin	Ljava/lang/String;
    //   7428: aload_0
    //   7429: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7432: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7435: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7438: getstatic 1037	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   7441: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7444: checkcast 1039	com/tencent/mobileqq/app/TroopManager
    //   7447: astore 12
    //   7449: aload 12
    //   7451: ifnull +430 -> 7881
    //   7454: aload 12
    //   7456: aload_0
    //   7457: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7460: invokevirtual 1434	com/tencent/mobileqq/app/TroopManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   7463: astore 12
    //   7465: aload 12
    //   7467: ifnull +34 -> 7501
    //   7470: aload_1
    //   7471: aload 12
    //   7473: aload_0
    //   7474: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7477: invokevirtual 1639	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7480: aload_0
    //   7481: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7484: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7487: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7490: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7493: invokevirtual 1851	com/tencent/mobileqq/troop/data/TroopInfoData:updateForTroopChatSetting	(Lcom/tencent/mobileqq/data/troop/TroopInfo;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   7496: aload_1
    //   7497: iconst_1
    //   7498: putfield 1854	com/tencent/mobileqq/troop/data/TroopInfoData:isMember	Z
    //   7501: new 1856	com/tencent/mobileqq/troopshare/TroopShareUtility
    //   7504: dup
    //   7505: aload_0
    //   7506: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7509: checkcast 1417	com/tencent/mobileqq/activity/SplashActivity
    //   7512: aload_1
    //   7513: invokespecial 1859	com/tencent/mobileqq/troopshare/TroopShareUtility:<init>	(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/troop/data/TroopInfoData;)V
    //   7516: aload_1
    //   7517: invokevirtual 1862	com/tencent/mobileqq/troopshare/TroopShareUtility:a	(Lcom/tencent/mobileqq/troop/data/TroopInfoData;)V
    //   7520: return
    //   7521: aload_0
    //   7522: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7525: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7528: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7531: astore_1
    //   7532: aload_0
    //   7533: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7536: astore 12
    //   7538: aload 12
    //   7540: ifnull +341 -> 7881
    //   7543: aload_1
    //   7544: ifnull +337 -> 7881
    //   7547: aload_0
    //   7548: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7551: astore 13
    //   7553: new 82	java/lang/StringBuilder
    //   7556: dup
    //   7557: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   7560: astore 14
    //   7562: aload 14
    //   7564: ldc 161
    //   7566: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7569: pop
    //   7570: aload 14
    //   7572: aload_0
    //   7573: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7576: getfield 1015	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   7579: invokevirtual 1341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7582: pop
    //   7583: aload_1
    //   7584: aload 12
    //   7586: aload 13
    //   7588: aload 14
    //   7590: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7593: iconst_4
    //   7594: iconst_m1
    //   7595: invokestatic 1432	com/tencent/mobileqq/profile/TroopMemberCardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   7598: return
    //   7599: iconst_2
    //   7600: istore_2
    //   7601: aload_0
    //   7602: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7605: invokevirtual 188	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7608: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7611: getstatic 1037	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   7614: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7617: checkcast 1039	com/tencent/mobileqq/app/TroopManager
    //   7620: aload_0
    //   7621: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7624: invokevirtual 1434	com/tencent/mobileqq/app/TroopManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   7627: ifnonnull +6 -> 7633
    //   7630: goto +5 -> 7635
    //   7633: iconst_1
    //   7634: istore_2
    //   7635: aload_0
    //   7636: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7639: iconst_4
    //   7640: invokestatic 1249	com/tencent/mobileqq/troop/utils/TroopInfoUIUtil:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   7643: astore_1
    //   7644: aload_1
    //   7645: ldc_w 1251
    //   7648: sipush 1001
    //   7651: invokevirtual 1254	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   7654: aload_0
    //   7655: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7658: aload_1
    //   7659: iload_2
    //   7660: invokestatic 1257	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   7663: return
    //   7664: aload_0
    //   7665: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7668: astore_1
    //   7669: aload_1
    //   7670: ifnull +165 -> 7835
    //   7673: aload_1
    //   7674: instanceof 202
    //   7677: ifeq +158 -> 7835
    //   7680: aload_1
    //   7681: checkcast 202	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7684: getfield 206	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7687: getfield 211	com/tencent/mobileqq/graytip/UniteGrayTipParam:i	I
    //   7690: ldc_w 336
    //   7693: if_icmpne +142 -> 7835
    //   7696: aload_0
    //   7697: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7700: ldc 153
    //   7702: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   7705: astore_1
    //   7706: aload_0
    //   7707: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7710: ldc 165
    //   7712: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   7715: astore 13
    //   7717: aload_0
    //   7718: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7721: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   7724: ifne +8 -> 7732
    //   7727: iconst_1
    //   7728: istore_2
    //   7729: goto +21 -> 7750
    //   7732: aload_0
    //   7733: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7736: getfield 341	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   7739: iconst_1
    //   7740: if_icmpne +8 -> 7748
    //   7743: iconst_2
    //   7744: istore_2
    //   7745: goto +5 -> 7750
    //   7748: iconst_3
    //   7749: istore_2
    //   7750: new 82	java/lang/StringBuilder
    //   7753: dup
    //   7754: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   7757: astore 14
    //   7759: aload 14
    //   7761: ldc 161
    //   7763: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7766: pop
    //   7767: aload 14
    //   7769: aload 13
    //   7771: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7774: pop
    //   7775: aload 14
    //   7777: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7780: astore 13
    //   7782: new 82	java/lang/StringBuilder
    //   7785: dup
    //   7786: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   7789: astore 14
    //   7791: aload 14
    //   7793: ldc 161
    //   7795: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7798: pop
    //   7799: aload 14
    //   7801: aload_1
    //   7802: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7805: pop
    //   7806: aload 12
    //   7808: ldc 159
    //   7810: ldc 161
    //   7812: ldc 161
    //   7814: ldc 163
    //   7816: ldc 163
    //   7818: iload_2
    //   7819: iconst_0
    //   7820: aload 13
    //   7822: aload 14
    //   7824: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7827: ldc_w 1864
    //   7830: ldc 161
    //   7832: invokestatic 173	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7835: aload_0
    //   7836: aload_0
    //   7837: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7840: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   7843: aload_0
    //   7844: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7847: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   7850: invokevirtual 1866	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickPluginMsg	(Ljava/lang/String;Ljava/lang/String;)Z
    //   7853: pop
    //   7854: return
    //   7855: aload_0
    //   7856: aload_0
    //   7857: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7860: getfield 257	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   7863: aload_0
    //   7864: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7867: getfield 260	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   7870: invokevirtual 1868	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickAppMsg	(Ljava/lang/String;Ljava/lang/String;)Z
    //   7873: pop
    //   7874: return
    //   7875: aload_0
    //   7876: aload 12
    //   7878: invokespecial 1870	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:onClickActionWeb	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   7881: return
    //   7882: astore 13
    //   7884: goto -7101 -> 783
    //   7887: astore_1
    //   7888: goto -5287 -> 2601
    //   7891: astore_1
    //   7892: goto -5122 -> 2770
    //   7895: astore_1
    //   7896: goto -5124 -> 2772
    //   7899: bipush 8
    //   7901: istore_2
    //   7902: goto -5836 -> 2066
    //   7905: bipush 10
    //   7907: istore_2
    //   7908: goto -5842 -> 2066
    //   7911: bipush 12
    //   7913: istore_2
    //   7914: goto -5848 -> 2066
    //   7917: iconst_m1
    //   7918: istore_2
    //   7919: goto -5853 -> 2066
    //   7922: iconst_0
    //   7923: istore_2
    //   7924: goto -3375 -> 4549
    //   7927: iconst_0
    //   7928: istore_3
    //   7929: goto -3312 -> 4617
    //   7932: iconst_0
    //   7933: istore 8
    //   7935: goto -3154 -> 4781
    //   7938: goto -2323 -> 5615
    //   7941: iconst_0
    //   7942: istore 8
    //   7944: goto -1648 -> 6296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7947	0	this	HightlightClickableSpan
    //   0	7947	1	paramView	android.view.View
    //   30	7894	2	i	int
    //   99	7830	3	j	int
    //   4652	270	4	k	int
    //   4696	187	5	m	int
    //   4584	189	6	n	int
    //   4642	72	7	i1	int
    //   27	7916	8	bool1	boolean
    //   1856	97	9	bool2	boolean
    //   3255	2303	10	l	long
    //   84	7793	12	localObject1	Object
    //   756	3803	13	localObject2	Object
    //   4945	15	13	localJSONException	org.json.JSONException
    //   5705	2116	13	localObject3	Object
    //   7882	1	13	localThrowable	java.lang.Throwable
    //   1553	6270	14	localObject4	Object
    //   4184	740	15	localObject5	Object
    //   4686	104	16	str1	String
    //   4718	64	17	localObject6	Object
    //   4754	30	18	localContext	Context
    //   4760	26	19	str2	String
    //   4767	26	20	localXEditTextEx	com.tencent.widget.XEditTextEx
    // Exception table:
    //   from	to	target	type
    //   603	688	689	org/json/JSONException
    //   1756	1781	2133	java/lang/RuntimeException
    //   1781	1796	2133	java/lang/RuntimeException
    //   1801	1912	2133	java/lang/RuntimeException
    //   1917	1927	2133	java/lang/RuntimeException
    //   1932	1947	2133	java/lang/RuntimeException
    //   1957	1967	2133	java/lang/RuntimeException
    //   1972	1987	2133	java/lang/RuntimeException
    //   1993	2008	2133	java/lang/RuntimeException
    //   2014	2039	2133	java/lang/RuntimeException
    //   2045	2060	2133	java/lang/RuntimeException
    //   2066	2130	2133	java/lang/RuntimeException
    //   3207	3242	3531	java/lang/Exception
    //   3248	3405	3531	java/lang/Exception
    //   3410	3483	3531	java/lang/Exception
    //   3484	3504	3531	java/lang/Exception
    //   3509	3519	3531	java/lang/Exception
    //   3520	3530	3531	java/lang/Exception
    //   4503	4537	4945	org/json/JSONException
    //   4537	4546	4945	org/json/JSONException
    //   4549	4614	4945	org/json/JSONException
    //   4617	4698	4945	org/json/JSONException
    //   4710	4769	4945	org/json/JSONException
    //   4781	4801	4945	org/json/JSONException
    //   4806	4814	4945	org/json/JSONException
    //   4817	4827	4945	org/json/JSONException
    //   4839	4878	4945	org/json/JSONException
    //   4890	4931	4945	org/json/JSONException
    //   5504	5588	5636	finally
    //   5595	5608	5636	finally
    //   5615	5635	5636	finally
    //   5641	5656	5636	finally
    //   5504	5588	5640	java/lang/Exception
    //   5595	5608	5640	java/lang/Exception
    //   5615	5635	5640	java/lang/Exception
    //   6186	6231	6371	org/json/JSONException
    //   6240	6262	6371	org/json/JSONException
    //   6267	6290	6371	org/json/JSONException
    //   6296	6370	6371	org/json/JSONException
    //   766	783	7882	java/lang/Throwable
    //   2563	2600	7887	java/lang/NumberFormatException
    //   2745	2756	7891	java/lang/NumberFormatException
    //   2756	2767	7895	java/lang/NumberFormatException
  }
  
  protected final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = -1;
    } else {
      i = paramString1.indexOf("://");
    }
    if (i == -1)
    {
      arrayOfString[0] = paramString1;
      return arrayOfString;
    }
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    int i = this.color;
    if (i == -1) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    } else {
      paramTextPaint.setColor(i);
    }
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */