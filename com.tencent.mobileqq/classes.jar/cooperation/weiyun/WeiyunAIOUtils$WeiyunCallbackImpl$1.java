package cooperation.weiyun;

import blev;
import blfa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(blev paramblev) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      blfa.a(blev.a(this.this$0), BaseActivity.sTopActivity, blev.a(this.this$0));
      return;
    }
    QQToast.a(blev.a(this.this$0), 2, 2131696848, 1).b(blev.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */