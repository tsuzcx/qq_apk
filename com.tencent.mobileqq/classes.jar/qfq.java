import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class qfq
  implements View.OnClickListener
{
  public qfq(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.g(this.a)) {
      QQToast.a(this.a, "当前网络连接不可用，请确认后再使用", 2000).a();
    }
    DeviceTipActivity.a(this.a, 2);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qfq
 * JD-Core Version:    0.7.0.1
 */