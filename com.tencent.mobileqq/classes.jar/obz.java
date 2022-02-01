import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

public class obz
  implements TouchWebView.OnScrollChangedListener
{
  public obz(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    PublicAccountBrowser.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obz
 * JD-Core Version:    0.7.0.1
 */