import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuTextBuilder;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import mqq.os.MqqHandler;

public class lji
  implements TextWatcher
{
  public lji(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i;
    label51:
    label86:
    ZhituManager localZhituManager;
    if ((paramEditable instanceof BiuTextBuilder))
    {
      i = ((BiuTextBuilder)paramEditable).a();
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (this.a.jdField_c_of_type_Int - i >= -99) {
          break label236;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("-99");
      }
      if (i - this.a.jdField_c_of_type_Int <= 0) {
        break label261;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      this.a.jdField_c_of_type_Boolean = true;
      ReadInJoyCommentComponentFragment.a(this.a);
      localZhituManager = ReadInJoyCommentComponentFragment.a(this.a);
      if (localZhituManager != null)
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
      if ((i <= 0) || (paramEditable.length() > 24) || (!localZhituManager.a(paramEditable))) {
        break label308;
      }
      if (ReadInJoyCommentComponentFragment.a(this.a))
      {
        localZhituManager.a(ReadInJoyCommentComponentFragment.a(this.a).app, paramEditable, null, 7220, false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(85);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(85, 10000L);
      }
      this.a.f.setImageResource(2130840750);
      return;
      i = paramEditable.length();
      break;
      label236:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.jdField_c_of_type_Int - i));
      break label51;
      label261:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131493501));
      this.a.jdField_c_of_type_Boolean = false;
      break label86;
      label294:
      this.a.f.setVisibility(0);
    }
    label308:
    localZhituManager.c();
    ReadInJoyCommentComponentFragment.a(this.a, false);
    this.a.f.setSelected(false);
    this.a.f.setImageResource(2130840898);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lji
 * JD-Core Version:    0.7.0.1
 */