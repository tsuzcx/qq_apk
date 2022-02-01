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
    if (VideoFeedsPlayActivity.g(this.a) == 0)
    {
      paramBundle = this.a;
      if (i == 0) {
        j = 2;
      }
      VideoFeedsPlayActivity.a(paramBundle, j);
    }
    paramBundle = VideoFeedsPlayActivity.c(this.a);
    if (paramBundle != null) {
      paramBundle.av = VideoFeedsPlayActivity.g(this.a);
    }
    if (VideoFeedsPlayActivity.g(this.a) == 3) {
      VideoFeedsPlayActivity.a(this.a, ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).createRecentColorNote(VideoFeedsPlayActivity.d(this.a)));
    }
    VideoFeedsPlayActivity.d(this.a).mReserve = VideoFeedsHelper.b(paramBundle);
    VideoFeedsPlayActivity.f(this.a).updateColorNote(VideoFeedsPlayActivity.d(this.a));
    ReportUtil.a(paramBundle);
    if (i == 0) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */