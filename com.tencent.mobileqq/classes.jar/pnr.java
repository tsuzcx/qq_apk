import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class pnr
{
  public static void a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
        if ((localArticleInfo != null) && (localArticleInfo.mFeedType == 29)) {
          QLog.d("ReadInJoyLogHelper", 1, new Object[] { "printProteusOnline: \n", localArticleInfo.toProteusOnlineString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnr
 * JD-Core Version:    0.7.0.1
 */