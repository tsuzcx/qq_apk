import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.VolumeChangedObserver.1;

public class npm
  extends ContentObserver
{
  public npm(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (ReadInJoyNativeAdAppVideoView.a(this.a) != null) {
      ReadInJoyNativeAdAppVideoView.a(this.a).post(new ReadInJoyNativeAdAppVideoView.VolumeChangedObserver.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     npm
 * JD-Core Version:    0.7.0.1
 */