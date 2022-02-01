package com.tencent.mobileqq.search.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.MobileQQ;

public class HighlightModel
{
  public List<String> a;
  public int b = 0;
  
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
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.toLowerCase().indexOf(paramString2.toLowerCase(), paramInt);
    }
    return -1;
  }
  
  public SpannableString a(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, false, false);
  }
  
  public SpannableString a(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return null;
    }
    Object localObject1 = new SpannableString(paramCharSequence);
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      if (((List)localObject2).size() <= 0) {
        return localObject1;
      }
      localObject2 = paramCharSequence.toString();
      Object[] arrayOfObject = this.a.toArray();
      this.b = 0;
      paramCharSequence = (CharSequence)localObject1;
      int m = 0;
      int i = 0;
      int j = 0;
      while (m < arrayOfObject.length)
      {
        String str2 = (String)arrayOfObject[m];
        if ((str2.length() <= 1) && (i != 0)) {
          return paramCharSequence;
        }
        int n = 0;
        int k = j;
        Object localObject3 = paramCharSequence;
        j = n;
        int i1 = a((String)localObject2, str2, j);
        if (i1 == -1)
        {
          m += 1;
          j = k;
          paramCharSequence = (CharSequence)localObject3;
        }
        else
        {
          n = i1;
          localObject1 = localObject3;
          paramCharSequence = (CharSequence)localObject2;
          j = k;
          if (paramBoolean3)
          {
            n = i1;
            localObject1 = localObject3;
            paramCharSequence = (CharSequence)localObject2;
            j = k;
            if (i1 > 10)
            {
              n = i1;
              localObject1 = localObject3;
              paramCharSequence = (CharSequence)localObject2;
              j = k;
              if (k == 0)
              {
                n = i1;
                localObject1 = localObject3;
                paramCharSequence = (CharSequence)localObject2;
                j = k;
                if (!paramBoolean1)
                {
                  paramCharSequence = new StringBuilder();
                  paramCharSequence.append("…");
                  paramCharSequence.append(((String)localObject2).substring(i1 - 6));
                  paramCharSequence = paramCharSequence.toString();
                  n = 7;
                  localObject1 = new SpannableString(paramCharSequence);
                  j = 1;
                }
              }
            }
          }
          if (paramBoolean2)
          {
            int i2 = paramCharSequence.indexOf(" ");
            int i3 = paramCharSequence.indexOf(" ", i2);
            i1 = i;
            k = j;
            if (n >= i2)
            {
              if (n <= i3) {
                break label367;
              }
              k = j;
              i1 = i;
            }
          }
          for (;;)
          {
            j = n + 1;
            localObject3 = localObject1;
            localObject2 = paramCharSequence;
            i = i1;
            break;
            label367:
            if (str2.length() > 1)
            {
              i = 1;
              j = 1;
            }
            try
            {
              if (!TextUtils.isEmpty(paramString)) {
                break label504;
              }
              localObject2 = "#00a5e0";
            }
            catch (Exception localException)
            {
              for (;;)
              {
                continue;
                String str1 = paramString;
              }
            }
            k = Color.parseColor((String)localObject2);
            break label413;
            k = Color.parseColor("#00a5e0");
            label413:
            i1 = k;
            if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime()))
            {
              i1 = k;
              if (TextUtils.isEmpty(paramString)) {
                i1 = Color.parseColor("#004080");
              }
            }
            ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(i1), n, str2.length() + n, 34);
            this.b += 1;
            i1 = i;
            k = j;
          }
        }
      }
      return paramCharSequence;
    }
    return localObject1;
  }
  
  public SpannableString a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return a(paramCharSequence, paramBoolean, false);
  }
  
  public SpannableString a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramCharSequence, null, paramBoolean1, paramBoolean2, true);
  }
  
  public SpannableString a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return a(paramCharSequence, null, paramBoolean1, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.HighlightModel
 * JD-Core Version:    0.7.0.1
 */