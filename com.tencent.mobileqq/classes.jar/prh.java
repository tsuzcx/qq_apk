import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import java.util.Comparator;

class prh
  implements Comparator<WeiShiVideoArticleInfo>
{
  prh(prf paramprf) {}
  
  public int a(WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo1, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo2)
  {
    if (paramWeiShiVideoArticleInfo1.recommendSeq == paramWeiShiVideoArticleInfo2.recommendSeq) {
      return 0;
    }
    if (paramWeiShiVideoArticleInfo1.recommendSeq > paramWeiShiVideoArticleInfo2.recommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prh
 * JD-Core Version:    0.7.0.1
 */