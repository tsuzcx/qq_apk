import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lqf
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int = -1;
  private static int b = -1;
  
  public static float a()
  {
    if (jdField_a_of_type_Float != -1.0F) {
      return jdField_a_of_type_Float;
    }
    for (;;)
    {
      try
      {
        lpe locallpe = lpe.a();
        if (locallpe == null) {
          continue;
        }
        jdField_a_of_type_Float = locallpe.a();
        if (QLog.isColorLevel()) {
          QLog.w("LowlightAndDenoiseTools", 1, "getVideodenoiseRatio[" + jdField_a_of_type_Float + "]");
        }
      }
      catch (Exception localException)
      {
        QLog.w("LowlightAndDenoiseTools", 1, "getVideoDenoiseRatio, Excpetion", localException);
        jdField_a_of_type_Float = 15.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 15.0F;
    }
  }
  
  static boolean a()
  {
    return lpu.a(8, 1800000, -2147483648);
  }
  
  public static boolean b()
  {
    if (AudioHelper.a(12) == 1)
    {
      AudioHelper.a(ajya.a(2131706404));
      return true;
    }
    if (AudioHelper.a(12) == 0)
    {
      AudioHelper.a(ajya.a(2131706406));
      return true;
    }
    if (jdField_a_of_type_Int == -1) {}
    for (;;)
    {
      try
      {
        locallpe = lpe.a();
        if (locallpe == null) {
          continue;
        }
        if (!locallpe.a()) {
          continue;
        }
        jdField_a_of_type_Int = 1;
        i = 1;
      }
      catch (Exception localException)
      {
        lpe locallpe;
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportLowlight, Excpetion", localException);
        jdField_a_of_type_Int = 0;
        continue;
        int i = 4;
        jdField_a_of_type_Int = 0;
        continue;
        i = 5;
        jdField_a_of_type_Int = 0;
        continue;
        i = 0;
        continue;
      }
      if (jdField_a_of_type_Int == -1)
      {
        if (!msn.b()) {
          continue;
        }
        if (!a()) {
          continue;
        }
        i = 3;
        jdField_a_of_type_Int = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportLowlight[" + jdField_a_of_type_Int + "], step[" + i + "]");
      }
      if (jdField_a_of_type_Int == 1) {
        break;
      }
      return false;
      if (!locallpe.b()) {
        continue;
      }
      i = 2;
      jdField_a_of_type_Int = 0;
    }
  }
  
  public static boolean c()
  {
    if (AudioHelper.a(12) == 1)
    {
      AudioHelper.a(ajya.a(2131706403));
      return true;
    }
    if (AudioHelper.a(12) == 0)
    {
      AudioHelper.a(ajya.a(2131706405));
      return true;
    }
    if (b == -1) {}
    try
    {
      locallpe = lpe.a();
      if (locallpe == null) {
        break label187;
      }
      if (!locallpe.c()) {
        break label145;
      }
      b = 1;
      jdField_a_of_type_Float = 25.0F;
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        lpe locallpe;
        label70:
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportVideoDenoiseFlag, Excpetion", localException);
        b = 0;
        continue;
        int i = 0;
      }
    }
    if (b == -1)
    {
      if (!a()) {
        break label161;
      }
      b = 1;
    }
    for (i = 3;; i = 4)
    {
      if (QLog.isColorLevel()) {
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportVideoDenoiseFlag[" + b + "], step[" + i + "]");
      }
      if (b == 1) {
        break;
      }
      return false;
      label145:
      if (!locallpe.d()) {
        break label187;
      }
      b = 0;
      i = 2;
      break label70;
      label161:
      b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqf
 * JD-Core Version:    0.7.0.1
 */