package com.tencent.mobileqq.text.processor;

import android.text.Spanned;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
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
      if (i < arrayOfEmoticonSpan.length)
      {
        EmoticonSpan localEmoticonSpan = arrayOfEmoticonSpan[i];
        int k = paramSpanned.getSpanStart(localEmoticonSpan);
        int m = paramSpanned.getSpanEnd(localEmoticonSpan);
        int j = k;
        if (k < paramInt1) {
          j = paramInt1;
        }
        k = m;
        if (m > paramInt2) {
          k = paramInt2;
        }
        switch (localEmoticonSpan.emojiType)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          try
          {
            paramStringBuilder.replace(j - paramInt1, k - paramInt1, TextUtils.getEmojiString(localEmoticonSpan.index));
          }
          catch (Exception localException)
          {
            QLog.e("QQEmoticonTextProcessor", 1, localException.getStackTrace());
          }
          continue;
          Object localObject = (SmallEmojiSpan)localException;
          localObject = EmosmUtils.a(((SmallEmojiSpan)localObject).b, ((SmallEmojiSpan)localObject).c);
          paramStringBuilder.replace(j - paramInt1, k - paramInt1, String.valueOf(new char[] { '\024', localObject[3], localObject[2], localObject[1], localObject[0] }));
          continue;
          paramStringBuilder.replace(j - paramInt1, k - paramInt1, TextUtils.getSysEmotcationString(((EmoticonSpan)localObject).index));
        }
      }
    }
  }
  
  public void doToPlain(int paramInt, StringBuffer paramStringBuffer, Spanned paramSpanned)
  {
    int i = 0;
    String str = QQText.EMOJI_SYMBOL;
    int j = str.length();
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramSpanned.getSpans(0, paramInt, EmoticonSpan.class);
    paramInt = 0;
    if (i < arrayOfEmoticonSpan.length)
    {
      Object localObject = arrayOfEmoticonSpan[i];
      int k = paramSpanned.getSpanStart(localObject);
      int m = paramSpanned.getSpanEnd(localObject);
      switch (((EmoticonSpan)localObject).emojiType)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuffer.replace(k + paramInt, m + paramInt, str);
        paramInt += j - (m - k);
        continue;
        localObject = ((EmoticonSpan)localObject).getDescription();
        paramStringBuffer.replace(k + paramInt, m + paramInt, (String)localObject);
        paramInt += ((String)localObject).length() - (m - k);
        continue;
        localObject = QQSysFaceUtil.getFaceDescription(((EmoticonSpan)localObject).index & 0x7FFFFFFF);
        paramStringBuffer.replace(k + paramInt, m + paramInt, (String)localObject);
        paramInt += ((String)localObject).length() - (m - k);
      }
    }
  }
  
  public void doToString(int paramInt, StringBuilder paramStringBuilder, Spanned paramSpanned)
  {
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramSpanned.getSpans(0, paramInt, EmoticonSpan.class);
    int i = paramStringBuilder.length();
    paramInt = 0;
    if (paramInt < arrayOfEmoticonSpan.length)
    {
      Object localObject = arrayOfEmoticonSpan[paramInt];
      int j = paramSpanned.getSpanStart(localObject);
      int k = paramSpanned.getSpanEnd(localObject);
      if ((j < i) && (k <= i)) {
        switch (((EmoticonSpan)localObject).emojiType)
        {
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramStringBuilder.replace(j, k, TextUtils.getEmojiString(((EmoticonSpan)localObject).index));
        continue;
        localObject = (SmallEmojiSpan)localObject;
        localObject = EmosmUtils.a(((SmallEmojiSpan)localObject).b, ((SmallEmojiSpan)localObject).c);
        paramStringBuilder.replace(j, k, String.valueOf(new char[] { '\024', localObject[3], localObject[2], localObject[1], localObject[0] }));
        if (QLog.isColorLevel())
        {
          QLog.d("QQEmoticonTextProcessor", 2, "start:" + j + ",end:" + k);
          continue;
          paramStringBuilder.replace(j, k, TextUtils.getSysEmotcationString(((EmoticonSpan)localObject).index));
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("QQEmoticonTextProcessor", 2, "error emo pos. start:" + j + " end: " + k + " length: " + i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.QQEmoticonTextProcessor
 * JD-Core Version:    0.7.0.1
 */