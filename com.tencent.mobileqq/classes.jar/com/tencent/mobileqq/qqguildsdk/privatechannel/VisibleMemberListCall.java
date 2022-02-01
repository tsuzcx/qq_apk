package com.tencent.mobileqq.qqguildsdk.privatechannel;

import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.manager.VisibleMemberMgr;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchVisibleMemberListCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisibleMemberListCall
  implements IFetchVisibleMemberListCallback
{
  public final String a;
  public final String b;
  private final VisibleMemberMgr c;
  private final GPSManagerEngine d;
  private long e;
  private boolean f;
  private int g;
  private final List<VisibleMemberListCall.Call> h = new ArrayList();
  
  public VisibleMemberListCall(VisibleMemberMgr paramVisibleMemberMgr, GPSManagerEngine paramGPSManagerEngine, String paramString1, String paramString2)
  {
    this.c = paramVisibleMemberMgr;
    this.d = paramGPSManagerEngine;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, List<IGProUserInfo> paramList)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((VisibleMemberListCall.Call)localIterator.next()).b.a(paramInt1, paramString, paramInt2, paramBoolean, paramList);
    }
    this.h.clear();
  }
  
  private void b()
  {
    if (this.h.isEmpty()) {
      return;
    }
    if (this.f) {
      return;
    }
    this.g += 1;
    if (this.g > 5)
    {
      a(-3, "拉取次数过多", this.c.b(this.a, this.b), true, new ArrayList());
      return;
    }
    this.f = true;
    int i = ((VisibleMemberListCall.Call)this.h.get(0)).a;
    this.d.a(this.a, this.b, this.e, i, this);
    this.c.c(this.a, this.b);
  }
  
  public void a()
  {
    this.h.clear();
  }
  
  public void a(int paramInt, IGetVisibleMemberListCallback paramIGetVisibleMemberListCallback)
  {
    paramInt = Math.max(0, paramInt);
    if (this.h.isEmpty()) {
      this.g = 0;
    }
    paramIGetVisibleMemberListCallback = new VisibleMemberListCall.Call(paramInt, paramIGetVisibleMemberListCallback);
    this.h.add(paramIGetVisibleMemberListCallback);
    b();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong, List<IGProUserInfo> paramList)
  {
    this.f = false;
    this.c.a(this.a, this.b, paramInt1, paramString, paramInt2);
    if (this.h.isEmpty()) {
      return;
    }
    boolean bool;
    if (paramInt1 != 0)
    {
      if (paramLong != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      a(paramInt1, paramString, paramInt2, bool, paramList);
      return;
    }
    this.e = paramLong;
    IGetVisibleMemberListCallback localIGetVisibleMemberListCallback = ((VisibleMemberListCall.Call)this.h.remove(0)).b;
    if (paramLong != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localIGetVisibleMemberListCallback.a(paramInt1, paramString, paramInt2, bool, paramList);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.privatechannel.VisibleMemberListCall
 * JD-Core Version:    0.7.0.1
 */