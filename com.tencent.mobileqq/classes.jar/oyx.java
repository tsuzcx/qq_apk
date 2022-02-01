import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class oyx
{
  public static long a(BaseArticleInfo paramBaseArticleInfo)
  {
    long l1;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {
      l1 = 0L;
    }
    long l2;
    do
    {
      return l1;
      if (paramBaseArticleInfo.mSocialFeedInfo.a == null) {
        break;
      }
      l2 = paramBaseArticleInfo.mSocialFeedInfo.a.a;
      l1 = l2;
    } while (l2 != 0L);
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        return l1;
      }
      catch (NumberFormatException paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        return l2;
      }
      l2 = 0L;
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {}
    while ((!paramArticleInfo.mSocialFeedInfo.a()) || (pgb.f(paramArticleInfo)) || (b(paramArticleInfo))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a()))
    {
      if (pgb.f((ArticleInfo)paramBaseArticleInfo)) {
        return true;
      }
      if (!b(paramBaseArticleInfo)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo) == pay.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyx
 * JD-Core Version:    0.7.0.1
 */