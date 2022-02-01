package org.apache.commons.lang.time;

import org.apache.commons.lang.StringUtils;

class DurationFormatUtils$Token
{
  private int count;
  private Object value;
  
  DurationFormatUtils$Token(Object paramObject)
  {
    this.value = paramObject;
    this.count = 1;
  }
  
  DurationFormatUtils$Token(Object paramObject, int paramInt)
  {
    this.value = paramObject;
    this.count = paramInt;
  }
  
  static boolean containsTokenWithValue(Token[] paramArrayOfToken, Object paramObject)
  {
    int j = paramArrayOfToken.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfToken[i].getValue() == paramObject) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Token;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Token)paramObject;
      if (this.value.getClass() != paramObject.value.getClass()) {
        return false;
      }
      if (this.count != paramObject.count) {
        return false;
      }
      Object localObject = this.value;
      if ((localObject instanceof StringBuffer)) {
        return localObject.toString().equals(paramObject.value.toString());
      }
      if ((localObject instanceof Number)) {
        return localObject.equals(paramObject.value);
      }
      bool1 = bool2;
      if (localObject == paramObject.value) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  int getCount()
  {
    return this.count;
  }
  
  Object getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  void increment()
  {
    this.count += 1;
  }
  
  public String toString()
  {
    return StringUtils.repeat(this.value.toString(), this.count);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.DurationFormatUtils.Token
 * JD-Core Version:    0.7.0.1
 */