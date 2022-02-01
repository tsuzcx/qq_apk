package cooperation.weiyun;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  WeiyunAIOUtils$WeiyunCallbackImpl$1(WeiyunAIOUtils.WeiyunCallbackImpl paramWeiyunCallbackImpl) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      WeiyunSaveTipsFactory.a(WeiyunAIOUtils.WeiyunCallbackImpl.a(this.this$0), BaseActivity.sTopActivity, WeiyunAIOUtils.WeiyunCallbackImpl.a(this.this$0));
      return;
    }
    QQToast.a(WeiyunAIOUtils.WeiyunCallbackImpl.a(this.this$0), 2, 2131697370, 1).b(WeiyunAIOUtils.WeiyunCallbackImpl.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */