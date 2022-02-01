import com.tencent.qphone.base.util.QLog;

public class liv
{
  public static void a()
  {
    a("0X8009850");
  }
  
  static void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("VoiceRecogReport", 1, "report, key[" + paramString + "]");
    }
    bdla.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", null, null);
  }
  
  public static void b()
  {
    a("0X8009851");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     liv
 * JD-Core Version:    0.7.0.1
 */