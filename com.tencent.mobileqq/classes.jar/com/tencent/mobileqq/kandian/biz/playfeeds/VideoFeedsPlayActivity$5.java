package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.qroute.QRoute;

class VideoFeedsPlayActivity$5
  extends OnColorNoteCurdListener
{
  VideoFeedsPlayActivity$5(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    int i = paramBundle.getInt("color_note_curd_from_type");
    int j = 1;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (VideoFeedsPlayActivity.a(this.a) == 0)
    {
      paramBundle = this.a;
      if (i == 0) {
        j = 2;
      }
      VideoFeedsPlayActivity.a(paramBundle, j);
    }
    paramBundle = VideoFeedsPlayActivity.a(this.a);
    if (paramBundle != null) {
      paramBundle.u = VideoFeedsPlayActivity.a(this.a);
    }
    if (VideoFeedsPlayActivity.a(this.a) == 3) {
      VideoFeedsPlayActivity.a(this.a, ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).createRecentColorNote(VideoFeedsPlayActivity.a(this.a)));
    }
    VideoFeedsPlayActivity.a(this.a).mReserve = VideoFeedsHelper.a(paramBundle);
    VideoFeedsPlayActivity.a(this.a).updateColorNote(VideoFeedsPlayActivity.a(this.a));
    ReportUtil.a(paramBundle);
    if (i == 0) {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */