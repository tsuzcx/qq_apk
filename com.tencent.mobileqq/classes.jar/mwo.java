import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mwo
{
  private mwm[] a = new mwm[5];
  
  private mwm b(AVGameAppInterface paramAVGameAppInterface, int paramInt)
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
      paramAVGameAppInterface = new mwp(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new mza(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new myz(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new mzb(paramAVGameAppInterface);
    }
  }
  
  public mwm a(AVGameAppInterface paramAVGameAppInterface, int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      localObject = null;
    }
    mwm localmwm;
    do
    {
      return localObject;
      localmwm = this.a[paramInt];
      localObject = localmwm;
    } while (localmwm != null);
    synchronized (this.a)
    {
      localmwm = this.a[paramInt];
      localObject = localmwm;
      if (localmwm == null) {
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
 * Qualified Name:     mwo
 * JD-Core Version:    0.7.0.1
 */