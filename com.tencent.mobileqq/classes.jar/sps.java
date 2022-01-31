import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.LikeEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sps
  implements spo
{
  public static final String a;
  public static final String b = skt.a("StoryGroupSvc.do_like_video");
  private atmp a;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.do_like_video");
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends atmo> a(atmp paramatmp, Class<? extends atmo> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramatmp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<LikeEntry> a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      List localList = a(this.jdField_a_of_type_Atmp, LikeEntry.class, LikeEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Atmp = QQStoryContext.a().a().createEntityManager();
  }
  
  public void a(@NonNull LikeEntry paramLikeEntry)
  {
    atmp localatmp = a().a().createEntityManager();
    localatmp.a().a();
    try
    {
      paramLikeEntry.type = 3;
      paramLikeEntry.setStatus(1000);
      localatmp.b(paramLikeEntry);
      LikeEntry localLikeEntry = new LikeEntry();
      localLikeEntry.copy(paramLikeEntry);
      localLikeEntry.type = 4;
      localLikeEntry.setStatus(1000);
      localatmp.b(localLikeEntry);
      localatmp.a().c();
      return;
    }
    finally
    {
      localatmp.a().b();
    }
  }
  
  public void a(@NonNull List<LikeEntry> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    }
    atmp localatmp;
    Object localObject;
    for (;;)
    {
      localatmp = a().a().createEntityManager();
      localatmp.a().a();
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
          localatmp.b(localLikeEntry);
        }
        i = 3;
      }
      finally
      {
        localatmp.a().b();
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (LikeEntry)paramList.next();
      ((LikeEntry)localObject).feedId = paramString;
      ((LikeEntry)localObject).type = i;
      localatmp.b((atmo)localObject);
    }
    localatmp.a().c();
    localatmp.a().b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atmp.a();
  }
  
  public void b(@NonNull LikeEntry paramLikeEntry)
  {
    paramLikeEntry.setStatus(1001);
    this.jdField_a_of_type_Atmp.a(paramLikeEntry, "unionId=? and feedId= ? and type in (?,?)", new String[] { paramLikeEntry.unionId, paramLikeEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sps
 * JD-Core Version:    0.7.0.1
 */