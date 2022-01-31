import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;

public class oic
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View b;
  
  public View a(ohs paramohs, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramohs.a().inflate(2131559847, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378383));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131379181);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b = localView.findViewById(2131379167);
      this.b.setVisibility(0);
    }
    localView.setTag(this);
    return localView;
  }
  
  public void a(ohs paramohs, int paramInt)
  {
    if (paramohs == null) {
      return;
    }
    oif localoif = (oif)paramohs.getItem(paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = ajya.a(2131712719);
    if (localoif.a != null) {}
    for (paramohs = String.valueOf(paramohs.a().a(localoif.a.commentId));; paramohs = "")
    {
      localSpannableStringBuilder.append(str + " ");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 0, str.length(), 34);
      localSpannableStringBuilder.append(paramohs);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#737373")), str.length(), localSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oic
 * JD-Core Version:    0.7.0.1
 */