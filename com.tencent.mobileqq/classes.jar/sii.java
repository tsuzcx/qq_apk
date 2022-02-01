import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class sii
  extends Handler
{
  private WeakReference<sif> a;
  
  public sii(sif paramsif)
  {
    this.a = new WeakReference(paramsif);
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
      sif.a((sif)this.a.get());
      sif.a((sif)this.a.get()).sendEmptyMessageDelayed(0, sif.a((sif)this.a.get()));
      return;
    } while (this.a.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d(sif.a((sif)this.a.get()), 2, "prePlay timeout, try rePlay");
    }
    if ((((sif)this.a.get()).f()) && (((sif)this.a.get()).a.a() == sif.a((sif)this.a.get())))
    {
      sif.b((sif)this.a.get());
      return;
    }
    sif.a((sif)this.a.get(), false);
    ((sif)this.a.get()).a(((sif)this.a.get()).a);
    sif.a((sif)this.a.get(), sif.a((sif)this.a.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sii
 * JD-Core Version:    0.7.0.1
 */