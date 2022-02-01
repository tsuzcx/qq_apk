import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.qphone.base.util.QLog;

public class nge
{
  public static final ngf a = new ngf(27, 8, 2.0F, 5.0F);
  public static final ngf b = new ngf(23, 6, 1.8F, 3.0F);
  public static final ngf c = new ngf(21, 4, 1.4F, 2.6F);
  
  public static int a()
  {
    ngf localngf3 = b;
    ngf localngf2 = c;
    ngf localngf1 = a;
    Object localObject = (nfy)aqlk.a().a(642);
    if (localObject != null)
    {
      localngf3 = ((nfy)localObject).b();
      localngf2 = ((nfy)localObject).c();
      localngf1 = ((nfy)localObject).a();
    }
    for (;;)
    {
      localObject = AEFilterSupport.a();
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMachineLevelUtils", 2, ((loj)localObject).toString());
      }
      if (localObject != null) {
        break;
      }
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineInfo null");
      return 2;
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineLevel no bean");
    }
    int i;
    if (localngf1.a((loj)localObject)) {
      i = 3;
    }
    for (;;)
    {
      QLog.d("AvGameMachineLevelUtils", 2, "getCurMachine level is " + i);
      return i;
      if (localngf3.a((loj)localObject)) {
        i = 2;
      } else if (localngf2.a((loj)localObject)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nge
 * JD-Core Version:    0.7.0.1
 */