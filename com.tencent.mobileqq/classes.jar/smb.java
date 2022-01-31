import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.TouchableSpan;

class smb
  extends EditInfoActivity.TouchableSpan
{
  smb(sly paramsly, int paramInt1, int paramInt2, String paramString)
  {
    super(paramsly.a, paramInt1, paramInt2);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Sly.a.a != null) {
      this.jdField_a_of_type_Sly.a.a.setText(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smb
 * JD-Core Version:    0.7.0.1
 */