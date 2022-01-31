import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class sew
  extends BroadcastReceiver
{
  sew(set paramset) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.a.a);
    this.a.b(false, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sew
 * JD-Core Version:    0.7.0.1
 */