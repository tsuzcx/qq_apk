import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkChangeReceiver.1;
import org.jetbrains.annotations.NotNull;

public final class qwf
  extends BroadcastReceiver
{
  private qwf(qwc paramqwc) {}
  
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    qwc.a(this.a).post(new BandwidthPredictor.NetworkChangeReceiver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwf
 * JD-Core Version:    0.7.0.1
 */