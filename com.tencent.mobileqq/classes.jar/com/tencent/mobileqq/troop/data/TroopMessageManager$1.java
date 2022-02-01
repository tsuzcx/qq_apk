package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import mqq.app.AppRuntime;

class TroopMessageManager$1
  implements Runnable
{
  TroopMessageManager$1(TroopMessageManager paramTroopMessageManager, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = (ITroopBatchAddFriendService)this.this$0.a.getRuntimeService(ITroopBatchAddFriendService.class, "");
    if (localObject != null)
    {
      localObject = ((ITroopBatchAddFriendService)localObject).getTroopBatchAddFriendMgr();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageManager.1
 * JD-Core Version:    0.7.0.1
 */