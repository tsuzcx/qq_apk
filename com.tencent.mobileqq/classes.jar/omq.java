import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

public class omq
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View b;
  
  public View a(omg paramomg, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramomg.a().inflate(2131559941, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378985));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131379881);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b = localView.findViewById(2131379865);
      this.b.setVisibility(0);
    }
    localView.setTag(this);
    return localView;
  }
  
  public void a(omg paramomg, int paramInt)
  {
    if (paramomg == null) {
      return;
    }
    omt localomt = (omt)paramomg.getItem(paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = alpo.a(2131713091);
    if (localomt.a != null) {}
    for (paramomg = String.valueOf(paramomg.a().a(localomt.a.commentId));; paramomg = "")
    {
      localSpannableStringBuilder.append(str + " ");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 0, str.length(), 34);
      localSpannableStringBuilder.append(paramomg);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#737373")), str.length(), localSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omq
 * JD-Core Version:    0.7.0.1
 */