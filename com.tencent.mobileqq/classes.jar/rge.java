import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class rge
  extends altm
{
  private rge(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      break label10;
    }
    label10:
    label227:
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        Object localObject1 = VideoFeedsRecommendFragment.a(this.a);
        if (localObject1 != null) {}
        for (localObject1 = bdgc.b((QQAppInterface)localObject1, paramString, false);; localObject1 = null)
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label227;
          }
          Iterator localIterator = VideoFeedsRecommendFragment.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (VideoInfo)localIterator.next();
            int i = j;
            if (paramString.equals(((VideoInfo)localObject2).j))
            {
              i = j;
              if (!((String)localObject1).equals(((VideoInfo)localObject2).k))
              {
                ((VideoInfo)localObject2).k = ((String)localObject1);
                i = 1;
              }
            }
            j = i;
            if (((VideoInfo)localObject2).d != null)
            {
              localObject2 = ((VideoInfo)localObject2).d.iterator();
              for (;;)
              {
                j = i;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject2).next();
                if ((paramString.equals(localVideoInfo.j)) && (!((String)localObject1).equals(localVideoInfo.k)))
                {
                  localVideoInfo.k = ((String)localObject1);
                  i = 1;
                }
              }
            }
          }
          if (j == 0) {
            break;
          }
          VideoFeedsRecommendFragment.a(this.a).a(paramString);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rge
 * JD-Core Version:    0.7.0.1
 */