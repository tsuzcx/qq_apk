package com.tencent.thumbplayer.api;

public class TPOptionalParam
{
  public static final int TP_OPTIONAL_RARAM_TYPE_BOOLEAN = 1;
  public static final int TP_OPTIONAL_RARAM_TYPE_LONG = 2;
  public static final int TP_OPTIONAL_RARAM_TYPE_QUEUE_INT = 4;
  public static final int TP_OPTIONAL_RARAM_TYPE_QUEUE_STRING = 5;
  public static final int TP_OPTIONAL_RARAM_TYPE_STRING = 3;
  public static final int TP_OPTIONAL_RARAM_TYPE_UNKNOW = -1;
  private int key;
  private TPOptionalParam.OptionalParamBoolean paramBoolean;
  private TPOptionalParam.OptionalParamLong paramLong;
  private TPOptionalParam.OptionalParamQueueInt paramQueueInt;
  private TPOptionalParam.OptionalParamQueueString paramQueueString;
  private TPOptionalParam.OptionalParamString paramString;
  private int paramType = -1;
  
  public TPOptionalParam buildBoolean(int paramInt, boolean paramBoolean1)
  {
    this.paramType = 1;
    this.key = paramInt;
    this.paramBoolean = new TPOptionalParam.OptionalParamBoolean(this);
    this.paramBoolean.value = paramBoolean1;
    return this;
  }
  
  public TPOptionalParam buildLong(int paramInt, long paramLong1)
  {
    this.paramType = 2;
    this.key = paramInt;
    this.paramLong = new TPOptionalParam.OptionalParamLong(this);
    this.paramLong.value = paramLong1;
    return this;
  }
  
  public TPOptionalParam buildLong(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.paramType = 2;
    this.key = paramInt;
    this.paramLong = new TPOptionalParam.OptionalParamLong(this);
    this.paramLong.value = paramLong1;
    this.paramLong.param1 = paramLong2;
    this.paramLong.param2 = paramLong3;
    return this;
  }
  
  public TPOptionalParam buildQueueInt(int paramInt, int[] paramArrayOfInt)
  {
    this.paramType = 4;
    this.key = paramInt;
    this.paramQueueInt = new TPOptionalParam.OptionalParamQueueInt(this);
    this.paramQueueInt.queueValue = paramArrayOfInt;
    return this;
  }
  
  public TPOptionalParam buildQueueString(int paramInt, String[] paramArrayOfString)
  {
    this.paramType = 5;
    this.key = paramInt;
    this.paramQueueString = new TPOptionalParam.OptionalParamQueueString(this);
    this.paramQueueString.queueValue = paramArrayOfString;
    return this;
  }
  
  public TPOptionalParam buildString(int paramInt, String paramString1)
  {
    this.paramType = 3;
    this.key = paramInt;
    this.paramString = new TPOptionalParam.OptionalParamString(this);
    this.paramString.value = paramString1;
    return this;
  }
  
  public TPOptionalParam buildString(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.paramType = 3;
    this.key = paramInt;
    this.paramString = new TPOptionalParam.OptionalParamString(this);
    this.paramString.value = paramString1;
    this.paramString.param1 = paramString2;
    this.paramString.param2 = paramString3;
    return this;
  }
  
  public int getKey()
  {
    return this.key;
  }
  
  public TPOptionalParam.OptionalParamBoolean getParamBoolean()
  {
    return this.paramBoolean;
  }
  
  public TPOptionalParam.OptionalParamLong getParamLong()
  {
    return this.paramLong;
  }
  
  public TPOptionalParam.OptionalParamQueueInt getParamQueueInt()
  {
    return this.paramQueueInt;
  }
  
  public TPOptionalParam.OptionalParamQueueString getParamQueueString()
  {
    return this.paramQueueString;
  }
  
  public TPOptionalParam.OptionalParamString getParamString()
  {
    return this.paramString;
  }
  
  public int getParamType()
  {
    return this.paramType;
  }
  
  public String toString()
  {
    int j = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    switch (this.paramType)
    {
    default: 
      localStringBuilder.append("type:unkonw");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("type:long, , key:" + this.key + ", value:" + this.paramBoolean.value);
      continue;
      localStringBuilder.append("type:long, , key:" + this.key + ", value:" + this.paramLong.value + "param1, :" + this.paramLong.param1 + ", param2:" + this.paramLong.param2);
      continue;
      localStringBuilder.append("type:string, , key:" + this.key + ", value:" + this.paramString.value + "param1, :" + this.paramString.param1 + ", param2:" + this.paramString.param2);
      continue;
      localStringBuilder.append("type:quint_int, , key:" + this.key + ", value:");
      if (this.paramQueueInt.queueValue != null)
      {
        Object localObject = this.paramQueueInt.queueValue;
        j = localObject.length;
        int k;
        while (i < j)
        {
          k = localObject[i];
          localStringBuilder.append(k + ", ");
          i += 1;
        }
        localStringBuilder.append("type:quint_string, , key:" + this.key + ", value:");
        if (this.paramQueueString.queueValue != null)
        {
          localObject = this.paramQueueString.queueValue;
          k = localObject.length;
          i = j;
          while (i < k)
          {
            String str = localObject[i];
            localStringBuilder.append(str + ", ");
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPOptionalParam
 * JD-Core Version:    0.7.0.1
 */