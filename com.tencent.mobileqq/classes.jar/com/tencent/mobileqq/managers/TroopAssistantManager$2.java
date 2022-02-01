package com.tencent.mobileqq.managers;

import axan;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import nkm;
import nkq;
import tencent.im.oidb.cmd0x72d.cmd0x72d.ReqBody;

public class TroopAssistantManager$2
  implements Runnable
{
  public TroopAssistantManager$2(axan paramaxan, QQAppInterface paramQQAppInterface, nkq paramnkq) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    cmd0x72d.ReqBody localReqBody = new cmd0x72d.ReqBody();
    localReqBody.rpt_uint64_groupcode.set(localList);
    nkm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nkq, localReqBody.toByteArray(), "OidbSvc.0x72d_0", 1837, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */