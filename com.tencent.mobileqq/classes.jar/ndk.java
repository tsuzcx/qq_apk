import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ndk
{
  private ndi[] a = new ndi[5];
  
  private ndi b(AVGameAppInterface paramAVGameAppInterface, int paramInt)
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
      paramAVGameAppInterface = new ndl(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new ngu(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new ngt(paramAVGameAppInterface);
      continue;
      paramAVGameAppInterface = new ngv(paramAVGameAppInterface);
    }
  }
  
  public ndi a(AVGameAppInterface paramAVGameAppInterface, int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      localObject = null;
    }
    ndi localndi;
    do
    {
      return localObject;
      localndi = this.a[paramInt];
      localObject = localndi;
    } while (localndi != null);
    synchronized (this.a)
    {
      localndi = this.a[paramInt];
      localObject = localndi;
      if (localndi == null) {
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
 * Qualified Name:     ndk
 * JD-Core Version:    0.7.0.1
 */