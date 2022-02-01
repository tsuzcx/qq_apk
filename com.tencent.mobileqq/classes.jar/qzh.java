import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class qzh
{
  private static qwf a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new qvt(paramBaseArticleInfo);
    }
    return new qze(paramBaseArticleInfo);
  }
  
  public static qwf a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (a(paramBaseArticleInfo)) {
      return a(1, paramBaseArticleInfo);
    }
    return a(0, paramBaseArticleInfo);
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (!sel.q((ArticleInfo)paramBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzh
 * JD-Core Version:    0.7.0.1
 */