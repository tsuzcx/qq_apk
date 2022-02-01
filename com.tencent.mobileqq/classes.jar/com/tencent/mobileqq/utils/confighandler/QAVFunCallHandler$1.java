package com.tencent.mobileqq.utils.confighandler;

import com.tencent.common.app.AppInterface;

class QAVFunCallHandler$1
  implements NormalConfigHandler.GetConfigListen<QAVFunCallConfig>
{
  QAVFunCallHandler$1(QAVFunCallHandler paramQAVFunCallHandler) {}
  
  public void a(AppInterface paramAppInterface, QAVFunCallConfig paramQAVFunCallConfig)
  {
    this.a.setConfig(paramQAVFunCallConfig);
    this.a.onGetConfig(paramAppInterface);
    QAVFunCallHandler.access$000(this.a, "onGetConfig", paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler.1
 * JD-Core Version:    0.7.0.1
 */