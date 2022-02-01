import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nyx
  implements View.OnClickListener
{
  public nyx(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyNativeAdFragment.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyx
 * JD-Core Version:    0.7.0.1
 */