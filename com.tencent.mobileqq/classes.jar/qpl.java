import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.1.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class qpl
  implements qpm
{
  public qpl(ReadInJoyDraftboxFragment.1 param1) {}
  
  public void a(List<ReadInJoyDraftboxItem> paramList)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxFragment.1.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qpl
 * JD-Core Version:    0.7.0.1
 */