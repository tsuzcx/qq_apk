import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class rob
  extends Handler
{
  private WeakReference<rny> a;
  
  public rob(rny paramrny)
  {
    this.a = new WeakReference(paramrny);
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
      rny.a((rny)this.a.get());
      rny.a((rny)this.a.get()).sendEmptyMessageDelayed(0, rny.a((rny)this.a.get()));
      return;
    } while (this.a.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d(rny.a((rny)this.a.get()), 2, "prePlay timeout, try rePlay");
    }
    if ((((rny)this.a.get()).e()) && (rny.a((rny)this.a.get()).a() == rny.a((rny)this.a.get())))
    {
      rny.b((rny)this.a.get());
      return;
    }
    rny.a((rny)this.a.get(), false);
    ((rny)this.a.get()).a(rny.a((rny)this.a.get()));
    rny.a((rny)this.a.get(), rny.a((rny)this.a.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rob
 * JD-Core Version:    0.7.0.1
 */