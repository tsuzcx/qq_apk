package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetSkinListRsp;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.app.MobileQQ;

class RedPacketManagerImpl$1
  implements Runnable
{
  RedPacketManagerImpl$1(RedPacketManagerImpl paramRedPacketManagerImpl, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(MobileQQ.sMobileQQ.getFilesDir());
      ((StringBuilder)localObject).append("skins");
      ((StringBuilder)localObject).append(this.a.getCurrentAccountUin());
      localObject = FileUtils.readFile(((StringBuilder)localObject).toString());
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = new JceInputStream((byte[])localObject);
        ((JceInputStream)localObject).setServerEncoding("utf-8");
        GetSkinListRsp localGetSkinListRsp = new GetSkinListRsp();
        localGetSkinListRsp.readFrom((JceInputStream)localObject);
        this.a.runOnUiThread(new RedPacketManagerImpl.1.1(this, localGetSkinListRsp));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */