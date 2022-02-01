package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QCircleMsgProcessor$QCircleMsgTask$1
  implements VSDispatchObserver.onVSRspCallBack
{
  QCircleMsgProcessor$QCircleMsgTask$1(QCircleMsgProcessor.QCircleMsgTask paramQCircleMsgTask) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new QCircleMsgProcessor.QCircleMsgTask.1.1(this, paramBoolean, paramObject, paramLong, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor.QCircleMsgTask.1
 * JD-Core Version:    0.7.0.1
 */