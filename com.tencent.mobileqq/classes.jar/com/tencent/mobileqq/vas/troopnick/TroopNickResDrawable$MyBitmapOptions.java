package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.vas.utils.CacheHelper.AbsOptions;
import org.jetbrains.annotations.NotNull;

class TroopNickResDrawable$MyBitmapOptions
  extends CacheHelper.AbsOptions
{
  private final String a;
  
  public TroopNickResDrawable$MyBitmapOptions(String paramString)
  {
    this.a = paramString;
  }
  
  @NotNull
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopnickname");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public Object b()
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(this.a);
    if (localBitmap != null) {
      return localBitmap;
    }
    return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable.MyBitmapOptions
 * JD-Core Version:    0.7.0.1
 */