package com.tencent.mobileqq.vas;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.DataReport;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.pb.vasreporter.VasReporter.ReqBody;
import com.tencent.pb.vasreporter.VasReporter.StatisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class VasMonitorHandler
  extends BusinessHandler
{
  public CopyOnWriteArrayList<String> a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  public VasMonitorHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  @Nullable
  private static QQAppInterface a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface))) {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
    } else {
      paramAppRuntime = null;
    }
    Object localObject = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      localObject = paramAppRuntime;
      if (BaseApplicationImpl.getApplication() != null)
      {
        localObject = paramAppRuntime;
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        }
      }
    }
    if (localObject == null)
    {
      paramAppRuntime = new Bundle();
      paramAppRuntime.putString("key_appid", paramString1);
      paramAppRuntime.putString("key_err_code", paramString2);
      paramAppRuntime.putString("key_log", paramString3);
      paramAppRuntime.putString("key_key4", paramString4);
      paramAppRuntime.putString("key_key5", paramString5);
      paramAppRuntime.putString("key_key6", paramString6);
      paramAppRuntime.putFloat("key_value2", paramFloat1);
      paramAppRuntime.putFloat("key_value3", paramFloat2);
      QIPCClientHelper.getInstance().getClient().callServer("VasMonitorIPCModule", "action_vas_monitor", paramAppRuntime);
      return null;
    }
    return localObject;
  }
  
  public static <T> ArrayList<T> a(T... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<String> paramArrayList, ArrayList<Float> paramArrayList1, String paramString2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uip:");
      ((StringBuilder)localObject).append(DataReport.k());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportOrg appid=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", keys=");
        ((StringBuilder)localObject).append(paramArrayList);
        ((StringBuilder)localObject).append(", values=");
        ((StringBuilder)localObject).append(paramArrayList1);
        ((StringBuilder)localObject).append(", log=");
        ((StringBuilder)localObject).append(paramString2);
        QLog.e("VasMonitorHandler", 2, ((StringBuilder)localObject).toString());
      }
      if (paramQQAppInterface == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("report args0 Error appInterface=null, appid=");
        paramQQAppInterface.append(paramString1);
        paramQQAppInterface.append(", keys=");
        paramQQAppInterface.append(paramArrayList);
        paramQQAppInterface.append(", values=");
        paramQQAppInterface.append(paramArrayList1);
        paramQQAppInterface.append(", log=");
        paramQQAppInterface.append(paramString2);
        QLog.e("VasMonitorHandler", 2, paramQQAppInterface.toString());
        return;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (paramArrayList != null) && (paramArrayList1 != null))
      {
        localObject = new VasReporter.StatisInfo();
        ((VasReporter.StatisInfo)localObject).appid.set(paramString1);
        ((VasReporter.StatisInfo)localObject).key_list.set(paramArrayList);
        ((VasReporter.StatisInfo)localObject).value_list.set(paramArrayList1);
        ((VasReporter.StatisInfo)localObject).ts.set(System.currentTimeMillis() / 1000L);
        ((VasReporter.StatisInfo)localObject).msg.set(paramString2);
        paramArrayList = new VasReporter.ReqBody();
        paramArrayList.cmd.set(1);
        paramArrayList.plat.set(109);
        paramArrayList.qqversion.set("8.7.0.5295");
        paramArrayList.osversion.set(Build.VERSION.RELEASE);
        paramArrayList.statis_list.set(a(new VasReporter.StatisInfo[] { localObject }));
        paramArrayList.setHasFlag(true);
        paramArrayList1 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "gxhreport.report");
        paramArrayList1.putWupBuffer(paramArrayList.toByteArray());
        ((VasMonitorHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_MONITOR_HANDLER)).sendPbReq(paramArrayList1);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("send reportOrg appid=");
          paramQQAppInterface.append(paramString1);
          paramQQAppInterface.append(", log=");
          paramQQAppInterface.append(paramString2);
          QLog.e("VasMonitorHandler", 2, paramQQAppInterface.toString());
        }
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("report args Error appid=");
        paramQQAppInterface.append(paramString1);
        paramQQAppInterface.append(", keys=");
        paramQQAppInterface.append(paramArrayList);
        paramQQAppInterface.append(", values=");
        paramQQAppInterface.append(paramArrayList1);
        paramQQAppInterface.append(", log=");
        paramQQAppInterface.append(paramString2);
        QLog.e("VasMonitorHandler", 2, paramQQAppInterface.toString());
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportOrg err:");
      paramString1.append(paramQQAppInterface.toString());
      QLog.e("VasMonitorHandler", 2, paramString1.toString());
    }
    return;
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, null, null, paramFloat, 0.0F);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, float paramFloat1, float paramFloat2)
  {
    QQAppInterface localQQAppInterface = a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramFloat1, paramFloat2);
    if (localQQAppInterface == null) {
      return;
    }
    paramAppRuntime = (VasMonitorHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_MONITOR_HANDLER);
    if (!paramAppRuntime.b.get()) {
      paramAppRuntime.a(localQQAppInterface, false);
    }
    if (paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("report stop all report appid=");
        paramAppRuntime.append(paramString1);
        paramAppRuntime.append(", errCode=");
        paramAppRuntime.append(paramString2);
        paramAppRuntime.append(", log=");
        paramAppRuntime.append(paramString3);
        paramAppRuntime.append(", key4=");
        paramAppRuntime.append(paramString4);
        paramAppRuntime.append(", value2=");
        paramAppRuntime.append(paramFloat1);
        QLog.d("VasMonitorHandler", 2, paramAppRuntime.toString());
      }
      return;
    }
    if (paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString1))
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("report appid in appidBlackList appid=");
        paramAppRuntime.append(paramString1);
        paramAppRuntime.append(", errCode=");
        paramAppRuntime.append(paramString2);
        paramAppRuntime.append(", log=");
        paramAppRuntime.append(paramString3);
        paramAppRuntime.append(", key4=");
        paramAppRuntime.append(paramString4);
        paramAppRuntime.append(", value2=");
        paramAppRuntime.append(paramFloat1);
        QLog.d("VasMonitorHandler", 2, paramAppRuntime.toString());
      }
      return;
    }
    VasWebviewUtil.a(localQQAppInterface.getCurrentAccountUin(), "MIGReport", paramString1, "", 1, 0, 0, paramString2, paramString3, paramString4, paramString5, paramString6, String.valueOf(paramFloat1), String.valueOf(paramFloat2), 0, 0, 0, 0);
    String str = "";
    if (paramString4 == null) {
      paramAppRuntime = "";
    } else {
      paramAppRuntime = paramString4;
    }
    if (paramString5 == null) {
      paramString4 = "";
    } else {
      paramString4 = paramString5;
    }
    if (paramString6 == null) {
      paramString6 = str;
    }
    ThreadManager.post(new VasMonitorHandler.1(localQQAppInterface, paramString1, a(new String[] { "109", "8.7.0", paramString2, paramAppRuntime, paramString4, paramString6 }), a(new Float[] { Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }), paramString3), 5, null, false);
    paramString4 = new StringBuilder();
    paramString4.append("report err appid=");
    paramString4.append(paramString1);
    paramString4.append(", errCode=");
    paramString4.append(paramString2);
    paramString4.append(", log=");
    paramString4.append(paramString3);
    paramString4.append(", key4=");
    paramString4.append(paramAppRuntime);
    paramString4.append(", value2=");
    paramString4.append(paramFloat1);
    QLog.e("VasMonitorHandler", 1, paramString4.toString());
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    this.b.set(true);
    ThreadManager.post(new VasMonitorHandler.2(this, paramAppRuntime, paramBoolean), 8, null, true);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"gxhreport.report".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("onReceive res.isSuccess=");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      paramToServiceMsg.append(",data=");
      paramToServiceMsg.append(PkgTools.toHexStr((byte[])paramObject));
      QLog.i("VasMonitorHandler", 2, paramToServiceMsg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasMonitorHandler
 * JD-Core Version:    0.7.0.1
 */