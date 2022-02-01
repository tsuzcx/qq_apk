package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMTime;
import java.util.concurrent.CountDownLatch;

class DecoderFrameMsg
{
  final CountDownLatch finishWait;
  final CMTime time;
  
  DecoderFrameMsg(CMTime paramCMTime, CountDownLatch paramCountDownLatch)
  {
    this.time = paramCMTime;
    this.finishWait = paramCountDownLatch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.DecoderFrameMsg
 * JD-Core Version:    0.7.0.1
 */