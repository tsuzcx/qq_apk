package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.util.Utils;

public class MQQName
{
  public int a;
  public String b;
  
  public MQQName() {}
  
  public MQQName(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public void a(MQQName paramMQQName)
  {
    if (paramMQQName != null)
    {
      this.a = paramMQQName.a;
      this.b = paramMQQName.b;
    }
  }
  
  public Object clone()
  {
    return new MQQName(this.a, this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MQQName))
    {
      paramObject = (MQQName)paramObject;
      if ((paramObject.a == this.a) && (Utils.a(paramObject.b, this.b))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQName
 * JD-Core Version:    0.7.0.1
 */