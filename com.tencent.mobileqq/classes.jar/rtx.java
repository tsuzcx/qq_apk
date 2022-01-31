import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class rtx
  implements Runnable
{
  rtx(rtu paramrtu) {}
  
  public void run()
  {
    try
    {
      FragmentActivity localFragmentActivity = this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      Object localObject;
      String str;
      if (BaseChatPie.j(this.a.a) > 0)
      {
        localObject = "发送到 " + this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        if (BaseChatPie.j(this.a.a) <= 0) {
          break label186;
        }
        str = "Crash count: " + BaseChatPie.j(this.a.a) + "\n" + "CrashInfoSummary.txt";
        label109:
        if (BaseChatPie.j(this.a.a) <= 0) {
          break label191;
        }
      }
      label186:
      label191:
      for (int i = 2131433645;; i = 2131433030)
      {
        localObject = DialogUtil.b(localFragmentActivity, 230, (String)localObject, str, 2131433029, i, new rty(this), new rtz(this));
        ((QQCustomDialog)localObject).adjustTitle();
        if (this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
          return;
        }
        ((QQCustomDialog)localObject).show();
        return;
        localObject = "0 Crash";
        break;
        str = null;
        break label109;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtx
 * JD-Core Version:    0.7.0.1
 */