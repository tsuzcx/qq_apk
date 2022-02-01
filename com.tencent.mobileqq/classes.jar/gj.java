import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;

public class gj
{
  private bjmo<CharacterStyle> jdField_a_of_type_Bjmo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  
  public gj(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    if ((paramCharSequence instanceof Spanned))
    {
      Spanned localSpanned = (Spanned)paramCharSequence;
      paramCharSequence = (CharacterStyle[])localSpanned.getSpans(0, paramCharSequence.length(), CharacterStyle.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        this.jdField_a_of_type_Bjmo = new bjmo(paramCharSequence.length);
        while (i < paramCharSequence.length)
        {
          Object localObject = paramCharSequence[i];
          if (((localObject instanceof QQText.EmoticonSpan)) || ((localObject instanceof bank)))
          {
            int j = localSpanned.getSpanStart(localObject);
            int k = localSpanned.getSpanEnd(localObject);
            this.jdField_a_of_type_Bjmo.a(a(j, k), localObject);
          }
          i += 1;
        }
      }
    }
  }
  
  private static int a(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  private static long a(int paramInt1, int paramInt2)
  {
    return (paramInt1 << 32) + (0xFFFFFFFF & paramInt2);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.e("ETTextView", 1, paramString + ":" + paramInt1 + "," + paramInt2 + " > " + this.jdField_a_of_type_JavaLangCharSequence.length() + ":" + this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  private static int b(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {}
    do
    {
      return paramInt;
      if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaLangCharSequence.length()))
      {
        if (paramInt > 0) {
          a("convertToGraphIndex", paramInt, 0);
        }
        return -1;
      }
    } while (this.jdField_a_of_type_Bjmo == null);
    int k = this.jdField_a_of_type_Bjmo.a();
    int j = 0;
    int i = paramInt;
    while (j < k)
    {
      long l = this.jdField_a_of_type_Bjmo.a(j);
      int m = a(l);
      int n = b(l);
      if (m >= paramInt) {
        return i;
      }
      if (n <= paramInt)
      {
        j += 1;
        i -= n - m - 1;
      }
      else
      {
        return i - (paramInt - m);
      }
    }
    return i;
  }
  
  public int b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      return paramInt;
    }
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaLangCharSequence.length()))
    {
      if (paramInt > 0) {
        a("convertToTextIndex1", paramInt, 0);
      }
      return -1;
    }
    int j;
    int i;
    int n;
    if (this.jdField_a_of_type_Bjmo != null)
    {
      int m = this.jdField_a_of_type_Bjmo.a();
      j = 0;
      i = paramInt;
      k = i;
      if (j < m)
      {
        long l = this.jdField_a_of_type_Bjmo.a(j);
        k = a(l);
        n = b(l);
        if (k < i) {
          break label127;
        }
      }
    }
    for (int k = i;; k = paramInt)
    {
      if (k > this.jdField_a_of_type_JavaLangCharSequence.length())
      {
        a("convertToTextIndex2", paramInt, k);
        return -1;
        label127:
        j += 1;
        i = n - k - 1 + i;
        break;
      }
      return k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     gj
 * JD-Core Version:    0.7.0.1
 */