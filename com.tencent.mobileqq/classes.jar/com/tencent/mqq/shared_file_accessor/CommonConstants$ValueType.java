package com.tencent.mqq.shared_file_accessor;

public class CommonConstants$ValueType
{
  public static final int VALUE_TYPE_ENUM_ANY = 0;
  public static final int VALUE_TYPE_ENUM_BOOLEAN = 5;
  public static final int VALUE_TYPE_ENUM_FLOAT = 3;
  public static final int VALUE_TYPE_ENUM_INT = 1;
  public static final int VALUE_TYPE_ENUM_LONG = 2;
  public static final int VALUE_TYPE_ENUM_STRING = 4;
  public static final int VALUE_TYPE_ENUM_STRSET = 6;
  public int mEnumValue = 0;
  public String mTypeName = null;
  
  private CommonConstants$ValueType(int paramInt, String paramString)
  {
    this.mEnumValue = paramInt;
    this.mTypeName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof Integer))
    {
      if (this.mEnumValue == ((Integer)paramObject).intValue()) {
        bool = true;
      }
      return bool;
    }
    if ((paramObject instanceof String)) {
      return this.mTypeName.equals(paramObject);
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return this.mTypeName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.CommonConstants.ValueType
 * JD-Core Version:    0.7.0.1
 */