package com.tencent.mobileqq.qqguildsdk.privatechannel;

import com.tencent.mobileqq.qqguildsdk.callback.IGetInvisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelMemberListCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvisibleMemberListCall
  implements IFetchChannelMemberListCallback
{
  public final String a;
  public final String b;
  private final GPSManagerEngine c;
  private long d;
  private boolean e;
  private int f;
  private final List<InvisibleMemberListCall.Call> g = new ArrayList();
  private List<IGProUserInfo> h = new ArrayList();
  
  public InvisibleMemberListCall(GPSManagerEngine paramGPSManagerEngine, String paramString1, String paramString2)
  {
    this.c = paramGPSManagerEngine;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.g.isEmpty()) {
      return;
    }
    Object localObject = this.h;
    this.h = new ArrayList();
    if (!((List)localObject).isEmpty()) {
      ((InvisibleMemberListCall.Call)this.g.remove(0)).b.a(0, paramString, paramBoolean, (List)localObject);
    }
    localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((InvisibleMemberListCall.Call)((Iterator)localObject).next()).b.a(paramInt, paramString, paramBoolean, new ArrayList());
    }
    this.g.clear();
  }
  
  private void b()
  {
    if (this.g.isEmpty()) {
      return;
    }
    if (this.e) {
      return;
    }
    this.f += 1;
    if (this.f > 5)
    {
      a(-3, "拉取次数过多", true);
      return;
    }
    this.e = true;
    int i = ((InvisibleMemberListCall.Call)this.g.get(0)).a;
    this.c.a(this.a, this.b, this.d, i, this);
  }
  
  public void a()
  {
    this.g.clear();
  }
  
  public void a(int paramInt, IGetInvisibleMemberListCallback paramIGetInvisibleMemberListCallback)
  {
    paramInt = Math.max(500, paramInt);
    if (this.g.isEmpty()) {
      this.f = 0;
    }
    paramIGetInvisibleMemberListCallback = new InvisibleMemberListCall.Call(paramInt, paramIGetInvisibleMemberListCallback);
    this.g.add(paramIGetInvisibleMemberListCallback);
    b();
  }
  
  public void a(int paramInt, String paramString, long paramLong, List<IGProUserInfo> paramList1, List<IGProUserInfo> paramList2)
  {
    boolean bool = false;
    this.e = false;
    if (this.g.isEmpty()) {
      return;
    }
    int i = 1;
    if (paramInt != 0)
    {
      if (paramLong != 0L) {
        bool = true;
      }
      a(paramInt, paramString, bool);
      return;
    }
    this.d = paramLong;
    this.h.addAll(paramList1);
    if (paramLong != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    int j = ((InvisibleMemberListCall.Call)this.g.get(0)).a;
    double d1 = this.h.size();
    double d2 = j;
    Double.isNaN(d2);
    if (d1 < d2 * 0.9D) {
      i = 0;
    }
    if ((!bool) || (i != 0))
    {
      paramList1 = this.h;
      this.h = new ArrayList();
      ((InvisibleMemberListCall.Call)this.g.remove(0)).b.a(paramInt, paramString, bool, paramList1);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.privatechannel.InvisibleMemberListCall
 * JD-Core Version:    0.7.0.1
 */