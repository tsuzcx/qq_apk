import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class slb
  implements qfs
{
  private List<VideoInfo> a;
  
  public slb(List<VideoInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void a(int paramInt, Map<Long, rpf> paramMap)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if (!TextUtils.isEmpty(localVideoInfo.j))
      {
        rpf localrpf = (rpf)paramMap.get(Long.valueOf(Long.parseLong(localVideoInfo.j)));
        if (localrpf != null) {
          localVideoInfo.q = localrpf.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slb
 * JD-Core Version:    0.7.0.1
 */