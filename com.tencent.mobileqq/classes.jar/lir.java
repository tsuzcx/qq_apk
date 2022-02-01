import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class lir
  extends lio
{
  private static int jdField_c_of_type_Int = -1;
  static long d = 30000L;
  long jdField_c_of_type_Long = 0L;
  
  public lir(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    return ((lin)paramVideoAppInterface.a(5)).a(2, "ptu_so");
  }
  
  public static boolean b()
  {
    return jdField_c_of_type_Int == 1;
  }
  
  private boolean c()
  {
    if (d()) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_Int < 17)
      {
        lbd.f("SupportPendant", "isUserEffectFace error  OSversion:" + this.jdField_a_of_type_Int);
        return false;
      }
      if (this.jdField_b_of_type_Int < 4)
      {
        lbd.f("SupportPendant", "isUserEffectFace error cpucount:" + this.jdField_b_of_type_Int);
        return false;
      }
      if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long < 1400000L))
      {
        lbd.f("SupportPendant", "isUserEffectFace error cpuFrequency:" + this.jdField_a_of_type_Long);
        return false;
      }
    } while (this.jdField_b_of_type_Long >= 1073741824L);
    lbd.f("SupportPendant", "isUserEffectFace error  memory:" + this.jdField_b_of_type_Long);
    return false;
  }
  
  private static boolean d()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  public int a(String paramString)
  {
    return 0;
  }
  
  public boolean a()
  {
    if (jdField_c_of_type_Int != 1)
    {
      if (bnky.b(bnkt.b)) {
        break label138;
      }
      long l1 = System.currentTimeMillis();
      if (l1 <= this.jdField_c_of_type_Long) {
        break label121;
      }
      long l2 = AudioHelper.c();
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.g()) {
        break label114;
      }
      jdField_c_of_type_Int = 1;
      long l3 = AudioHelper.c();
      QLog.w("SupportPendant", 1, "isDownloadedPTUSO, isFilterSoDownLoadSuc[" + jdField_c_of_type_Int + "], cost[" + (l3 - l2) + "]");
      this.jdField_c_of_type_Long = (l1 + d);
    }
    for (;;)
    {
      if (jdField_c_of_type_Int == 1)
      {
        return true;
        label114:
        jdField_c_of_type_Int = 0;
        break;
        label121:
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.w("SupportPendant", 1, "isDownloadedPTUSO, 频繁调用");
        continue;
        label138:
        jdField_c_of_type_Int = 1;
        boolean bool = bnky.b(bnkt.c);
        if (!bool) {}
        try
        {
          Intent localIntent = new Intent();
          localIntent.setAction("tencent.video.v2q.checkPtuRes");
          localIntent.putExtra("packageIdx", bnkt.c.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
          if (QLog.isColorLevel()) {
            QLog.i("PtuResCheck", 2, "downloadPtuSO, extend res ready [" + bool + "]");
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.i("PtuResCheck", 1, "downloadPtuSO", localThrowable);
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ("ptu_so".equalsIgnoreCase(paramString)) {
      return a();
    }
    return c();
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lir
 * JD-Core Version:    0.7.0.1
 */