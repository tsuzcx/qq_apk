import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class mqg
{
  private static mqg a;
  public int a;
  public String a;
  public int b = 4;
  public int c = 2000;
  public int d = 4;
  public int e = 2150;
  public int f = 720;
  public int g = 1;
  public int h = 5;
  public int i = 120000;
  public int j = 1;
  public int k = 1;
  public int l = 0;
  public int m = 0;
  public int n = 5000;
  public int o = 0;
  public int p = 25000;
  public int q = 1;
  public int r;
  public int s;
  
  public mqg()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  private static int a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfString == null) || (paramInt1 >= paramArrayOfString.length)) {
      return paramInt2;
    }
    try
    {
      paramInt1 = Integer.parseInt(paramArrayOfString[paramInt1]);
      return paramInt1;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return paramInt2;
  }
  
  public static mqg a()
  {
    if (jdField_a_of_type_Mqg == null) {
      jdField_a_of_type_Mqg = b();
    }
    return jdField_a_of_type_Mqg;
  }
  
  private static mqg b()
  {
    mqg localmqg = new mqg();
    Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.qavDpc.name());
    localmqg.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (!TextUtils.isEmpty(localmqg.jdField_a_of_type_JavaLangString))
    {
      localObject = ((String)localObject).split("\\|");
      localmqg.jdField_a_of_type_Int = a((String[])localObject, 0, 1);
      localmqg.b = a((String[])localObject, 1, 4);
      localmqg.c = a((String[])localObject, 2, 2000);
      localmqg.d = a((String[])localObject, 3, 4);
      localmqg.e = a((String[])localObject, 4, 2150);
      localmqg.f = a((String[])localObject, 5, 720);
      localmqg.g = a((String[])localObject, 6, 1);
      localmqg.h = a((String[])localObject, 7, 5);
      localmqg.i = a((String[])localObject, 8, 120000);
      localmqg.j = a((String[])localObject, 9, 1);
      localmqg.k = a((String[])localObject, 10, 1);
      localmqg.l = a((String[])localObject, 11, 0);
      localmqg.m = a((String[])localObject, 12, 0);
      localmqg.n = a((String[])localObject, 13, 5000);
      localmqg.o = a((String[])localObject, 14, 0);
      localmqg.p = a((String[])localObject, 15, 25000);
      localmqg.q = a((String[])localObject, 16, 1);
    }
    localmqg.r = bdgk.b();
    localmqg.s = ((int)(bdgk.b() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordDpc", 2, "init=" + localmqg);
    }
    return localmqg;
  }
  
  public String toString()
  {
    return String.format(Locale.getDefault(), "QavRecordDpc:dpc=%s, default=%d|%d|%d|%d|%d|%d, value=%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%s|%s|%s, system=%d|%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2000), Integer.valueOf(4), Integer.valueOf(2150), Integer.valueOf(720), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r), Integer.valueOf(this.s) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqg
 * JD-Core Version:    0.7.0.1
 */