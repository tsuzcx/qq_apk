import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class qsl
{
  private static Boolean a(@NotNull ArticleInfo paramArticleInfo)
  {
    rrr localrrr = (rrr)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a.get(0);
    if ((localrrr == null) || (localrrr.b <= 0)) {
      return Boolean.valueOf(false);
    }
    float f = localrrr.jdField_a_of_type_Int / localrrr.b;
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrb != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrb.c == 1))
    {
      if (f <= 1.3439D) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
    return Boolean.valueOf(true);
  }
  
  private static rrm a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size() > 0)) {
      return (rrm)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.get(0);
    }
    return null;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null));
      if (b(paramArticleInfo)) {
        return true;
      }
    } while (!c(paramArticleInfo));
    return true;
  }
  
  private static boolean b(ArticleInfo paramArticleInfo)
  {
    if (ppe.i(paramArticleInfo))
    {
      if (g(paramArticleInfo)) {}
      while ((h(paramArticleInfo)) || (i(paramArticleInfo))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean c(ArticleInfo paramArticleInfo)
  {
    if (ppe.d(paramArticleInfo))
    {
      if (d(paramArticleInfo)) {}
      while ((e(paramArticleInfo)) || (f(paramArticleInfo))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean d(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 2) && (k(paramArticleInfo));
  }
  
  private static boolean e(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6))
    {
      int j = paramArticleInfo.mVideoJsonWidth;
      if (paramArticleInfo.mVideoJsonHeight == 0) {}
      for (int i = 1; j / i < 0.75D; i = paramArticleInfo.mVideoJsonHeight) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean f(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 9) || (pqw.e(paramArticleInfo))) {}
    do
    {
      do
      {
        return false;
      } while (!j(paramArticleInfo));
      if (paramArticleInfo.mChannelID == 0L) {
        return true;
      }
      paramArticleInfo = a(paramArticleInfo);
    } while ((paramArticleInfo == null) || (paramArticleInfo.b <= 0) || (paramArticleInfo.jdField_a_of_type_Int / paramArticleInfo.b >= 1.671428571428572D));
    return true;
  }
  
  private static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (l(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a.size() == 1))
    {
      if (paramArticleInfo.mChannelID == 0L) {
        return true;
      }
      paramArticleInfo = (rrr)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a.get(0);
      if ((paramArticleInfo != null) && (paramArticleInfo.b != 0) && (paramArticleInfo.jdField_a_of_type_Int != 0) && (paramArticleInfo.jdField_a_of_type_Int / paramArticleInfo.b < 1.671428571428572D)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean h(ArticleInfo paramArticleInfo)
  {
    if (ppe.b(paramArticleInfo) != 22) {}
    while ((!l(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a.size() != 1)) {
      return false;
    }
    return a(paramArticleInfo).booleanValue();
  }
  
  private static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((ppe.b(paramArticleInfo) == 23) && (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.size() > 0))
    {
      paramArticleInfo = (rrs)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0);
      if (paramArticleInfo.d == 0) {
        paramArticleInfo.d = 1;
      }
      if (paramArticleInfo.c / paramArticleInfo.d < 0.75D) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean j(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size() == 1);
  }
  
  private static boolean k(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent()) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size() > 0);
  }
  
  private static boolean l(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qsl
 * JD-Core Version:    0.7.0.1
 */