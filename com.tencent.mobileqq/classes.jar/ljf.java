import android.os.Handler;
import android.os.Looper;
import com.tencent.av.camera.CameraObserver.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class ljf
  implements Observer
{
  Handler a = null;
  
  private void a(Object paramObject)
  {
    long l = 0L;
    if (paramObject == null) {
      return;
    }
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isDevelopLevel()) {
      QLog.w("CameraObserver", 1, "onUpdate, msgType[" + i + "]");
    }
    boolean bool;
    switch (i)
    {
    default: 
      return;
    case 1: 
      if (paramObject.length > 1)
      {
        bool = ((Boolean)paramObject[1]).booleanValue();
        if (paramObject.length <= 2) {
          break label317;
        }
      }
      break;
    }
    label317:
    for (l = ((Long)paramObject[2]).longValue();; l = 0L)
    {
      a(l, bool);
      return;
      a();
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      i = ((Integer)paramObject[2]).intValue();
      if (paramObject.length > 3) {
        l = ((Long)paramObject[3]).longValue();
      }
      a(l, bool, i);
      return;
      if (paramObject.length > 1) {
        l = ((Long)paramObject[1]).longValue();
      }
      a(l);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      if (paramObject.length > 2) {
        l = ((Long)paramObject[2]).longValue();
      }
      b(l, bool);
      return;
      b();
      return;
      a(((Boolean)paramObject[1]).booleanValue());
      return;
      try
      {
        paramObject = (byte[])paramObject[1];
        a(paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
          paramObject = null;
        }
      }
      b(((Boolean)paramObject[1]).booleanValue());
      return;
    }
  }
  
  @Deprecated
  protected void a() {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(byte[] paramArrayOfByte) {}
  
  protected void b() {}
  
  protected void b(long paramLong, boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new CameraObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljf
 * JD-Core Version:    0.7.0.1
 */