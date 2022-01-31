import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.PstnCallbackWaitingUi;
import com.tencent.qphone.base.util.BaseApplication;

public class kaz
  implements Runnable
{
  public kaz(PstnCallbackWaitingUi paramPstnCallbackWaitingUi) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = this.a.a.getApp();
    Intent localIntent = new Intent(localBaseApplication, AVActivity.class);
    localIntent.setFlags(268566528);
    localBaseApplication.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kaz
 * JD-Core Version:    0.7.0.1
 */