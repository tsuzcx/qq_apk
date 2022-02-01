package com.tencent.mobileqq.guild.chatpie.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.UnreadCountHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;
import java.util.Observer;
import mqq.os.MqqHandler;

public class GuildAIOUnreadHelper
  implements ILifeCycleHelper
{
  protected BaseChatPie a;
  private final Observer b = new -..Lambda.GuildAIOUnreadHelper.j4ACFyA7FRbUBdDIe_NdS3mB0NY(this);
  
  public GuildAIOUnreadHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null)) {
      ((IGuildUnreadCntService)this.a.d.getRuntimeService(IGuildUnreadCntService.class, "")).addObserver(this.b);
    }
  }
  
  private void a(IGuildUnreadCntService.NotifyObj paramNotifyObj)
  {
    if ((this.a != null) && (paramNotifyObj.a == 2))
    {
      paramNotifyObj = (UnreadCountHelper)this.a.q(5);
      if (paramNotifyObj != null)
      {
        paramNotifyObj = paramNotifyObj.a();
        ThreadManager.getSubThreadHandler().post(paramNotifyObj);
      }
    }
  }
  
  private void b()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null)) {
      ((IGuildUnreadCntService)this.a.d.getRuntimeService(IGuildUnreadCntService.class, "")).deleteObserver(this.b);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildDrawerFrameHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildAIOUnreadHelper
 * JD-Core Version:    0.7.0.1
 */