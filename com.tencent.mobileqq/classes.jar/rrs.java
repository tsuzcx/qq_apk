import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class rrs
  implements ppq
{
  public rrs(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, List paramList) {}
  
  public void a(int paramInt, Map<Long, qwb> paramMap)
  {
    if (pfa.a().a() != null) {
      pfa.a().a().b(this);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if (!TextUtils.isEmpty(localVideoInfo.j))
      {
        qwb localqwb = (qwb)paramMap.get(Long.valueOf(Long.parseLong(localVideoInfo.j)));
        if (localqwb != null) {
          localVideoInfo.n = localqwb.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrs
 * JD-Core Version:    0.7.0.1
 */