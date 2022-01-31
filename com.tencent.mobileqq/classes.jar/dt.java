import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

class dt
  extends ClickableSpan
{
  dt(dr paramdr) {}
  
  public void onClick(View paramView)
  {
    apck.a(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ajjy.a(2131628834), ajjy.a(2131628834));
    awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#00a5e0"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dt
 * JD-Core Version:    0.7.0.1
 */