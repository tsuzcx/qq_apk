import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rzd
  implements pvq
{
  private rzd(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(int paramInt, List<pvr> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    label12:
    label151:
    label152:
    for (;;)
    {
      pvr localpvr;
      if (paramList.hasNext())
      {
        localpvr = (pvr)paramList.next();
        Iterator localIterator = VideoFeedsRecommendFragment.a(this.a).iterator();
        paramInt = 0;
        label45:
        if (localIterator.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
          if ((TextUtils.isEmpty(localVideoInfo.j)) || (localVideoInfo.jdField_a_of_type_Pvp != null) || (Long.parseLong(localVideoInfo.j) != localpvr.jdField_a_of_type_Long)) {
            break label151;
          }
          localVideoInfo.jdField_a_of_type_Pvp = localpvr.jdField_a_of_type_Pvp;
          if (localpvr.jdField_a_of_type_Pvp.a != 1) {
            break label151;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        break label45;
        if (paramInt == 0) {
          break label152;
        }
        VideoFeedsRecommendFragment.a(this.a).b(String.valueOf(localpvr.jdField_a_of_type_Long));
        break label12;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzd
 * JD-Core Version:    0.7.0.1
 */