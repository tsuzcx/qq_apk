package com.tencent.qcircle.shadow.core.runtime.skin.loader;

public class SkinResFactory
{
  public static final String SKIN_THEME_APK_ASSET_DIR = "skinres";
  public static final String SKIN_THEME_APK_SAVE_DIR = "skin";
  public static final int THEMEID_1_DAY = 5;
  public static final int THEMEID_2_NIGHT = 15;
  
  public static SkinPkgInfo createResourceData(int paramInt)
  {
    if (paramInt != 5)
    {
      if (paramInt != 15) {
        return new SkinPkgInfo(5, "");
      }
      return new SkinPkgInfo(paramInt, "blackNight2.skin");
    }
    return new SkinPkgInfo(paramInt, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.skin.loader.SkinResFactory
 * JD-Core Version:    0.7.0.1
 */