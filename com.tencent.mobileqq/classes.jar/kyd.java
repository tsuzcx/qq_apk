import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;

public class kyd
  extends ContentObserver
{
  public kyd(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (ReadInJoyNativeAdAppVideoView.a(this.a) != null) {
      ReadInJoyNativeAdAppVideoView.a(this.a).post(new kye(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kyd
 * JD-Core Version:    0.7.0.1
 */