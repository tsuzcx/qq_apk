package cooperation.weiyun;

import bcql;
import bido;
import bidv;
import com.tencent.mobileqq.app.BaseActivity;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bido parambido) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bidv.a(bido.a(this.this$0), BaseActivity.sTopActivity, bido.a(this.this$0));
      return;
    }
    bcql.a(bido.a(this.this$0), 2, 2131697639, 1).b(bido.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */