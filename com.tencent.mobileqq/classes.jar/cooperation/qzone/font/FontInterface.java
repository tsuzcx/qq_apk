package cooperation.qzone.font;

public abstract class FontInterface
{
  public static FontManager.DefaultBarrageEffectInfo getDefaultBarrageEffect(long paramLong)
  {
    return FontManager.getInstance().getDefaultBarrageEffectInfo(paramLong);
  }
  
  public static FontManager.DefaultFontInfo getDefaultFont(long paramLong)
  {
    return FontManager.getInstance().getDefaultFont(paramLong);
  }
  
  public static FontManager.DefaultSuperFontInfo getDefaultSuperFont(long paramLong)
  {
    return FontManager.getInstance().getDefaultSuperFont(paramLong);
  }
  
  public static String getFullTypeFont(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    return FontManager.getInstance().getFullTypeFont(paramInt, paramString1, paramString2, paramFullTypeResult);
  }
  
  public static String getTrueTypeFont(int paramInt, String paramString1, String paramString2, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return getTrueTypeFont(paramInt, paramString1, paramString2, true, paramTrueTypeResult);
  }
  
  public static String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return FontManager.getInstance().getTrueTypeFont(paramInt, paramString1, paramString2, paramBoolean, paramTrueTypeResult);
  }
  
  public static void setDefaultBarrageEffect(long paramLong, FontManager.DefaultBarrageEffectInfo paramDefaultBarrageEffectInfo)
  {
    FontManager.getInstance().setDefaultBarrageEffect(paramLong, paramDefaultBarrageEffectInfo);
  }
  
  public static void setDefaultFont(long paramLong, FontManager.DefaultFontInfo paramDefaultFontInfo)
  {
    FontManager.getInstance().setDefaultFont(paramLong, paramDefaultFontInfo);
  }
  
  public static void setDefaultSuperFont(long paramLong, FontManager.DefaultSuperFontInfo paramDefaultSuperFontInfo)
  {
    FontManager.getInstance().setDefaultSuperFont(paramLong, paramDefaultSuperFontInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.font.FontInterface
 * JD-Core Version:    0.7.0.1
 */