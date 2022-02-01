package com.tencent.mobileqq.qqgamepub.ipc;

import eipc.EIPCResult;
import java.util.Map;

class QQGameIpcHandle$1$1
  implements Runnable
{
  QQGameIpcHandle$1$1(QQGameIpcHandle.1 param1, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    if (QQGameIpcHandle.QGameIPCTask.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$1.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$QGameIPCTask) != null) {
      QQGameIpcHandle.QGameIPCTask.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$1.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$QGameIPCTask).a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_EipcEIPCResult);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$1.jdField_a_of_type_Boolean)
    {
      QQGameIpcHandle.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$1.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle).remove(this.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$1.jdField_a_of_type_JavaLangString);
      QQGameIpcHandle.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle$1.jdField_a_of_type_ComTencentMobileqqQqgamepubIpcQQGameIpcHandle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.ipc.QQGameIpcHandle.1.1
 * JD-Core Version:    0.7.0.1
 */