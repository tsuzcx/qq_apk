package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.gprosdk.GProChannelMemberInfos;
import com.tencent.gprosdk.IGProFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAudioChannelMemberInfosListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import java.util.ArrayList;

class GPSAsynManagerEngine$31
  implements IGProFetchAudioChannelUserListCallback
{
  GPSAsynManagerEngine$31(GPSAsynManagerEngine paramGPSAsynManagerEngine, IGetAudioChannelMemberInfosListCallback paramIGetAudioChannelMemberInfosListCallback, String paramString) {}
  
  public void onGetAudioChannelUsers(int paramInt, String paramString, ArrayList<GProChannelMemberInfos> paramArrayList)
  {
    IGetAudioChannelMemberInfosListCallback localIGetAudioChannelMemberInfosListCallback = this.a;
    if (paramArrayList != null) {
      paramArrayList = new ArrayList(GProConvert.a(this.b, paramArrayList));
    } else {
      paramArrayList = null;
    }
    localIGetAudioChannelMemberInfosListCallback.a(paramInt, paramString, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.31
 * JD-Core Version:    0.7.0.1
 */