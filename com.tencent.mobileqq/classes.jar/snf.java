import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.ILogAdapter;

public class snf
  implements ILogAdapter
{
  public void callLog(String paramString1, int paramInt, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString2);
      }
      break;
    }
    do
    {
      do
      {
        return;
        QLog.e(paramString1, 2, paramString2);
        return;
      } while (!QLog.isColorLevel());
      QLog.i(paramString1, 2, paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.w(paramString1, 2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     snf
 * JD-Core Version:    0.7.0.1
 */