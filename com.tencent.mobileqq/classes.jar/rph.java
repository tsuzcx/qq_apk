import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class rph
{
  public List<rpi> a;
  
  public static rph a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    rph localrph = new rph();
    if ((paramHotWordInfo != null) && (paramHotWordInfo.rpt_hot_word_item.has()))
    {
      localrph.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        rpi localrpi = rpi.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localrph.a.add(localrpi);
      }
    }
    return localrph;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if ((this.a != null) && (this.a.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((rpi)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rph
 * JD-Core Version:    0.7.0.1
 */