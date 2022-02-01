package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProResult;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$39
  implements IGProKickChannelMemberCallback
{
  GProSdkWrapperImpl$39(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IKickChannelMemberCallback paramIKickChannelMemberCallback) {}
  
  public void onKickChannelMembers(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, ArrayList<GProResult> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.39.1(this, paramInt, paramString, paramGProSecurityResult, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.39
 * JD-Core Version:    0.7.0.1
 */