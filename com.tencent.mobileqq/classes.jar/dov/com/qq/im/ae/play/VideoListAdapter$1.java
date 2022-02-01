package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoListAdapter$1
  implements View.OnClickListener
{
  VideoListAdapter$1(VideoListAdapter paramVideoListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!VideoListAdapter.isFastClick()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VideoListAdapter.access$002(this.this$0, this.val$position);
      this.this$0.notifyDataSetChanged();
      if (VideoListAdapter.access$100(this.this$0) != null) {
        VideoListAdapter.access$100(this.this$0).onVideoNodeClick(this.val$position);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.VideoListAdapter.1
 * JD-Core Version:    0.7.0.1
 */