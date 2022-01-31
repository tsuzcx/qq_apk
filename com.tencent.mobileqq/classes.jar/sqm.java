import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sqm
  extends JobSegment<List<sqc>, List<sqb>>
  implements spx
{
  private ArrayList<sqb> jdField_a_of_type_JavaUtilArrayList;
  private List<spv> jdField_a_of_type_JavaUtilList;
  private sqp jdField_a_of_type_Sqp;
  
  public sqm(sqp paramsqp)
  {
    this.jdField_a_of_type_Sqp = paramsqp;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<spv> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((spq)tdc.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new spz(i, this.jdField_a_of_type_Sqp));
    return localArrayList;
  }
  
  private void a(List<sqc> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      spv localspv = (spv)this.jdField_a_of_type_JavaUtilList.remove(0);
      localspv.a(paramList);
      localspv.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      spq.a((sqb)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<sqc> paramList)
  {
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    spq.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((sqc)paramList.get(0)).b, ((sqc)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<sqb> paramList, List<sqc> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        sqb localsqb = (sqb)localIterator.next();
        veg.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localsqb.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqm
 * JD-Core Version:    0.7.0.1
 */