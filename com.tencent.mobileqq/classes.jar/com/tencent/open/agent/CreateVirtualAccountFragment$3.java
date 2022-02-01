package com.tencent.open.agent;

import com.tencent.open.agent.auth.IVirtualCreatorContract.Presenter;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.SSOLog;

class CreateVirtualAccountFragment$3
  implements Runnable
{
  CreateVirtualAccountFragment$3(CreateVirtualAccountFragment paramCreateVirtualAccountFragment, String paramString) {}
  
  public void run()
  {
    String str = QQLiteStatusUtil.a(CreateVirtualAccountFragment.a(this.this$0));
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "uploadAvatar appId=", this.a });
    CreateVirtualAccountFragment.b(this.this$0).a(this.a, CreateVirtualAccountFragment.a(this.this$0), QQLiteStatusUtil.a(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.3
 * JD-Core Version:    0.7.0.1
 */