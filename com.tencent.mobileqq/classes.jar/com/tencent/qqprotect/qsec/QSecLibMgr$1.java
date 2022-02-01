package com.tencent.qqprotect.qsec;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.util.List;

class QSecLibMgr$1
  implements QSecCbMgr.IControlBitChangeListener
{
  QSecLibMgr$1(QSecLibMgr paramQSecLibMgr) {}
  
  public void a(List<Pair<Integer, Byte>> paramList)
  {
    Message localMessage = QSecLibMgr.a(this.a).obtainMessage(2);
    localMessage.obj = paramList;
    QSecLibMgr.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.1
 * JD-Core Version:    0.7.0.1
 */