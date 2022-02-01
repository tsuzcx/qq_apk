import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class rdb
{
  public List<rdc> a;
  
  public static rdb a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    rdb localrdb = new rdb();
    if ((paramHotWordInfo != null) && (paramHotWordInfo.rpt_hot_word_item.has()))
    {
      localrdb.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        rdc localrdc = rdc.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localrdb.a.add(localrdc);
      }
    }
    return localrdb;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if ((this.a != null) && (this.a.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((rdc)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdb
 * JD-Core Version:    0.7.0.1
 */