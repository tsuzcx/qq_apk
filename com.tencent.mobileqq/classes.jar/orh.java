import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

final class orh
  implements Comparator<Pair<Long, BaseArticleInfo>>
{
  public int a(Pair<Long, BaseArticleInfo> paramPair1, Pair<Long, BaseArticleInfo> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     orh
 * JD-Core Version:    0.7.0.1
 */