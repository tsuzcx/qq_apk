import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView.ListViewEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

public class mnq
  implements FastWebVideoFeedsListView.ListViewEventListener
{
  public mnq(FastWebVideoFeedsPlayActivity paramFastWebVideoFeedsPlayActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    FastWebVideoFeedsPlayActivity.a(this.a, paramBoolean);
    if (paramBoolean)
    {
      if (FastWebVideoFeedsPlayActivity.a(this.a) != null) {
        FastWebVideoFeedsPlayActivity.a(this.a).b(0);
      }
      this.a.a.setVisibility(8);
      return;
    }
    if (FastWebVideoFeedsPlayActivity.a(this.a) != null) {
      FastWebVideoFeedsPlayActivity.a(this.a).b(2);
    }
    this.a.a.setVisibility(0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "onFinishActivity()");
    }
    FastWebVideoFeedsPlayActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnq
 * JD-Core Version:    0.7.0.1
 */