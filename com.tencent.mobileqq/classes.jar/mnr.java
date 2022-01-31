import com.tencent.qphone.base.util.QLog;

final class mnr
  implements mnb
{
  public void a(int paramInt)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onError " + paramInt);
    mnp.a(false, paramInt);
  }
  
  public void a(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onStart " + paramString);
  }
  
  public void b(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onFinish " + paramString);
    mnp.a(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mnr
 * JD-Core Version:    0.7.0.1
 */