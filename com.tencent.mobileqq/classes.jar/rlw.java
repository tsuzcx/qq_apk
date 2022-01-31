import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkChangeReceiver.1;
import org.jetbrains.annotations.NotNull;

public final class rlw
  extends BroadcastReceiver
{
  private rlw(rlt paramrlt) {}
  
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    rlt.a(this.a).post(new BandwidthPredictor.NetworkChangeReceiver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rlw
 * JD-Core Version:    0.7.0.1
 */