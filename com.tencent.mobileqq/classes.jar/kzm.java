import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class kzm
  implements Runnable
{
  public kzm(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView, Context paramContext) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new kzn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzm
 * JD-Core Version:    0.7.0.1
 */