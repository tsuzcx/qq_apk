package com.tencent.rmonitor.fd.cluser;

import com.tencent.rmonitor.common.util.Objects;

class ExactFdMatcher
  extends BaseFdMatcher
{
  private final String[] a;
  
  ExactFdMatcher(int paramInt, String... paramVarArgs)
  {
    super(paramInt);
    this.a = paramVarArgs;
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = this.a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (Objects.a(arrayOfString[i], paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.cluser.ExactFdMatcher
 * JD-Core Version:    0.7.0.1
 */