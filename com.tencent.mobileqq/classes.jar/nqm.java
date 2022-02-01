import android.os.Build;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.qphone.base.util.QLog;

public class nqm
{
  public static final nqn a = new nqn(27, 8, 2.0F, 5.0F);
  public static final nqn b = new nqn(23, 6, 1.8F, 3.0F);
  public static final nqn c = new nqn(21, 4, 1.3F, 2.6F);
  
  public static int a()
  {
    nqn localnqn3 = b;
    nqn localnqn2 = c;
    nqn localnqn1 = a;
    Object localObject = (nqg)aqxe.a().a(642);
    if (localObject != null)
    {
      localnqn3 = ((nqg)localObject).b();
      localnqn2 = ((nqg)localObject).c();
      localnqn1 = ((nqg)localObject).a();
    }
    for (;;)
    {
      localObject = AEFilterSupport.a();
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMachineLevelUtils", 2, ((lor)localObject).toString());
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
      QLog.d("AvGameMachineLevelUtils", 2, "getCurMachine level is " + i + " api=" + ((lor)localObject).jdField_a_of_type_Int + " cpuNum:" + ((lor)localObject).jdField_b_of_type_Int + " maxFreqGHZ=" + ((lor)localObject).jdField_a_of_type_Float + " ramSizeGB:" + ((lor)localObject).jdField_b_of_type_Float);
      QLog.d("AvGameMachineLevelUtils", 2, "lowMatchine level is  api=" + localnqn2.jdField_a_of_type_Int + " cpuNum:" + localnqn2.jdField_b_of_type_Int + " maxFreqGHZ=" + localnqn2.jdField_a_of_type_Float + " ramSizeGB:" + localnqn2.jdField_b_of_type_Float);
      return i;
      if (localnqn1.a((lor)localObject)) {
        i = 3;
      } else if (localnqn3.a((lor)localObject)) {
        i = 2;
      } else if (localnqn2.a((lor)localObject)) {
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
 * Qualified Name:     nqm
 * JD-Core Version:    0.7.0.1
 */