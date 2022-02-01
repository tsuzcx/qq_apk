import android.os.Build;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.qphone.base.util.QLog;

public class njo
{
  public static final njp a = new njp(27, 8, 2.0F, 5.0F);
  public static final njp b = new njp(23, 6, 1.8F, 3.0F);
  public static final njp c = new njp(21, 4, 1.4F, 2.6F);
  
  public static int a()
  {
    njp localnjp3 = b;
    njp localnjp2 = c;
    njp localnjp1 = a;
    Object localObject = (nji)apub.a().a(642);
    if (localObject != null)
    {
      localnjp3 = ((nji)localObject).b();
      localnjp2 = ((nji)localObject).c();
      localnjp1 = ((nji)localObject).a();
    }
    for (;;)
    {
      localObject = AEFilterSupport.a();
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMachineLevelUtils", 2, ((loe)localObject).toString());
      }
      if (localObject != null) {
        break;
      }
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineInfo null");
      return 2;
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineLevel no bean");
    }
    int i;
    if (a()) {
      i = 0;
    }
    for (;;)
    {
      QLog.d("AvGameMachineLevelUtils", 2, "getCurMachine level is " + i);
      return i;
      if (localnjp1.a((loe)localObject)) {
        i = 3;
      } else if (localnjp3.a((loe)localObject)) {
        i = 2;
      } else if (localnjp2.a((loe)localObject)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static boolean a()
  {
    return Build.MODEL.equalsIgnoreCase("MI 5C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njo
 * JD-Core Version:    0.7.0.1
 */