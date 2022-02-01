package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.test.VideoTestHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.HashMap;
import java.util.Map;

class VideoFeedsPlayManager$9
  implements Runnable
{
  VideoFeedsPlayManager$9(VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("vid", this.a.c.b);
    localHashMap.put("duration", Integer.valueOf(this.a.c.e));
    localHashMap.put("title", this.a.c.g);
    localHashMap.put("author", this.a.c.r);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.c.b);
    localStringBuilder.append(".mp4");
    localHashMap.put("local_file_name", localStringBuilder.toString());
    localHashMap.put("rowKey", this.a.c.l);
    localHashMap.put("testId", VideoTestHelper.a.a());
    BeaconAdapter.onUserActionToTunnel("00000U7O8S3BLETM", "actVideoTest", true, -1L, -1L, localHashMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.9
 * JD-Core Version:    0.7.0.1
 */