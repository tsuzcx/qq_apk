import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class njc
  implements Runnable
{
  public njc(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Int == 0)
    {
      if (MsgTabStoryNodeListManager.a(this.a)) {
        this.a.jdField_a_of_type_JavaLangRunnable = null;
      }
      return;
    }
    ThreadManager.getUIHandler().post(this.a.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njc
 * JD-Core Version:    0.7.0.1
 */