import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tfs
  extends JobSegment<List<tso>, List<tso>>
{
  private final tsn a;
  
  public tfs()
  {
    this(new tft());
  }
  
  public tfs(tsn paramtsn)
  {
    this.a = paramtsn;
  }
  
  protected void a(JobContext paramJobContext, List<tso> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, "list empty");
      }
      notifyResult(paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info start");
    }
    paramJobContext = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      paramJobContext.add(((tso)localIterator.next()).b);
    }
    paramJobContext = new tsi(paramJobContext);
    if (this.a != null) {
      paramJobContext.a = this.a;
    }
    paramJobContext.a(new tfu(this, paramList));
    paramJobContext.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfs
 * JD-Core Version:    0.7.0.1
 */