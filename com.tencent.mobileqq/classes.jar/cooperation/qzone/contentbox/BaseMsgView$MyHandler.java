package cooperation.qzone.contentbox;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import java.lang.ref.WeakReference;

public class BaseMsgView$MyHandler
  extends Handler
{
  private WeakReference<BaseMsgView> msgViewWeakReference;
  
  public BaseMsgView$MyHandler(BaseMsgView paramBaseMsgView)
  {
    this.msgViewWeakReference = new WeakReference(paramBaseMsgView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    BaseMsgView localBaseMsgView = (BaseMsgView)this.msgViewWeakReference.get();
    if (localBaseMsgView == null) {}
    ViewPager localViewPager;
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        localBaseMsgView.doHandleMessage(paramMessage);
        return;
      }
      localViewPager = (ViewPager)((WeakReference)paramMessage.obj).get();
    } while (localViewPager == null);
    int i = paramMessage.arg1;
    localViewPager.setCurrentItem((localViewPager.getCurrentItem() + 1) % i, true);
    localBaseMsgView.startPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.BaseMsgView.MyHandler
 * JD-Core Version:    0.7.0.1
 */