package com.tencent.mobileqq.text.processor;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQEmoticonSpanProcessor
  implements ISpanProcessor
{
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, StringBuilder paramStringBuilder, ISpanCallback paramISpanCallback)
  {
    int i5 = paramStringBuilder.length();
    int i = 0;
    int k = 0;
    float f1 = 1.0F;
    try
    {
      float f2 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      f1 = f2;
    }
    catch (NullPointerException localNullPointerException)
    {
      int i1;
      int i2;
      int i6;
      int j;
      int i7;
      boolean bool1;
      for (;;)
      {
        QLog.d("QQText", 1, localNullPointerException, new Object[0]);
        continue;
        bool1 = false;
        continue;
        if (k == 10)
        {
          paramStringBuilder.setCharAt(j + 1, 'ú');
          continue;
          if ((k < 255) || (j + 4 >= i5)) {
            break;
          }
          char[] arrayOfChar = new char[4];
          arrayOfChar[0] = paramStringBuilder.charAt(j + 4);
          arrayOfChar[1] = paramStringBuilder.charAt(j + 3);
          arrayOfChar[2] = paramStringBuilder.charAt(j + 2);
          arrayOfChar[3] = paramStringBuilder.charAt(j + 1);
          paramInt4 = 0;
          if (paramInt4 < 3)
          {
            if (arrayOfChar[paramInt4] == 'ú') {
              arrayOfChar[paramInt4] = '\n';
            }
            for (;;)
            {
              paramInt4 += 1;
              break;
              if (arrayOfChar[paramInt4] == 'þ') {
                arrayOfChar[paramInt4] = '\r';
              }
            }
          }
          boolean bool2;
          if (k == 511)
          {
            bool2 = true;
            paramISpanCallback.addSpan(new SmallEmojiSpan(arrayOfChar, i1, bool1, bool2), j, j + 5, 33);
            paramInt4 = 2;
            if (paramInt4 >= 5) {
              break label538;
            }
            if (paramStringBuilder.charAt(j + paramInt4) != '\n') {
              break label507;
            }
            paramStringBuilder.setCharAt(j + paramInt4, 'ú');
          }
          for (;;)
          {
            paramInt4 += 1;
            break label458;
            bool2 = false;
            break;
            if (paramStringBuilder.charAt(j + paramInt4) == '\r') {
              paramStringBuilder.setCharAt(j + paramInt4, 'þ');
            }
          }
          j += 4;
          paramInt4 = i + 1;
          paramInt1 += 1;
          i = j;
        }
      }
      if (k != 250) {
        break label1147;
      }
      if (!QQText.IS_FXXKED_MTK) {
        break label589;
      }
      paramStringBuilder.replace(j, j + 2, "##");
      if (!bool1) {
        break label648;
      }
      for (paramInt4 = -2147483638;; paramInt4 = 10)
      {
        paramISpanCallback.addSpan(new EmoticonSpan(paramInt4, i1, 1), j, j + 2, 33);
        j += 1;
        paramInt4 = i + 1;
        paramInt1 += 1;
        i = j;
        break;
      }
      if ((paramInt3 & 0x1) != 1) {
        break label1147;
      }
      k = EmotcationConstants.getSingleEmoji(i7);
      paramInt4 = -1;
      int n = 0;
      int i3 = 0;
      if (i7 <= 65535) {
        break label919;
      }
      int m = i3;
      if (i5 <= j + 2) {
        break label713;
      }
      paramInt4 = paramStringBuilder.codePointAt(j + 2);
      m = i3;
      if (!EmotcationConstants.isSkinEmoji(paramInt4)) {
        break label724;
      }
      n = 1;
      if ((k != -1) && (n == 0)) {
        break label1158;
      }
      n = EmotcationConstants.getDoubleEmoji(i7, paramInt4);
      if (n != -1) {
        break label992;
      }
      for (n = 1;; n = 0)
      {
        if (k != -1)
        {
          if (n != 0) {
            if ((i7 > 65535) && (i5 >= j + 2))
            {
              if (QQText.IS_FXXKED_MTK) {
                paramStringBuilder.replace(j, j + 2, "##");
              }
              n = 2;
              if ((paramInt4 <= 65535) || (i5 < j + 2)) {
                break label1025;
              }
              if (QQText.IS_FXXKED_MTK) {
                paramStringBuilder.replace(j + 2, j + 4, "##");
              }
              paramInt4 = n + 2;
              if (m == 0) {
                break label1144;
              }
              paramInt4 += 1;
            }
          }
          for (;;)
          {
            if (i1 == i6) {}
            for (m = i2;; m = i1)
            {
              paramISpanCallback.addSpan(new EmoticonSpan(k, m, 0), j, j + paramInt4, 33);
              j += paramInt4 - 1;
              paramInt4 = i + 1;
              i = j;
              break;
              m = i3;
              if (i5 <= j + 1) {
                break label713;
              }
              int i4 = paramStringBuilder.codePointAt(j + 1);
              m = i3;
              paramInt4 = i4;
              if (i4 != 65039) {
                break label713;
              }
              m = i3;
              paramInt4 = i4;
              if (i5 <= j + 2) {
                break label713;
              }
              paramInt4 = paramStringBuilder.codePointAt(j + 2);
              m = 1;
              break label713;
              k = n;
              break label750;
              if (QQText.IS_FXXKED_MTK) {
                paramStringBuilder.replace(j, j + 1, "#");
              }
              n = 1;
              break label803;
              if (QQText.IS_FXXKED_MTK) {
                paramStringBuilder.replace(j + 2, j + 3, "#");
              }
              paramInt4 = n + 1;
              break label847;
              if ((i7 > 65535) && (i5 >= j + 2))
              {
                if (QQText.IS_FXXKED_MTK) {
                  paramStringBuilder.replace(j, j + 2, "##");
                }
                paramInt4 = 2;
                break label858;
              }
              if (QQText.IS_FXXKED_MTK) {
                paramStringBuilder.replace(j, j + 1, "#");
              }
              paramInt4 = 1;
              break label858;
            }
            j = i + 1;
            i = paramInt4;
            break;
          }
        }
        paramInt4 = i;
        i = j;
        break label228;
      }
    }
    i1 = (int)(paramInt4 * f1 + 0.5F);
    i2 = (int)(22.0F * f1 + 0.5F);
    i6 = (int)(f1 * 32.0F + 0.5F);
    j = paramInt1;
    paramInt1 = k;
    if (j < paramInt2)
    {
      i7 = paramStringBuilder.codePointAt(j);
      if ((paramInt3 & 0x4) == 4)
      {
        bool1 = true;
        if (((paramInt3 & 0x6) <= 0) || (i7 != 20) || (j >= i5 - 1)) {
          break label655;
        }
        k = paramStringBuilder.charAt(j + 1);
        if (!QQSysFaceUtil.isValidFaceId(k)) {
          break label283;
        }
        if (!QQText.IS_FXXKED_MTK) {
          break label261;
        }
        paramStringBuilder.replace(j, j + 2, "##");
        paramInt4 = k;
        if (bool1) {
          paramInt4 = k | 0x80000000;
        }
        paramISpanCallback.addSpan(new EmoticonSpan(paramInt4, i1, 1), j, j + 2, 33);
        paramInt4 = j + 1;
        j = i + 1;
        paramInt1 += 1;
        i = paramInt4;
        paramInt4 = j;
        label228:
        if (paramInt4 <= 512) {
          break label1131;
        }
        return paramInt1;
      }
    }
    label261:
    label283:
    label458:
    label507:
    return paramInt1;
  }
  
  public void doGrab(GrabParams paramGrabParams, ISpanCallback paramISpanCallback)
  {
    if ((paramGrabParams == null) || (paramISpanCallback == null)) {}
    do
    {
      do
      {
        return;
        StringBuilder localStringBuilder = new StringBuilder(paramGrabParams.text);
        i = a(paramGrabParams.start, paramGrabParams.end, paramGrabParams.flag, paramGrabParams.emoSize, localStringBuilder, paramISpanCallback);
        paramGrabParams.text = localStringBuilder.toString();
      } while ((paramISpanCallback == null) || (i < QQSysFaceUtil.getAnimEmoCount()));
      paramGrabParams = (EmoticonSpan[])paramISpanCallback.acquireSpans(paramGrabParams.start, paramGrabParams.end, EmoticonSpan.class);
    } while (paramGrabParams == null);
    int j = paramGrabParams.length;
    int i = 0;
    label96:
    if (i < j)
    {
      paramISpanCallback = paramGrabParams[i];
      if (paramISpanCallback.emojiType != 1) {
        break label132;
      }
      paramISpanCallback.index &= 0x7FFFFFFF;
    }
    for (;;)
    {
      i += 1;
      break label96;
      break;
      label132:
      if (paramISpanCallback.emojiType == 2) {
        ((SmallEmojiSpan)paramISpanCallback).a = false;
      }
    }
  }
  
  public int doPlain(Object paramObject, int paramInt1, int paramInt2, int paramInt3, StringBuffer paramStringBuffer)
  {
    int j = 0;
    int i = 0;
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    EmoticonSpan localEmoticonSpan;
    do
    {
      return 0;
      localEmoticonSpan = (EmoticonSpan)paramObject;
      paramObject = "";
      switch (localEmoticonSpan.emojiType)
      {
      default: 
        return 0;
      }
    } while (paramInt3 == 3);
    if (paramInt3 == 2)
    {
      paramObject = QQText.EMOJI_SYMBOL;
      i = paramObject.length();
    }
    paramStringBuffer.replace(paramInt1, paramInt2, paramObject);
    return i - (paramInt2 - paramInt1);
    paramObject = localEmoticonSpan.getDescription();
    paramStringBuffer.replace(paramInt1, paramInt2, paramObject);
    return paramObject.length() - (paramInt2 - paramInt1);
    if (paramInt3 != 1) {
      paramObject = QQSysFaceUtil.getFaceDescription(0x7FFFFFFF & localEmoticonSpan.index);
    }
    for (paramInt3 = paramObject.length();; paramInt3 = j)
    {
      paramStringBuffer.replace(paramInt1, paramInt2, paramObject);
      return paramInt3 - (paramInt2 - paramInt1);
      paramObject = "";
    }
  }
  
  public boolean matchGrab(int paramInt)
  {
    return (paramInt > 0) && (((paramInt & 0x1) == 1) || ((paramInt & 0x6) > 0));
  }
  
  public boolean matchPlain(Object paramObject)
  {
    return paramObject instanceof EmoticonSpan;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.QQEmoticonSpanProcessor
 * JD-Core Version:    0.7.0.1
 */