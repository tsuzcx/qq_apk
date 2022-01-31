import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.PstnCallbackWaitingUi;
import com.tencent.qphone.base.util.BaseApplication;

public class jzk
  implements Runnable
{
  public jzk(PstnCallbackWaitingUi paramPstnCallbackWaitingUi) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = this.a.a.getApp();
    Intent localIntent = new Intent(localBaseApplication, AVActivity.class);
    localIntent.setFlags(268566528);
    localBaseApplication.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzk
 * JD-Core Version:    0.7.0.1
 */