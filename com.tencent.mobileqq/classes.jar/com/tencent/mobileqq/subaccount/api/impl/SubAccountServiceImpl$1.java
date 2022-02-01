package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.data.SubAccountInfo;

class SubAccountServiceImpl$1
  implements Runnable
{
  SubAccountServiceImpl$1(SubAccountServiceImpl paramSubAccountServiceImpl, SubAccountInfo paramSubAccountInfo) {}
  
  public void run()
  {
    SubAccountInfo localSubAccountInfo = this.a;
    if (localSubAccountInfo != null) {
      this.this$0.updateEntity(localSubAccountInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */