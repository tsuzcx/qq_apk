package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import mqq.os.MqqHandler;

class QQViewBridgeImpl$GifUi$1
  implements PublicAccountGifListener
{
  QQViewBridgeImpl$GifUi$1(QQViewBridgeImpl.GifUi paramGifUi) {}
  
  public void a(HotPicData paramHotPicData)
  {
    this.a.a = paramHotPicData;
    ThreadManager.getUIHandler().post(new QQViewBridgeImpl.GifUi.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.GifUi.1
 * JD-Core Version:    0.7.0.1
 */