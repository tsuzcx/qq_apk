package com.tencent.open.agent;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import mqq.app.QQPermissionCallback;

class CreateVirtualAccountFragment$4$1
  implements QQPermissionCallback
{
  CreateVirtualAccountFragment$4$1(CreateVirtualAccountFragment.4 param4) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a.getQBaseActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CreateVirtualAccountFragment.a(this.a.a, QQLiteStatusUtil.a(this.a.a.getActivity()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.4.1
 * JD-Core Version:    0.7.0.1
 */