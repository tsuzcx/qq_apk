package com.tencent.mobileqq.qwallet.transaction.impl;

import Wallet.PfaFriendRsp;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

final class ToPayManagerImpl$2
  implements Runnable
{
  public void run()
  {
    if (ToPayManagerImpl.mData == null) {
      return;
    }
    Object localObject1 = QWalletTools.b();
    if (localObject1 != null) {}
    try
    {
      localObject1 = ((BaseQQAppInterface)localObject1).getCurrentAccountUin();
      break label26;
      localObject1 = "";
      label26:
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(QWalletValues.e);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (ToPayManagerImpl.mBusinessType == 1)
      {
        localObject1 = localObject2;
        if (ToPayManagerImpl.mBusinessSubType > 0)
        {
          localObject1 = localObject2;
          if (ToPayManagerImpl.mBusinessSubType < 3)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("_");
            ((StringBuilder)localObject1).append(ToPayManagerImpl.mBusinessType);
            ((StringBuilder)localObject1).append("_");
            ((StringBuilder)localObject1).append(ToPayManagerImpl.mBusinessSubType);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      ToPayManagerImpl.mData.writeTo((JceOutputStream)localObject2);
      FileUtils.writeFile(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */