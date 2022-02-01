package com.tencent.mobileqq.profile.view;

import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.MD5;
import java.util.Map;

public class QzonePhotoView$PhotoInfo
{
  public String a;
  public Map<Integer, String> b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public QzonePhotoView$PhotoInfo(int paramInt1, int paramInt2, Map<Integer, String> paramMap)
  {
    int i = 0;
    this.c = 0;
    this.b = paramMap;
    this.a = null;
    this.f = paramInt2;
    if (this.b != null)
    {
      paramMap = new StringBuilder();
      paramMap.append(paramInt1);
      paramInt1 = i;
      while (paramInt1 <= 4)
      {
        String str = (String)this.b.get(Integer.valueOf(paramInt1));
        if (str != null) {
          paramMap.append(str);
        }
        paramInt1 += 1;
      }
      this.a = paramMap.toString();
      if (!TextUtils.isEmpty(this.a)) {
        this.a = MD5.toMD5(this.a);
      }
    }
  }
  
  private String b(int paramInt)
  {
    int i = 1;
    Object localObject = null;
    while ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 5))
    {
      localObject = (String)this.b.get(Integer.valueOf((paramInt + i) % 5));
      i += 1;
    }
    return localObject;
  }
  
  public String a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      String str = (String)((Map)localObject).get(Integer.valueOf(1));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        return b(1);
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public String a(int paramInt)
  {
    String str1;
    if (this.b != null)
    {
      int i = 2;
      if (paramInt <= 100) {
        i = 3;
      }
      String str2 = (String)this.b.get(Integer.valueOf(i));
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        return b(i);
      }
    }
    else
    {
      str1 = null;
    }
    return str1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PhotoInfo)) {
      return Utils.a(((PhotoInfo)paramObject).a, this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */