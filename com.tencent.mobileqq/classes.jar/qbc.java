import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class qbc
{
  public List<qbd> a;
  
  public static qbc a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    qbc localqbc = new qbc();
    if (paramHotWordInfo.rpt_hot_word_item.has())
    {
      localqbc.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        qbd localqbd = qbd.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localqbc.a.add(localqbd);
      }
    }
    return localqbc;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if (this.a.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((qbd)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbc
 * JD-Core Version:    0.7.0.1
 */