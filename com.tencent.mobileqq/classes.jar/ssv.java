import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ssv
  extends Handler
{
  private WeakReference<sss> a;
  
  public ssv(sss paramsss)
  {
    this.a = new WeakReference(paramsss);
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
      sss.a((sss)this.a.get());
      sss.a((sss)this.a.get()).sendEmptyMessageDelayed(0, sss.a((sss)this.a.get()));
      return;
    } while (this.a.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d(sss.a((sss)this.a.get()), 2, "prePlay timeout, try rePlay");
    }
    if ((((sss)this.a.get()).f()) && (((sss)this.a.get()).a.a() == sss.a((sss)this.a.get())))
    {
      sss.b((sss)this.a.get());
      return;
    }
    sss.a((sss)this.a.get(), false);
    ((sss)this.a.get()).a(((sss)this.a.get()).a);
    sss.a((sss)this.a.get(), sss.a((sss)this.a.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssv
 * JD-Core Version:    0.7.0.1
 */