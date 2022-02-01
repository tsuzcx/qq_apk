import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

public class otl
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View b;
  
  public View a(otd paramotd, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramotd.a().inflate(2131560100, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380141));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131381074);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b = localView.findViewById(2131381060);
      this.b.setVisibility(0);
    }
    localView.setTag(this);
    return localView;
  }
  
  public void a(otd paramotd, int paramInt)
  {
    if (paramotd == null) {
      return;
    }
    otp localotp = (otp)paramotd.getItem(paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = anzj.a(2131711591);
    if (localotp.a != null) {}
    for (paramotd = String.valueOf(paramotd.a().a(localotp.a.commentId));; paramotd = "")
    {
      localSpannableStringBuilder.append(str + " ");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 0, str.length(), 34);
      localSpannableStringBuilder.append(paramotd);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#737373")), str.length(), localSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otl
 * JD-Core Version:    0.7.0.1
 */