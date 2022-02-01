package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;

public class TPOptionalParam
{
  public static final int TP_OPTIONAL_PARAM_TYPE_BOOLEAN = 1;
  public static final int TP_OPTIONAL_PARAM_TYPE_FLOAT = 6;
  public static final int TP_OPTIONAL_PARAM_TYPE_LONG = 2;
  public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_INT = 4;
  public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_STRING = 5;
  public static final int TP_OPTIONAL_PARAM_TYPE_STRING = 3;
  public static final int TP_OPTIONAL_PARAM_TYPE_UNKNOWN = -1;
  public static final int TP_OPTIONAL_RARAM_TYPE_OBJECT = 7;
  @TPCommonEnum.TPOptionalId
  private int key;
  private TPOptionalParam.OptionalParamBoolean paramBoolean;
  private TPOptionalParam.OptionalParamFloat paramFloat;
  private TPOptionalParam.OptionalParamLong paramLong;
  private TPOptionalParam.OptionalParamObject paramObject;
  private TPOptionalParam.OptionalParamQueueInt paramQueueInt;
  private TPOptionalParam.OptionalParamQueueString paramQueueString;
  private TPOptionalParam.OptionalParamString paramString;
  private int paramType = -1;
  
  public TPOptionalParam buildBoolean(@TPCommonEnum.TPOptionalId int paramInt, boolean paramBoolean1)
  {
    this.paramType = 1;
    this.key = paramInt;
    this.paramBoolean = new TPOptionalParam.OptionalParamBoolean();
    this.paramBoolean.value = paramBoolean1;
    return this;
  }
  
  public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int paramInt, float paramFloat1)
  {
    this.paramType = 6;
    this.key = paramInt;
    this.paramFloat = new TPOptionalParam.OptionalParamFloat();
    this.paramFloat.value = paramFloat1;
    return this;
  }
  
  public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.paramType = 6;
    this.key = paramInt;
    this.paramFloat = new TPOptionalParam.OptionalParamFloat();
    TPOptionalParam.OptionalParamFloat localOptionalParamFloat = this.paramFloat;
    localOptionalParamFloat.value = paramFloat1;
    localOptionalParamFloat.param1 = paramFloat2;
    localOptionalParamFloat.param2 = paramFloat3;
    return this;
  }
  
  public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int paramInt, long paramLong1)
  {
    this.paramType = 2;
    this.key = paramInt;
    this.paramLong = new TPOptionalParam.OptionalParamLong();
    this.paramLong.value = paramLong1;
    return this;
  }
  
  public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.paramType = 2;
    this.key = paramInt;
    this.paramLong = new TPOptionalParam.OptionalParamLong();
    TPOptionalParam.OptionalParamLong localOptionalParamLong = this.paramLong;
    localOptionalParamLong.value = paramLong1;
    localOptionalParamLong.param1 = paramLong2;
    localOptionalParamLong.param2 = paramLong3;
    return this;
  }
  
  public TPOptionalParam buildObject(int paramInt, Object paramObject1)
  {
    this.paramType = 7;
    this.key = paramInt;
    this.paramObject = new TPOptionalParam.OptionalParamObject();
    this.paramObject.objectValue = paramObject1;
    return this;
  }
  
  public TPOptionalParam buildQueueInt(@TPCommonEnum.TPOptionalId int paramInt, int[] paramArrayOfInt)
  {
    this.paramType = 4;
    this.key = paramInt;
    this.paramQueueInt = new TPOptionalParam.OptionalParamQueueInt();
    this.paramQueueInt.queueValue = paramArrayOfInt;
    return this;
  }
  
  public TPOptionalParam buildQueueString(@TPCommonEnum.TPOptionalId int paramInt, String[] paramArrayOfString)
  {
    this.paramType = 5;
    this.key = paramInt;
    this.paramQueueString = new TPOptionalParam.OptionalParamQueueString();
    this.paramQueueString.queueValue = paramArrayOfString;
    return this;
  }
  
  public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int paramInt, String paramString1)
  {
    this.paramType = 3;
    this.key = paramInt;
    this.paramString = new TPOptionalParam.OptionalParamString();
    this.paramString.value = paramString1;
    return this;
  }
  
  public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.paramType = 3;
    this.key = paramInt;
    this.paramString = new TPOptionalParam.OptionalParamString();
    TPOptionalParam.OptionalParamString localOptionalParamString = this.paramString;
    localOptionalParamString.value = paramString1;
    localOptionalParamString.param1 = paramString2;
    localOptionalParamString.param2 = paramString3;
    return this;
  }
  
  @TPCommonEnum.TPOptionalId
  public int getKey()
  {
    return this.key;
  }
  
  public TPOptionalParam.OptionalParamBoolean getParamBoolean()
  {
    return this.paramBoolean;
  }
  
  public TPOptionalParam.OptionalParamFloat getParamFloat()
  {
    return this.paramFloat;
  }
  
  public TPOptionalParam.OptionalParamLong getParamLong()
  {
    return this.paramLong;
  }
  
  public TPOptionalParam.OptionalParamObject getParamObject()
  {
    return this.paramObject;
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
    StringBuilder localStringBuilder = new StringBuilder();
    int k = this.paramType;
    int j = 0;
    int i = 0;
    Object localObject;
    switch (k)
    {
    default: 
      localStringBuilder.append("type:unknown");
      break;
    case 6: 
      localStringBuilder.append("type:float, key:");
      localStringBuilder.append(this.key);
      localStringBuilder.append(", \nname:");
      localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
      localStringBuilder.append(", value:");
      localStringBuilder.append(this.paramFloat.value);
      localStringBuilder.append(", param1:");
      localStringBuilder.append(this.paramFloat.param1);
      localStringBuilder.append(", param2:");
      localStringBuilder.append(this.paramFloat.param2);
      break;
    case 5: 
      localStringBuilder.append("type:quint_string, key:");
      localStringBuilder.append(this.key);
      localStringBuilder.append(", \nname:");
      localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
      localStringBuilder.append(", value:");
      if (this.paramQueueString.queueValue != null)
      {
        localObject = this.paramQueueString.queueValue;
        j = localObject.length;
      }
      break;
    case 4: 
    case 3: 
    case 2: 
    case 1: 
      while (i < j)
      {
        localStringBuilder.append(localObject[i]);
        localStringBuilder.append(", ");
        i += 1;
        continue;
        localStringBuilder.append("type:quint_int, key:");
        localStringBuilder.append(this.key);
        localStringBuilder.append(", \nname:");
        localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
        localStringBuilder.append(", value:");
        if (this.paramQueueInt.queueValue != null)
        {
          localObject = this.paramQueueInt.queueValue;
          k = localObject.length;
          i = j;
          while (i < k)
          {
            localStringBuilder.append(localObject[i]);
            localStringBuilder.append(", ");
            i += 1;
            continue;
            localStringBuilder.append("type:string, key:");
            localStringBuilder.append(this.key);
            localStringBuilder.append(", \nname:");
            localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
            localStringBuilder.append(", value:");
            localStringBuilder.append(this.paramString.value);
            localStringBuilder.append(", param1:");
            localStringBuilder.append(this.paramString.param1);
            localStringBuilder.append(", param2:");
            localStringBuilder.append(this.paramString.param2);
            break;
            localStringBuilder.append("type:long, key:");
            localStringBuilder.append(this.key);
            localStringBuilder.append(", \nname:");
            localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
            localStringBuilder.append(", value:");
            localStringBuilder.append(this.paramLong.value);
            localStringBuilder.append(", param1:");
            localStringBuilder.append(this.paramLong.param1);
            localStringBuilder.append(", param2:");
            localStringBuilder.append(this.paramLong.param2);
            break;
            localStringBuilder.append("type:long, key:");
            localStringBuilder.append(this.key);
            localStringBuilder.append(", \nname:");
            localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
            localStringBuilder.append(", value:");
            localStringBuilder.append(this.paramBoolean.value);
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPOptionalParam
 * JD-Core Version:    0.7.0.1
 */