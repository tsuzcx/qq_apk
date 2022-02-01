package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class QMessageUtils
{
  public static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, null);
  }
  
  public static String a(String paramString, boolean paramBoolean, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if (paramString == null) {
      return "";
    }
    char[] arrayOfChar = paramString.toCharArray();
    int m = 0;
    int n = 0;
    int i = 0;
    int k = 0;
    int i5;
    for (int i2 = 0; m < arrayOfChar.length; i2 = i5)
    {
      Object localObject = null;
      int j = i;
      paramString = localObject;
      if (paramArrayList != null) {
        for (;;)
        {
          j = i;
          paramString = localObject;
          if (i >= paramArrayList.size()) {
            break;
          }
          paramString = (AtTroopMemberInfo)paramArrayList.get(i);
          if ((paramString != null) && (paramString.isValid()))
          {
            j = i;
            break;
          }
          i += 1;
        }
      }
      int i3 = j;
      i = k;
      int i1 = i2;
      int i4;
      if (paramString != null)
      {
        i3 = j;
        i = k;
        i1 = i2;
        if (paramString.startPos <= m)
        {
          if (paramString.startPos == m) {
            k = n;
          }
          if (m < paramString.startPos + paramString.textLen)
          {
            i3 = j;
            i = k;
            i1 = i2;
            if (arrayOfChar[m] == '\024')
            {
              i5 = i2 - 2;
              i4 = n - 2;
              i2 = m + 1;
              break label417;
            }
          }
          else
          {
            paramString.startPos = ((short)(paramString.startPos + k));
            paramString.textLen = ((short)(paramString.textLen + i2));
            i3 = j + 1;
            i = 0;
            i1 = 0;
          }
        }
      }
      if ((arrayOfChar[m] == '\r') && ((!paramBoolean) || (m <= 0) || (arrayOfChar[(m - 1)] != '\024')))
      {
        arrayOfChar[(m + n)] = '\n';
        int i6 = m + 1;
        i2 = m;
        i4 = n;
        j = i3;
        k = i;
        i5 = i1;
        if (i6 < arrayOfChar.length)
        {
          i2 = m;
          i4 = n;
          j = i3;
          k = i;
          i5 = i1;
          if (arrayOfChar[i6] == '\n')
          {
            i4 = n - 1;
            i2 = i6;
            j = i3;
            k = i;
            i5 = i1;
          }
        }
      }
      else
      {
        i2 = m;
        i4 = n;
        j = i3;
        k = i;
        i5 = i1;
        if (n != 0)
        {
          arrayOfChar[(m + n)] = arrayOfChar[m];
          i5 = i1;
          k = i;
          j = i3;
          i4 = n;
          i2 = m;
        }
      }
      label417:
      m = i2 + 1;
      n = i4;
      i = j;
    }
    return new String(arrayOfChar, 0, arrayOfChar.length + n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QMessageUtils
 * JD-Core Version:    0.7.0.1
 */