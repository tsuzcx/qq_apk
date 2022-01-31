import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class rkr
  implements rje
{
  rkr(rkp paramrkp) {}
  
  public List<qyp> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (VideoInfo)paramList.next();
        if (localObject != null)
        {
          localObject = qys.a((VideoInfo)localObject);
          if (localObject != null) {
            localArrayList.add(rqj.a((BaseArticleInfo)localObject, true));
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rkr
 * JD-Core Version:    0.7.0.1
 */