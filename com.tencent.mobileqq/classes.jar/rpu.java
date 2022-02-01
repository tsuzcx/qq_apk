import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

final class rpu
  extends ClickableSpan
{
  rpu(String paramString, Context paramContext, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "handleKingCardHintTextView span is clicked, guideUrl=" + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("big_brother_source_key", ozs.f(0));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(18, 183, 245));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpu
 * JD-Core Version:    0.7.0.1
 */