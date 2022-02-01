package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveRoomInfoCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$69$1
  implements Runnable
{
  GProSdkWrapperImpl$69$1(GProSdkWrapperImpl.69 param69, int paramInt1, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLiveRoomInfoByRoomIds", "", i, str, str, this.f.a);
    this.f.b.a(this.a, this.b, GProConvert.h(this.c), GProConvert.b(this.d), this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.69.1
 * JD-Core Version:    0.7.0.1
 */