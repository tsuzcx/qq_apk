package com.tencent.mobileqq.qwallet.hb.grap.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class RedPacketEmojiFragment$3$1
  implements Runnable
{
  RedPacketEmojiFragment$3$1(RedPacketEmojiFragment.3 param3, int paramInt, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("face config doLoading result:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",pathres=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult);
      QLog.i("RedPacketEmojiFragment", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketEmojiFragment$3.a.b = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath;
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketEmojiFragment$3.a.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketEmojiFragment$3.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */