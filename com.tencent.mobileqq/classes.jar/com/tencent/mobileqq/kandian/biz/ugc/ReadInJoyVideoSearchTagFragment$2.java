package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;

class ReadInJoyVideoSearchTagFragment$2
  implements TextWatcher
{
  private int jdField_a_of_type_Int = 0;
  
  ReadInJoyVideoSearchTagFragment$2(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int k = paramEditable.length();
    int i;
    if (this.jdField_a_of_type_Int > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (k > 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i ^ j) != 0)
    {
      Drawable[] arrayOfDrawable = ReadInJoyVideoSearchTagFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoSearchTagFragment).getCompoundDrawables();
      if (k > 0) {
        arrayOfDrawable[2] = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoSearchTagFragment.getResources().getDrawable(2130839537);
      } else {
        arrayOfDrawable[2] = null;
      }
      ReadInJoyVideoSearchTagFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoSearchTagFragment).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
    this.jdField_a_of_type_Int = k;
    if (paramEditable.length() > 0)
    {
      ReadInJoyLogicEngine.a().f(paramEditable.toString());
      return;
    }
    ReadInJoyVideoSearchTagFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoSearchTagFragment).clear();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoSearchTagFragment.2
 * JD-Core Version:    0.7.0.1
 */