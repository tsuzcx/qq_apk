import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class spn
  implements spo
{
  private atmp a()
  {
    return QQStoryContext.a().a().createEntityManager();
  }
  
  public static List<? extends atmo> a(atmp paramatmp, Class<? extends atmo> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramatmp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<HotSortVideoEntry> a(String paramString)
  {
    List localList = a(a(), HotSortVideoEntry.class, HotSortVideoEntry.class.getSimpleName(), "groupId=?", new String[] { paramString });
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    urk.a("Q.qqstory:HotSortVideoManager", "query HotSortVideoEntry id: %s, size: %d", paramString, Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public void a() {}
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    atmp localatmp = a();
    paramHotSortVideoEntry.setStatus(1001);
    localatmp.a(paramHotSortVideoEntry);
  }
  
  public void a(List<HotSortVideoEntry> paramList)
  {
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    localatmp.a().a();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)paramList.next();
        localHotSortVideoEntry.setStatus(1001);
        localatmp.a(localHotSortVideoEntry);
      }
    }
    finally
    {
      localatmp.a().b();
    }
    localatmp.a().b();
  }
  
  public void a(List<HotSortVideoEntry> paramList, String paramString, boolean paramBoolean)
  {
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    localatmp.a().a();
    Object localObject;
    HotSortVideoEntry localHotSortVideoEntry;
    if (paramBoolean) {
      try
      {
        localObject = a(paramString);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
            localHotSortVideoEntry.setStatus(1001);
            localatmp.b(localHotSortVideoEntry);
          }
        }
        localObject = paramList.iterator();
      }
      finally
      {
        localatmp.a().b();
      }
    }
    while (((Iterator)localObject).hasNext())
    {
      localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
      localHotSortVideoEntry.groupId = paramString;
      localHotSortVideoEntry.setStatus(1000);
      localatmp.b(localHotSortVideoEntry);
    }
    urk.a("Q.qqstory:HotSortVideoManager", "insert HotSortVideoEntry list groupId is %s, size is %d", paramString, Integer.valueOf(paramList.size()));
    localatmp.a().c();
    localatmp.a().b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spn
 * JD-Core Version:    0.7.0.1
 */