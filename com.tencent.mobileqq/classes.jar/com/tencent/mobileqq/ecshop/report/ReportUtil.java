package com.tencent.mobileqq.ecshop.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.abtest.ABTestInfo;
import com.tencent.mobileqq.ecshop.abtest.ABTestUtil;
import com.tencent.mobileqq.ecshop.conf.QQShopFakeUrlHelper;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ReportUtil
{
  private static final byte[] b = new byte[0];
  private static volatile ReportUtil c;
  public CopyOnWriteArraySet<Long> a = new CopyOnWriteArraySet();
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000004B5DU3Q3LD1"));
  }
  
  public static ReportUtil a()
  {
    if (c == null) {
      synchronized (b)
      {
        if (c == null) {
          c = new ReportUtil();
        }
      }
    }
    return c;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    Object localObject = QQShopFakeUrlHelper.a(EcshopUtils.a(paramMessageRecord));
    if (!StringUtil.isEmpty((String)localObject)) {
      paramMessageRecord = EcshopUtils.a((String)localObject, EcshopUtils.d(EcshopUtils.b(paramMessageRecord)), false);
    } else {
      paramMessageRecord = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wrapPushReport: ");
    ((StringBuilder)localObject).append(paramMessageRecord);
    QLog.i("ReportUtil", 2, ((StringBuilder)localObject).toString());
    return paramMessageRecord;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2;
    if (StringUtil.isEmpty(paramString2)) {
      str = "tab";
    }
    paramString2 = new HashMap(1);
    paramString2.put("_source", str);
    return EcshopUtils.a(paramString1, paramString2, false);
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(String paramString)
  {
    try
    {
      Object localObject1 = ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getAIOList("3046055438", 1008);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
        int i = 0;
        try
        {
          int j = Integer.parseInt(((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType((MessageRecord)localObject1));
          i = j;
        }
        catch (Exception localException)
        {
          QLog.e("ReportUtil", 1, localException, new Object[0]);
        }
        Object localObject2 = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getStructMsgContentTitle((MessageRecord)localObject1);
        Object localObject3;
        if (localObject2 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(NetConnInfoCenter.getServerTimeMillis());
          ((StringBuilder)localObject3).append("");
          a(paramString, (String)localObject2, ((StringBuilder)localObject3).toString(), "", i);
          paramString = a((MessageRecord)localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(NetConnInfoCenter.getServerTimeMillis());
          ((StringBuilder)localObject1).append("");
          b("qgg_push_click", (String)localObject2, ((StringBuilder)localObject1).toString(), paramString, i);
          return;
        }
        localObject2 = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getSourceAdFromArk((MessageRecord)localObject1);
        if (localObject2 != null)
        {
          localObject3 = ((JSONObject)localObject2).optString("aio_desc_name");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
          localStringBuilder.append("");
          a(paramString, (String)localObject3, localStringBuilder.toString(), "", i);
          paramString = a((MessageRecord)localObject1);
          localObject1 = ((JSONObject)localObject2).optString("aio_desc_name");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTimeMillis());
          ((StringBuilder)localObject2).append("");
          b("qgg_push_click", (String)localObject1, ((StringBuilder)localObject2).toString(), paramString, i);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramString));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, 0);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s__fromType: %s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) }));
    }
    try
    {
      ReportController.b(AppUtils.a(), "P_CliOper", "Vip_pay_mywallet", "", paramString2, paramString1, paramInt, 0, paramString4, paramString3, "android", "8.8.17");
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramString1));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    a(paramString1, paramString2, paramString3, paramString4, paramString5, "", "", paramString6, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    try
    {
      String str = b();
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s__abTestInfo: %s__fromType: %s", new Object[] { paramString1, paramString2, paramString3, paramString4, str, paramString7 }));
      }
      a("Vip_pay_mywallet", paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, str, paramString7);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramString1));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", paramString1);
    localHashMap.put("op_type", paramString3);
    localHashMap.put("op_in", paramString9);
    localHashMap.put("ext1", paramString5);
    localHashMap.put("pvsrc", paramString6);
    localHashMap.put("ext10", paramString7);
    localHashMap.put("ext15", paramString8);
    localHashMap.put("pvid", paramString4);
    localHashMap.put("plat", "android");
    localHashMap.put("version", "8.8.17");
    localHashMap.put("A8", AppUtils.a().getCurrentAccountUin());
    a(paramString2, localHashMap);
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if ((AppUtils.a() instanceof BaseQQAppInterface))
      {
        UserAction.onUserActionToTunnel("000004B5DU3Q3LD1", paramString, true, -1L, -1L, paramHashMap, true, true);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("key_report_event", paramString);
      localBundle.putSerializable("key_report_params", paramHashMap);
      QIPCClientHelper.getInstance().callServer("EcshopIPCModule", "reportToBeacon", localBundle, null);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ReportUtil", 1, paramString, new Object[0]);
    }
  }
  
  public static String b()
  {
    Object localObject = ABTestUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ABTestInfo localABTestInfo = (ABTestInfo)((Iterator)localObject).next();
      if (localABTestInfo != null)
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("##");
        }
        if (!TextUtils.isEmpty(localABTestInfo.c)) {
          localStringBuilder.append(localABTestInfo.c);
        }
        localStringBuilder.append(">");
        if (!TextUtils.isEmpty(localABTestInfo.e)) {
          localStringBuilder.append(localABTestInfo.e);
        }
        localStringBuilder.append(">");
        if (!TextUtils.isEmpty(localABTestInfo.a())) {
          localStringBuilder.append(localABTestInfo.a());
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b(paramString1, paramString2, paramString3, paramString4, 0);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    try
    {
      String str = b();
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s__abTestInfo: %s__fromType: %s", new Object[] { paramString1, paramString2, paramString3, paramString4, str, Integer.valueOf(paramInt) }));
      }
      a("Vip_pay_mywallet", paramString1, paramString2, paramString3, paramString4, str, paramInt);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.report.ReportUtil
 * JD-Core Version:    0.7.0.1
 */