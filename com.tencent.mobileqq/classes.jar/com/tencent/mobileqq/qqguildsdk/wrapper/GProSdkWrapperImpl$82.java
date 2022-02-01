package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProRole;
import com.tencent.gprosdk.IGProGetAppRoleList;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$82
  implements IGProGetAppRoleList
{
  GProSdkWrapperImpl$82(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IGetAppRoleListCallback paramIGetAppRoleListCallback) {}
  
  public void onGetAppRoleList(int paramInt1, String paramString1, int paramInt2, ArrayList<GProRole> paramArrayList, String paramString2, String paramString3)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.82.1(this, paramInt1, paramString1, paramInt2, paramArrayList, paramString2, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.82
 * JD-Core Version:    0.7.0.1
 */