package com.tencent.mobileqq.kandian.biz.share;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

public class ShareToComputerHelper
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  private String jdField_a_of_type_JavaLangString;
  
  public ShareToComputerHelper(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new ShareToComputerHelper.1(this);
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramAppInterface != null) {
      paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  public long a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    if (bool) {
      return 0L;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    long l1 = l2;
    if (localObject != null)
    {
      if (QFileAssistantUtils.a((QQAppInterface)localObject))
      {
        new QFileAssistantForwardManager((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(paramString);
        return 1L;
      }
      localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      l1 = l2;
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        l1 = ((DataLineHandler)localObject).a(paramString, 0).longValue();
      }
    }
    return l1;
  }
  
  public void a()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ShareToComputerHelper
 * JD-Core Version:    0.7.0.1
 */