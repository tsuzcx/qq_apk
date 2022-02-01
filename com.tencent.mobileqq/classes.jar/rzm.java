import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class rzm
  extends Handler
{
  private WeakReference<rzj> a;
  
  public rzm(rzj paramrzj)
  {
    this.a = new WeakReference(paramrzj);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.a.get() == null);
      rzj.a((rzj)this.a.get());
      rzj.a((rzj)this.a.get()).sendEmptyMessageDelayed(0, rzj.a((rzj)this.a.get()));
      return;
    } while (this.a.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d(rzj.a((rzj)this.a.get()), 2, "prePlay timeout, try rePlay");
    }
    if ((((rzj)this.a.get()).f()) && (((rzj)this.a.get()).a.a() == rzj.a((rzj)this.a.get())))
    {
      rzj.b((rzj)this.a.get());
      return;
    }
    rzj.a((rzj)this.a.get(), false);
    ((rzj)this.a.get()).a(((rzj)this.a.get()).a);
    rzj.a((rzj)this.a.get(), rzj.a((rzj)this.a.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzm
 * JD-Core Version:    0.7.0.1
 */