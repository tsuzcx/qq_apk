import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tcf
  implements tch
{
  private String a;
  
  public tcf()
  {
    this.jdField_a_of_type_JavaLangString = "Q.qqstory:DiscoverManager";
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends auko> a(aukp paramaukp, Class<? extends auko> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(CardItem paramCardItem)
  {
    aukp localaukp = a().a().createEntityManager();
    localaukp.a().a();
    try
    {
      CardEntry localCardEntry1 = paramCardItem.toCardEntry();
      paramCardItem = a(localaukp, CardEntry.class, CardEntry.class.getSimpleName(), CardEntry.getCardIdSelection(), new String[] { paramCardItem.cardId });
      if (paramCardItem == null) {
        return;
      }
      paramCardItem = paramCardItem.iterator();
      while (paramCardItem.hasNext())
      {
        CardEntry localCardEntry2 = (CardEntry)paramCardItem.next();
        localCardEntry2.PBData = localCardEntry1.PBData;
        localaukp.a(localCardEntry2);
        ved.a(this.jdField_a_of_type_JavaLangString, "update db cardId=%s id=%d", localCardEntry2.cardId, Long.valueOf(localCardEntry2.getId()));
      }
    }
    finally
    {
      localaukp.a().b();
    }
    localaukp.a().b();
  }
  
  public DiscoverBannerVideoEntry a(String paramString)
  {
    paramString = a(QQStoryContext.a().a().createEntityManager(), DiscoverBannerVideoEntry.class, DiscoverBannerVideoEntry.class.getSimpleName(), "bannerId=?", new String[] { paramString });
    if ((paramString != null) && (paramString.size() > 0)) {
      return (DiscoverBannerVideoEntry)paramString.get(0);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString, toc paramtoc)
  {
    aukp localaukp = a().a().createEntityManager();
    localaukp.a().a();
    try
    {
      if (paramtoc.jdField_b_of_type_JavaUtilList.size() == paramtoc.jdField_a_of_type_JavaUtilList.size())
      {
        DiscoverBannerVideoEntry localDiscoverBannerVideoEntry = new DiscoverBannerVideoEntry();
        localDiscoverBannerVideoEntry.bannerId = paramString;
        localDiscoverBannerVideoEntry.totalCount = paramtoc.jdField_b_of_type_Int;
        paramString = new ArrayList(paramtoc.jdField_b_of_type_JavaUtilList.size());
        int i = 0;
        while (i < paramtoc.jdField_b_of_type_JavaUtilList.size())
        {
          DiscoverBannerVideoEntry.BannerInfo localBannerInfo = new DiscoverBannerVideoEntry.BannerInfo();
          localBannerInfo.b = ((String)paramtoc.jdField_b_of_type_JavaUtilList.get(i));
          localBannerInfo.jdField_a_of_type_JavaLangString = ((String)paramtoc.jdField_a_of_type_JavaUtilList.get(i));
          paramString.add(localBannerInfo);
          i += 1;
        }
        localDiscoverBannerVideoEntry.bannerInfoList = paramString;
        localDiscoverBannerVideoEntry.nextCookie = paramtoc.jdField_a_of_type_JavaLangString;
        localaukp.b(localDiscoverBannerVideoEntry);
      }
      localaukp.a().c();
      return;
    }
    finally
    {
      localaukp.a().b();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcf
 * JD-Core Version:    0.7.0.1
 */