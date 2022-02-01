package com.tencent.mobileqq.ocr.ui;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighlightModel
{
  public List<String> a;
  
  public HighlightModel(List<String> paramList, String paramString)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if ((paramString != null) && (!((List)localObject).contains(paramString))) {
      ((List)localObject).add(paramString);
    }
    Collections.sort((List)localObject, new HighlightModel.1(this));
    this.a = ((List)localObject);
  }
  
  public static String a(String paramString)
  {
    return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(paramString).replaceAll("");
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.toLowerCase().indexOf(paramString2.toLowerCase(), paramInt);
    }
    return -1;
  }
  
  public SpannableString a(String paramString)
  {
    return a(paramString, false);
  }
  
  public SpannableString a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject2 = new SpannableString(paramString);
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return localObject2;
      }
      Object[] arrayOfObject = this.a.toArray();
      int m = 0;
      int i = 0;
      int j = 0;
      if (m < arrayOfObject.length)
      {
        String str = (String)arrayOfObject[m];
        if ((str.length() <= 1) && (i != 0)) {
          return localObject2;
        }
        int k = 0;
        for (;;)
        {
          int i1 = a(paramString, str, k);
          if (i1 == -1)
          {
            m += 1;
            break;
          }
          int n = i1;
          Object localObject3 = localObject2;
          localObject1 = paramString;
          k = j;
          if (i1 > 10)
          {
            n = i1;
            localObject3 = localObject2;
            localObject1 = paramString;
            k = j;
            if (j == 0)
            {
              n = i1;
              localObject3 = localObject2;
              localObject1 = paramString;
              k = j;
              if (!paramBoolean)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("…");
                ((StringBuilder)localObject1).append(paramString.substring(i1 - 6));
                localObject1 = ((StringBuilder)localObject1).toString();
                n = 7;
                localObject3 = new SpannableString((CharSequence)localObject1);
                k = 1;
              }
            }
          }
          j = k;
          if (str.length() > 1)
          {
            j = 1;
            i = 1;
          }
          ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), n, str.length() + n, 34);
          k = n + 1;
          localObject2 = localObject3;
          paramString = (String)localObject1;
        }
      }
      return localObject2;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.HighlightModel
 * JD-Core Version:    0.7.0.1
 */