package com.tencent.ttpic.recorder;

import com.tencent.ttpic.util.VideoPrefsUtil;

public class VideoDecoderManager
{
  public static final int MAX_HARD_DECODER_COUNT = 6;
  private static VideoDecoderManager instance = new VideoDecoderManager();
  private int mHardwareDecoderCount = 0;
  
  public static VideoDecoderManager getInstance()
  {
    return instance;
  }
  
  public IVideoDecoder createDecoder(String paramString, int paramInt, DECODE_TYPE paramDECODE_TYPE)
  {
    if (paramDECODE_TYPE == DECODE_TYPE.SOFTWARE) {
      return createSoftwareDecoder(paramString, paramInt);
    }
    try
    {
      paramDECODE_TYPE = new HardwareDecoder(paramString, paramInt);
      return paramDECODE_TYPE;
    }
    catch (Exception paramDECODE_TYPE)
    {
      paramString = new SoftwareDecoder(paramString, paramInt);
      VideoPrefsUtil.setUseHardWareDecoder(false);
    }
    return paramString;
  }
  
  public IVideoDecoder createSoftwareDecoder(String paramString, int paramInt)
  {
    return new SoftwareDecoder(paramString, paramInt);
  }
  
  public void notifyDecodeError()
  {
    VideoPrefsUtil.setUseHardWareDecoder(false);
  }
  
  public void releaseDecoder(IVideoDecoder paramIVideoDecoder)
  {
    if (paramIVideoDecoder != null) {
      paramIVideoDecoder.release();
    }
  }
  
  public static enum DECODE_TYPE
  {
    HARDWARE,  SOFTWARE;
    
    private DECODE_TYPE() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.VideoDecoderManager
 * JD-Core Version:    0.7.0.1
 */