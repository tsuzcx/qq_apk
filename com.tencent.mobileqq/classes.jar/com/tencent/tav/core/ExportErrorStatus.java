package com.tencent.tav.core;

import android.support.annotation.Nullable;

public class ExportErrorStatus
{
  public static final int APPEND_BUFFER = -110;
  public static final int APPEND_VIDEO_SAMPLE_MAKE_CURRENT = -111;
  public static final int APPEND_VIDEO_SAMPLE_SWAP_BUFFERS = -113;
  public static final int END_WRITE_AUDIO_SAMPLE = -124;
  public static final int END_WRITE_VIDEO_SAMPLE = -123;
  public static final int ERROR_CODE_AUDIO_EXPORTING = -15;
  public static final int ERROR_CODE_VIDEO_EXPORTING = -14;
  public static final int ERROR_FINISHING = -10;
  public static final int EXPORT_CANCEL = -11;
  public static final int RENDER_SAMPLE_BUFFER = -112;
  public static final int WRITE_AUDIO_SAMPLE = -122;
  public static final int WRITE_VIDEO_SAMPLE = -121;
  public int code;
  @Nullable
  public Throwable throwable;
  
  public ExportErrorStatus(int paramInt)
  {
    this(paramInt, null);
  }
  
  public ExportErrorStatus(int paramInt, @Nullable Throwable paramThrowable)
  {
    this.code = paramInt;
    this.throwable = paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.ExportErrorStatus
 * JD-Core Version:    0.7.0.1
 */