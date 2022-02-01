package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusObserver;
import java.util.ArrayList;

class IndividualityRemoteCommandHandler$MyStatusObserver
  extends StatusObserver
{
  private IndividualityRemoteCommandHandler$MyStatusObserver(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RichStatus> paramArrayList, boolean paramBoolean3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putInt("start", paramInt1);
    localBundle.putInt("end", paramInt2);
    localBundle.putBoolean("over", paramBoolean2);
    localBundle.putSerializable("data", paramArrayList);
    localBundle.putBoolean("isAddFromCard", paramBoolean3);
    localBundle.putInt("which_method", 0);
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 5, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler.MyStatusObserver
 * JD-Core Version:    0.7.0.1
 */