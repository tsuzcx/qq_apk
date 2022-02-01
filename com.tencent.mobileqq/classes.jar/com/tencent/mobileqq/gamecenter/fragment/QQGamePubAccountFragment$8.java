package com.tencent.mobileqq.gamecenter.fragment;

import auud;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;

class QQGamePubAccountFragment$8
  implements Runnable
{
  QQGamePubAccountFragment$8(QQGamePubAccountFragment paramQQGamePubAccountFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      synchronized (QQGamePubAccountFragment.a)
      {
        auud.a(localMessageRecord, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.8
 * JD-Core Version:    0.7.0.1
 */