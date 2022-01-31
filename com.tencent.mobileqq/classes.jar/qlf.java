import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;

class qlf
  extends net
{
  private qlf(qle paramqle) {}
  
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
        paramBundle = qle.a(this.a).a().iterator();
        while (paramBundle.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)paramBundle.next();
          if ((str.equals(localVideoInfo.a)) && (i > 0) && (localVideoInfo.s == 0))
          {
            localVideoInfo.s = i;
            qle.a(this.a).b(localVideoInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlf
 * JD-Core Version:    0.7.0.1
 */