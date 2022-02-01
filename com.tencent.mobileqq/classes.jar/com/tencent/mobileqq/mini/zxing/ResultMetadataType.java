package com.tencent.mobileqq.mini.zxing;

public class ResultMetadataType
{
  public static final ResultMetadataType BYTE_SEGMENTS;
  public static final ResultMetadataType ERROR_CORRECTION_LEVEL;
  public static final ResultMetadataType ISSUE_NUMBER;
  public static final ResultMetadataType ORIENTATION;
  public static final ResultMetadataType OTHER = new ResultMetadataType("OTHER");
  public static final ResultMetadataType PDF417_EXTRA_METADATA;
  public static final ResultMetadataType POSSIBLE_COUNTRY;
  public static final ResultMetadataType STRUCTURED_APPEND_PARITY = new ResultMetadataType("STRUCTURED_APPEND_PARITY");
  public static final ResultMetadataType STRUCTURED_APPEND_SEQUENCE;
  public static final ResultMetadataType SUGGESTED_PRICE;
  public static final ResultMetadataType UPC_EAN_EXTENSION;
  public final String type;
  
  static
  {
    ORIENTATION = new ResultMetadataType("ORIENTATION");
    BYTE_SEGMENTS = new ResultMetadataType("BYTE_SEGMENTS");
    ERROR_CORRECTION_LEVEL = new ResultMetadataType("ERROR_CORRECTION_LEVEL");
    ISSUE_NUMBER = new ResultMetadataType("ISSUE_NUMBER");
    SUGGESTED_PRICE = new ResultMetadataType("SUGGESTED_PRICE");
    POSSIBLE_COUNTRY = new ResultMetadataType("POSSIBLE_COUNTRY");
    UPC_EAN_EXTENSION = new ResultMetadataType("UPC_EAN_EXTENSION");
    PDF417_EXTRA_METADATA = new ResultMetadataType("PDF417_EXTRA_METADATA");
    STRUCTURED_APPEND_SEQUENCE = new ResultMetadataType("STRUCTURED_APPEND_SEQUENCE");
  }
  
  private ResultMetadataType(String paramString)
  {
    this.type = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (ResultMetadataType)paramObject;
      return this.type.equals(paramObject.type);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.type.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResultMetadataType{type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.ResultMetadataType
 * JD-Core Version:    0.7.0.1
 */