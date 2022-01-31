import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

class dv
  extends ClickableSpan
{
  dv(dt paramdt) {}
  
  public void onClick(View paramView)
  {
    arni.a(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), alpo.a(2131694652), alpo.a(2131694652));
    azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#00a5e0"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dv
 * JD-Core Version:    0.7.0.1
 */