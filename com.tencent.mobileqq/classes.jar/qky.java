import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class qky
{
  public List<qkz> a;
  
  public static qky a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    qky localqky = new qky();
    if (paramHotWordInfo.rpt_hot_word_item.has())
    {
      localqky.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        qkz localqkz = qkz.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localqky.a.add(localqkz);
      }
    }
    return localqky;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if (this.a.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((qkz)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */