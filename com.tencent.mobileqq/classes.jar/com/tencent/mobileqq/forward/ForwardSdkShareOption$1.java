package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class ForwardSdkShareOption$1
  implements ForwardD55Manager.D55ResultListener
{
  ForwardSdkShareOption$1(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void a()
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> mD55ResultListener onResult");
    ((ForwardSdkStatusManager)this.a.a.getManager(QQManagerFactory.SDK_SHARE)).a().a(null);
    this.a.A();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.1
 * JD-Core Version:    0.7.0.1
 */