package com.tencent.mobileqq.profilecard.base.component;

import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class AbsProfileHeaderComponent$7
  implements Runnable
{
  AbsProfileHeaderComponent$7(AbsProfileHeaderComponent paramAbsProfileHeaderComponent) {}
  
  public void run()
  {
    try
    {
      Object localObject = (LocalRedTouchManager)AbsProfileHeaderComponent.access$2300(this.this$0).getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(100601);
      if ((((LocalRedTouchManager)localObject).a(localRedTouchItem, false)) && (localRedTouchItem.passThroughLevel > 0))
      {
        localObject = this.this$0.mUIHandler.obtainMessage();
        ((Message)localObject).what = 1;
        ((Message)localObject).arg1 = 2;
        this.this$0.mUIHandler.sendMessageDelayed((Message)localObject, 300L);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AbsProfileHeaderComponent", 1, "checkVoteRedTouch fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.7
 * JD-Core Version:    0.7.0.1
 */