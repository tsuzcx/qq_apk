import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class qzy
{
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static qzy jdField_a_of_type_Qzy;
  private static String jdField_b_of_type_JavaLangString = ors.d;
  private static String c;
  public static boolean c;
  public float a;
  public Context a;
  protected boolean a;
  public float b;
  private long jdField_b_of_type_Long = -1L;
  public boolean b;
  public float c;
  private boolean d;
  private boolean e;
  private boolean f = true;
  
  static
  {
    jdField_c_of_type_JavaLangString = ors.d;
  }
  
  public qzy()
  {
    this(-1);
  }
  
  private qzy(int paramInt)
  {
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = paramInt;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_c_of_type_Float = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / 16.0D * 9.0D));
    this.jdField_b_of_type_Float = (2.0F * this.jdField_c_of_type_Float * 1.2F);
    if (Build.VERSION.SDK_INT >= 14) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "mDeviceAutoPlaySwitch : " + this.jdField_a_of_type_Boolean);
      }
      return;
    }
  }
  
  public static qzy a()
  {
    try
    {
      if (jdField_a_of_type_Qzy == null) {
        jdField_a_of_type_Qzy = new qzy();
      }
      qzy localqzy = jdField_a_of_type_Qzy;
      return localqzy;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.f) {
      jdField_b_of_type_JavaLangString = ors.b();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
        {
          int i = paramContext.getType();
          if (i == 1) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d(qzy.class.getSimpleName(), 2, paramContext.toString());
    }
    return false;
  }
  
  public static boolean e()
  {
    if (jdField_a_of_type_Long == -1L) {
      return false;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
      if (!str.equals(jdField_a_of_type_JavaLangString))
      {
        jdField_a_of_type_JavaLangString = str;
        jdField_a_of_type_Long = -1L;
        return false;
      }
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long >= 600000L) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoAutoPlayController", 2, "canAutoPlayVideo：getKandianMode: " + ors.e());
    }
    if (rcp.a().a()) {}
    do
    {
      do
      {
        QQAppInterface localQQAppInterface;
        do
        {
          return false;
          localQQAppInterface = ors.a();
        } while ((localQQAppInterface != null) && (localQQAppInterface.c()));
        if (ors.e() != 6) {
          break;
        }
        jdField_c_of_type_JavaLangString = ors.a(this.jdField_b_of_type_Long);
      } while (ors.d.equals(jdField_c_of_type_JavaLangString));
      if ((ors.jdField_b_of_type_JavaLangString.equals(jdField_c_of_type_JavaLangString)) && (bdin.g(this.jdField_a_of_type_AndroidContentContext))) {
        return this.jdField_a_of_type_Boolean;
      }
      if ((this.e) && (this.jdField_a_of_type_Boolean)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      jdField_b_of_type_JavaLangString = ors.a(this.jdField_b_of_type_Long);
    } while (ors.d.equals(jdField_b_of_type_JavaLangString));
    if ((ors.jdField_b_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) && (bdin.g(this.jdField_a_of_type_AndroidContentContext))) {
      return this.jdField_a_of_type_Boolean;
    }
    if ((this.e) && (this.jdField_a_of_type_Boolean)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    if (ors.jdField_b_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) {}
    while ((bdin.h(this.jdField_a_of_type_AndroidContentContext)) || (e())) {
      return false;
    }
    return true;
  }
  
  public boolean d()
  {
    if (ors.jdField_b_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) {}
    while ((bdin.h(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_b_of_type_Boolean)) {
      return false;
    }
    return true;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzy
 * JD-Core Version:    0.7.0.1
 */