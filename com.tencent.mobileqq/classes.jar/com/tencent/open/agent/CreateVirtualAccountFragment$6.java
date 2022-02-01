package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

class CreateVirtualAccountFragment$6
  extends AuthCallback
{
  CreateVirtualAccountFragment$6(CreateVirtualAccountFragment paramCreateVirtualAccountFragment) {}
  
  public void a(boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt)
  {
    if (this.a.getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "onCreate activity is null");
      return;
    }
    this.a.getActivity().runOnUiThread(new CreateVirtualAccountFragment.6.2(this, paramBoolean, paramCreateVirtualResult, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (this.a.getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "onUploadAvatar activity is null");
      return;
    }
    this.a.getActivity().runOnUiThread(new CreateVirtualAccountFragment.6.1(this, paramBoolean, paramString1, paramString2, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6
 * JD-Core Version:    0.7.0.1
 */