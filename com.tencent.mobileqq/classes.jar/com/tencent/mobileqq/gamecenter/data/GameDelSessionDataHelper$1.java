package com.tencent.mobileqq.gamecenter.data;

import com.tencent.mobileqq.gamecenter.msginfo.GameDelSessionRecord;

final class GameDelSessionDataHelper$1
  implements Runnable
{
  GameDelSessionDataHelper$1(IDataVisitor paramIDataVisitor, String paramString) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
    localGameDelSessionRecord.mUin = this.b;
    this.a.c(localGameDelSessionRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper.1
 * JD-Core Version:    0.7.0.1
 */