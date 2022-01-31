import com.tencent.qphone.base.util.QLog;

final class lye
  extends mul
{
  lye(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void a(String paramString)
  {
    lyd.a(null);
    if (QLog.isColorLevel()) {
      QLog.d("AVPushReport", 2, "onAvReportPush SimpleHttpPostTask rsp = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lye
 * JD-Core Version:    0.7.0.1
 */