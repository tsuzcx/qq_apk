import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ThreadPriorityUtil;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class mfs
  implements AbsListView.OnScrollListener
{
  double jdField_a_of_type_Double = 0.0D;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean;
  final double jdField_b_of_type_Double = 200.0D;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  boolean jdField_b_of_type_Boolean = false;
  long c = 0L;
  
  public mfs(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  private boolean a(AbsListView paramAbsListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Double > 0.0D)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Double < 200.0D)
      {
        bool1 = bool2;
        if (!ReadInJoyBaseAdapter.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter))
        {
          bool1 = bool2;
          if (!ReadInJoyUtils.h())
          {
            bool1 = bool2;
            if (paramAbsListView.getVisibility() == 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.j = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "onScrollStateChanged " + paramInt);
    }
    label149:
    ReadInJoyBaseAdapter.VideoFeedsViewHolder localVideoFeedsViewHolder;
    int i;
    if (paramInt == 0)
    {
      if (ReadInJoyUtils.a()) {}
      switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c)
      {
      default: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil.b();
        ImageManager.a().c();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged idle");
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition(), ReadInJoyBaseAdapter.b());
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() < ReadInJoyBaseAdapter.c()) {
            ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
          }
          ReadInJoyBaseAdapter.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_Boolean);
          localVideoFeedsViewHolder = ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView);
          if (localVideoFeedsViewHolder != null) {
            break label449;
          }
          i = paramAbsListView.getFirstVisiblePosition();
          label212:
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, ReadInJoyBaseAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter));
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + i + " when scroll state idle");
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.i)
          {
            ReadInJoyLogicEngine.a().f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.i = false;
          }
          ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).postDelayed(ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter), 1000L);
          if ((paramInt != 2) || (!ReadInJoyBaseAdapter.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter))) {
            break label567;
          }
          this.jdField_b_of_type_Boolean = true;
          label348:
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).removeMessages(1001);
      return;
      DropFrameMonitor.a().a("list_video_kandian", false);
      break;
      DropFrameMonitor.a().a("list_new_kandian", false);
      break;
      DropFrameMonitor.a().a("list_subscript", false);
      break;
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - ReadInJoyBaseAdapter.b(), ReadInJoyBaseAdapter.b());
      break label149;
      label449:
      i = localVideoFeedsViewHolder.jdField_a_of_type_Int;
      break label212;
      if (ReadInJoyUtils.a()) {
        switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c)
        {
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil.a();
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).removeCallbacks(ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter));
        break;
        DropFrameMonitor.a().a("list_video_kandian");
        continue;
        DropFrameMonitor.a().a("list_new_kandian");
        continue;
        DropFrameMonitor.a().a("list_subscript");
      }
      label567:
      if ((paramInt == 2) || (!this.jdField_b_of_type_Boolean)) {
        break label348;
      }
      this.jdField_b_of_type_Boolean = false;
      ReadInJoyBaseAdapter.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, false);
      break label348;
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView, ReadInJoyBaseAdapter.jdField_b_of_type_Int);
      ReadInJoyBaseAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
      return;
      if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) != null) {
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).a(false);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = paramAbsListView.getChildAt(0);
    if (localView != null) {
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
    label143:
    label232:
    label239:
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return;
        this.jdField_b_of_type_Long = (localView.getHeight() * paramInt1 - localView.getTop());
        l1 = this.jdField_b_of_type_Long;
        l2 = this.c;
        l3 = System.currentTimeMillis();
      } while (l3 == this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Double = ((l1 - l2) * 1000L / (l3 - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_Long = l3;
      this.c = this.jdField_b_of_type_Long;
      if (a(paramAbsListView))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "低速滚动触发自动播放检测");
        }
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView, ReadInJoyBaseAdapter.jdField_a_of_type_Int);
      }
      if (paramInt1 > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.j != 2) {
          break label239;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          break;
        }
        if (!ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, paramAbsListView)) {
          break label232;
        }
        ImageManager.a().b();
        return;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.c = 0L;
        break label143;
        if (paramInt1 < this.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      ImageManager.a().c();
      return;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.j != -1) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.i));
    ReadInJoyLogicEngine.a().f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.i = false;
    ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter).postDelayed(ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfs
 * JD-Core Version:    0.7.0.1
 */