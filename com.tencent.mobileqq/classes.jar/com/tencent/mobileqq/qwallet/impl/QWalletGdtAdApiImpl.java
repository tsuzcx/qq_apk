package com.tencent.mobileqq.qwallet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.IStructmsgApi;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XBaseAdapter;
import cooperation.qwallet.QwUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.qqwallet.QWalletPubAdReport.QueryReq;
import tencent.im.qqwallet.QWalletPubAdReport.QueryRsp;
import tencent.im.qqwallet.QWalletPubAdReport.ReportReq;
import tencent.im.qqwallet.QWalletPubAdReport.TerminalInfor;

public class QWalletGdtAdApiImpl
  implements IQWalletGdtAdApi
{
  private static final String GDT_PUB_POST_ID = "6001902438716523";
  private static final long ONE_DAY_MILLIONS = 86400000L;
  private static final long ONE_WEEK_MILLIONS = 604800000L;
  private static final int PUB_AD_CONFIG_DAY_REQ_DEFAULT = 1;
  private static final int PUB_AD_CONFIG_SWITCH_DEFAULT = 0;
  private static final int PUB_AD_CONFIG_WEEK_REQ_DEFAULT = 4;
  private static final String SP_KEY_DAY_FREQ = "sp_key_day_freq";
  private static final String SP_KEY_PV_TIMESTAMP = "sp_key_pv_timestamp";
  private static final String SP_KEY_SHOW_AD_TIMES = "sp_key_show_ad_times";
  private static final String SP_KEY_WEEK_FREQ = "sp_key_week_freq";
  private static final String SP_WALLET_GDT = "sp_wallet_gdt";
  private GdtAdLoader.Listener mAdLoaderListener;
  private volatile GdtAd mGdtAd;
  private GdtAppReceiver mGdtReceiver;
  private boolean mHasTailMsg;
  private volatile int mPvFlag = 0;
  private volatile long mPvTimestamp = 0L;
  private String title = "";
  
  private static qq_ad_get.QQAdGet createRequest(long paramLong, String paramString, int paramInt)
  {
    qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.pos_id.set(paramString);
    localPositionInfo.ad_count.set(paramInt);
    paramString = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    paramString.deep_link_version.set(1);
    localPositionInfo.pos_ext.set(paramString);
    paramString = new qq_ad_get.QQAdGet.UserInfo();
    paramString.qq.set(paramLong);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add(localPositionInfo);
    localQQAdGet.user_info.set(paramString);
    return localQQAdGet;
  }
  
  private void doReqAds(QBaseActivity paramQBaseActivity, IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    paramIBaseChatPieProxy = new QWalletGdtAdApiImpl.1(this, NetConnInfoCenter.getServerTimeMillis(), paramIBaseChatPieProxy, paramQBaseActivity);
    this.mAdLoaderListener = paramIBaseChatPieProxy;
    reqAds(paramQBaseActivity, "6001902438716523", 1, paramIBaseChatPieProxy);
  }
  
  private void doReqAdsControl()
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    if (localBaseQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdApi", 2, "doReqAdsControl start");
    }
    QwUtils.a(localBaseQQAppInterface, "tenpay.com", new QWalletGdtAdApiImpl.2(this, localBaseQQAppInterface, NetConnInfoCenter.getServerTimeMillis()));
  }
  
  private QWalletPubAdReport.QueryReq getQueryReq(String paramString)
  {
    QWalletPubAdReport.QueryReq localQueryReq = new QWalletPubAdReport.QueryReq();
    String str = QWalletTools.c().getAccount();
    localQueryReq.uin.set(str);
    localQueryReq.pskey.set(paramString);
    localQueryReq.channel.set(1);
    localQueryReq.terminal_infor.set(getTerminalInfo());
    return localQueryReq;
  }
  
  private QWalletPubAdReport.ReportReq getReportReq(String paramString, int paramInt)
  {
    QWalletPubAdReport.ReportReq localReportReq = new QWalletPubAdReport.ReportReq();
    String str = QWalletTools.c().getAccount();
    localReportReq.uin.set(str);
    localReportReq.pskey.set(paramString);
    localReportReq.channel.set(1);
    localReportReq.ad_reslut.set(paramInt);
    localReportReq.terminal_infor.set(getTerminalInfo());
    return localReportReq;
  }
  
  private QWalletPubAdReport.TerminalInfor getTerminalInfo()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean isDebugNoLimit()
  {
    return false;
  }
  
  private void notifyListRefresh(IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    if ((paramIBaseChatPieProxy != null) && (paramIBaseChatPieProxy.h() != null)) {
      paramIBaseChatPieProxy.h().notifyDataSetChanged();
    }
  }
  
  private void printRetFailLog(GdtAdLoader paramGdtAdLoader)
  {
    if (QLog.isColorLevel())
    {
      if (paramGdtAdLoader == null)
      {
        QLog.i("QWalletGdtAdApi", 2, "reqAds onResponse ret fail,loader null");
        return;
      }
      if (paramGdtAdLoader.a() == null)
      {
        QLog.i("QWalletGdtAdApi", 2, "reqAds onResponse ret fail,getSession null");
        return;
      }
      if (paramGdtAdLoader.a().b == null)
      {
        QLog.i("QWalletGdtAdApi", 2, "reqAds onResponse ret fail,loader.getSession().response null");
        return;
      }
      if (paramGdtAdLoader.a().b.ret.get() != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reqAds onResponse ret fail,loader.getSession().response.ret.get ");
        localStringBuilder.append(paramGdtAdLoader.a().b.ret.get());
        QLog.i("QWalletGdtAdApi", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void reqAds(Context paramContext, String paramString, int paramInt, GdtAdLoader.Listener paramListener)
  {
    GdtAdLoader.Session localSession = new GdtAdLoader.Session();
    localSession.a = createRequest(QWalletTools.c().getLongAccountUin(), paramString, paramInt);
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).loadAd(localSession, new WeakReference(paramListener), new WeakReference(paramContext));
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdApi", 2, "doReqAds start");
    }
  }
  
  private void saveUvControl(QWalletPubAdReport.QueryRsp paramQueryRsp)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_wallet_gdt", 4);
    int k = paramQueryRsp.pv_flag.get();
    int m = paramQueryRsp.uv_flag.get();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    long l;
    if (k == 1) {
      l = paramQueryRsp.pv_timestamp.get();
    } else {
      l = 0L;
    }
    localEditor.putLong("sp_key_pv_timestamp", l).apply();
    localEditor = ((SharedPreferences)localObject).edit();
    int j = 0;
    if (m == 1) {
      i = paramQueryRsp.uv_day_freq.get();
    } else {
      i = 0;
    }
    localEditor.putInt("sp_key_day_freq", i).apply();
    localObject = ((SharedPreferences)localObject).edit();
    int i = j;
    if (m == 1) {
      i = paramQueryRsp.uv_week_freq.get();
    }
    ((SharedPreferences.Editor)localObject).putInt("sp_key_week_freq", i).apply();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveUvControl...pv_flag:");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",uv_flag:");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(",pv_timestamp:");
      ((StringBuilder)localObject).append(paramQueryRsp.pv_timestamp.get());
      ((StringBuilder)localObject).append(",uv_day_freq:");
      ((StringBuilder)localObject).append(paramQueryRsp.uv_day_freq.get());
      ((StringBuilder)localObject).append(",uv_week_freq:");
      ((StringBuilder)localObject).append(paramQueryRsp.uv_week_freq.get());
      QLog.i("QWalletGdtAdApi", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void checkReportTailAdShow()
  {
    if (this.mHasTailMsg)
    {
      String str = QWalletTools.c().getAccount();
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.tailad.show", 0, 0, "", ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(str, "walletPubMsgTail_busiType", ""), this.title, "");
    }
  }
  
  public void checkReportTailPlaceShow()
  {
    if (this.mHasTailMsg) {
      reportEvent("public.tailplace.show", "", "", "2", "");
    }
  }
  
  public void doReqAdsStatistics(int paramInt)
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    if (localBaseQQAppInterface == null) {
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doReqAdsStatistics start,adResult:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("QWalletGdtAdApi", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == 1)
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_wallet_gdt", 4);
      String str = localSharedPreferences.getString("sp_key_show_ad_times", "");
      Object localObject3 = null;
      localObject1 = localObject3;
      Object localObject2;
      if (!TextUtils.isEmpty(str)) {
        try
        {
          localObject1 = new JSONArray(str);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("QWalletGdtAdApi", 1, localThrowable, new Object[0]);
          localObject2 = localObject3;
        }
      }
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = new JSONArray();
      }
      ((JSONArray)localObject3).put(l / 1000L);
      localSharedPreferences.edit().putString("sp_key_show_ad_times", ((JSONArray)localObject3).toString()).apply();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doReqAdsStatistics recordShowTimeString:");
        ((StringBuilder)localObject2).append(((JSONArray)localObject3).toString());
        QLog.i("QWalletGdtAdApi", 2, ((StringBuilder)localObject2).toString());
      }
    }
    QwUtils.a(localBaseQQAppInterface, "tenpay.com", new QWalletGdtAdApiImpl.3(this, paramInt, localBaseQQAppInterface, l));
  }
  
  public GdtAppReceiver getAppReceiver(Context paramContext)
  {
    if (this.mGdtReceiver == null)
    {
      this.mGdtReceiver = new GdtAppReceiver();
      this.mGdtReceiver.register(paramContext);
    }
    return this.mGdtReceiver;
  }
  
  public GdtAd getGdtAd()
  {
    return this.mGdtAd;
  }
  
  public void handlePubRefreshList(List<ChatMessage> paramList)
  {
    this.mHasTailMsg = false;
    String str = QWalletTools.c().getAccount();
    this.title = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(str, "walletPubMsgTail_title", "");
    str = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(str, "walletPubMsgTail_jumpURL", "");
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      if ((!this.mHasTailMsg) && (((IStructmsgApi)QRoute.api(IStructmsgApi.class)).instanceofMessageForStructing(localChatMessage)) && ("1".equals(localChatMessage.getExtInfoFromExtStr("wallet_ad_msg"))) && ((!TextUtils.isEmpty(this.title)) || (!TextUtils.isEmpty(str))))
      {
        localChatMessage.isShowQWalletPubAd = true;
        this.mHasTailMsg = true;
      }
      else
      {
        localChatMessage.isShowQWalletPubAd = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("list,time:");
        localStringBuilder.append(TimeFormatterUtils.f(localChatMessage.time * 1000L));
        localStringBuilder.append(",isShowQWalletPubAd:");
        localStringBuilder.append(localChatMessage.isShowQWalletPubAd);
        QLog.d("QWalletGdtAdApi", 2, localStringBuilder.toString());
      }
      i -= 1;
    }
  }
  
  public void handlePubTailMsg(im_msg_body.GeneralFlags paramGeneralFlags, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (!TextUtils.isEmpty(((IStructmsgApi)QRoute.api(IStructmsgApi.class)).getBirthdayReminder(paramMessageRecord)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis());
      ((StringBuilder)localObject).append("");
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.birthmessage.receive", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {
      try
      {
        localObject = new generalflags.ResvAttr();
        ((generalflags.ResvAttr)localObject).mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if ((((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.has()) && (((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.get() != null))
        {
          paramGeneralFlags = ((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.get().toStringUtf8().trim();
          if ((paramGeneralFlags.startsWith("{")) && (paramGeneralFlags.endsWith("}")))
          {
            paramGeneralFlags = new JSONObject(paramGeneralFlags).optString("money_extra");
            if ((!TextUtils.isEmpty(paramGeneralFlags)) && (new JSONObject(paramGeneralFlags).optInt("gdt_flg") == 1))
            {
              ((IStructmsgApi)QRoute.api(IStructmsgApi.class)).handleStructMsgElement(paramMessageRecord);
              return;
            }
          }
        }
      }
      catch (Throwable paramGeneralFlags)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletGdtAdApi", 2, "parse wallet ad tail fail:", paramGeneralFlags);
        }
      }
    }
  }
  
  public void handleWhenPubEnter(QBaseActivity paramQBaseActivity, Object paramObject)
  {
    IBaseChatPieProxy localIBaseChatPieProxy = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createBaseChatPie(paramObject);
    this.mGdtAd = null;
    this.mPvFlag = 0;
    if (isDebugNoLimit())
    {
      doReqAdsControl();
      doReqAds(paramQBaseActivity, localIBaseChatPieProxy);
      return;
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("sp_wallet_gdt", 4);
    this.mPvTimestamp = (localSharedPreferences.getLong("sp_key_pv_timestamp", 0L) * 1000L);
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleWhenPubEnter...currentTime:");
      paramObject.append(l1);
      paramObject.append(",mPvTimestamp:");
      paramObject.append(this.mPvTimestamp);
      paramObject.append(",mPvFlag:");
      paramObject.append(this.mPvFlag);
      QLog.i("QWalletGdtAdApi", 2, paramObject.toString());
    }
    if (l1 < this.mPvTimestamp)
    {
      checkReportTailPlaceShow();
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdApi", 2, "handleWhenPubEnter...timeLimit,return");
      }
      return;
    }
    int n = localSharedPreferences.getInt("sp_key_day_freq", 0);
    int i1 = localSharedPreferences.getInt("sp_key_week_freq", 0);
    if ((n != 0) && (i1 != 0)) {
      break label295;
    }
    paramObject = (IQWalletConfigService)paramQBaseActivity.getAppRuntime().getRuntimeService(IQWalletConfigService.class, "");
    n = paramObject.getInt("common", 1, new String[] { "pub_ad_control", "gdt_day_freq" });
    i1 = paramObject.getInt("common", 4, new String[] { "pub_ad_control", "gdt_week_freq" });
    label295:
    paramObject = localSharedPreferences.getString("sp_key_show_ad_times", "");
    if (!TextUtils.isEmpty(paramObject)) {}
    for (;;)
    {
      int i2;
      int i3;
      int i4;
      try
      {
        paramObject = new JSONArray(paramObject);
        if (paramObject.length() > 0)
        {
          JSONArray localJSONArray = new JSONArray();
          i2 = 0;
          j = 0;
          i = 0;
          int k = j;
          int m = i;
          try
          {
            if (i2 < paramObject.length())
            {
              k = j;
              m = i;
              long l2 = paramObject.getLong(i2);
              Long.signum(l2);
              long l3 = l1 - l2 * 1000L;
              if (l3 < 604800000L)
              {
                i3 = j + 1;
                j = i;
                if (l3 < 86400000L) {
                  j = i + 1;
                }
                k = i3;
                m = j;
                localJSONArray.put(l2);
                i4 = j;
                break label773;
              }
              k = j;
              m = i;
              i3 = j;
              i4 = i;
              if (!QLog.isColorLevel()) {
                break label773;
              }
              k = j;
              m = i;
              StringBuilder localStringBuilder = new StringBuilder();
              k = j;
              m = i;
              localStringBuilder.append("handleWhenPubEnter...this time is over 1 week,just ignore,time:");
              k = j;
              m = i;
              localStringBuilder.append(l2);
              k = j;
              m = i;
              QLog.i("QWalletGdtAdApi", 2, localStringBuilder.toString());
              i3 = j;
              i4 = i;
              break label773;
            }
            k = j;
            m = i;
            localSharedPreferences.edit().putString("sp_key_show_ad_times", localJSONArray.toString()).apply();
          }
          catch (Throwable paramObject)
          {
            i = m;
            j = k;
            continue;
          }
        }
        else
        {
          i = 0;
          j = 0;
        }
      }
      catch (Throwable paramObject)
      {
        i = 0;
        j = 0;
        QLog.e("QWalletGdtAdApi", 1, paramObject, new Object[0]);
        localSharedPreferences.edit().remove("sp_key_show_ad_times").apply();
      }
      break label642;
      int j = 0;
      int i = 0;
      label642:
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleWhenPubEnter...last24HourAdCount:");
        paramObject.append(i);
        paramObject.append(",gdt_day_freq:");
        paramObject.append(n);
        paramObject.append(",last7DayAdCount:");
        paramObject.append(j);
        paramObject.append(",gdt_week_freq:");
        paramObject.append(i1);
        QLog.i("QWalletGdtAdApi", 2, paramObject.toString());
      }
      if ((i < n) && (j < i1))
      {
        doReqAdsControl();
        doReqAds(paramQBaseActivity, localIBaseChatPieProxy);
        return;
      }
      checkReportTailPlaceShow();
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdApi", 2, "handleWhenPubEnter...frequency limited,just return");
      }
      return;
      label773:
      i2 += 1;
      j = i3;
      i = i4;
    }
  }
  
  public void handleWhenPubPause()
  {
    ((IStructmsgApi)QRoute.api(IStructmsgApi.class)).notifyAdExposureCheckersPause();
  }
  
  public void handleWhenPubQuit(Context paramContext)
  {
    this.mGdtAd = null;
    this.mPvFlag = 0;
    this.mPvTimestamp = 0L;
    this.mHasTailMsg = false;
    GdtAppReceiver localGdtAppReceiver = this.mGdtReceiver;
    if (localGdtAppReceiver != null)
    {
      localGdtAppReceiver.unregister(paramContext);
      this.mGdtReceiver = null;
    }
    this.mAdLoaderListener = null;
    ((IStructmsgApi)QRoute.api(IStructmsgApi.class)).notifyAdExposureCheckersDestroy();
  }
  
  public void handleWhenPubResume()
  {
    ((IStructmsgApi)QRoute.api(IStructmsgApi.class)).notifyAdExposureCheckersResume();
  }
  
  public void reportEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    if (localBaseQQAppInterface == null) {
      return;
    }
    ReportController.b(localBaseQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void reportUrlByHttpGet(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportUrlByHttpGet...reportUrl:");
        localStringBuilder.append(paramString);
        QLog.i("QWalletGdtAdApi", 1, localStringBuilder.toString());
      }
      ThreadManager.excute(new QWalletGdtAdApiImpl.4(this, paramString), 128, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletGdtAdApiImpl
 * JD-Core Version:    0.7.0.1
 */