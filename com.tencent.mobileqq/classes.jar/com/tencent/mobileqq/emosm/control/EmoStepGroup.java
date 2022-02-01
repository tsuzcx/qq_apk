package com.tencent.mobileqq.emosm.control;

public class EmoStepGroup
  extends EmoAsyncStep
{
  protected EmoAsyncStep[] a;
  protected String[] a;
  public String b;
  public int e;
  
  private String a(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int n = arrayOfChar.length;
    int j;
    if (arrayOfChar[0] == '{')
    {
      j = 125;
    }
    else
    {
      if (arrayOfChar[0] != '[') {
        break label121;
      }
      j = 93;
    }
    int i1 = arrayOfChar[0];
    int k = 0;
    int i;
    for (int m = 0; k < n; m = i)
    {
      if (arrayOfChar[k] == i1)
      {
        i = m + 1;
      }
      else
      {
        i = m;
        if (arrayOfChar[k] == j) {
          i = m - 1;
        }
      }
      if (i == 0) {
        return paramString.substring(0, k + 1);
      }
      k += 1;
    }
    return "";
    label121:
    if (paramString.indexOf(",") == -1) {
      return paramString;
    }
    return paramString.substring(0, paramString.indexOf(","));
  }
  
  private String[] a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    if (j <= 2) {
      return new String[0];
    }
    String str2 = paramString.substring(1, paramString.length() - 1);
    int k = str2.length();
    StringBuilder localStringBuilder = new StringBuilder(50);
    for (paramString = str2; i < k; paramString = str2.substring(i, k))
    {
      j = i;
      String str1 = paramString;
      if (paramString.startsWith(","))
      {
        j = i + 1;
        str1 = str2.substring(j, k);
      }
      paramString = a(str1);
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      i = j + paramString.length();
    }
    return localStringBuilder.toString().split("-");
  }
  
  public EmoAsyncStep a()
  {
    int i = this.e;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep[i] = EmoCaptureAsyncStepFactory.a(this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAutomator, this.jdField_a_of_type_ArrayOfJavaLangString[this.e]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep[this.e].jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      EmoAsyncStep[] arrayOfEmoAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep;
      i = this.e;
      this.e = (i + 1);
      return arrayOfEmoAsyncStep[i];
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 2147483647L;
    this.jdField_a_of_type_ArrayOfJavaLangString = a(this.b);
    this.e = 0;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep = new EmoAsyncStep[this.jdField_a_of_type_ArrayOfJavaLangString.length];
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 4) {
      super.a(paramInt);
    }
    EmoAsyncStep[] arrayOfEmoAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep;
    if (((paramInt == 8) || (paramInt == 4)) && (arrayOfEmoAsyncStep != null))
    {
      int j = arrayOfEmoAsyncStep.length;
      int i = 0;
      while (i < j)
      {
        EmoAsyncStep localEmoAsyncStep = arrayOfEmoAsyncStep[i];
        if (localEmoAsyncStep == null) {
          return;
        }
        localEmoAsyncStep.a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoStepGroup
 * JD-Core Version:    0.7.0.1
 */