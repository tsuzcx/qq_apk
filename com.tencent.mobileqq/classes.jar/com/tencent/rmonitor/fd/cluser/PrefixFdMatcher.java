package com.tencent.rmonitor.fd.cluser;

class PrefixFdMatcher
  extends BaseFdMatcher
{
  private final String[] a;
  
  PrefixFdMatcher(int paramInt, String... paramVarArgs)
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
      if (paramString.startsWith(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.cluser.PrefixFdMatcher
 * JD-Core Version:    0.7.0.1
 */