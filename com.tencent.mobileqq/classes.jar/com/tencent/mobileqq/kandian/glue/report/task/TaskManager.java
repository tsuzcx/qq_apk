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
  public static boolean b = false;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static boolean j = false;
  private static long k = 0L;
  private static long l = 3600000L;
  private static TaskManager m = new TaskManager();
  private static List<String> n;
  private ArrayList<Task> i = new ArrayList();
  private boolean o = false;
  private INetInfoHandler p = new TaskManager.1(this);
  
  static
  {
    try
    {
      b = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(OfflineEnvHelper.b("3412"));
      localStringBuilder.append("3412");
      c = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append("/extraction");
      d = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append("/process");
      e = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append("/distribution");
      f = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append("/check");
      g = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append("/task_config");
      h = localStringBuilder.toString();
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
  private JSContext.Callback A()
  {
    return new TaskManager.27(this);
  }
  
  private Task a(File paramFile)
  {
    return e(FileUtils.readFileContent(paramFile));
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
      int i1 = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i1 >= paramArrayList.size()) {
          break;
        }
        localObject2 = localObject1;
        if (i1 != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(',');
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("'");
        ((StringBuilder)localObject1).append((String)paramArrayList.get(i1));
        ((StringBuilder)localObject1).append("'");
        localObject1 = ((StringBuilder)localObject1).toString();
        i1 += 1;
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
      if (localConfigItem.b.equals(paramString)) {
        return localConfigItem.c;
      }
    }
    return null;
  }
  
  private void a(Task paramTask, ArrayList<Task.ConfigItem> paramArrayList, int paramInt)
  {
    JSContext localJSContext = paramTask.a;
    String str;
    if (paramInt == Task.k) {
      str = d;
    } else if (paramInt == Task.l) {
      str = e;
    } else if (paramInt == Task.m) {
      str = f;
    } else if (paramInt == Task.n) {
      str = g;
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
        ((StringBuilder)localObject2).append(((Task.ConfigItem)localObject1).b);
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
              localObject2 = paramTask.b;
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
    localObject1 = d((String)localObject1);
    localObject2 = d((String)localObject2);
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
      paramTask = paramTask.b;
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
    localConfigItem.a = str1;
    localConfigItem.b = str2;
    int i2 = 0;
    int i1;
    if (localObject2 != null)
    {
      i1 = 0;
      while (i1 < ((JSONArray)localObject2).length())
      {
        str1 = (String)((JSONArray)localObject2).opt(i1);
        localConfigItem.c.add(str1);
        i1 += 1;
      }
    }
    if (localObject1 != null)
    {
      i1 = 0;
      while (i1 < ((JSONArray)localObject1).length())
      {
        localObject2 = (String)((JSONArray)localObject1).opt(i1);
        localConfigItem.d.add(localObject2);
        i1 += 1;
      }
    }
    if (paramJSONObject != null)
    {
      i1 = i2;
      while (i1 < paramJSONObject.length())
      {
        localObject1 = (String)paramJSONObject.opt(i1);
        localConfigItem.e.add(localObject1);
        i1 += 1;
      }
    }
    paramArrayList.add(localConfigItem);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (((Integer)RIJSPUtils.b("kandianreport_ON", Integer.valueOf(0))).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
  private String[] a(ArrayList<Task.ConfigItem> paramArrayList, ArrayList<String> paramArrayList1)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      String[] arrayOfString = new String[paramArrayList1.size()];
      int i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          Task.ConfigItem localConfigItem = (Task.ConfigItem)localIterator.next();
          if (localConfigItem.a.equals(paramArrayList1.get(i1))) {
            arrayOfString[i1] = localConfigItem.b;
          }
        }
        i1 += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  public static TaskManager b()
  {
    return m;
  }
  
  private ArrayList<String> b(ArrayList<Task.ConfigItem> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Task.ConfigItem localConfigItem = (Task.ConfigItem)paramArrayList.next();
      if (localConfigItem.b.equals(paramString)) {
        return localConfigItem.e;
      }
    }
    return null;
  }
  
  private boolean b(Task paramTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandianreport.taskmanager");
    localStringBuilder.append(paramTask.b);
    paramTask = localStringBuilder.toString();
    boolean bool2 = false;
    int i1 = ((Integer)RIJSPUtils.b(paramTask, Integer.valueOf(0))).intValue();
    boolean bool1 = bool2;
    if (i1 != Task.h)
    {
      bool1 = bool2;
      if (i1 != Task.g) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c(Task paramTask)
  {
    paramTask.a = new JSContext();
    paramTask.a.a = paramTask;
    paramTask.a.a();
    paramTask.a.a("doNext", i(paramTask));
    paramTask.a.a("setTimeout", h(paramTask));
    paramTask.a.a("QLog", A());
    paramTask.a.a("getTaskId", g(paramTask));
    paramTask.a.a("setInterval", f(paramTask));
    paramTask.a.a("reportToServer", z());
    paramTask.a.a("clearInterval", y());
    paramTask.a.a("getPlatformInfo", x());
    paramTask.a.a("createRIJStorage", w());
    paramTask.a.a("setValueForKey", v());
    paramTask.a.a("getValueForKey", u());
    paramTask.a.a("removeKey", t());
    paramTask.a.a("invalidate", s());
    paramTask.a.a("reportCustomEvent", r());
    paramTask.a.a("generateCustomData", e(paramTask));
    paramTask.a.a("httpRequest", d(paramTask));
    paramTask.a.a("alert", q());
    paramTask.a.a("getAladdinConfig", p());
    paramTask.a.a("decodeBase64", o());
    paramTask.a.a("encodeBase64", n());
    paramTask.a.a("getUserUin", m());
    paramTask.a.a("isPublicVersion", l());
    paramTask.i = Task.d;
  }
  
  @NotNull
  private JSContext.Callback d(Task paramTask)
  {
    return new TaskManager.14(this, paramTask);
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = 0;
    int i1 = 0;
    int i4;
    for (int i2 = 1; i3 < paramString.length(); i2 = i4)
    {
      char c1 = paramString.charAt(i3);
      if ((i1 == 0) && (c1 == '\\')) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i2 != 0)
      {
        i4 = i2;
        if (c1 == ' ') {
          break label126;
        }
        i4 = i2;
        if (c1 == '\r') {
          break label126;
        }
        i4 = i2;
        if (c1 == '\n') {
          break label126;
        }
        if (c1 == '\t')
        {
          i4 = i2;
          break label126;
        }
      }
      localStringBuilder.append(c1);
      i4 = i2;
      if (c1 == '"')
      {
        i4 = i2;
        if (i1 == 0) {
          i4 = i2 ^ 0x1;
        }
      }
      label126:
      i3 += 1;
    }
    return localStringBuilder.toString().replaceAll("\r\n", "\\\\r\\\\n");
  }
  
  @NotNull
  private JSContext.Callback e(Task paramTask)
  {
    return new TaskManager.15(this);
  }
  
  private Task e(String paramString)
  {
    paramString = new JSONObject(paramString);
    JSONArray localJSONArray1 = paramString.optJSONArray("filter");
    JSONArray localJSONArray2 = paramString.optJSONArray("extraction");
    JSONArray localJSONArray3 = paramString.optJSONArray("process");
    JSONArray localJSONArray4 = paramString.optJSONArray("distribution");
    JSONArray localJSONArray5 = paramString.optJSONArray("check");
    Task localTask = new Task();
    localTask.o = paramString;
    localTask.b = paramString.optString("id");
    int i2 = 0;
    int i1;
    if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
    {
      i1 = 0;
      while (i1 < localJSONArray1.length())
      {
        a(localTask.p, (JSONObject)localJSONArray1.opt(i1));
        i1 += 1;
      }
    }
    if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
    {
      i1 = 0;
      while (i1 < localJSONArray2.length())
      {
        a(localTask.q, (JSONObject)localJSONArray2.opt(i1));
        i1 += 1;
      }
    }
    if ((localJSONArray3 != null) && (localJSONArray3.length() > 0))
    {
      i1 = 0;
      while (i1 < localJSONArray3.length())
      {
        a(localTask.r, (JSONObject)localJSONArray3.opt(i1));
        i1 += 1;
      }
    }
    if ((localJSONArray4 != null) && (localJSONArray4.length() > 0))
    {
      i1 = 0;
      while (i1 < localJSONArray4.length())
      {
        a(localTask.s, (JSONObject)localJSONArray4.opt(i1));
        i1 += 1;
      }
    }
    if ((localJSONArray5 != null) && (localJSONArray5.length() > 0))
    {
      i1 = i2;
      while (i1 < localJSONArray5.length())
      {
        a(localTask.t, (JSONObject)localJSONArray5.opt(i1));
        i1 += 1;
      }
    }
    return localTask;
  }
  
  @NotNull
  private JSContext.Callback f(Task paramTask)
  {
    return new TaskManager.25(this, paramTask);
  }
  
  @NotNull
  private JSContext.Callback g(Task paramTask)
  {
    return new TaskManager.26(this, paramTask);
  }
  
  private void g()
  {
    n = Arrays.asList(Aladdin.getConfig(177).getString("kandian_feature_compute_tasks", "").split("\\|"));
  }
  
  @NotNull
  private JSContext.Callback h(Task paramTask)
  {
    return new TaskManager.28(this, paramTask);
  }
  
  private void h()
  {
    ThreadManager.getFileThreadHandler().post(new TaskManager.5(this));
  }
  
  @NotNull
  private JSContext.Callback i(Task paramTask)
  {
    return new TaskManager.29(this, paramTask);
  }
  
  private void i()
  {
    try
    {
      if (j) {
        return;
      }
      if (!FileUtils.fileExists(c)) {
        QLog.d("kandianreport.taskmanager", 1, "startTasksIfExist: offline root dir is null");
      }
      try
      {
        if (!OfflineSecurity.a(c, "3412"))
        {
          KandianReportSoLoader.a("startTasksIfExist: verification failed");
          return;
        }
        g();
        j();
        k();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startTasksIfExist tasks size are: ");
        localStringBuilder1.append(this.i.size());
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
  
  private void j()
  {
    QLog.d("kandianreport.taskmanager", 1, "readTasksFromConfigFile...");
    if (FileUtils.fileExists(h))
    {
      Object localObject1 = new File(h).listFiles();
      this.i.clear();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject2 = localObject1[i1];
          try
          {
            localObject2 = a((File)localObject2);
            if ((n != null) && (n.size() > 0) && (("*".equals(n.get(0))) || (n.contains(((Task)localObject2).b)))) {
              this.i.add(localObject2);
            }
          }
          catch (Exception localException)
          {
            QLog.d("kandianreport.taskmanager", 2, localException.getMessage());
            TaskException.b(localException.getMessage());
          }
          i1 += 1;
        }
      }
      if (this.i.size() > 0)
      {
        localObject1 = this.i.iterator();
        while (((Iterator)localObject1).hasNext()) {
          QLog.d("kandianreport.taskmanager", 1, ((Task)((Iterator)localObject1).next()).toString());
        }
      }
      QLog.d("kandianreport.taskmanager", 1, "tasklist empty");
    }
  }
  
  private void j(Task paramTask)
  {
    a(paramTask, paramTask.q, Task.k);
    a(paramTask, paramTask.r, Task.l);
    a(paramTask, paramTask.s, Task.m);
    a(paramTask, paramTask.t, Task.n);
    paramTask.i = Task.e;
  }
  
  private void k()
  {
    QLog.d("kandianreport.taskmanager", 1, "startTasksInList...");
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Task)localIterator.next();
      try
      {
        if (b((Task)localObject))
        {
          c((Task)localObject);
          j((Task)localObject);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(((Task)localObject).b);
          localStringBuilder1.append(" available status is ");
          localStringBuilder1.append(((Task)localObject).i);
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
        localObject = ((Task)localObject).b;
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
        localObject = ((Task)localObject).b;
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startTasksInList unexpected exception: ");
        localStringBuilder2.append(localException.getMessage());
        TaskException.a((String)localObject, localStringBuilder2.toString());
      }
    }
    j = true;
  }
  
  @NotNull
  private JSContext.Callback l()
  {
    return new TaskManager.8(this);
  }
  
  @NotNull
  private JSContext.Callback m()
  {
    return new TaskManager.9(this);
  }
  
  @NotNull
  private JSContext.Callback n()
  {
    return new TaskManager.10(this);
  }
  
  @NotNull
  private JSContext.Callback o()
  {
    return new TaskManager.11(this);
  }
  
  @NotNull
  private JSContext.Callback p()
  {
    return new TaskManager.12(this);
  }
  
  @NotNull
  private JSContext.Callback q()
  {
    return new TaskManager.13(this);
  }
  
  @NotNull
  private JSContext.Callback r()
  {
    return new TaskManager.16(this);
  }
  
  @NotNull
  private JSContext.Callback s()
  {
    return new TaskManager.17(this);
  }
  
  @NotNull
  private JSContext.Callback t()
  {
    return new TaskManager.18(this);
  }
  
  @NotNull
  private JSContext.Callback u()
  {
    return new TaskManager.19(this);
  }
  
  @NotNull
  private JSContext.Callback v()
  {
    return new TaskManager.20(this);
  }
  
  @NotNull
  private JSContext.Callback w()
  {
    return new TaskManager.21(this);
  }
  
  @NotNull
  private JSContext.Callback x()
  {
    return new TaskManager.22(this);
  }
  
  @NotNull
  private JSContext.Callback y()
  {
    return new TaskManager.23(this);
  }
  
  @NotNull
  private JSContext.Callback z()
  {
    return new TaskManager.24(this);
  }
  
  public void a(Task paramTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mark task fail ");
    localStringBuilder.append(paramTask.b);
    QLog.d("kandianreport.taskmanager", 2, localStringBuilder.toString());
    paramTask.i = Task.h;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandianreport.taskmanager");
    localStringBuilder.append(paramTask.b);
    RIJSPUtils.a(localStringBuilder.toString(), Integer.valueOf(Task.h));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - k >= l) {
      TaskOfflineUtils.a("3412", 1, new TaskManager.30(this, paramBoolean));
    }
    k = l1;
  }
  
  public void b(String paramString)
  {
    if ((b) && (j) && (!TextUtils.isEmpty(paramString)))
    {
      if (!KandianReportSoLoader.a())
      {
        QLog.d("kandianreport.taskmanager", 2, "accept so not load");
        return;
      }
      ThreadManager.getFileThreadHandler().post(new TaskManager.6(this, paramString));
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 48	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:a	()Z
    //   5: putstatic 50	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:b	Z
    //   8: getstatic 50	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:b	Z
    //   11: ifeq +114 -> 125
    //   14: getstatic 670	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:j	Z
    //   17: ifne +108 -> 125
    //   20: ldc_w 820
    //   23: invokestatic 687	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 109	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:o	Z
    //   30: ifne +18 -> 48
    //   33: invokestatic 823	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload_0
    //   37: getfield 116	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:p	Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;
    //   40: invokestatic 829	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:registerConnectionChangeReceiver	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;)V
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 109	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:o	Z
    //   48: ldc 55
    //   50: iconst_1
    //   51: invokestatic 832	com/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils$ConfigData;
    //   54: getfield 836	com/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils$ConfigData:b	I
    //   57: putstatic 838	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:a	I
    //   60: invokestatic 811	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	()Z
    //   63: ifeq +19 -> 82
    //   66: ldc 92
    //   68: iconst_1
    //   69: ldc_w 840
    //   72: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: invokespecial 333	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:h	()V
    //   79: goto +136 -> 215
    //   82: ldc 92
    //   84: iconst_1
    //   85: ldc_w 842
    //   88: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: invokestatic 844	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:d	()Z
    //   94: ifne +17 -> 111
    //   97: new 846	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$3
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 847	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$3:<init>	(Lcom/tencent/mobileqq/kandian/glue/report/task/TaskManager;)V
    //   105: invokestatic 850	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	(Ljava/lang/Runnable;)V
    //   108: goto +107 -> 215
    //   111: new 852	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$4
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 853	com/tencent/mobileqq/kandian/glue/report/task/TaskManager$4:<init>	(Lcom/tencent/mobileqq/kandian/glue/report/task/TaskManager;)V
    //   119: invokestatic 855	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:b	(Ljava/lang/Runnable;)V
    //   122: goto +93 -> 215
    //   125: new 52	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: ldc_w 857
    //   137: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: getstatic 50	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:b	Z
    //   145: invokevirtual 860	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: ldc_w 862
    //   153: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: getstatic 670	com/tencent/mobileqq/kandian/glue/report/task/TaskManager:j	Z
    //   161: invokevirtual 860	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 92
    //   167: iconst_2
    //   168: aload_1
    //   169: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: goto +40 -> 215
    //   178: astore_1
    //   179: goto +39 -> 218
    //   182: astore_1
    //   183: new 52	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   190: astore_2
    //   191: aload_2
    //   192: ldc_w 864
    //   195: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload_1
    //   201: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 92
    //   207: iconst_2
    //   208: aload_2
    //   209: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public void c(String paramString)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      Task localTask = (Task)localIterator.next();
      if (localTask.b == paramString) {
        localTask.i = Task.f;
      }
    }
  }
  
  public void d()
  {
    QLog.d("kandianreport.taskmanager", 2, "restartAllTasks");
    e();
    c();
  }
  
  public void e()
  {
    try
    {
      if (j)
      {
        QLog.d("kandianreport.taskmanager", 1, "stopAllTasks");
        j = false;
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext()) {
          c(((Task)localIterator.next()).b);
        }
        this.o = false;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager
 * JD-Core Version:    0.7.0.1
 */