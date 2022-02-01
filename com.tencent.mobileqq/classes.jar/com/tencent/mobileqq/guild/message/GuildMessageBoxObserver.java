package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.data.ChannelMsgEventCollection;
import java.util.List;

public class GuildMessageBoxObserver
  implements BusinessObserver
{
  public static final int a;
  private static int b;
  
  static
  {
    int i = b;
    b = i + 1;
    a = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        a(paramBoolean, (List)paramObject[0]);
        return;
      }
      a(false, null);
      return;
    }
    a(false, null);
  }
  
  protected void a(boolean paramBoolean, List<ChannelMsgEventCollection> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildMessageBoxObserver
 * JD-Core Version:    0.7.0.1
 */