package com.tencent.mobileqq.managers;

import auam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import mzy;
import nac;
import tencent.im.oidb.cmd0x72d.cmd0x72d.ReqBody;

public class TroopAssistantManager$2
  implements Runnable
{
  public TroopAssistantManager$2(auam paramauam, QQAppInterface paramQQAppInterface, nac paramnac) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    cmd0x72d.ReqBody localReqBody = new cmd0x72d.ReqBody();
    localReqBody.rpt_uint64_groupcode.set(localList);
    mzy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nac, localReqBody.toByteArray(), "OidbSvc.0x72d_0", 1837, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */