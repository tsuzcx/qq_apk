import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.LiveStatusCallback.1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class slg
  implements qgq
{
  private slg(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(int paramInt, List<qgr> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    label12:
    label146:
    label147:
    for (;;)
    {
      qgr localqgr;
      if (paramList.hasNext())
      {
        localqgr = (qgr)paramList.next();
        Iterator localIterator = VideoFeedsRecommendFragment.a(this.a).iterator();
        paramInt = 0;
        label45:
        if (localIterator.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
          if ((TextUtils.isEmpty(localVideoInfo.j)) || (localVideoInfo.jdField_a_of_type_Qgp != null) || (Long.parseLong(localVideoInfo.j) != localqgr.jdField_a_of_type_Long)) {
            break label146;
          }
          localVideoInfo.jdField_a_of_type_Qgp = localqgr.jdField_a_of_type_Qgp;
          if (localqgr.jdField_a_of_type_Qgp.a != 1) {
            break label146;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        break label45;
        if (paramInt == 0) {
          break label147;
        }
        six.a(new VideoFeedsRecommendFragment.LiveStatusCallback.1(this, localqgr));
        break label12;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slg
 * JD-Core Version:    0.7.0.1
 */