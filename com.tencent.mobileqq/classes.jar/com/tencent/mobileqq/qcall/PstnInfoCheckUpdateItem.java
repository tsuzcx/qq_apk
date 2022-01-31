package com.tencent.mobileqq.qcall;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class PstnInfoCheckUpdateItem
  extends PstnHandler
  implements CheckUpdateItemInterface
{
  private int jdField_a_of_type_Int;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  
  public PstnInfoCheckUpdateItem(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnInfoCheckUpdateItem", 2, "=== PstnInfoCheckUpdateItem getCheckUpdateItemData serviceId: " + this.jdField_a_of_type_Int);
    }
    Object localObject2 = null;
    if (this.jdField_a_of_type_Int == 128) {
      super.b();
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
      {
        BaseProtocolCoder localBaseProtocolCoder = this.b.a.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
        localObject1 = localObject2;
        if (localBaseProtocolCoder != null)
        {
          UniPacket localUniPacket = new UniPacket(true);
          localUniPacket.setEncodeName("utf-8");
          localObject1 = localObject2;
          if (localBaseProtocolCoder.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localUniPacket))
          {
            localObject1 = new ReqItem();
            ((ReqItem)localObject1).eServiceID = this.jdField_a_of_type_Int;
            ((ReqItem)localObject1).vecParam = localUniPacket.encode();
          }
        }
      }
      return localObject1;
      if (this.jdField_a_of_type_Int == 129) {
        super.a(this.b.getCurrentAccountUin());
      }
    }
  }
  
  public void a(RespItem paramRespItem)
  {
    Object localObject = "";
    if (paramRespItem.eServiceID == 128) {
      localObject = "OidbSvc.0x4f1_0";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnInfoCheckUpdateItem", 2, "=== PstnInfoCheckUpdateItem handleCheckUpdateItemData serviceCmd: " + (String)localObject + ",result: " + paramRespItem.cResult);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramRespItem.cResult == 2))
      {
        localObject = new FromServiceMsg(this.b.getAccount(), (String)localObject);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).putWupBuffer(paramRespItem.vecUpdate);
        this.b.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject);
      }
      return;
      if (paramRespItem.eServiceID == 129) {
        localObject = "OidbSvc.0x5eb_47";
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.PstnInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */