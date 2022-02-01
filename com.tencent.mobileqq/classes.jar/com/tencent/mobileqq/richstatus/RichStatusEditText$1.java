package com.tencent.mobileqq.richstatus;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import com.tencent.mobileqq.text.ClickableImageSpan;

class RichStatusEditText$1
  implements TextWatcher
{
  private boolean b = false;
  private boolean c = false;
  private int d;
  private int e;
  private String f;
  
  RichStatusEditText$1(RichStatusEditText paramRichStatusEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.a.a) && (this.c))
    {
      paramEditable = this.a;
      paramEditable.a = false;
      this.c = false;
      paramEditable = paramEditable.getText();
      int i = this.d;
      paramEditable.replace(i, this.e + i, this.f);
      this.a.setSelection(this.d + this.f.length());
      this.a.a = true;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.a.a) {
      return;
    }
    if (paramInt3 > 0)
    {
      this.b = true;
      this.d = paramInt1;
      this.e = paramInt3;
      RichStatusEditText.b(this.a);
      this.a.setCursorVisible(true);
      return;
    }
    this.b = false;
    paramCharSequence = RichStatusEditText.a(this.a, paramInt1, false, false);
    if (paramCharSequence != null)
    {
      paramInt3 = RichStatusEditText.c(this.a).getSpanStart(paramCharSequence);
      if (paramInt3 != paramInt1)
      {
        this.c = true;
        this.d = paramInt3;
        this.e = (paramInt1 - paramInt3);
        this.f = "";
      }
    }
    RichStatusEditText.a(this.a, paramInt1, paramInt2);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.a.a) {
      return;
    }
    if (this.b)
    {
      Object localObject = this.a;
      paramInt2 = paramInt3 + paramInt1;
      localObject = RichStatusEditText.a((RichStatusEditText)localObject, paramInt2, true, false);
      if ((localObject != null) && (RichStatusEditText.a(this.a) != null) && (!RichStatusEditText.a(this.a).b((ClickableImageSpan)localObject)))
      {
        this.f = "";
        this.c = true;
        return;
      }
      this.f = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
      if (this.f.contains("\n"))
      {
        this.c = true;
        this.f = this.f.replace("\n", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatusEditText.1
 * JD-Core Version:    0.7.0.1
 */