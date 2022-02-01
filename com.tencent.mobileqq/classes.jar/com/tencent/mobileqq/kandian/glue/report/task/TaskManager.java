package com.tencent.mobileqq.kandian.glue.report.task;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskManager
{
  public static int a = -1;
  private static long jdField_a_of_type_Long = 0L;
  private static TaskManager jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTaskManager = new TaskManager();
  private static String jdField_a_of_type_JavaLangString;
  private static List<String> jdField_a_of_type_JavaUtilList;
  public static boolean a = false;
  private static long jdField_b_of_type_Long = 3600000L;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  private static String jdField_c_of_type_JavaLangString;
  private static String d;
  private static String e;
  private static String f;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new TaskManager.1(this);
  private ArrayList<Task> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    try
    {
      jdField_a_of_type_Boolean = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(OfflineEnvHelper.a("3412"));
      localStringBuilder.append("3412");
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/extraction");
      jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/process");
      jdField_c_of_type_JavaLangString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/distribution");
      d = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/check");
      e = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/task_config");
      f = localStringBuilder.toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.taskmanager", 2, localThrowable.getLocalizedMessage());
    }
  }
  
  private TaskManager()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.2(this));
  }
  
  @NotNull
  private JSContext.Callback a()
  {
    return new TaskManager.8(this);
  }
  
  @NotNull
  private JSContext.Callback a(Task paramTask)
  {
    return new TaskManager.14(this, paramTask);
  }
  
  private Task a(File paramFile)
  {
    return a(FileUtils.readFileContent(paramFile));
  }
  
  private Task a(String paramString)
  {
    paramString = new JSONObject(paramString);
    JSONArray localJSONArray1 = paramString.optJSONArray("filter");
    JSONArray localJSONArray2 = paramString.optJSONArray("extraction");
    JSONArray localJSONArray3 = paramString.optJSONArray("process");
    JSONArray localJSONArray4 = paramString.optJSONArray("distribution");
    JSONArray localJSONArray5 = paramString.optJSONArray("check");
    Task localTask = new Task();
    localTask.jdField_a_of_type_OrgJsonJSONObject = paramString;
    localTask.jdField_a_of_type_JavaLangString = paramString.optString("id");
    int j = 0;
    int i;
    if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
    {
      i = 0;
      while (i < localJSONArray1.length())
      {
        a(localTask.jdField_a_of_type_JavaUtilArrayList, (JSONObject)localJSONArray1.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
    {
      i = 0;
      while (i < localJSONArray2.length())
      {
        a(localTask.jdField_b_of_type_JavaUtilArrayList, (JSONObject)localJSONArray2.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray3 != null) && (localJSONArray3.length() > 0))
    {
      i = 0;
      while (i < localJSONArray3.length())
      {
        a(localTask.jdField_c_of_type_JavaUtilArrayList, (JSONObject)localJSONArray3.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray4 != null) && (localJSONArray4.length() > 0))
    {
      i = 0;
      while (i < localJSONArray4.length())
      {
        a(localTask.jdField_d_of_type_JavaUtilArrayList, (JSONObject)localJSONArray4.opt(i));
        i += 1;
      }
    }
    if ((localJSONArray5 != null) && (localJSONArray5.length() > 0))
    {
      i = j;
      while (i < localJSONArray5.length())
      {
        a(localTask.jdField_e_of_type_JavaUtilArrayList, (JSONObject)localJSONArray5.opt(i));
        i += 1;
      }
    }
    return localTask;
  }
  
  public static TaskManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTaskManager;
  }
  
  public static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", "NetworkEvent");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis() / 1000L);
      ((StringBuilder)localObject).append("");
      localJSONObject.put("timestamp", ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", paramString);
      if (paramString.equals("WIFI"))
      {
        paramString = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
        if (paramString != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checknetinfo get wifi ssid ");
            localStringBuilder.append(paramString.getSSID());
            QLog.d("kandianreport.taskmanager", 2, localStringBuilder.toString());
          }
          ((JSONObject)localObject).put("info", paramString.getBSSID());
        }
      }
      localJSONObject.put("data", localObject);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  private String a(ArrayList<String> paramArrayList)
  {
    Object localObject1 = "[";
    Object localObject2 = localObject1;
    if (paramArrayList != null)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= paramArrayList.size()) {
          break;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(',');
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("'");
        ((StringBuilder)localObject1).append((String)paramArrayList.get(i));
        ((StringBuilder)localObject1).append("'");
        localObject1 = ((StringBuilder)localObject1).toString();
        i += 1;
      }
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append((String)localObject2);
    paramArrayList.append("]");
    return paramArrayList.toString();
  }
  
  private ArrayList<String> a(ArrayList<Task.ConfigItem> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.ConfigItem localConfigItem = (Task.ConfigItem)paramArrayList.next();
      if (localConfigItem.jdField_b_of_type_JavaLangString.equals(paramString)) {
        return localConfigItem.jdField_a_of_type_JavaUtilArrayList;
      }
    }
    return null;
  }
  
  private void a(Task paramTask, ArrayList<Task.ConfigItem> paramArrayList, int paramInt)
  {
    JSContext localJSContext = paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext;
    String str;
    if (paramInt == Task.i) {
      str = jdField_b_of_type_JavaLangString;
    } else if (paramInt == Task.j) {
      str = jdField_c_of_type_JavaLangString;
    } else if (paramInt == Task.k) {
      str = d;
    } else if (paramInt == Task.l) {
      str = e;
    } else {
      str = "";
    }
    if (!TextUtils.isEmpty(str))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject1 = (Task.ConfigItem)paramArrayList.next();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(((Task.ConfigItem)localObject1).jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(".js");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          localObject1 = new StringBuffer();
          localObject2 = FileUtils.readFileToString((File)localObject2);
          if (localJSContext != null)
          {
            localJSContext.a((String)localObject2, (StringBuffer)localObject1);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("evaluate js exception: ");
              ((StringBuilder)localObject2).append(localObject1);
              QLog.d("kandianreport.taskmanager", 1, ((StringBuilder)localObject2).toString());
              localObject2 = paramTask.jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("evaluate js exception: ");
              localStringBuilder.append(localObject1);
              TaskException.a((String)localObject2, localStringBuilder.toString());
            }
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("import js not exist: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("kandianreport.taskmanager", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  private void a(NetResp paramNetResp, String paramString, JSContext paramJSContext, Task paramTask)
  {
    Object localObject1 = paramNetResp.mRespData;
    Object localObject2 = "";
    if (localObject1 != null) {
      localObject1 = new String(paramNetResp.mRespData);
    } else {
      localObject1 = "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramNetResp.mRespProperties != null)
    {
      localObject2 = new JSONObject();
      localObject3 = paramNetResp.mRespProperties.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
        String str = (String)((Map.Entry)localObject4).getKey();
        localObject4 = (String)((Map.Entry)localObject4).getValue();
        try
        {
          ((JSONObject)localObject2).put(str, localObject4);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("kandianreport.taskmanager", 2, localJSONException.getMessage());
        }
      }
      localObject2 = ((JSONObject)localObject2).toString();
    }
    localObject1 = b((String)localObject1);
    localObject2 = b((String)localObject2);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("(");
    ((StringBuilder)localObject3).append(paramNetResp.mHttpCode);
    ((StringBuilder)localObject3).append(",'");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("','");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("')");
    paramNetResp = ((StringBuilder)localObject3).toString();
    if (paramJSContext != null)
    {
      paramJSContext.a(paramNetResp, localStringBuffer);
      a(localStringBuffer, paramTask, paramNetResp);
    }
  }
  
  private void a(StringBuffer paramStringBuffer, Task paramTask, String paramString)
  {
    if (!TextUtils.isEmpty(paramStringBuffer))
    {
      a(paramTask);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluate js exception: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramStringBuffer);
      QLog.d("kandianreport.taskmanager", 1, localStringBuilder.toString());
      paramTask = paramTask.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluate js exception: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramStringBuffer);
      TaskException.a(paramTask, localStringBuilder.toString());
    }
  }
  
  private void a(ArrayList<Task.ConfigItem> paramArrayList, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("id");
    String str2 = paramJSONObject.optString("value");
    Object localObject2 = paramJSONObject.optJSONArray("output");
    Object localObject1 = paramJSONObject.optJSONArray("check");
    paramJSONObject = paramJSONObject.optJSONArray("args");
    Task.ConfigItem localConfigItem = new Task.ConfigItem();
    localConfigItem.jdField_a_of_type_JavaLangString = str1;
    localConfigItem.jdField_b_of_type_JavaLangString = str2;
    int j = 0;
    int i;
    if (localObject2 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        str1 = (String)((JSONArray)localObject2).opt(i);
        localConfigItem.jdField_a_of_type_JavaUtilArrayList.add(str1);
        i += 1;
      }
    }
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = (String)((JSONArray)localObject1).opt(i);
        localConfigItem.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        i += 1;
      }
    }
    if (paramJSONObject != null)
    {
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject1 = (String)paramJSONObject.opt(i);
        localConfigItem.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
        i += 1;
      }
    }
    paramArrayList.add(localConfigItem);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (((Integer)RIJSPUtils.a("kandianreport_ON", Integer.valueOf(0))).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(Task paramTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandianreport.taskmanager");
    localStringBuilder.append(paramTask.jdField_a_of_type_JavaLangString);
    paramTask = localStringBuilder.toString();
    boolean bool2 = false;
    int i = ((Integer)RIJSPUtils.a(paramTask, Integer.valueOf(0))).intValue();
    boolean bool1 = bool2;
    if (i != Task.f)
    {
      bool1 = bool2;
      if (i != Task.jdField_e_of_type_Int) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String[] a(ArrayList<Task.ConfigItem> paramArrayList, ArrayList<String> paramArrayList1)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      String[] arrayOfString = new String[paramArrayList1.size()];
      int i = 0;
      while (i < paramArrayList1.size())
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          Task.ConfigItem localConfigItem = (Task.ConfigItem)localIterator.next();
          if (localConfigItem.jdField_a_of_type_JavaLangString.equals(paramArrayList1.get(i))) {
            arrayOfString[i] = localConfigItem.jdField_b_of_type_JavaLangString;
          }
        }
        i += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  @NotNull
  private JSContext.Callback b()
  {
    return new TaskManager.9(this);
  }
  
  @NotNull
  private JSContext.Callback b(Task paramTask)
  {
    return new TaskManager.15(this);
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    int m;
    for (int j = 1; k < paramString.length(); j = m)
    {
      char c1 = paramString.charAt(k);
      if ((i == 0) && (c1 == '\\')) {
        i = 1;
      } else {
        i = 0;
      }
      if (j != 0)
      {
        m = j;
        if (c1 == ' ') {
          break label126;
        }
        m = j;
        if (c1 == '\r') {
          break label126;
        }
        m = j;
        if (c1 == '\n') {
          break label126;
        }
        if (c1 == '\t')
        {
          m = j;
          break label126;
        }
      }
      localStringBuilder.append(c1);
      m = j;
      if (c1 == '"')
      {
        m = j;
        if (i == 0) {
          m = j ^ 0x1;
        }
      }
      label126:
      k += 1;
    }
    return localStringBuilder.toString().replaceAll("\r\n", "\\\\r\\\\n");
  }
  
  private ArrayList<String> b(ArrayList<Task.ConfigItem> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.ConfigItem localConfigItem = (Task.ConfigItem)paramArrayList.next();
      if (localConfigItem.jdField_b_of_type_JavaLangString.equals(paramString)) {
        return localConfigItem.jdField_c_of_type_JavaUtilArrayList;
      }
    }
    return null;
  }
  
  private void b(Task paramTask)
  {
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext = new JSContext();
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a = paramTask;
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a();
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("doNext", f(paramTask));
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("setTimeout", e(paramTask));
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("QLog", p());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("getTaskId", d(paramTask));
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("setInterval", c(paramTask));
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("reportToServer", o());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("clearInterval", n());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("getPlatformInfo", m());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("createRIJStorage", l());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("setValueForKey", k());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("getValueForKey", j());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("removeKey", i());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("invalidate", h());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("reportCustomEvent", g());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("generateCustomData", b(paramTask));
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("httpRequest", a(paramTask));
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("alert", f());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("getAladdinConfig", e());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("decodeBase64", d());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("encodeBase64", c());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("getUserUin", b());
    paramTask.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext.a("isPublicVersion", a());
    paramTask.g = Task.jdField_b_of_type_Int;
  }
  
  @NotNull
  private JSContext.Callback c()
  {
    return new TaskManager.10(this);
  }
  
  @NotNull
  private JSContext.Callback c(Task paramTask)
  {
    return new TaskManager.25(this, paramTask);
  }
  
  private void c(Task paramTask)
  {
    a(paramTask, paramTask.jdField_b_of_type_JavaUtilArrayList, Task.i);
    a(paramTask, paramTask.jdField_c_of_type_JavaUtilArrayList, Task.j);
    a(paramTask, paramTask.jdField_d_of_type_JavaUtilArrayList, Task.k);
    a(paramTask, paramTask.jdField_e_of_type_JavaUtilArrayList, Task.l);
    paramTask.g = Task.jdField_c_of_type_Int;
  }
  
  @NotNull
  private JSContext.Callback d()
  {
    return new TaskManager.11(this);
  }
  
  @NotNull
  private JSContext.Callback d(Task paramTask)
  {
    return new TaskManager.26(this, paramTask);
  }
  
  @NotNull
  private JSContext.Callback e()
  {
    return new TaskManager.12(this);
  }
  
  @NotNull
  private JSContext.Callback e(Task paramTask)
  {
    return new TaskManager.28(this, paramTask);
  }
  
  private void e()
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(Aladdin.getConfig(177).getString("kandian_feature_compute_tasks", "").split("\\|"));
  }
  
  @NotNull
  private JSContext.Callback f()
  {
    return new TaskManager.13(this);
  }
  
  @NotNull
  private JSContext.Callback f(Task paramTask)
  {
    return new TaskManager.29(this, paramTask);
  }
  
  private void f()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.5(this));
  }
  
  @NotNull
  private JSContext.Callback g()
  {
    return new TaskManager.16(this);
  }
  
  private void g()
  {
    try
    {
      if (jdField_b_of_type_Boolean) {
        return;
      }
      if (!FileUtils.fileExists(jdField_a_of_type_JavaLangString)) {
        QLog.d("kandianreport.taskmanager", 1, "startTasksIfExist: offline root dir is null");
      }
      try
      {
        if (!OfflineSecurity.a(jdField_a_of_type_JavaLangString, "3412"))
        {
          KandianReportSoLoader.a("startTasksIfExist: verification failed");
          return;
        }
        e();
        h();
        i();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startTasksIfExist tasks size are: ");
        localStringBuilder1.append(this.jdField_a_of_type_JavaUtilArrayList.size());
        KandianReportSoLoader.a(localStringBuilder1.toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("kandianreport.taskmanager", 1, localThrowable.getMessage());
        return;
      }
      StringBuilder localStringBuilder2;
      return;
    }
    catch (Error localError)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("startAllTasks unexpected error: ");
      localStringBuilder2.append(localError.getMessage());
      QLog.d("kandianreport.taskmanager", 2, localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("startAllTasks unexpected error: ");
      localStringBuilder2.append(localError.getMessage());
      TaskException.b(localStringBuilder2.toString());
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("startAllTasks unexpected exception: ");
      localStringBuilder2.append(localException.getMessage());
      QLog.d("kandianreport.taskmanager", 2, localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("startAllTasks unexpected exception: ");
      localStringBuilder2.append(localException.getMessage());
      TaskException.b(localStringBuilder2.toString());
    }
  }
  
  @NotNull
  private JSContext.Callback h()
  {
    return new TaskManager.17(this);
  }
  
  private void h()
  {
    QLog.d("kandianreport.taskmanager", 1, "readTasksFromConfigFile...");
    if (FileUtils.fileExists(f))
    {
      Object localObject1 = new File(f).listFiles();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          try
          {
            localObject2 = a((File)localObject2);
            if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0) && (("*".equals(jdField_a_of_type_JavaUtilList.get(0))) || (jdField_a_of_type_JavaUtilList.contains(((Task)localObject2).jdField_a_of_type_JavaLangString)))) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
          catch (Exception localException)
          {
            QLog.d("kandianreport.taskmanager", 2, localException.getMessage());
            TaskException.b(localException.getMessage());
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          QLog.d("kandianreport.taskmanager", 1, ((Task)((Iterator)localObject1).next()).toString());
        }
      }
      QLog.d("kandianreport.taskmanager", 1, "tasklist empty");
    }
  }
  
  @NotNull
  private JSContext.Callback i()
  {
    return new TaskManager.18(this);
  }
  
  private void i()
  {
    QLog.d("kandianreport.taskmanager", 1, "startTasksInList...");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Task)localIterator.next();
      try
      {
        if (a((Task)localObject))
        {
          b((Task)localObject);
          c((Task)localObject);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(((Task)localObject).jdField_a_of_type_JavaLangString);
          localStringBuilder1.append(" available status is ");
          localStringBuilder1.append(((Task)localObject).g);
          QLog.d("kandianreport.taskmanager", 1, localStringBuilder1.toString());
        }
      }
      catch (Error localError)
      {
        a((Task)localObject);
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startTasksInList unexpected error: ");
        localStringBuilder2.append(localError.getMessage());
        QLog.d("kandianreport.taskmanager", 1, localStringBuilder2.toString());
        localObject = ((Task)localObject).jdField_a_of_type_JavaLangString;
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startTasksInList unexpected error: ");
        localStringBuilder2.append(localError.getMessage());
        TaskException.a((String)localObject, localStringBuilder2.toString());
      }
      catch (Exception localException)
      {
        a((Task)localObject);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startTasksInList unexpected exception: ");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("kandianreport.taskmanager", 1, localStringBuilder2.toString());
        localObject = ((Task)localObject).jdField_a_of_type_JavaLangString;
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startTasksInList unexpected exception: ");
        localStringBuilder2.append(localException.getMessage());
        TaskException.a((String)localObject, localStringBuilder2.toString());
      }
    }
    jdField_b_of_type_Boolean = true;
  }
  
  @NotNull
  private JSContext.Callback j()
  {
    return new TaskManager.19(this);
  }
  
  @NotNull
  private JSContext.Callback k()
  {
    return new TaskManager.20(this);
  }
  
  @NotNull
  private JSContext.Callback l()
  {
    return new TaskManager.21(this);
  }
  
  @NotNull
  private JSContext.Callback m()
  {
    return new TaskManager.22(this);
  }
  
  @NotNull
  private JSContext.Callback n()
  {
    return new TaskManager.23(this);
  }
  
  @NotNull
  private JSContext.Callback o()
  {
    return new TaskManager.24(this);
  }
  
  @NotNull
  private JSContext.Callback p()
  {
    return new TaskManager.27(this);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 38	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:a	()Z
    //   5: putstatic 40	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_a_of_type_Boolean	Z
    //   8: getstatic 40	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_a_of_type_Boolean	Z
    //   11: ifeq +114 -> 125
    //   14: getstatic 675	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_b_of_type_Boolean	Z
    //   17: ifne +108 -> 125
    //   20: ldc_w 775
    //   23: invokestatic 692	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 99	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_c_of_type_Boolean	Z
    //   30: ifne +18 -> 48
    //   33: invokestatic 778	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload_0
    //   37: getfield 106	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler	Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;
    //   40: invokestatic 784	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:registerConnectionChangeReceiver	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;)V
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 99	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_c_of_type_Boolean	Z
    //   48: ldc 45
    //   50: iconst_1
    //   51: invokestatic 789	com/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils$ConfigData;
    //   54: getfield 793	com/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils$ConfigData:jdField_a_of_type_Int	I
    //   57: putstatic 794	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_a_of_type_Int	I
    //   60: invokestatic 795	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	()Z
    //   63: ifeq +19 -> 82
    //   66: ldc 82
    //   68: iconst_1
    //   69: ldc_w 797
    //   72: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: invokespecial 376	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:f	()V
    //   79: goto +136 -> 215
    //   82: ldc 82
    //   84: iconst_1
    //   85: ldc_w 799
    //   88: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: invokestatic 801	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:b	()Z
    //   94: ifne +17 -> 111
    //   97: new 803	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$3
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 804	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$3:<init>	(Lcom/tencent/mobileqq/kandian/glue/report/task/TaskManager;)V
    //   105: invokestatic 807	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	(Ljava/lang/Runnable;)V
    //   108: goto +107 -> 215
    //   111: new 809	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$4
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 810	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$4:<init>	(Lcom/tencent/mobileqq/kandian/glue/report/task/TaskManager;)V
    //   119: invokestatic 812	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:b	(Ljava/lang/Runnable;)V
    //   122: goto +93 -> 215
    //   125: new 42	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: ldc_w 814
    //   137: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: getstatic 40	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_a_of_type_Boolean	Z
    //   145: invokevirtual 817	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: ldc_w 819
    //   153: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: getstatic 675	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:jdField_b_of_type_Boolean	Z
    //   161: invokevirtual 817	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 82
    //   167: iconst_2
    //   168: aload_1
    //   169: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: goto +40 -> 215
    //   178: astore_1
    //   179: goto +39 -> 218
    //   182: astore_1
    //   183: new 42	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   190: astore_2
    //   191: aload_2
    //   192: ldc_w 821
    //   195: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload_1
    //   201: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 82
    //   207: iconst_2
    //   208: aload_2
    //   209: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_0
    //   216: monitorexit
    //   217: return
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	TaskManager
    //   132	37	1	localStringBuilder1	StringBuilder
    //   178	1	1	localObject	Object
    //   182	39	1	localThrowable	Throwable
    //   190	19	2	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	48	178	finally
    //   48	79	178	finally
    //   82	108	178	finally
    //   111	122	178	finally
    //   125	175	178	finally
    //   183	215	178	finally
    //   2	48	182	java/lang/Throwable
    //   48	79	182	java/lang/Throwable
    //   82	108	182	java/lang/Throwable
    //   111	122	182	java/lang/Throwable
    //   125	175	182	java/lang/Throwable
  }
  
  public void a(Task paramTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mark task fail ");
    localStringBuilder.append(paramTask.jdField_a_of_type_JavaLangString);
    QLog.d("kandianreport.taskmanager", 2, localStringBuilder.toString());
    paramTask.g = Task.f;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandianreport.taskmanager");
    localStringBuilder.append(paramTask.jdField_a_of_type_JavaLangString);
    RIJSPUtils.a(localStringBuilder.toString(), Integer.valueOf(Task.f));
  }
  
  public void a(String paramString)
  {
    if ((jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(paramString)))
    {
      if (!KandianReportSoLoader.a())
      {
        QLog.d("kandianreport.taskmanager", 2, "accept so not load");
        return;
      }
      ThreadManager.getFileThreadHandler().post(new TaskManager.6(this, paramString));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long >= jdField_b_of_type_Long) {
      TaskOfflineUtils.a("3412", 1, new TaskManager.30(this, paramBoolean));
    }
    jdField_a_of_type_Long = l;
  }
  
  public void b()
  {
    QLog.d("kandianreport.taskmanager", 2, "restartAllTasks");
    c();
    a();
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      if (localTask.jdField_a_of_type_JavaLangString == paramString) {
        localTask.g = Task.jdField_d_of_type_Int;
      }
    }
  }
  
  public void c()
  {
    try
    {
      if (jdField_b_of_type_Boolean)
      {
        QLog.d("kandianreport.taskmanager", 1, "stopAllTasks");
        jdField_b_of_type_Boolean = false;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          b(((Task)localIterator.next()).jdField_a_of_type_JavaLangString);
        }
        this.jdField_c_of_type_Boolean = false;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager
 * JD-Core Version:    0.7.0.1
 */