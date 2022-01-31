import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.AdapterEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppJumpManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView.ListViewEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;

public class mei
  implements VideoFeedsListView.ListViewEventListener
{
  public mei(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void a() {}
  
  public void a(Object paramObject)
  {
    VideoFeedsAdapter.a(this.a).removeMessages(4, null);
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((paramObject instanceof VideoFeedsAdapter.BaseVideoItemHolder))
    {
      localObject1 = VideoFeedsAdapter.a(this.a);
      VideoFeedsAdapter.a(this.a, (VideoFeedsAdapter.BaseVideoItemHolder)localObject1);
      localObject1 = (VideoFeedsAdapter.VideoItemHolder)paramObject;
      VideoFeedsAdapter.a(this.a, (VideoFeedsAdapter.BaseVideoItemHolder)localObject1);
      localObject2 = this.a;
      if (VideoFeedsAdapter.a(this.a) - ((VideoFeedsAdapter.VideoItemHolder)localObject1).jdField_b_of_type_Int >= 0) {
        break label639;
      }
      bool = true;
      VideoFeedsAdapter.a((VideoFeedsAdapter)localObject2, bool);
      VideoFeedsAdapter.a(this.a, ((VideoFeedsAdapter.VideoItemHolder)localObject1).jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + VideoFeedsAdapter.a(this.a).a.a.b());
      }
      if (VideoFeedsAdapter.c(this.a)) {
        break label662;
      }
      if (!VideoFeedsAdapter.a(this.a, (VideoFeedsAdapter.BaseVideoItemHolder)localObject1)) {
        break label644;
      }
      VideoFeedsAdapter.b(this.a, (VideoFeedsAdapter.BaseVideoItemHolder)localObject1);
      label174:
      if (!VideoFeedsAdapter.d(this.a)) {
        VideoFeedsAdapter.a(this.a, (VideoFeedsAdapter.VideoItemHolder)localObject1, false);
      }
      if (VideoFeedsAdapter.a(this.a).a())
      {
        VideoFeedsAdapter.a(this.a).e.setVisibility(8);
        VideoFeedsAdapter.a(this.a).j.setVisibility(8);
      }
      VideoFeedsAdapter.b(this.a, true);
      bool = false;
      label248:
      if ((VideoFeedsAdapter.a(this.a) != null) && (VideoFeedsAdapter.a(this.a).a != null))
      {
        localObject2 = new ReportInfo.VideoExtraRepoerData();
        if (VideoFeedsAdapter.a(this.a) == null) {
          break label681;
        }
        ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_b_of_type_Int = VideoFeedsAdapter.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label644:
    label662:
    label681:
    for (int i = VideoFeedsAdapter.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      VideoReporter.a(VideoFeedsAdapter.a(this.a).a.a.g, i, (int)VideoFeedsAdapter.a(this.a).a.a.d, VideoFeedsAdapter.a(this.a).a.a.k, 7, -1, (ReportInfo.VideoExtraRepoerData)localObject2);
      VideoFeedsAdapter.a(this.a, (VideoFeedsAdapter.VideoItemHolder)localObject1);
      VideoFeedsAdapter.a(this.a).a(VideoFeedsAdapter.a(this.a).a.a);
      VideoFeedsAdapter.a(this.a).a(VideoFeedsAdapter.a(this.a).a.a, VideoFeedsAdapter.a(this.a));
      ThreadManager.post(new mej(this, VideoFeedsAdapter.a(this.a).a, VideoFeedsAdapter.a(this.a), bool), 1, null, true);
      if ((((VideoFeedsAdapter.VideoItemHolder)localObject1).jdField_b_of_type_Int >= this.a.getCount() - 5) && (VideoFeedsAdapter.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((VideoFeedsAdapter.VideoItemHolder)localObject1).jdField_b_of_type_Int + ", getCount() = " + this.a.getCount() + ", 推荐视频列表提前预拉取");
        }
        VideoFeedsAdapter.a(this.a).a();
      }
      VideoFeedsAdapter.a(this.a, System.currentTimeMillis());
      VideoFeedsAdapter.a(this.a).removeMessages(0);
      VideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(0, 3000L);
      VideoFeedsAdapter.a(this.a, (VideoFeedsAdapter.BaseItemHolder)paramObject);
      VideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(4, 1000L);
      return;
      label639:
      bool = false;
      break;
      VideoFeedsAdapter.a(this.a).d.setVisibility(8);
      break label174;
      VideoFeedsAdapter.a(this.a, VideoFeedsAdapter.a(this.a));
      bool = true;
      break label248;
    }
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    VideoFeedsAdapter.c(this.a, paramBoolean);
    if ((paramObject instanceof VideoFeedsAdapter.VideoItemHolder))
    {
      paramObject = (VideoFeedsAdapter.VideoItemHolder)paramObject;
      if (!paramBoolean) {
        break label124;
      }
      paramObject.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramObject.e.setVisibility(8);
      paramObject.j.setVisibility(8);
      paramObject.c.setBackgroundDrawable(VideoFeedsAdapter.a(this.a, 2130839778));
    }
    for (;;)
    {
      if ((VideoFeedsAdapter.a(this.a) != null) && (VideoFeedsAdapter.a(this.a).isShowing())) {
        VideoFeedsAdapter.a(this.a).dismiss();
      }
      paramObject.a.setIsInFullScreen(paramBoolean);
      paramObject.a.a();
      VideoFeedsAdapter.a(this.a);
      return;
      label124:
      paramObject.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramObject.e.setVisibility(0);
      paramObject.j.setVisibility(0);
      paramObject.c.setBackgroundDrawable(VideoFeedsAdapter.a(this.a, 2130839779));
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mei
 * JD-Core Version:    0.7.0.1
 */