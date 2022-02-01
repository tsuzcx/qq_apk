import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog;
import com.tencent.qphone.base.util.QLog;

public class qsi
  implements LogUtil.ProteusLog
{
  public void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, paramInt, paramString2);
  }
  
  public void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public void w(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, paramInt, paramString2);
  }
  
  public void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, paramInt, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qsi
 * JD-Core Version:    0.7.0.1
 */