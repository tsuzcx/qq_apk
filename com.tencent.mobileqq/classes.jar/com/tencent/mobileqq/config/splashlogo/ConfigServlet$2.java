package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper;
import java.util.List;

class ConfigServlet$2
  implements ConfigServlet.IHandleConfigCallback
{
  ConfigServlet$2(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface) {}
  
  public int a()
  {
    return ShortVideoMsgTailHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
  }
  
  public void a(int paramInt)
  {
    ShortVideoMsgTailHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt);
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      ShortVideoMsgTailHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.2
 * JD-Core Version:    0.7.0.1
 */