import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class pju
{
  public static void a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    a(paramContext, paramArticleInfo, false);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("PGCShortContentUtils", 1, "articleInfo is null");
      return;
    }
    if (paramArticleInfo.isCardJumpUrlAvailable == 1)
    {
      onk.e(paramContext, paramArticleInfo.getCardJumpUrl());
      return;
    }
    onk.a(paramContext, paramArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pju
 * JD-Core Version:    0.7.0.1
 */