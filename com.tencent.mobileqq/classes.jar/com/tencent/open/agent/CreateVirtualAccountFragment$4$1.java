package com.tencent.open.agent;

import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class CreateVirtualAccountFragment$4$1
  implements QQPermissionCallback
{
  CreateVirtualAccountFragment$4$1(CreateVirtualAccountFragment.4 param4) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a = ProfileActivity.a(this.a.a.getActivity(), 257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.4.1
 * JD-Core Version:    0.7.0.1
 */