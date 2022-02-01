package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderConfigProcessor;
import java.lang.ref.WeakReference;

final class TdsReaderGlobal$RunnableImpl
  implements Runnable
{
  private final WeakReference<TdsReaderGlobal> a;
  private final int b;
  private final Object[] c;
  
  private TdsReaderGlobal$RunnableImpl(TdsReaderGlobal paramTdsReaderGlobal, int paramInt, Object... paramVarArgs)
  {
    if (paramTdsReaderGlobal == null) {
      paramTdsReaderGlobal = null;
    } else {
      paramTdsReaderGlobal = new WeakReference(paramTdsReaderGlobal);
    }
    this.a = paramTdsReaderGlobal;
    this.b = paramInt;
    this.c = paramVarArgs;
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (TdsReaderGlobal)((WeakReference)localObject).get();
    }
    int i = this.b;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (localObject != null) {
            TdsReaderGlobal.c((TdsReaderGlobal)localObject, this.c);
          }
        }
        else if (localObject != null)
        {
          TdsReaderGlobal.b((TdsReaderGlobal)localObject, this.c);
        }
      }
      else if (localObject != null) {
        TdsReaderGlobal.a((TdsReaderGlobal)localObject, this.c);
      }
    }
    else {
      TdsReaderConfigProcessor.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.RunnableImpl
 * JD-Core Version:    0.7.0.1
 */