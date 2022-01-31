import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoPlayCountObserver;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class mgw
  extends VideoPlayCountObserver
{
  public mgw(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onGetVideoPlayCount isSuccess: " + paramBoolean);
    }
    if (!paramBoolean) {}
    label35:
    String str;
    VideoInfo localVideoInfo;
    do
    {
      Iterator localIterator;
      do
      {
        do
        {
          return;
          break label35;
          while (paramBundle == null) {}
          str = paramBundle.getString("VALUE_VIDEO_VID");
        } while (str == null);
        localIterator = VideoFeedsPlayActivity.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localVideoInfo = (VideoInfo)localIterator.next();
    } while ((localVideoInfo.a == null) || (!localVideoInfo.a.equals(str)));
    localVideoInfo.l = paramBundle.getInt("VALUE_VIDEO_PLAY_COUNT");
    VideoFeedsPlayActivity.a(this.a).b(localVideoInfo.a, localVideoInfo.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgw
 * JD-Core Version:    0.7.0.1
 */