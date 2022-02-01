import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkCallbackImpl.1;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkCallbackImpl.2;
import org.jetbrains.annotations.Nullable;

@RequiresApi(21)
public final class sgw
  extends ConnectivityManager.NetworkCallback
{
  private sgw(sgu paramsgu) {}
  
  public void onAvailable(@Nullable Network paramNetwork)
  {
    sgu.a(this.a).post(new BandwidthPredictor.NetworkCallbackImpl.1(this));
  }
  
  public void onLost(@Nullable Network paramNetwork)
  {
    sgu.a(this.a).post(new BandwidthPredictor.NetworkCallbackImpl.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgw
 * JD-Core Version:    0.7.0.1
 */