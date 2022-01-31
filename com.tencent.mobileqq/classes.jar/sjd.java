import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.TouchableSpan;

class sjd
  extends EditInfoActivity.TouchableSpan
{
  sjd(sja paramsja, int paramInt1, int paramInt2, String paramString)
  {
    super(paramsja.a, paramInt1, paramInt2);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Sja.a.a != null) {
      this.jdField_a_of_type_Sja.a.a.setText(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjd
 * JD-Core Version:    0.7.0.1
 */