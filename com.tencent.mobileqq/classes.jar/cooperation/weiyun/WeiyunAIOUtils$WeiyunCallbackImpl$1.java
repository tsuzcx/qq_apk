package cooperation.weiyun;

import bmrm;
import bmrr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bmrm parambmrm) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bmrr.a(bmrm.a(this.this$0), BaseActivity.sTopActivity, bmrm.a(this.this$0));
      return;
    }
    QQToast.a(bmrm.a(this.this$0), 2, 2131697116, 1).b(bmrm.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */