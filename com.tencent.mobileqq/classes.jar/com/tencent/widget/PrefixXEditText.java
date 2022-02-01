package com.tencent.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;

public class PrefixXEditText
  extends XEditText
  implements TextWatcher
{
  protected String a = null;
  
  public PrefixXEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public PrefixXEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((!TextUtils.isEmpty(this.a)) && (!paramEditable.toString().startsWith(this.a))) {
      paramEditable.replace(0, paramEditable.length(), this.a);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if ((!TextUtils.isEmpty(this.a)) && (getText().length() >= this.a.length()))
    {
      int i;
      if (paramInt1 < this.a.length()) {
        i = this.a.length();
      } else {
        i = paramInt1;
      }
      int j;
      if (paramInt2 < i) {
        j = i;
      } else {
        j = paramInt2;
      }
      if ((i != paramInt1) || (j != paramInt2)) {
        setSelection(i, j);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setPrefix(String paramString, int paramInt)
  {
    this.a = paramString;
    if (!TextUtils.isEmpty(this.a))
    {
      setText(this.a);
      setSelection(this.a.length());
      getEditableText().setSpan(new ForegroundColorSpan(paramInt), 0, this.a.length(), 17);
      addTextChangedListener(this);
      return;
    }
    removeTextChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PrefixXEditText
 * JD-Core Version:    0.7.0.1
 */