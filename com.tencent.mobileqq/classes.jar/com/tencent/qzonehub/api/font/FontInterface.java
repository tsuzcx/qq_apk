package com.tencent.qzonehub.api.font;

public abstract class FontInterface
{
  public static String a(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    return FontManager.a().a(paramInt, paramString1, paramString2, paramFullTypeResult);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return FontManager.a().a(paramInt, paramString1, paramString2, paramBoolean, paramTrueTypeResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.font.FontInterface
 * JD-Core Version:    0.7.0.1
 */