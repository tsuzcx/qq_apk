package cooperation.weiyun;

import bmyg;
import bmyl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bmyg parambmyg) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bmyl.a(bmyg.a(this.this$0), BaseActivity.sTopActivity, bmyg.a(this.this$0));
      return;
    }
    QQToast.a(bmyg.a(this.this$0), 2, 2131696658, 1).b(bmyg.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */