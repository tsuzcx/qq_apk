package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class VideoStoryPiecesPart$2
  implements View.OnClickListener
{
  VideoStoryPiecesPart$2(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().P();
    if ("h5".equals(VideoStoryPiecesPart.a(this.a))) {
      if (!NetworkUtil.g(null)) {
        QQToast.a(VideoStoryPiecesPart.a(this.a), 1, VideoStoryPiecesPart.b(this.a).getString(2131697606), 1).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(VideoStoryPiecesPart.c(this.a), QQBrowserActivity.class);
      localIntent.putExtra("url", VideoStoryPiecesPart.b(this.a));
      localIntent.putExtra("loc_play_show_material_id", VideoStoryPiecesPart.b(this.a));
      if (VideoStoryPiecesPart.d(this.a).getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", VideoStoryPiecesPart.e(this.a).getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      for (;;)
      {
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.J.a());
        localIntent.putExtra("VIDEO_STORY_ACTIVITY_ID", VideoStoryPiecesPart.g(this.a).getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID"));
        VideoStoryPiecesPart.h(this.a).startActivityForResult(localIntent, 1025);
        break;
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", VideoStoryPiecesPart.f(this.a).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      VideoStoryPiecesPart.a(this.a).b(VideoStoryPiecesPart.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.2
 * JD-Core Version:    0.7.0.1
 */