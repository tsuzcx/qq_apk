package com.tencent.mobileqq.troop.data;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopAioTips
  extends TroopAioAgent
{
  public long a;
  protected GestureDetector a;
  TroopAioBlueTipsView jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView = new TroopAioBlueTipsView();
  TroopAioKeywordTipBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar = new TroopAioKeywordTipBar();
  TroopAioNewMessageBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar = new TroopAioNewMessageBar();
  TroopAioNotificationBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar = new TroopAioNotificationBar();
  TroopAioMsgNavigateBar jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar = new TroopAioMsgNavigateBar();
  public long b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  
  public TroopAioTips()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
  }
  
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
    return this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (!a().a.get())) {
      if ((TroopAioNavigateUtil.a(b())) && (paramInt2 > 0))
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
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
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a(paramLong);
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
    if (this.jdField_a_of_type_Boolean)
    {
      GestureDetector localGestureDetector = this.jdField_a_of_type_AndroidViewGestureDetector;
      if (localGestureDetector != null) {
        localGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
    k();
  }
  
  public void a(List<TroopAIONotifyItem> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a()) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a()) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a()) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar;
      }
      if (localObject != null)
      {
        localObject = ((TroopAioAgent)localObject).a();
        if (localObject != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (paramBoolean)
          {
            localLayoutParams.addRule(3, 2131379333);
          }
          else
          {
            int i = TroopAioMsgNavigateBar.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131374119, 2131374255, 2131374250 });
            if (i > 0) {
              localLayoutParams.addRule(3, i);
            }
          }
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.b();
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a(paramInt);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopAioMsgNavigateBar localTroopAioMsgNavigateBar = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar;
      if (localTroopAioMsgNavigateBar != null) {
        return localTroopAioMsgNavigateBar.a();
      }
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.e();
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a(paramList);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.c();
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new TroopAioTips.1(this));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a(paramInt);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNotificationBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar.a();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.f();
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
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar.k();
    }
  }
  
  public boolean g()
  {
    return (d()) || (e()) || (f());
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.c = true;
  }
  
  public boolean h()
  {
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
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
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.c = false;
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioTips
 * JD-Core Version:    0.7.0.1
 */