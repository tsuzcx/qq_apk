package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PasswdRedBagServiceImpl$3
  implements Runnable
{
  PasswdRedBagServiceImpl$3(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((IMessageFacade)PasswdRedBagServiceImpl.access$600(this.this$0).getRuntimeService(IMessageFacade.class)).getMsgList(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForQQWalletMsg))
        {
          localObject2 = (MessageForQQWalletMsg)localObject2;
          if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg != null)
          {
            Object localObject3 = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
            localObject3 = this.this$0.getPasswdRedBagInfoById(((QQWalletRedPacketMsg)localObject3).redPacketId);
            if ((localObject3 != null) && (((PasswdRedBagInfo)localObject3).jdField_a_of_type_Int == 4) && (!((PasswdRedBagInfo)localObject3).b)) {
              localArrayList.add(((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.redPacketId);
            }
          }
        }
      }
    }
    this.this$0.refreshCureentIdomResbag(this.a, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */