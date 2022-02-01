import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class sgq
  extends Handler
{
  private WeakReference<sgn> a;
  
  public sgq(sgn paramsgn)
  {
    this.a = new WeakReference(paramsgn);
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
      sgn.a((sgn)this.a.get());
      sgn.a((sgn)this.a.get()).sendEmptyMessageDelayed(0, sgn.a((sgn)this.a.get()));
      return;
    } while (this.a.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d(sgn.a((sgn)this.a.get()), 2, "prePlay timeout, try rePlay");
    }
    if ((((sgn)this.a.get()).f()) && (((sgn)this.a.get()).a.a() == sgn.a((sgn)this.a.get())))
    {
      sgn.b((sgn)this.a.get());
      return;
    }
    sgn.a((sgn)this.a.get(), false);
    ((sgn)this.a.get()).a(((sgn)this.a.get()).a);
    sgn.a((sgn)this.a.get(), sgn.a((sgn)this.a.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgq
 * JD-Core Version:    0.7.0.1
 */