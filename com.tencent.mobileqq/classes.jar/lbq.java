import com.tencent.biz.pubaccount.readinjoy.ReadInJoyRainAnimationController;
import com.tencent.biz.pubaccount.readinjoy.view.RainView.AnimationEndListener;
import java.lang.ref.WeakReference;

public class lbq
  implements RainView.AnimationEndListener
{
  private WeakReference a;
  
  public lbq(ReadInJoyRainAnimationController paramReadInJoyRainAnimationController)
  {
    this.a = new WeakReference(paramReadInJoyRainAnimationController);
  }
  
  public void a()
  {
    ReadInJoyRainAnimationController localReadInJoyRainAnimationController = (ReadInJoyRainAnimationController)this.a.get();
    if ((localReadInJoyRainAnimationController == null) || (!localReadInJoyRainAnimationController.b())) {
      return;
    }
    ReadInJoyRainAnimationController.a(localReadInJoyRainAnimationController).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbq
 * JD-Core Version:    0.7.0.1
 */