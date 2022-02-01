package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.profile.stickynote.publish.StickyNotePublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class StickyNotePublishFragment$9
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int b;
  
  StickyNotePublishFragment$9(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (com.tencent.mobileqq.text.TextUtils.getQQTextCharCount(String.valueOf(this.jdField_a_of_type_JavaLangCharSequence), 3) > 300))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment.getActivity(), 1, 2131690324, 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.b);
    }
    paramEditable = StickyNotePublishUtils.a(StickyNotePublishFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment));
    if ((android.text.TextUtils.isEmpty(paramEditable)) || (android.text.TextUtils.isEmpty(paramEditable.trim()))) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment.d(false);
    }
    for (;;)
    {
      if (StickyNotePublishFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment) != null) {
        StickyNotePublishFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment).post(new StickyNotePublishFragment.9.1(this));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishUiStickyNotePublishFragment.d(true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.9
 * JD-Core Version:    0.7.0.1
 */