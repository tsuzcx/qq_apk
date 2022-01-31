import com.tencent.qphone.base.util.QLog;

final class mql
  implements mpv
{
  public void a(int paramInt)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onError " + paramInt);
    mqj.a(false, paramInt);
  }
  
  public void a(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onStart " + paramString);
  }
  
  public void b(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onFinish " + paramString);
    mqj.a(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mql
 * JD-Core Version:    0.7.0.1
 */