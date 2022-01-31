import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class kxf
  implements Runnable
{
  public kxf(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView, Context paramContext) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new kxg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxf
 * JD-Core Version:    0.7.0.1
 */