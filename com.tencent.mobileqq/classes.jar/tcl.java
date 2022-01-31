import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.LikeEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tcl
  implements tch
{
  public static final String a;
  public static final String b = sxm.a("StoryGroupSvc.do_like_video");
  private aukp a;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxm.a("StorySvc.do_like_video");
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends auko> a(aukp paramaukp, Class<? extends auko> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<LikeEntry> a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      List localList = a(this.jdField_a_of_type_Aukp, LikeEntry.class, LikeEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aukp = QQStoryContext.a().a().createEntityManager();
  }
  
  public void a(@NonNull LikeEntry paramLikeEntry)
  {
    aukp localaukp = a().a().createEntityManager();
    localaukp.a().a();
    try
    {
      paramLikeEntry.type = 3;
      paramLikeEntry.setStatus(1000);
      localaukp.b(paramLikeEntry);
      LikeEntry localLikeEntry = new LikeEntry();
      localLikeEntry.copy(paramLikeEntry);
      localLikeEntry.type = 4;
      localLikeEntry.setStatus(1000);
      localaukp.b(localLikeEntry);
      localaukp.a().c();
      return;
    }
    finally
    {
      localaukp.a().b();
    }
  }
  
  public void a(@NonNull List<LikeEntry> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    }
    aukp localaukp;
    Object localObject;
    for (;;)
    {
      localaukp = a().a().createEntityManager();
      localaukp.a().a();
      if (!paramBoolean2) {
        break;
      }
      try
      {
        localObject = a(paramString, paramBoolean1);
        if (localObject == null) {
          break;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LikeEntry localLikeEntry = (LikeEntry)((Iterator)localObject).next();
          localLikeEntry.setStatus(1001);
          localaukp.b(localLikeEntry);
        }
        i = 3;
      }
      finally
      {
        localaukp.a().b();
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (LikeEntry)paramList.next();
      ((LikeEntry)localObject).feedId = paramString;
      ((LikeEntry)localObject).type = i;
      localaukp.b((auko)localObject);
    }
    localaukp.a().c();
    localaukp.a().b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aukp.a();
  }
  
  public void b(@NonNull LikeEntry paramLikeEntry)
  {
    paramLikeEntry.setStatus(1001);
    this.jdField_a_of_type_Aukp.a(paramLikeEntry, "unionId=? and feedId= ? and type in (?,?)", new String[] { paramLikeEntry.unionId, paramLikeEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcl
 * JD-Core Version:    0.7.0.1
 */