import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager;
import com.tencent.qphone.base.util.QLog;

public class kqq
  extends BroadcastReceiver
{
  public kqq(AccountDetailVideoManager paramAccountDetailVideoManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "onReceive ===>" + paramContext);
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqq
 * JD-Core Version:    0.7.0.1
 */