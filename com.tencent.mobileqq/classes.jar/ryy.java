import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ryy
  implements puy
{
  private List<VideoInfo> a;
  
  public ryy(List<VideoInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void a(int paramInt, Map<Long, rcz> paramMap)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if (!TextUtils.isEmpty(localVideoInfo.j))
      {
        rcz localrcz = (rcz)paramMap.get(Long.valueOf(Long.parseLong(localVideoInfo.j)));
        if (localrcz != null) {
          localVideoInfo.q = localrcz.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryy
 * JD-Core Version:    0.7.0.1
 */