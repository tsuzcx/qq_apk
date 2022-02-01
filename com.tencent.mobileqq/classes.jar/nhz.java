import android.os.Build;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.qphone.base.util.QLog;

public class nhz
{
  public static final nia a = new nia(27, 8, 2.0F, 5.0F);
  public static final nia b = new nia(23, 6, 1.8F, 3.0F);
  public static final nia c = new nia(21, 4, 1.4F, 2.6F);
  
  public static int a()
  {
    nia localnia3 = b;
    nia localnia2 = c;
    nia localnia1 = a;
    Object localObject = (nht)aran.a().a(642);
    if (localObject != null)
    {
      localnia3 = ((nht)localObject).b();
      localnia2 = ((nht)localObject).c();
      localnia1 = ((nht)localObject).a();
    }
    for (;;)
    {
      localObject = AEFilterSupport.a();
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMachineLevelUtils", 2, ((low)localObject).toString());
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
      if (localnia1.a((low)localObject)) {
        i = 3;
      } else if (localnia3.a((low)localObject)) {
        i = 2;
      } else if (localnia2.a((low)localObject)) {
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
 * Qualified Name:     nhz
 * JD-Core Version:    0.7.0.1
 */