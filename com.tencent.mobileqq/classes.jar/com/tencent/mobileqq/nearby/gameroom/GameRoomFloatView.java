package com.tencent.mobileqq.nearby.gameroom;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameRoomFloatView
  implements View.OnTouchListener
{
  protected TextView a;
  protected WindowManager b;
  protected Context c;
  protected int d;
  protected int e;
  protected boolean f;
  protected boolean g;
  protected int h;
  protected WerewolvesObserver i = new GameRoomFloatView.4(this);
  protected BroadcastReceiver j = new GameRoomFloatView.5(this);
  
  public GameRoomFloatView()
  {
    this(BaseApplicationImpl.getApplication());
  }
  
  public GameRoomFloatView(Context paramContext)
  {
    this.c = paramContext;
    this.a = new TextView(this.c);
    this.a.setOnTouchListener(this);
    this.a.setText(HardCodeUtil.a(2131903072));
    this.a.setTextSize(10.0F);
    this.a.setTextColor(Color.parseColor("#B2FFFFFF"));
    this.a.setGravity(81);
    this.a.setPadding(0, 0, 0, DisplayUtil.a(this.c, 15.0F));
    paramContext = new IntentFilter("tencent.video.v2q.SmallScreenState");
    this.c.registerReceiver(this.j, paramContext);
  }
  
  private void c()
  {
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.a.getLayoutParams();
    int m = this.b.getDefaultDisplay().getWidth();
    int k = this.b.getDefaultDisplay().getHeight();
    if (localLayoutParams.x - this.a.getWidth() / 2 > m / 2) {
      m = m - this.a.getWidth() - DisplayUtil.a(this.c, 10.0F);
    } else {
      m = DisplayUtil.a(this.c, 10.0F);
    }
    float f1 = localLayoutParams.y - this.a.getHeight() / 2;
    float f2 = k;
    if (f1 > 0.8F * f2)
    {
      k = k - this.a.getHeight() - DisplayUtil.a(this.c, 10.0F);
    }
    else
    {
      if (localLayoutParams.y - this.a.getHeight() / 2 > 0.6F * f2)
      {
        f1 = k - this.a.getHeight();
        f2 = 0.75F;
      }
      for (;;)
      {
        k = (int)(f1 * f2);
        break label287;
        if (localLayoutParams.y - this.a.getHeight() / 2 > 0.4F * f2)
        {
          f1 = k - this.a.getHeight();
          f2 = 0.5F;
        }
        else
        {
          if (localLayoutParams.y - this.a.getHeight() / 2 <= f2 * 0.2F) {
            break;
          }
          f1 = k - this.a.getHeight();
          f2 = 0.25F;
        }
      }
      k = DisplayUtil.a(this.c, 10.0F);
    }
    label287:
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.x, m });
    localValueAnimator.addUpdateListener(new GameRoomFloatView.2(this, localLayoutParams, localValueAnimator));
    localValueAnimator.setDuration(200L);
    localValueAnimator.setTarget(this.a);
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.y, k });
    localValueAnimator.addUpdateListener(new GameRoomFloatView.3(this, localLayoutParams, localValueAnimator));
    localValueAnimator.setDuration(200L);
    localValueAnimator.setTarget(this.a);
    localValueAnimator.start();
  }
  
  public void a()
  {
    if (this.g) {}
    try
    {
      this.a.setBackgroundResource(0);
      this.b.removeViewImmediate(this.a);
      label28:
      this.g = false;
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.i);
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GameRoomFloatView->show: state = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("GameRoomFloatView", 2, ((StringBuilder)localObject).toString());
    }
    this.h = paramInt1;
    if (this.b == null) {
      this.b = ((WindowManager)this.c.getSystemService("window"));
    }
    if (!this.g) {
      if (!SmallScreenUtils.c(this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameRoomFloatView", 2, "GameRoomFloatView->show: isFloatWindowOpAllowed = false");
        }
        localObject = new Intent(this.c, SmallScreenDialogActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(131072);
        this.c.startActivity((Intent)localObject);
      }
    }
    try
    {
      this.b.removeViewImmediate(this.a);
      label172:
      int m = this.b.getDefaultDisplay().getWidth();
      int n = this.b.getDefaultDisplay().getHeight();
      int k;
      if (Build.VERSION.SDK_INT >= 26) {
        k = 2038;
      } else {
        k = 2010;
      }
      localObject = new WindowManager.LayoutParams(-2, -2, k, 776, -2);
      ((WindowManager.LayoutParams)localObject).gravity = 51;
      ((WindowManager.LayoutParams)localObject).x = (m - DisplayUtil.a(this.c, 62.0F) - DisplayUtil.a(this.c, 10.0F));
      ((WindowManager.LayoutParams)localObject).y = ((int)((n - DisplayUtil.a(this.c, 67.0F)) * 0.25F));
      this.a.setBackgroundResource(2130843280);
      try
      {
        this.b.addView(this.a, (ViewGroup.LayoutParams)localObject);
      }
      catch (Exception localException1)
      {
        QLog.e("GameRoomFloatView", 1, localException1, new Object[0]);
      }
      this.g = true;
      if (paramInt1 == 0) {
        this.a.setText(HardCodeUtil.a(2131903120));
      } else {
        this.a.setText(HardCodeUtil.a(2131903111));
      }
      this.a.setOnClickListener(new GameRoomFloatView.1(this, paramInt1, paramLong, paramString2, paramString1, paramInt2));
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.i);
      return;
    }
    catch (Exception localException2)
    {
      break label172;
    }
  }
  
  protected void a(HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      paramHotChatInfo.isGameRoom = true;
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = ((QQAppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      ((EntityManager)localObject2).update(paramHotChatInfo);
      ((EntityManager)localObject2).close();
      localObject1 = (HotChatManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      localObject2 = ((HotChatManager)localObject1).c();
      if ((localObject2 != null) && (!((List)localObject2).contains(paramHotChatInfo))) {
        ((List)localObject2).add(paramHotChatInfo);
      }
      ((HotChatManager)localObject1).a(paramHotChatInfo, 4);
      paramHotChatInfo = new Intent(this.c, ChatActivity.class);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("");
      paramHotChatInfo.putExtra("uin", ((StringBuilder)localObject1).toString());
      paramHotChatInfo.putExtra("uintype", 1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("");
      paramHotChatInfo.putExtra("troop_uin", ((StringBuilder)localObject1).toString());
      paramHotChatInfo.putExtra("uinname", paramString2);
      paramHotChatInfo.putExtra("hotnamecode", paramString1);
      paramHotChatInfo = AIOUtils.a(paramHotChatInfo, new int[] { 2 });
      paramHotChatInfo.addFlags(268435456);
      this.c.startActivity(paramHotChatInfo);
      a();
      return;
    }
    finally {}
  }
  
  public int b()
  {
    return this.h;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int m = (int)paramMotionEvent.getRawX();
    int n = (int)paramMotionEvent.getRawY();
    if (k == 0)
    {
      this.d = ((int)paramMotionEvent.getX());
      this.e = ((int)paramMotionEvent.getY());
      return false;
    }
    if (k == 2)
    {
      if ((this.f) || (Math.abs(paramMotionEvent.getX() - this.d) > DisplayUtil.a(this.c, 10.0F)) || (Math.abs(paramMotionEvent.getY() - this.e) > DisplayUtil.a(this.c, 10.0F)))
      {
        this.f = true;
        paramView = (WindowManager.LayoutParams)this.a.getLayoutParams();
        paramView.x = (m - this.d);
        paramView.y = (n - this.e - DisplayUtil.a(this.c, 25.0F));
        k = this.b.getDefaultDisplay().getWidth();
        m = this.b.getDefaultDisplay().getHeight();
        if (paramView.x < 0) {
          paramView.x = 0;
        } else if (paramView.x > k - this.a.getWidth()) {
          paramView.x = (k - this.a.getWidth());
        }
        if (paramView.y < 0) {
          paramView.y = 0;
        } else if (paramView.y > m - this.a.getHeight()) {
          paramView.y = (m - this.a.getHeight());
        }
        this.b.updateViewLayout(this.a, paramView);
      }
      return true;
    }
    if ((k != 1) && (k != 3)) {
      return false;
    }
    if (this.f)
    {
      c();
      this.f = false;
      return true;
    }
    this.f = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView
 * JD-Core Version:    0.7.0.1
 */