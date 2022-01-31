import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class och
{
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 0;
    int i = j;
    if (b(paramBaseArticleInfo))
    {
      i = j;
      if (paramBaseArticleInfo.mSocialFeedInfo.a.b != null) {
        i = paramBaseArticleInfo.mSocialFeedInfo.a.b.intValue();
      }
    }
    return i;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 25) || ((paramBaseArticleInfo.mFeedType == 1) && (a(paramBaseArticleInfo) == 25));
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     och
 * JD-Core Version:    0.7.0.1
 */