package com.tencent.open.adapter;

import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.open.downloadnew.common.NoticeParam;

final class OpenAppClient$1
  implements Runnable
{
  public void run()
  {
    NoticeParam localNoticeParam = new NoticeParam();
    localNoticeParam.a = this.a;
    localNoticeParam.b = this.b;
    localNoticeParam.d = this.c;
    localNoticeParam.h = this.d;
    localNoticeParam.c = "";
    localNoticeParam.e = this.e;
    localNoticeParam.g = 4;
    localNoticeParam.j = IntentFactory.a(this.f, this.g, this.h);
    AppNotificationManager.a().a(localNoticeParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.1
 * JD-Core Version:    0.7.0.1
 */