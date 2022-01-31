import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

final class omw
  implements Comparator<Pair<Long, BaseArticleInfo>>
{
  public int a(Pair<Long, BaseArticleInfo> paramPair1, Pair<Long, BaseArticleInfo> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omw
 * JD-Core Version:    0.7.0.1
 */