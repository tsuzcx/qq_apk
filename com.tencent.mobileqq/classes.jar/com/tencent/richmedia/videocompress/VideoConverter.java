package com.tencent.richmedia.videocompress;

import android.content.Context;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import com.tencent.richmedia.videocompress.utils.Logger;
import java.util.List;

public class VideoConverter
{
  private VideoConverterImpl convertImpl = new VideoConverterImpl();
  
  public VideoConverter() {}
  
  public VideoConverter(Logger paramLogger)
  {
    ConvertLog.setLogger(paramLogger);
  }
  
  public boolean cancelCompress()
  {
    return this.convertImpl.cancel();
  }
  
  public int executeFFmpegCmd(List<String> paramList)
  {
    return this.convertImpl.executeFFmpegCmd(paramList);
  }
  
  public void setCompressMode(int paramInt)
  {
    this.convertImpl.setCompressMode(paramInt);
  }
  
  public void setFFmpegBinAndSoPath(String paramString1, String paramString2)
  {
    this.convertImpl.setFFmpegBinAndSoPath(paramString1, paramString2);
  }
  
  public int startCompress(Context paramContext, String paramString, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    return this.convertImpl.start(paramContext, paramString, paramProcessor, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.VideoConverter
 * JD-Core Version:    0.7.0.1
 */