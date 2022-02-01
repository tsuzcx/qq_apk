package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.messageexpose.OnAIOMessageExposeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qav.thread.ThreadManager;

public class AnonymousExposeBusiness
  implements OnAIOMessageExposeListener
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    ThreadManager.b().post(new AnonymousExposeBusiness.1(this, paramMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.AnonymousExposeBusiness
 * JD-Core Version:    0.7.0.1
 */