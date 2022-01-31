import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class lrd
  implements Runnable
{
  public lrd(InterestLabelInfoModule paramInterestLabelInfoModule) {}
  
  public void run()
  {
    List localList = this.a.a.a(InterestLabelInfo.class, true, null, null, null, null, null, null);
    this.a.c(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrd
 * JD-Core Version:    0.7.0.1
 */