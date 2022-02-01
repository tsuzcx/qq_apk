package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProSearchMemberFromServerCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ISearchMemberFromServerCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$89
  implements IGProSearchMemberFromServerCallback
{
  GProSdkWrapperImpl$89(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ISearchMemberFromServerCallback paramISearchMemberFromServerCallback) {}
  
  public void onMemberSearch(int paramInt, String paramString1, String paramString2, boolean paramBoolean, ArrayList<GProUser> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.89.1(this, paramInt, paramString1, paramBoolean, paramArrayList, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.89
 * JD-Core Version:    0.7.0.1
 */