import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class mdl
  extends VideoPlayDianZanObserver
{
  public mdl(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onGetDianZanState isSuccess: " + paramBoolean);
    }
    if (!paramBoolean) {}
    label35:
    String str;
    int i;
    VideoInfo localVideoInfo;
    do
    {
      do
      {
        do
        {
          return;
          break label35;
          while (paramBundle == null) {}
          str = paramBundle.getString("VALUE_VIDEO_ARTICLE_ID");
          i = paramBundle.getInt("VALUE_VIDEO_FAVORITE_STATE");
        } while (str == null);
        paramBundle = VideoFeedsPlayActivity.a(this.a).iterator();
      } while (!paramBundle.hasNext());
      localVideoInfo = (VideoInfo)paramBundle.next();
    } while ((localVideoInfo.g == null) || (!localVideoInfo.g.equals(str)));
    if (i == 1) {
      localVideoInfo.h = true;
    }
    for (;;)
    {
      VideoFeedsPlayActivity.a(this.a).a(localVideoInfo.g, Boolean.valueOf(false));
      return;
      if (i == 0) {
        localVideoInfo.h = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdl
 * JD-Core Version:    0.7.0.1
 */