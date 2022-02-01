package com.tencent.weseevideo.editor.sticker.model;

import android.os.Bundle;
import com.tencent.tavsticker.model.TAVSticker;

public class TAVStickerExKt
{
  public static String getExtraStickerType(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null) {
      return paramTAVSticker.getExtraBundle().getString("key_extra_sticker_type");
    }
    return null;
  }
  
  public static int getLastStickerTextColr(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null) {
      return paramTAVSticker.getExtraBundle().getInt("key_last_sticker_text_color");
    }
    return -1;
  }
  
  public static String getLastStickerTextContent(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null) {
      return paramTAVSticker.getExtraBundle().getString("key_last_sticker_text_content");
    }
    return null;
  }
  
  public static String getLastStickerTextFont(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null) {
      return paramTAVSticker.getExtraBundle().getString("key_last_sticker_text_font");
    }
    return null;
  }
  
  public static float getSticerScaleMinY(TAVSticker paramTAVSticker)
  {
    return paramTAVSticker.getExtraBundle().getFloat("key_sticker_scale_min_y", 0.0F);
  }
  
  public static float getStickerScaleMaxX(TAVSticker paramTAVSticker)
  {
    return paramTAVSticker.getExtraBundle().getFloat("key_sticker_scale_max_x", 0.0F);
  }
  
  public static float getStickerScaleMaxY(TAVSticker paramTAVSticker)
  {
    return paramTAVSticker.getExtraBundle().getFloat("key_sticker_scale_max_y", 0.0F);
  }
  
  public static float getStickerScaleMinX(TAVSticker paramTAVSticker)
  {
    return paramTAVSticker.getExtraBundle().getFloat("key_sticker_scale_min_x", 0.0F);
  }
  
  public static float getStickerScaleX(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      return 0.0F;
    }
    return paramTAVSticker.getExtraBundle().getFloat("key_sticker_scale_x", 1.0F);
  }
  
  public static float getStickerScaleY(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      return 0.0F;
    }
    return paramTAVSticker.getExtraBundle().getFloat("key_sticker_scale_y", 1.0F);
  }
  
  public static String getStickerTextPngPath(TAVSticker paramTAVSticker)
  {
    return paramTAVSticker.getExtraBundle().getString("key_sticker_text_path");
  }
  
  public static String getStickerTexturePngPath(TAVSticker paramTAVSticker)
  {
    return paramTAVSticker.getExtraBundle().getString("key_sticker_texture_path");
  }
  
  public static boolean isLockRatio(TAVSticker paramTAVSticker)
  {
    return (paramTAVSticker != null) && (paramTAVSticker.getExtraBundle().getBoolean("key_sticker_lock_ratio", true));
  }
  
  public static boolean isRotateEnable(TAVSticker paramTAVSticker)
  {
    return (paramTAVSticker != null) && (paramTAVSticker.getExtraBundle().getBoolean("key_sticker_enable_rotate", true));
  }
  
  public static boolean isStickerCarryTextFromOther(TAVSticker paramTAVSticker)
  {
    Bundle localBundle = paramTAVSticker.getExtraBundle();
    if (!"blur".equals(getExtraStickerType(paramTAVSticker))) {}
    for (boolean bool = true;; bool = false) {
      return localBundle.getBoolean("key_sticker_carry_text_from_others", bool);
    }
  }
  
  public static void markLastStickerTextData(TAVSticker paramTAVSticker, String paramString1, String paramString2, int paramInt)
  {
    if (paramTAVSticker != null)
    {
      paramTAVSticker.getExtraBundle().putString("key_last_sticker_text_font", paramString1);
      paramTAVSticker.getExtraBundle().putString("key_last_sticker_text_content", paramString2);
      paramTAVSticker.getExtraBundle().putInt("key_last_sticker_text_color", paramInt);
    }
  }
  
  public static void setExtraStickerType(TAVSticker paramTAVSticker, String paramString)
  {
    if (paramTAVSticker != null) {
      paramTAVSticker.getExtraBundle().putString("key_extra_sticker_type", paramString);
    }
  }
  
  public static void setStickerCarryTextFromOther(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    paramTAVSticker.getExtraBundle().putBoolean("key_sticker_carry_text_from_others", paramBoolean);
  }
  
  public static void setStickerEnableRotate(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    paramTAVSticker.getExtraBundle().putBoolean("key_sticker_enable_rotate", paramBoolean);
  }
  
  public static void setStickerLockRatio(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    paramTAVSticker.getExtraBundle().putBoolean("key_sticker_lock_ratio", paramBoolean);
  }
  
  public static void setStickerScaleMaxX(TAVSticker paramTAVSticker, float paramFloat)
  {
    paramTAVSticker.getExtraBundle().putFloat("key_sticker_scale_max_x", paramFloat);
  }
  
  public static void setStickerScaleMaxY(TAVSticker paramTAVSticker, float paramFloat)
  {
    paramTAVSticker.getExtraBundle().putFloat("key_sticker_scale_max_y", paramFloat);
  }
  
  public static void setStickerScaleMinX(TAVSticker paramTAVSticker, float paramFloat)
  {
    paramTAVSticker.getExtraBundle().putFloat("key_sticker_scale_min_x", paramFloat);
  }
  
  public static void setStickerScaleMinY(TAVSticker paramTAVSticker, float paramFloat)
  {
    paramTAVSticker.getExtraBundle().putFloat("key_sticker_scale_min_y", paramFloat);
  }
  
  public static void setStickerScaleX(TAVSticker paramTAVSticker, float paramFloat)
  {
    paramTAVSticker.getExtraBundle().putFloat("key_sticker_scale_x", paramFloat);
  }
  
  public static void setStickerScaleY(TAVSticker paramTAVSticker, float paramFloat)
  {
    paramTAVSticker.getExtraBundle().putFloat("key_sticker_scale_y", paramFloat);
  }
  
  public static void setStickerTextPngPath(TAVSticker paramTAVSticker, String paramString)
  {
    paramTAVSticker.getExtraBundle().putString("key_sticker_text_path", paramString);
  }
  
  public static void setStickerTexturePngPath(TAVSticker paramTAVSticker, String paramString)
  {
    paramTAVSticker.getExtraBundle().putString("key_sticker_texture_path", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt
 * JD-Core Version:    0.7.0.1
 */