package com.tencent.mobileqq.vas;

import ajtu;
import ajtv;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.DataReport;
import com.tencent.mobileqq.app.BusinessHandler;
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

public class VasMonitorHandler
  extends BusinessHandler
{
  public CopyOnWriteArrayList a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  public VasMonitorHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static ArrayList a(Object... paramVarArgs)
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString2)
  {
    try
    {
      paramString2 = "uip:" + DataReport.k() + ", " + paramString2;
      QLog.e("VasMonitorHandler", 1, "reportOrg appid=" + paramString1 + ", keys=" + paramArrayList1 + ", values=" + paramArrayList2 + ", log=" + paramString2);
      if (paramQQAppInterface == null)
      {
        QLog.e("VasMonitorHandler", 2, "report args0 Error appInterface=null, appid=" + paramString1 + ", keys=" + paramArrayList1 + ", values=" + paramArrayList2 + ", log=" + paramString2);
        return;
      }
      if ((TextUtils.isEmpty(paramString1)) || (paramArrayList1 == null) || (paramArrayList2 == null))
      {
        QLog.e("VasMonitorHandler", 2, "report args Error appid=" + paramString1 + ", keys=" + paramArrayList1 + ", values=" + paramArrayList2 + ", log=" + paramString2);
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("VasMonitorHandler", 2, "reportOrg err:" + paramQQAppInterface.toString());
      return;
    }
    VasReporter.StatisInfo localStatisInfo = new VasReporter.StatisInfo();
    localStatisInfo.appid.set(paramString1);
    localStatisInfo.key_list.set(paramArrayList1);
    localStatisInfo.value_list.set(paramArrayList2);
    localStatisInfo.ts.set(System.currentTimeMillis() / 1000L);
    localStatisInfo.msg.set(paramString2);
    paramArrayList1 = new VasReporter.ReqBody();
    paramArrayList1.cmd.set(1);
    paramArrayList1.plat.set(109);
    paramArrayList1.qqversion.set("7.6.0.3525");
    paramArrayList1.osversion.set(Build.VERSION.RELEASE);
    paramArrayList1.statis_list.set(a(new VasReporter.StatisInfo[] { localStatisInfo }));
    paramArrayList1.setHasFlag(true);
    paramArrayList2 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "gxhreport.report");
    paramArrayList2.putWupBuffer(paramArrayList1.toByteArray());
    ((VasMonitorHandler)paramQQAppInterface.a(103)).b(paramArrayList2);
    if (QLog.isColorLevel()) {
      QLog.e("VasMonitorHandler", 2, "send reportOrg appid=" + paramString1 + ", log=" + paramString2);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, null, null, paramFloat, 0.0F);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface))) {}
        for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
        {
          localObject = paramAppRuntime;
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
          if (localObject != null) {
            break;
          }
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
          return;
        }
        paramAppRuntime = (VasMonitorHandler)((QQAppInterface)localObject).a(103);
        if (!paramAppRuntime.b.get()) {
          paramAppRuntime.a((AppRuntime)localObject, false);
        }
        if (!paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VasMonitorHandler", 2, "report stop all report appid=" + paramString1 + ", errCode=" + paramString2 + ", log=" + paramString3 + ", key4=" + paramString4 + ", value2=" + paramFloat1);
      return;
      if (!paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VasMonitorHandler", 2, "report appid in appidBlackList appid=" + paramString1 + ", errCode=" + paramString2 + ", log=" + paramString3 + ", key4=" + paramString4 + ", value2=" + paramFloat1);
    return;
    paramAppRuntime = paramString4;
    if (paramString4 == null) {
      paramAppRuntime = "";
    }
    paramString4 = paramString5;
    if (paramString5 == null) {
      paramString4 = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    ThreadManager.post(new ajtu((QQAppInterface)localObject, paramString1, a(new String[] { "109", "7.6.0", paramString2, paramAppRuntime, paramString4, paramString5 }), a(new Float[] { Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }), paramString3), 5, null, false);
    QLog.e("VasMonitorHandler", 1, "report err appid=" + paramString1 + ", errCode=" + paramString2 + ", log=" + paramString3 + ", key4=" + paramAppRuntime + ", value2=" + paramFloat1);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"gxhreport.report".equals(paramFromServiceMsg.getServiceCmd())) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("VasMonitorHandler", 2, "onReceive res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + PkgTools.a((byte[])paramObject));
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    this.b.set(true);
    ThreadManager.post(new ajtv(this, paramAppRuntime, paramBoolean), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasMonitorHandler
 * JD-Core Version:    0.7.0.1
 */