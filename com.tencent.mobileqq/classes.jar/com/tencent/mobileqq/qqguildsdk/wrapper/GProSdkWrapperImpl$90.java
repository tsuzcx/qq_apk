package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProLoadAllMemberListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$90
  implements IGProLoadAllMemberListCallback
{
  public void onLoadAllMemberList(int paramInt, String paramString, boolean paramBoolean, ArrayList<GProUser> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.90.1(this, paramInt, paramString, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.90
 * JD-Core Version:    0.7.0.1
 */