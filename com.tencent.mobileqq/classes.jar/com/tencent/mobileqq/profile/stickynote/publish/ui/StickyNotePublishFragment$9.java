package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.profile.stickynote.publish.StickyNotePublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class StickyNotePublishFragment$9
  implements TextWatcher
{
  private CharSequence b;
  private int c;
  private int d;
  
  StickyNotePublishFragment$9(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    CharSequence localCharSequence = this.b;
    if ((localCharSequence != null) && (com.tencent.mobileqq.text.TextUtils.getQQTextCharCount(String.valueOf(localCharSequence), 3) > 300))
    {
      QQToast.makeText(this.a.getBaseActivity(), 1, 2131887156, 0).show();
      paramEditable.delete(this.c, this.d);
    }
    paramEditable = StickyNotePublishUtils.a(StickyNotePublishFragment.a(this.a));
    if ((!android.text.TextUtils.isEmpty(paramEditable)) && (!android.text.TextUtils.isEmpty(paramEditable.trim()))) {
      this.a.d(true);
    } else {
      this.a.d(false);
    }
    if (StickyNotePublishFragment.a(this.a) != null) {
      StickyNotePublishFragment.a(this.a).post(new StickyNotePublishFragment.9.1(this));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramCharSequence;
    this.c = paramInt1;
    this.d = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.9
 * JD-Core Version:    0.7.0.1
 */