import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment;

public class rbz
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  
  public rbz(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int k = paramEditable.length();
    int i;
    int j;
    label24:
    Drawable[] arrayOfDrawable;
    if (this.jdField_a_of_type_Int > 0)
    {
      i = 1;
      if (k <= 0) {
        break label120;
      }
      j = 1;
      if ((j ^ i) != 0)
      {
        arrayOfDrawable = ReadInJoyVideoSearchTagFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment).getCompoundDrawables();
        if (k <= 0) {
          break label125;
        }
        arrayOfDrawable[2] = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment.getResources().getDrawable(2130839544);
      }
    }
    for (;;)
    {
      ReadInJoyVideoSearchTagFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      this.jdField_a_of_type_Int = k;
      if (paramEditable.length() <= 0) {
        break label133;
      }
      pfa.a().g(paramEditable.toString());
      return;
      i = 0;
      break;
      label120:
      j = 0;
      break label24;
      label125:
      arrayOfDrawable[2] = null;
    }
    label133:
    ReadInJoyVideoSearchTagFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment).clear();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbz
 * JD-Core Version:    0.7.0.1
 */