import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

class ea
  extends ClickableSpan
{
  ea(dy paramdy) {}
  
  public void onClick(View paramView)
  {
    auea.a(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), anvx.a(2131694211), anvx.a(2131694211));
    bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#00a5e0"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ea
 * JD-Core Version:    0.7.0.1
 */