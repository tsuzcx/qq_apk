package com.tencent.mobileqq.emosm.api.impl;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class EmoticonFromGroupDBManagerServiceImpl$1
  implements Handler.Callback
{
  EmoticonFromGroupDBManagerServiceImpl$1(EmoticonFromGroupDBManagerServiceImpl paramEmoticonFromGroupDBManagerServiceImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    this.a.mCanWriteDataToDB = true;
    QLog.i("EmoticonFromGroup_DBManager", 1, "set db tag, mCanWriteDataToDB = true.");
    if (this.a.getAddedEmoCacheDataSize() >= 300) {
      this.a.emoFromGroupDBCacheAdded.clear();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonFromGroupDBManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */