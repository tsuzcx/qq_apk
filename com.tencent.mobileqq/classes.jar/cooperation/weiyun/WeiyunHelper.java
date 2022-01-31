package cooperation.weiyun;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.weiyun.utils.NetworkUtils;
import cooperation.weiyun.sdk.api.WeiyunApi;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public final class WeiyunHelper
{
  private static final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private static String jdField_a_of_type_JavaLangString;
  private static final Map jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean = false;
  private static String b;
  private static String c;
  private static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    b = "";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), "16*16");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), "32*32");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), "64*64");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), "128*128");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), "320*320");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), "384*384");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(6), "640*640");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), "750*750");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), "1024*1024");
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(9);
    jdField_a_of_type_AndroidUtilSparseArray.put(0, "/16");
    jdField_a_of_type_AndroidUtilSparseArray.put(1, "/32");
    jdField_a_of_type_AndroidUtilSparseArray.put(2, "/64");
    jdField_a_of_type_AndroidUtilSparseArray.put(3, "/128");
    jdField_a_of_type_AndroidUtilSparseArray.put(4, "/320");
    jdField_a_of_type_AndroidUtilSparseArray.put(5, "/384");
    jdField_a_of_type_AndroidUtilSparseArray.put(6, "/640");
    jdField_a_of_type_AndroidUtilSparseArray.put(7, "/750");
    jdField_a_of_type_AndroidUtilSparseArray.put(8, "/1024");
  }
  
  public static PluginRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      Class localClass = Class.forName("com.weiyun.plugin.app.WeiyunRuntime");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "WeiyunPlugin.apk");
        paramBaseApplicationImpl = localClassLoader.loadClass("com.weiyun.plugin.app.WeiyunRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof PluginRuntime)));
      paramBaseApplicationImpl = (PluginRuntime)paramBaseApplicationImpl;
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
    if (paramBaseApplicationImpl == null) {
      return null;
    }
  }
  
  public static Pair a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new Pair(new Pair(paramString, paramString), Long.valueOf(0L));
    }
    String str = (String)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    paramString = new StringBuilder(paramString);
    if (paramBoolean)
    {
      str = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (!TextUtils.isEmpty(str)) {
        paramString.append(str);
      }
      paramString = paramString.toString();
      l = paramString.hashCode() * 31;
      return new Pair(new Pair(paramString, paramString), Long.valueOf(l));
    }
    paramInt = NetworkUtils.getNetworkType(BaseApplicationImpl.getApplication());
    paramString.append("&nettype=").append(paramInt);
    if (!TextUtils.isEmpty(str)) {
      paramString.append("&size=").append(str);
    }
    paramString = paramString.toString();
    str = paramString.replaceFirst("cn=\\d", "").replaceFirst("nettype=\\d", "");
    long l = str.hashCode() * 31;
    return new Pair(new Pair(paramString, str), Long.valueOf(l));
  }
  
  public static String a()
  {
    return c;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = String.format("https://jump.weiyun.com/?from=30001&aid=%s", new Object[] { paramString2 });
    QLog.d("Weiyun.AlbumBackup", 2, "weiyun vip payurl : " + paramString1);
    return paramString1;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      try
      {
        if (!jdField_a_of_type_Boolean)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          TransmissionHelper.a(localBaseApplicationImpl, false);
          WeiyunApi.a(localBaseApplicationImpl);
          a(localBaseApplicationImpl);
          jdField_a_of_type_Boolean = true;
        }
        return;
      }
      finally {}
    }
  }
  
  private static void a(Application paramApplication)
  {
    c = FMSettings.a().b();
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (paramApplication = new File(AppConstants.aK);; paramApplication = paramApplication.getCacheDir())
    {
      d = new File(paramApplication, "diskcache").getAbsolutePath();
      return;
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("enter_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    WeiyunApi.a(paramContext, paramLong);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      jdField_a_of_type_JavaLangString = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      b = paramString2;
    }
  }
  
  public static String[] a()
  {
    return new String[] { jdField_a_of_type_JavaLangString, b };
  }
  
  public static String b()
  {
    return d;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Boolean) {
      try
      {
        if (jdField_a_of_type_Boolean)
        {
          TransmissionHelper.a(false, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
          jdField_a_of_type_Boolean = false;
        }
        return;
      }
      finally {}
    }
  }
  
  public static void b(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("exit_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
  
  public static String c()
  {
    QLog.d("Weiyun.AlbumBackup", 2, "weiyun shapce payurl : " + "https://jump.weiyun.com/?from=3047");
    return "https://jump.weiyun.com/?from=3047";
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaLangString = "";
    b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.WeiyunHelper
 * JD-Core Version:    0.7.0.1
 */