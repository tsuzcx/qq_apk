package com.tencent.mobileqq.richmediabrowser.api.impl;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.net.URL;
import mqq.os.MqqHandler;

public class ShortVideoDependImpl
  implements IShortVideoDepend
{
  public String getLocalShortVideoPath()
  {
    return ShortVideoUtils.getLocalShortVideoPath();
  }
  
  public String getShortVideoSavePath(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return SVUtils.a((MessageForShortVideo)paramMessageRecord, paramString);
    }
    return null;
  }
  
  public URL getThumbUrl(String paramString)
  {
    return ShortVideoUtils.getThumbUrl(paramString);
  }
  
  public Runnable getVideoFileSaveRunnable(String paramString1, MqqHandler paramMqqHandler, String paramString2, boolean paramBoolean)
  {
    return new ShortVideoUtils.VideoFileSaveRunnable(paramString1, paramMqqHandler, paramString2, paramBoolean);
  }
  
  public int getVideoSaveFailCode()
  {
    return 1;
  }
  
  public int getVideoSaveSuccessCode()
  {
    return 2;
  }
  
  public boolean isAEPituTakeSameOpen()
  {
    return ShortVideoUtils.isAEPituTakeSameOpen();
  }
  
  public void reportVideoPlayEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    ShortVideoUtils.reportVideoPlayEvent(null, paramInt1, paramString, paramInt2, paramInt3, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.ShortVideoDependImpl
 * JD-Core Version:    0.7.0.1
 */