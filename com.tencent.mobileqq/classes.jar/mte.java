import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class mte
{
  private static Boolean[] a;
  
  private static void a()
  {
    a = new Boolean[4];
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qavUseSurface.name(), "1|1|1|1");
    int i;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      i = 0;
      if (i < a.length)
      {
        if (i < arrayOfString.length) {
          a[i] = Boolean.valueOf("1".equals(arrayOfString[i]));
        }
        for (;;)
        {
          i += 1;
          break;
          a[i] = Boolean.valueOf(false);
        }
      }
    }
    else
    {
      i = 0;
      while (i < a.length)
      {
        a[i] = Boolean.valueOf(false);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavDpcUtil", 2, "initQavSurfaceDpc, dpcValue[" + str + "]");
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (a == null) {
      a();
    }
    if ((a == null) || (paramInt >= a.length)) {}
    while ((a[paramInt] == null) || (!a[paramInt].booleanValue())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mte
 * JD-Core Version:    0.7.0.1
 */