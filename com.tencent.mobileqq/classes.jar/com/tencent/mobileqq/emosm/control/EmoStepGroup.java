package com.tencent.mobileqq.emosm.control;

public class EmoStepGroup
  extends EmoAsyncStep
{
  protected EmoAsyncStep[] k;
  public String l;
  public int m;
  protected String[] n;
  
  private String[] a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    if (j <= 2) {
      return new String[0];
    }
    String str2 = paramString.substring(1, paramString.length() - 1);
    int i1 = str2.length();
    StringBuilder localStringBuilder = new StringBuilder(50);
    for (paramString = str2; i < i1; paramString = str2.substring(i, i1))
    {
      j = i;
      String str1 = paramString;
      if (paramString.startsWith(","))
      {
        j = i + 1;
        str1 = str2.substring(j, i1);
      }
      paramString = b(str1);
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      i = j + paramString.length();
    }
    return localStringBuilder.toString().split("-");
  }
  
  private String b(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i3 = arrayOfChar.length;
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
    int i4 = arrayOfChar[0];
    int i1 = 0;
    int i;
    for (int i2 = 0; i1 < i3; i2 = i)
    {
      if (arrayOfChar[i1] == i4)
      {
        i = i2 + 1;
      }
      else
      {
        i = i2;
        if (arrayOfChar[i1] == j) {
          i = i2 - 1;
        }
      }
      if (i == 0) {
        return paramString.substring(0, i1 + 1);
      }
      i1 += 1;
    }
    return "";
    label121:
    if (paramString.indexOf(",") == -1) {
      return paramString;
    }
    return paramString.substring(0, paramString.indexOf(","));
  }
  
  public void a()
  {
    this.e = 2147483647L;
    this.n = a(this.l);
    this.m = 0;
    this.k = new EmoAsyncStep[this.n.length];
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 4) {
      super.a(paramInt);
    }
    EmoAsyncStep[] arrayOfEmoAsyncStep = this.k;
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
  
  public EmoAsyncStep c()
  {
    int i = this.m;
    if (i < this.n.length)
    {
      this.k[i] = EmoCaptureAsyncStepFactory.a(this.f, this.n[this.m]);
      this.k[this.m].j = this.j;
      EmoAsyncStep[] arrayOfEmoAsyncStep = this.k;
      i = this.m;
      this.m = (i + 1);
      return arrayOfEmoAsyncStep[i];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoStepGroup
 * JD-Core Version:    0.7.0.1
 */