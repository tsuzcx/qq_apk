package com.tencent.mobileqq.troop.data;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.navigatebar.AioAgent;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopAioTips
  extends AioTips
{
  TroopAioNewMessageBar a = new TroopAioNewMessageBar();
  TroopAioMsgNavigateBar b = new TroopAioMsgNavigateBar();
  TroopAioNotificationBar c = new TroopAioNotificationBar();
  TroopAioBlueTipsView d = new TroopAioBlueTipsView();
  TroopAioKeywordTipBar e = new TroopAioKeywordTipBar();
  protected GestureDetector f = null;
  
  protected void a()
  {
    this.a.a(this.D, this.E, this.K, this.F, this.G, this.I, this.J, this.L);
    this.b.a(this.D, this.E, this.K, this.F, this.G, this.I, this.J, this.L);
    this.c.a(this.D, this.E, this.K, this.F, this.G, this.I, this.J, this.L);
    this.d.a(this.D, this.E, this.K, this.F, this.G, this.I, this.J, this.L);
    this.e.a(this.D, this.E, this.K, this.F, this.G, this.I, this.J, this.L);
    this.e.a(this);
    this.f = new GestureDetector(this.E, new TroopAioTips.1(this));
    this.g = false;
    this.h = 0L;
    this.i = 0L;
    this.j = false;
  }
  
  public void a(int paramInt)
  {
    if (this.M) {
      this.b.c(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((h()) && (this.I != null) && (!t().f.get())) {
      if ((TroopAioNavigateUtil.a(i())) && (paramInt2 > 0))
      {
        List localList = this.I.a();
        int i = localList.size();
        int j = paramInt1 + paramInt2 - paramInt5 - paramInt4;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("firstVisibleItem = ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(",visibleItemCount = ");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",totalItemCount = ");
          localStringBuilder.append(paramInt3);
          localStringBuilder.append(",footerCnt = ");
          localStringBuilder.append(paramInt4);
          localStringBuilder.append(",headerCnt = ");
          localStringBuilder.append(paramInt5);
          localStringBuilder.append(", listSize = ");
          localStringBuilder.append(i);
          QLog.i("BaseTroopChatPieOnScroll", 2, localStringBuilder.toString());
        }
        if ((paramInt1 >= 0) && (paramInt1 <= j) && (j < i)) {
          b(localList.subList(paramInt1, j));
        }
      }
      else
      {
        b(0);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.M) {
      this.b.a(paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.g = true;
    this.h = paramLong1;
    this.i = paramLong2;
    this.j = paramBoolean;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.M)
    {
      GestureDetector localGestureDetector = this.f;
      if (localGestureDetector != null) {
        localGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
    s();
  }
  
  public void a(List<TroopAIONotifyItem> paramList)
  {
    this.c.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.M)
    {
      Object localObject = null;
      if (this.b.j()) {
        localObject = this.b;
      } else if (this.c.c()) {
        localObject = this.c;
      } else if (this.e.e()) {
        localObject = this.e;
      }
      if (localObject != null)
      {
        localObject = ((AioAgent)localObject).f();
        if (localObject != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (paramBoolean)
          {
            localLayoutParams.addRule(3, 2131448070);
          }
          else
          {
            int i = TroopAioMsgNavigateBar.a(this.G, new int[] { 2131442214, 2131442350, 2131442345 });
            if (i > 0) {
              localLayoutParams.addRule(3, i);
            }
          }
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
      }
    }
  }
  
  protected void b()
  {
    this.f = null;
    this.a.v();
    this.b.v();
    this.c.v();
    this.d.v();
    this.e.v();
    this.g = false;
    this.h = 0L;
    this.i = 0L;
    this.j = false;
  }
  
  public void b(int paramInt)
  {
    if (this.M) {
      this.b.k();
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((this.M) && (!this.k)) {
      this.b.a(paramList);
    }
  }
  
  public boolean c()
  {
    return this.b.i();
  }
  
  public boolean c(int paramInt)
  {
    if (this.M) {
      return this.b.d(paramInt);
    }
    return false;
  }
  
  public boolean cB_()
  {
    if (this.M) {
      return this.b.e();
    }
    return false;
  }
  
  public void d()
  {
    if ((this.M) && (!this.k)) {
      this.b.l();
    }
  }
  
  public void d(int paramInt)
  {
    if (this.M) {
      this.a.a(paramInt);
    }
  }
  
  public void e()
  {
    if (this.M) {
      this.b.q();
    }
  }
  
  public boolean g()
  {
    if (this.M) {
      return this.a.d();
    }
    return false;
  }
  
  public boolean h()
  {
    if (this.M) {
      return this.b.j();
    }
    return false;
  }
  
  public int i()
  {
    if (this.M)
    {
      TroopAioMsgNavigateBar localTroopAioMsgNavigateBar = this.b;
      if (localTroopAioMsgNavigateBar != null) {
        return localTroopAioMsgNavigateBar.r();
      }
    }
    return -1;
  }
  
  public void j()
  {
    this.a.y = true;
  }
  
  public void l()
  {
    if ((this.M) && (!this.k)) {
      this.c.d();
    }
  }
  
  public int m()
  {
    if (this.M) {
      return this.a.c();
    }
    return 0;
  }
  
  public boolean n()
  {
    if (this.M) {
      return this.c.c();
    }
    return false;
  }
  
  public boolean o()
  {
    if (this.M) {
      return this.e.e();
    }
    return false;
  }
  
  public boolean p()
  {
    return (h()) || (n()) || (o());
  }
  
  public boolean q()
  {
    boolean bool3 = this.M;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if ((!h()) && (!g()) && (!this.c.c()))
      {
        bool1 = bool2;
        if (!this.d.d()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void r()
  {
    this.a.y = false;
  }
  
  public void s()
  {
    this.d.c();
  }
  
  public TroopAioMsgNavigateBar t()
  {
    return this.b;
  }
  
  public TroopAioKeywordTipBar u()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioTips
 * JD-Core Version:    0.7.0.1
 */