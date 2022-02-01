package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;

class GuildQQWalletMsgItemBuilder$1
  implements Runnable
{
  GuildQQWalletMsgItemBuilder$1(GuildQQWalletMsgItemBuilder paramGuildQQWalletMsgItemBuilder, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    if (!QWalletHelperDelegate.isQWalletProcessExist(this.this$0.b))
    {
      if (QLog.isColorLevel())
      {
        String str = GuildQQWalletMsgItemBuilder.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preload qwallet process by qqWalletMsg isTroop=");
        localStringBuilder.append(this.a);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).preloadQWallet(this.this$0.g, 0, "qwallet_red");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildQQWalletMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */