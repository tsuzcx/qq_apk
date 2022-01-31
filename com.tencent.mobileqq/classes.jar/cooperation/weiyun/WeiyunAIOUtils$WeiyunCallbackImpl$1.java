package cooperation.weiyun;

import bbmy;
import bgtv;
import bguc;
import com.tencent.mobileqq.app.BaseActivity;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bgtv parambgtv) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bguc.a(bgtv.a(this.this$0), BaseActivity.sTopActivity, bgtv.a(this.this$0));
      return;
    }
    bbmy.a(bgtv.a(this.this$0), 2, 2131631924, 1).b(bgtv.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */