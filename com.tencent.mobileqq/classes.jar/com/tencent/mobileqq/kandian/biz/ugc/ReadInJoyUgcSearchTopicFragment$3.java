package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.utils.ViewUtils;

class ReadInJoyUgcSearchTopicFragment$3
  implements TextWatcher
{
  private int jdField_a_of_type_Int = 0;
  
  ReadInJoyUgcSearchTopicFragment$3(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
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
      Drawable[] arrayOfDrawable = ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyUgcSearchTopicFragment).getCompoundDrawables();
      if (k > 0)
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyUgcSearchTopicFragment.getResources().getDrawable(2130839537);
        localDrawable.setBounds(0, 0, ViewUtils.b(16.0F), ViewUtils.b(16.0F));
        arrayOfDrawable[2] = localDrawable;
      }
      else
      {
        arrayOfDrawable[2] = null;
      }
      ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyUgcSearchTopicFragment).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
    this.jdField_a_of_type_Int = k;
    ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyUgcSearchTopicFragment, paramEditable.toString());
    if (paramEditable.length() > 0)
    {
      ReadInJoyLogicEngine.a().g(ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyUgcSearchTopicFragment));
      return;
    }
    ReadInJoyUgcSearchTopicFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyUgcSearchTopicFragment).setVisibility(4);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment.3
 * JD-Core Version:    0.7.0.1
 */