import android.view.View;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

public class qjn
  implements URLDrawableDownListener
{
  public qjn(GdtCanvasPictureComponentView paramGdtCanvasPictureComponentView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    GdtCanvasPictureComponentView.c(this.a, false);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    GdtCanvasPictureComponentView.b(this.a, false);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    GdtCanvasPictureComponentView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qjn
 * JD-Core Version:    0.7.0.1
 */