import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ldc
  extends Handler
{
  WeakReference<lda> a;
  
  ldc(lda paramlda)
  {
    this.a = new WeakReference(paramlda);
  }
  
  public void a()
  {
    sendMessage(obtainMessage(1));
  }
  
  public void b()
  {
    sendMessage(obtainMessage(3));
    removeMessages(1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    lda locallda = (lda)this.a.get();
    if (locallda != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        lda.a(locallda, paramMessage.what);
      } while (lda.a(locallda) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    lda.a(locallda);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ldc
 * JD-Core Version:    0.7.0.1
 */