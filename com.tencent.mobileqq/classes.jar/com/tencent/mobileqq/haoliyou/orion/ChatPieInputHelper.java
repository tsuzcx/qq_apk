package com.tencent.mobileqq.haoliyou.orion;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.TextMenuListener;

public class ChatPieInputHelper
  implements ILifeCycleHelper
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private XEditTextEx.TextMenuListener jdField_a_of_type_ComTencentWidgetXEditTextEx$TextMenuListener = new ChatPieInputHelper.1(this);
  public boolean a;
  
  public ChatPieInputHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void b(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$TextMenuListener);
      return;
    }
    catch (Throwable paramXEditTextEx) {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 30) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$TextMenuListener);
      return;
    }
    catch (Throwable paramXEditTextEx)
    {
      paramXEditTextEx.printStackTrace();
    }
  }
  
  public String getTag()
  {
    return "ChatPieInputHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 4)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      return;
    }
    if (paramInt == 15)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      return;
    }
    if (paramInt == 7) {
      NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.orion.ChatPieInputHelper
 * JD-Core Version:    0.7.0.1
 */