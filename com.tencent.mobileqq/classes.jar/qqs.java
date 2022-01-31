import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;
import com.tencent.gdtad.views.image.GdtDrawableLoader;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class qqs
  implements GdtDrawableLoader.Listener
{
  public qqs(GdtCanvasPictureComponentView paramGdtCanvasPictureComponentView) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    GdtLog.b("GdtCanvasPictureComponentView", "onLoadSuccessful");
    if ((GdtCanvasPictureComponentView.a(this.a) != null) && (GdtCanvasPictureComponentView.a(this.a) != null)) {
      GdtCanvasPictureComponentView.a(this.a).setImageDrawable(GdtCanvasPictureComponentView.a(this.a).a());
    }
    GdtCanvasPictureComponentView.a(this.a, true);
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    GdtLog.b("GdtCanvasPictureComponentView", "onLoadFailed");
    if ((GdtCanvasPictureComponentView.a(this.a) != null) && (GdtCanvasPictureComponentView.a(this.a) != null)) {
      GdtCanvasPictureComponentView.a(this.a).setImageDrawable(GdtCanvasPictureComponentView.a(this.a).a());
    }
    GdtCanvasPictureComponentView.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qqs
 * JD-Core Version:    0.7.0.1
 */