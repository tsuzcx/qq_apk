import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyRainAnimationController;
import java.lang.ref.WeakReference;

public class lbr
  extends Handler
{
  private WeakReference a;
  
  public lbr(ReadInJoyRainAnimationController paramReadInJoyRainAnimationController)
  {
    this.a = new WeakReference(paramReadInJoyRainAnimationController);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoyRainAnimationController localReadInJoyRainAnimationController = (ReadInJoyRainAnimationController)this.a.get();
    if ((localReadInJoyRainAnimationController == null) || (!localReadInJoyRainAnimationController.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localReadInJoyRainAnimationController.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbr
 * JD-Core Version:    0.7.0.1
 */