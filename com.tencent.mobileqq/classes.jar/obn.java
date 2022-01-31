import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

class obn
  implements Comparator<Pair<Long, Pair<View, BaseArticleInfo>>>
{
  obn(obm paramobm) {}
  
  public int a(Pair<Long, Pair<View, BaseArticleInfo>> paramPair1, Pair<Long, Pair<View, BaseArticleInfo>> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     obn
 * JD-Core Version:    0.7.0.1
 */