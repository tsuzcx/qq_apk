import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class ppj
{
  public List<ppk> a;
  
  public static ppj a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    ppj localppj = new ppj();
    if (paramHotWordInfo.rpt_hot_word_item.has())
    {
      localppj.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        ppk localppk = ppk.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localppj.a.add(localppk);
      }
    }
    return localppj;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if (this.a.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((ppk)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppj
 * JD-Core Version:    0.7.0.1
 */