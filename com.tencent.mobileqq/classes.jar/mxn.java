import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class mxn
  extends BroadcastReceiver
{
  private final WeakReference<mxk> a;
  
  private mxn(mxk parammxk)
  {
    this.a = new WeakReference(parammxk);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (QLog.isColorLevel()) {
          QLog.i("WTogetherRealNameVideoProcessHelper", 2, "onReceive action[" + paramContext + "]");
        }
      } while (!"tencent.video.q2v.avReceivePushMsg".equals(paramContext));
      bool = paramIntent.getBooleanExtra("real_name_result", false);
      paramContext = (mxk)this.a.get();
    } while (paramContext == null);
    mxk.a(paramContext, bool);
    mxk.b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxn
 * JD-Core Version:    0.7.0.1
 */