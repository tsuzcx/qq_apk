package com.tencent.mobileqq.vas.wallpaper;

public class VipWallpaperService$WallpaperConfig
{
  public final String a;
  public final String b;
  @Deprecated
  public final String c;
  
  public VipWallpaperService$WallpaperConfig()
  {
    this.a = "0";
    this.b = "";
    this.c = "";
  }
  
  public VipWallpaperService$WallpaperConfig(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (WallpaperConfig)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public String toString()
  {
    return "WallpaperConfig{itemId='" + this.a + '\'' + ", imgPath='" + this.b + '\'' + ", videoPath='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.VipWallpaperService.WallpaperConfig
 * JD-Core Version:    0.7.0.1
 */