import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import mqq.os.MqqHandler;

public class okl
  implements TextWatcher
{
  public okl(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i;
    label51:
    label86:
    ahbf localahbf;
    if ((paramEditable instanceof ohr))
    {
      i = ((ohr)paramEditable).a();
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (this.a.c - i >= -99) {
          break label236;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("-99");
      }
      if (i - this.a.c <= 0) {
        break label261;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      this.a.d = true;
      ReadInJoyCommentComponentFragment.a(this.a);
      localahbf = ReadInJoyCommentComponentFragment.a(this.a);
      if (localahbf != null)
      {
        i = paramEditable.toString().trim().length();
        if (i > 0) {
          break label294;
        }
        this.a.f.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((i <= 0) || (paramEditable.length() > 24) || (!localahbf.a(paramEditable))) {
        break label308;
      }
      if (ReadInJoyCommentComponentFragment.a(this.a))
      {
        localahbf.a(ReadInJoyCommentComponentFragment.a(this.a).app, paramEditable, null, 7220, false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
      }
      this.a.f.setImageResource(2130842446);
      return;
      i = paramEditable.length();
      break;
      label236:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.c - i));
      break label51;
      label261:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165570));
      this.a.d = false;
      break label86;
      label294:
      this.a.f.setVisibility(0);
    }
    label308:
    localahbf.c();
    ReadInJoyCommentComponentFragment.a(this.a, false);
    this.a.f.setSelected(false);
    this.a.f.setImageResource(2130842806);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (ReadInJoyCommentComponentFragment.b(this.a)) {
      ReadInJoyCommentComponentFragment.c(this.a, false);
    }
    while ((!ReadInJoyCommentComponentFragment.c(this.a)) || (paramInt3 != 1) || (paramInt2 != 0) || (!paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@"))) {
      return;
    }
    this.a.b("2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okl
 * JD-Core Version:    0.7.0.1
 */