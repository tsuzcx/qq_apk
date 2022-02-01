package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AuthCodeItem;
import Wallet.AuthCodeRsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

class QWalletCommonJsPlugin$2
  implements Runnable
{
  QWalletCommonJsPlugin$2(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = FileUtils.readFile(this.val$cacheFileName);
      if (localObject1 == null)
      {
        QWalletCommonJsPlugin.access$000(this.this$0);
        return;
      }
      Object localObject2 = new JceInputStream((byte[])localObject1);
      localObject1 = new AuthCodeRsp();
      ((AuthCodeRsp)localObject1).readFrom((JceInputStream)localObject2);
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if (((AuthCodeRsp)localObject1).items != null)
      {
        int i = 0;
        while (i < ((AuthCodeRsp)localObject1).items.size())
        {
          if ((((AuthCodeRsp)localObject1).items.get(i) != null) && (((AuthCodeItem)((AuthCodeRsp)localObject1).items.get(i)).appid == QWalletCommonJsPlugin.access$100(this.this$0)) && (((AuthCodeItem)((AuthCodeRsp)localObject1).items.get(i)).expireTime > l))
          {
            localObject2 = this.this$0;
            ((QWalletCommonJsPlugin)localObject2).doAuthCodeCallback(QWalletCommonJsPlugin.access$200((QWalletCommonJsPlugin)localObject2), (AuthCodeItem)((AuthCodeRsp)localObject1).items.get(i));
            ((AuthCodeRsp)localObject1).items.remove(i);
            if (((AuthCodeRsp)localObject1).items.size() <= 0)
            {
              new File(this.val$cacheFileName).delete();
              return;
            }
            localObject2 = new JceOutputStream();
            ((AuthCodeRsp)localObject1).writeTo((JceOutputStream)localObject2);
            FileUtils.writeFile(((JceOutputStream)localObject2).toByteArray(), this.val$cacheFileName);
            return;
          }
          i += 1;
        }
      }
      QWalletCommonJsPlugin.access$000(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      label247:
      break label247;
    }
    QWalletCommonJsPlugin.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */