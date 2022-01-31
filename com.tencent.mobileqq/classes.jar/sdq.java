import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sdq
  extends JobSegment<List<sdg>, List<sdf>>
  implements sdb
{
  private ArrayList<sdf> jdField_a_of_type_JavaUtilArrayList;
  private List<scz> jdField_a_of_type_JavaUtilList;
  private sdt jdField_a_of_type_Sdt;
  
  public sdq(sdt paramsdt)
  {
    this.jdField_a_of_type_Sdt = paramsdt;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<scz> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((scu)sqg.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new sdd(i, this.jdField_a_of_type_Sdt));
    return localArrayList;
  }
  
  private void a(List<sdg> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      scz localscz = (scz)this.jdField_a_of_type_JavaUtilList.remove(0);
      localscz.a(paramList);
      localscz.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      scu.a((sdf)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<sdg> paramList)
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    scu.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((sdg)paramList.get(0)).b, ((sdg)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<sdf> paramList, List<sdg> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        sdf localsdf = (sdf)localIterator.next();
        urk.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localsdf.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdq
 * JD-Core Version:    0.7.0.1
 */