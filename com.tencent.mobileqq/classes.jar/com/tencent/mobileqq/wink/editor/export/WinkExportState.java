package com.tencent.mobileqq.wink.editor.export;

import android.support.annotation.NonNull;

public class WinkExportState
{
  public static final WinkExportState a = new WinkExportState("EXTRACT_COVER_STARTED");
  public static final WinkExportState b = new WinkExportState("EXTRACT_COVER_SUCCESS");
  public static final WinkExportState c = new WinkExportState("EXTRACT_COVER_FAIL");
  public static final WinkExportState d = new WinkExportState("EXPORT_STARTED");
  public static final WinkExportState e = new WinkExportState("EXPORT_SUCCESS");
  public static final WinkExportState f = new WinkExportState("EXPORT_FAIL");
  public static final WinkExportState g = new WinkExportState("EXPORT_IMAGE");
  public static final WinkExportState[] h = { a, b, c, d, e, f, g };
  public final String i;
  
  private WinkExportState(@NonNull String paramString)
  {
    this.i = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.export.WinkExportState
 * JD-Core Version:    0.7.0.1
 */