package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleState;

public class ExportErrorStatus
{
  public static final int APPEND_BUFFER = -110;
  public static final int APPEND_VIDEO_SAMPLE_MAKE_CURRENT = -111;
  public static final int APPEND_VIDEO_SAMPLE_SWAP_BUFFERS = -113;
  public static final int AUDIO_CONFIGURE = -104;
  public static final int END_WRITE_AUDIO_SAMPLE = -124;
  public static final int END_WRITE_VIDEO_SAMPLE = -123;
  public static final int ERROR_CODE_AUDIO_EXPORTING = -15;
  public static final int ERROR_CODE_VIDEO_EXPORTING = -14;
  public static final int ERROR_FINISHING = -10;
  public static final int EXPORT_CANCEL = -11;
  public static final int RENDER_SAMPLE_BUFFER = -112;
  public static final int START_AUDIO_ENCODER = -102;
  public static final int START_VIDEO_ENCODER = -101;
  public static final int VIDEO_CONFIGURE = -103;
  public static final int WRITE_AUDIO_SAMPLE = -122;
  public static final int WRITE_VIDEO_SAMPLE = -121;
  public static final int WRITE_VIDEO_SAMPLE_ERROR_INSUFFICIENT_RESOURCE = -1211100;
  public static final int WRITE_VIDEO_SAMPLE_ERROR_RECLAIMED = -1211101;
  public int code;
  @Nullable
  public String msg;
  @Nullable
  public Throwable throwable;
  
  public ExportErrorStatus(int paramInt)
  {
    this(paramInt, null);
  }
  
  public ExportErrorStatus(int paramInt, @Nullable Throwable paramThrowable)
  {
    this(paramInt, paramThrowable, null);
  }
  
  public ExportErrorStatus(int paramInt, @Nullable Throwable paramThrowable, String paramString)
  {
    this.code = paramInt;
    this.throwable = paramThrowable;
    this.msg = paramString;
  }
  
  public ExportErrorStatus(@NonNull CMSampleState paramCMSampleState)
  {
    this((int)paramCMSampleState.getStateCode(), paramCMSampleState.getThrowable(), paramCMSampleState.getMsg());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.ExportErrorStatus
 * JD-Core Version:    0.7.0.1
 */