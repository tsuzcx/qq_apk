import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class tdz
  implements Runnable
{
  public tdz(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void run()
  {
    List localList = ProfileLabelEditorActivity.a(this.a, this.a.app.getCurrentAccountUin());
    ThreadManager.getUIHandler().post(new tea(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdz
 * JD-Core Version:    0.7.0.1
 */