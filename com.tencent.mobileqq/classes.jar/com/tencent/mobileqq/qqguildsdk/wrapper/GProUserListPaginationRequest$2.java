package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProLoadNextPageMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback;
import java.util.ArrayList;

class GProUserListPaginationRequest$2
  implements IGProLoadNextPageMemberListCallback
{
  GProUserListPaginationRequest$2(GProUserListPaginationRequest paramGProUserListPaginationRequest, String paramString, IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback) {}
  
  public void onGetMemberList(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte, ArrayList<GProUser> paramArrayList1, ArrayList<GProUser> paramArrayList2, ArrayList<GProUser> paramArrayList3)
  {
    GProUserListPaginationRequest.a(this.c, this.a, paramInt, paramString, paramBoolean2, paramArrayOfByte, paramArrayList1, paramArrayList2, paramArrayList3, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListPaginationRequest.2
 * JD-Core Version:    0.7.0.1
 */