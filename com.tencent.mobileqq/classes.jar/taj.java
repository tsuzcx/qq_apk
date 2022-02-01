import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import com.tencent.qphone.base.util.QLog;

public class taj
  implements TextWatcher
{
  private tai a;
  
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
        this.a.a();
        this.a = null;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = paramInt1 + paramInt3;
    if (paramInt3 >= paramInt2) {}
    label166:
    for (;;)
    {
      return;
      if ((paramInt2 > 0) && (paramInt2 == paramCharSequence.length()) && (paramInt3 == 0)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (!(paramCharSequence instanceof Spanned)) {
          break label166;
        }
        Spanned localSpanned = (Spanned)paramCharSequence;
        paramCharSequence = (tai[])localSpanned.getSpans(0, paramCharSequence.length(), tai.class);
        if ((paramCharSequence == null) || (paramCharSequence.length <= 0)) {
          break;
        }
        paramInt3 = paramCharSequence.length;
        paramInt2 = i;
        label86:
        if (paramInt2 < paramInt3)
        {
          if ((paramInt1 == 0) || (paramInt3 <= 1)) {
            break label117;
          }
          paramCharSequence[paramInt2].a();
        }
        label117:
        int k;
        do
        {
          paramInt2 += 1;
          break label86;
          break;
          i = localSpanned.getSpanStart(paramCharSequence[paramInt2]);
          k = localSpanned.getSpanEnd(paramCharSequence[paramInt2]);
        } while ((i > j) || (j >= k));
        this.a = paramCharSequence[paramInt2];
        return;
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("DeleteAsAWholeWatcher", 2, "onTextChanged: s: " + paramCharSequence + " start: " + paramInt1 + " before: " + paramInt2 + " count: " + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     taj
 * JD-Core Version:    0.7.0.1
 */