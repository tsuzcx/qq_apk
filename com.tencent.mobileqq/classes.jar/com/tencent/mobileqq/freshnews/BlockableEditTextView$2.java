package com.tencent.mobileqq.freshnews;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;

class BlockableEditTextView$2
  implements TextWatcher
{
  public int a;
  public CharSequence a;
  public boolean a;
  int b = -1;
  int c = -1;
  
  BlockableEditTextView$2(BlockableEditTextView paramBlockableEditTextView)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 0) {
        return;
      }
      if (i < 0)
      {
        if (BlockableEditTextView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView) == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        paramEditable = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView;
        CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
        paramEditable.setText(TextUtils.concat(new CharSequence[] { localCharSequence.subSequence(this.c, localCharSequence.length()), this.jdField_a_of_type_JavaLangCharSequence.subSequence(0, this.b) }));
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setSelection(this.b);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (BlockableEditTextView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView) == 0) {
        return;
      }
      this.jdField_a_of_type_Int = 0;
      if (paramInt3 != paramInt2)
      {
        Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getEditableText();
        if (localEditable == null) {
          return;
        }
        BlockableEditTextView.BlockAble[] arrayOfBlockAble = (BlockableEditTextView.BlockAble[])localEditable.getSpans(paramInt1, paramInt1, BlockableEditTextView.BlockAble.class);
        if ((arrayOfBlockAble != null) && (arrayOfBlockAble.length > 0))
        {
          this.b = localEditable.getSpanStart(arrayOfBlockAble[0]);
          this.c = localEditable.getSpanEnd(arrayOfBlockAble[0]);
          int i = this.c;
          if ((i >= 0) && (i >= this.b) && (paramInt2 > paramInt3) && (BlockableEditTextView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView) != 0) && (paramInt1 != this.b))
          {
            if (paramInt1 == this.c) {
              return;
            }
            this.jdField_a_of_type_JavaLangCharSequence = new SpannableStringBuilder(paramCharSequence).subSequence(0, paramCharSequence.length());
            this.jdField_a_of_type_Int = -1;
          }
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.BlockableEditTextView.2
 * JD-Core Version:    0.7.0.1
 */