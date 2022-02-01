package com.tencent.mobileqq.guild.pic.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildPicAIO
  extends QRouteApi
{
  public static final float GUILD_AIO_IMAGE_ROUND_CORNER = 6.0F;
  public static final float GUILD_AIO_VIDEO_ROUND_CORNER = 6.0F;
  public static final String GUILD_PIC_URLDRAWABLE_STUFF = "guildStuff";
  
  public abstract Bitmap getThumbBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public abstract int[] getThumbMaxDp(boolean paramBoolean);
  
  public abstract int[] getThumbMaxPx(boolean paramBoolean);
  
  public abstract int[] getThumbMinDp(boolean paramBoolean);
  
  public abstract int[] getThumbMinPx(boolean paramBoolean);
  
  public abstract int[] getThumbSize(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract ThumbWidthHeightDP getThumbWidthHeightDPForGuildPicMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.pic.api.IGuildPicAIO
 * JD-Core Version:    0.7.0.1
 */