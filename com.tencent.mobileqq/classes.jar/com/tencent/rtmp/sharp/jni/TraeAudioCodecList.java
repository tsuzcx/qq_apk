package com.tencent.rtmp.sharp.jni;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioCodecList
{
  private ArrayList<TraeAudioCodecList.CodecInfo> _sessionInfoList = new ArrayList();
  private ReentrantLock mLock = new ReentrantLock();
  
  public TraeAudioCodecList.CodecInfo add(long paramLong)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = find(paramLong);
    if (localCodecInfo != null) {
      return localCodecInfo;
    }
    localCodecInfo = new TraeAudioCodecList.CodecInfo(this);
    localCodecInfo.sessionId = paramLong;
    localCodecInfo.audioDecoder = new AudioDecoder();
    localCodecInfo._tempBufdec = new byte[3840];
    this.mLock.lock();
    this._sessionInfoList.add(localCodecInfo);
    this.mLock.unlock();
    return find(paramLong);
  }
  
  public TraeAudioCodecList.CodecInfo find(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    while (i < this._sessionInfoList.size())
    {
      localCodecInfo = (TraeAudioCodecList.CodecInfo)this._sessionInfoList.get(i);
      if (localCodecInfo.sessionId == paramLong) {
        break label56;
      }
      i += 1;
    }
    TraeAudioCodecList.CodecInfo localCodecInfo = null;
    label56:
    this.mLock.unlock();
    return localCodecInfo;
  }
  
  public void remove(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    while (i < this._sessionInfoList.size())
    {
      if (((TraeAudioCodecList.CodecInfo)this._sessionInfoList.get(i)).sessionId == paramLong)
      {
        this._sessionInfoList.remove(i);
        break;
      }
      i += 1;
    }
    this.mLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioCodecList
 * JD-Core Version:    0.7.0.1
 */