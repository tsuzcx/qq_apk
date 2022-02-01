package com.tencent.mobileqq.ecshop.ad;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.abtest.ABTestUtil;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieDelegate;
import com.tencent.mobileqq.ecshop.api.IEcshopService;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.DateUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;
import tencent.im.oidb.qqshop.qq_ad.QQAdReport;
import tencent.im.oidb.qqshop.qq_ad.QQAdReportRsp;

public class EcshopAdHandler
  extends BusinessHandler
  implements IEcshopAdHandler
{
  public static int c = 300000;
  long a;
  String b;
  public boolean d;
  public long e;
  private WeakReference<IEcshopChatPieDelegate> f;
  
  public EcshopAdHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    ThreadManagerV2.excute(new EcshopAdHandler.1(this), 16, null, false);
  }
  
  public static IEcshopAdHandler.ReportInfo a(IEcshopAdHandler.ReportInfo paramReportInfo, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return paramReportInfo;
    }
    String str2 = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
    Object localObject3 = paramMessageRecord.getExtInfoFromExtStr("gdt_msgClick");
    String str1 = "0";
    String str3 = paramMessageRecord.getExtInfoFromExtStr("gdt_view_id");
    Object localObject1 = str1;
    Object localObject2;
    try
    {
      localObject3 = new JSONObject((String)localObject3);
      localObject1 = str1;
      str1 = ((JSONObject)localObject3).optString("ad_id");
      localObject1 = str1;
      localObject3 = ((JSONObject)localObject3).optString("key");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Ecshop_EcshopAdHandler", 2, "addAdParams error:", localException);
      }
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    try
    {
      paramReportInfo.s = Long.parseLong(paramMessageRecord.senderuin.trim());
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Ecshop_EcshopAdHandler", 2, "add puin error:", paramMessageRecord);
      }
    }
    paramReportInfo.u = localObject2;
    paramReportInfo.b = str3;
    paramReportInfo.v = str2;
    paramReportInfo.c = ((String)localObject1);
    paramReportInfo.w = 0;
    return paramReportInfo;
  }
  
  public static void a(AppInterface paramAppInterface, ChatMessage paramChatMessage, View paramView)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--> bindViewForGdtReport,uin:");
        localStringBuilder.append(paramChatMessage.senderuin);
        QLog.d("Ecshop_EcshopAdHandler", 1, localStringBuilder.toString());
      }
      if (!((IEcshopService)paramAppInterface.getRuntimeService(IEcshopService.class, "")).isInWalletReportList(paramChatMessage.senderuin)) {
        return;
      }
      paramChatMessage = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getAdInfoByChatMessage(paramChatMessage);
      if (paramChatMessage != null)
      {
        paramView.setTag(2131449865, new GdtAd(paramChatMessage));
        paramView.setTag(2131449864, new EcshopAdHandler.2(paramAppInterface));
        return;
      }
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("bindViewForGdtReport:");
      paramChatMessage.append(paramAppInterface.getStackTrace().toString());
      QLog.d("Ecshop_EcshopAdHandler", 1, paramChatMessage.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("On Running Foreground,login?");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",current interval:");
      localStringBuilder.append(c);
      QLog.i("Ecshop_EcshopAdHandler", 2, localStringBuilder.toString());
    }
    if (!this.d) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.e > c)
    {
      this.e = l;
      a(null, null, false, null, 3);
    }
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    IEcshopAdHandler.ReportInfo localReportInfo = new IEcshopAdHandler.ReportInfo();
    localReportInfo.a = paramInt;
    a(localReportInfo, paramMessageRecord);
    a(localReportInfo, null);
  }
  
  public void a(IEcshopAdHandler.ReportInfo paramReportInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("do ad report info:");
      ((StringBuilder)localObject1).append(paramReportInfo.toString());
      QLog.i("Ecshop_EcshopAdHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = "trpc.qqshop.adreport.ReportService.AdReport";
    } else {
      Cmd2HandlerMapHelper.a(paramString, new String[] { EcshopAdHandler.class.getName() });
    }
    qq_ad.QQAdReport localQQAdReport = new qq_ad.QQAdReport();
    localQQAdReport.type.set(paramReportInfo.a);
    Object localObject2 = localQQAdReport.view_id;
    Object localObject1 = paramReportInfo.b;
    String str = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.b;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.trace_id;
    if (paramReportInfo.c == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.c;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localQQAdReport.act_time.set((int)(System.currentTimeMillis() / 1000L));
    localObject2 = localQQAdReport.sns_uid;
    if (paramReportInfo.d == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.d;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.resolution;
    if (paramReportInfo.e == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.e;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.referer;
    if (paramReportInfo.f == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.f;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.user_agent;
    if (paramReportInfo.g == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.g;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.q_user_agent;
    if (paramReportInfo.h == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.h;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localQQAdReport.feeds_index.set(paramReportInfo.i);
    localQQAdReport.is_impression.set(paramReportInfo.j);
    localQQAdReport.is_installed.set(paramReportInfo.k);
    localObject2 = localQQAdReport.feeds_video_attachment;
    if (paramReportInfo.l == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.l;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localQQAdReport.platform_id.set(109);
    localObject2 = localQQAdReport.imei;
    if (MobileInfoUtil.getImei() == null) {
      localObject1 = "";
    } else {
      localObject1 = MobileInfoUtil.getImei();
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.click_source;
    if (paramReportInfo.m == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.m;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.antispam_info;
    if (paramReportInfo.n == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.n;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = DeviceInfoUtil.d(MobileQQ.getContext());
    PBStringField localPBStringField = localQQAdReport.hardware_addr;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localPBStringField.set((String)localObject1);
    localQQAdReport.stay_time.set(paramReportInfo.o);
    localQQAdReport.net_type.set(HttpUtil.getNetWorkType());
    localQQAdReport.client_id.set(paramReportInfo.p);
    localQQAdReport.action_id.set(paramReportInfo.q);
    localQQAdReport.msg_floor.set(paramReportInfo.r);
    localQQAdReport.puin.set(paramReportInfo.s);
    localQQAdReport.ad_puin.set(paramReportInfo.t);
    localQQAdReport.version.set("8.8.17");
    localObject2 = localQQAdReport.ad_id;
    if (paramReportInfo.u == null) {
      localObject1 = "";
    } else {
      localObject1 = paramReportInfo.u;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localQQAdReport.msgid;
    if (paramReportInfo.v == null) {
      localObject1 = str;
    } else {
      localObject1 = paramReportInfo.v;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localQQAdReport.get_back.set(false);
    localQQAdReport.source.set(paramReportInfo.w);
    paramReportInfo = new ToServiceMsg("mobileqq.service", AppUtils.a().getCurrentUin(), paramString);
    paramReportInfo.putWupBuffer(localQQAdReport.toByteArray());
    super.sendPbReq(paramReportInfo);
  }
  
  public void a(IEcshopChatPieDelegate paramIEcshopChatPieDelegate)
  {
    this.f = new WeakReference(paramIEcshopChatPieDelegate);
  }
  
  public void a(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pull ad pos:");
      ((StringBuilder)localObject1).append(paramList);
      ((StringBuilder)localObject1).append(",count:");
      ((StringBuilder)localObject1).append(paramList1);
      ((StringBuilder)localObject1).append(",syn:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("Ecshop_EcshopAdHandler", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = DateUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("currentTs:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("Ecshop_EcshopAdHandler", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(AppUtils.a().getCurrentAccountUin(), "risk_ad_del_time", (String)localObject1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cacheTs:");
        localStringBuilder.append((String)localObject2);
        QLog.i("Ecshop_EcshopAdHandler", 2, localStringBuilder.toString());
      }
      if (!((String)localObject1).equals(localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopAdHandler", 2, "---removeRiskAids---");
        }
        ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).removeSp(AppUtils.a().getCurrentAccountUin(), "risk_ids");
      }
      if (TextUtils.isEmpty(paramString)) {
        paramString = "trpc.qqshop.adpush.PushService.GetAd";
      } else {
        this.b = paramString;
      }
      ThreadManagerV2.excute(new EcshopAdHandler.3(this, paramInt, paramList, paramList1, paramBoolean, paramString), 16, null, false);
      return;
    }
    catch (Exception paramList)
    {
      paramList1 = new StringBuilder();
      paramList1.append("pullAd failed err msg: ");
      paramList1.append(paramList.getMessage());
      QLog.e("Ecshop_EcshopAdHandler", 1, paramList1.toString());
    }
  }
  
  public void a(qq_ad.QQAdGetRsp paramQQAdGetRsp)
  {
    if ((paramQQAdGetRsp.del_aid.has()) && (paramQQAdGetRsp.del_aid.has()))
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        localObject = (IEcshopChatPieDelegate)((WeakReference)localObject).get();
        if (localObject != null) {
          ((IEcshopChatPieDelegate)localObject).a(paramQQAdGetRsp.del_aid.get());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.d = paramBoolean;
    this.e = paramLong;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return EcshopAdObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((!"trpc.qqshop.adpush.PushService.GetAd".equals(paramToServiceMsg.getServiceCmd())) && ((TextUtils.isEmpty(this.b)) || (!this.b.equals(paramToServiceMsg.getServiceCmd()))))
    {
      paramToServiceMsg = new qq_ad.QQAdReportRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!QLog.isColorLevel()) {
          return;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("rsp:");
        paramFromServiceMsg.append(JSONUtils.a(paramToServiceMsg));
        QLog.i("Ecshop_EcshopAdHandler", 2, paramFromServiceMsg.toString());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("Ecshop_EcshopAdHandler", 2, "Report error:", paramToServiceMsg);
        return;
      }
    }
    else
    {
      paramToServiceMsg = new qq_ad.QQAdGetRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramToServiceMsg.tab_policy.get();
        if (!TextUtils.isEmpty(paramFromServiceMsg)) {
          ABTestUtil.a(paramFromServiceMsg);
        }
        paramFromServiceMsg = paramToServiceMsg.red_point.get();
        if (paramFromServiceMsg != null) {
          QQShopRedPointUtil.a(paramFromServiceMsg);
        }
        a(paramToServiceMsg);
        notifyUI(1, true, paramToServiceMsg);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        notifyUI(2, false, paramToServiceMsg);
        QLog.e("Ecshop_EcshopAdHandler", 2, "Get ad error:", paramFromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.EcshopAdHandler
 * JD-Core Version:    0.7.0.1
 */