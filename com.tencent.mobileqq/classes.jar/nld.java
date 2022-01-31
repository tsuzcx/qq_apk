import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;

public class nld
  implements View.OnClickListener
{
  public nld(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyNativeAdFragment.a(this.a).dismiss();
    ReadInJoyNativeAdFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nld
 * JD-Core Version:    0.7.0.1
 */