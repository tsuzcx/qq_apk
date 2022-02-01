package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.api.ITroopInfoService.GetTroopCodeCallback;
import mqq.os.MqqHandler;

class TroopInfoServiceImpl$2
  implements Runnable
{
  TroopInfoServiceImpl$2(TroopInfoServiceImpl paramTroopInfoServiceImpl, String paramString, ITroopInfoService.GetTroopCodeCallback paramGetTroopCodeCallback) {}
  
  public void run()
  {
    String str = this.this$0.getTroopCodeByTroopUin(this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new TroopInfoServiceImpl.2.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopInfoServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */