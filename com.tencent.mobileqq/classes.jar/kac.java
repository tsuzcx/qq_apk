import android.text.TextUtils;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class kac
  implements Runnable
{
  public kac(SysCallTransparentActivity paramSysCallTransparentActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Int == 1) {
      DialogUtil.a(this.a, this.a.jdField_a_of_type_JavaLangString, this.a.b, 2131428675, 2131428676, new kad(this), null).show();
    }
    while ((this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 3)) {
      return;
    }
    int i;
    SysCallTransparentActivity localSysCallTransparentActivity;
    String str2;
    String str3;
    String str4;
    if (this.a.jdField_a_of_type_Int == 2)
    {
      i = 1;
      localSysCallTransparentActivity = this.a;
      str2 = this.a.jdField_a_of_type_JavaLangString;
      str3 = this.a.b;
      str4 = this.a.getString(2131428675);
      if (!TextUtils.isEmpty(this.a.c)) {
        break label181;
      }
    }
    label181:
    for (String str1 = this.a.getString(2131429561);; str1 = this.a.c)
    {
      DialogUtil.a(localSysCallTransparentActivity, 230, str2, str3, str4, str1, new kae(this, i), new kaf(this)).show();
      return;
      i = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kac
 * JD-Core Version:    0.7.0.1
 */