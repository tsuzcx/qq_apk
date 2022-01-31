import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sqj
  extends JobSegment<List<spz>, List<spy>>
  implements spu
{
  private ArrayList<spy> jdField_a_of_type_JavaUtilArrayList;
  private List<sps> jdField_a_of_type_JavaUtilList;
  private sqm jdField_a_of_type_Sqm;
  
  public sqj(sqm paramsqm)
  {
    this.jdField_a_of_type_Sqm = paramsqm;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<sps> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((spn)tcz.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new spw(i, this.jdField_a_of_type_Sqm));
    return localArrayList;
  }
  
  private void a(List<spz> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      sps localsps = (sps)this.jdField_a_of_type_JavaUtilList.remove(0);
      localsps.a(paramList);
      localsps.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      spn.a((spy)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<spz> paramList)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    spn.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((spz)paramList.get(0)).b, ((spz)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<spy> paramList, List<spz> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        spy localspy = (spy)localIterator.next();
        ved.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localspy.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqj
 * JD-Core Version:    0.7.0.1
 */