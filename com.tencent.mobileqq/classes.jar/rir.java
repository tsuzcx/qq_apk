import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import java.io.UnsupportedEncodingException;

public class rir
  implements TextWatcher
{
  public rir(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (AddFriendVerifyActivity.a(this.a) != 4)
    {
      int i = paramEditable.length();
      if (i > 30)
      {
        paramEditable = paramEditable.toString();
        if (i > 30)
        {
          i = paramEditable.length();
          if ((i >= 2) && (Character.isHighSurrogate(paramEditable.charAt(i - 2)))) {}
          for (paramEditable = paramEditable.substring(0, i - 2);; paramEditable = paramEditable.substring(0, i - 1))
          {
            i = paramEditable.length();
            break;
          }
        }
        this.a.a.setText(paramEditable);
        this.a.a.setSelection(paramEditable.length());
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (AddFriendVerifyActivity.a(this.a) != 4) {}
    for (;;)
    {
      return;
      try
      {
        paramInt3 = paramCharSequence.toString().getBytes("utf-8").length;
        paramInt1 = 90 - paramInt3;
        paramCharSequence = paramCharSequence.toString();
        paramInt2 = paramInt1;
        if (paramInt3 > 90)
        {
          paramInt2 = paramInt3;
          if (paramInt2 > 90)
          {
            paramInt1 = paramCharSequence.length();
            if ((paramInt1 >= 2) && (Character.isHighSurrogate(paramCharSequence.charAt(paramInt1 - 2)))) {}
            for (paramCharSequence = paramCharSequence.substring(0, paramInt1 - 2);; paramCharSequence = paramCharSequence.substring(0, paramInt1 - 1))
            {
              paramInt2 = paramCharSequence.getBytes("utf-8").length;
              paramInt1 = 90 - paramInt2;
              break;
            }
          }
          AddFriendVerifyActivity.a(this.a).setText(paramCharSequence);
          AddFriendVerifyActivity.a(this.a).setSelection(paramCharSequence.length());
          paramInt2 = paramInt1;
        }
        if (AddFriendVerifyActivity.c(this.a).getVisibility() == 0)
        {
          paramCharSequence = paramInt2 + "";
          AddFriendVerifyActivity.c(this.a).setText(paramCharSequence);
          return;
        }
      }
      catch (UnsupportedEncodingException paramCharSequence)
      {
        paramCharSequence.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rir
 * JD-Core Version:    0.7.0.1
 */