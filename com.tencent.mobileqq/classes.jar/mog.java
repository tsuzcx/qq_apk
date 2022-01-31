import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import java.util.List;

public class mog
  extends Handler
{
  public mog(FastWebVideoFeedsAdapter paramFastWebVideoFeedsAdapter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    case 0: 
    case 1: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              FastWebVideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(0, 5000L);
            } while (FastWebVideoFeedsAdapter.a(this.a) == null);
            if (FastWebVideoFeedsAdapter.a(this.a).a() > FastWebVideoFeedsAdapter.a(this.a).b()) {}
            for (long l = FastWebVideoFeedsAdapter.a(this.a).a();; l = FastWebVideoFeedsAdapter.a(this.a).b())
            {
              l = 5000L - (System.currentTimeMillis() - l);
              if (l <= 0L) {
                break;
              }
              FastWebVideoFeedsAdapter.a(this.a).removeMessages(0);
              FastWebVideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(0, l);
              return;
            }
          } while ((FastWebVideoFeedsAdapter.a(this.a) == null) || (!FastWebVideoFeedsAdapter.a(this.a).c()));
          if (FastWebVideoFeedsAdapter.a(this.a).g.getVisibility() == 0) {
            VideoFeedsHelper.b(FastWebVideoFeedsAdapter.a(this.a).g, 8);
          }
        } while (FastWebVideoFeedsAdapter.a(this.a).f.getVisibility() != 0);
        VideoFeedsHelper.b(FastWebVideoFeedsAdapter.a(this.a).f, 8);
        return;
        FastWebVideoFeedsAdapter.a(this.a).a(FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam, false);
      } while ((FastWebVideoFeedsAdapter.a(this.a) == null) || (FastWebVideoFeedsAdapter.a(this.a).size() <= 1));
      FastWebVideoFeedsAdapter.a(this.a).a(FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_Int, FastWebVideoFeedsAdapter.a(this.a));
      return;
    case 2: 
      if (FastWebVideoFeedsAdapter.b(this.a))
      {
        FastWebVideoFeedsAdapter.a(this.a).sendEmptyMessage(3);
        FastWebVideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(2, 50L);
      }
      FastWebVideoFeedsAdapter.a(this.a).a();
      return;
    }
    FastWebVideoFeedsAdapter.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mog
 * JD-Core Version:    0.7.0.1
 */