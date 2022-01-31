import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

class qwz
  extends Handler
{
  private WeakReference<qwy> a;
  
  public qwz(qwy paramqwy)
  {
    this.a = new WeakReference(paramqwy);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    qwy localqwy = (qwy)this.a.get();
    if (localqwy == null) {}
    while (paramMessage.what != 101) {
      return;
    }
    qwy.a(localqwy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwz
 * JD-Core Version:    0.7.0.1
 */