import android.view.View;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

public class pcs
  implements URLDrawableDownListener
{
  public pcs(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.a(false, "onLoadCancelled");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.a(false, "onLoadFailed");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.a.a(false, "onLoadInterrupted");
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.a(true, "onLoadSuccessed");
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcs
 * JD-Core Version:    0.7.0.1
 */