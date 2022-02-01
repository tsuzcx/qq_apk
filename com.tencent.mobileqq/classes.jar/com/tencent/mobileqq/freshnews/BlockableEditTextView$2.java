package com.tencent.mobileqq.freshnews;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;

class BlockableEditTextView$2
  implements TextWatcher
{
  public int a = 0;
  public CharSequence b = "";
  int c = -1;
  int d = -1;
  public boolean e = false;
  
  BlockableEditTextView$2(BlockableEditTextView paramBlockableEditTextView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!this.e)
    {
      int i = this.a;
      if (i == 0) {
        return;
      }
      if (i < 0)
      {
        if (BlockableEditTextView.a(this.f) == 2)
        {
          this.e = true;
          this.f.setText(this.b);
          this.e = false;
          return;
        }
        this.e = true;
        paramEditable = this.f;
        CharSequence localCharSequence = this.b;
        paramEditable.setText(TextUtils.concat(new CharSequence[] { localCharSequence.subSequence(this.d, localCharSequence.length()), this.b.subSequence(0, this.c) }));
        this.e = false;
        this.f.setSelection(this.c);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.e)
    {
      if (BlockableEditTextView.a(this.f) == 0) {
        return;
      }
      this.a = 0;
      if (paramInt3 != paramInt2)
      {
        Editable localEditable = this.f.getEditableText();
        if (localEditable == null) {
          return;
        }
        BlockableEditTextView.BlockAble[] arrayOfBlockAble = (BlockableEditTextView.BlockAble[])localEditable.getSpans(paramInt1, paramInt1, BlockableEditTextView.BlockAble.class);
        if ((arrayOfBlockAble != null) && (arrayOfBlockAble.length > 0))
        {
          this.c = localEditable.getSpanStart(arrayOfBlockAble[0]);
          this.d = localEditable.getSpanEnd(arrayOfBlockAble[0]);
          int i = this.d;
          if ((i >= 0) && (i >= this.c) && (paramInt2 > paramInt3) && (BlockableEditTextView.a(this.f) != 0) && (paramInt1 != this.c))
          {
            if (paramInt1 == this.d) {
              return;
            }
            this.b = new SpannableStringBuilder(paramCharSequence).subSequence(0, paramCharSequence.length());
            this.a = -1;
          }
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.BlockableEditTextView.2
 * JD-Core Version:    0.7.0.1
 */