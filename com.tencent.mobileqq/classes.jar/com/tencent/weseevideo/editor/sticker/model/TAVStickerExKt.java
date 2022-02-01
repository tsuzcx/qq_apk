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
  
  public static void setExtraStickerType(TAVSticker paramTAVSticker, String paramString)
  {
    if (paramTAVSticker != null) {
      paramTAVSticker.getExtraBundle().putString("key_extra_sticker_type", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt
 * JD-Core Version:    0.7.0.1
 */