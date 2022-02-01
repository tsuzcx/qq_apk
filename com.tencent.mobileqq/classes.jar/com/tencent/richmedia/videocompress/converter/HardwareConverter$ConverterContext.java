package com.tencent.richmedia.videocompress.converter;

import android.media.MediaFormat;

class HardwareConverter$ConverterContext
{
  private int decodeTimeOutCount;
  private long firstFrameTimestamp = -1L;
  private long lastAudioWriteTimestamp;
  private long lastVideoWriteTimestamp;
  private MediaFormat outputAudioFormat;
  private int outputAudioTrack = -1;
  private MediaFormat outputVideoFormat;
  private int outputVideoTrack = -1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.converter.HardwareConverter.ConverterContext
 * JD-Core Version:    0.7.0.1
 */