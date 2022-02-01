import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mxy
{
  private mxw[] a = new mxw[5];
  
  private mxw b(AVGameAppInterface paramAVGameAppInterface, int paramInt)
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
      paramAVGameAppInterface = new mxz(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new nbe(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new nbd(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new nbf(paramAVGameAppInterface);
    }
  }
  
  public mxw a(AVGameAppInterface paramAVGameAppInterface, int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      localObject = null;
    }
    mxw localmxw;
    do
    {
      return localObject;
      localmxw = this.a[paramInt];
      localObject = localmxw;
    } while (localmxw != null);
    synchronized (this.a)
    {
      localmxw = this.a[paramInt];
      localObject = localmxw;
      if (localmxw == null) {
        localObject = b(paramAVGameAppInterface, paramInt);
      }
      if (localObject != null) {
        this.a[paramInt] = localObject;
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxy
 * JD-Core Version:    0.7.0.1
 */