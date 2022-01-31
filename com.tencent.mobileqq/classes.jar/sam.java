import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;

public class sam
  implements TextWatcher
{
  public sam(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(ReadInJoyNewSearchActivity.a(this.a).getText().toString()))
    {
      ReadInJoyNewSearchActivity.a(this.a).setVisibility(8);
      return;
    }
    ReadInJoyNewSearchActivity.a(this.a).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sam
 * JD-Core Version:    0.7.0.1
 */