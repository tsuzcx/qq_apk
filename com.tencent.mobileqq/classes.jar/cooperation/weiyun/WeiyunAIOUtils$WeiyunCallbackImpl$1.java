package cooperation.weiyun;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;

class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  WeiyunAIOUtils$WeiyunCallbackImpl$1(WeiyunAIOUtils.WeiyunCallbackImpl paramWeiyunCallbackImpl) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(WeiyunAIOUtils.WeiyunCallbackImpl.a(this.this$0), BaseActivity.sTopActivity, WeiyunAIOUtils.WeiyunCallbackImpl.b(this.this$0));
      return;
    }
    QQToast.makeText(WeiyunAIOUtils.WeiyunCallbackImpl.c(this.this$0), 2, 2131895162, 1).show(WeiyunAIOUtils.WeiyunCallbackImpl.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */