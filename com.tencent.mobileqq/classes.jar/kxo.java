import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;

public class kxo
  extends ContentObserver
{
  public kxo(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (ReadInJoyNativeAdAppVideoView.a(this.a) != null) {
      ReadInJoyNativeAdAppVideoView.a(this.a).post(new kxp(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxo
 * JD-Core Version:    0.7.0.1
 */