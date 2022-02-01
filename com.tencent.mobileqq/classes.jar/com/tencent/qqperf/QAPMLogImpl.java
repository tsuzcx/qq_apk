package com.tencent.qqperf;

import com.tencent.qapmsdk.common.logger.ILogProxy;
import com.tencent.qapmsdk.common.logger.LogState;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class QAPMLogImpl
  implements ILogProxy
{
  int a;
  
  public QAPMLogImpl(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void doLog(@NotNull LogState paramLogState, @NotNull String... paramVarArgs)
  {
    if (paramLogState.getValue() > this.a) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 1))
    {
      Object localObject = paramVarArgs[0];
      localObject = new StringBuilder(256);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        ((StringBuilder)localObject).append(paramVarArgs[i]);
        i += 1;
      }
      i = QAPMLogImpl.1.a[paramLogState.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              QLog.e(paramVarArgs[0], 1, ((StringBuilder)localObject).toString());
              return;
            }
            QLog.w(paramVarArgs[0], 1, ((StringBuilder)localObject).toString());
            return;
          }
          QLog.i(paramVarArgs[0], 1, ((StringBuilder)localObject).toString());
        }
      }
      else {
        QLog.d(paramVarArgs[0], 2, ((StringBuilder)localObject).toString());
      }
      QLog.d(paramVarArgs[0], 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void flush(@NotNull String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.QAPMLogImpl
 * JD-Core Version:    0.7.0.1
 */