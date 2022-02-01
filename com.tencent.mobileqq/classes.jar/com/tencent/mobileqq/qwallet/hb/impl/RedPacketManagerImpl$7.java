package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetGroupRedPackListRsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class RedPacketManagerImpl$7
  implements Runnable
{
  RedPacketManagerImpl$7(RedPacketManagerImpl paramRedPacketManagerImpl, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (TextUtils.isEmpty(this.b)) {
        return;
      }
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(QWalletValues.f);
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(this.d);
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        localObject2 = new JceOutputStream();
        ((JceOutputStream)localObject2).setServerEncoding("utf-8");
        this.a.writeTo((JceOutputStream)localObject2);
        FileUtils.writeFile(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */