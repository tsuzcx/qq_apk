package com.tencent.mobileqq.mini.zxing;

public class BarcodeFormat
{
  public static final BarcodeFormat CODABAR = new BarcodeFormat("CODABAR");
  public static final BarcodeFormat CODE_128;
  public static final BarcodeFormat CODE_39 = new BarcodeFormat("CODE_39");
  public static final BarcodeFormat CODE_93 = new BarcodeFormat("CODE_93");
  public static final BarcodeFormat EAN_13 = new BarcodeFormat("EAN_13");
  public static final BarcodeFormat EAN_8;
  public static final BarcodeFormat ITF = new BarcodeFormat("ITF");
  public static final BarcodeFormat UPC_A = new BarcodeFormat("UPC_A");
  public static final BarcodeFormat UPC_E = new BarcodeFormat("UPC_E");
  public static final BarcodeFormat UPC_EAN_EXTENSION = new BarcodeFormat("UPC_EAN_EXTENSION");
  public final String type;
  
  static
  {
    CODE_128 = new BarcodeFormat("CODE_128");
    EAN_8 = new BarcodeFormat("EAN_8");
  }
  
  private BarcodeFormat(String paramString)
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
      paramObject = (BarcodeFormat)paramObject;
      return this.type.equals(paramObject.type);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.type.hashCode();
  }
  
  public String name()
  {
    return this.type;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BarcodeFormat{type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.BarcodeFormat
 * JD-Core Version:    0.7.0.1
 */