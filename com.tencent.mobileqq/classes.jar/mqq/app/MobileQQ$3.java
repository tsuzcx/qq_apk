package mqq.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

class MobileQQ$3
  implements Runnable
{
  MobileQQ$3(MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    if ((MobileQQ.access$500(this.this$0).isEmpty()) && (this.this$0.appActivities.isEmpty()) && (this.this$0.otherTypeActivitys.isEmpty()))
    {
      localObject1 = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
      this.this$0.sendBroadcast((Intent)localObject1);
      if (this.this$0.getQQProcessName().endsWith(":video"))
      {
        MobileQQ.access$100(this.this$0).msfSub.unbindMsfService();
        MobileQQ.access$000(this.this$0).onDestroy();
      }
      this.this$0.mHandler.postDelayed(new MobileQQ.3.1(this), 300L);
      return;
    }
    Object localObject1 = new StringBuffer();
    Iterator localIterator = MobileQQ.access$500(this.this$0).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (BaseActivity)((WeakReference)localIterator.next()).get();
      if (localObject2 != null)
      {
        ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    localIterator = this.this$0.appActivities.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (AppActivity)((WeakReference)localIterator.next()).get();
      if (localObject2 != null)
      {
        ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    localIterator = this.this$0.otherTypeActivitys.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Activity)((WeakReference)localIterator.next()).get();
      if (localObject2 != null)
      {
        ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    if ((!MobileQQ.access$700()) && (QLog.isColorLevel()))
    {
      QLog.i("mqq", 2, "do exit ->" + ((StringBuffer)localObject1).toString());
      MobileQQ.access$702(true);
    }
    ((StringBuffer)localObject1).delete(0, ((StringBuffer)localObject1).length());
    this.this$0.mHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MobileQQ.3
 * JD-Core Version:    0.7.0.1
 */