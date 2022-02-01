package dov.com.qq.im.ae.camera.ui.topbar;

import android.support.annotation.Nullable;

public enum AEVideoStoryTopBarViewModel$Ratio
{
  FULL(4),  R_1_1(11),  R_4_3(43);
  
  public final int code;
  
  private AEVideoStoryTopBarViewModel$Ratio(int paramInt)
  {
    this.code = paramInt;
  }
  
  @Nullable
  public static Ratio fromCode(int paramInt)
  {
    Ratio[] arrayOfRatio = values();
    int j = arrayOfRatio.length;
    int i = 0;
    while (i < j)
    {
      Ratio localRatio = arrayOfRatio[i];
      if (localRatio.code == paramInt) {
        return localRatio;
      }
      i += 1;
    }
    return null;
  }
  
  public abstract Ratio next();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio
 * JD-Core Version:    0.7.0.1
 */