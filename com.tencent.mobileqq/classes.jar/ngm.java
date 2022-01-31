import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverSearchDialog;

public class ngm
  implements TextWatcher
{
  public ngm(QQStoryDiscoverSearchDialog paramQQStoryDiscoverSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载…");
      this.a.b.setVisibility(8);
      paramEditable = this.a.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130838592);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramEditable, null, null, null);
      ((Animatable)paramEditable).start();
      this.a.jdField_a_of_type_Int = 0;
      this.a.a(null);
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngm
 * JD-Core Version:    0.7.0.1
 */