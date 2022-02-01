package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetSkinListRsp;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

class RedPacketManagerImpl$2$1
  implements Runnable
{
  RedPacketManagerImpl$2$1(RedPacketManagerImpl.2 param2, GetSkinListRsp paramGetSkinListRsp) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("utf-8");
      this.a.writeTo((JceOutputStream)localObject);
      localObject = ((JceOutputStream)localObject).toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MobileQQ.getContext().getFilesDir());
      localStringBuilder.append("skins");
      localStringBuilder.append(this.b.b.getCurrentAccountUin());
      FileUtils.writeFile((byte[])localObject, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.2.1
 * JD-Core Version:    0.7.0.1
 */