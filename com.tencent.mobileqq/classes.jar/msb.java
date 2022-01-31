import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;
import java.util.List;

public class msb
  implements Runnable
{
  public msb(FastWebVideoFeedsAdapter paramFastWebVideoFeedsAdapter) {}
  
  public void run()
  {
    FastWebVideoInfo localFastWebVideoInfo = (FastWebVideoInfo)FastWebVideoFeedsAdapter.a(this.a).get(0);
    Object localObject;
    if (FastWebVideoFeedsAdapter.a(this.a).getFirstVisiblePosition() == 0)
    {
      localObject = FastWebVideoFeedsAdapter.a(this.a).getChildAt(FastWebVideoFeedsAdapter.a(this.a).getHeaderViewsCount());
      if ((localObject != null) && ((((View)localObject).getTag() instanceof FastWebVideoFeedsAdapter.VideoItemHolder)))
      {
        localObject = (FastWebVideoFeedsAdapter.VideoItemHolder)((View)localObject).getTag();
        if (!localFastWebVideoInfo.a(FastWebVideoFeedsAdapter.a(this.a), FastWebVideoFeedsAdapter.a(this.a))) {
          break label106;
        }
        ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject).k.setText(localFastWebVideoInfo.j);
      }
    }
    return;
    label106:
    ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject).a.setText(localFastWebVideoInfo.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msb
 * JD-Core Version:    0.7.0.1
 */