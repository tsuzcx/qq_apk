import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;

public class mof
  implements Runnable
{
  public mof(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((FastWebVideoFeedsPlayManager.a(this.a) != null) && (FastWebVideoFeedsPlayManager.a(this.a).c() == 5))
    {
      FastWebVideoFeedsPlayManager.a(this.a).e();
      FastWebVideoFeedsPlayManager.a(this.a, 8);
      if ((FastWebVideoFeedsPlayManager.a(this.a) == null) || (FastWebVideoFeedsPlayManager.a(this.a).c.getVisibility() != 0)) {
        break label104;
      }
      this.a.a(3);
    }
    for (;;)
    {
      if (FastWebVideoFeedsPlayManager.c(this.a)) {
        FastWebVideoFeedsPlayManager.a(this.a).a.f = ReadinjoyAdVideoReportData.b;
      }
      return;
      label104:
      this.a.a(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mof
 * JD-Core Version:    0.7.0.1
 */