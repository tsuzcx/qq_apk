package com.tencent.mobileqq.profile.view;

import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.MD5;
import java.util.Map;

public class QzonePhotoView$PhotoInfo
{
  public int a;
  public String a;
  public Map<Integer, String> a;
  public int b;
  public int c;
  public int d;
  
  public QzonePhotoView$PhotoInfo(int paramInt1, int paramInt2, Map<Integer, String> paramMap)
  {
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_JavaLangString = null;
    this.d = paramInt2;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramMap = new StringBuilder();
      paramMap.append(paramInt1);
      paramInt1 = i;
      while (paramInt1 <= 4)
      {
        String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
        if (str != null) {
          paramMap.append(str);
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaLangString = paramMap.toString();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = MD5.toMD5(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private String b(int paramInt)
  {
    int i = 1;
    Object localObject = null;
    while ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 5))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf((paramInt + i) % 5));
      i += 1;
    }
    return localObject;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
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
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      int i = 2;
      if (paramInt <= 100) {
        i = 3;
      }
      String str2 = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
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
      return Utils.a(((PhotoInfo)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */