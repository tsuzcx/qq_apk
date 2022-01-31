import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class sdp
  extends JobSegment<List<sdf>, List<sdf>>
{
  private sdt a;
  
  public sdp(sdt paramsdt)
  {
    this.a = paramsdt;
  }
  
  protected void a(JobContext paramJobContext, List<sdf> paramList)
  {
    int i = 1;
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((sdf)paramJobContext.next()).a(this.a);
    }
    scu.a(paramList);
    scu localscu = (scu)sqg.a(30);
    scm localscm = localscu.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localscm.a())
      {
        urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localscm.a());
        paramJobContext = paramList.subList(0, localscm.a());
      }
    }
    if (localscu.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((sdf)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((sdf)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((sdf)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdp
 * JD-Core Version:    0.7.0.1
 */