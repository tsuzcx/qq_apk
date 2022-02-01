import com.tencent.qphone.base.util.QLog;

final class mon
  implements mnx
{
  public void a(int paramInt)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onError " + paramInt);
    mol.a(false, paramInt);
  }
  
  public void a(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onStart " + paramString);
  }
  
  public void b(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onFinish " + paramString);
    mol.a(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mon
 * JD-Core Version:    0.7.0.1
 */