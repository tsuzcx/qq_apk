package com.tencent.open.widget;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

public class CursorEditText
  extends EditText
{
  protected Class<?> a;
  
  public CursorEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    Editable localEditable = super.getEditableText();
    int i = localEditable.length();
    Object localObject1 = this.a;
    int k = 0;
    int j = 0;
    localObject1 = localEditable.getSpans(0, i, (Class)localObject1);
    int m = localObject1.length;
    i = 0;
    Object localObject2;
    while (i < m)
    {
      localObject2 = localObject1[i];
      int n = localEditable.getSpanStart(localObject2);
      if ((paramInt1 < localEditable.getSpanEnd(localObject2)) && (paramInt1 > n))
      {
        i = localObject1.length;
        paramInt1 = j;
        while (paramInt1 < i)
        {
          localObject2 = localObject1[paramInt1];
          j = localEditable.getSpanStart(localObject2);
          k = localEditable.getSpanEnd(localObject2);
          if ((paramInt2 < k) && (paramInt2 > j))
          {
            super.setSelection(k);
            return;
          }
          paramInt1 += 1;
        }
        super.setSelection(paramInt2);
        return;
      }
      i += 1;
    }
    j = localObject1.length;
    i = k;
    while (i < j)
    {
      localObject2 = localObject1[i];
      k = localEditable.getSpanStart(localObject2);
      if ((paramInt2 < localEditable.getSpanEnd(localObject2)) && (paramInt2 > k))
      {
        super.setSelection(paramInt1);
        return;
      }
      i += 1;
    }
    super.setSelection(paramInt1, paramInt2);
  }
  
  public void setSpannedClassToSkip(Class<?> paramClass)
  {
    this.a = paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.widget.CursorEditText
 * JD-Core Version:    0.7.0.1
 */