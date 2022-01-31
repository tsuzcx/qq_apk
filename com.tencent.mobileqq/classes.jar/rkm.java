import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class rkm
  extends ClickableSpan
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  
  public rkm(AboutActivity paramAboutActivity, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.startActivity(paramView.putExtra("url", this.jdField_a_of_type_JavaLangString));
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16754769);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rkm
 * JD-Core Version:    0.7.0.1
 */