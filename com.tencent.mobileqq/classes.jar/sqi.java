import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class sqi
  extends JobSegment<List<spy>, List<spy>>
{
  private sqm a;
  
  public sqi(sqm paramsqm)
  {
    this.a = paramsqm;
  }
  
  protected void a(JobContext paramJobContext, List<spy> paramList)
  {
    int i = 1;
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((spy)paramJobContext.next()).a(this.a);
    }
    spn.a(paramList);
    spn localspn = (spn)tcz.a(30);
    spf localspf = localspn.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localspf.a())
      {
        ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localspf.a());
        paramJobContext = paramList.subList(0, localspf.a());
      }
    }
    if (localspn.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((spy)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((spy)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((spy)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqi
 * JD-Core Version:    0.7.0.1
 */