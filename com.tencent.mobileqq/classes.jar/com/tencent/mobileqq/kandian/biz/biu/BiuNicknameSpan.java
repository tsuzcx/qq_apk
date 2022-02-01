package com.tencent.mobileqq.kandian.biz.biu;

import android.content.Context;
import android.graphics.Paint;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeSpan;
import com.tencent.mobileqq.kandian.base.view.widget.text.ISpan;
import com.tencent.mobileqq.text.EmotcationConstants;
import org.jetbrains.annotations.NotNull;

public class BiuNicknameSpan
  extends ForegroundColorSpan
  implements DeleteAsAWholeSpan, ISpan
{
  public String a;
  public long b;
  private String c;
  private int d = -1;
  private int e = 0;
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    super(-15504151);
    this.a = paramString;
    this.b = paramLong;
    if (paramCharSequence != null) {
      paramString = paramCharSequence.toString();
    } else {
      paramString = "";
    }
    this.c = paramString;
  }
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    super(paramInt);
    this.a = paramString;
    this.b = paramLong;
    if (paramCharSequence != null) {
      paramString = paramCharSequence.toString();
    } else {
      paramString = "";
    }
    this.c = paramString;
  }
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, Context paramContext, Paint paramPaint, int paramInt)
  {
    super(-15504151);
    this.a = paramString;
    this.b = paramLong;
    if (paramCharSequence != null) {
      paramString = paramCharSequence.toString();
    } else {
      paramString = "";
    }
    this.c = paramString;
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int j;
    for (int i = 0; i < paramCharSequence.length(); i = j + 1)
    {
      int k = paramCharSequence.codePointAt(i);
      if ((k == 20) && (i < paramCharSequence.length() - 1)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        j = i;
        if (EmotcationConstants.EMOJI_MAP.get(k, -1) < 0) {
          break;
        }
        if (k > 65535)
        {
          j = paramCharSequence.length();
          k = i + 2;
          if (j >= k)
          {
            paramCharSequence.delete(i, k);
            continue;
          }
        }
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  @NotNull
  public String b()
  {
    return this.c;
  }
  
  public void cO_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan
 * JD-Core Version:    0.7.0.1
 */