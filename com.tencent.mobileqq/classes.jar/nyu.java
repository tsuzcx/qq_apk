import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

public class nyu
  implements TouchWebView.OnScrollChangedListener
{
  public nyu(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    PublicAccountBrowser.b(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyu
 * JD-Core Version:    0.7.0.1
 */