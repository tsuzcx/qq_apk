package com.tencent.mobileqq.qqlive.callback.announce;

import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;

public abstract interface IQQLiveAnnouncePushListener
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(AnnouncePushMessage paramAnnouncePushMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener
 * JD-Core Version:    0.7.0.1
 */