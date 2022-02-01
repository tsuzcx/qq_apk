import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class pmx
{
  private static int jdField_a_of_type_Int;
  private static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  public static String b = "_viola_reinstall_delJSC_succ_810";
  private static String c = "";
  private static String d;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    d = "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/android.qq.readinjoy.viola_biz_810.js";
    jdField_a_of_type_JavaLangString = "_viola_reinstall_delBiz_succ_810";
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(c))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label65;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (TextUtils.isEmpty(c)) {
        c = ((File)localObject).getParent() + "/txlib/" + "readinjoy_viola/";
      }
    }
    for (;;)
    {
      return c;
      label65:
      QLog.w("viola.ReadInjoyWebRenderSoLoader", 2, "getSoLibPath but context is null");
    }
  }
  
  private static boolean a()
  {
    SharedPreferences localSharedPreferences = bmqa.a(pha.a(), true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "isReinstallDelSucc  failed");
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean(b, false);
    QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "isReinstallDelSucc sp result=" + bool);
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      a();
      boolean bool = TextUtils.isEmpty(c);
      if (!bool) {}
      try
      {
        jdField_a_of_type_Int = 1;
        bgmg.a(paramString, c, false);
        jdField_a_of_type_Int = 0;
        QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, "succeed to unzip so.");
        if (jdField_a_of_type_Int == 0) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          jdField_a_of_type_Int = 2;
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, paramString, new Object[0]);
        }
      }
    }
    return false;
  }
  
  public static boolean a(pmt parampmt)
  {
    if (a()) {
      return true;
    }
    ThreadManager.post(new ReadInjoyWebRenderSoLoader.1(parampmt), 8, null, true);
    return false;
  }
  
  private static void c()
  {
    Object localObject = bmqa.a(pha.a(), true, true);
    if (localObject == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "delSoReinstall sp failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "delSoReinstall sp update to true");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(b, true);
    bmqa.a((SharedPreferences.Editor)localObject, true);
  }
  
  private static boolean c(String paramString)
  {
    QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, "[delAllSo]" + paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        String str = a();
        bgmg.d(str + paramString);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          try
          {
            if (new File(a(), paramString).exists()) {
              break;
            }
            QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "reinstallDelSO  " + paramString + "succ");
            return true;
          }
          catch (Throwable paramString) {}
          localThrowable = localThrowable;
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, localThrowable, new Object[0]);
        }
      }
    }
    return false;
  }
  
  private static void d()
  {
    Object localObject = bmqa.a(pha.a(), true, true);
    if (localObject == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "delSoReinstall sp failed");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(jdField_a_of_type_JavaLangString, true);
    bmqa.a((SharedPreferences.Editor)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmx
 * JD-Core Version:    0.7.0.1
 */