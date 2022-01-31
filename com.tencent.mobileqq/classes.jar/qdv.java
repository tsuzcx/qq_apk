import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class qdv
{
  private static qbe a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new qar(paramBaseArticleInfo);
    }
    return new qdt(paramBaseArticleInfo);
  }
  
  public static qbe a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (a(paramBaseArticleInfo)) {
      return a(1, paramBaseArticleInfo);
    }
    return a(0, paramBaseArticleInfo);
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ram.q((ArticleInfo)paramBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdv
 * JD-Core Version:    0.7.0.1
 */