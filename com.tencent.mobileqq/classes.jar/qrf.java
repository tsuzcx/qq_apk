import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.freeflip.GdtFreeFlipContentViewWithRoundTrip;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.image.URLDrawable;
import java.net.URL;
import java.util.Map;

public class qrf
  implements GdtDrawableLoader.Listener
{
  public qrf(GdtFreeFlipContentViewWithRoundTrip paramGdtFreeFlipContentViewWithRoundTrip) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = null)
    {
      int i = GdtFreeFlipContentViewWithRoundTrip.a(this.a, paramURLDrawable);
      if (!GdtFreeFlipContentViewWithRoundTrip.a(this.a).containsKey(Integer.valueOf(i))) {
        break;
      }
      GdtLog.b("GdtFreeFlipContentViewWithRoundTrip", "onLoadSuccessful " + paramURLDrawable);
      ((qrg)GdtFreeFlipContentViewWithRoundTrip.a(this.a).get(Integer.valueOf(i))).a = true;
      GdtFreeFlipContentViewWithRoundTrip.a(this.a);
      GdtFreeFlipContentViewWithRoundTrip.b(this.a);
      return;
    }
    GdtLog.d("GdtFreeFlipContentViewWithRoundTrip", "onLoadSuccessful error " + paramURLDrawable);
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = null)
    {
      GdtLog.b("GdtFreeFlipContentViewWithRoundTrip", "onLoadFailed " + paramURLDrawable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qrf
 * JD-Core Version:    0.7.0.1
 */