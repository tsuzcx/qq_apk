import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;

class rmw
  extends nta
{
  private rmw(rmv paramrmv) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((!paramBoolean) || (paramBundle == null)) {}
    for (;;)
    {
      return;
      String str = paramBundle.getString("VALUE_VIDEO_VID");
      int i = paramBundle.getInt("VALUE_VIDEO_PLAY_COUNT");
      if (!TextUtils.isEmpty(str))
      {
        paramBundle = rmv.a(this.a).a().iterator();
        while (paramBundle.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)paramBundle.next();
          if ((str.equals(localVideoInfo.a)) && (i > 0) && (localVideoInfo.p == 0))
          {
            localVideoInfo.p = i;
            rmv.a(this.a).b(localVideoInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rmw
 * JD-Core Version:    0.7.0.1
 */