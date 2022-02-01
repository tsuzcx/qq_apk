package com.tencent.mobileqq.search.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighlightModel
{
  public int a;
  public List<String> a;
  
  public HighlightModel(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if ((paramString != null) && (!((List)localObject).contains(paramString))) {
      ((List)localObject).add(paramString);
    }
    Collections.sort((List)localObject, new HighlightModel.1(this));
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return -1;
    }
    return paramString1.toLowerCase().indexOf(paramString2.toLowerCase(), paramInt);
  }
  
  public SpannableString a(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, false, false);
  }
  
  public SpannableString a(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramCharSequence))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = new SpannableString(paramCharSequence);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return localObject1;
    }
    paramCharSequence = paramCharSequence.toString();
    Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilList.toArray();
    this.jdField_a_of_type_Int = 0;
    int i = 0;
    int j = 0;
    int m = 0;
    String str;
    int k;
    int n;
    for (;;)
    {
      localObject2 = localObject1;
      if (m >= arrayOfObject.length) {
        break;
      }
      str = (String)arrayOfObject[m];
      if (str.length() <= 1)
      {
        localObject2 = localObject1;
        if (j != 0) {
          break;
        }
      }
      k = 0;
      n = a(paramCharSequence, str, k);
      if (n != -1) {
        break label146;
      }
      m += 1;
    }
    label146:
    if ((paramBoolean3) && (n > 10) && (i == 0) && (!paramBoolean1))
    {
      localObject1 = "…" + paramCharSequence.substring(n - 6);
      paramCharSequence = new SpannableString((CharSequence)localObject1);
      i = 1;
      n = 7;
    }
    for (;;)
    {
      int i1;
      if (paramBoolean2)
      {
        k = ((String)localObject1).indexOf(" ");
        i1 = ((String)localObject1).indexOf(" ", k);
        if ((n < k) || (n > i1))
        {
          localObject2 = paramCharSequence;
          k = n + 1;
          paramCharSequence = (CharSequence)localObject1;
          localObject1 = localObject2;
          break;
        }
      }
      if (str.length() > 1)
      {
        j = 1;
        i = 1;
      }
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString)) {
            continue;
          }
          localObject2 = "#00a5e0";
          k = Color.parseColor((String)localObject2);
        }
        catch (Exception localException)
        {
          k = Color.parseColor("#00a5e0");
          continue;
        }
        i1 = k;
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          i1 = k;
          if (TextUtils.isEmpty(paramString)) {
            i1 = Color.parseColor("#004080");
          }
        }
        paramCharSequence.setSpan(new ForegroundColorSpan(i1), n, str.length() + n, 34);
        this.jdField_a_of_type_Int += 1;
        localObject2 = paramCharSequence;
        k = n + 1;
        paramCharSequence = (CharSequence)localObject1;
        localObject1 = localObject2;
        break;
        localObject2 = paramString;
      }
      Object localObject3 = localObject1;
      localObject1 = paramCharSequence;
      paramCharSequence = localObject3;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.HighlightModel
 * JD-Core Version:    0.7.0.1
 */