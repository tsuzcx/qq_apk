package com.tencent.viola.commons;

public class JSParam
{
  public static final int JSON = 3;
  public static final int NUMBER = 1;
  public static final int String = 2;
  public static final int WSON = 4;
  public Object data;
  public int type;
  
  public JSParam(int paramInt, Object paramObject)
  {
    this.type = paramInt;
    this.data = paramObject;
  }
  
  public JSParam(Object paramObject)
  {
    if (paramObject == null)
    {
      this.type = 2;
      this.data = "";
      return;
    }
    this.data = paramObject;
    if ((paramObject instanceof Integer))
    {
      this.type = 1;
      this.data = new Double(((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      this.type = 1;
      return;
    }
    if ((paramObject instanceof Float))
    {
      this.type = 1;
      this.data = new Double(((Float)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      this.type = 2;
      return;
    }
    if ((paramObject instanceof Object)) {
      this.type = 3;
    }
  }
  
  public String dataToString()
  {
    if (this.type == 2)
    {
      Object localObject = this.data;
      if (localObject != null) {
        return (String)localObject;
      }
    }
    return "";
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public int getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.commons.JSParam
 * JD-Core Version:    0.7.0.1
 */