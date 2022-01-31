package cooperation.dingdong;

import alup;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class DingdongPluginHelper
{
  public static int a = 3;
  public static int b = 2;
  public static int c = 1;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 1;
    }
    return 2;
  }
  
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.dingdong.app.DingdongAppInterface");
      if (localClass1 == null) {
        return null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2;
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "dingdong_plugin.apk");
        localClass2 = localClassLoader.loadClass("com.dingdong.app.DingdongAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      switch (paramInt)
      {
      default: 
        paramString1 = ContactUtils.k((QQAppInterface)localObject, paramString2);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        return paramString2;
        paramString1 = ContactUtils.g((QQAppInterface)localObject, paramString1, paramString2);
        continue;
        paramString1 = ContactUtils.a((QQAppInterface)localObject, paramString1, paramString2);
      }
      else
      {
        return paramString1;
        paramString1 = null;
      }
    }
  }
  
  public static String a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    Object localObject = Calendar.getInstance();
    if (a(localCalendar1, localCalendar2)) {
      if ((paramBoolean) && (a((Calendar)localObject, localCalendar1)))
      {
        localObject = new SimpleDateFormat("kk:mm", Locale.getDefault());
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar1.getTime()));
        localStringBuilder.append(" ~ ");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar2.getTime()));
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(new SimpleDateFormat("M月d日 kk:mm", Locale.getDefault()).format(localCalendar1.getTime()));
      localStringBuilder.append(" ~ ");
      localStringBuilder.append(new SimpleDateFormat("kk:mm", Locale.getDefault()).format(localCalendar2.getTime()));
      continue;
      if (paramBoolean)
      {
        if (a((Calendar)localObject, localCalendar1))
        {
          localStringBuilder.append(new SimpleDateFormat("今天 kk:mm", Locale.getDefault()).format(localCalendar1.getTime()));
          localStringBuilder.append(" ~ ");
          localStringBuilder.append(new SimpleDateFormat("M月d日 kk:mm", Locale.getDefault()).format(localCalendar2.getTime()));
        }
      }
      else
      {
        localObject = new SimpleDateFormat("M月d日 kk:mm", Locale.getDefault());
        localStringBuilder.append("开始：");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar1.getTime()));
        localStringBuilder.append("\r\n结束：");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar2.getTime()));
      }
    }
  }
  
  public static void a(int paramInt, Intent paramIntent)
  {
    new alup(paramIntent, paramInt).execute(new Void[] { null, null, null });
  }
  
  public static void a(int paramInt, String paramString)
  {
    b(paramInt, paramString, 1);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    int i = 3;
    if (paramInt2 == 2) {
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != -1) {
        a(paramInt1, paramString);
      }
      return;
      if (paramInt2 == 4) {
        paramInt1 = 4;
      } else if (paramInt2 == 5) {
        paramInt1 = 1;
      } else if (paramInt2 == 3) {
        paramInt1 = 0;
      } else {
        paramInt1 = a(paramInt1);
      }
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label52;
      }
    }
    label52:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", paramString1, paramString2, paramInt1, paramInt2, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("workid", paramString);
    if (b == paramInt) {
      a(paramActivity, "com.dingdong.business.approval.activity.ApprovalCommonDetailActivity", localIntent, -1);
    }
    do
    {
      return;
      if (a == paramInt)
      {
        a(paramActivity, "com.dingdong.business.approval.activity.ApprovalExpenseDetailActivity", localIntent, -1);
        return;
      }
    } while (c != paramInt);
    a(paramActivity, "com.dingdong.business.approval.activity.ApprovalHolidayDetailActivity", localIntent, -1);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      if (a(paramActivity))
      {
        DingdongPluginProxyActivity.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramActivity, paramString, paramIntent, paramInt, null);
        return;
      }
      paramIntent.setClass(paramActivity, DingdongPluginBridgeActivity.class);
      paramIntent.putExtra("_from_componet_", paramString);
      paramIntent.putExtra("_request_code_", paramInt);
      paramIntent.putExtra("userQqResources", 2);
      paramActivity.startActivity(paramIntent);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    b(-1, paramString, 1);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label49;
      }
    }
    label49:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "ScheduleClickReport", paramString, 0, paramInt, 0, "", "", "", "");
      return;
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            int i = "com.tencent.mobileqq:dingdong".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName);
            if (i == 0) {
              return true;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
    }
    return false;
  }
  
  public static boolean a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return (paramCalendar1.get(5) == paramCalendar2.get(5)) && (paramCalendar1.get(2) == paramCalendar2.get(2)) && (paramCalendar1.get(1) == paramCalendar2.get(1));
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 3000;
  }
  
  public static void b(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label49;
      }
    }
    label49:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "DingdongClickReport", paramString, paramInt1, paramInt2, 0, "", "", "", "");
      return;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (localObject != null)
      {
        paramContext = paramContext.getApplicationContext().getPackageName();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (100 == localRunningAppProcessInfo.importance)
          {
            boolean bool = localRunningAppProcessInfo.processName.startsWith(paramContext);
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginHelper
 * JD-Core Version:    0.7.0.1
 */