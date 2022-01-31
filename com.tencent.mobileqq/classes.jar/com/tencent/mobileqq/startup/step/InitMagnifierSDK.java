package com.tencent.mobileqq.startup.step;

import abqn;
import almv;
import aloz;
import alrv;
import amfn;
import android.os.Handler;
import aowf;
import azju;
import bjqj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InitMagnifierSDK
  extends Step
{
  private static ArrayList<String> a = new ArrayList(20);
  
  public static String a()
  {
    return "V 8.3.3." + aowf.a(BaseApplicationImpl.sApplication) + ".r" + AppSetting.g();
  }
  
  @NotNull
  public static List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(abqn.b());
    localArrayList.add(abqn.a());
    localArrayList.addAll(abqn.b());
    QLog.i("QQ_QAPM", 1, "leakDump" + paramString);
    return localArrayList;
  }
  
  public static void a(long paramLong) {}
  
  public static void a(long paramLong1, long paramLong2, String paramString, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("newPlugin", 135);
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("category", "ceiling_rate");
      localJSONObject2.put("s", paramLong1);
      localJSONObject2.put("e", paramLong2);
      localJSONObject2.put("ceiling_stage", paramString);
      localJSONObject2.put("used_mem_max", paramLong3);
      localJSONObject2.put("total_mem", paramLong4);
      localJSONObject2.put("device_total_mem", paramLong5);
      localJSONObject2.put("device_left_mem", paramLong6);
      localJSONObject2.put("ceiling_cnt", paramInt1);
      localJSONObject2.put("extra", paramInt2);
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("parts", localJSONArray);
      ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, localJSONObject1, true, true, MagnifierSDK.a));
      QLog.d("QQ_QAPM", 2, new Object[] { "report new ceiling:s= ", Long.valueOf(paramLong1), ", stage=", paramString, ", useMem=" + paramLong3 + ", cnt=" + paramInt1 });
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQ_QAPM", 1, "reportCeiling", paramString);
    }
  }
  
  public static void a(Handler paramHandler, long paramLong)
  {
    String str;
    Object localObject2;
    if (2 == BaseApplicationImpl.sProcessId)
    {
      str = bjqj.c();
      localObject1 = str + bjqj.a();
      if (!a.contains(localObject1))
      {
        localObject2 = new StringBuffer(512);
        localObject3 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject3 instanceof QQAppInterface))
        {
          localObject3 = (QQAppInterface)localObject3;
          localaloz = (aloz)((QQAppInterface)localObject3).getManager(51);
          if (localaloz != null)
          {
            i = localaloz.a();
            ((StringBuffer)localObject2).append("fc=");
            ((StringBuffer)localObject2).append(i);
            ((StringBuffer)localObject2).append("&");
          }
          localObject3 = (almv)((QQAppInterface)localObject3).getManager(53);
          if (localObject3 != null)
          {
            i = ((almv)localObject3).a().size();
            ((StringBuffer)localObject2).append("dc=");
            ((StringBuffer)localObject2).append(i);
            ((StringBuffer)localObject2).append("&");
            i = ((almv)localObject3).b();
            ((StringBuffer)localObject2).append("dmc=");
            ((StringBuffer)localObject2).append(i);
            ((StringBuffer)localObject2).append("&");
          }
        }
        a(paramHandler, paramLong, (100 - alrv.a().a) * Runtime.getRuntime().maxMemory() / 100L, str, ((StringBuffer)localObject2).toString());
        a(paramLong);
        a.add(localObject1);
      }
    }
    while (1 != BaseApplicationImpl.sProcessId)
    {
      Object localObject3;
      aloz localaloz;
      int i;
      return;
    }
    if (BaseActivity.sTopActivity != null)
    {
      str = BaseActivity.sTopActivity.getActivityName();
      label273:
      localObject2 = new StringBuilder().append(str).append("@");
      if (BaseActivity.sTopActivity == null) {
        break label333;
      }
    }
    label333:
    for (Object localObject1 = Integer.valueOf(BaseActivity.sTopActivity.hashCode());; localObject1 = "")
    {
      localObject1 = localObject1;
      break;
      str = "";
      break label273;
    }
  }
  
  public static void a(Handler paramHandler, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    int i = 1;
    if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 2)) {}
    for (;;)
    {
      return;
      if (Math.random() < 0.1000000014901161D) {}
      while (i != 0)
      {
        paramHandler.postDelayed(new InitMagnifierSDK.1(paramString1, paramLong1, paramLong2, paramString2), 100L);
        return;
        i = 0;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, long paramLong)
  {
    try
    {
      paramJSONObject.put("MemorySize", paramLong);
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("p_id", MagnifierSDK.a());
      localJSONObject1.put("plugin", String.valueOf(22));
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("memorydata", paramJSONObject);
      localJSONObject2.put("clientinfo", localJSONObject1);
      localJSONObject2.put("newplugin", 129);
      ReporterMachine.a(new ResultObject(0, "testcase", false, 1L, 1L, localJSONObject2, true, true, MagnifierSDK.a));
      if (QLog.isColorLevel()) {
        QLog.d("QQ_QAPM", 2, "reportTOAPM : " + localJSONObject2.toString());
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQ_QAPM", 2, paramJSONObject, new Object[0]);
    }
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    QLog.i("QQ_QAPM", 1, "finishDump" + paramString1 + paramString2);
  }
  
  public static boolean a(LeakInspector.InspectUUID paramInspectUUID)
  {
    if (paramInspectUUID != null) {}
    try
    {
      if (paramInspectUUID.weakObj != null) {
        MemoryManager.a().a(paramInspectUUID.weakObj.get());
      }
      label24:
      if (!AppSetting.d) {}
      return false;
    }
    catch (Exception paramInspectUUID)
    {
      break label24;
    }
  }
  
  public static boolean a(Object paramObject)
  {
    return !amfn.a().a;
  }
  
  protected boolean doStep()
  {
    Object localObject = a();
    QLog.i("InitMagnifierSDK", 4, "init MagnifierSDK: process = " + BaseApplicationImpl.sProcessId + " verson = " + (String)localObject);
    if (10 == BaseApplicationImpl.sProcessId) {}
    for (int i = Integer.parseInt(MagnifierSDK.a());; i = 1)
    {
      localObject = MagnifierSDK.a(ThreadManager.getSubThreadHandler(), i, (String)localObject);
      ((MagnifierSDK)localObject).a(new azju());
      if (7 == BaseApplicationImpl.sProcessId)
      {
        ((MagnifierSDK)localObject).a(BaseApplicationImpl.getApplication(), 9);
        return true;
      }
      if (10 == BaseApplicationImpl.sProcessId)
      {
        ((MagnifierSDK)localObject).a(BaseApplicationImpl.getApplication(), 57);
        return true;
      }
      ((MagnifierSDK)localObject).a(BaseApplicationImpl.getApplication());
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDK
 * JD-Core Version:    0.7.0.1
 */