package cooperation.weiyun;

import bkjr;
import bkjy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bkjr parambkjr) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bkjy.a(bkjr.a(this.this$0), BaseActivity.sTopActivity, bkjr.a(this.this$0));
      return;
    }
    QQToast.a(bkjr.a(this.this$0), 2, 2131697816, 1).b(bkjr.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */