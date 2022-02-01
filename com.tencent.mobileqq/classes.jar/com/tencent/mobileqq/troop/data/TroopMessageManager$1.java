package com.tencent.mobileqq.troop.data;

import aoep;
import bfjz;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;

public class TroopMessageManager$1
  implements Runnable
{
  public TroopMessageManager$1(bfjz parambfjz, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = (aoep)bfjz.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localObject != null)
    {
      localObject = ((aoep)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageManager.1
 * JD-Core Version:    0.7.0.1
 */