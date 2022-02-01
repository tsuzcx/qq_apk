package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProChannelMemberInfos;
import com.tencent.gprosdk.IGProFetchAudioChannelUserListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$36
  implements IGProFetchAudioChannelUserListCallback
{
  GProSdkWrapperImpl$36(GProSdkWrapperImpl paramGProSdkWrapperImpl, String paramString, int paramInt, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback) {}
  
  public void onGetAudioChannelUsers(int paramInt, String paramString, ArrayList<GProChannelMemberInfos> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.36.1(this, paramInt, paramString, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.36
 * JD-Core Version:    0.7.0.1
 */