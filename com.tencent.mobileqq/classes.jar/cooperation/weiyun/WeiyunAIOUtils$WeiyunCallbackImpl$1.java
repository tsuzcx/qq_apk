package cooperation.weiyun;

import bkfk;
import bkfr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bkfk parambkfk) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bkfr.a(bkfk.a(this.this$0), BaseActivity.sTopActivity, bkfk.a(this.this$0));
      return;
    }
    QQToast.a(bkfk.a(this.this$0), 2, 2131697814, 1).b(bkfk.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */