package dov.com.qq.im.aeeditor.manage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AEEditorPagStickerConfig
  implements Serializable
{
  public static final float CONFIG_DEFAULT_ANGLE = 0.0F;
  public static final float CONFIG_DEFAULT_MAX_SCALE = 1.0F;
  public static final float CONFIG_DEFAULT_MIN_SCALE = 0.18F;
  public static final float CONFIG_DEFAULT_SCALE = 0.53F;
  public static final String TYPE_COLOR_TEXT = "color_text";
  public static final String TYPE_FIXED_TEXT = "fixed_text";
  public static final String TYPE_PLAIN_TEXT = "plain_text";
  @SerializedName("frame")
  public AEEditorPagStickerConfig.FrameConfig frameConfig = new AEEditorPagStickerConfig.FrameConfig();
  @SerializedName("style")
  public AEEditorPagStickerConfig.StyleConfig styleConfig;
  @SerializedName("type")
  public String type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig
 * JD-Core Version:    0.7.0.1
 */