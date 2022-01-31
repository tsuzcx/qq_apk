package com.tencent.mobileqq.startup.step;

import ahqp;
import ahqq;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InitMagnifierSDK
  extends Step
{
  private static ArrayList a = new ArrayList(20);
  
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
      QLog.d("LeakInspector", 2, new Object[] { "report new ceiling:s= ", Long.valueOf(paramLong1), ", stage=", paramString, ", useMem=" + paramLong3 + ", cnt=" + paramInt1 });
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("LeakInspector", 1, "reportCeiling", paramString);
    }
  }
  
  public static void a(Handler paramHandler, long paramLong)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    String str;
    label22:
    Object localObject2;
    if (BaseActivity.sTopActivity != null)
    {
      str = BaseActivity.sTopActivity.getActivityName();
      localObject2 = new StringBuilder().append(str).append("@");
      if (BaseActivity.sTopActivity == null) {
        break label290;
      }
    }
    label290:
    for (Object localObject1 = Integer.valueOf(BaseActivity.sTopActivity.hashCode());; localObject1 = "")
    {
      localObject1 = localObject1;
      if (a.contains(localObject1)) {
        break;
      }
      localObject2 = new StringBuffer(512);
      Object localObject3 = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject3 instanceof QQAppInterface))
      {
        localObject3 = (QQAppInterface)localObject3;
        FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)localObject3).getManager(50);
        int i;
        if (localFriendsManager != null)
        {
          i = localFriendsManager.a();
          ((StringBuffer)localObject2).append("fc=");
          ((StringBuffer)localObject2).append(i);
          ((StringBuffer)localObject2).append("&");
        }
        localObject3 = (DiscussionManager)((QQAppInterface)localObject3).getManager(52);
        if (localObject3 != null)
        {
          i = ((DiscussionManager)localObject3).a().size();
          ((StringBuffer)localObject2).append("dc=");
          ((StringBuffer)localObject2).append(i);
          ((StringBuffer)localObject2).append("&");
          i = ((DiscussionManager)localObject3).b();
          ((StringBuffer)localObject2).append("dmc=");
          ((StringBuffer)localObject2).append(i);
          ((StringBuffer)localObject2).append("&");
        }
      }
      a(paramHandler, paramLong, (100 - MemoryConfigs.a().a) * Runtime.getRuntime().maxMemory() / 100L, str, ((StringBuffer)localObject2).toString());
      a.add(localObject1);
      return;
      str = "";
      break label22;
    }
  }
  
  public static void a(Handler paramHandler, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    paramHandler.postDelayed(new ahqp(paramString1, paramLong1, paramLong2, paramString2), 100L);
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
        QLog.d("LeakInspector", 2, "reportTOAPM : " + localJSONObject2.toString());
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LeakInspector", 2, paramJSONObject, new Object[0]);
    }
  }
  
  private static boolean b(LeakInspector.InspectUUID paramInspectUUID)
  {
    if (!AppSetting.c) {}
    return false;
  }
  
  protected boolean a()
  {
    Object localObject = "V 7.6.0." + ApkUtils.a(BaseApplicationImpl.sApplication);
    QLog.i("InitMagnifierSDK", 4, "init MagnifierSDK: process =  verson = " + (String)localObject);
    localObject = MagnifierSDK.a(ThreadManager.getSubThreadHandler(), 1, (String)localObject);
    ((MagnifierSDK)localObject).a(new ahqq());
    if (7 == BaseApplicationImpl.sProcessId)
    {
      ((MagnifierSDK)localObject).a(BaseApplicationImpl.getApplication(), 8);
      return true;
    }
    ((MagnifierSDK)localObject).a(BaseApplicationImpl.getApplication());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDK
 * JD-Core Version:    0.7.0.1
 */