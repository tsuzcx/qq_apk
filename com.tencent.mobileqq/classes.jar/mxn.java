import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mxn
{
  private mxl[] a = new mxl[5];
  
  private mxl b(AVGameAppInterface paramAVGameAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = SystemClock.elapsedRealtime();
    }
    switch (paramInt)
    {
    default: 
      paramAVGameAppInterface = localObject;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l2 = SystemClock.elapsedRealtime();
        QLog.i("HandlerFactory", 2, "createBusinessHandler, cost[" + (l2 - l1) + "], handlerId[" + paramInt + "], handler[" + paramAVGameAppInterface + "]");
      }
      return paramAVGameAppInterface;
      paramAVGameAppInterface = new mxo(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new nad(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new nac(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new nae(paramAVGameAppInterface);
    }
  }
  
  public mxl a(AVGameAppInterface paramAVGameAppInterface, int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      localObject = null;
    }
    mxl localmxl;
    do
    {
      return localObject;
      localmxl = this.a[paramInt];
      localObject = localmxl;
    } while (localmxl != null);
    synchronized (this.a)
    {
      localmxl = this.a[paramInt];
      localObject = localmxl;
      if (localmxl == null) {
        localObject = b(paramAVGameAppInterface, paramInt);
      }
      if (localObject != null) {
        this.a[paramInt] = localObject;
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxn
 * JD-Core Version:    0.7.0.1
 */