package com.tencent.qzonehub.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.qzonehub.api.IQZoneEventHandlerProxy;
import cooperation.qzone.util.QZLog;

public class QZoneEventHandlerProxyImpl
  implements IQZoneEventHandlerProxy
{
  private static final String TAG = "QZoneEventHandler";
  
  public boolean handleActivityEvent(Object paramObject, int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleActivityEvent: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt2);
    QZLog.i("QZoneEventHandler", localStringBuilder.toString());
    switch (paramInt1)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof FriendChatPie))
    {
      paramObject = (FriendChatPie)paramObject;
      if (((ChatDrawerHelper)paramObject.a(124)).a != null) {
        ((ChatDrawerHelper)paramObject.a(124)).a.a(paramInt1, paramInt2, paramIntent);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneEventHandlerProxyImpl
 * JD-Core Version:    0.7.0.1
 */