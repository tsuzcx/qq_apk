import com.tencent.qphone.base.util.QLog;

public class qhy
{
  public static void a(String paramString1, String paramString2)
  {
    a("0X800A833", "", "", "", new qhz().a("type", paramString2).a("msg", paramString1).a());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QLog.i("PTSReport", 1, "[reportData], actionName = " + paramString1 + ", r2 = " + paramString2 + ", r3 = " + paramString3 + ", r4 = " + paramString4 + ", r5 = " + paramString5);
    ocd.a(null, "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5, false);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a("0X800A832", "", "", "", new qhz().a("type", paramString2).a("msg", paramString1).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhy
 * JD-Core Version:    0.7.0.1
 */