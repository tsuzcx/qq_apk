package com.tencent.mobileqq.filemanager.fileassistant.aio;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;

public class DatalineMultiForwardHelper
  extends MultiForwardHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public DatalineMultiForwardHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet == null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet = new DatalineAIOShareActionSheet(localQQAppInterface, localContext, localActivity, localBaseChatPie, localBaseChatPie.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.aio.DatalineMultiForwardHelper
 * JD-Core Version:    0.7.0.1
 */