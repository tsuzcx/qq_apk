import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class sgn
  implements Runnable
{
  public sgn(Conversation paramConversation, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = NetworkUtil.e(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(new sgo(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgn
 * JD-Core Version:    0.7.0.1
 */