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
  private int a;
  public long a;
  public String a;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    super(-15504151);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    if (paramCharSequence != null) {
      paramString = paramCharSequence.toString();
    } else {
      paramString = "";
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    if (paramCharSequence != null) {
      paramString = paramCharSequence.toString();
    } else {
      paramString = "";
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, Context paramContext, Paint paramPaint, int paramInt)
  {
    super(-15504151);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    if (paramCharSequence != null) {
      paramString = paramCharSequence.toString();
    } else {
      paramString = "";
    }
    this.jdField_b_of_type_JavaLangString = paramString;
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
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan
 * JD-Core Version:    0.7.0.1
 */