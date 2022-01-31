import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tcj
  implements tck
{
  private aukn a()
  {
    return QQStoryContext.a().a().createEntityManager();
  }
  
  public static List<? extends aukm> a(aukn paramaukn, Class<? extends aukm> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukn.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<HotSortVideoEntry> a(String paramString)
  {
    List localList = a(a(), HotSortVideoEntry.class, HotSortVideoEntry.class.getSimpleName(), "groupId=?", new String[] { paramString });
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    veg.a("Q.qqstory:HotSortVideoManager", "query HotSortVideoEntry id: %s, size: %d", paramString, Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public void a() {}
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    aukn localaukn = a();
    paramHotSortVideoEntry.setStatus(1001);
    localaukn.a(paramHotSortVideoEntry);
  }
  
  public void a(List<HotSortVideoEntry> paramList)
  {
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    localaukn.a().a();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)paramList.next();
        localHotSortVideoEntry.setStatus(1001);
        localaukn.a(localHotSortVideoEntry);
      }
    }
    finally
    {
      localaukn.a().b();
    }
    localaukn.a().b();
  }
  
  public void a(List<HotSortVideoEntry> paramList, String paramString, boolean paramBoolean)
  {
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    localaukn.a().a();
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
            localaukn.b(localHotSortVideoEntry);
          }
        }
        localObject = paramList.iterator();
      }
      finally
      {
        localaukn.a().b();
      }
    }
    while (((Iterator)localObject).hasNext())
    {
      localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
      localHotSortVideoEntry.groupId = paramString;
      localHotSortVideoEntry.setStatus(1000);
      localaukn.b(localHotSortVideoEntry);
    }
    veg.a("Q.qqstory:HotSortVideoManager", "insert HotSortVideoEntry list groupId is %s, size is %d", paramString, Integer.valueOf(paramList.size()));
    localaukn.a().c();
    localaukn.a().b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcj
 * JD-Core Version:    0.7.0.1
 */