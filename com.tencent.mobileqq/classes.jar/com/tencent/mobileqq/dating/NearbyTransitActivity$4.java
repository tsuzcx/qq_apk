package com.tencent.mobileqq.dating;

import axei;
import bctj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class NearbyTransitActivity$4
  implements Runnable
{
  NearbyTransitActivity$4(int paramInt, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    bctj.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_JavaLangString, "actEnterHotChatAIO", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      axei.a("NearbyTransitActivity", "reportResult", new Object[] { "end of report" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity.4
 * JD-Core Version:    0.7.0.1
 */