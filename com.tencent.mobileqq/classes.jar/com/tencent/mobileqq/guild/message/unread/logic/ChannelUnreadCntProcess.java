package com.tencent.mobileqq.guild.message.unread.logic;

import android.util.SparseArray;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ChannelUnreadCntProcess
{
  SparseArray<AbsChannelUnreadCnt> a = new SparseArray();
  private AppRuntime b;
  private String c;
  
  public ChannelUnreadCntProcess(AppRuntime paramAppRuntime, String paramString)
  {
    this.b = paramAppRuntime;
    this.c = paramString;
    a();
  }
  
  public IGuildUnreadCntService.UnreadCntInfo a(int paramInt)
  {
    if (paramInt >= 8) {}
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateUnreadCntInfo error! unreadTypeMask = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.i("ChannelUnreadCntProcess", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new IGuildUnreadCntService.UnreadCntInfo();
      return localObject1;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int i;
        long l3;
        long l4;
        IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo;
        for (;;)
        {
          throw localObject2;
        }
        i += 1;
        paramInt >>>= 1;
        long l2 = l3;
        long l1 = l4;
      }
    }
    localObject1 = new IGuildUnreadCntService.UnreadCntInfo();
    i = 0;
    l2 = 0L;
    l1 = 0L;
    if ((paramInt != 0) && (i < 3))
    {
      l3 = l2;
      l4 = l1;
      if (1 == (paramInt & 0x1))
      {
        localUnreadCntInfo = ((AbsChannelUnreadCnt)this.a.get(i)).b();
        if (localUnreadCntInfo.b == 1)
        {
          l3 = l2 + localUnreadCntInfo.a;
          l4 = l1;
        }
        else
        {
          l3 = l2;
          l4 = l1;
          if (localUnreadCntInfo.b == 2)
          {
            l4 = l1 + localUnreadCntInfo.a;
            l3 = l2;
          }
        }
      }
    }
    else
    {
      ((IGuildUnreadCntService.UnreadCntInfo)localObject1).a(l2, l1);
      return localObject1;
    }
  }
  
  void a()
  {
    this.a.put(0, new ChannelMsgUnreadCnt(this.b, this.c));
    this.a.put(1, new ChannelAtAllUnReadCnt(this.b, this.c));
    this.a.put(2, new ChannelAtMeUnReadCnt(this.b, this.c));
  }
  
  public void b()
  {
    int i = 0;
    try
    {
      while (i < this.a.size())
      {
        ((AbsChannelUnreadCnt)this.a.get(i)).a();
        i += 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean c()
  {
    int i = 0;
    boolean bool = false;
    try
    {
      while (i < this.a.size())
      {
        Object localObject2 = (AbsChannelUnreadCnt)this.a.valueAt(i);
        IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = ((AbsChannelUnreadCnt)localObject2).b();
        localUnreadCntInfo = new IGuildUnreadCntService.UnreadCntInfo(localUnreadCntInfo.a, localUnreadCntInfo.b);
        ((AbsChannelUnreadCnt)localObject2).a();
        localObject2 = ((AbsChannelUnreadCnt)localObject2).b();
        if (!localUnreadCntInfo.equals(localObject2))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("refreshAndNotifyChannelUnreadCntInfo channelid:");
            localStringBuilder.append(this.c);
            localStringBuilder.append(" old:");
            localStringBuilder.append(localUnreadCntInfo.toString());
            localStringBuilder.append("new:");
            localStringBuilder.append(((IGuildUnreadCntService.UnreadCntInfo)localObject2).toString());
            localStringBuilder.append("bit: ");
            localStringBuilder.append(i);
            QLog.i("ChannelUnreadCntProcess", 2, localStringBuilder.toString());
          }
          bool = true;
        }
        i += 1;
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.logic.ChannelUnreadCntProcess
 * JD-Core Version:    0.7.0.1
 */