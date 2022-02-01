package com.tencent.mobileqq.doodle;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodlePanel;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IDoodlePanelHelper
  extends QRouteApi
{
  public abstract BaseDoodleMsgLayout createMsgLayout(Context paramContext);
  
  public abstract void destroy();
  
  public abstract void destroyCache();
  
  public abstract BaseDoodlePanel getDoodlePanel(Context paramContext);
  
  public abstract long getMsgID(ChatMessage paramChatMessage);
  
  public abstract long getUniID(ChatMessage paramChatMessage);
  
  public abstract boolean isNewMsgAndNotPlayed(long paramLong1, long paramLong2);
  
  public abstract void playLayout(BaseDoodleMsgLayout paramBaseDoodleMsgLayout, boolean paramBoolean);
  
  public abstract void registLayout(long paramLong1, long paramLong2, int paramInt, BaseDoodleMsgLayout paramBaseDoodleMsgLayout);
  
  public abstract void setLastMsgID(List<ChatMessage> paramList);
  
  public abstract void setScrollData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public abstract void setScrollState(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doodle.IDoodlePanelHelper
 * JD-Core Version:    0.7.0.1
 */