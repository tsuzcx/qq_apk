import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class slt
  implements TextWatcher
{
  public slt(EditInfoActivity paramEditInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence == null) || (paramCharSequence.toString().trim().length() == 0))
    {
      this.a.jdField_c_of_type_JavaLangString = ("" + this.a.jdField_c_of_type_Int);
      this.a.a.post(new slu(this));
      return;
    }
    for (;;)
    {
      try
      {
        if (this.a.f != 0) {
          break label239;
        }
        paramInt1 = paramCharSequence.toString().trim().getBytes("utf-8").length;
        this.a.jdField_c_of_type_JavaLangString = ("" + (this.a.jdField_c_of_type_Int - paramInt1));
        if (this.a.jdField_c_of_type_JavaLangString.length() > 4) {
          this.a.jdField_c_of_type_JavaLangString = (this.a.jdField_c_of_type_JavaLangString.substring(0, 2) + "…");
        }
        this.a.a.post(new slv(this, paramInt1));
        return;
      }
      catch (UnsupportedEncodingException paramCharSequence) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("IphoneTitleBarActivity", 2, "UnsupportedEncodingException" + paramCharSequence.getMessage());
      return;
      label239:
      paramInt1 = paramCharSequence.toString().trim().length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slt
 * JD-Core Version:    0.7.0.1
 */