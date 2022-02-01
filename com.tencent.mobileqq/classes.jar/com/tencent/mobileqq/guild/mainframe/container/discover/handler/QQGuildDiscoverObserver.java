package com.tencent.mobileqq.guild.mainframe.container.discover.handler;

import com.tencent.mobileqq.app.BusinessObserver;

public class QQGuildDiscoverObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverObserver
 * JD-Core Version:    0.7.0.1
 */