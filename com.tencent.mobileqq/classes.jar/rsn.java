import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class rsn
{
  private static rpj a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new rox(paramBaseArticleInfo);
    }
    return new rsk(paramBaseArticleInfo);
  }
  
  public static rpj a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (a(paramBaseArticleInfo)) {
      return a(1, paramBaseArticleInfo);
    }
    return a(0, paramBaseArticleInfo);
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ppe.q((ArticleInfo)paramBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsn
 * JD-Core Version:    0.7.0.1
 */