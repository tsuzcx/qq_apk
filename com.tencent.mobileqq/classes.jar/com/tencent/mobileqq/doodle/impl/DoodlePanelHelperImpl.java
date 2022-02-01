package com.tencent.mobileqq.doodle.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.doodle.IDoodlePanelHelper;
import java.util.List;

public class DoodlePanelHelperImpl
  implements IDoodlePanelHelper
{
  public BaseDoodleMsgLayout createMsgLayout(Context paramContext)
  {
    return new DoodleMsgLayout(paramContext, null);
  }
  
  public void destroy() {}
  
  public void destroyCache()
  {
    DoodleResHelper.a().b();
  }
  
  public BaseDoodlePanel getDoodlePanel(Context paramContext)
  {
    return (BaseDoodlePanel)View.inflate(paramContext, 2131624085, null);
  }
  
  public long getMsgID(ChatMessage paramChatMessage)
  {
    return PlayLastLogic.a(paramChatMessage);
  }
  
  public long getUniID(ChatMessage paramChatMessage)
  {
    return PlayLastLogic.b(paramChatMessage);
  }
  
  public boolean isNewMsgAndNotPlayed(long paramLong1, long paramLong2)
  {
    return PlayLastLogic.a().a(paramLong1, paramLong2);
  }
  
  public void playLayout(BaseDoodleMsgLayout paramBaseDoodleMsgLayout, boolean paramBoolean)
  {
    PlayLastLogic.a().a(paramBaseDoodleMsgLayout, paramBoolean);
  }
  
  public void registLayout(long paramLong1, long paramLong2, int paramInt, BaseDoodleMsgLayout paramBaseDoodleMsgLayout)
  {
    PlayLastLogic.a().a(paramLong1, paramLong2, paramInt, paramBaseDoodleMsgLayout);
  }
  
  public void setLastMsgID(List<ChatMessage> paramList)
  {
    PlayLastLogic.a().a(paramList);
  }
  
  public void setScrollData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PlayLastLogic.a().a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void setScrollState(int paramInt)
  {
    PlayLastLogic.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doodle.impl.DoodlePanelHelperImpl
 * JD-Core Version:    0.7.0.1
 */