import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.widget.FadeIconImageView;

public class npz
  implements View.OnClickListener
{
  public npz(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void onClick(View paramView)
  {
    PublicAccountBrowser.a(this.a).callOnClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     npz
 * JD-Core Version:    0.7.0.1
 */