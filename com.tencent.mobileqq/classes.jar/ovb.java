import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

public class ovb
  implements TouchWebView.OnScrollChangedListener
{
  public ovb(TribeVideoPlugin paramTribeVideoPlugin) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (TribeVideoPlugin.a(this.a) != null)
    {
      TribeVideoPlugin.a(this.a).scrollBy(0, paramInt2 - paramInt4);
      TribeVideoPlugin.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovb
 * JD-Core Version:    0.7.0.1
 */