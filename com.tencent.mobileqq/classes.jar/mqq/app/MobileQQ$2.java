package mqq.app;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

class MobileQQ$2
  implements Runnable
{
  MobileQQ$2(MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    try
    {
      i = MobileQQ.access$500(this.this$0).size();
      QLog.d("mqq", 1, "closeAllActivitys...BaseActivity count: " + i);
      i -= 1;
      if (i < 0) {
        break label163;
      }
      Object localObject1 = (WeakReference)MobileQQ.access$500(this.this$0).get(i);
      if (localObject1 == null) {
        break label408;
      }
      localObject1 = (BaseActivity)((WeakReference)localObject1).get();
      label75:
      if (localObject1 == null) {
        MobileQQ.access$500(this.this$0).remove(i);
      } else if (!((Activity)localObject1).isFinishing()) {
        ((Activity)localObject1).finish();
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "closeAllActivitys: " + localException.getMessage());
      }
    }
    label145:
    return;
    MobileQQ.access$500(this.this$0).remove(i);
    break label401;
    label163:
    int i = this.this$0.appActivities.size();
    QLog.d("mqq", 1, "closeAllActivitys...AppActivity count: " + i);
    i -= 1;
    label203:
    if (i >= 0)
    {
      localObject2 = (WeakReference)this.this$0.appActivities.get(i);
      if (localObject2 == null) {
        break label420;
      }
      localObject2 = (AppActivity)((WeakReference)localObject2).get();
      label234:
      if (localObject2 == null) {
        this.this$0.appActivities.remove(i);
      } else if (!((Activity)localObject2).isFinishing()) {
        ((Activity)localObject2).finish();
      } else {
        this.this$0.appActivities.remove(i);
      }
    }
    else
    {
      i = this.this$0.otherTypeActivitys.size();
      QLog.d("mqq", 1, "closeAllActivitys...other Activity count: " + i);
      i -= 1;
      if (i < 0) {
        break label430;
      }
      localObject2 = (WeakReference)this.this$0.otherTypeActivitys.get(i);
      if (localObject2 == null) {
        break label432;
      }
    }
    label322:
    for (Object localObject2 = (Activity)((WeakReference)localObject2).get();; localObject2 = null)
    {
      if (localObject2 == null)
      {
        this.this$0.otherTypeActivitys.remove(i);
      }
      else if (!((Activity)localObject2).isFinishing())
      {
        ((Activity)localObject2).finish();
      }
      else
      {
        this.this$0.otherTypeActivitys.remove(i);
        break label425;
        i -= 1;
        break;
        localObject2 = null;
        break label75;
        i -= 1;
        break label203;
        localObject2 = null;
        break label234;
      }
      i -= 1;
      break label322;
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MobileQQ.2
 * JD-Core Version:    0.7.0.1
 */