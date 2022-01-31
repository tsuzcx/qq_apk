import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment;

public class pua
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  
  public pua(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
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
        break label156;
      }
      j = 1;
      if ((j ^ i) != 0)
      {
        arrayOfDrawable = ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyUgcSearchTopicFragment).getCompoundDrawables();
        if (k <= 0) {
          break label161;
        }
        Drawable localDrawable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyUgcSearchTopicFragment.getResources().getDrawable(2130839242);
        localDrawable.setBounds(0, 0, bajq.b(16.0F), bajq.b(16.0F));
        arrayOfDrawable[2] = localDrawable;
      }
    }
    for (;;)
    {
      ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyUgcSearchTopicFragment).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      this.jdField_a_of_type_Int = k;
      ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyUgcSearchTopicFragment, paramEditable.toString());
      if (paramEditable.length() <= 0) {
        break label169;
      }
      ogy.a().h(ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyUgcSearchTopicFragment));
      return;
      i = 0;
      break;
      label156:
      j = 0;
      break label24;
      label161:
      arrayOfDrawable[2] = null;
    }
    label169:
    ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyUgcSearchTopicFragment).setVisibility(4);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pua
 * JD-Core Version:    0.7.0.1
 */