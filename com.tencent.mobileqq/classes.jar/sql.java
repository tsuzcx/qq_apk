import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class sql
  extends JobSegment<List<sqb>, List<sqb>>
{
  private sqp a;
  
  public sql(sqp paramsqp)
  {
    this.a = paramsqp;
  }
  
  protected void a(JobContext paramJobContext, List<sqb> paramList)
  {
    int i = 1;
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((sqb)paramJobContext.next()).a(this.a);
    }
    spq.a(paramList);
    spq localspq = (spq)tdc.a(30);
    spi localspi = localspq.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localspi.a())
      {
        veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localspi.a());
        paramJobContext = paramList.subList(0, localspi.a());
      }
    }
    if (localspq.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((sqb)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((sqb)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((sqb)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sql
 * JD-Core Version:    0.7.0.1
 */