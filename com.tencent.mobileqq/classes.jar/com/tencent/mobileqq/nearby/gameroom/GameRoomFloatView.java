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
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
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
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameRoomFloatView
  implements View.OnTouchListener
{
  protected int a;
  protected BroadcastReceiver a;
  protected Context a;
  protected WindowManager a;
  protected TextView a;
  protected WerewolvesObserver a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  
  public GameRoomFloatView()
  {
    this(BaseApplicationImpl.getApplication());
  }
  
  public GameRoomFloatView(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver = new GameRoomFloatView.4(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new GameRoomFloatView.5(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705107));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#B2FFFFFF"));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(81);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    paramContext = new IntentFilter("tencent.video.v2q.SmallScreenState");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramContext);
  }
  
  private void b()
  {
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    int j = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
    int i = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight();
    if (localLayoutParams.x - this.jdField_a_of_type_AndroidWidgetTextView.getWidth() / 2 > j / 2)
    {
      j = j - this.jdField_a_of_type_AndroidWidgetTextView.getWidth() - DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      if (localLayoutParams.y - this.jdField_a_of_type_AndroidWidgetTextView.getHeight() / 2 <= i * 0.8F) {
        break label251;
      }
      i = i - this.jdField_a_of_type_AndroidWidgetTextView.getHeight() - DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.x, j });
      localValueAnimator.addUpdateListener(new GameRoomFloatView.2(this, localLayoutParams, localValueAnimator));
      localValueAnimator.setDuration(200L);
      localValueAnimator.setTarget(this.jdField_a_of_type_AndroidWidgetTextView);
      localValueAnimator.start();
      localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.y, i });
      localValueAnimator.addUpdateListener(new GameRoomFloatView.3(this, localLayoutParams, localValueAnimator));
      localValueAnimator.setDuration(200L);
      localValueAnimator.setTarget(this.jdField_a_of_type_AndroidWidgetTextView);
      localValueAnimator.start();
      return;
      j = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      break;
      label251:
      if (localLayoutParams.y - this.jdField_a_of_type_AndroidWidgetTextView.getHeight() / 2 > i * 0.6F) {
        i = (int)((i - this.jdField_a_of_type_AndroidWidgetTextView.getHeight()) * 0.75F);
      } else if (localLayoutParams.y - this.jdField_a_of_type_AndroidWidgetTextView.getHeight() / 2 > i * 0.4F) {
        i = (int)((i - this.jdField_a_of_type_AndroidWidgetTextView.getHeight()) * 0.5F);
      } else if (localLayoutParams.y - this.jdField_a_of_type_AndroidWidgetTextView.getHeight() / 2 > i * 0.2F) {
        i = (int)((i - this.jdField_a_of_type_AndroidWidgetTextView.getHeight()) * 0.25F);
      } else {
        i = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      }
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_AndroidWidgetTextView);
      label28:
      this.jdField_b_of_type_Boolean = false;
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFloatView", 2, "GameRoomFloatView->show: state = " + paramInt1);
    }
    this.c = paramInt1;
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    }
    Object localObject;
    if (!this.jdField_b_of_type_Boolean) {
      if (!SmallScreenUtils.c(this.jdField_a_of_type_AndroidContentContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameRoomFloatView", 2, "GameRoomFloatView->show: isFloatWindowOpAllowed = false");
        }
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SmallScreenDialogActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(131072);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_AndroidWidgetTextView);
      label159:
      int j = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
      int k = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight();
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      }
      for (;;)
      {
        localObject = new WindowManager.LayoutParams(-2, -2, i, 776, -2);
        ((WindowManager.LayoutParams)localObject).gravity = 51;
        ((WindowManager.LayoutParams)localObject).x = (j - DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 62.0F) - DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        ((WindowManager.LayoutParams)localObject).y = ((int)((k - DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 67.0F)) * 0.25F));
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130842438);
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
          this.jdField_b_of_type_Boolean = true;
          if (paramInt1 == 0)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705158));
            this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new GameRoomFloatView.1(this, paramInt1, paramLong, paramString2, paramString1, paramInt2));
            ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
            return;
            i = 2010;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.e("GameRoomFloatView", 1, localException1, new Object[0]);
            continue;
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705149));
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label159;
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
      localObject2 = ((HotChatManager)localObject1).a();
      if ((localObject2 != null) && (!((List)localObject2).contains(paramHotChatInfo))) {
        ((List)localObject2).add(paramHotChatInfo);
      }
      ((HotChatManager)localObject1).a(paramHotChatInfo, 4);
      paramHotChatInfo = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      paramHotChatInfo.putExtra("uin", paramInt + "");
      paramHotChatInfo.putExtra("uintype", 1);
      paramHotChatInfo.putExtra("troop_uin", paramInt + "");
      paramHotChatInfo.putExtra("uinname", paramString2);
      paramHotChatInfo.putExtra("hotnamecode", paramString1);
      paramHotChatInfo = AIOUtils.a(paramHotChatInfo, new int[] { 2 });
      paramHotChatInfo.addFlags(268435456);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramHotChatInfo);
      a();
      return;
    }
    finally {}
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawX();
    int k = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getY());
    }
    label225:
    do
    {
      return false;
      if (i == 2)
      {
        if ((this.jdField_a_of_type_Boolean) || (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Int) > DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F)) || (Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Int) > DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F)))
        {
          this.jdField_a_of_type_Boolean = true;
          paramView = (WindowManager.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView.x = (j - this.jdField_a_of_type_Int);
          paramView.y = (k - this.jdField_b_of_type_Int - DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 25.0F));
          i = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
          j = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight();
          if (paramView.x >= 0) {
            break label225;
          }
          paramView.x = 0;
          if (paramView.y >= 0) {
            break label257;
          }
          paramView.y = 0;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidWidgetTextView, paramView);
          return true;
          if (paramView.x <= i - this.jdField_a_of_type_AndroidWidgetTextView.getWidth()) {
            break;
          }
          paramView.x = (i - this.jdField_a_of_type_AndroidWidgetTextView.getWidth());
          break;
          if (paramView.y > j - this.jdField_a_of_type_AndroidWidgetTextView.getHeight()) {
            paramView.y = (j - this.jdField_a_of_type_AndroidWidgetTextView.getHeight());
          }
        }
      }
    } while ((i != 1) && (i != 3));
    label257:
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView
 * JD-Core Version:    0.7.0.1
 */