package com.tencent.mobileqq.guild.message.registerproxy.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import tencent.im.group_pro_proto.synclogic.synclogic.FirstViewRsp;
import tencent.im.group_pro_proto.synclogic.synclogic.GuildNode;
import tencent.im.group_pro_proto.synclogic.synclogic.MultiChannelMsgRsp;

public class GuildRegisterProxyObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
    i = a;
    a = i + 1;
    d = i;
    i = a;
    a = i + 1;
    e = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if (paramObject == null)
    {
      a(paramBoolean, null);
      return;
    }
    a(paramBoolean, (synclogic.FirstViewRsp)((Object[])(Object[])paramObject)[0]);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if (paramObject == null)
    {
      a(paramBoolean, null);
      return;
    }
    a(paramBoolean, (ArrayList)((Object[])(Object[])paramObject)[0]);
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2)
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (synclogic.MultiChannelMsgRsp)paramObject[1]);
        return;
      }
    }
    a(paramBoolean, 0, null);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2)
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue());
        return;
      }
    }
    a(paramBoolean, 0);
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, synclogic.MultiChannelMsgRsp paramMultiChannelMsgRsp) {}
  
  protected void a(boolean paramBoolean, ArrayList<synclogic.GuildNode> paramArrayList) {}
  
  protected void a(boolean paramBoolean, synclogic.FirstViewRsp paramFirstViewRsp) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.observer.GuildRegisterProxyObserver
 * JD-Core Version:    0.7.0.1
 */