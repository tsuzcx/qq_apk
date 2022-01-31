import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.AuthDevForRoamMsgActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class rnv
  implements Handler.Callback
{
  public rnv(AuthDevForRoamMsgActivity paramAuthDevForRoamMsgActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.a.findViewById(2131372248).setEnabled(true);
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      QQToast.a(this.a.getApplicationContext(), 2, "开启保护成功", 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.a.setResult(1);
      this.a.finish();
      return false;
      QQToast.a(this.a.getApplicationContext(), 2, "开启保护失败", 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnv
 * JD-Core Version:    0.7.0.1
 */