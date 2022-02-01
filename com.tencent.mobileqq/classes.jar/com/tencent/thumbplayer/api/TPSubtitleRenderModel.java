package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSubtitleFontStyle;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSubtitleRenderParams;

public class TPSubtitleRenderModel
{
  @TPNativeKeyMap.MapSubtitleFontStyle(1)
  public static final int TP_SUBTITLE_FONT_STYLE_BOLD = 1;
  @TPNativeKeyMap.MapSubtitleRenderParams(2L)
  public static final long TP_SUBTITLE_PARAM_FLAG_CANVAS_HEIGHT = 2L;
  @TPNativeKeyMap.MapSubtitleRenderParams(1L)
  public static final long TP_SUBTITLE_PARAM_FLAG_CANVAS_WIDTH = 1L;
  @TPNativeKeyMap.MapSubtitleRenderParams(256L)
  public static final long TP_SUBTITLE_PARAM_FLAG_END_MARGIN = 256L;
  @TPNativeKeyMap.MapSubtitleRenderParams(8L)
  public static final long TP_SUBTITLE_PARAM_FLAG_FONT_COLOR = 8L;
  @TPNativeKeyMap.MapSubtitleRenderParams(4L)
  public static final long TP_SUBTITLE_PARAM_FLAG_FONT_SIZE = 4L;
  @TPNativeKeyMap.MapSubtitleRenderParams(1024L)
  public static final long TP_SUBTITLE_PARAM_FLAG_FONT_STYLE_BOLD = 1024L;
  @TPNativeKeyMap.MapSubtitleRenderParams(64L)
  public static final long TP_SUBTITLE_PARAM_FLAG_LINE_SPACE = 64L;
  @TPNativeKeyMap.MapSubtitleRenderParams(32L)
  public static final long TP_SUBTITLE_PARAM_FLAG_OUTLINE_COLOR = 32L;
  @TPNativeKeyMap.MapSubtitleRenderParams(16L)
  public static final long TP_SUBTITLE_PARAM_FLAG_OUTLINE_WIDTH = 16L;
  @TPNativeKeyMap.MapSubtitleRenderParams(128L)
  public static final long TP_SUBTITLE_PARAM_FLAG_START_MARGIN = 128L;
  @TPNativeKeyMap.MapSubtitleRenderParams(512L)
  public static final long TP_SUBTITLE_PARAM_FLAG_VERTICAL_MARGIN = 512L;
  public int canvasHeight;
  public int canvasWidth;
  public float endMargin;
  public String familyName;
  public int fontColor;
  public float fontSize;
  public int fontStyleFlags;
  public float lineSpace;
  public int outlineColor;
  public float outlineWidth;
  public long paramFlags;
  public float startMargin;
  public float verticalMargin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPSubtitleRenderModel
 * JD-Core Version:    0.7.0.1
 */