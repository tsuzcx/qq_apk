import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class rfk
{
  public List<rfl> a;
  
  public static rfk a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    rfk localrfk = new rfk();
    if ((paramHotWordInfo != null) && (paramHotWordInfo.rpt_hot_word_item.has()))
    {
      localrfk.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        rfl localrfl = rfl.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localrfk.a.add(localrfl);
      }
    }
    return localrfk;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if ((this.a != null) && (this.a.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((rfl)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfk
 * JD-Core Version:    0.7.0.1
 */