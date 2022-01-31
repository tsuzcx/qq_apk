package cooperation.weiyun;

import bcpw;
import bicx;
import bide;
import com.tencent.mobileqq.app.BaseActivity;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bicx parambicx) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bide.a(bicx.a(this.this$0), BaseActivity.sTopActivity, bicx.a(this.this$0));
      return;
    }
    bcpw.a(bicx.a(this.this$0), 2, 2131697638, 1).b(bicx.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */