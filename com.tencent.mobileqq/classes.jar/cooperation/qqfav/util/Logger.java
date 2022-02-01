package cooperation.qqfav.util;

import com.tencent.qphone.base.util.QLog;

public class Logger
{
  private static int a;
  private final boolean b = true;
  private String c;
  private int d = 3;
  
  static
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    while (i < arrayOfStackTraceElement.length)
    {
      if (Logger.class.getName().equals(arrayOfStackTraceElement[i].getClassName()))
      {
        a = i;
        return;
      }
      i += 1;
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    if ((paramInt1 == 2) || (paramInt1 == 4)) {}
    StringBuilder localStringBuilder;
    try
    {
      boolean bool = QLog.isDevelopLevel();
      if (!bool)
      {
        return;
        bool = QLog.isColorLevel();
        if (!bool) {
          return;
        }
      }
      localStringBuilder = b(paramInt3);
      if (paramString2 != null) {
        localStringBuilder.append(paramString2);
      }
      paramString2 = paramString1;
      if (paramString1 != null) {
        break label139;
      }
      paramString2 = this.c;
    }
    finally {}
    QLog.e(paramString2, paramInt1, localStringBuilder.toString());
    break label131;
    label92:
    QLog.w(paramString2, paramInt1, localStringBuilder.toString());
    break label131;
    label106:
    QLog.i(paramString2, paramInt1, localStringBuilder.toString());
    break label131;
    label120:
    QLog.d(paramString2, paramInt1, localStringBuilder.toString());
    for (;;)
    {
      label131:
      return;
      label139:
      if (paramInt2 == 3) {
        break label120;
      }
      if (paramInt2 == 4) {
        break label106;
      }
      if (paramInt2 == 5) {
        break label92;
      }
      if (paramInt2 == 6) {
        break;
      }
    }
  }
  
  private StringBuilder b(int paramInt)
  {
    return new StringBuilder();
  }
  
  public Logger a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Logger a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, 6, paramString2, this.d);
    return this;
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public Logger b(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, 4, paramString2, this.d);
    return this;
  }
  
  public Logger c(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, 3, paramString2, this.d);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.util.Logger
 * JD-Core Version:    0.7.0.1
 */