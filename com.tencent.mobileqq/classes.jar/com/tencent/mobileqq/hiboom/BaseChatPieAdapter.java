package com.tencent.mobileqq.hiboom;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.api.IBaseChatPieAdapter;
import com.tencent.widget.XEditText;

public class BaseChatPieAdapter
  implements IBaseChatPieAdapter
{
  private BaseChatPie a;
  
  public BaseChatPieAdapter(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public int a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie != null) {
      return localBaseChatPie.b();
    }
    return 0;
  }
  
  public Context a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    }
    return null;
  }
  
  public BaseSessionInfo a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie == null) {
      return null;
    }
    return localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public QQAppInterface a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie == null) {
      return null;
    }
    return localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public XEditText a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie == null) {
      return null;
    }
    return localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
  }
  
  public Object a()
  {
    return this.a;
  }
  
  public void a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie != null) {
      localBaseChatPie.Y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.BaseChatPieAdapter
 * JD-Core Version:    0.7.0.1
 */