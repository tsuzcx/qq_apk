package com.tencent.mobileqq.qwallet.hb.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi.ITroopUnclaimedHbList;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel;
import com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.specify.impl.RedPacketConfigManager;
import com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyRedPacketAnimMsg;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier;
import com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketEmojiFragment;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRecognizer;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletHbApiImpl
  implements IQWalletHbApi
{
  private static final int MIN_HEIGHT_TO_SHOW_NEW_CLOSE_BTN_DP = 650;
  private static final String TAG = "QWalletHbApi";
  private static TroopManagerBizObserver sTroopBusinessObserver;
  private int panel_from = -1;
  
  private void doReport(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, BaseSessionInfo paramBaseSessionInfo, QWalletHbApiImpl.SendHbParamOfSession paramSendHbParamOfSession, QWalletHbApiImpl.SendHbParamOfPanel paramSendHbParamOfPanel)
  {
    if (paramInt == 0) {
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).AIOPanelUtiles$panelReport(paramBaseQQAppInterface, "0X8005CAF", paramBaseSessionInfo.a);
    } else if (paramInt == 1) {
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).AIOPanelUtiles$panelReport(paramBaseQQAppInterface, "0X8005FC9", paramBaseSessionInfo.a);
    }
    if (getPanelFrom() == 0)
    {
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append(paramSendHbParamOfSession.d);
      paramBaseSessionInfo.append(".plus");
      paramSendHbParamOfSession.d = paramBaseSessionInfo.toString();
    }
    else if (getPanelFrom() == 1)
    {
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append(paramSendHbParamOfSession.d);
      paramBaseSessionInfo.append(".quick");
      paramSendHbParamOfSession.d = paramBaseSessionInfo.toString();
    }
    ReportController.b(paramBaseQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramSendHbParamOfSession.d, 0, 0, paramSendHbParamOfPanel.c, "", "", "");
  }
  
  private void doSendHbJumpIntoSendHbActivity(Activity paramActivity, PanelData paramPanelData, QWalletHbApiImpl.SendHbParamOfSession paramSendHbParamOfSession, QWalletHbApiImpl.SendHbParamOfPanel paramSendHbParamOfPanel, BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramActivity == null) {
      return;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/qwallet/redpacket/sendhb");
    localActivityURIRequest.extra().putInt("come_from", 2);
    localActivityURIRequest.extra().putString("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#aio");
    localActivityURIRequest.extra().putBoolean("isFromPanel", true);
    if ((paramPanelData != null) && (paramPanelData.b == 3))
    {
      JSONObject localJSONObject = paramPanelData.h;
      paramActivity = "";
      if (localJSONObject != null) {
        paramActivity = paramPanelData.h.optString("theme_id", "");
      }
      localActivityURIRequest.extra().putString("theme_type", paramActivity);
      localActivityURIRequest.extra().putBoolean("theme", true);
    }
    paramActivity = new StringBuilder();
    paramActivity.append("groupType=");
    paramActivity.append(paramSendHbParamOfSession.b);
    long l = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", paramActivity.toString(), 0, null);
    localActivityURIRequest.extra().putLong("vacreport_key_seq", l);
    paramActivity = new JSONObject();
    try
    {
      paramActivity.put("recv_type", paramSendHbParamOfSession.b);
      paramActivity.put("recv_uin", paramBaseSessionInfo.b);
      paramActivity.put("channel", paramSendHbParamOfPanel.a);
      paramActivity.put("bus_type", paramSendHbParamOfPanel.b);
      if (paramSendHbParamOfSession.a > 0) {
        paramActivity.put("people_num", paramSendHbParamOfSession.a);
      }
      if (!TextUtils.isEmpty(paramSendHbParamOfSession.c)) {
        paramActivity.put("session_token", paramSendHbParamOfSession.c);
      }
      if (!TextUtils.isEmpty(paramSendHbParamOfSession.e)) {
        paramActivity.put("placeholder", paramSendHbParamOfSession.e);
      }
      if (!TextUtils.isEmpty(paramSendHbParamOfSession.f)) {
        paramActivity.put("tinyid", paramSendHbParamOfSession.f);
      }
      if (!TextUtils.isEmpty(paramSendHbParamOfSession.g)) {
        paramActivity.put("guild_id", paramSendHbParamOfSession.g);
      }
      if (!TextUtils.isEmpty(paramSendHbParamOfSession.h)) {
        paramActivity.put("sub_guild_id", paramSendHbParamOfSession.h);
      }
    }
    catch (JSONException paramPanelData)
    {
      paramPanelData.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramPanelData = new StringBuilder();
      paramPanelData.append("click HongBao:params=");
      paramPanelData.append(paramActivity.toString());
      QLog.d("PlusPanel", 2, paramPanelData.toString());
    }
    localActivityURIRequest.extra().putString("extra_data", paramActivity.toString());
    QRoute.startUri(localActivityURIRequest, new QWalletHbApiImpl.4(this));
  }
  
  private boolean doSendHbJumpNoEnterSendHbActivity(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, PanelData paramPanelData, BaseSessionInfo paramBaseSessionInfo, QWalletHbApiImpl.SendHbParamOfSession paramSendHbParamOfSession)
  {
    int i = paramPanelData.b;
    Object localObject;
    if (i != 4)
    {
      if (i != 5)
      {
        if (i != 12)
        {
          if (i != 13) {
            return false;
          }
          paramPanelData = paramPanelData.h.optString("schema", "");
          QLog.i("QWalletHbApi", 2, paramPanelData);
          if (TextUtils.isEmpty(paramPanelData)) {
            return true;
          }
          localObject = new HashMap();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramSendHbParamOfSession.b);
          localStringBuilder.append("");
          ((Map)localObject).put("recv_group_type", localStringBuilder.toString());
          ((Map)localObject).put("recv_group_id", paramBaseSessionInfo.b);
          ((Map)localObject).put("send_uin", paramBaseQQAppInterface.getCurrentUin());
          paramBaseQQAppInterface = QwUtils.a(paramPanelData, (Map)localObject, true);
          if (QLog.isColorLevel())
          {
            paramPanelData = new StringBuilder();
            paramPanelData.append("[go to miniapp] finalSchame: ");
            paramPanelData.append(paramBaseQQAppInterface);
            QLog.i("QWalletHbApi", 2, paramPanelData.toString());
          }
          ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doJumpAction(paramActivity, paramBaseQQAppInterface);
          return true;
        }
        paramPanelData = paramPanelData.h.optString("schema");
        QLog.i("QWalletHbApi", 2, paramPanelData);
        if (TextUtils.isEmpty(paramPanelData)) {
          return true;
        }
        gotoGoldHb(paramBaseQQAppInterface, paramActivity, paramBaseSessionInfo, paramSendHbParamOfSession.b, paramSendHbParamOfSession.a, paramPanelData);
        return true;
      }
      long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
      ReportController.b(paramBaseQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "plus.hongbao.click", 0, 0, "", "", "", "");
      paramBaseQQAppInterface = new ActivityURIRequest(paramActivity, "/qwallet/redpacket/QrcodeHbGuider");
      paramBaseQQAppInterface.extra().putLong("vacreport_key_seq", l);
      paramBaseQQAppInterface.extra().putString("appInfo", "");
      QRoute.startUri(paramBaseQQAppInterface, new QWalletHbApiImpl.2(this));
      return true;
    }
    if (paramPanelData.h != null)
    {
      localObject = paramPanelData.h.optString("url", "");
      QLog.i("QWalletHbApi", 2, (String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return true;
      }
      paramBaseQQAppInterface = (BaseQQAppInterface)localObject;
      if (paramPanelData.h.optInt("subtype", 0) == 1) {
        if (((String)localObject).indexOf("?") == -1)
        {
          paramBaseQQAppInterface = new StringBuilder();
          paramBaseQQAppInterface.append((String)localObject);
          paramBaseQQAppInterface.append("?recv_uin=");
          paramBaseQQAppInterface.append(paramBaseSessionInfo.b);
          paramBaseQQAppInterface.append("&recv_type=");
          paramBaseQQAppInterface.append(paramSendHbParamOfSession.b);
          paramBaseQQAppInterface = paramBaseQQAppInterface.toString();
        }
        else
        {
          paramBaseQQAppInterface = new StringBuilder();
          paramBaseQQAppInterface.append((String)localObject);
          paramBaseQQAppInterface.append("&recv_uin=");
          paramBaseQQAppInterface.append(paramBaseSessionInfo.b);
          paramBaseQQAppInterface.append("&recv_type=");
          paramBaseQQAppInterface.append(paramSendHbParamOfSession.b);
          paramBaseQQAppInterface = paramBaseQQAppInterface.toString();
        }
      }
      gotoWebViewFromURL(paramActivity, paramBaseQQAppInterface);
    }
    return true;
  }
  
  private QWalletHbApiImpl.SendHbParamOfPanel getSendHbModelByPanel(PanelData paramPanelData)
  {
    int i;
    if (IRedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramPanelData.b)) == null) {
      i = 1;
    } else {
      i = ((Integer)IRedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramPanelData.b))).intValue();
    }
    String str = String.valueOf(2);
    int j = paramPanelData.b;
    paramPanelData = "";
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 6)
            {
              if (j == 7) {
                paramPanelData = "13147";
              }
            }
            else {
              paramPanelData = "13146";
            }
          }
          else {
            i = 1;
          }
        }
        else {
          paramPanelData = "13142";
        }
      }
      else
      {
        str = String.valueOf(2);
        paramPanelData = "13141";
      }
    }
    else
    {
      str = String.valueOf(1);
      paramPanelData = "13140";
    }
    QWalletHbApiImpl.SendHbParamOfPanel localSendHbParamOfPanel = new QWalletHbApiImpl.SendHbParamOfPanel(null);
    localSendHbParamOfPanel.b = str;
    localSendHbParamOfPanel.a = i;
    localSendHbParamOfPanel.c = paramPanelData;
    return localSendHbParamOfPanel;
  }
  
  private static QWalletHbApiImpl.SendHbParamOfSession getSendHbModelBySession(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class)).getRandomPasswd();
    QWalletHbApiImpl.SendHbParamOfSession localSendHbParamOfSession = new QWalletHbApiImpl.SendHbParamOfSession(null);
    int k = paramBaseSessionInfo.a;
    int j = 1;
    int i = 1;
    String str2 = "entrance.click.c2c";
    String str1 = "";
    Object localObject;
    if (k == 0)
    {
      i = 1;
      paramBaseSessionInfo = str1;
      paramBaseQQAppInterface = str2;
    }
    else if (paramBaseSessionInfo.a == 3000)
    {
      j = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).DiscussionManager$getDiscussionMemberNum(paramBaseQQAppInterface, paramBaseSessionInfo.b);
      paramBaseQQAppInterface = "entrance.click.group";
      i = 2;
      paramBaseSessionInfo = str1;
    }
    else if (paramBaseSessionInfo.a == 1)
    {
      localObject = ((ITroopInfoService)paramBaseQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramBaseSessionInfo.b);
      j = i;
      if (localObject != null)
      {
        j = ((TroopInfo)localObject).wMemberNum;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("troop uin：");
          ((StringBuilder)localObject).append(paramBaseSessionInfo.b);
          ((StringBuilder)localObject).append(" people_num：");
          ((StringBuilder)localObject).append(j);
          QLog.d("PlusPanelUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (!QWalletHelperImpl.isNeedUpdateTroopMemberNum(paramBaseSessionInfo.b)) {}
    }
    try
    {
      long l = Long.parseLong(paramBaseSessionInfo.b);
      if (sTroopBusinessObserver == null) {
        sTroopBusinessObserver = new QWalletHbApiImpl.1(paramBaseSessionInfo);
      }
      paramBaseQQAppInterface.addObserver(sTroopBusinessObserver);
      ((ITroopManagerBizHandler)paramBaseQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopManagerBizHandlerName())).a(l, 32);
    }
    catch (NumberFormatException paramBaseQQAppInterface)
    {
      label284:
      break label284;
    }
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("群uin：");
      paramBaseQQAppInterface.append(paramBaseSessionInfo.b);
      paramBaseQQAppInterface.append(" 解析失败");
      QLog.d("angelzhuang", 2, paramBaseQQAppInterface.toString());
    }
    i = 3;
    paramBaseQQAppInterface = "entrance.click.chatgroup";
    paramBaseSessionInfo = str1;
    break label590;
    if (paramBaseSessionInfo.a == 1000)
    {
      i = 4;
      paramBaseSessionInfo = paramBaseSessionInfo.c;
      paramBaseQQAppInterface = str2;
    }
    else if (paramBaseSessionInfo.a == 1004)
    {
      i = 5;
      paramBaseSessionInfo = paramBaseSessionInfo.c;
      paramBaseQQAppInterface = str2;
    }
    else if ((paramBaseSessionInfo.a != 1001) && (paramBaseSessionInfo.a != 10002) && (paramBaseSessionInfo.a != 10004))
    {
      if (paramBaseSessionInfo.a == 10014)
      {
        localSendHbParamOfSession.f = ((IGPSService)paramBaseQQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        localSendHbParamOfSession.g = paramBaseSessionInfo.c;
        localSendHbParamOfSession.h = paramBaseSessionInfo.b;
        paramBaseQQAppInterface = "";
        i = 11;
        paramBaseSessionInfo = str1;
      }
      else
      {
        i = 0;
        paramBaseQQAppInterface = "";
        paramBaseSessionInfo = str1;
      }
    }
    else
    {
      localObject = (MessageCache)paramBaseQQAppInterface.getMsgCache();
      if (paramBaseSessionInfo.a == 10004) {
        localObject = ((MessageCache)localObject).q(paramBaseSessionInfo.b);
      } else {
        localObject = ((MessageCache)localObject).r(paramBaseSessionInfo.b);
      }
      paramBaseSessionInfo = str1;
      if (localObject != null) {
        paramBaseSessionInfo = Base64Util.encodeToString((byte[])localObject, 2);
      }
      ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
      i = 7;
      paramBaseQQAppInterface = str2;
    }
    label590:
    localSendHbParamOfSession.d = paramBaseQQAppInterface;
    localSendHbParamOfSession.a = j;
    localSendHbParamOfSession.b = i;
    localSendHbParamOfSession.c = paramBaseSessionInfo;
    return localSendHbParamOfSession;
  }
  
  private void gotoGoldHb(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    QwUtils.a(paramBaseQQAppInterface, "tenpay.com", new QWalletHbApiImpl.3(this, paramInt1, paramBaseSessionInfo, paramBaseQQAppInterface, paramInt2, paramString, paramActivity));
  }
  
  private void initRedPannelData(List<PanelData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).setPanelDataList(paramList);
    }
  }
  
  private boolean isRedPacketMsg(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    return (paramMessageForQQWalletMsg != null) && (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null) && (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null);
  }
  
  public void dealHongBaoPanelMultiPlex(int paramInt, View paramView)
  {
    if ((paramView != null) && (paramInt == 10)) {
      try
      {
        paramView = (HongBaoPanel)paramView;
        paramView.b();
        paramView.d();
        return;
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public boolean doJumpAction(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = new Intent(paramContext, JumpActivity.class);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      localIntent.setData(Uri.parse(paramString));
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public boolean doStartBrowser(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = new Intent();
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
      RouteUtils.a(paramContext, localIntent, "/base/browser");
      return true;
    }
    return false;
  }
  
  public ICustomizeStrategyFactory getCustomizeStrategyFactory()
  {
    return CustomizeStrategyFactory.d();
  }
  
  public int getPanelFrom()
  {
    return this.panel_from;
  }
  
  public int getSpecifyHbAniMaxSize(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return RedPacketConfigManager.a().a(paramBaseQQAppInterface);
  }
  
  public IQWalletHbApi.ITroopUnclaimedHbList getTroopUnclaimedHbList(BaseQQAppInterface paramBaseQQAppInterface, IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    return new TroopUnclaimedHbList(paramBaseQQAppInterface, paramIBaseChatPieProxy);
  }
  
  public void gotoWebViewFromURL(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = paramString.indexOf(':');
    if (i == -1) {
      return;
    }
    Object localObject = paramString.substring(0, i);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = ((String)localObject).toLowerCase();
    if ((((String)localObject).compareTo("http") == 0) || (((String)localObject).compareTo("https") == 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramString);
      paramActivity.startActivity((Intent)localObject);
      RouteUtils.a(paramActivity, (Intent)localObject, "/base/browser");
    }
  }
  
  public boolean isCanShowNewCloseBtn(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (DisplayUtil.a(paramContext, 650.0F) < localDisplayMetrics.heightPixels) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForQQWalletMsg)) && (isRedPacketMsg((MessageForQQWalletMsg)paramMessageRecord));
  }
  
  public boolean isValideToDoAction(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public void sendRedPkg(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo, PanelData paramPanelData, List<PanelData> paramList, int paramInt)
  {
    if (paramPanelData == null) {
      return;
    }
    initRedPannelData(paramList);
    paramList = getSendHbModelBySession(paramBaseQQAppInterface, paramBaseSessionInfo);
    if (doSendHbJumpNoEnterSendHbActivity(paramBaseQQAppInterface, paramActivity, paramPanelData, paramBaseSessionInfo, paramList))
    {
      QLog.i("QWalletHbApi", 2, "---doSendHbJumpNoEnterSendHbActivity---");
      return;
    }
    QWalletHbApiImpl.SendHbParamOfPanel localSendHbParamOfPanel = getSendHbModelByPanel(paramPanelData);
    doSendHbJumpIntoSendHbActivity(paramActivity, paramPanelData, paramList, localSendHbParamOfPanel, paramBaseSessionInfo);
    doReport(paramBaseQQAppInterface, paramInt, paramBaseSessionInfo, paramList, localSendHbParamOfPanel);
  }
  
  public void setPanelFrom(int paramInt)
  {
    this.panel_from = paramInt;
  }
  
  public boolean specifyRedPacketIsValidAnim(Object paramObject, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return SpecifyRedPacketAnimMsg.a(paramObject, paramBaseQQAppInterface);
  }
  
  public void tryPreDownEmojiRes(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForQQWalletMsg)) {
      RedPacketEmojiFragment.a(paramBaseQQAppInterface, (MessageForQQWalletMsg)paramMessageRecord);
    }
  }
  
  public void tryPreDownLoadModel(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForQQWalletMsg)) {
      DrawClassifier.a((MessageForQQWalletMsg)paramMessageRecord);
    }
  }
  
  public boolean tryScheduleSpecifyAnim(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForQQWalletMsg)) {
      return SpecifyRedPacketAnimMsg.a(paramBaseQQAppInterface, (MessageForQQWalletMsg)paramMessageRecord);
    }
    return false;
  }
  
  public void voiceRecognizerDestroy()
  {
    VoiceRecognizer.a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.QWalletHbApiImpl
 * JD-Core Version:    0.7.0.1
 */