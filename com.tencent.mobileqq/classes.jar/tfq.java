import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import com.tencent.qphone.base.util.QLog;

public class tfq
  implements TextWatcher
{
  private tfp a;
  
  public void afterTextChanged(Editable paramEditable)
  {
    QLog.d("DeleteAsAWholeWatcher", 2, "afterTextChanged: s: " + paramEditable);
    if (this.a != null)
    {
      int i = paramEditable.getSpanStart(this.a);
      int j = paramEditable.getSpanEnd(this.a);
      if ((i >= 0) && (j <= paramEditable.length()))
      {
        paramEditable.delete(i, j);
        this.a = null;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = paramInt1 + paramInt3;
    if (paramInt3 >= paramInt2) {
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if ((paramCharSequence instanceof Spanned))
      {
        Spanned localSpanned = (Spanned)paramCharSequence;
        paramCharSequence = (tfp[])localSpanned.getSpans(0, paramCharSequence.length(), tfp.class);
        if ((paramCharSequence == null) || (paramCharSequence.length <= 0)) {
          break;
        }
        paramInt2 = paramCharSequence.length;
        paramInt1 = i;
        while (paramInt1 < paramInt2)
        {
          paramInt3 = localSpanned.getSpanStart(paramCharSequence[paramInt1]);
          i = localSpanned.getSpanEnd(paramCharSequence[paramInt1]);
          if ((paramInt3 <= j) && (j < i))
          {
            this.a = paramCharSequence[paramInt1];
            return;
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("DeleteAsAWholeWatcher", 2, "onTextChanged: s: " + paramCharSequence + " start: " + paramInt1 + " before: " + paramInt2 + " count: " + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tfq
 * JD-Core Version:    0.7.0.1
 */