package com.tencent.mobileqq.vas.avatar;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;

class VasFaceManager$2
  implements Runnable
{
  VasFaceManager$2(VasFaceManager paramVasFaceManager, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getExtensionInfo(this.a, true);
    if ((localObject != null) && (((ExtensionInfo)localObject).faceIdUpdateTime != 0L))
    {
      this.this$0.a(this.a, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestFaceId uin: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.qqhead.VasFaceManager", 2, ((StringBuilder)localObject).toString());
    }
    AvatarPendantUtil.a(this.a);
    AvatarPendantUtil.a(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager.2
 * JD-Core Version:    0.7.0.1
 */