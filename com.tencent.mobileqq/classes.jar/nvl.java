import android.text.Editable;
import android.widget.EditText;

public final class nvl
  implements askq<char[]>
{
  public nvl(EditText paramEditText) {}
  
  public void a(char[] paramArrayOfChar)
  {
    int i = this.a.getSelectionStart();
    int j = this.a.getSelectionEnd();
    this.a.getEditableText().replace(i, j, String.valueOf(paramArrayOfChar));
    this.a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvl
 * JD-Core Version:    0.7.0.1
 */