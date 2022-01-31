import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class qbf
{
  public List<qbg> a;
  
  public static qbf a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    qbf localqbf = new qbf();
    if (paramHotWordInfo.rpt_hot_word_item.has())
    {
      localqbf.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        qbg localqbg = qbg.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localqbf.a.add(localqbg);
      }
    }
    return localqbf;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if (this.a.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((qbg)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbf
 * JD-Core Version:    0.7.0.1
 */