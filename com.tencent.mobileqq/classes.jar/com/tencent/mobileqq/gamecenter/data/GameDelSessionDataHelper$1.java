package com.tencent.mobileqq.gamecenter.data;

import com.tencent.mobileqq.gamecenter.msgInfo.GameDelSessionRecord;

final class GameDelSessionDataHelper$1
  implements Runnable
{
  GameDelSessionDataHelper$1(IDataVisitor paramIDataVisitor, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataIDataVisitor == null) {
      return;
    }
    GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
    localGameDelSessionRecord.mUin = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataIDataVisitor.c(localGameDelSessionRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper.1
 * JD-Core Version:    0.7.0.1
 */