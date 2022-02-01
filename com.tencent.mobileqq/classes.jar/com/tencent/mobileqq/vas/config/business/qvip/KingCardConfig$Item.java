package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Arrays;

public class KingCardConfig$Item
{
  private final String jdField_a_of_type_JavaLangString;
  public final boolean a;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private final String jdField_b_of_type_JavaLangString;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString;
  private final String c;
  private final String d;
  
  public KingCardConfig$Item()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    this.c = null;
    this.d = null;
  }
  
  public KingCardConfig$Item(String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString1;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString2;
    if ("AIO".equals(paramString1))
    {
      this.c = "0X800A647";
      this.d = "0X800A648";
      return;
    }
    if ("group".equals(paramString1))
    {
      this.c = "0X800A649";
      this.d = "0X800A64A";
      return;
    }
    if ("download".equals(paramString1))
    {
      this.c = "0X800A64B";
      this.d = "0X800A64C";
      return;
    }
    this.c = null;
    this.d = null;
  }
  
  public SpannableString a(Context paramContext, CharSequence paramCharSequence)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramCharSequence);
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    localObject1 = ((StringBuilder)localObject1).toString();
    paramCharSequence = new SpannableString((CharSequence)localObject1);
    int i = 0;
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i];
      String str = this.jdField_b_of_type_ArrayOfJavaLangString[i];
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str)))
      {
        int j = ((String)localObject1).indexOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        paramCharSequence.setSpan(new KingCardConfig.Item.1(this, str, paramContext), j, ((String)localObject2).length() + j, 33);
      }
      i += 1;
    }
    paramContext = this.c;
    ReportController.b(null, "dc00898", "", "", paramContext, paramContext, 2, 0, "", "", "", "");
    return paramCharSequence;
  }
  
  public String a()
  {
    Object localObject = this.jdField_b_of_type_ArrayOfJavaLangString;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = this.c;
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 2, 0, "", "", "", "");
      return this.jdField_b_of_type_ArrayOfJavaLangString[0];
    }
    return "";
  }
  
  public void a()
  {
    String str = this.d;
    ReportController.b(null, "dc00898", "", "", str, str, 2, 0, "", "", "", "");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Item{enable=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", keyWords=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    localStringBuilder.append(", actionUrls=");
    localStringBuilder.append(Arrays.toString(this.jdField_b_of_type_ArrayOfJavaLangString));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item
 * JD-Core Version:    0.7.0.1
 */