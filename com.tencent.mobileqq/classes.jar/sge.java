import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class sge
{
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static sge jdField_a_of_type_Sge;
  private static String jdField_b_of_type_JavaLangString = pqu.jdField_c_of_type_JavaLangString;
  private static String c;
  public static boolean c;
  public float a;
  private int jdField_a_of_type_Int = 0;
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
    jdField_c_of_type_JavaLangString = pqu.jdField_c_of_type_JavaLangString;
  }
  
  public sge()
  {
    this(-1);
  }
  
  private sge(int paramInt)
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
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "mDeviceAutoPlaySwitch : " + this.jdField_a_of_type_Boolean);
      }
      return;
      bool = false;
    }
  }
  
  public static sge a()
  {
    try
    {
      if (jdField_a_of_type_Sge == null) {
        jdField_a_of_type_Sge = new sge();
      }
      sge localsge = jdField_a_of_type_Sge;
      return localsge;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.f) {
      jdField_b_of_type_JavaLangString = pqu.a();
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
      QLog.d(sge.class.getSimpleName(), 2, paramContext.toString());
    }
    return false;
  }
  
  public static boolean d()
  {
    if (jdField_a_of_type_Long == -1L) {
      return false;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      if (!str.equals(jdField_a_of_type_JavaLangString))
      {
        jdField_a_of_type_JavaLangString = str;
        jdField_a_of_type_Long = -1L;
        return false;
      }
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 600000L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
    boolean bool3 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoAutoPlayController", 2, "canAutoPlayVideo：getKandianMode: " + pqu.a());
    }
    QQAppInterface localQQAppInterface = pnn.a();
    if ((localQQAppInterface != null) && (localQQAppInterface.isVideoChatting())) {}
    do
    {
      do
      {
        return false;
        if (pqu.a() != 6) {
          break;
        }
        jdField_c_of_type_JavaLangString = pqu.a(this.jdField_b_of_type_Long);
      } while (pqu.jdField_c_of_type_JavaLangString.equals(jdField_c_of_type_JavaLangString));
      if ((pqu.jdField_a_of_type_JavaLangString.equals(jdField_c_of_type_JavaLangString)) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
        return this.jdField_a_of_type_Boolean;
      }
      if ((this.e) && (this.jdField_a_of_type_Boolean)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      jdField_b_of_type_JavaLangString = pqu.a(this.jdField_b_of_type_Long);
    } while (pqu.jdField_c_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString));
    if ((pqu.jdField_a_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if (((this.e) || (ukr.a(a().jdField_a_of_type_AndroidContentContext))) && (this.jdField_a_of_type_Boolean)) {}
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
    if ((this.e) && (this.jdField_a_of_type_Boolean)) {}
    for (bool1 = bool3;; bool1 = false) {
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
    if (pqu.jdField_a_of_type_JavaLangString.equals(jdField_b_of_type_JavaLangString)) {}
    while ((NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) || (d())) {
      return false;
    }
    return true;
  }
  
  public boolean e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sge
 * JD-Core Version:    0.7.0.1
 */