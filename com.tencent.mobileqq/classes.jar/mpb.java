import android.app.Dialog;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

public class mpb
  implements Runnable
{
  public mpb(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((FastWebVideoFeedsPlayManager.a(this.a) != null) && (FastWebVideoFeedsPlayManager.a(this.a).isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "showMobileNetHint() mNetworkDialog.isShowing()=true, RETURN");
      }
      return;
    }
    FastWebVideoFeedsPlayManager.a(this.a, ReadInJoyUtils.a(FastWebVideoFeedsPlayManager.a(this.a), new mpc(this), new mpd(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpb
 * JD-Core Version:    0.7.0.1
 */