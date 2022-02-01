package com.tencent.mobileqq.qwallet.transaction.impl;

import Wallet.PfaFriendRsp;
import android.os.Handler;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class ToPayManagerImpl$1
  implements Runnable
{
  ToPayManagerImpl$1(ToPayManagerImpl paramToPayManagerImpl, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = QWalletTools.a();
    Object localObject4 = null;
    Object localObject3 = null;
    if (localObject1 != null) {}
    try
    {
      localObject1 = ((BaseQQAppInterface)localObject1).getCurrentAccountUin();
      break label24;
      localObject1 = "";
      label24:
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(QWalletValues.e);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject2 = localObject1;
        if (this.b > 0)
        {
          localObject2 = localObject1;
          if (this.b < 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("_");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject2).append("_");
            ((StringBuilder)localObject2).append(this.b);
            localObject2 = ((StringBuilder)localObject2).toString();
          }
        }
      }
      localObject1 = localObject4;
      if (new File((String)localObject2).exists())
      {
        localObject2 = FileUtils.readFile((String)localObject2);
        localObject1 = localObject4;
        if (localObject2 != null)
        {
          localObject1 = localObject4;
          if (localObject2.length > 0)
          {
            localObject2 = new JceInputStream((byte[])localObject2);
            ((JceInputStream)localObject2).setServerEncoding("utf-8");
            localObject1 = new PfaFriendRsp();
            try
            {
              ((PfaFriendRsp)localObject1).readFrom((JceInputStream)localObject2);
            }
            catch (Exception localException1) {}
            localException2.printStackTrace();
          }
        }
      }
    }
    catch (Exception localException2)
    {
      localObject1 = localObject3;
    }
    ToPayManagerImpl.mLoadedFromFileState = 0;
    ToPayManagerImpl.mHandler.post(new ToPayManagerImpl.1.1(this, (PfaFriendRsp)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */