import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyRainAnimationController;
import java.lang.ref.WeakReference;

public class lda
  extends Handler
{
  private WeakReference a;
  
  public lda(KanDianViewController paramKanDianViewController)
  {
    this.a = new WeakReference(paramKanDianViewController);
  }
  
  public void handleMessage(Message paramMessage)
  {
    KanDianViewController localKanDianViewController = (KanDianViewController)this.a.get();
    if (localKanDianViewController == null) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          KanDianViewController.a(localKanDianViewController);
          return;
        }
      } while (KanDianViewController.a(localKanDianViewController) == null);
      KanDianViewController.a(localKanDianViewController).a(KanDianViewController.a(localKanDianViewController));
      return;
    } while (KanDianViewController.a(localKanDianViewController) == null);
    KanDianViewController.a(localKanDianViewController).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lda
 * JD-Core Version:    0.7.0.1
 */