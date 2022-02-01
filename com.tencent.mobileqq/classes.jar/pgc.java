import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.ArrayList;
import java.util.Iterator;

class pgc
{
  public long a;
  public ArrayList<Pair<BaseArticleInfo, Float>> a;
  public long b;
  
  private pgc(pfs parampfs)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ArrayList<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(((BaseArticleInfo)((Pair)localIterator.next()).first).mArticleID));
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("screenInfo : \n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      localStringBuilder.append("【").append(((BaseArticleInfo)localPair.first).mTitle).append("】");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgc
 * JD-Core Version:    0.7.0.1
 */