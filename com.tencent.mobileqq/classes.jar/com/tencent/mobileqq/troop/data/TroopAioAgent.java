package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.Observable;
import java.util.Observer;

public abstract class TroopAioAgent
  extends Observable
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  public Context a;
  protected View a;
  public RelativeLayout a;
  public BaseSessionInfo a;
  public ChatAdapter1 a;
  public QQAppInterface a;
  public ChatXListView a;
  public ScrollerRunnable a;
  public Observer a;
  public boolean a;
  
  public TroopAioAgent()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public View a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = false;
    deleteObservers();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, BaseSessionInfo paramBaseSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView, ScrollerRunnable paramScrollerRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    paramContext = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131374119);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.jdField_a_of_type_JavaUtilObserver = paramObserver;
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = paramScrollerRunnable;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramBaseSessionInfo.a != 1) && (paramBaseSessionInfo.a != 3000))
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      c();
    }
  }
  
  public void b()
  {
    IDoutuService localIDoutuService = (IDoutuService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IDoutuService.class, "");
    if (localIDoutuService != null) {
      localIDoutuService.clearComboViews();
    }
  }
  
  protected abstract void c();
  
  protected abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioAgent
 * JD-Core Version:    0.7.0.1
 */