import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

class mqy
  extends ClickableSpan
{
  mqy(mqt parammqt, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    QLog.w(this.jdField_a_of_type_Mqt.i, 1, "closeUI showNoNameDialog, realName[" + this.jdField_a_of_type_Boolean + "]");
    this.jdField_a_of_type_Mqt.a(this.jdField_a_of_type_JavaLangString);
    paramView = this.jdField_a_of_type_Mqt.a();
    if (paramView == null) {
      return;
    }
    paramView.finish();
    if (this.jdField_a_of_type_Boolean)
    {
      mqc.a(this.jdField_a_of_type_Mqt.a, this.b);
      return;
    }
    paramView = agej.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    paramView.putExtra("uin", this.jdField_a_of_type_Mqt.a.a().a().d);
    paramView.putExtra("uintype", 0);
    paramView.putExtra("uinname", this.jdField_a_of_type_Mqt.a.a().a().e);
    paramView.putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqy
 * JD-Core Version:    0.7.0.1
 */