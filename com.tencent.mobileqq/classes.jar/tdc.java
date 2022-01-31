import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.TagEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Set;

public class tdc
  implements tch
{
  private long jdField_a_of_type_Long;
  private aukp jdField_a_of_type_Aukp;
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends auko> a(aukp paramaukp, Class<? extends auko> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<vve> a(String paramString)
  {
    Object localObject = a(this.jdField_a_of_type_Aukp, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    localObject = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((List)localObject).add(new vve((TagEntry)paramString.next()));
    }
    return localObject;
  }
  
  public List<vve> a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      paramString = a(paramList, a(paramString));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public List<vve> a(List<StoryVideoItem> paramList, List<vve> paramList1)
  {
    ArrayList localArrayList;
    HashSet localHashSet;
    try
    {
      localArrayList = new ArrayList();
      localHashSet = new HashSet();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
          if ((localStoryVideoItem.mTagInfoBase != null) && (!localHashSet.contains(localStoryVideoItem.mTagInfoBase)))
          {
            localArrayList.add(localStoryVideoItem.mTagInfoBase);
            localHashSet.add(localStoryVideoItem.mTagInfoBase);
          }
        }
      }
      if (paramList1 == null) {
        break label167;
      }
    }
    finally {}
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (vve)paramList.next();
      if (!localHashSet.contains(paramList1))
      {
        localArrayList.add(paramList1);
        localHashSet.add(paramList1);
      }
    }
    label167:
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aukp = a().a().createEntityManager();
  }
  
  public void a(String paramString, List<vve> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = a(this.jdField_a_of_type_Aukp, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TagEntry localTagEntry = (TagEntry)((Iterator)localObject).next();
            localTagEntry.setStatus(1001);
            this.jdField_a_of_type_Aukp.b(localTagEntry);
          }
        }
      }
      finally
      {
        try
        {
          this.jdField_a_of_type_Aukp.a().b();
          throw paramString;
        }
        finally {}
        this.jdField_a_of_type_Aukp.a().a();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = ((vve)paramList.next()).a();
          ((TagEntry)localObject).feedId = paramString;
          this.jdField_a_of_type_Aukp.b((auko)localObject);
        }
        this.jdField_a_of_type_Aukp.a().c();
        this.jdField_a_of_type_Aukp.a().b();
      }
    }
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (Math.abs(this.jdField_a_of_type_Long - System.currentTimeMillis()) > 60000L) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        ved.d("Q.qqstory:TagManager", "request still waiting , %s", new Object[] { localArrayList });
      }
      if (paramList.size() == 0) {
        break;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = new tmj();
      ((tmj)localObject).a = paramList;
      syo.a().a((sys)localObject, new tdd(this));
      ved.d("Q.qqstory:TagManager", "request tag list :%s", new Object[] { paramList });
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          localArrayList.add(str);
        } else {
          ((List)localObject).add(str);
        }
      }
      paramList = (List<String>)localObject;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdc
 * JD-Core Version:    0.7.0.1
 */