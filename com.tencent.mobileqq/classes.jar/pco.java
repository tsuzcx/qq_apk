import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

public class pco
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View b;
  
  public View a(pcf parampcf, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = parampcf.a().inflate(2131560154, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380210));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131381151);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b = localView.findViewById(2131381136);
      this.b.setVisibility(0);
    }
    localView.setTag(this);
    return localView;
  }
  
  public void a(pcf parampcf, int paramInt)
  {
    if (parampcf == null) {
      return;
    }
    pdp localpdp = (pdp)parampcf.getItem(paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = anvx.a(2131712170);
    if (localpdp.a != null) {}
    for (parampcf = String.valueOf(parampcf.a().a(localpdp.a.commentId));; parampcf = "")
    {
      localSpannableStringBuilder.append(str + " ");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 0, str.length(), 34);
      localSpannableStringBuilder.append(parampcf);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#737373")), str.length(), localSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pco
 * JD-Core Version:    0.7.0.1
 */