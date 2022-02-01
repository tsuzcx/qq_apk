package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetGroupRedPackListRsp;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetAvailableListListener;
import java.util.HashMap;

class RedPacketManagerImpl$6$1
  implements Runnable
{
  RedPacketManagerImpl$6$1(RedPacketManagerImpl.6 param6, GetGroupRedPackListRsp paramGetGroupRedPackListRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.this$0.mReqGroupAvailableListListeners != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.this$0.mReqGroupAvailableListListeners;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.b);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.jdField_a_of_type_Int);
      if (((HashMap)localObject).get(localStringBuilder.toString()) != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.this$0.mReqGroupAvailableListListeners;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.b);
        localStringBuilder.append("_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.jdField_a_of_type_Int);
        localObject = (IRedPacket.OnGetAvailableListListener)((HashMap)localObject).get(localStringBuilder.toString());
        break label141;
      }
    }
    Object localObject = null;
    label141:
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.this$0.filterHbHasGrabbed(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.b, this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$6.jdField_a_of_type_Int, (IRedPacket.OnGetAvailableListListener)localObject, this.jdField_a_of_type_WalletGetGroupRedPackListRsp, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.6.1
 * JD-Core Version:    0.7.0.1
 */