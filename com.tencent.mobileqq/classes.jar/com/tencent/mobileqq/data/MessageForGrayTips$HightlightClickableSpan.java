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
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
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
      if (((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString))
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
        if (localUniteGrayTipParam.b == 2359297)
        {
          ReportController.b(null, "P_CliOper", "cmshow", "", "Apollo", "Invitetip_clk", 0, 0, "", "", "", "");
          localObject1 = (IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class);
          ((IApolloDtReportHelper)localObject1).report("aio_bubble", "apollo_tips", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)localObject1).getApolloMode(paramQQAppInterface)).b(((IApolloDtReportHelper)localObject1).getReportSessionType(this.message.istroop)).a(this.message.msg).b(this.frienduin).a());
        }
        else if (localUniteGrayTipParam.b == 2359298)
        {
          ReportController.b(null, "P_CliOper", "cmshow", "", "Apollo", "clk_intro", 0, 0, "", "", "", "");
        }
        else if (localUniteGrayTipParam.b == 2490369)
        {
          ReportController.b(null, "dc00898", "", "", "0X8007F12", "0X8007F12", 0, 0, "", "", "", "");
        }
        else if (localUniteGrayTipParam.b == 2621441)
        {
          localObject1 = ((MessageForUniteGrayTip)this.message).appGuideTipsOpKey;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
          }
        }
        else if (localUniteGrayTipParam.b == 3145729)
        {
          ReportController.b(null, "dc00898", "", "", "0X800812B", "0X800812B", 0, 0, "", "", "", "");
        }
        else if (localUniteGrayTipParam.b == 131078)
        {
          VasWebviewUtil.a(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "0");
        }
        else if (localUniteGrayTipParam.b == 2097154)
        {
          if (TextUtils.isEmpty(this.item.mMsgActionData)) {
            localObject1 = this.item.mMsgAActionData;
          } else {
            localObject1 = this.item.mMsgActionData;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1506;
          }
          localObject2 = HttpUtil.decodeURL((String)localObject1);
          if (!((Map)localObject2).containsKey("type")) {
            break label1506;
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
      label542:
      String str;
      Object localObject3;
      StringBuilder localStringBuilder;
      label1506:
      break label542;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse url type error:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("reactive", 2, ((StringBuilder)localObject2).toString());
      break label1506;
      if (localUniteGrayTipParam.b == 655384)
      {
        localObject2 = this.message.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "1";
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", (String)localObject1, "", "2"));
      }
      else if (localUniteGrayTipParam.b == 2097153)
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
      else if (localUniteGrayTipParam.b == 655397)
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
        TogetherUtils.a((String)localObject1, localUniteGrayTipParam.jdField_a_of_type_JavaLangString);
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
      else if (localUniteGrayTipParam.b == 131090)
      {
        TroopEssenceUtil.a((QQAppInterface)this.mApp.get(), this.frienduin);
        TroopEssenceReportUtil.b((QQAppInterface)this.mApp.get(), this.frienduin);
      }
      else if (localUniteGrayTipParam.b == 656397)
      {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.e, "1", "145", "920", "92005", "207654", localUniteGrayTipParam.c, "", "20", "");
      }
    }
    if (MutualMarkUtils.b(localUniteGrayTipParam.b))
    {
      if (TextUtils.isEmpty(this.item.mMsgActionData)) {
        localObject1 = this.item.mMsgAActionData;
      } else {
        localObject1 = this.item.mMsgActionData;
      }
      MutualMarkBusinessLogicHelper.a(paramQQAppInterface, (MessageForUniteGrayTip)this.message, localUniteGrayTipParam.b, (String)localObject1);
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
    paramQQAppInterface = HardCodeUtil.a(2131706633);
    if (this.item.mMsgAActionData != null) {
      paramQQAppInterface = this.item.mMsgAActionData;
    }
    DialogUtil.a(this.context, null, paramQQAppInterface, null, 2131690728, 2131691767, new MessageForGrayTips.HightlightClickableSpan.4(this), new MessageForGrayTips.HightlightClickableSpan.5(this)).show();
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
        paramString1.d();
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
      if ((localObject != null) && ((localObject instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject).tipParam.b == 131078))
      {
        if (this.mApp.get() != null) {
          ((ITroopEnterEffectService)((QQAppInterface)this.mApp.get()).getRuntimeService(ITroopEnterEffectService.class, "all")).report("Grp_AIO", "grey_clk", new String[] { this.message.frienduin });
        }
        localObject = this.context;
        SharedPreUtils.n((Context)localObject, ((BaseActivity)localObject).app.getCurrentAccountUin(), this.message.frienduin);
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
        if ((paramString != null) && (paramString.a() != null))
        {
          ((GiftPanelHelper)paramString.a().a(136)).a(true);
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
    //   4: ifnull +7765 -> 7769
    //   7: aload_0
    //   8: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +7756 -> 7769
    //   16: aload_1
    //   17: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
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
    //   45: ldc_w 788
    //   48: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   57: getfield 791	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:actionType	I
    //   60: invokevirtual 794	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 91
    //   66: iconst_2
    //   67: aload_1
    //   68: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   78: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   81: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   84: astore 12
    //   86: aload 12
    //   88: ifnonnull +4 -> 92
    //   91: return
    //   92: aload_0
    //   93: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   96: getfield 791	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:actionType	I
    //   99: istore_3
    //   100: ldc 145
    //   102: astore_1
    //   103: iload_3
    //   104: tableswitch	default:+280 -> 384, 1:+7659->7763, 2:+7639->7743, 3:+7448->7552, 4:+7383->7487, 5:+7305->7409, 6:+7196->7300, 7:+7074->7178, 8:+280->384, 9:+280->384, 10:+7037->7141, 11:+6717->6821, 12:+6635->6739, 13:+6441->6545, 14:+6155->6259, 15:+5964->6068, 16:+5760->5864, 17:+5657->5761, 18:+5601->5705, 19:+5437->5541, 20:+5265->5369, 21:+5156->5260, 22:+280->384, 23:+280->384, 24:+5077->5181, 25:+4945->5049, 26:+4887->4991, 27:+4103->4207, 28:+3921->4025, 29:+3713->3817, 30:+3609->3713, 31:+3427->3531, 32:+3377->3481, 33:+2960->3064, 34:+2708->2812, 35:+280->384, 36:+2656->2760, 37:+280->384, 38:+2450->2554, 39:+2391->2495, 40:+2252->2356, 41:+2200->2304, 42:+2071->2175, 43:+1984->2088, 44:+1959->2063, 45:+1944->2048, 46:+1877->1981, 47:+1465->1569, 48:+1190->1294, 49:+280->384, 50:+1091->1195, 51:+989->1093, 52:+953->1057, 53:+920->1024, 54:+880->984, 55:+873->977, 56:+854->958, 57:+835->939, 58:+806->910, 59:+781->885, 60:+738->842, 61:+698->802, 62:+669->773, 63:+644->748, 64:+626->730, 65:+443->547, 66:+281->385
    //   385: aload_0
    //   386: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   389: astore_1
    //   390: aload_1
    //   391: ifnull +7378 -> 7769
    //   394: new 586	android/content/Intent
    //   397: dup
    //   398: aload_1
    //   399: ldc_w 725
    //   402: invokespecial 728	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   405: astore_1
    //   406: aload_1
    //   407: ldc_w 730
    //   410: ldc_w 796
    //   413: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   416: pop
    //   417: aload_0
    //   418: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   421: aload_1
    //   422: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   425: new 798	org/json/JSONObject
    //   428: dup
    //   429: invokespecial 799	org/json/JSONObject:<init>	()V
    //   432: astore_1
    //   433: aload_1
    //   434: ldc_w 801
    //   437: ldc_w 803
    //   440: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload_1
    //   445: ldc_w 809
    //   448: ldc_w 811
    //   451: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   454: pop
    //   455: aload_1
    //   456: ldc_w 813
    //   459: ldc 232
    //   461: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   464: pop
    //   465: aload_1
    //   466: ldc_w 815
    //   469: aload 12
    //   471: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   474: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   477: pop
    //   478: aload_1
    //   479: ldc_w 817
    //   482: aload 12
    //   484: invokevirtual 821	com/tencent/mobileqq/app/QQAppInterface:getAppid	()I
    //   487: invokestatic 743	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   490: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   493: pop
    //   494: new 823	com/tencent/mobileqq/dating/NearbyCGIReporter
    //   497: dup
    //   498: invokespecial 824	com/tencent/mobileqq/dating/NearbyCGIReporter:<init>	()V
    //   501: aload_1
    //   502: invokevirtual 827	com/tencent/mobileqq/dating/NearbyCGIReporter:a	(Lorg/json/JSONObject;)V
    //   505: return
    //   506: astore_1
    //   507: new 82	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   514: astore 12
    //   516: aload 12
    //   518: ldc_w 829
    //   521: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 12
    //   527: aload_1
    //   528: invokevirtual 830	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   531: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: ldc 91
    //   537: iconst_1
    //   538: aload 12
    //   540: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: return
    //   547: aload 12
    //   549: ldc 116
    //   551: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   554: astore_1
    //   555: aload_1
    //   556: ifnull +7213 -> 7769
    //   559: aload 12
    //   561: ldc_w 832
    //   564: ldc_w 697
    //   567: invokevirtual 701	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   570: checkcast 832	com/tencent/mobileqq/apollo/api/IApolloManagerService
    //   573: astore 13
    //   575: aload 13
    //   577: iconst_1
    //   578: invokeinterface 836 2 0
    //   583: aload 13
    //   585: aload_0
    //   586: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   589: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   592: invokestatic 334	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   595: invokeinterface 836 2 0
    //   600: aload_1
    //   601: bipush 49
    //   603: invokevirtual 839	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   606: invokevirtual 844	android/os/Message:sendToTarget	()V
    //   609: aload_0
    //   610: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   613: ifnull +7156 -> 7769
    //   616: aload 12
    //   618: ldc 214
    //   620: ldc 216
    //   622: ldc_w 846
    //   625: ldc_w 848
    //   628: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   631: checkcast 848	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   634: aload_0
    //   635: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   638: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   641: invokeinterface 851 2 0
    //   646: iconst_0
    //   647: iconst_0
    //   648: anewarray 328	java/lang/String
    //   651: invokestatic 856	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   654: ldc 220
    //   656: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   659: checkcast 220	com/tencent/mobileqq/apollo/statistics/product/api/IApolloDtReportHelper
    //   662: astore_1
    //   663: aload_1
    //   664: ldc 228
    //   666: ldc 230
    //   668: ldc 232
    //   670: new 234	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder
    //   673: dup
    //   674: invokespecial 235	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:<init>	()V
    //   677: aload_1
    //   678: aload 12
    //   680: invokeinterface 239 2 0
    //   685: invokevirtual 242	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:a	(I)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   688: aload_1
    //   689: aload_0
    //   690: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   693: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   696: invokeinterface 249 2 0
    //   701: invokevirtual 251	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:b	(I)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   704: aload_0
    //   705: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   708: getfield 254	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   711: invokevirtual 257	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   714: aload_0
    //   715: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   718: invokevirtual 259	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;
    //   721: invokevirtual 262	com/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder:a	()Ljava/util/HashMap;
    //   724: invokeinterface 266 5 0
    //   729: return
    //   730: aload 12
    //   732: getstatic 859	com/tencent/mobileqq/app/QQManagerFactory:PAI_YI_PAI_MANAGER	I
    //   735: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   738: checkcast 861	com/tencent/mobileqq/activity/aio/avatardoubletap/PaiYiPaiManager
    //   741: aload_0
    //   742: invokevirtual 863	com/tencent/mobileqq/activity/aio/avatardoubletap/PaiYiPaiManager:a	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;)V
    //   745: goto +57 -> 802
    //   748: aload_0
    //   749: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   752: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   755: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   758: aload_0
    //   759: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   762: aload_0
    //   763: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   766: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   769: invokestatic 868	com/tencent/mobileqq/troop/shortcutbar/TroopShortcutBarUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   772: return
    //   773: aload_0
    //   774: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   777: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   780: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   783: aload_0
    //   784: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   787: aload_0
    //   788: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   791: aload_0
    //   792: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   795: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   798: invokestatic 871	com/tencent/mobileqq/troop/shortcutbar/TroopShortcutBarUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   801: return
    //   802: aload_0
    //   803: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   806: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   809: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   812: aload_0
    //   813: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   816: aload_0
    //   817: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   820: aload_0
    //   821: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   824: aload_0
    //   825: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   828: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   831: aload_0
    //   832: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   835: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   838: invokestatic 876	com/tencent/mobileqq/troop/utils/TroopUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   841: return
    //   842: aload_0
    //   843: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   846: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   849: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   852: invokestatic 881	com/tencent/mobileqq/together/TogetherControlManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/together/TogetherControlManager;
    //   855: aload_0
    //   856: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   859: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   862: iconst_2
    //   863: iconst_1
    //   864: aload_0
    //   865: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   868: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   871: lconst_0
    //   872: bipush 10
    //   874: new 883	android/os/Bundle
    //   877: dup
    //   878: invokespecial 884	android/os/Bundle:<init>	()V
    //   881: invokevirtual 887	com/tencent/mobileqq/together/TogetherControlManager:a	(Lcom/tencent/mobileqq/app/BaseActivity;IILjava/lang/String;JILandroid/os/Bundle;)V
    //   884: return
    //   885: aload_0
    //   886: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   889: astore_1
    //   890: aload_1
    //   891: ifnull +6878 -> 7769
    //   894: aload_0
    //   895: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   898: aload_1
    //   899: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   902: aload_0
    //   903: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   906: invokestatic 892	com/tencent/mobileqq/listentogether/ListenTogetherUtils:a	(Landroid/content/Context;ILjava/lang/String;)V
    //   909: return
    //   910: aload_0
    //   911: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   914: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   917: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   920: aload_0
    //   921: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   924: aload_0
    //   925: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   928: aload_0
    //   929: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   932: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   935: invokestatic 893	com/tencent/mobileqq/troop/essencemsg/TroopEssenceUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   938: return
    //   939: ldc_w 895
    //   942: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   945: checkcast 895	com/tencent/mobileqq/qqexpand/chat/IAioColdPalaceHelper
    //   948: aload_0
    //   949: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   952: invokeinterface 899 2 0
    //   957: return
    //   958: aload 12
    //   960: aload_0
    //   961: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   964: ldc 145
    //   966: aload_0
    //   967: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   970: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   973: invokestatic 904	com/tencent/mobileqq/graytip/CustomizeGrayTipsManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   976: return
    //   977: aload_0
    //   978: aload 12
    //   980: invokespecial 906	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:doAddFriendSafetyReport	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   983: return
    //   984: aload_0
    //   985: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   988: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   991: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   994: aload_0
    //   995: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   998: aload_0
    //   999: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1002: aload_0
    //   1003: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1006: aload_0
    //   1007: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1010: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1013: aload_0
    //   1014: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1017: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   1020: invokestatic 908	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1023: return
    //   1024: aload_0
    //   1025: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1028: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1031: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1034: aload_0
    //   1035: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1038: aload_0
    //   1039: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1042: aload_0
    //   1043: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1046: aload_0
    //   1047: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1050: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1053: invokestatic 911	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;)V
    //   1056: return
    //   1057: aload_0
    //   1058: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1061: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1064: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1067: aload_0
    //   1068: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1071: aload_0
    //   1072: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1075: aload_0
    //   1076: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1079: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   1082: aload_0
    //   1083: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1086: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1089: invokestatic 914	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1092: return
    //   1093: invokestatic 920	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1096: ldc_w 922
    //   1099: ldc_w 924
    //   1102: bipush 24
    //   1104: invokevirtual 928	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   1107: istore_2
    //   1108: ldc_w 929
    //   1111: invokestatic 526	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1114: iconst_1
    //   1115: anewarray 624	java/lang/Object
    //   1118: dup
    //   1119: iconst_0
    //   1120: iload_2
    //   1121: invokestatic 932	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1124: aastore
    //   1125: invokestatic 936	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1128: astore_1
    //   1129: invokestatic 941	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1132: iconst_0
    //   1133: aload_1
    //   1134: iconst_0
    //   1135: invokestatic 946	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1138: invokevirtual 949	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1141: pop
    //   1142: ldc_w 922
    //   1145: invokestatic 954	java/lang/System:currentTimeMillis	()J
    //   1148: ldc2_w 955
    //   1151: ldiv
    //   1152: iload_2
    //   1153: bipush 60
    //   1155: imul
    //   1156: bipush 60
    //   1158: imul
    //   1159: i2l
    //   1160: ladd
    //   1161: aload_0
    //   1162: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1165: getfield 960	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   1168: invokestatic 966	cooperation/qzone/LocalMultiProcConfig:putLong4Uin	(Ljava/lang/String;JJ)V
    //   1171: aload_0
    //   1172: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1175: aload 12
    //   1177: aload_0
    //   1178: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1181: checkcast 968	com/tencent/mobileqq/data/ChatMessage
    //   1184: invokestatic 973	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1187: bipush 40
    //   1189: iconst_3
    //   1190: iconst_3
    //   1191: invokestatic 979	cooperation/qzone/report/lp/LpReportInfo_pf00064:allReport	(III)V
    //   1194: return
    //   1195: aload_0
    //   1196: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1199: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1202: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   1205: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1208: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1211: checkcast 984	com/tencent/mobileqq/app/TroopManager
    //   1214: aload_0
    //   1215: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1218: invokevirtual 987	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1221: astore_1
    //   1222: new 989	java/util/ArrayList
    //   1225: dup
    //   1226: aload_0
    //   1227: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   1230: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   1233: ldc_w 991
    //   1236: invokevirtual 995	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1239: invokestatic 1001	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   1242: invokespecial 1004	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   1245: astore 13
    //   1247: bipush 40
    //   1249: iconst_3
    //   1250: iconst_2
    //   1251: invokestatic 979	cooperation/qzone/report/lp/LpReportInfo_pf00064:allReport	(III)V
    //   1254: aload_0
    //   1255: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1258: checkcast 1006	android/app/Activity
    //   1261: aload 12
    //   1263: invokevirtual 291	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1266: iconst_1
    //   1267: iconst_0
    //   1268: aload_0
    //   1269: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1272: invokestatic 1010	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1275: aload_1
    //   1276: getfield 1015	com/tencent/mobileqq/data/troop/TroopInfo:troopname	Ljava/lang/String;
    //   1279: ldc_w 1017
    //   1282: getstatic 1021	com/tencent/mobileqq/utils/AlbumConstants:d	Ljava/lang/String;
    //   1285: aload 13
    //   1287: iconst_m1
    //   1288: iconst_0
    //   1289: iconst_3
    //   1290: invokestatic 1027	cooperation/qzone/QZoneHelper:forwardToTroopUploadPhoto	(Landroid/app/Activity;Ljava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;III)V
    //   1293: return
    //   1294: aload_0
    //   1295: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1298: astore_1
    //   1299: aload_1
    //   1300: instanceof 137
    //   1303: ifeq +6466 -> 7769
    //   1306: aload_1
    //   1307: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   1310: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1313: astore_1
    //   1314: aload_1
    //   1315: ifnull +6454 -> 7769
    //   1318: aload_1
    //   1319: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1322: ifnull +6447 -> 7769
    //   1325: aload_1
    //   1326: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1329: instanceof 1029
    //   1332: ifeq +6437 -> 7769
    //   1335: aload_1
    //   1336: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1339: checkcast 1029	com/tencent/mobileqq/activity/aio/core/TroopChatPie
    //   1342: astore 13
    //   1344: aload 13
    //   1346: invokevirtual 1031	com/tencent/mobileqq/activity/aio/core/TroopChatPie:b	()Ljava/lang/String;
    //   1349: astore_1
    //   1350: aload 12
    //   1352: getstatic 1034	com/tencent/mobileqq/app/QQManagerFactory:TROOP_GAG_MANAGER	I
    //   1355: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1358: checkcast 1036	com/tencent/mobileqq/troop/utils/TroopGagMgr
    //   1361: aload_1
    //   1362: iconst_1
    //   1363: invokevirtual 1039	com/tencent/mobileqq/troop/utils/TroopGagMgr:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/troopgag/data/SelfGagInfo;
    //   1366: astore 14
    //   1368: aload_0
    //   1369: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1372: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1375: ifne +6394 -> 7769
    //   1378: aload_0
    //   1379: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1382: aload_1
    //   1383: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1386: ifeq +6383 -> 7769
    //   1389: aload_0
    //   1390: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1393: instanceof 968
    //   1396: ifeq +6373 -> 7769
    //   1399: aload 14
    //   1401: getfield 1044	com/tencent/mobileqq/troop/troopgag/data/SelfGagInfo:a	Z
    //   1404: ifne +6365 -> 7769
    //   1407: aload 13
    //   1409: bipush 41
    //   1411: invokevirtual 1045	com/tencent/mobileqq/activity/aio/core/TroopChatPie:a	(I)Lcom/tencent/mobileqq/activity/aio/helper/IHelper;
    //   1414: checkcast 1047	com/tencent/mobileqq/activity/aio/helper/SpecWordEmotionThinkHelper
    //   1417: iconst_1
    //   1418: invokevirtual 1049	com/tencent/mobileqq/activity/aio/helper/SpecWordEmotionThinkHelper:a	(I)V
    //   1421: aload 12
    //   1423: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1426: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1429: checkcast 984	com/tencent/mobileqq/app/TroopManager
    //   1432: invokevirtual 1052	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/app/TroopManager$ConfigableWordingSetter;
    //   1435: aload 12
    //   1437: aload_0
    //   1438: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1441: aload 13
    //   1443: getfield 1055	com/tencent/mobileqq/activity/aio/core/TroopChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   1446: aload_0
    //   1447: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   1450: iconst_0
    //   1451: aload_0
    //   1452: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1455: checkcast 968	com/tencent/mobileqq/data/ChatMessage
    //   1458: invokevirtual 1060	com/tencent/mobileqq/app/TroopManager$ConfigableWordingSetter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/EditText;Ljava/lang/String;ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   1461: iconst_3
    //   1462: putstatic 1064	com/tencent/mobileqq/activity/aio/item/TroopPobingItemBuilder:jdField_a_of_type_Int	I
    //   1465: aload_0
    //   1466: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1469: getfield 1067	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   1472: putstatic 1068	com/tencent/mobileqq/activity/aio/item/TroopPobingItemBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1475: new 1070	com/tencent/mobileqq/statistics/ReportTask
    //   1478: dup
    //   1479: aload 12
    //   1481: invokespecial 1073	com/tencent/mobileqq/statistics/ReportTask:<init>	(Lmqq/app/AppRuntime;)V
    //   1484: ldc_w 461
    //   1487: invokevirtual 1076	com/tencent/mobileqq/statistics/ReportTask:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1490: ldc_w 463
    //   1493: invokevirtual 1078	com/tencent/mobileqq/statistics/ReportTask:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1496: ldc_w 1080
    //   1499: invokevirtual 1082	com/tencent/mobileqq/statistics/ReportTask:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1502: ldc_w 1084
    //   1505: invokevirtual 1086	com/tencent/mobileqq/statistics/ReportTask:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1508: astore 13
    //   1510: new 82	java/lang/StringBuilder
    //   1513: dup
    //   1514: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1517: astore 14
    //   1519: aload 14
    //   1521: ldc 161
    //   1523: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: pop
    //   1527: aload 14
    //   1529: aload 12
    //   1531: aload_1
    //   1532: invokestatic 1089	com/tencent/mobileqq/troop/utils/TroopUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   1535: invokevirtual 794	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1538: pop
    //   1539: aload 13
    //   1541: iconst_3
    //   1542: anewarray 328	java/lang/String
    //   1545: dup
    //   1546: iconst_0
    //   1547: aload_1
    //   1548: aastore
    //   1549: dup
    //   1550: iconst_1
    //   1551: ldc 161
    //   1553: aastore
    //   1554: dup
    //   1555: iconst_2
    //   1556: aload 14
    //   1558: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: aastore
    //   1562: invokevirtual 1092	com/tencent/mobileqq/statistics/ReportTask:a	([Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   1565: invokevirtual 1094	com/tencent/mobileqq/statistics/ReportTask:a	()V
    //   1568: return
    //   1569: aload_0
    //   1570: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1573: instanceof 201
    //   1576: ifeq +6229 -> 7805
    //   1579: aload_0
    //   1580: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1583: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   1586: astore_1
    //   1587: aload_1
    //   1588: getfield 1095	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   1591: ifne +23 -> 1614
    //   1594: aload_1
    //   1595: getfield 1096	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1598: aload 12
    //   1600: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1603: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1606: ifeq +273 -> 1879
    //   1609: iconst_1
    //   1610: istore_2
    //   1611: goto +268 -> 1879
    //   1614: aload_1
    //   1615: getfield 1095	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   1618: iconst_1
    //   1619: if_icmpne +208 -> 1827
    //   1622: aload 12
    //   1624: aload_0
    //   1625: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1628: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1631: aload 12
    //   1633: invokevirtual 291	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1636: invokestatic 1099	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Z
    //   1639: istore 8
    //   1641: ldc_w 1101
    //   1644: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1647: checkcast 1101	com/tencent/mobileqq/troop/utils/api/ITroopUtilsApi
    //   1650: aload 12
    //   1652: aload_0
    //   1653: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1656: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1659: aload 12
    //   1661: invokevirtual 291	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1664: invokeinterface 1105 4 0
    //   1669: istore 9
    //   1671: aload_1
    //   1672: getfield 205	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   1675: getfield 495	com/tencent/mobileqq/graytip/UniteGrayTipParam:c	Ljava/lang/String;
    //   1678: astore 13
    //   1680: new 82	java/lang/StringBuilder
    //   1683: dup
    //   1684: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1687: astore 14
    //   1689: aload 14
    //   1691: ldc_w 1106
    //   1694: invokestatic 526	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1697: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: pop
    //   1701: aload 14
    //   1703: aload 12
    //   1705: invokevirtual 1109	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1708: ldc_w 1110
    //   1711: invokevirtual 1113	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1714: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: pop
    //   1718: aload 14
    //   1720: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1723: astore 14
    //   1725: iload 8
    //   1727: ifeq +38 -> 1765
    //   1730: aload 13
    //   1732: aload 14
    //   1734: invokevirtual 682	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1737: ifeq +8 -> 1745
    //   1740: iconst_3
    //   1741: istore_2
    //   1742: goto +137 -> 1879
    //   1745: aload_1
    //   1746: getfield 1096	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1749: aload 12
    //   1751: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1754: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1757: ifeq +6030 -> 7787
    //   1760: iconst_4
    //   1761: istore_2
    //   1762: goto +117 -> 1879
    //   1765: iload 9
    //   1767: ifeq +39 -> 1806
    //   1770: aload 13
    //   1772: aload 14
    //   1774: invokevirtual 682	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1777: ifeq +8 -> 1785
    //   1780: iconst_5
    //   1781: istore_2
    //   1782: goto +97 -> 1879
    //   1785: aload_1
    //   1786: getfield 1096	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1789: aload 12
    //   1791: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1794: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1797: ifeq +5990 -> 7787
    //   1800: bipush 6
    //   1802: istore_2
    //   1803: goto +76 -> 1879
    //   1806: aload_1
    //   1807: getfield 1096	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1810: aload 12
    //   1812: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1815: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1818: ifeq +5969 -> 7787
    //   1821: bipush 7
    //   1823: istore_2
    //   1824: goto +55 -> 1879
    //   1827: aload_1
    //   1828: getfield 1095	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   1831: sipush 3000
    //   1834: if_icmpne +24 -> 1858
    //   1837: aload_1
    //   1838: getfield 1096	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1841: aload 12
    //   1843: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1846: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1849: ifeq +5944 -> 7793
    //   1852: bipush 9
    //   1854: istore_2
    //   1855: goto +24 -> 1879
    //   1858: aload_1
    //   1859: getfield 1096	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:senderuin	Ljava/lang/String;
    //   1862: aload 12
    //   1864: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1867: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1870: ifeq +5929 -> 7799
    //   1873: bipush 11
    //   1875: istore_2
    //   1876: goto +3 -> 1879
    //   1879: aload_0
    //   1880: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   1883: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   1886: checkcast 336	mqq/app/AppRuntime
    //   1889: astore_1
    //   1890: new 82	java/lang/StringBuilder
    //   1893: dup
    //   1894: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1897: astore 13
    //   1899: aload 13
    //   1901: iload_2
    //   1902: invokevirtual 794	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1905: pop
    //   1906: aload 13
    //   1908: ldc 161
    //   1910: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: pop
    //   1914: aload_1
    //   1915: ldc_w 272
    //   1918: ldc 161
    //   1920: ldc 161
    //   1922: ldc_w 1115
    //   1925: ldc_w 1115
    //   1928: iconst_0
    //   1929: iconst_0
    //   1930: aload 13
    //   1932: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1935: ldc 161
    //   1937: ldc 161
    //   1939: ldc 161
    //   1941: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1944: goto +20 -> 1964
    //   1947: astore_1
    //   1948: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1951: ifeq +13 -> 1964
    //   1954: ldc 91
    //   1956: iconst_1
    //   1957: ldc_w 1115
    //   1960: aload_1
    //   1961: invokestatic 1118	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1964: aload_0
    //   1965: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   1968: aload 12
    //   1970: aload_0
    //   1971: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1974: checkcast 968	com/tencent/mobileqq/data/ChatMessage
    //   1977: invokestatic 973	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1980: return
    //   1981: aload_0
    //   1982: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1985: astore_1
    //   1986: aload_1
    //   1987: ifnull +5782 -> 7769
    //   1990: aload_1
    //   1991: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1994: iconst_1
    //   1995: if_icmpne +19 -> 2014
    //   1998: aload 12
    //   2000: aload_0
    //   2001: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2004: iconst_1
    //   2005: aload_0
    //   2006: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2009: iconst_0
    //   2010: invokestatic 1121	com/tencent/mobileqq/listentogether/ListenTogetherUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;ILjava/lang/String;I)V
    //   2013: return
    //   2014: aload_0
    //   2015: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2018: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2021: ifne +5748 -> 7769
    //   2024: aload_0
    //   2025: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2028: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2031: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   2034: aload_0
    //   2035: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2038: iconst_2
    //   2039: aload_0
    //   2040: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2043: iconst_0
    //   2044: invokestatic 1121	com/tencent/mobileqq/listentogether/ListenTogetherUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;ILjava/lang/String;I)V
    //   2047: return
    //   2048: aload_0
    //   2049: aload_0
    //   2050: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2053: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2056: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   2059: invokespecial 1123	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:showDeleteDialog	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   2062: return
    //   2063: new 1125	com/tencent/mobileqq/profilecard/data/AllInOne
    //   2066: dup
    //   2067: aload_0
    //   2068: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2071: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2074: iconst_1
    //   2075: invokespecial 1128	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   2078: astore_1
    //   2079: aload_0
    //   2080: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2083: aload_1
    //   2084: invokestatic 1134	com/tencent/mobileqq/profilecard/utils/ProfileUtils:openProfileCard	(Landroid/content/Context;Lcom/tencent/mobileqq/profilecard/data/AllInOne;)V
    //   2087: return
    //   2088: aload_0
    //   2089: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2092: astore_1
    //   2093: aload_1
    //   2094: instanceof 137
    //   2097: ifeq +41 -> 2138
    //   2100: aload_1
    //   2101: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   2104: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   2107: astore_1
    //   2108: aload_1
    //   2109: ifnull +29 -> 2138
    //   2112: aload_1
    //   2113: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   2116: ifnull +22 -> 2138
    //   2119: aload_1
    //   2120: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   2123: astore_1
    //   2124: aload_1
    //   2125: instanceof 1136
    //   2128: ifeq +10 -> 2138
    //   2131: aload_1
    //   2132: checkcast 1136	com/tencent/mobileqq/activity/aio/core/FriendChatPie
    //   2135: invokevirtual 1139	com/tencent/mobileqq/activity/aio/core/FriendChatPie:ao	()V
    //   2138: aload_0
    //   2139: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2142: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2145: checkcast 336	mqq/app/AppRuntime
    //   2148: ldc_w 272
    //   2151: ldc 161
    //   2153: ldc 161
    //   2155: ldc_w 1141
    //   2158: ldc_w 1141
    //   2161: iconst_0
    //   2162: iconst_0
    //   2163: ldc 161
    //   2165: ldc 161
    //   2167: ldc 161
    //   2169: ldc 161
    //   2171: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2174: return
    //   2175: aload_0
    //   2176: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2179: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   2182: astore_1
    //   2183: aload_0
    //   2184: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2187: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2190: astore 12
    //   2192: aload_1
    //   2193: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2196: ifne +38 -> 2234
    //   2199: aload_1
    //   2200: ldc_w 1143
    //   2203: invokevirtual 401	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2206: ifeq +28 -> 2234
    //   2209: ldc_w 1145
    //   2212: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2215: checkcast 1145	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   2218: aload_0
    //   2219: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2222: aload_1
    //   2223: aload 12
    //   2225: invokeinterface 1149 4 0
    //   2230: pop
    //   2231: goto +43 -> 2274
    //   2234: ldc_w 1145
    //   2237: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2240: checkcast 1145	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   2243: aload_1
    //   2244: invokeinterface 1152 2 0
    //   2249: ifeq +25 -> 2274
    //   2252: ldc_w 1154
    //   2255: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2258: checkcast 1154	com/tencent/mobileqq/mini/api/IMiniAppService
    //   2261: aload_0
    //   2262: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2265: aload_1
    //   2266: iconst_0
    //   2267: aconst_null
    //   2268: invokeinterface 1158 5 0
    //   2273: pop
    //   2274: aconst_null
    //   2275: ldc_w 272
    //   2278: ldc 161
    //   2280: aload_0
    //   2281: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2284: ldc_w 1160
    //   2287: ldc_w 1160
    //   2290: iconst_0
    //   2291: iconst_0
    //   2292: ldc 161
    //   2294: ldc 161
    //   2296: ldc 161
    //   2298: ldc 161
    //   2300: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2303: return
    //   2304: aload 12
    //   2306: invokestatic 1165	com/tencent/mobileqq/settings/config/SettingsConfigHelper:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   2309: ifeq +23 -> 2332
    //   2312: new 586	android/content/Intent
    //   2315: dup
    //   2316: invokespecial 1166	android/content/Intent:<init>	()V
    //   2319: astore_1
    //   2320: aload_0
    //   2321: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2324: aload_1
    //   2325: ldc_w 1168
    //   2328: invokestatic 1173	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   2331: return
    //   2332: new 586	android/content/Intent
    //   2335: dup
    //   2336: aload_0
    //   2337: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2340: ldc_w 1175
    //   2343: invokespecial 728	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2346: astore_1
    //   2347: aload_0
    //   2348: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2351: aload_1
    //   2352: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2355: return
    //   2356: getstatic 1179	com/tencent/mobileqq/app/msgnotify/MsgNotifyPushDialog:d	Z
    //   2359: ifeq +16 -> 2375
    //   2362: aload_0
    //   2363: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2366: getstatic 1182	com/tencent/mobileqq/app/msgnotify/MsgNotifyPushDialog:a	Landroid/content/Intent;
    //   2369: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2372: goto +39 -> 2411
    //   2375: aload_0
    //   2376: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2379: ifnull +17 -> 2396
    //   2382: new 1184	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$3
    //   2385: dup
    //   2386: aload_0
    //   2387: invokespecial 1185	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$3:<init>	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;)V
    //   2390: invokestatic 1191	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   2393: goto +18 -> 2411
    //   2396: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2399: ifeq +12 -> 2411
    //   2402: ldc 91
    //   2404: iconst_2
    //   2405: ldc_w 1193
    //   2408: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2411: aload_0
    //   2412: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2415: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2418: invokestatic 334	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2421: istore_2
    //   2422: aconst_null
    //   2423: ldc_w 272
    //   2426: ldc 161
    //   2428: ldc 161
    //   2430: ldc_w 1195
    //   2433: ldc_w 1195
    //   2436: iload_2
    //   2437: iload_2
    //   2438: ldc 161
    //   2440: ldc 161
    //   2442: ldc 161
    //   2444: ldc 161
    //   2446: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2449: return
    //   2450: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2453: ifeq +5316 -> 7769
    //   2456: new 82	java/lang/StringBuilder
    //   2459: dup
    //   2460: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   2463: astore_1
    //   2464: aload_1
    //   2465: ldc_w 1197
    //   2468: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2471: pop
    //   2472: aload_1
    //   2473: aload_0
    //   2474: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2477: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2480: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: pop
    //   2484: ldc 91
    //   2486: iconst_2
    //   2487: aload_1
    //   2488: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2491: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2494: return
    //   2495: aload_0
    //   2496: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2499: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2502: iconst_2
    //   2503: invokestatic 1200	com/tencent/mobileqq/troop/utils/TroopInfoUIUtil:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   2506: astore_1
    //   2507: aload_1
    //   2508: ldc_w 1202
    //   2511: sipush 1000
    //   2514: invokevirtual 1205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2517: aload_0
    //   2518: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2521: aload_1
    //   2522: iconst_2
    //   2523: invokestatic 1208	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   2526: aconst_null
    //   2527: ldc_w 272
    //   2530: ldc 161
    //   2532: ldc 161
    //   2534: ldc_w 1210
    //   2537: ldc_w 1210
    //   2540: iconst_0
    //   2541: iconst_0
    //   2542: ldc 161
    //   2544: ldc 161
    //   2546: ldc 161
    //   2548: ldc 161
    //   2550: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2553: return
    //   2554: aload_0
    //   2555: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2558: ifnull +5211 -> 7769
    //   2561: new 586	android/content/Intent
    //   2564: dup
    //   2565: invokespecial 1166	android/content/Intent:<init>	()V
    //   2568: astore_1
    //   2569: aload_1
    //   2570: ldc_w 1212
    //   2573: aload_0
    //   2574: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2577: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2580: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2583: pop
    //   2584: aload 12
    //   2586: invokestatic 1165	com/tencent/mobileqq/settings/config/SettingsConfigHelper:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   2589: ifeq +17 -> 2606
    //   2592: aload_0
    //   2593: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2596: aload_1
    //   2597: ldc_w 1217
    //   2600: invokestatic 1173	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   2603: goto +14 -> 2617
    //   2606: aload_0
    //   2607: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2610: aload_1
    //   2611: ldc_w 1219
    //   2614: invokestatic 1173	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   2617: aload_0
    //   2618: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2621: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2624: invokestatic 334	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2627: istore_2
    //   2628: aload_0
    //   2629: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2632: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   2635: invokestatic 334	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2638: istore_3
    //   2639: goto +65 -> 2704
    //   2642: iconst_0
    //   2643: istore_2
    //   2644: new 82	java/lang/StringBuilder
    //   2647: dup
    //   2648: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   2651: astore_1
    //   2652: aload_1
    //   2653: ldc_w 1197
    //   2656: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: pop
    //   2660: aload_1
    //   2661: aload_0
    //   2662: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2665: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2668: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2671: pop
    //   2672: aload_1
    //   2673: ldc_w 1221
    //   2676: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2679: pop
    //   2680: aload_1
    //   2681: aload_0
    //   2682: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2685: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   2688: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2691: pop
    //   2692: ldc 91
    //   2694: iconst_1
    //   2695: aload_1
    //   2696: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2699: invokestatic 1223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2702: iconst_0
    //   2703: istore_3
    //   2704: aconst_null
    //   2705: ldc_w 272
    //   2708: ldc 161
    //   2710: ldc 161
    //   2712: ldc_w 1225
    //   2715: ldc_w 1225
    //   2718: iload_2
    //   2719: iload_2
    //   2720: ldc 161
    //   2722: ldc 161
    //   2724: ldc 161
    //   2726: ldc 161
    //   2728: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2731: aload 12
    //   2733: ldc_w 272
    //   2736: ldc 161
    //   2738: ldc 161
    //   2740: ldc_w 1227
    //   2743: ldc_w 1227
    //   2746: iload_3
    //   2747: iconst_0
    //   2748: ldc 161
    //   2750: ldc 161
    //   2752: ldc 161
    //   2754: ldc 161
    //   2756: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2759: return
    //   2760: aload_0
    //   2761: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2764: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2767: istore_2
    //   2768: iload_2
    //   2769: sipush 1044
    //   2772: if_icmpeq +10 -> 2782
    //   2775: iload_2
    //   2776: sipush 1045
    //   2779: if_icmpne +4990 -> 7769
    //   2782: ldc_w 1229
    //   2785: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2788: checkcast 1229	com/tencent/mobileqq/qqexpand/chat/ILimitChatUtils
    //   2791: aload_0
    //   2792: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2795: aload_0
    //   2796: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   2799: aload_0
    //   2800: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   2803: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   2806: invokeinterface 1232 4 0
    //   2811: return
    //   2812: aload_0
    //   2813: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   2816: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   2819: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   2822: astore 13
    //   2824: aload 13
    //   2826: ifnull +4943 -> 7769
    //   2829: aload 13
    //   2831: invokestatic 1235	com/tencent/mobileqq/confess/ConfessConfig:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   2834: ifeq +4935 -> 7769
    //   2837: aload_0
    //   2838: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2841: invokevirtual 1238	com/tencent/mobileqq/data/MessageRecord:isSelfConfessor	()Z
    //   2844: ifeq +21 -> 2865
    //   2847: aload 13
    //   2849: invokevirtual 1241	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2852: astore_1
    //   2853: aload_0
    //   2854: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2857: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2860: astore 12
    //   2862: goto +18 -> 2880
    //   2865: aload_0
    //   2866: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2869: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2872: astore_1
    //   2873: aload 13
    //   2875: invokevirtual 1241	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2878: astore 12
    //   2880: aload 13
    //   2882: aload_0
    //   2883: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2886: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2889: aload_0
    //   2890: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2893: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2896: aload_0
    //   2897: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2900: invokevirtual 1244	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   2903: invokestatic 1249	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   2906: iconst_0
    //   2907: invokestatic 1252	com/tencent/mobileqq/confess/ConfessConfig:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Z
    //   2910: pop
    //   2911: aload 13
    //   2913: getstatic 1255	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFESS_HANDLER	Ljava/lang/String;
    //   2916: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2919: checkcast 1257	com/tencent/mobileqq/confess/ConfessHandler
    //   2922: astore 14
    //   2924: aload 14
    //   2926: ifnull +51 -> 2977
    //   2929: aload 14
    //   2931: bipush 9
    //   2933: iconst_1
    //   2934: iconst_3
    //   2935: anewarray 624	java/lang/Object
    //   2938: dup
    //   2939: iconst_0
    //   2940: aload_0
    //   2941: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2944: getfield 43	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2947: aastore
    //   2948: dup
    //   2949: iconst_1
    //   2950: aload_0
    //   2951: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2954: invokevirtual 1244	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   2957: invokestatic 932	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2960: aastore
    //   2961: dup
    //   2962: iconst_2
    //   2963: aload_0
    //   2964: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2967: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2970: invokestatic 932	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2973: aastore
    //   2974: invokevirtual 1261	com/tencent/mobileqq/confess/ConfessHandler:notifyUI	(IZLjava/lang/Object;)V
    //   2977: aload 13
    //   2979: aload_0
    //   2980: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   2983: aload_1
    //   2984: aload 12
    //   2986: aload_0
    //   2987: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2990: invokevirtual 1244	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   2993: aload_0
    //   2994: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   2997: invokevirtual 1238	com/tencent/mobileqq/data/MessageRecord:isSelfConfessor	()Z
    //   3000: invokestatic 1264	com/tencent/mobileqq/confess/ConfessConfig:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IZ)V
    //   3003: new 82	java/lang/StringBuilder
    //   3006: dup
    //   3007: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3010: astore 14
    //   3012: aload 14
    //   3014: aload_0
    //   3015: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3018: invokevirtual 1244	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   3021: invokevirtual 794	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3024: pop
    //   3025: aload 14
    //   3027: ldc 161
    //   3029: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3032: pop
    //   3033: aload 13
    //   3035: ldc_w 272
    //   3038: ldc 161
    //   3040: ldc 161
    //   3042: ldc_w 1266
    //   3045: ldc_w 1266
    //   3048: iconst_0
    //   3049: iconst_0
    //   3050: aload 14
    //   3052: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3055: ldc 161
    //   3057: aload_1
    //   3058: aload 12
    //   3060: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3063: return
    //   3064: ldc_w 1145
    //   3067: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3070: checkcast 1145	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   3073: invokeinterface 1269 1 0
    //   3078: ifeq +4 -> 3082
    //   3081: return
    //   3082: aload_0
    //   3083: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3086: getfield 960	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   3089: invokestatic 1272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3092: astore_1
    //   3093: aload_0
    //   3094: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3097: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   3100: astore 12
    //   3102: aload_0
    //   3103: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3106: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   3109: ldc_w 1274
    //   3112: invokevirtual 995	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3115: astore 13
    //   3117: aload 13
    //   3119: iconst_0
    //   3120: aaload
    //   3121: astore 14
    //   3123: aload 13
    //   3125: iconst_1
    //   3126: aaload
    //   3127: invokestatic 1010	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   3130: lstore 10
    //   3132: aload_0
    //   3133: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3136: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3139: istore_2
    //   3140: ldc_w 1145
    //   3143: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3146: checkcast 1145	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   3149: aload 14
    //   3151: aload_1
    //   3152: aload 12
    //   3154: invokeinterface 1278 4 0
    //   3159: astore 12
    //   3161: new 82	java/lang/StringBuilder
    //   3164: dup
    //   3165: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3168: astore 13
    //   3170: aload 13
    //   3172: ldc 91
    //   3174: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: pop
    //   3178: aload 13
    //   3180: getstatic 1282	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   3183: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3186: pop
    //   3187: aload 13
    //   3189: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3192: astore 13
    //   3194: new 82	java/lang/StringBuilder
    //   3197: dup
    //   3198: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3201: astore 14
    //   3203: aload 14
    //   3205: ldc_w 1284
    //   3208: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3211: pop
    //   3212: aload 14
    //   3214: aload_1
    //   3215: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3218: pop
    //   3219: aload 14
    //   3221: ldc_w 1286
    //   3224: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3227: pop
    //   3228: aload 14
    //   3230: iload_2
    //   3231: invokevirtual 794	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3234: pop
    //   3235: aload 14
    //   3237: ldc_w 1288
    //   3240: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3243: pop
    //   3244: aload 14
    //   3246: lload 10
    //   3248: invokevirtual 1291	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3251: pop
    //   3252: aload 14
    //   3254: ldc_w 1293
    //   3257: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3260: pop
    //   3261: aload 14
    //   3263: aload 12
    //   3265: invokevirtual 1296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3268: pop
    //   3269: aload 13
    //   3271: iconst_1
    //   3272: aload 14
    //   3274: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3277: invokestatic 1298	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3280: aload 12
    //   3282: ifnull +4487 -> 7769
    //   3285: aload 12
    //   3287: getfield 1303	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:s	Ljava/lang/String;
    //   3290: getstatic 1306	com/tencent/mobileqq/teamwork/TeamWorkConstants:k	Ljava/lang/String;
    //   3293: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3296: ifeq +64 -> 3360
    //   3299: aload 12
    //   3301: getfield 1309	com/tencent/mobileqq/teamwork/DocsGrayTipsInfo:t	Ljava/lang/String;
    //   3304: astore_1
    //   3305: aload_1
    //   3306: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3309: ifne +4460 -> 7769
    //   3312: ldc_w 1145
    //   3315: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3318: checkcast 1145	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   3321: aload_0
    //   3322: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3325: aload_1
    //   3326: invokeinterface 1313 3 0
    //   3331: pop
    //   3332: aconst_null
    //   3333: ldc_w 272
    //   3336: ldc 161
    //   3338: ldc 161
    //   3340: ldc_w 1315
    //   3343: ldc_w 1315
    //   3346: iconst_0
    //   3347: iconst_0
    //   3348: ldc 161
    //   3350: ldc 161
    //   3352: ldc 161
    //   3354: ldc 161
    //   3356: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3359: return
    //   3360: aload_0
    //   3361: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3364: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3367: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   3370: getstatic 1318	com/tencent/mobileqq/app/BusinessHandlerFactory:TEAM_WORK_HANDLER	Ljava/lang/String;
    //   3373: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3376: checkcast 1320	com/tencent/mobileqq/teamwork/api/ITeamWorkHandler
    //   3379: astore_1
    //   3380: iload_2
    //   3381: iconst_1
    //   3382: if_icmpne +14 -> 3396
    //   3385: aload_1
    //   3386: aload 12
    //   3388: lload 10
    //   3390: invokeinterface 1324 4 0
    //   3395: return
    //   3396: aload_1
    //   3397: aload 12
    //   3399: lload 10
    //   3401: invokeinterface 1327 4 0
    //   3406: return
    //   3407: astore_1
    //   3408: new 82	java/lang/StringBuilder
    //   3411: dup
    //   3412: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3415: astore 12
    //   3417: aload 12
    //   3419: ldc 91
    //   3421: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: pop
    //   3425: aload 12
    //   3427: getstatic 1282	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   3430: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3433: pop
    //   3434: aload 12
    //   3436: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3439: astore 12
    //   3441: new 82	java/lang/StringBuilder
    //   3444: dup
    //   3445: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3448: astore 13
    //   3450: aload 13
    //   3452: ldc_w 1329
    //   3455: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: pop
    //   3459: aload 13
    //   3461: aload_1
    //   3462: invokevirtual 1330	java/lang/Exception:toString	()Ljava/lang/String;
    //   3465: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3468: pop
    //   3469: aload 12
    //   3471: iconst_1
    //   3472: aload 13
    //   3474: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3477: invokestatic 1223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3480: return
    //   3481: aload_0
    //   3482: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3485: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3488: ifnull +4281 -> 7769
    //   3491: aload_0
    //   3492: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3495: astore_1
    //   3496: aload_1
    //   3497: ifnull +4272 -> 7769
    //   3500: aload_1
    //   3501: instanceof 201
    //   3504: ifeq +4265 -> 7769
    //   3507: aload_0
    //   3508: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3511: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3514: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   3517: aload_0
    //   3518: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3521: sipush 2080
    //   3524: ldc_w 381
    //   3527: invokestatic 775	com/tencent/mobileqq/loverzone/LoverZoneUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;ILjava/lang/String;)V
    //   3530: return
    //   3531: aload_0
    //   3532: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   3535: astore 13
    //   3537: aload_0
    //   3538: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3541: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3544: istore_2
    //   3545: aload_0
    //   3546: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3549: invokevirtual 1244	com/tencent/mobileqq/data/MessageRecord:getConfessTopicId	()I
    //   3552: istore_3
    //   3553: new 1332	com/tencent/mobileqq/confess/ConfessInfo
    //   3556: dup
    //   3557: invokespecial 1333	com/tencent/mobileqq/confess/ConfessInfo:<init>	()V
    //   3560: astore 14
    //   3562: aload 14
    //   3564: aload_0
    //   3565: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3568: ldc_w 1335
    //   3571: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   3574: invokevirtual 1338	com/tencent/mobileqq/confess/ConfessInfo:parseFromJsonStr	(Ljava/lang/String;)V
    //   3577: aload_0
    //   3578: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3581: astore_1
    //   3582: aload_1
    //   3583: instanceof 137
    //   3586: ifeq +4183 -> 7769
    //   3589: aload_1
    //   3590: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3593: invokevirtual 1341	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   3596: ifne +4173 -> 7769
    //   3599: iload_2
    //   3600: invokestatic 1343	com/tencent/imcore/message/UinTypeUtil:a	(I)I
    //   3603: sipush 1032
    //   3606: if_icmpne +4163 -> 7769
    //   3609: aload_0
    //   3610: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3613: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3616: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3619: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   3622: astore_1
    //   3623: aload_1
    //   3624: ifnull +18 -> 3642
    //   3627: aload_1
    //   3628: instanceof 1345
    //   3631: ifeq +11 -> 3642
    //   3634: aload_1
    //   3635: checkcast 1345	com/tencent/mobileqq/activity/aio/rebuild/ConfessChatPie
    //   3638: astore_1
    //   3639: goto +5 -> 3644
    //   3642: aconst_null
    //   3643: astore_1
    //   3644: aload_1
    //   3645: ifnonnull +4 -> 3649
    //   3648: return
    //   3649: aload_0
    //   3650: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3653: iconst_0
    //   3654: getstatic 1348	com/tencent/mobileqq/confess/ConfessConfig:f	Ljava/lang/String;
    //   3657: getstatic 1351	com/tencent/mobileqq/confess/ConfessConfig:g	Ljava/lang/String;
    //   3660: ldc_w 527
    //   3663: ldc_w 1352
    //   3666: new 1354	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$1
    //   3669: dup
    //   3670: aload_0
    //   3671: aload 12
    //   3673: aload 13
    //   3675: iload_2
    //   3676: iload_3
    //   3677: aload 14
    //   3679: aload_1
    //   3680: invokespecial 1357	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$1:<init>	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IILcom/tencent/mobileqq/confess/ConfessInfo;Lcom/tencent/mobileqq/activity/aio/rebuild/ConfessChatPie;)V
    //   3683: new 1359	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$2
    //   3686: dup
    //   3687: aload_0
    //   3688: invokespecial 1360	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan$2:<init>	(Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan;)V
    //   3691: invokestatic 1363	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3694: astore_1
    //   3695: aload_0
    //   3696: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3699: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3702: invokevirtual 1341	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   3705: ifne +4064 -> 7769
    //   3708: aload_1
    //   3709: invokevirtual 546	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   3712: return
    //   3713: aload_0
    //   3714: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3717: ifnull +17 -> 3734
    //   3720: aload_0
    //   3721: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3724: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   3727: aload_0
    //   3728: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3731: invokestatic 1368	com/tencent/mobileqq/vas/VasH5PayUtil:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   3734: aload_0
    //   3735: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3738: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3741: ifnull +4028 -> 7769
    //   3744: aload_0
    //   3745: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3748: astore_1
    //   3749: aload_1
    //   3750: ifnull +4019 -> 7769
    //   3753: aload_1
    //   3754: instanceof 201
    //   3757: ifeq +4012 -> 7769
    //   3760: aload_1
    //   3761: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   3764: getfield 205	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   3767: astore_1
    //   3768: aload_1
    //   3769: ifnull +4000 -> 7769
    //   3772: aload_1
    //   3773: getfield 209	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   3776: ldc_w 288
    //   3779: if_icmpeq +4 -> 3783
    //   3782: return
    //   3783: aload_0
    //   3784: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   3787: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   3790: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   3793: invokevirtual 291	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   3796: ldc_w 293
    //   3799: ldc_w 295
    //   3802: ldc 161
    //   3804: iconst_1
    //   3805: iconst_0
    //   3806: iconst_0
    //   3807: ldc 161
    //   3809: ldc 161
    //   3811: ldc 145
    //   3813: invokestatic 300	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3816: return
    //   3817: aload_0
    //   3818: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3821: astore_1
    //   3822: aload_1
    //   3823: instanceof 116
    //   3826: ifne +10 -> 3836
    //   3829: aload_1
    //   3830: instanceof 1370
    //   3833: ifeq +3936 -> 7769
    //   3836: aload_0
    //   3837: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   3840: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   3843: astore_1
    //   3844: aload_1
    //   3845: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3848: ifnull +111 -> 3959
    //   3851: aload_1
    //   3852: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3855: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   3858: ifnull +101 -> 3959
    //   3861: aload_0
    //   3862: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3865: instanceof 968
    //   3868: ifeq +91 -> 3959
    //   3871: aload_1
    //   3872: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   3875: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   3878: aload_0
    //   3879: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3882: checkcast 968	com/tencent/mobileqq/data/ChatMessage
    //   3885: invokevirtual 1373	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   3888: aload 12
    //   3890: ldc_w 695
    //   3893: ldc_w 697
    //   3896: invokevirtual 701	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   3899: checkcast 695	com/tencent/mobileqq/troop/entereffect/api/ITroopEnterEffectService
    //   3902: aload_0
    //   3903: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3906: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   3909: invokeinterface 1376 2 0
    //   3914: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3917: ifeq +42 -> 3959
    //   3920: new 82	java/lang/StringBuilder
    //   3923: dup
    //   3924: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   3927: astore_1
    //   3928: aload_1
    //   3929: ldc_w 1378
    //   3932: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3935: pop
    //   3936: aload_1
    //   3937: aload_0
    //   3938: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   3941: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   3944: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3947: pop
    //   3948: ldc_w 1380
    //   3951: iconst_2
    //   3952: aload_1
    //   3953: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3956: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3959: aload_0
    //   3960: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   3963: astore_1
    //   3964: aload_1
    //   3965: ifnull +3804 -> 7769
    //   3968: aload_1
    //   3969: instanceof 201
    //   3972: ifeq +3797 -> 7769
    //   3975: aload_1
    //   3976: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   3979: getfield 205	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   3982: astore_1
    //   3983: aload_1
    //   3984: ifnull +3785 -> 7769
    //   3987: aload_1
    //   3988: getfield 209	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   3991: ldc_w 288
    //   3994: if_icmpeq +4 -> 3998
    //   3997: return
    //   3998: aload 12
    //   4000: invokevirtual 291	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4003: ldc_w 293
    //   4006: ldc_w 295
    //   4009: ldc 161
    //   4011: iconst_1
    //   4012: iconst_0
    //   4013: iconst_0
    //   4014: ldc 161
    //   4016: ldc 161
    //   4018: ldc_w 371
    //   4021: invokestatic 300	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4024: return
    //   4025: aload_0
    //   4026: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   4029: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   4032: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   4035: astore 12
    //   4037: aload_0
    //   4038: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4041: astore 13
    //   4043: aload 13
    //   4045: ifnull +3724 -> 7769
    //   4048: aload 12
    //   4050: ifnull +3719 -> 7769
    //   4053: aload_0
    //   4054: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4057: astore 14
    //   4059: new 82	java/lang/StringBuilder
    //   4062: dup
    //   4063: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   4066: astore 15
    //   4068: aload 15
    //   4070: ldc 161
    //   4072: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4075: pop
    //   4076: aload 15
    //   4078: aload_0
    //   4079: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4082: getfield 960	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   4085: invokevirtual 1291	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4088: pop
    //   4089: aload 12
    //   4091: aload 13
    //   4093: aload 14
    //   4095: aload 15
    //   4097: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4100: iconst_4
    //   4101: iconst_m1
    //   4102: invokestatic 1385	com/tencent/mobileqq/profile/TroopMemberCardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   4105: aload 12
    //   4107: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4110: astore 12
    //   4112: aload_0
    //   4113: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   4116: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   4119: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   4122: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   4125: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4128: checkcast 984	com/tencent/mobileqq/app/TroopManager
    //   4131: astore 13
    //   4133: aload 13
    //   4135: ifnull +39 -> 4174
    //   4138: aload 13
    //   4140: aload_0
    //   4141: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4144: invokevirtual 1387	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   4147: astore 13
    //   4149: aload 13
    //   4151: ifnull +23 -> 4174
    //   4154: aload 13
    //   4156: aload 12
    //   4158: invokevirtual 1390	com/tencent/mobileqq/data/troop/TroopInfo:isTroopOwner	(Ljava/lang/String;)Z
    //   4161: ifeq +6 -> 4167
    //   4164: goto +13 -> 4177
    //   4167: ldc_w 353
    //   4170: astore_1
    //   4171: goto +6 -> 4177
    //   4174: ldc 161
    //   4176: astore_1
    //   4177: ldc_w 1392
    //   4180: ldc_w 1394
    //   4183: ldc_w 1396
    //   4186: iconst_0
    //   4187: iconst_0
    //   4188: iconst_2
    //   4189: anewarray 328	java/lang/String
    //   4192: dup
    //   4193: iconst_0
    //   4194: aload_0
    //   4195: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4198: aastore
    //   4199: dup
    //   4200: iconst_1
    //   4201: aload_1
    //   4202: aastore
    //   4203: invokestatic 1401	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   4206: return
    //   4207: getstatic 1404	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:a	Z
    //   4210: ifeq +19 -> 4229
    //   4213: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4216: ifeq +12 -> 4228
    //   4219: ldc 91
    //   4221: iconst_2
    //   4222: ldc_w 1406
    //   4225: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4228: return
    //   4229: aload_0
    //   4230: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4233: instanceof 137
    //   4236: ifeq +3533 -> 7769
    //   4239: aload_0
    //   4240: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4243: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   4246: astore_1
    //   4247: aload_0
    //   4248: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   4251: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   4254: astore 13
    //   4256: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4259: ifeq +44 -> 4303
    //   4262: lconst_0
    //   4263: lstore 10
    //   4265: aload_1
    //   4266: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4269: ifne +10 -> 4279
    //   4272: aload_1
    //   4273: invokevirtual 1409	java/lang/String:length	()I
    //   4276: i2l
    //   4277: lstore 10
    //   4279: ldc 91
    //   4281: iconst_2
    //   4282: iconst_2
    //   4283: anewarray 624	java/lang/Object
    //   4286: dup
    //   4287: iconst_0
    //   4288: ldc_w 1411
    //   4291: aastore
    //   4292: dup
    //   4293: iconst_1
    //   4294: lload 10
    //   4296: invokestatic 424	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4299: aastore
    //   4300: invokestatic 1414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   4303: aload_0
    //   4304: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4307: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   4310: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   4313: astore 12
    //   4315: aload 12
    //   4317: ifnull +3452 -> 7769
    //   4320: aload 12
    //   4322: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   4325: ifnull +3444 -> 7769
    //   4328: aload_0
    //   4329: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4332: invokestatic 1419	com/tencent/mobileqq/graytip/UniteGrayTipUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   4335: aload 12
    //   4337: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   4340: astore 12
    //   4342: aload 12
    //   4344: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4347: ifnull +628 -> 4975
    //   4350: aload 12
    //   4352: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4355: invokevirtual 1426	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4358: ifnonnull +6 -> 4364
    //   4361: goto +614 -> 4975
    //   4364: aload 12
    //   4366: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4369: invokevirtual 1426	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4372: invokeinterface 1431 1 0
    //   4377: aload 13
    //   4379: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4382: ifne +479 -> 4861
    //   4385: new 1433	org/json/JSONArray
    //   4388: dup
    //   4389: aload 13
    //   4391: invokespecial 1435	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   4394: astore 13
    //   4396: aload 13
    //   4398: invokevirtual 1436	org/json/JSONArray:length	()I
    //   4401: ifne +3409 -> 7810
    //   4404: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4407: ifeq +12 -> 4419
    //   4410: ldc 91
    //   4412: iconst_2
    //   4413: ldc_w 1438
    //   4416: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4419: aload 12
    //   4421: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4424: aload_1
    //   4425: invokevirtual 1442	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   4428: goto +457 -> 4885
    //   4431: iload_2
    //   4432: aload 13
    //   4434: invokevirtual 1436	org/json/JSONArray:length	()I
    //   4437: if_icmpge +448 -> 4885
    //   4440: aload 13
    //   4442: iload_2
    //   4443: invokevirtual 1446	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   4446: astore 14
    //   4448: aload 14
    //   4450: getstatic 1449	com/tencent/mobileqq/service/message/MessageConstants:k	Ljava/lang/String;
    //   4453: invokevirtual 1452	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4456: astore 15
    //   4458: aload 14
    //   4460: getstatic 1455	com/tencent/mobileqq/service/message/MessageConstants:l	Ljava/lang/String;
    //   4463: invokevirtual 1458	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4466: istore 6
    //   4468: new 1433	org/json/JSONArray
    //   4471: dup
    //   4472: aload 15
    //   4474: invokespecial 1435	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   4477: astore 14
    //   4479: aload 14
    //   4481: invokevirtual 1436	org/json/JSONArray:length	()I
    //   4484: ifne +3331 -> 7815
    //   4487: aload 12
    //   4489: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4492: aload_1
    //   4493: invokevirtual 1442	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   4496: goto +389 -> 4885
    //   4499: iload_3
    //   4500: aload 14
    //   4502: invokevirtual 1436	org/json/JSONArray:length	()I
    //   4505: if_icmpge +315 -> 4820
    //   4508: aload 14
    //   4510: iload_3
    //   4511: invokevirtual 1446	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   4514: astore 15
    //   4516: aload 15
    //   4518: ldc_w 1460
    //   4521: invokevirtual 1458	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4524: istore 7
    //   4526: aload 15
    //   4528: ldc_w 1462
    //   4531: invokevirtual 1458	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4534: istore 4
    //   4536: aload 15
    //   4538: ldc_w 1464
    //   4541: invokevirtual 1458	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4544: pop
    //   4545: aload 15
    //   4547: ldc_w 1465
    //   4550: invokevirtual 1452	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4553: astore 15
    //   4555: aload_1
    //   4556: iload 7
    //   4558: iconst_1
    //   4559: iadd
    //   4560: iload 4
    //   4562: iload 7
    //   4564: iadd
    //   4565: invokevirtual 1469	java/lang/String:substring	(II)Ljava/lang/String;
    //   4568: astore 16
    //   4570: aload 12
    //   4572: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4575: invokevirtual 1472	com/tencent/widget/XEditTextEx:getSelectionEnd	()I
    //   4578: istore 5
    //   4580: iload 5
    //   4582: istore 4
    //   4584: iload 5
    //   4586: ifge +6 -> 4592
    //   4589: iconst_0
    //   4590: istore 4
    //   4592: aload_1
    //   4593: iload 4
    //   4595: iload 7
    //   4597: invokevirtual 1469	java/lang/String:substring	(II)Ljava/lang/String;
    //   4600: astore 17
    //   4602: aload 12
    //   4604: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4607: invokevirtual 1426	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4610: iload 4
    //   4612: aload 17
    //   4614: invokeinterface 1476 3 0
    //   4619: pop
    //   4620: aload_0
    //   4621: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   4624: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   4627: checkcast 336	mqq/app/AppRuntime
    //   4630: astore 17
    //   4632: aload_0
    //   4633: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4636: astore 18
    //   4638: aload_0
    //   4639: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   4642: astore 19
    //   4644: aload 12
    //   4646: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4649: astore 20
    //   4651: iload 6
    //   4653: iconst_1
    //   4654: if_icmpne +3166 -> 7820
    //   4657: iconst_1
    //   4658: istore 8
    //   4660: goto +3 -> 4663
    //   4663: aload 17
    //   4665: aload 18
    //   4667: aload 19
    //   4669: aload 15
    //   4671: aload 16
    //   4673: iconst_0
    //   4674: aload 20
    //   4676: iload 8
    //   4678: invokestatic 1481	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lmqq/app/AppRuntime;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/EditText;Z)Landroid/text/SpannableString;
    //   4681: astore 15
    //   4683: aload 15
    //   4685: ifnull +128 -> 4813
    //   4688: aload 15
    //   4690: invokevirtual 1484	android/text/SpannableString:length	()I
    //   4693: ifne +6 -> 4699
    //   4696: goto +117 -> 4813
    //   4699: aload 12
    //   4701: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4704: invokevirtual 1472	com/tencent/widget/XEditTextEx:getSelectionEnd	()I
    //   4707: istore 5
    //   4709: iload 5
    //   4711: istore 4
    //   4713: iload 5
    //   4715: ifge +6 -> 4721
    //   4718: iconst_0
    //   4719: istore 4
    //   4721: aload 12
    //   4723: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4726: invokevirtual 1426	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4729: iload 4
    //   4731: aload 15
    //   4733: invokeinterface 1476 3 0
    //   4738: pop
    //   4739: iload_3
    //   4740: aload 14
    //   4742: invokevirtual 1436	org/json/JSONArray:length	()I
    //   4745: iconst_1
    //   4746: isub
    //   4747: if_icmpne +66 -> 4813
    //   4750: aload 12
    //   4752: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4755: invokevirtual 1472	com/tencent/widget/XEditTextEx:getSelectionEnd	()I
    //   4758: istore 5
    //   4760: iload 5
    //   4762: istore 4
    //   4764: iload 5
    //   4766: ifge +6 -> 4772
    //   4769: iconst_0
    //   4770: istore 4
    //   4772: iload 4
    //   4774: aload_1
    //   4775: invokevirtual 1409	java/lang/String:length	()I
    //   4778: iconst_1
    //   4779: isub
    //   4780: if_icmpgt +33 -> 4813
    //   4783: aload_1
    //   4784: iload 4
    //   4786: aload_1
    //   4787: invokevirtual 1409	java/lang/String:length	()I
    //   4790: invokevirtual 1469	java/lang/String:substring	(II)Ljava/lang/String;
    //   4793: astore 15
    //   4795: aload 12
    //   4797: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4800: invokevirtual 1426	com/tencent/widget/XEditTextEx:getEditableText	()Landroid/text/Editable;
    //   4803: iload 4
    //   4805: aload 15
    //   4807: invokeinterface 1476 3 0
    //   4812: pop
    //   4813: iload_3
    //   4814: iconst_1
    //   4815: iadd
    //   4816: istore_3
    //   4817: goto -318 -> 4499
    //   4820: iload_2
    //   4821: iconst_1
    //   4822: iadd
    //   4823: istore_2
    //   4824: goto -393 -> 4431
    //   4827: astore 13
    //   4829: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4832: ifeq +17 -> 4849
    //   4835: ldc 91
    //   4837: iconst_2
    //   4838: ldc_w 1486
    //   4841: aload 13
    //   4843: invokestatic 677	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4846: goto +3 -> 4849
    //   4849: aload 12
    //   4851: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4854: aload_1
    //   4855: invokevirtual 1442	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   4858: goto +27 -> 4885
    //   4861: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4864: ifeq +12 -> 4876
    //   4867: ldc 91
    //   4869: iconst_2
    //   4870: ldc_w 1488
    //   4873: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4876: aload 12
    //   4878: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4881: aload_1
    //   4882: invokevirtual 1442	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   4885: aload 12
    //   4887: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4890: invokevirtual 1491	com/tencent/widget/XEditTextEx:getText	()Landroid/text/Editable;
    //   4893: invokeinterface 1492 1 0
    //   4898: istore_3
    //   4899: iload_3
    //   4900: istore_2
    //   4901: iload_3
    //   4902: ifge +5 -> 4907
    //   4905: iconst_0
    //   4906: istore_2
    //   4907: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4910: ifeq +35 -> 4945
    //   4913: new 82	java/lang/StringBuilder
    //   4916: dup
    //   4917: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   4920: astore_1
    //   4921: aload_1
    //   4922: ldc_w 1494
    //   4925: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4928: pop
    //   4929: aload_1
    //   4930: iload_2
    //   4931: invokevirtual 794	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4934: pop
    //   4935: ldc 91
    //   4937: iconst_2
    //   4938: aload_1
    //   4939: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4942: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4945: aload 12
    //   4947: bipush 111
    //   4949: invokevirtual 763	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	(I)Lcom/tencent/mobileqq/activity/aio/helper/IHelper;
    //   4952: checkcast 1496	com/tencent/mobileqq/activity/aio/helper/AIODraftHelper
    //   4955: ldc 161
    //   4957: putfield 1497	com/tencent/mobileqq/activity/aio/helper/AIODraftHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4960: aload 12
    //   4962: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   4965: iload_2
    //   4966: invokevirtual 1500	com/tencent/widget/XEditTextEx:setSelection	(I)V
    //   4969: aload 12
    //   4971: invokevirtual 1503	com/tencent/mobileqq/activity/aio/core/BaseChatPie:Y	()V
    //   4974: return
    //   4975: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4978: ifeq +2791 -> 7769
    //   4981: ldc 91
    //   4983: iconst_2
    //   4984: ldc_w 1505
    //   4987: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4990: return
    //   4991: aload_0
    //   4992: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   4995: astore_1
    //   4996: aload_1
    //   4997: instanceof 137
    //   5000: ifeq +2769 -> 7769
    //   5003: aload_1
    //   5004: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   5007: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   5010: astore_1
    //   5011: aload_1
    //   5012: ifnull +2757 -> 7769
    //   5015: aload_1
    //   5016: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5019: ifnull +2750 -> 7769
    //   5022: aload_1
    //   5023: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5026: astore_1
    //   5027: aload_1
    //   5028: instanceof 1507
    //   5031: ifeq +2738 -> 7769
    //   5034: aload_1
    //   5035: checkcast 1507	com/tencent/mobileqq/activity/aio/rebuild/BusinessCmrTmpChatPie
    //   5038: aload_0
    //   5039: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5042: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5045: invokevirtual 1509	com/tencent/mobileqq/activity/aio/rebuild/BusinessCmrTmpChatPie:d	(Ljava/lang/String;)V
    //   5048: return
    //   5049: aload_0
    //   5050: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5053: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5056: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   5059: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   5062: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5065: checkcast 984	com/tencent/mobileqq/app/TroopManager
    //   5068: aload_0
    //   5069: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5072: invokevirtual 987	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   5075: astore_1
    //   5076: aload_1
    //   5077: ifnull +2692 -> 7769
    //   5080: new 586	android/content/Intent
    //   5083: dup
    //   5084: invokespecial 1166	android/content/Intent:<init>	()V
    //   5087: astore 12
    //   5089: aload 12
    //   5091: ldc_w 1511
    //   5094: iconst_1
    //   5095: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5098: pop
    //   5099: aload 12
    //   5101: ldc_w 1513
    //   5104: iconst_2
    //   5105: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5108: pop
    //   5109: aload 12
    //   5111: ldc_w 1515
    //   5114: ldc_w 1516
    //   5117: invokestatic 526	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5120: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5123: pop
    //   5124: aload_1
    //   5125: getfield 1519	com/tencent/mobileqq/data/troop/TroopInfo:hasSetNewTroopName	Z
    //   5128: ifeq +16 -> 5144
    //   5131: aload 12
    //   5133: ldc_w 1521
    //   5136: aload_1
    //   5137: getfield 1015	com/tencent/mobileqq/data/troop/TroopInfo:troopname	Ljava/lang/String;
    //   5140: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5143: pop
    //   5144: aload 12
    //   5146: ldc_w 1523
    //   5149: bipush 96
    //   5151: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5154: pop
    //   5155: aload 12
    //   5157: ldc_w 1525
    //   5160: iconst_0
    //   5161: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   5164: pop
    //   5165: aload_0
    //   5166: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5169: aload 12
    //   5171: ldc_w 1527
    //   5174: sipush 13010
    //   5177: invokestatic 1532	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;I)V
    //   5180: return
    //   5181: aload_0
    //   5182: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5185: astore_1
    //   5186: aload_1
    //   5187: ifnull +2582 -> 7769
    //   5190: aload_1
    //   5191: instanceof 201
    //   5194: ifeq +2575 -> 7769
    //   5197: aload_1
    //   5198: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   5201: getfield 205	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   5204: astore_1
    //   5205: aload_1
    //   5206: getfield 1533	com/tencent/mobileqq/graytip/UniteGrayTipParam:d	Ljava/lang/String;
    //   5209: iconst_0
    //   5210: invokestatic 1538	com/tencent/mobileqq/troopAddFrd/Scene:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   5213: invokestatic 1540	com/tencent/mobileqq/troopAddFrd/Scene:a	(Ljava/lang/String;)I
    //   5216: istore_2
    //   5217: aload_1
    //   5218: getfield 1533	com/tencent/mobileqq/graytip/UniteGrayTipParam:d	Ljava/lang/String;
    //   5221: iconst_1
    //   5222: invokestatic 1538	com/tencent/mobileqq/troopAddFrd/Scene:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   5225: astore_1
    //   5226: aload_0
    //   5227: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5230: aload_0
    //   5231: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5234: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5237: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   5240: aload_0
    //   5241: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5244: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5247: aload_0
    //   5248: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5251: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   5254: iload_2
    //   5255: aload_1
    //   5256: invokestatic 1545	com/tencent/mobileqq/relationx/batchAdd/BatchAddFriendData:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   5259: return
    //   5260: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5263: ifeq +13 -> 5276
    //   5266: ldc_w 1547
    //   5269: iconst_2
    //   5270: ldc_w 1549
    //   5273: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5276: new 586	android/content/Intent
    //   5279: dup
    //   5280: aload_0
    //   5281: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5284: ldc_w 1551
    //   5287: invokespecial 728	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5290: astore_1
    //   5291: aload_1
    //   5292: ldc_w 1553
    //   5295: aload_0
    //   5296: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5299: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5302: pop
    //   5303: aload_1
    //   5304: ldc_w 1555
    //   5307: iconst_1
    //   5308: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5311: pop
    //   5312: aload_0
    //   5313: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5316: astore 12
    //   5318: aload 12
    //   5320: instanceof 137
    //   5323: ifeq +9 -> 5332
    //   5326: aload 12
    //   5328: aload_1
    //   5329: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5332: aload_0
    //   5333: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5336: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5339: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   5342: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5345: ldc_w 1557
    //   5348: ldc_w 1559
    //   5351: ldc 161
    //   5353: iconst_1
    //   5354: iconst_0
    //   5355: iconst_0
    //   5356: aconst_null
    //   5357: aload_0
    //   5358: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5361: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5364: aconst_null
    //   5365: invokestatic 300	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5368: return
    //   5369: aload_0
    //   5370: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5373: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5376: astore 12
    //   5378: aload 12
    //   5380: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5383: ifne +2386 -> 7769
    //   5386: aload 12
    //   5388: invokestatic 1010	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5391: lstore 10
    //   5393: aload_0
    //   5394: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5397: instanceof 137
    //   5400: ifeq +2369 -> 7769
    //   5403: aload_0
    //   5404: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5407: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   5410: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   5413: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5416: astore 12
    //   5418: aload 12
    //   5420: invokevirtual 1561	com/tencent/mobileqq/activity/aio/core/BaseChatPie:e	()Z
    //   5423: ifeq +2346 -> 7769
    //   5426: aload 12
    //   5428: invokevirtual 1564	com/tencent/mobileqq/activity/aio/core/BaseChatPie:b	()Lcom/tencent/mobileqq/activity/aio/core/AIOContext;
    //   5431: invokevirtual 1569	com/tencent/mobileqq/activity/aio/core/AIOContext:a	()Lcom/tencent/mobileqq/activity/aio/core/msglist/MsgList;
    //   5434: invokevirtual 1574	com/tencent/mobileqq/activity/aio/core/msglist/MsgList:a	()Lcom/tencent/mobileqq/activity/aio/coreui/msglist/Scroller;
    //   5437: bipush 10
    //   5439: lload 10
    //   5441: iconst_0
    //   5442: invokevirtual 1579	com/tencent/mobileqq/activity/aio/coreui/msglist/Scroller:a	(IJI)V
    //   5445: invokestatic 1584	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   5448: iconst_0
    //   5449: putfield 1585	com/tencent/mobileqq/emoticon/EmojiStickerManager:b	I
    //   5452: aload_0
    //   5453: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5456: ifnull +2313 -> 7769
    //   5459: aload_0
    //   5460: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5463: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   5466: iconst_1
    //   5467: if_icmpne +10 -> 5477
    //   5470: ldc_w 353
    //   5473: astore_1
    //   5474: goto +2352 -> 7826
    //   5477: aload_0
    //   5478: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5481: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   5484: sipush 3000
    //   5487: if_icmpne +2339 -> 7826
    //   5490: ldc_w 371
    //   5493: astore_1
    //   5494: goto +2332 -> 7826
    //   5497: ldc 161
    //   5499: ldc_w 1587
    //   5502: ldc_w 1589
    //   5505: aload_1
    //   5506: iconst_1
    //   5507: iconst_0
    //   5508: iconst_0
    //   5509: aconst_null
    //   5510: ldc 161
    //   5512: ldc 161
    //   5514: invokestatic 300	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5517: return
    //   5518: astore_1
    //   5519: goto +20 -> 5539
    //   5522: astore_1
    //   5523: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5526: ifeq +2243 -> 7769
    //   5529: ldc 91
    //   5531: iconst_2
    //   5532: ldc 161
    //   5534: aload_1
    //   5535: invokestatic 1591	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5538: return
    //   5539: aload_1
    //   5540: athrow
    //   5541: aload_0
    //   5542: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5545: ifnull +2224 -> 7769
    //   5548: new 586	android/content/Intent
    //   5551: dup
    //   5552: invokespecial 1166	android/content/Intent:<init>	()V
    //   5555: astore_1
    //   5556: aload_0
    //   5557: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5560: getfield 960	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   5563: invokestatic 1272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5566: astore 12
    //   5568: aload_0
    //   5569: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5572: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5575: checkcast 1593	com/tencent/common/app/AppInterface
    //   5578: aload_0
    //   5579: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5582: aload 12
    //   5584: invokestatic 1598	com/tencent/mobileqq/utils/ContactUtils:c	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5587: astore 13
    //   5589: aload_1
    //   5590: ldc_w 1511
    //   5593: iconst_5
    //   5594: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5597: pop
    //   5598: aload_1
    //   5599: ldc_w 1513
    //   5602: iconst_0
    //   5603: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5606: pop
    //   5607: aload_1
    //   5608: ldc_w 1600
    //   5611: aload_0
    //   5612: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5615: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5618: pop
    //   5619: aload_1
    //   5620: ldc_w 1465
    //   5623: aload 12
    //   5625: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5628: pop
    //   5629: aload_1
    //   5630: ldc_w 1515
    //   5633: aload_0
    //   5634: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5637: invokevirtual 1604	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   5640: ldc_w 1605
    //   5643: invokevirtual 1608	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   5646: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5649: pop
    //   5650: aload_1
    //   5651: ldc_w 1521
    //   5654: aload 13
    //   5656: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5659: pop
    //   5660: aload_1
    //   5661: ldc_w 1523
    //   5664: bipush 60
    //   5666: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5669: pop
    //   5670: aload_1
    //   5671: ldc_w 1610
    //   5674: ldc_w 1611
    //   5677: invokestatic 526	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5680: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5683: pop
    //   5684: aload_1
    //   5685: ldc_w 1613
    //   5688: iconst_1
    //   5689: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   5692: pop
    //   5693: aload_0
    //   5694: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5697: aload_1
    //   5698: ldc_w 1527
    //   5701: invokestatic 1616	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V
    //   5704: return
    //   5705: aload_0
    //   5706: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5709: aload_0
    //   5710: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5713: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5716: ldc_w 1618
    //   5719: sipush 1005
    //   5722: invokestatic 1623	com/tencent/biz/qqstory/playvideo/StoryPlayerLauncher:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   5725: ldc_w 1625
    //   5728: ldc_w 1627
    //   5731: iconst_0
    //   5732: iconst_0
    //   5733: iconst_4
    //   5734: anewarray 328	java/lang/String
    //   5737: dup
    //   5738: iconst_0
    //   5739: ldc 161
    //   5741: aastore
    //   5742: dup
    //   5743: iconst_1
    //   5744: ldc 161
    //   5746: aastore
    //   5747: dup
    //   5748: iconst_2
    //   5749: ldc 161
    //   5751: aastore
    //   5752: dup
    //   5753: iconst_3
    //   5754: ldc 161
    //   5756: aastore
    //   5757: invokestatic 1632	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   5760: return
    //   5761: aconst_null
    //   5762: astore_1
    //   5763: new 586	android/content/Intent
    //   5766: dup
    //   5767: aload_0
    //   5768: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5771: ldc_w 1634
    //   5774: invokespecial 728	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5777: astore 12
    //   5779: aload_0
    //   5780: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5783: astore 13
    //   5785: aload 13
    //   5787: ifnull +12 -> 5799
    //   5790: aload 13
    //   5792: ldc_w 1636
    //   5795: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   5798: astore_1
    //   5799: aload_1
    //   5800: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5803: ifne +51 -> 5854
    //   5806: aload 12
    //   5808: ldc_w 1636
    //   5811: aload_1
    //   5812: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5815: pop
    //   5816: aload_0
    //   5817: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5820: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   5823: checkcast 336	mqq/app/AppRuntime
    //   5826: ldc 212
    //   5828: ldc_w 1638
    //   5831: ldc 161
    //   5833: ldc_w 1640
    //   5836: ldc_w 1642
    //   5839: iconst_0
    //   5840: iconst_0
    //   5841: aload_0
    //   5842: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   5845: ldc 161
    //   5847: ldc 161
    //   5849: ldc 161
    //   5851: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5854: aload_0
    //   5855: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5858: aload 12
    //   5860: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5863: return
    //   5864: aload_0
    //   5865: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5868: astore_1
    //   5869: aload_1
    //   5870: ifnull +38 -> 5908
    //   5873: aload_1
    //   5874: getfield 254	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   5877: ifnull +31 -> 5908
    //   5880: aload_0
    //   5881: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   5884: getfield 254	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   5887: aload_0
    //   5888: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5891: getfield 1645	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:start	I
    //   5894: aload_0
    //   5895: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5898: getfield 1648	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:end	I
    //   5901: invokevirtual 1469	java/lang/String:substring	(II)Ljava/lang/String;
    //   5904: astore_1
    //   5905: goto +6 -> 5911
    //   5908: ldc 161
    //   5910: astore_1
    //   5911: aload_0
    //   5912: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5915: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   5918: astore 12
    //   5920: aload_0
    //   5921: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   5924: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   5927: astore 13
    //   5929: aload 12
    //   5931: ifnull +1838 -> 7769
    //   5934: aload 13
    //   5936: ifnull +1833 -> 7769
    //   5939: aload_0
    //   5940: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   5943: astore 14
    //   5945: aload 14
    //   5947: instanceof 137
    //   5950: ifeq +1819 -> 7769
    //   5953: aload 14
    //   5955: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   5958: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   5961: astore 14
    //   5963: aload 14
    //   5965: ifnull +1804 -> 7769
    //   5968: aload 14
    //   5970: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5973: ifnull +1796 -> 7769
    //   5976: aload 14
    //   5978: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   5981: astore 14
    //   5983: aload 14
    //   5985: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   5988: ldc 161
    //   5990: invokevirtual 1442	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   5993: aload_0
    //   5994: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   5997: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6000: checkcast 336	mqq/app/AppRuntime
    //   6003: aload_0
    //   6004: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6007: aload_0
    //   6008: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6011: aload 12
    //   6013: aload 13
    //   6015: iconst_0
    //   6016: aload 14
    //   6018: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6021: iconst_1
    //   6022: invokestatic 1481	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lmqq/app/AppRuntime;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/EditText;Z)Landroid/text/SpannableString;
    //   6025: astore 12
    //   6027: aload 14
    //   6029: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6032: aload 12
    //   6034: invokevirtual 1442	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   6037: aload 14
    //   6039: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6042: aload_1
    //   6043: invokevirtual 1650	com/tencent/widget/XEditTextEx:append	(Ljava/lang/CharSequence;)V
    //   6046: aload 14
    //   6048: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6051: aload 14
    //   6053: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6056: invokevirtual 1491	com/tencent/widget/XEditTextEx:getText	()Landroid/text/Editable;
    //   6059: invokeinterface 1492 1 0
    //   6064: invokevirtual 1500	com/tencent/widget/XEditTextEx:setSelection	(I)V
    //   6067: return
    //   6068: new 798	org/json/JSONObject
    //   6071: dup
    //   6072: aload_0
    //   6073: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6076: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6079: invokespecial 1651	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6082: astore 13
    //   6084: aload 13
    //   6086: ldc_w 1465
    //   6089: invokevirtual 1452	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6092: astore_1
    //   6093: aload 13
    //   6095: ldc_w 1653
    //   6098: invokevirtual 1452	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6101: astore 12
    //   6103: aload 13
    //   6105: ldc_w 1655
    //   6108: invokevirtual 1452	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6111: astore 13
    //   6113: aload_1
    //   6114: ifnull +1655 -> 7769
    //   6117: aload 12
    //   6119: ifnull +1650 -> 7769
    //   6122: aload_0
    //   6123: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6126: instanceof 137
    //   6129: ifeq +1640 -> 7769
    //   6132: aload_0
    //   6133: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6136: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   6139: invokevirtual 753	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   6142: astore 14
    //   6144: aload 14
    //   6146: ifnull +1623 -> 7769
    //   6149: aload 14
    //   6151: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   6154: ifnull +1615 -> 7769
    //   6157: aload 14
    //   6159: invokevirtual 758	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   6162: astore 14
    //   6164: aload 13
    //   6166: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6169: ifne +1660 -> 7829
    //   6172: iconst_1
    //   6173: istore 8
    //   6175: goto +3 -> 6178
    //   6178: aload_0
    //   6179: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6182: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6185: checkcast 336	mqq/app/AppRuntime
    //   6188: aload_0
    //   6189: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6192: aload_0
    //   6193: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6196: aload_1
    //   6197: aload 12
    //   6199: iconst_0
    //   6200: aload 14
    //   6202: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6205: iconst_1
    //   6206: iload 8
    //   6208: invokestatic 1658	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lmqq/app/AppRuntime;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/EditText;ZZ)Landroid/text/SpannableString;
    //   6211: astore_1
    //   6212: aload 14
    //   6214: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6217: aload_1
    //   6218: invokevirtual 1442	com/tencent/widget/XEditTextEx:setText	(Ljava/lang/CharSequence;)V
    //   6221: aload 14
    //   6223: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6226: aload 13
    //   6228: invokevirtual 1650	com/tencent/widget/XEditTextEx:append	(Ljava/lang/CharSequence;)V
    //   6231: aload 14
    //   6233: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6236: aload 14
    //   6238: getfield 1420	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/widget/XEditTextEx;
    //   6241: invokevirtual 1491	com/tencent/widget/XEditTextEx:getText	()Landroid/text/Editable;
    //   6244: invokeinterface 1492 1 0
    //   6249: invokevirtual 1500	com/tencent/widget/XEditTextEx:setSelection	(I)V
    //   6252: return
    //   6253: astore_1
    //   6254: aload_1
    //   6255: invokevirtual 1661	org/json/JSONException:printStackTrace	()V
    //   6258: return
    //   6259: new 586	android/content/Intent
    //   6262: dup
    //   6263: aload_0
    //   6264: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6267: ldc_w 1663
    //   6270: invokespecial 728	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6273: astore_1
    //   6274: aload_0
    //   6275: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6278: getfield 1666	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:groupId	I
    //   6281: istore_3
    //   6282: iload_3
    //   6283: iconst_m1
    //   6284: if_icmpeq +27 -> 6311
    //   6287: iload_3
    //   6288: istore_2
    //   6289: iload_3
    //   6290: ifne +65 -> 6355
    //   6293: iload_3
    //   6294: istore_2
    //   6295: ldc_w 1668
    //   6298: aload_0
    //   6299: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6302: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6305: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6308: ifeq +47 -> 6355
    //   6311: aload_0
    //   6312: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6315: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6318: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   6321: getstatic 62	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   6324: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6327: checkcast 70	com/tencent/mobileqq/app/FriendsManager
    //   6330: aload_0
    //   6331: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6334: invokevirtual 1671	com/tencent/mobileqq/app/FriendsManager:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   6337: astore 12
    //   6339: aload 12
    //   6341: ifnull +12 -> 6353
    //   6344: aload 12
    //   6346: getfield 1676	com/tencent/mobileqq/data/Friends:groupid	I
    //   6349: istore_2
    //   6350: goto +5 -> 6355
    //   6353: iconst_0
    //   6354: istore_2
    //   6355: aload_1
    //   6356: ldc_w 1678
    //   6359: aload_0
    //   6360: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6363: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6366: ldc_w 1680
    //   6369: iload_2
    //   6370: i2b
    //   6371: invokevirtual 1683	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   6374: pop
    //   6375: aload_0
    //   6376: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6379: astore 12
    //   6381: aload 12
    //   6383: instanceof 137
    //   6386: ifeq +18 -> 6404
    //   6389: aload 12
    //   6391: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   6394: aload_1
    //   6395: sipush 13009
    //   6398: invokevirtual 1687	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   6401: goto +9 -> 6410
    //   6404: aload 12
    //   6406: aload_1
    //   6407: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6410: aload_0
    //   6411: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6414: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6417: checkcast 336	mqq/app/AppRuntime
    //   6420: ldc_w 272
    //   6423: ldc 161
    //   6425: ldc 161
    //   6427: ldc_w 1689
    //   6430: ldc_w 1689
    //   6433: iconst_0
    //   6434: iconst_0
    //   6435: ldc 161
    //   6437: ldc 161
    //   6439: ldc 161
    //   6441: ldc 161
    //   6443: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6446: ldc_w 1668
    //   6449: aload_0
    //   6450: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6453: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6456: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6459: ifeq +1310 -> 7769
    //   6462: invokestatic 1692	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6465: ifeq +42 -> 6507
    //   6468: ldc 91
    //   6470: iconst_4
    //   6471: invokestatic 1698	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   6474: ldc_w 1700
    //   6477: iconst_2
    //   6478: anewarray 624	java/lang/Object
    //   6481: dup
    //   6482: iconst_0
    //   6483: iload_2
    //   6484: invokestatic 932	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6487: aastore
    //   6488: dup
    //   6489: iconst_1
    //   6490: aload_0
    //   6491: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6494: getfield 1666	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:groupId	I
    //   6497: invokestatic 932	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6500: aastore
    //   6501: invokestatic 1703	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6504: invokestatic 1298	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6507: aload_0
    //   6508: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6511: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6514: checkcast 336	mqq/app/AppRuntime
    //   6517: ldc_w 461
    //   6520: ldc_w 1705
    //   6523: ldc 161
    //   6525: ldc_w 1707
    //   6528: ldc_w 1709
    //   6531: iconst_0
    //   6532: iconst_0
    //   6533: ldc 161
    //   6535: ldc 161
    //   6537: ldc 161
    //   6539: ldc 161
    //   6541: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6544: return
    //   6545: new 586	android/content/Intent
    //   6548: dup
    //   6549: aload_0
    //   6550: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6553: ldc_w 1711
    //   6556: invokespecial 728	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6559: astore_1
    //   6560: aload_1
    //   6561: ldc_w 1515
    //   6564: ldc_w 1712
    //   6567: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6570: ldc_w 1714
    //   6573: aload_0
    //   6574: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6577: getfield 1717	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:remark	Ljava/lang/String;
    //   6580: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6583: ldc_w 813
    //   6586: bipush 103
    //   6588: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6591: ldc_w 1719
    //   6594: bipush 96
    //   6596: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6599: ldc_w 1525
    //   6602: iconst_1
    //   6603: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6606: ldc_w 1721
    //   6609: iconst_0
    //   6610: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6613: pop
    //   6614: aload_0
    //   6615: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6618: astore 12
    //   6620: aload 12
    //   6622: instanceof 137
    //   6625: ifeq +18 -> 6643
    //   6628: aload 12
    //   6630: checkcast 137	com/tencent/mobileqq/app/BaseActivity
    //   6633: aload_1
    //   6634: sipush 13008
    //   6637: invokevirtual 1687	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   6640: goto +9 -> 6649
    //   6643: aload 12
    //   6645: aload_1
    //   6646: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6649: aload_0
    //   6650: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6653: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6656: checkcast 336	mqq/app/AppRuntime
    //   6659: ldc_w 272
    //   6662: ldc 161
    //   6664: ldc 161
    //   6666: ldc_w 1723
    //   6669: ldc_w 1723
    //   6672: iconst_0
    //   6673: iconst_0
    //   6674: ldc 161
    //   6676: ldc 161
    //   6678: ldc 161
    //   6680: ldc 161
    //   6682: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6685: ldc_w 1668
    //   6688: aload_0
    //   6689: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   6692: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   6695: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6698: ifeq +1071 -> 7769
    //   6701: aload_0
    //   6702: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6705: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6708: checkcast 336	mqq/app/AppRuntime
    //   6711: ldc_w 461
    //   6714: ldc_w 1705
    //   6717: ldc 161
    //   6719: ldc_w 1707
    //   6722: ldc_w 1725
    //   6725: iconst_0
    //   6726: iconst_0
    //   6727: ldc 161
    //   6729: ldc 161
    //   6731: ldc 161
    //   6733: ldc 161
    //   6735: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6738: return
    //   6739: aload_0
    //   6740: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   6743: astore_1
    //   6744: aload_1
    //   6745: ifnull +1024 -> 7769
    //   6748: aload_1
    //   6749: instanceof 201
    //   6752: ifeq +1017 -> 7769
    //   6755: aload_1
    //   6756: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   6759: astore_1
    //   6760: aload_0
    //   6761: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   6764: astore 12
    //   6766: aload 12
    //   6768: ifnull +1001 -> 7769
    //   6771: aload 12
    //   6773: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   6776: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   6779: getstatic 1728	com/tencent/mobileqq/app/BusinessHandlerFactory:QIDIAN_HANDLER	Ljava/lang/String;
    //   6782: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   6785: checkcast 1730	com/tencent/qidian/controller/QidianHandler
    //   6788: astore 12
    //   6790: aload 12
    //   6792: ifnull +977 -> 7769
    //   6795: aload 12
    //   6797: aload_1
    //   6798: getfield 1733	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:extUin	Ljava/lang/String;
    //   6801: aload_1
    //   6802: getfield 1736	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:masterUin	Ljava/lang/String;
    //   6805: aload_1
    //   6806: getfield 1739	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:taskId	Ljava/lang/String;
    //   6809: aload_1
    //   6810: getfield 1742	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:uniseq	J
    //   6813: aload_1
    //   6814: getfield 1095	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:istroop	I
    //   6817: invokevirtual 1745	com/tencent/qidian/controller/QidianHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V
    //   6820: return
    //   6821: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6824: ifeq +13 -> 6837
    //   6827: ldc_w 344
    //   6830: iconst_2
    //   6831: ldc_w 1549
    //   6834: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6837: aconst_null
    //   6838: ldc_w 272
    //   6841: ldc 161
    //   6843: ldc 161
    //   6845: ldc_w 1747
    //   6848: ldc_w 1747
    //   6851: iconst_0
    //   6852: iconst_0
    //   6853: ldc 161
    //   6855: ldc 161
    //   6857: ldc 161
    //   6859: ldc 161
    //   6861: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6864: new 586	android/content/Intent
    //   6867: dup
    //   6868: aload_0
    //   6869: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6872: ldc_w 725
    //   6875: invokespecial 728	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6878: astore_1
    //   6879: invokestatic 1752	com/tencent/mobileqq/config/business/MutualMarkConfProcessor:a	()Lcom/tencent/mobileqq/config/business/MutualMarkConfBean;
    //   6882: aload_0
    //   6883: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   6886: invokevirtual 1756	com/tencent/mobileqq/config/business/MutualMarkConfBean:a	(Ljava/lang/String;)Ljava/lang/String;
    //   6889: astore 13
    //   6891: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6894: ifeq +24 -> 6918
    //   6897: ldc 91
    //   6899: iconst_2
    //   6900: ldc_w 1758
    //   6903: iconst_1
    //   6904: anewarray 624	java/lang/Object
    //   6907: dup
    //   6908: iconst_0
    //   6909: aload 13
    //   6911: aastore
    //   6912: invokestatic 936	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6915: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6918: aload_1
    //   6919: ldc_w 730
    //   6922: aload 13
    //   6924: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6927: pop
    //   6928: aload_1
    //   6929: ldc_w 1760
    //   6932: iconst_1
    //   6933: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6936: pop
    //   6937: aload_1
    //   6938: ldc_w 1762
    //   6941: iconst_1
    //   6942: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6945: pop
    //   6946: aload_1
    //   6947: ldc_w 1764
    //   6950: iconst_0
    //   6951: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6954: pop
    //   6955: aload_0
    //   6956: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   6959: astore 13
    //   6961: aload 13
    //   6963: ifnull +9 -> 6972
    //   6966: aload 13
    //   6968: aload_1
    //   6969: invokevirtual 647	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6972: aload_0
    //   6973: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   6976: astore_1
    //   6977: aload_1
    //   6978: ifnull +88 -> 7066
    //   6981: aload_1
    //   6982: instanceof 201
    //   6985: ifeq +81 -> 7066
    //   6988: aload_1
    //   6989: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   6992: getfield 205	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   6995: astore_1
    //   6996: aload_1
    //   6997: ifnull +49 -> 7046
    //   7000: ldc_w 301
    //   7003: aload_1
    //   7004: getfield 209	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   7007: if_icmpne +39 -> 7046
    //   7010: aload_0
    //   7011: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7014: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7017: checkcast 336	mqq/app/AppRuntime
    //   7020: ldc_w 272
    //   7023: ldc 161
    //   7025: ldc 161
    //   7027: ldc_w 338
    //   7030: ldc_w 1766
    //   7033: iconst_0
    //   7034: iconst_0
    //   7035: ldc 161
    //   7037: ldc 161
    //   7039: ldc 161
    //   7041: ldc 161
    //   7043: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7046: aload_1
    //   7047: ifnull +19 -> 7066
    //   7050: aload 12
    //   7052: aload_0
    //   7053: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7056: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7059: aload_1
    //   7060: getfield 209	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   7063: invokestatic 1769	com/tencent/mobileqq/mutualmark/MutualMarkBusinessLogicHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/graytip/MessageForUniteGrayTip;I)V
    //   7066: aload_0
    //   7067: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7070: astore_1
    //   7071: aload_1
    //   7072: ifnull +697 -> 7769
    //   7075: aload_1
    //   7076: instanceof 201
    //   7079: ifeq +690 -> 7769
    //   7082: aload_1
    //   7083: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7086: getfield 205	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7089: astore_1
    //   7090: aload_1
    //   7091: ifnull +678 -> 7769
    //   7094: ldc_w 1770
    //   7097: aload_1
    //   7098: getfield 209	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   7101: if_icmpne +668 -> 7769
    //   7104: aload_0
    //   7105: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7108: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7111: checkcast 336	mqq/app/AppRuntime
    //   7114: ldc_w 272
    //   7117: ldc 161
    //   7119: ldc 161
    //   7121: ldc_w 1772
    //   7124: ldc_w 1772
    //   7127: iconst_0
    //   7128: iconst_0
    //   7129: ldc 161
    //   7131: ldc 161
    //   7133: ldc 161
    //   7135: ldc 161
    //   7137: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7140: return
    //   7141: aload_0
    //   7142: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7145: aload_0
    //   7146: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7149: invokestatic 1777	com/tencent/mobileqq/troop/utils/HWTroopUtils:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   7152: ldc_w 1779
    //   7155: ldc_w 463
    //   7158: ldc_w 1781
    //   7161: iconst_0
    //   7162: iconst_0
    //   7163: iconst_1
    //   7164: anewarray 328	java/lang/String
    //   7167: dup
    //   7168: iconst_0
    //   7169: aload_0
    //   7170: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7173: aastore
    //   7174: invokestatic 1401	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   7177: return
    //   7178: new 586	android/content/Intent
    //   7181: dup
    //   7182: invokespecial 1166	android/content/Intent:<init>	()V
    //   7185: astore_1
    //   7186: aload_1
    //   7187: ldc_w 1783
    //   7190: aload_0
    //   7191: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7194: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7197: pop
    //   7198: aload_1
    //   7199: ldc_w 1785
    //   7202: iconst_1
    //   7203: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7206: pop
    //   7207: aload_1
    //   7208: ldc_w 1787
    //   7211: iconst_1
    //   7212: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7215: pop
    //   7216: aload_1
    //   7217: ldc_w 1789
    //   7220: aload_0
    //   7221: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7224: ldc_w 1790
    //   7227: invokevirtual 1791	android/content/Context:getString	(I)Ljava/lang/String;
    //   7230: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7233: pop
    //   7234: aload_1
    //   7235: ldc_w 1793
    //   7238: iconst_1
    //   7239: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7242: pop
    //   7243: aload_1
    //   7244: ldc_w 1795
    //   7247: iconst_1
    //   7248: invokevirtual 735	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7251: pop
    //   7252: aload_1
    //   7253: ldc_w 1797
    //   7256: aload_0
    //   7257: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7260: ldc_w 1798
    //   7263: invokevirtual 1791	android/content/Context:getString	(I)Ljava/lang/String;
    //   7266: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7269: pop
    //   7270: aload_1
    //   7271: ldc_w 1800
    //   7274: bipush 100
    //   7276: invokevirtual 1215	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7279: pop
    //   7280: ldc_w 1802
    //   7283: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   7286: checkcast 1802	com/tencent/mobileqq/selectmember/api/ISelectMemberApi
    //   7289: aload_0
    //   7290: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7293: aload_1
    //   7294: invokeinterface 1806 3 0
    //   7299: return
    //   7300: new 1808	com/tencent/mobileqq/troop/data/TroopInfoData
    //   7303: dup
    //   7304: invokespecial 1809	com/tencent/mobileqq/troop/data/TroopInfoData:<init>	()V
    //   7307: astore_1
    //   7308: aload_1
    //   7309: aload_0
    //   7310: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7313: putfield 1811	com/tencent/mobileqq/troop/data/TroopInfoData:troopUin	Ljava/lang/String;
    //   7316: aload_0
    //   7317: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7320: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7323: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7326: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   7329: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7332: checkcast 984	com/tencent/mobileqq/app/TroopManager
    //   7335: astore 12
    //   7337: aload 12
    //   7339: ifnull +430 -> 7769
    //   7342: aload 12
    //   7344: aload_0
    //   7345: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7348: invokevirtual 1387	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   7351: astore 12
    //   7353: aload 12
    //   7355: ifnull +34 -> 7389
    //   7358: aload_1
    //   7359: aload 12
    //   7361: aload_0
    //   7362: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7365: invokevirtual 1604	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7368: aload_0
    //   7369: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7372: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7375: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7378: invokevirtual 190	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7381: invokevirtual 1815	com/tencent/mobileqq/troop/data/TroopInfoData:updateForTroopChatSetting	(Lcom/tencent/mobileqq/data/troop/TroopInfo;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   7384: aload_1
    //   7385: iconst_1
    //   7386: putfield 1818	com/tencent/mobileqq/troop/data/TroopInfoData:isMember	Z
    //   7389: new 1820	com/tencent/mobileqq/troopshare/TroopShareUtility
    //   7392: dup
    //   7393: aload_0
    //   7394: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7397: checkcast 1370	com/tencent/mobileqq/activity/SplashActivity
    //   7400: aload_1
    //   7401: invokespecial 1823	com/tencent/mobileqq/troopshare/TroopShareUtility:<init>	(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/troop/data/TroopInfoData;)V
    //   7404: aload_1
    //   7405: invokevirtual 1826	com/tencent/mobileqq/troopshare/TroopShareUtility:a	(Lcom/tencent/mobileqq/troop/data/TroopInfoData;)V
    //   7408: return
    //   7409: aload_0
    //   7410: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7413: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7416: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7419: astore_1
    //   7420: aload_0
    //   7421: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7424: astore 12
    //   7426: aload 12
    //   7428: ifnull +341 -> 7769
    //   7431: aload_1
    //   7432: ifnull +337 -> 7769
    //   7435: aload_0
    //   7436: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7439: astore 13
    //   7441: new 82	java/lang/StringBuilder
    //   7444: dup
    //   7445: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   7448: astore 14
    //   7450: aload 14
    //   7452: ldc 161
    //   7454: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7457: pop
    //   7458: aload 14
    //   7460: aload_0
    //   7461: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7464: getfield 960	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:uin	J
    //   7467: invokevirtual 1291	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7470: pop
    //   7471: aload_1
    //   7472: aload 12
    //   7474: aload 13
    //   7476: aload 14
    //   7478: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7481: iconst_4
    //   7482: iconst_m1
    //   7483: invokestatic 1385	com/tencent/mobileqq/profile/TroopMemberCardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   7486: return
    //   7487: iconst_2
    //   7488: istore_2
    //   7489: aload_0
    //   7490: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   7493: invokevirtual 187	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7496: checkcast 64	com/tencent/mobileqq/app/QQAppInterface
    //   7499: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   7502: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7505: checkcast 984	com/tencent/mobileqq/app/TroopManager
    //   7508: aload_0
    //   7509: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7512: invokevirtual 1387	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   7515: ifnonnull +6 -> 7521
    //   7518: goto +5 -> 7523
    //   7521: iconst_1
    //   7522: istore_2
    //   7523: aload_0
    //   7524: getfield 44	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:frienduin	Ljava/lang/String;
    //   7527: iconst_4
    //   7528: invokestatic 1200	com/tencent/mobileqq/troop/utils/TroopInfoUIUtil:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   7531: astore_1
    //   7532: aload_1
    //   7533: ldc_w 1202
    //   7536: sipush 1001
    //   7539: invokevirtual 1205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   7542: aload_0
    //   7543: getfield 35	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   7546: aload_1
    //   7547: iload_2
    //   7548: invokestatic 1208	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   7551: return
    //   7552: aload_0
    //   7553: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7556: astore_1
    //   7557: aload_1
    //   7558: ifnull +165 -> 7723
    //   7561: aload_1
    //   7562: instanceof 201
    //   7565: ifeq +158 -> 7723
    //   7568: aload_1
    //   7569: checkcast 201	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7572: getfield 205	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   7575: getfield 209	com/tencent/mobileqq/graytip/UniteGrayTipParam:b	I
    //   7578: ldc_w 384
    //   7581: if_icmpne +142 -> 7723
    //   7584: aload_0
    //   7585: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7588: ldc 153
    //   7590: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   7593: astore_1
    //   7594: aload_0
    //   7595: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7598: ldc 165
    //   7600: invokevirtual 157	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   7603: astore 13
    //   7605: aload_0
    //   7606: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7609: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   7612: ifne +8 -> 7620
    //   7615: iconst_1
    //   7616: istore_2
    //   7617: goto +21 -> 7638
    //   7620: aload_0
    //   7621: getfield 39	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   7624: getfield 245	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   7627: iconst_1
    //   7628: if_icmpne +8 -> 7636
    //   7631: iconst_2
    //   7632: istore_2
    //   7633: goto +5 -> 7638
    //   7636: iconst_3
    //   7637: istore_2
    //   7638: new 82	java/lang/StringBuilder
    //   7641: dup
    //   7642: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   7645: astore 14
    //   7647: aload 14
    //   7649: ldc 161
    //   7651: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7654: pop
    //   7655: aload 14
    //   7657: aload 13
    //   7659: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7662: pop
    //   7663: aload 14
    //   7665: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7668: astore 13
    //   7670: new 82	java/lang/StringBuilder
    //   7673: dup
    //   7674: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   7677: astore 14
    //   7679: aload 14
    //   7681: ldc 161
    //   7683: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7686: pop
    //   7687: aload 14
    //   7689: aload_1
    //   7690: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7693: pop
    //   7694: aload 12
    //   7696: ldc 159
    //   7698: ldc 161
    //   7700: ldc 161
    //   7702: ldc 163
    //   7704: ldc 163
    //   7706: iload_2
    //   7707: iconst_0
    //   7708: aload 13
    //   7710: aload 14
    //   7712: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7715: ldc_w 1828
    //   7718: ldc 161
    //   7720: invokestatic 172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7723: aload_0
    //   7724: aload_0
    //   7725: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7728: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   7731: aload_0
    //   7732: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7735: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   7738: invokevirtual 1830	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickPluginMsg	(Ljava/lang/String;Ljava/lang/String;)Z
    //   7741: pop
    //   7742: return
    //   7743: aload_0
    //   7744: aload_0
    //   7745: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7748: getfield 306	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgActionData	Ljava/lang/String;
    //   7751: aload_0
    //   7752: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:item	Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;
    //   7755: getfield 309	com/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem:mMsgAActionData	Ljava/lang/String;
    //   7758: invokevirtual 1832	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickAppMsg	(Ljava/lang/String;Ljava/lang/String;)Z
    //   7761: pop
    //   7762: return
    //   7763: aload_0
    //   7764: aload 12
    //   7766: invokespecial 1834	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:onClickActionWeb	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   7769: return
    //   7770: astore 13
    //   7772: goto -7172 -> 600
    //   7775: astore_1
    //   7776: goto -5326 -> 2450
    //   7779: astore_1
    //   7780: goto -5138 -> 2642
    //   7783: astore_1
    //   7784: goto -5140 -> 2644
    //   7787: bipush 8
    //   7789: istore_2
    //   7790: goto -5911 -> 1879
    //   7793: bipush 10
    //   7795: istore_2
    //   7796: goto -5917 -> 1879
    //   7799: bipush 12
    //   7801: istore_2
    //   7802: goto -5923 -> 1879
    //   7805: iconst_m1
    //   7806: istore_2
    //   7807: goto -5928 -> 1879
    //   7810: iconst_0
    //   7811: istore_2
    //   7812: goto -3381 -> 4431
    //   7815: iconst_0
    //   7816: istore_3
    //   7817: goto -3318 -> 4499
    //   7820: iconst_0
    //   7821: istore 8
    //   7823: goto -3160 -> 4663
    //   7826: goto -2329 -> 5497
    //   7829: iconst_0
    //   7830: istore 8
    //   7832: goto -1654 -> 6178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7835	0	this	HightlightClickableSpan
    //   0	7835	1	paramView	android.view.View
    //   30	7782	2	i	int
    //   99	7718	3	j	int
    //   4534	270	4	k	int
    //   4578	187	5	m	int
    //   4466	189	6	n	int
    //   4524	72	7	i1	int
    //   27	7804	8	bool1	boolean
    //   1669	97	9	bool2	boolean
    //   3130	2310	10	l	long
    //   84	7681	12	localObject1	Object
    //   573	3868	13	localObject2	Object
    //   4827	15	13	localJSONException	org.json.JSONException
    //   5587	2122	13	localObject3	Object
    //   7770	1	13	localThrowable	java.lang.Throwable
    //   1366	6345	14	localObject4	Object
    //   4066	740	15	localObject5	Object
    //   4568	104	16	str1	String
    //   4600	64	17	localObject6	Object
    //   4636	30	18	localContext	Context
    //   4642	26	19	str2	String
    //   4649	26	20	localXEditTextEx	com.tencent.widget.XEditTextEx
    // Exception table:
    //   from	to	target	type
    //   425	505	506	org/json/JSONException
    //   1569	1594	1947	java/lang/RuntimeException
    //   1594	1609	1947	java/lang/RuntimeException
    //   1614	1725	1947	java/lang/RuntimeException
    //   1730	1740	1947	java/lang/RuntimeException
    //   1745	1760	1947	java/lang/RuntimeException
    //   1770	1780	1947	java/lang/RuntimeException
    //   1785	1800	1947	java/lang/RuntimeException
    //   1806	1821	1947	java/lang/RuntimeException
    //   1827	1852	1947	java/lang/RuntimeException
    //   1858	1873	1947	java/lang/RuntimeException
    //   1879	1944	1947	java/lang/RuntimeException
    //   3082	3117	3407	java/lang/Exception
    //   3123	3280	3407	java/lang/Exception
    //   3285	3359	3407	java/lang/Exception
    //   3360	3380	3407	java/lang/Exception
    //   3385	3395	3407	java/lang/Exception
    //   3396	3406	3407	java/lang/Exception
    //   4385	4419	4827	org/json/JSONException
    //   4419	4428	4827	org/json/JSONException
    //   4431	4496	4827	org/json/JSONException
    //   4499	4580	4827	org/json/JSONException
    //   4592	4651	4827	org/json/JSONException
    //   4663	4683	4827	org/json/JSONException
    //   4688	4696	4827	org/json/JSONException
    //   4699	4709	4827	org/json/JSONException
    //   4721	4760	4827	org/json/JSONException
    //   4772	4813	4827	org/json/JSONException
    //   5386	5470	5518	finally
    //   5477	5490	5518	finally
    //   5497	5517	5518	finally
    //   5523	5538	5518	finally
    //   5386	5470	5522	java/lang/Exception
    //   5477	5490	5522	java/lang/Exception
    //   5497	5517	5522	java/lang/Exception
    //   6068	6113	6253	org/json/JSONException
    //   6122	6144	6253	org/json/JSONException
    //   6149	6172	6253	org/json/JSONException
    //   6178	6252	6253	org/json/JSONException
    //   583	600	7770	java/lang/Throwable
    //   2411	2449	7775	java/lang/NumberFormatException
    //   2617	2628	7779	java/lang/NumberFormatException
    //   2628	2639	7783	java/lang/NumberFormatException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */