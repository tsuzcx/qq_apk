import android.app.Dialog;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.utils.DialogUtil;

class slt
  implements Runnable
{
  slt(sls paramsls, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    slu localslu = new slu(this);
    this.jdField_a_of_type_Sls.a.a = DialogUtil.a(this.jdField_a_of_type_Sls.a.a(), 230, this.b, this.c, "退出登录", "立即验证", localslu, localslu);
    this.jdField_a_of_type_Sls.a.a.setCancelable(false);
    this.jdField_a_of_type_Sls.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slt
 * JD-Core Version:    0.7.0.1
 */