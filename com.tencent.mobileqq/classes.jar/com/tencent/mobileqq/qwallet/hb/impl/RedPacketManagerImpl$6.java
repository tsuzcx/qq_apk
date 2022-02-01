package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetGroupRedPackListRsp;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.os.MqqHandler;

class RedPacketManagerImpl$6
  implements Runnable
{
  RedPacketManagerImpl$6(RedPacketManagerImpl paramRedPacketManagerImpl, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    JceInputStream localJceInputStream = null;
    Object localObject2 = null;
    Object localObject1;
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(QWalletValues.f);
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      Object localObject3 = ((StringBuilder)localObject1).toString();
      localObject1 = localJceInputStream;
      if (new File((String)localObject3).exists())
      {
        localObject3 = FileUtils.readFile((String)localObject3);
        localObject1 = localJceInputStream;
        if (localObject3 != null)
        {
          localObject1 = localJceInputStream;
          if (localObject3.length > 0)
          {
            localJceInputStream = new JceInputStream((byte[])localObject3);
            localJceInputStream.setServerEncoding("utf-8");
            localObject1 = new GetGroupRedPackListRsp();
            try
            {
              ((GetGroupRedPackListRsp)localObject1).readFrom(localJceInputStream);
            }
            catch (Throwable localThrowable1) {}
            localThrowable2.printStackTrace();
          }
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      localObject1 = localObject2;
    }
    ThreadManager.getUIHandler().post(new RedPacketManagerImpl.6.1(this, (GetGroupRedPackListRsp)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */