import android.os.Handler;
import android.os.Looper;
import com.tencent.av.app.InviteMemberObserverWithoutCache.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class lht
  implements Observer
{
  Handler a = null;
  
  private void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("qav.GAudioUIObserver", 2, "OnUpdate，msgType = " + i);
    }
    if (paramObject.length < 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qav.GAudioUIObserver", 2, "quit for message length");
      }
      return;
    }
    switch (i)
    {
    default: 
      return;
    }
    a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (ArrayList)paramObject[3]);
  }
  
  protected void a(long paramLong1, long paramLong2, ArrayList<lqk> paramArrayList) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new InviteMemberObserverWithoutCache.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lht
 * JD-Core Version:    0.7.0.1
 */