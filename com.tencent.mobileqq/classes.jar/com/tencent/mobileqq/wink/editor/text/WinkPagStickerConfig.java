package com.tencent.mobileqq.wink.editor.text;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WinkPagStickerConfig
  implements Serializable
{
  public static final float CONFIG_DEFAULT_ANGLE = 0.0F;
  public static final float CONFIG_DEFAULT_MAX_SCALE = 1.0F;
  public static final float CONFIG_DEFAULT_MIN_SCALE = 0.18F;
  public static final float CONFIG_DEFAULT_SCALE = 0.5F;
  public static final String TYPE_BLUR = "blur";
  public static final String TYPE_COLOR_TEXT = "color_text";
  public static final String TYPE_FIXED_TEXT = "fixed_text";
  public static final String TYPE_PLAIN_TEXT = "plain_text";
  @SerializedName("frame")
  public WinkPagStickerConfig.FrameConfig frameConfig = new WinkPagStickerConfig.FrameConfig();
  @SerializedName("style")
  public WinkPagStickerConfig.StyleConfig styleConfig;
  @SerializedName("type")
  public String type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.WinkPagStickerConfig
 * JD-Core Version:    0.7.0.1
 */