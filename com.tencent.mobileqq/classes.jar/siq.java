import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.statistics.ReportController;

public class siq
  implements Runnable
{
  public siq(Conversation paramConversation, Object paramObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof String)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)this.jdField_a_of_type_JavaLangObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a, "dc00898", "", "", "0X80087C2", "0X80087C2", i, 0, "", "", "", "");
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     siq
 * JD-Core Version:    0.7.0.1
 */