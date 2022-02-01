package com.tencent.mobileqq.mini.fake;

class FakeSdkReceiver$1
  implements Runnable
{
  FakeSdkReceiver$1(FakeSdkReceiver paramFakeSdkReceiver) {}
  
  public void run()
  {
    FakeSdkBrandUI.initOKHttpClient();
    FakeSdkBrandUI.setCookie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeSdkReceiver.1
 * JD-Core Version:    0.7.0.1
 */