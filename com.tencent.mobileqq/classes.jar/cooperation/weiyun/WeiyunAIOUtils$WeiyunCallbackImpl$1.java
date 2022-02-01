package cooperation.weiyun;

import bnzo;
import bnzt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(bnzo parambnzo) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      bnzt.a(bnzo.a(this.this$0), BaseActivity.sTopActivity, bnzo.a(this.this$0));
      return;
    }
    QQToast.a(bnzo.a(this.this$0), 2, 2131696707, 1).b(bnzo.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */