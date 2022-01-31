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

class mqf
  extends ClickableSpan
{
  mqf(mqa parammqa, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    QLog.w(this.jdField_a_of_type_Mqa.i, 1, "closeUI showNoNameDialog, realName[" + this.jdField_a_of_type_Boolean + "]");
    this.jdField_a_of_type_Mqa.a(this.jdField_a_of_type_JavaLangString);
    paramView = this.jdField_a_of_type_Mqa.a();
    if (paramView == null) {
      return;
    }
    paramView.finish();
    if (this.jdField_a_of_type_Boolean)
    {
      mpj.a(this.jdField_a_of_type_Mqa.a, this.b);
      return;
    }
    paramView = actn.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    paramView.putExtra("uin", this.jdField_a_of_type_Mqa.a.a().a().d);
    paramView.putExtra("uintype", 0);
    paramView.putExtra("uinname", this.jdField_a_of_type_Mqa.a.a().a().e);
    paramView.putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mqf
 * JD-Core Version:    0.7.0.1
 */