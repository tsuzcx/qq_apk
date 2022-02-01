package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProSearchMemberFromServerCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchVisibleMemberListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$25
  implements IGProSearchMemberFromServerCallback
{
  GProSdkWrapperImpl$25(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ISearchVisibleMemberListCallback paramISearchVisibleMemberListCallback) {}
  
  public void onMemberSearch(int paramInt, String paramString1, String paramString2, boolean paramBoolean, ArrayList<GProUser> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.25.1(this, paramInt, paramString1, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.25
 * JD-Core Version:    0.7.0.1
 */