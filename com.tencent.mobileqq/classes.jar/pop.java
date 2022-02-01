import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.Comparator;

class pop
  implements Comparator<ArticleInfo>
{
  pop(pon parampon) {}
  
  public int a(ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2)
  {
    if (paramArticleInfo1.mRecommendSeq == paramArticleInfo2.mRecommendSeq) {
      return 0;
    }
    if (paramArticleInfo1.mRecommendSeq > paramArticleInfo2.mRecommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pop
 * JD-Core Version:    0.7.0.1
 */