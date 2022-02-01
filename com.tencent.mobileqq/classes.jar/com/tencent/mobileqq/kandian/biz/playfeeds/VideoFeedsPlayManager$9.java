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
    localHashMap.put("vid", this.a.a.a);
    localHashMap.put("duration", Integer.valueOf(this.a.a.d));
    localHashMap.put("title", this.a.a.c);
    localHashMap.put("author", this.a.a.k);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a.a);
    localStringBuilder.append(".mp4");
    localHashMap.put("local_file_name", localStringBuilder.toString());
    localHashMap.put("rowKey", this.a.a.g);
    localHashMap.put("testId", VideoTestHelper.a.a());
    BeaconAdapter.onUserActionToTunnel("00000U7O8S3BLETM", "actVideoTest", true, -1L, -1L, localHashMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.9
 * JD-Core Version:    0.7.0.1
 */