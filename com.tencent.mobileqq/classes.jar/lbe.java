import com.tencent.qphone.base.util.QLog;

public class lbe
  implements ncq
{
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, 1, paramString2, paramThrowable);
  }
  
  public boolean a()
  {
    return QLog.isDevelopLevel();
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public void c(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  public void f(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void g(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void h(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbe
 * JD-Core Version:    0.7.0.1
 */