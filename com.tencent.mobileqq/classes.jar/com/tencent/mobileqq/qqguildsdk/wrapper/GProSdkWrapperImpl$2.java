package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$2
  implements IGProGetUserListCallback
{
  GProSdkWrapperImpl$2(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, String paramString, IGetUserListCallback paramIGetUserListCallback) {}
  
  public void onGetUserList(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte, ArrayList<GProUser> paramArrayList1, ArrayList<GProUser> paramArrayList2, ArrayList<GProUser> paramArrayList3)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.2.1(this, paramInt, paramArrayList1, paramArrayList2, paramArrayList3, paramString, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.2
 * JD-Core Version:    0.7.0.1
 */