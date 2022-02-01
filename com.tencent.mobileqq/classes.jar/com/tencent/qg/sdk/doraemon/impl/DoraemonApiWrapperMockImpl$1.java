package com.tencent.qg.sdk.doraemon.impl;

import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.doraemon.MyApiCallback;

class DoraemonApiWrapperMockImpl$1
  implements Runnable
{
  DoraemonApiWrapperMockImpl$1(DoraemonApiWrapperMockImpl paramDoraemonApiWrapperMockImpl, long paramLong, String paramString) {}
  
  public void run()
  {
    MyApiCallback localMyApiCallback = new MyApiCallback(this.val$eJApiCallbackNativePtr);
    try
    {
      Thread.sleep(300L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    String str;
    if (this.val$apiName.equals("login")) {
      str = "{ \"openid\": \"800682574CA1F2FD4A1CE239CB3E2848\", \"access_token\":\"BD41B0EDC379B3B1E32B8D2014B128B7\"}";
    } else if (this.val$apiName.equals("reportScore")) {
      str = "{\n  \"seq\" : 10199941,\n  \"apiName\" : \"reportScore\",\n  \"errorCode\" : 0\n}";
    } else if (this.val$apiName.equals("getRankingList")) {
      str = "{\n    \"apiName\":\"getRankingList\",\n    \"selfRank\":{\n        \"score\":388,\n        \"nickName\":\"peter1234565555555554445225544422355\",\n        \"rank\":1,\n        \"avatarUrl\":\"https://q.qlogo.cn/qqapp/101479478/E46A9FF8CB715932F3B8C90F3BBFB1FC/100\"\n    },\n    \"rankingList\":[\n        {\n            \"score\":388,\n            \"nickName\":\"peter\",\n            \"rank\":1,\n            \"avatarUrl\":\"https://q.qlogo.cn/qqapp/101479478/E46A9FF8CB715932F3B8C90F3BBFB1FC/100\"\n        },\n        {\n            \"score\":388222,\n            \"nickName\":\"peter2\",\n            \"rank\":1,\n            \"avatarUrl\":\"https://q.qlogo.cn/qqapp/101479478/E46A9FF8CB715932F3B8C90F3BBFB1FC/100\"\n        },\n        {\n            \"score\":38118,\n            \"nickName\":\"peter3\",\n            \"rank\":1,\n            \"avatarUrl\":\"https://q.qlogo.cn/qqapp/101479478/E46A9FF8CB715932F3B8C90F3BBFB1FC/100\"\n        },\n        {\n            \"score\":388,\n            \"nickName\":\"andy1234565555555554445225544422355\",\n            \"rank\":1,\n            \"avatarUrl\":\"https://q.qlogo.cn/qqapp/101479478/E46A9FF8CB715932F3B8C90F3BBFB1FC/100\"\n        }\n    ]\n}";
    } else {
      str = "";
    }
    if (this.this$0.mQGGLSurfaceView != null) {
      this.this$0.mQGGLSurfaceView.queueEvent(new DoraemonApiWrapperMockImpl.1.1(this, localMyApiCallback, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.impl.DoraemonApiWrapperMockImpl.1
 * JD-Core Version:    0.7.0.1
 */