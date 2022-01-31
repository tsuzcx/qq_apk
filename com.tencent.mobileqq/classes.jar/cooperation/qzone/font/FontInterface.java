package cooperation.qzone.font;

public abstract class FontInterface
{
  public static FontManager.DefaultBarrageEffectInfo a(long paramLong)
  {
    return FontManager.a().a(paramLong);
  }
  
  public static FontManager.DefaultFontInfo a(long paramLong)
  {
    return FontManager.a().a(paramLong);
  }
  
  public static FontManager.DefaultSuperFontInfo a(long paramLong)
  {
    return FontManager.a().a(paramLong);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    return FontManager.a().a(paramInt, paramString1, paramString2, paramFullTypeResult);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return a(paramInt, paramString1, paramString2, true, paramTrueTypeResult);
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return FontManager.a().a(paramInt, paramString1, paramString2, paramBoolean, paramTrueTypeResult);
  }
  
  public static void a(long paramLong, FontManager.DefaultBarrageEffectInfo paramDefaultBarrageEffectInfo)
  {
    FontManager.a().a(paramLong, paramDefaultBarrageEffectInfo);
  }
  
  public static void a(long paramLong, FontManager.DefaultFontInfo paramDefaultFontInfo)
  {
    FontManager.a().a(paramLong, paramDefaultFontInfo);
  }
  
  public static void a(long paramLong, FontManager.DefaultSuperFontInfo paramDefaultSuperFontInfo)
  {
    FontManager.a().a(paramLong, paramDefaultSuperFontInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.font.FontInterface
 * JD-Core Version:    0.7.0.1
 */