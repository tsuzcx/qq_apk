import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class n
{
  public static final String a = Build.MANUFACTURER;
  public static final String b = Build.MODEL;
  
  public static void a(String paramString1, long paramLong, String paramString2)
  {
    if (!l.a) {
      return;
    }
    float f = (float)(System.nanoTime() - paramLong) / 1000000.0F;
    a(paramString1, paramString2 + "  绘制耗时：" + f + "ms\n  手机型号：" + a + "  " + b);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     n
 * JD-Core Version:    0.7.0.1
 */