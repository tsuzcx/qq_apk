package dov.com.qq.im.aeeditor.module.text;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bofw;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig.FrameConfig;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig.StyleConfig;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import java.io.Serializable;
import org.libpag.PAGFile;
import org.libpag.PAGText;

public class AEEditorTextBean
  implements Serializable
{
  public static final int TYPE_FIXED_COLOR_TEXT_STICKER = 2;
  public static final int TYPE_NORMAL_TEXT_STICKER = 0;
  public static final int TYPE_VARIABLE_COLOR_TEXT_STICKER = 1;
  public int aiColorIndex = -1;
  public float angle = 0.0F;
  @ColorInt
  public int backgroundColor;
  public String content;
  @ColorInt
  public int defaultColor;
  public String fontId;
  public String id;
  public boolean isDownloading;
  public float maxScale = 1.0F;
  public float minScale = 0.18F;
  public String pagFilePath;
  public String pagThumbFilePath;
  public int progress = -1;
  public float scale = 0.53F;
  @ColorInt
  public int textColor;
  @ColorInt
  public int textStrokeColor;
  public String thumbPath;
  public String thumbUrl;
  public int type;
  public boolean usable;
  
  public static AEEditorTextBean createTextBeanByStickerInfo(@NonNull AEEditorPagStickerInfo paramAEEditorPagStickerInfo)
  {
    AEEditorTextBean localAEEditorTextBean = new AEEditorTextBean();
    localAEEditorTextBean.id = paramAEEditorPagStickerInfo.stickerId;
    localAEEditorTextBean.thumbUrl = paramAEEditorPagStickerInfo.thumbUrl;
    localAEEditorTextBean.pagFilePath = bofw.a().e(paramAEEditorPagStickerInfo.stickerId);
    if (paramAEEditorPagStickerInfo.backgroundColorAdjustable == 1)
    {
      localAEEditorTextBean.type = 1;
      localAEEditorTextBean.pagThumbFilePath = bofw.a().f(paramAEEditorPagStickerInfo.stickerId);
    }
    for (;;)
    {
      localAEEditorTextBean.fontId = paramAEEditorPagStickerInfo.fontId;
      return localAEEditorTextBean;
      localAEEditorTextBean.type = 2;
    }
  }
  
  public static AEEditorTextBean updateTextBeanByStickerConfig(@NonNull AEEditorTextBean paramAEEditorTextBean, @NonNull AEEditorPagStickerConfig paramAEEditorPagStickerConfig)
  {
    if (!paramAEEditorTextBean.usable)
    {
      if (paramAEEditorPagStickerConfig.frameConfig != null)
      {
        paramAEEditorTextBean.angle = paramAEEditorPagStickerConfig.frameConfig.angle;
        paramAEEditorTextBean.scale = paramAEEditorPagStickerConfig.frameConfig.scale;
        paramAEEditorTextBean.minScale = paramAEEditorPagStickerConfig.frameConfig.minScale;
        paramAEEditorTextBean.maxScale = paramAEEditorPagStickerConfig.frameConfig.maxScale;
      }
      if (paramAEEditorPagStickerConfig.type != null)
      {
        if (!paramAEEditorPagStickerConfig.type.equals("plain_text")) {
          break label215;
        }
        paramAEEditorTextBean.type = 0;
      }
      PAGFile localPAGFile = PAGFile.Load(paramAEEditorTextBean.pagFilePath);
      if ((localPAGFile != null) && (localPAGFile.numTexts() > 0))
      {
        paramAEEditorTextBean.content = localPAGFile.getTextData(0).text;
        paramAEEditorTextBean.textColor = localPAGFile.getTextData(0).fillColor;
      }
      if (paramAEEditorPagStickerConfig.styleConfig != null) {
        if (!TextUtils.isEmpty(paramAEEditorPagStickerConfig.styleConfig.defaultColor))
        {
          paramAEEditorTextBean.defaultColor = Color.parseColor(paramAEEditorPagStickerConfig.styleConfig.defaultColor);
          switch (paramAEEditorTextBean.type)
          {
          }
        }
      }
    }
    for (;;)
    {
      if (paramAEEditorPagStickerConfig.styleConfig.colorIndex != null) {
        paramAEEditorTextBean.aiColorIndex = paramAEEditorPagStickerConfig.styleConfig.colorIndex.intValue();
      }
      paramAEEditorTextBean.usable = true;
      return paramAEEditorTextBean;
      label215:
      if (paramAEEditorPagStickerConfig.type.equals("color_text"))
      {
        paramAEEditorTextBean.type = 1;
        break;
      }
      paramAEEditorTextBean.type = 2;
      break;
      paramAEEditorTextBean.textColor = paramAEEditorTextBean.defaultColor;
      continue;
      paramAEEditorTextBean.backgroundColor = paramAEEditorTextBean.defaultColor;
      if (paramAEEditorTextBean.backgroundColor != -1) {
        paramAEEditorTextBean.textColor = -1;
      } else {
        paramAEEditorTextBean.textColor = AEEditorColorSelectorView.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextBean
 * JD-Core Version:    0.7.0.1
 */