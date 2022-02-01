package com.tencent.mobileqq.kandian.base.view.widget.text;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

public class DeleteAsAWholeWatcher
  implements TextWatcher
{
  private DeleteAsAWholeSpan a = null;
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (a(paramInt1, paramInt2, paramInt3)) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2;
    if (a(paramInt2, paramInt3, paramInt4)) {
      i = paramInt4;
    }
    if (i < paramInt1) {
      return paramInt1;
    }
    return i;
  }
  
  public static void a(EditText paramEditText, int paramInt1, int paramInt2)
  {
    Editable localEditable = paramEditText.getEditableText();
    if (localEditable == null) {
      return;
    }
    DeleteAsAWholeSpan[] arrayOfDeleteAsAWholeSpan = (DeleteAsAWholeSpan[])localEditable.getSpans(paramInt1, paramInt2, DeleteAsAWholeSpan.class);
    if (arrayOfDeleteAsAWholeSpan != null)
    {
      if (arrayOfDeleteAsAWholeSpan.length <= 0) {
        return;
      }
      a(paramEditText, paramInt1, paramInt2, localEditable, arrayOfDeleteAsAWholeSpan);
    }
  }
  
  private static void a(EditText paramEditText, int paramInt1, int paramInt2, Spanned paramSpanned, DeleteAsAWholeSpan[] paramArrayOfDeleteAsAWholeSpan)
  {
    int j = paramArrayOfDeleteAsAWholeSpan.length;
    int i = 0;
    while (i < j)
    {
      DeleteAsAWholeSpan localDeleteAsAWholeSpan = paramArrayOfDeleteAsAWholeSpan[i];
      int k = paramSpanned.getSpanStart(localDeleteAsAWholeSpan);
      int m = paramSpanned.getSpanEnd(localDeleteAsAWholeSpan);
      if (k >= 0)
      {
        i = a(paramInt1, k, m);
        j = a(i, paramInt2, k, m);
        if ((paramInt1 != i) || (paramInt2 != j)) {
          paramEditText.setSelection(i, j);
        }
        return;
      }
      i += 1;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 > paramInt2) && (paramInt1 < paramInt3);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("afterTextChanged: s: ");
    ((StringBuilder)localObject).append(paramEditable);
    QLog.d("DeleteAsAWholeWatcher", 2, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null)
    {
      int i = paramEditable.getSpanStart(localObject);
      int j = paramEditable.getSpanEnd(this.a);
      if ((i >= 0) && (j <= paramEditable.length()))
      {
        paramEditable.delete(i, j);
        this.a.a();
        this.a = null;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1 + paramInt3;
    if (paramInt3 >= paramInt2) {
      return;
    }
    int i = 0;
    if ((paramInt2 > 0) && (paramInt2 == paramCharSequence.length()) && (paramInt3 == 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramCharSequence instanceof Spanned))
    {
      Spanned localSpanned = (Spanned)paramCharSequence;
      paramCharSequence = (DeleteAsAWholeSpan[])localSpanned.getSpans(0, paramCharSequence.length(), DeleteAsAWholeSpan.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        paramInt3 = paramCharSequence.length;
        paramInt2 = i;
        while (paramInt2 < paramInt3)
        {
          if ((paramInt1 != 0) && (paramInt3 > 1))
          {
            paramCharSequence[paramInt2].a();
          }
          else
          {
            i = localSpanned.getSpanStart(paramCharSequence[paramInt2]);
            int k = localSpanned.getSpanEnd(paramCharSequence[paramInt2]);
            if ((i <= j) && (j < k))
            {
              this.a = paramCharSequence[paramInt2];
              return;
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTextChanged: s: ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(" start: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" before: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" count: ");
    localStringBuilder.append(paramInt3);
    QLog.d("DeleteAsAWholeWatcher", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeWatcher
 * JD-Core Version:    0.7.0.1
 */