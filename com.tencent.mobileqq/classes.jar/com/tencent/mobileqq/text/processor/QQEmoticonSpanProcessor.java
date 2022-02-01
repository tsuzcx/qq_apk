package com.tencent.mobileqq.text.processor;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQEmoticonSpanProcessor
  implements ISpanProcessor
{
  private int doGrabEMotcation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, StringBuilder paramStringBuilder, ISpanCallback paramISpanCallback)
  {
    int i7 = paramStringBuilder.length();
    float f;
    try
    {
      f = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.d("QQText", 1, localNullPointerException, new Object[0]);
      f = 1.0F;
    }
    int i5 = (int)(paramInt4 * f + 0.5F);
    int i6 = (int)(22.0F * f + 0.5F);
    int i8 = (int)(f * 32.0F + 0.5F);
    int k = 0;
    int j = 0;
    int m = paramInt1;
    while (m < paramInt2)
    {
      int i9 = paramStringBuilder.codePointAt(m);
      boolean bool1;
      if ((paramInt3 & 0x4) == 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i2 = 2;
      int n;
      int i1;
      int i;
      if (((paramInt3 & 0x6) > 0) && (i9 == 20) && (m < i7 - 1))
      {
        n = m + 1;
        i1 = paramStringBuilder.charAt(n);
        if (QQSysFaceUtil.isValidFaceId(i1))
        {
          if (QQText.IS_FXXKED_MTK) {
            paramStringBuilder.replace(m, m + 2, "##");
          } else if (i1 == 10) {
            paramStringBuilder.setCharAt(n, 'ú');
          }
          paramInt1 = i1;
          if (bool1) {
            paramInt1 = i1 | 0x80000000;
          }
          paramISpanCallback.addSpan(new EmoticonSpan(paramInt1, i5, 1), m, m + 2, 33);
          paramInt4 = k + 1;
          paramInt1 = j + 1;
          i = n;
        }
      }
      for (;;)
      {
        break label1091;
        if (i1 >= 255)
        {
          i = m + 4;
          if (i < i7)
          {
            char[] arrayOfChar = new char[4];
            arrayOfChar[0] = paramStringBuilder.charAt(i);
            arrayOfChar[1] = paramStringBuilder.charAt(m + 3);
            arrayOfChar[2] = paramStringBuilder.charAt(m + 2);
            arrayOfChar[3] = paramStringBuilder.charAt(n);
            paramInt1 = 0;
            while (paramInt1 < 3)
            {
              if (arrayOfChar[paramInt1] == 'ú') {
                arrayOfChar[paramInt1] = '\n';
              } else if (arrayOfChar[paramInt1] == 'þ') {
                arrayOfChar[paramInt1] = '\r';
              }
              paramInt1 += 1;
            }
            ISmallEmojiSpanService localISmallEmojiSpanService = (ISmallEmojiSpanService)QRoute.api(ISmallEmojiSpanService.class);
            boolean bool2;
            if (i1 == 511) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            paramISpanCallback.addSpan(localISmallEmojiSpanService.createSmallEmojiSpan(arrayOfChar, i5, bool1, bool2), m, m + 5, 33);
            paramInt1 = 2;
            while (paramInt1 < 5)
            {
              paramInt4 = m + paramInt1;
              if (paramStringBuilder.charAt(paramInt4) == '\n') {
                paramStringBuilder.setCharAt(paramInt4, 'ú');
              } else if (paramStringBuilder.charAt(paramInt4) == '\r') {
                paramStringBuilder.setCharAt(paramInt4, 'þ');
              }
              paramInt1 += 1;
            }
            paramInt4 = k + 1;
            paramInt1 = j + 1;
            continue;
          }
        }
        i2 = 10;
        i = m;
        paramInt4 = k;
        paramInt1 = j;
        if (i1 == 250)
        {
          if (QQText.IS_FXXKED_MTK) {
            paramStringBuilder.replace(m, m + 2, "##");
          }
          paramInt1 = i2;
          if (bool1) {
            paramInt1 = -2147483638;
          }
          paramISpanCallback.addSpan(new EmoticonSpan(paramInt1, i5, 1), m, m + 2, 33);
          break;
          i = m;
          paramInt4 = k;
          paramInt1 = j;
          if ((paramInt3 & 0x1) == 1)
          {
            int i3 = EmotcationConstants.getSingleEmoji(i9);
            if (i9 > 65535)
            {
              paramInt1 = m + 2;
              if (i7 <= paramInt1) {
                break label727;
              }
              i1 = paramStringBuilder.codePointAt(paramInt1);
            }
            else
            {
              paramInt1 = m + 1;
              if (i7 <= paramInt1) {
                break label727;
              }
              paramInt1 = paramStringBuilder.codePointAt(paramInt1);
              i1 = paramInt1;
              if (paramInt1 == 65039)
              {
                paramInt4 = m + 2;
                i1 = paramInt1;
                if (i7 > paramInt4)
                {
                  i1 = paramStringBuilder.codePointAt(paramInt4);
                  n = 1;
                  break label733;
                }
              }
            }
            n = 0;
            break label733;
            label727:
            n = 0;
            i1 = -1;
            label733:
            bool1 = EmotcationConstants.isSkinEmoji(i1);
            int i4;
            if ((i3 != -1) && (!bool1))
            {
              i4 = 0;
            }
            else
            {
              paramInt4 = EmotcationConstants.getDoubleEmoji(i9, i1);
              paramInt1 = paramInt4;
              if (paramInt4 == -1) {
                paramInt1 = i3;
              }
              i4 = 1;
              i3 = paramInt1;
            }
            i = m;
            paramInt4 = k;
            paramInt1 = j;
            if (i3 != -1)
            {
              if (i4 != 0)
              {
                if (i9 > 65535)
                {
                  paramInt1 = m + 2;
                  if (i7 >= paramInt1)
                  {
                    if (QQText.IS_FXXKED_MTK) {
                      paramStringBuilder.replace(m, paramInt1, "##");
                    }
                    break label870;
                  }
                }
                if (QQText.IS_FXXKED_MTK) {
                  paramStringBuilder.replace(m, m + 1, "#");
                }
                i2 = 1;
                label870:
                if (i1 > 65535)
                {
                  paramInt1 = m + 2;
                  if (i7 >= paramInt1)
                  {
                    if (QQText.IS_FXXKED_MTK) {
                      paramStringBuilder.replace(paramInt1, m + 4, "##");
                    }
                    paramInt4 = i2 + 2;
                    break label944;
                  }
                }
                if (QQText.IS_FXXKED_MTK) {
                  paramStringBuilder.replace(m + 2, m + 3, "#");
                }
                paramInt4 = i2 + 1;
                label944:
                paramInt1 = paramInt4;
                if (n != 0) {
                  paramInt1 = paramInt4 + 1;
                }
              }
              else
              {
                if (i9 > 65535)
                {
                  paramInt4 = m + 2;
                  if (i7 >= paramInt4)
                  {
                    paramInt1 = i2;
                    if (!QQText.IS_FXXKED_MTK) {
                      break label1029;
                    }
                    paramStringBuilder.replace(m, paramInt4, "##");
                    paramInt1 = i2;
                    break label1029;
                  }
                }
                if (QQText.IS_FXXKED_MTK) {
                  paramStringBuilder.replace(m, m + 1, "#");
                }
                paramInt1 = 1;
              }
              label1029:
              if (i5 == i8) {
                paramInt4 = i6;
              } else {
                paramInt4 = i5;
              }
              paramISpanCallback.addSpan(new EmoticonSpan(i3, paramInt4, 0), m, m + paramInt1, 33);
              i = m + (paramInt1 - 1);
              paramInt1 = j + 1;
              paramInt4 = k;
            }
          }
        }
      }
      label1091:
      if (paramInt1 > 512) {
        return paramInt4;
      }
      m = i + 1;
      k = paramInt4;
      j = paramInt1;
    }
    return k;
  }
  
  public void doGrab(GrabParams paramGrabParams, ISpanCallback paramISpanCallback)
  {
    if ((paramGrabParams != null) && (paramISpanCallback != null))
    {
      if (TextUtils.isEmpty(paramGrabParams.text)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramGrabParams.text);
      int i = doGrabEMotcation(paramGrabParams.start, paramGrabParams.end, paramGrabParams.flag, paramGrabParams.emoSize, localStringBuilder, paramISpanCallback);
      paramGrabParams.text = localStringBuilder.toString();
      if ((paramISpanCallback != null) && (i >= QQSysFaceUtil.getAnimEmoCount()))
      {
        paramGrabParams = (EmoticonSpan[])paramISpanCallback.acquireSpans(paramGrabParams.start, paramGrabParams.end, EmoticonSpan.class);
        if (paramGrabParams != null)
        {
          int j = paramGrabParams.length;
          i = 0;
          while (i < j)
          {
            paramISpanCallback = paramGrabParams[i];
            if (paramISpanCallback.emojiType == 1) {
              paramISpanCallback.index &= 0x7FFFFFFF;
            } else if (paramISpanCallback.emojiType == 2) {
              ((ISmallEmojiSpan)paramISpanCallback).setIsAnim(false);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public int doPlain(Object paramObject, int paramInt1, int paramInt2, int paramInt3, StringBuffer paramStringBuffer)
  {
    int j = 0;
    int i = 0;
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return 0;
      }
      EmoticonSpan localEmoticonSpan = (EmoticonSpan)paramObject;
      int k = localEmoticonSpan.emojiType;
      paramObject = "";
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2) {
            return 0;
          }
          paramObject = localEmoticonSpan.getDescription();
          paramStringBuffer.replace(paramInt1, paramInt2, paramObject);
          return paramObject.length() - (paramInt2 - paramInt1);
        }
        if (paramInt3 != 1)
        {
          paramObject = QQSysFaceUtil.getFaceDescription(localEmoticonSpan.index & 0x7FFFFFFF);
          i = paramObject.length();
        }
        paramStringBuffer.replace(paramInt1, paramInt2, paramObject);
      }
      for (;;)
      {
        return i - (paramInt2 - paramInt1);
        if (paramInt3 == 3) {
          return 0;
        }
        i = j;
        if (paramInt3 == 2)
        {
          paramObject = QQText.EMOJI_SYMBOL;
          i = paramObject.length();
        }
        paramStringBuffer.replace(paramInt1, paramInt2, paramObject);
      }
    }
    return 0;
  }
  
  public boolean matchGrab(int paramInt)
  {
    boolean bool = true;
    if (paramInt > 0)
    {
      if ((paramInt & 0x1) == 1) {
        return bool;
      }
      if ((paramInt & 0x6) > 0) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public boolean matchPlain(Object paramObject)
  {
    return paramObject instanceof EmoticonSpan;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.QQEmoticonSpanProcessor
 * JD-Core Version:    0.7.0.1
 */