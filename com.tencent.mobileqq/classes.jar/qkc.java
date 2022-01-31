import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkCallbackImpl.1;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkCallbackImpl.2;
import org.jetbrains.annotations.Nullable;

@RequiresApi(21)
public final class qkc
  extends ConnectivityManager.NetworkCallback
{
  private qkc(qka paramqka) {}
  
  public void onAvailable(@Nullable Network paramNetwork)
  {
    qka.a(this.a).post(new BandwidthPredictor.NetworkCallbackImpl.1(this));
  }
  
  public void onLost(@Nullable Network paramNetwork)
  {
    qka.a(this.a).post(new BandwidthPredictor.NetworkCallbackImpl.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkc
 * JD-Core Version:    0.7.0.1
 */