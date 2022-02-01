package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class RIJEmotionDownloader$EmotionNetLoader$1
  extends ProtoUtils.TroopProtocolObserver
{
  RIJEmotionDownloader$EmotionNetLoader$1(RIJEmotionDownloader.EmotionNetLoader paramEmotionNetLoader) {}
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onError: errorCode=");
    paramBundle.append(paramInt);
    paramBundle.append(" errorMsg=");
    paramBundle.append(paramString);
    QLog.d("RIJEmotionDownloader", 1, paramBundle.toString());
    return true;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      RIJEmotionDownloader.EmotionNetLoader.a(this.a, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("download: fail to download emotion, errorCode=");
    paramArrayOfByte.append(paramInt);
    QLog.d("RIJEmotionDownloader", 1, paramArrayOfByte.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.EmotionNetLoader.1
 * JD-Core Version:    0.7.0.1
 */