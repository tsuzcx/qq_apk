package com.tencent.mobileqq.text.processor;

import android.text.Spanned;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.qphone.base.util.QLog;

public class QQEmoticonTextProcessor
  implements ITextProcessor
{
  public void doSubSequence(int paramInt1, int paramInt2, StringBuilder paramStringBuilder, Spanned paramSpanned)
  {
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramSpanned.getSpans(paramInt1, paramInt2, EmoticonSpan.class);
    if (paramInt2 - paramInt1 > 0)
    {
      int i = 0;
      while (i < arrayOfEmoticonSpan.length)
      {
        Object localObject = arrayOfEmoticonSpan[i];
        int k = paramSpanned.getSpanStart(localObject);
        int m = paramSpanned.getSpanEnd(localObject);
        int j = k;
        if (k < paramInt1) {
          j = paramInt1;
        }
        k = m;
        if (m > paramInt2) {
          k = paramInt2;
        }
        m = ((EmoticonSpan)localObject).emojiType;
        if (m != 0)
        {
          if (m != 1)
          {
            if (m == 2)
            {
              localObject = (ISmallEmojiSpan)localObject;
              localObject = EmosmUtils.b(((ISmallEmojiSpan)localObject).getEpId(), ((ISmallEmojiSpan)localObject).getEId());
              paramStringBuilder.replace(j - paramInt1, k - paramInt1, String.valueOf(new char[] { '\024', localObject[3], localObject[2], localObject[1], localObject[0] }));
            }
          }
          else {
            paramStringBuilder.replace(j - paramInt1, k - paramInt1, TextUtils.getSysEmotcationString(((EmoticonSpan)localObject).index));
          }
        }
        else {
          try
          {
            paramStringBuilder.replace(j - paramInt1, k - paramInt1, TextUtils.getEmojiString(((EmoticonSpan)localObject).index));
          }
          catch (Exception localException)
          {
            QLog.e("QQEmoticonTextProcessor", 1, localException.getStackTrace());
          }
        }
        i += 1;
      }
    }
  }
  
  public void doToPlain(int paramInt, StringBuffer paramStringBuffer, Spanned paramSpanned)
  {
    String str = QQText.EMOJI_SYMBOL;
    int k = str.length();
    int i = 0;
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramSpanned.getSpans(0, paramInt, EmoticonSpan.class);
    int j = 0;
    paramInt = i;
    i = j;
    while (paramInt < arrayOfEmoticonSpan.length)
    {
      Object localObject = arrayOfEmoticonSpan[paramInt];
      int m = paramSpanned.getSpanStart(localObject);
      int n = paramSpanned.getSpanEnd(localObject);
      j = ((EmoticonSpan)localObject).emojiType;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2) {
            break label218;
          }
          localObject = ((EmoticonSpan)localObject).getDescription();
          paramStringBuffer.replace(m + i, n + i, (String)localObject);
          j = ((String)localObject).length();
        }
        else
        {
          localObject = QQSysFaceUtil.getFaceDescription(((EmoticonSpan)localObject).index & 0x7FFFFFFF);
          paramStringBuffer.replace(m + i, n + i, (String)localObject);
          j = ((String)localObject).length();
        }
        j -= n - m;
      }
      else
      {
        paramStringBuffer.replace(m + i, n + i, str);
        j = k - (n - m);
      }
      i += j;
      label218:
      paramInt += 1;
    }
  }
  
  public void doToString(int paramInt, StringBuilder paramStringBuilder, Spanned paramSpanned)
  {
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramSpanned.getSpans(0, paramInt, EmoticonSpan.class);
    int i = paramStringBuilder.length();
    paramInt = 0;
    while (paramInt < arrayOfEmoticonSpan.length)
    {
      Object localObject = arrayOfEmoticonSpan[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if ((j < i) && (k <= i))
      {
        int m = ((EmoticonSpan)localObject).emojiType;
        if (m != 0)
        {
          if (m != 1)
          {
            if (m == 2)
            {
              localObject = (ISmallEmojiSpan)localObject;
              localObject = EmosmUtils.b(((ISmallEmojiSpan)localObject).getEpId(), ((ISmallEmojiSpan)localObject).getEId());
              paramStringBuilder.replace(j, k, String.valueOf(new char[] { '\024', localObject[3], localObject[2], localObject[1], localObject[0] }));
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("start:");
                ((StringBuilder)localObject).append(j);
                ((StringBuilder)localObject).append(",end:");
                ((StringBuilder)localObject).append(k);
                QLog.d("QQEmoticonTextProcessor", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          else {
            paramStringBuilder.replace(j, k, TextUtils.getSysEmotcationString(((EmoticonSpan)localObject).index));
          }
        }
        else {
          paramStringBuilder.replace(j, k, TextUtils.getEmojiString(((EmoticonSpan)localObject).index));
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error emo pos. start:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" end: ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" length: ");
        ((StringBuilder)localObject).append(i);
        QLog.e("QQEmoticonTextProcessor", 2, ((StringBuilder)localObject).toString());
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.QQEmoticonTextProcessor
 * JD-Core Version:    0.7.0.1
 */