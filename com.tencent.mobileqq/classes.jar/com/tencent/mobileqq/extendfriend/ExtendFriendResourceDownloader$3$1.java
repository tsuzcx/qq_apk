package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager.LimitChatRes;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatResourceUtil;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendResourceDownloader$3$1
  implements INetEngineListener
{
  ExtendFriendResourceDownloader$3$1(ExtendFriendResourceDownloader.3 param3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i = 0;
    ExpandConfigManager.LimitChatRes localLimitChatRes = (ExpandConfigManager.LimitChatRes)paramNetResp.mReq.getUserData();
    if (localLimitChatRes != null)
    {
      if (paramNetResp.mResult == 0) {
        break label148;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localLimitChatRes.b);
    }
    for (;;)
    {
      if ((i != 0) && (ExtendFriendResourceDownloader.a(this.a.this$0, localLimitChatRes)))
      {
        ((ExtendFriendHandler)ExtendFriendResourceDownloader.a(this.a.this$0).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      ExtendFriendResourceDownloader.a(this.a.this$0, localLimitChatRes);
      return;
      label148:
      if (!localLimitChatRes.c.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localLimitChatRes.b + "md5 is not match. ：" + SecUtil.getFileMd5(paramNetResp.mReq.mOutPath) + " infomd5:" + localLimitChatRes.c);
        FileUtils.e(paramNetResp.mReq.mOutPath);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localLimitChatRes.a + localLimitChatRes.b);
        }
        String str = ExtendFriendLimitChatResourceUtil.c();
        boolean bool = ExtendFriendResourceDownloader.b(this.a.this$0, paramNetResp.mReq.mOutPath, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.3.1
 * JD-Core Version:    0.7.0.1
 */