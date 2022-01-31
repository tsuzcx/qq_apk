import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import java.util.List;

public class lqt
  implements Runnable
{
  public lqt(ChannelInfoModule paramChannelInfoModule, List paramList) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqt
 * JD-Core Version:    0.7.0.1
 */