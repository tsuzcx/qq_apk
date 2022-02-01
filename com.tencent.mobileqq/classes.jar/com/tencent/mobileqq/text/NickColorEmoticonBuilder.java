package com.tencent.mobileqq.text;

import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.qphone.base.util.QLog;

public class NickColorEmoticonBuilder
  extends SpannableStringBuilder
{
  public static Editable.Factory a = new NickColorEmoticonBuilder.1();
  private int b;
  
  public NickColorEmoticonBuilder(CharSequence paramCharSequence, int paramInt)
  {
    super(a(paramCharSequence, paramInt));
    this.b = paramInt;
  }
  
  private static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence instanceof ColorNickText)) {
      return ((ColorNickText)paramCharSequence).b();
    }
    return new ColorNickText(paramCharSequence, paramInt).b();
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    if (paramInt1 < 0) {
      j = 0;
    }
    int i = paramInt2;
    Object localObject2 = paramCharSequence;
    for (;;)
    {
      try
      {
        int k = length();
        paramInt1 = paramInt2;
        if (paramInt2 > k) {
          paramInt1 = k;
        }
        paramInt2 = paramInt1;
        if (paramInt1 < 0)
        {
          i = paramInt1;
          localObject2 = paramCharSequence;
          if (QLog.isColorLevel())
          {
            i = paramInt1;
            localObject2 = paramCharSequence;
            localObject1 = new StringBuilder();
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append("selection error, start = ");
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(j);
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(" end = ");
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(paramInt1);
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(" length = ");
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(k);
            i = paramInt1;
            localObject2 = paramCharSequence;
            QLog.w("ColorNick.EmoticonBuilder", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject1 = paramCharSequence;
          i = paramInt2;
          localObject2 = paramCharSequence;
          if (paramCharSequence.length() > 0)
          {
            i = paramInt2;
            localObject2 = paramCharSequence;
            localObject1 = new ColorNickText(paramCharSequence, this.b).b();
          }
          i = paramInt2;
          localObject2 = localObject1;
          paramCharSequence = super.replace(j, paramInt2, (CharSequence)localObject1, paramInt3, paramInt4);
          return paramCharSequence;
        }
      }
      catch (Throwable paramCharSequence)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQTextBuilder.replace caused crash..text:");
        ((StringBuilder)localObject1).append(toString());
        ((StringBuilder)localObject1).append(", replace text:");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append(" , ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" , ");
        ((StringBuilder)localObject1).append(paramInt3);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(paramInt4);
        QLog.e("ColorNick.EmoticonBuilder", 1, ((StringBuilder)localObject1).toString(), paramCharSequence);
        return new SpannableStringBuilder();
      }
      paramInt2 = 0;
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return super.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickColorEmoticonBuilder
 * JD-Core Version:    0.7.0.1
 */