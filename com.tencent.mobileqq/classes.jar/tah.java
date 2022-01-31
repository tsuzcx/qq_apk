import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyRule;
import com.tencent.biz.pubaccount.util.SneakyCallback.1;
import com.tencent.biz.pubaccount.util.SneakyCallback.2;
import com.tencent.biz.pubaccount.util.SneakyCallback.4;
import com.tencent.biz.pubaccount.util.SneakyCallback.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.IdlePushWakeParam;

public class tah
  implements oxx
{
  private static tah a = new tah();
  
  private Set<String> a(Context paramContext)
  {
    localHashSet = new HashSet();
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses();
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext()) {
            localHashSet.add(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName);
          }
        }
      }
      return localHashSet;
    }
    catch (Exception paramContext)
    {
      QLog.e("SneakyCallback", 1, "[getRunningAppProcess] ", paramContext);
    }
  }
  
  public static tah a()
  {
    return a;
  }
  
  public static void a()
  {
    oxs.a(a);
  }
  
  public static void a(int paramInt)
  {
    QLog.i("SneakyCallback", 1, "[doSneakyThing]: occasionType=" + paramInt);
    ThreadManager.executeOnSubThread(new SneakyCallback.4(paramInt));
  }
  
  private void a(int paramInt, List<SneakyParams> paramList)
  {
    if (!a(Aladdin.get(139)))
    {
      QLog.i("SneakyCallback", 1, "[maybeWakeOtherApps] did not match any rule, skip.");
      return;
    }
    QLog.d("SneakyCallback", 2, "[maybeWakeOtherApps] occasionType=" + paramInt + ", paramList=" + paramList);
    Set localSet = a(BaseApplicationImpl.getContext());
    Random localRandom = new Random();
    long l = 0L;
    if ((paramList != null) && (paramList.size() > 0))
    {
      int k = paramList.size();
      int i = 0;
      label100:
      SneakyParams localSneakyParams;
      if (i < k)
      {
        localSneakyParams = (SneakyParams)paramList.get(i);
        if (localSneakyParams != null) {
          break label130;
        }
      }
      for (;;)
      {
        i += 1;
        break label100;
        break;
        label130:
        if (a(localSet, localSneakyParams))
        {
          QLog.i("SneakyCallback", 1, "[maybeWakeOtherApps] Target is already running, skip.");
        }
        else if (!a(localSneakyParams))
        {
          QLog.i("SneakyCallback", 1, "[maybeWakeOtherApps] Target is not installed, skip.");
        }
        else if (!b(paramInt, localSneakyParams))
        {
          QLog.i("SneakyCallback", 1, "[maybeWakeOtherApps] occasionType not allowed, skip. occasionType:" + paramInt);
        }
        else
        {
          if (a(paramInt, localSneakyParams)) {
            break label261;
          }
          QLog.i("SneakyCallback", 1, "[maybeWakeOtherApps] too frequent for " + localSneakyParams.getPackageName() + " in occasionType=" + paramInt);
        }
      }
      label261:
      int m = localSneakyParams.getBaseDelayMs(paramInt);
      int j = localSneakyParams.getRandomDelayUpperBoundMs(paramInt);
      if (j < 2) {}
      for (j = 0;; j = localRandom.nextInt(j))
      {
        l += j + m;
        QLog.d("SneakyCallback", 2, "[maybeWakeOtherApps] will wake up in delay = " + l / 1000L + "s");
        ThreadManager.getSubThreadHandler().postDelayed(new SneakyCallback.5(this, localSneakyParams, paramInt), l);
        break;
      }
    }
    QLog.i("SneakyCallback", 1, "[maybeWakeOtherApps] empty list");
  }
  
  private void a(SneakyParams paramSneakyParams, int paramInt)
  {
    boolean bool2 = false;
    if ((paramSneakyParams == null) || (!paramSneakyParams.isEnable())) {
      QLog.d("SneakyCallback", 2, "[doWake] return since wake up service is disabled. ");
    }
    for (;;)
    {
      return;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (localBaseApplicationImpl == null)
      {
        QLog.d("SneakyCallback", 2, "[doWake] return since context is null");
        return;
      }
      String str = paramSneakyParams.getWakeType();
      QLog.i("SneakyCallback", 1, "[doWake] wakeType=" + str);
      try
      {
        if (TextUtils.equals(str, "explicit_service")) {
          bool1 = a(localBaseApplicationImpl, paramSneakyParams, str);
        }
        for (;;)
        {
          if (!bool1) {
            break label283;
          }
          a(paramSneakyParams.getPackageName(), str);
          QLog.d("SneakyCallback", 2, "[doWake] wake " + paramSneakyParams.getPackageName());
          if (paramInt != 4) {
            break;
          }
          ors.f = bool1;
          ors.g = bool1;
          return;
          if (TextUtils.equals(str, "explicit_activity"))
          {
            bool1 = a(localBaseApplicationImpl, paramSneakyParams, str);
          }
          else if (TextUtils.equals(str, "explicit_broadcast"))
          {
            bool1 = a(localBaseApplicationImpl, paramSneakyParams, str);
          }
          else if (TextUtils.equals(str, "implicit_activity_uri"))
          {
            bool1 = a(localBaseApplicationImpl, paramSneakyParams);
          }
          else if (TextUtils.equals(str, "am_command_activity"))
          {
            bool1 = a(paramSneakyParams, false);
          }
          else
          {
            bool1 = bool2;
            if (TextUtils.equals(str, "am_command_service")) {
              bool1 = a(paramSneakyParams, true);
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("SneakyCallback", 1, "[doWake] ", localException);
          boolean bool1 = bool2;
          continue;
          label283:
          QLog.e("SneakyCallback", 1, "[doWake] fail to wake");
        }
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wake_type", paramString2);
      localJSONObject.put("manufacturer", Build.MANUFACTURER.toUpperCase());
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("timestamp", System.currentTimeMillis() / 1000L);
      localJSONObject.put("fingerprint", Build.FINGERPRINT);
      localJSONObject.put("api_level", Build.VERSION.SDK_INT);
      paramString2 = localJSONObject.toString();
      nrt.a(null, "CliOper", "", "", "0X8009C0F", "0X8009C0F", 0, 0, "", "", paramString1, paramString2);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        QLog.e("SneakyCallback", 1, "[reportStartService] ", paramString2);
        paramString2 = str;
      }
    }
  }
  
  public static void a(List<oidb_cmd0x80a.IdlePushWakeParam> paramList)
  {
    try
    {
      Object localObject = Aladdin.getConfig(139).getList("param_list");
      ArrayList localArrayList = new ArrayList();
      if ((localObject != null) && (paramList != null))
      {
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label126;
          }
          SneakyParams localSneakyParams = (SneakyParams)((Iterator)localObject).next();
          String str = localSneakyParams.getPackageName();
          Iterator localIterator = paramList.iterator();
          if (localIterator.hasNext())
          {
            if (!TextUtils.equals(((oidb_cmd0x80a.IdlePushWakeParam)localIterator.next()).package_name.get(), str)) {
              break;
            }
            localArrayList.add(localSneakyParams);
          }
        }
      }
      a().a(16, localArrayList);
    }
    catch (Exception paramList)
    {
      QLog.e("SneakyCallback", 1, "[handle0x80aIdlePushWakeParams]: ", paramList);
      return;
    }
    label126:
  }
  
  private boolean a(int paramInt, SneakyParams paramSneakyParams)
  {
    String str1 = "sp_key_prefix_last_wakeup_ts_" + paramSneakyParams.getPackageName() + "_" + paramInt;
    String str2 = "sp_key_prefix_remain_wake_up_count_" + paramSneakyParams.getPackageName() + "_" + paramInt;
    long l1 = ((Long)bjxj.a(str1, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    double d = (l2 - l1) * 1.0D / 60000.0D;
    int i = paramSneakyParams.getDebounceIntervalMinutes(paramInt);
    if (QLog.isColorLevel())
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      QLog.d("SneakyCallback", 2, "[checkInterval] last wakeup: " + localSimpleDateFormat.format(new Date(l1)));
      QLog.d("SneakyCallback", 2, "[checkInterval] current time: " + localSimpleDateFormat.format(new Date(l2)));
    }
    if (d <= i)
    {
      QLog.i("SneakyCallback", 1, "[checkInterval] less than " + i + " minutes for occasionType=" + paramInt);
      return false;
    }
    int j = ((Integer)bjxj.a(str2, Integer.valueOf(paramSneakyParams.getMaximumWakeUpTimes(paramInt)))).intValue();
    if ((l2 - l1) * 1.0D / 86400000.0D > 1.0D)
    {
      i = 1;
      QLog.d("SneakyCallback", 2, "[checkInterval] remain count " + j + " for occasionType=" + paramInt);
      if (i == 0) {
        break label397;
      }
      QLog.i("SneakyCallback", 1, "[checkInterval] more than one day for occasionType=" + paramInt);
      bjxj.a(str2, Integer.valueOf(paramSneakyParams.getMaximumWakeUpTimes(paramInt) - 1));
    }
    for (;;)
    {
      bjxj.a(str1, Long.valueOf(l2));
      return true;
      i = 0;
      break;
      label397:
      if (j <= 0) {
        break label417;
      }
      bjxj.a(str2, Integer.valueOf(j - 1));
    }
    label417:
    return false;
  }
  
  private boolean a(Context paramContext, SneakyParams paramSneakyParams)
  {
    paramSneakyParams = paramSneakyParams.getBackupActivityUri();
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramSneakyParams)));
    QLog.d("SneakyCallback", 2, "[wakeViaImplicitIntent] wake with uri: " + paramSneakyParams);
    return true;
  }
  
  private boolean a(Context paramContext, SneakyParams paramSneakyParams, @NonNull String paramString)
  {
    String str1 = paramSneakyParams.getPackageName();
    String str2 = paramSneakyParams.getServiceClassName();
    String str3 = paramSneakyParams.getActivityClassName();
    String str4 = paramSneakyParams.getReceiverClassName();
    Bundle localBundle = new Bundle();
    Object localObject = paramSneakyParams.getParams();
    Iterator localIterator = ((Map)localObject).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str5 = (String)localIterator.next();
      localBundle.putString(str5, (String)((Map)localObject).get(str5));
    }
    localObject = new Intent();
    ((Intent)localObject).setAction(paramSneakyParams.getActionName());
    localBundle.putString("big_brother_source_key", "biz_src_feeds_kandian");
    ((Intent)localObject).putExtras(localBundle);
    if (paramString.contains("activity"))
    {
      ((Intent)localObject).setComponent(new ComponentName(str1, str3));
      paramContext.startActivity((Intent)localObject);
      QLog.d("SneakyCallback", 2, "[wakeViaExplicitIntent] " + str3);
    }
    for (;;)
    {
      return true;
      if (paramString.contains("service"))
      {
        ((Intent)localObject).setComponent(new ComponentName(str1, str2));
        paramContext.startService((Intent)localObject);
        QLog.d("SneakyCallback", 2, "[wakeViaExplicitIntent] " + str2);
      }
      else if (paramString.contains("broadcast"))
      {
        ((Intent)localObject).setComponent(new ComponentName(str1, str4));
        paramContext.sendBroadcast((Intent)localObject);
        QLog.d("SneakyCallback", 2, "[wakeViaExplicitIntent] " + str4);
      }
    }
  }
  
  private boolean a(AladdinConfig paramAladdinConfig)
  {
    try
    {
      paramAladdinConfig = paramAladdinConfig.getList("rule_list").iterator();
      while (paramAladdinConfig.hasNext())
      {
        SneakyRule localSneakyRule = (SneakyRule)paramAladdinConfig.next();
        String str = TextUtils.join(".", qoa.a(localSneakyRule.getProps(), new tai(this)));
        if (localSneakyRule.getFingerprintSet().contains(str))
        {
          if (!localSneakyRule.isEnable())
          {
            QLog.i("SneakyCallback", 1, "[matchRules] matched blacklist");
            return false;
          }
          return true;
        }
      }
    }
    catch (Throwable paramAladdinConfig)
    {
      QLog.e("SneakyCallback", 1, "[matchRules] ", paramAladdinConfig);
    }
    return false;
  }
  
  private boolean a(SneakyParams paramSneakyParams)
  {
    try
    {
      boolean bool = aowf.a(paramSneakyParams.getPackageName(), BaseApplicationImpl.getContext());
      if (bool) {
        return true;
      }
    }
    catch (Exception paramSneakyParams)
    {
      QLog.e("SneakyCallback", 1, "[checkPackageInstalled] ", paramSneakyParams);
    }
    return false;
  }
  
  private boolean a(SneakyParams paramSneakyParams, boolean paramBoolean)
  {
    Object localObject2 = paramSneakyParams.getActionName();
    Object localObject1 = "";
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = " -a " + (String)localObject2 + " ";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (localObject2 = "am startservice --user 0";; localObject2 = "am start --user 0")
    {
      localStringBuilder.append((String)localObject2).append((String)localObject1);
      localObject1 = paramSneakyParams.getParams();
      localObject2 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        localStringBuilder.append(" --es ").append(str).append(" ").append((String)((Map)localObject1).get(str));
      }
    }
    localObject1 = localStringBuilder.append(" ").append(paramSneakyParams.getPackageName()).append("/");
    if (paramBoolean) {}
    for (paramSneakyParams = paramSneakyParams.getServiceClassName();; paramSneakyParams = paramSneakyParams.getActivityClassName())
    {
      ((StringBuilder)localObject1).append(paramSneakyParams);
      paramSneakyParams = localStringBuilder.toString();
      try
      {
        QLog.d("SneakyCallback", 2, "[wakeViaShellCommand] exec: " + paramSneakyParams);
        Runtime.getRuntime().exec(paramSneakyParams);
        return true;
      }
      catch (IOException paramSneakyParams)
      {
        QLog.e("SneakyCallback", 1, "[wakeViaShellCommand] ", paramSneakyParams);
      }
    }
    return false;
  }
  
  private boolean a(Set<String> paramSet, SneakyParams paramSneakyParams)
  {
    return paramSet.contains(paramSneakyParams.getTargetProcessName());
  }
  
  private static String b(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { new String(paramString) });
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      QLog.e("SneakyCallback", 1, "[getSystemProperty] ", paramString);
      return "unknown";
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        QLog.e("SneakyCallback", 1, "[getSystemProperty] ", paramString);
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        QLog.e("SneakyCallback", 1, "[getSystemProperty] ", paramString);
      }
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        QLog.e("SneakyCallback", 1, "[getSystemProperty] ", paramString);
      }
    }
  }
  
  public static void b()
  {
    oxs.b(a);
  }
  
  private void b(int paramInt)
  {
    a(paramInt, Aladdin.get(139).getList("param_list"));
  }
  
  private boolean b(int paramInt, SneakyParams paramSneakyParams)
  {
    return (paramSneakyParams.getWakeOccasion() & paramInt) > 0;
  }
  
  public void l()
  {
    ThreadManager.executeOnSubThread(new SneakyCallback.1(this));
  }
  
  public void m()
  {
    ThreadManager.executeOnSubThread(new SneakyCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tah
 * JD-Core Version:    0.7.0.1
 */