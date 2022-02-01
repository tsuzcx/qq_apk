package com.tencent.mobileqq.guild.util;

import android.text.Spannable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.emoji.text.EmojiSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;

public class QQGuildTextUtils
{
  public static int a(CharSequence paramCharSequence, int paramInt, float paramFloat)
  {
    Object localObject = new QQText(paramCharSequence, 3);
    QQGuildTextUtils.AsciiHalfCharacterCounter localAsciiHalfCharacterCounter = new QQGuildTextUtils.AsciiHalfCharacterCounter(null);
    localObject = a((Spannable)localObject);
    for (float f = localAsciiHalfCharacterCounter.a();; f = localAsciiHalfCharacterCounter.a())
    {
      f = paramFloat - f;
      if ((paramInt >= paramCharSequence.length()) || (QQGuildTextUtils.AsciiHalfCharacterCounter.a(localAsciiHalfCharacterCounter)) || (f <= 0.0F)) {
        break;
      }
      int i = ((SparseArray)localObject).indexOfKey(paramInt);
      if (i >= 0) {}
      for (i = localAsciiHalfCharacterCounter.a((QQGuildTextUtils.SpanPair)((SparseArray)localObject).valueAt(i), f);; i = localAsciiHalfCharacterCounter.a(paramCharSequence, paramInt, i, f))
      {
        paramInt += i;
        break;
        i = -i - 1;
        if (i < ((SparseArray)localObject).size()) {
          i = ((QQGuildTextUtils.SpanPair)((SparseArray)localObject).valueAt(i)).a;
        } else {
          i = paramCharSequence.length();
        }
      }
    }
    return paramInt;
  }
  
  @NonNull
  private static SparseArray<QQGuildTextUtils.SpanPair> a(@NonNull Spannable paramSpannable)
  {
    SparseArray localSparseArray = new SparseArray();
    int j = paramSpannable.length();
    int i = 0;
    Object[] arrayOfObject = paramSpannable.getSpans(0, j, Object.class);
    j = arrayOfObject.length;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if (((localObject instanceof EmojiSpan)) || ((localObject instanceof EmoticonSpan)))
      {
        localObject = QQGuildTextUtils.SpanPair.a(paramSpannable, localObject);
        localSparseArray.append(((QQGuildTextUtils.SpanPair)localObject).a, localObject);
      }
      i += 1;
    }
    return localSparseArray;
  }
  
  public static QQGuildTextUtils.CharacterCountInfo a(CharSequence paramCharSequence)
  {
    Object localObject = new QQText(paramCharSequence, 3);
    QQGuildTextUtils.AsciiHalfCharacterCounter localAsciiHalfCharacterCounter = new QQGuildTextUtils.AsciiHalfCharacterCounter(null);
    localObject = a((Spannable)localObject);
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int j = ((SparseArray)localObject).indexOfKey(i);
      if (j >= 0)
      {
        QQGuildTextUtils.SpanPair localSpanPair = (QQGuildTextUtils.SpanPair)((SparseArray)localObject).valueAt(j);
        i += localSpanPair.b - localSpanPair.a;
        localAsciiHalfCharacterCounter.a(localSpanPair);
      }
      else
      {
        j = -j - 1;
        if (j < ((SparseArray)localObject).size()) {
          j = ((QQGuildTextUtils.SpanPair)((SparseArray)localObject).valueAt(j)).a;
        } else {
          j = paramCharSequence.length();
        }
        localAsciiHalfCharacterCounter.a(paramCharSequence, i, j);
        i += j - i;
      }
    }
    return localAsciiHalfCharacterCounter.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildTextUtils
 * JD-Core Version:    0.7.0.1
 */