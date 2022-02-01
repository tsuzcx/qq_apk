package com.tencent.mobileqq.troop.redpoint;

import java.util.HashSet;

class RedPointInfoManager$1
  implements Runnable
{
  RedPointInfoManager$1(RedPointInfoManager paramRedPointInfoManager, int paramInt, String paramString1, String paramString2, RedPointInfo paramRedPointInfo) {}
  
  public void run()
  {
    RedPointInfoManager.1.1 local1 = new RedPointInfoManager.1.1(this);
    local1.add(Integer.valueOf(this.jdField_a_of_type_Int));
    RedPointInfoManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointInfo, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.RedPointInfoManager.1
 * JD-Core Version:    0.7.0.1
 */