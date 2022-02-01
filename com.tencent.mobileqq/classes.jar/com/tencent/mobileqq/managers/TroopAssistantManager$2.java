package com.tencent.mobileqq.managers;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import tencent.im.oidb.cmd0x72d.cmd0x72d.ReqBody;

class TroopAssistantManager$2
  implements Runnable
{
  TroopAssistantManager$2(TroopAssistantManager paramTroopAssistantManager, QQAppInterface paramQQAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver) {}
  
  public void run()
  {
    List localList = this.this$0.k(this.a);
    cmd0x72d.ReqBody localReqBody = new cmd0x72d.ReqBody();
    localReqBody.rpt_uint64_groupcode.set(localList);
    ProtoUtils.b(this.a, this.b, localReqBody.toByteArray(), "OidbSvc.0x72d_0", 1837, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */