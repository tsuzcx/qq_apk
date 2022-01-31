import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class mgz
  implements Runnable
{
  public mgz(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = ((KandianMergeManager)ReadInJoyUtils.a().getManager(161)).f();
    ThreadManager.getUIHandler().post(new mha(this, localKandianOx210MsgInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgz
 * JD-Core Version:    0.7.0.1
 */