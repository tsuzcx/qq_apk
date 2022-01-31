package com.tencent.mobileqq.troop.data;

import ajdd;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import java.util.List;
import java.util.Observer;

public class TroopAioTips
  extends TroopAioAgent
{
  public long a;
  protected GestureDetector a;
  TroopAioBlueTipsView jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView = new TroopAioBlueTipsView();
  TroopAioKeywordTipBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar = new TroopAioKeywordTipBar();
  TroopAioMsgNavigateBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar = new TroopAioMsgNavigateBar();
  TroopAioNewMessageBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar = new TroopAioNewMessageBar();
  TroopAioNotificationBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar = new TroopAioNotificationBar();
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a();
    }
    return 0;
  }
  
  public TroopAioKeywordTipBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar;
  }
  
  public TroopAioMsgNavigateBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramBoolean;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null)) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    j();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a(paramList);
  }
  
  public void a(Observer paramObserver)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.jdField_b_of_type_JavaUtilObserver = paramObserver;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = null;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a()) {
        break label65;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar;
      if (localObject != null)
      {
        localObject = ((TroopAioAgent)localObject).a();
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (!paramBoolean) {
            break label101;
          }
          localLayoutParams.addRule(3, 2131362422);
        }
      }
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(localLayoutParams);
      return;
      label65:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar;
        break;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a()) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar;
      break;
      label101:
      int i = TroopAioMsgNavigateBar.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131363508, 2131362153, 2131362130 });
      if (i > 0) {
        localLayoutParams.addRule(3, i);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.b();
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.e();
    }
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(paramList);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.c();
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new ajdd(this));
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a(paramInt);
    }
  }
  
  public void c(List paramList)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.b(paramList);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a();
    }
    return false;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a();
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.f();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a();
    }
    return false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.e();
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a();
    }
    return false;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.jdField_b_of_type_Boolean = true;
  }
  
  public boolean g()
  {
    return (d()) || (e()) || (f());
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.jdField_b_of_type_Boolean = false;
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean) {
      if ((!d()) && (!c()) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a()))
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioTips
 * JD-Core Version:    0.7.0.1
 */