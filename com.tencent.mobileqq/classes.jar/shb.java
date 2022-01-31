import android.app.Dialog;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.utils.DialogUtil;

class shb
  implements Runnable
{
  shb(sha paramsha, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    shc localshc = new shc(this);
    this.jdField_a_of_type_Sha.a.a = DialogUtil.a(this.jdField_a_of_type_Sha.a.a(), 230, this.b, this.c, "退出登录", "立即验证", localshc, localshc);
    this.jdField_a_of_type_Sha.a.a.setCancelable(false);
    this.jdField_a_of_type_Sha.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shb
 * JD-Core Version:    0.7.0.1
 */