import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class msl
  extends FastWebVideoFeedsPlayManager.VideoStatusListener
{
  public msl(FastWebVideoFeedsPlayActivity paramFastWebVideoFeedsPlayActivity) {}
  
  public void a(FastWebVideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "video play completion!, move to next position");
    }
    boolean bool = FastWebVideoFeedsPlayActivity.a(this.a);
    if (FastWebVideoFeedsPlayActivity.a(this.a)) {
      FastWebVideoFeedsPlayActivity.a(this.a).post(new msm(this));
    }
    if (FastWebVideoFeedsPlayActivity.b(this.a))
    {
      if (!bool) {
        FastWebVideoFeedsPlayActivity.a(this.a);
      }
      FastWebVideoFeedsPlayActivity.a(this.a).a(5);
    }
    while (this.a.a() == FastWebVideoFeedsPlayActivity.a(this.a).size() - 1) {
      return;
    }
    FastWebVideoFeedsPlayActivity.a(this.a).postDelayed(new msn(this), 600L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msl
 * JD-Core Version:    0.7.0.1
 */