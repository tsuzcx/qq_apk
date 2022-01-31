import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class qja
  implements qhn
{
  qja(qiy paramqiy) {}
  
  public List<pxn> a(List<VideoInfo> paramList)
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
          localObject = pxq.a((VideoInfo)localObject);
          if (localObject != null) {
            localArrayList.add(qoe.a((BaseArticleInfo)localObject, true));
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qja
 * JD-Core Version:    0.7.0.1
 */