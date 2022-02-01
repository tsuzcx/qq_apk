package com.tencent.mobileqq.identification;

import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class RequestHelper$1
  implements EIPCResultCallback
{
  RequestHelper$1(RequestHelper paramRequestHelper) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    RequestHelper.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      RequestHelper.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    RequestHelper.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.RequestHelper.1
 * JD-Core Version:    0.7.0.1
 */