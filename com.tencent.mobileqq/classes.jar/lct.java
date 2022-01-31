import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.model.QueryCallback;

public final class lct
  implements QueryCallback
{
  public lct(EditText paramEditText) {}
  
  public void a(char[] paramArrayOfChar)
  {
    int i = this.a.getSelectionStart();
    int j = this.a.getSelectionEnd();
    this.a.getEditableText().replace(i, j, String.valueOf(paramArrayOfChar));
    this.a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lct
 * JD-Core Version:    0.7.0.1
 */