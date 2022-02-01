package dov.com.qq.im.aeeditor.module.text;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bmkn;
import com.tencent.mobileqq.utils.StringUtil;
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
  public static final int TYPE_BLUR_STICKER = 3;
  public static final int TYPE_FIXED_COLOR_TEXT_STICKER = 2;
  public static final int TYPE_NORMAL_TEXT_STICKER = 0;
  public static final int TYPE_VARIABLE_COLOR_TEXT_STICKER = 1;
  public int aiColorIndex = -1;
  public float angle = 0.0F;
  @ColorInt
  public int backgroundColor;
  public String blurTextPath;
  public String blurTexturePath;
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
    localAEEditorTextBean.pagFilePath = bmkn.a().e(paramAEEditorPagStickerInfo.stickerId);
    if (paramAEEditorPagStickerInfo.backgroundColorAdjustable == 1)
    {
      localAEEditorTextBean.type = 1;
      localAEEditorTextBean.pagThumbFilePath = bmkn.a().h(paramAEEditorPagStickerInfo.stickerId);
    }
    for (;;)
    {
      localAEEditorTextBean.fontId = paramAEEditorPagStickerInfo.fontId;
      return localAEEditorTextBean;
      if ("blur".equals(paramAEEditorPagStickerInfo.stickerId))
      {
        localAEEditorTextBean.type = 3;
        localAEEditorTextBean.blurTextPath = bmkn.a().f(paramAEEditorPagStickerInfo.stickerId);
        localAEEditorTextBean.blurTexturePath = bmkn.a().g(paramAEEditorPagStickerInfo.stickerId);
      }
      else
      {
        localAEEditorTextBean.type = 2;
      }
    }
  }
  
  public static int stickerConfigType2TextBeanType(AEEditorPagStickerConfig paramAEEditorPagStickerConfig)
  {
    if ((paramAEEditorPagStickerConfig == null) || (StringUtil.isEmpty(paramAEEditorPagStickerConfig.type))) {
      return -1;
    }
    if (paramAEEditorPagStickerConfig.type.equals("plain_text")) {
      return 0;
    }
    if (paramAEEditorPagStickerConfig.type.equals("color_text")) {
      return 1;
    }
    if (paramAEEditorPagStickerConfig.type.equals("blur")) {
      return 3;
    }
    return 2;
  }
  
  public static String textBeanType2stickerConfigType(AEEditorTextBean paramAEEditorTextBean)
  {
    if (paramAEEditorTextBean == null) {
      return "";
    }
    if (paramAEEditorTextBean.type == 0) {
      return "plain_text";
    }
    if (paramAEEditorTextBean.type == 1) {
      return "color_text";
    }
    if (paramAEEditorTextBean.type == 3) {
      return "blur";
    }
    return "fixed_text";
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
      paramAEEditorTextBean.type = stickerConfigType2TextBeanType(paramAEEditorPagStickerConfig);
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