package com.tencent.mobileqq.qqexpand.downloader;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.chat.LimitChatRes;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil;
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
    LimitChatRes localLimitChatRes = (LimitChatRes)paramNetResp.mReq.getUserData();
    if (localLimitChatRes != null)
    {
      if (paramNetResp.mResult != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LimitChatDownloaderListener file failed. errorCode: ");
        ((StringBuilder)localObject).append(paramNetResp.mErrCode);
        ((StringBuilder)localObject).append(", errorMsg: ");
        ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
        ((StringBuilder)localObject).append(", file: ");
        ((StringBuilder)localObject).append(localLimitChatRes.b);
        QLog.e("ExtendFriendResourceDownloader", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        if (localLimitChatRes.c.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath))) {
          break label221;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LimitChatDownloaderListener file failed: ");
        ((StringBuilder)localObject).append(localLimitChatRes.b);
        ((StringBuilder)localObject).append("md5 is not match. ：");
        ((StringBuilder)localObject).append(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath));
        ((StringBuilder)localObject).append(" infomd5:");
        ((StringBuilder)localObject).append(localLimitChatRes.c);
        QLog.e("ExtendFriendResourceDownloader", 2, ((StringBuilder)localObject).toString());
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      }
      int i = 0;
      break label318;
      label221:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LimitChatDownloaderListener resFile success. file: ");
        ((StringBuilder)localObject).append(localLimitChatRes.a);
        ((StringBuilder)localObject).append(localLimitChatRes.b);
        QLog.i("ExtendFriendResourceDownloader", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = ExpandLimitChatResourceUtil.c();
      boolean bool = ExtendFriendResourceDownloader.b(this.a.this$0, paramNetResp.mReq.mOutPath, (String)localObject);
      i = bool;
      if (!bool)
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
        i = bool;
      }
      label318:
      if ((i != 0) && (ExtendFriendResourceDownloader.a(this.a.this$0, localLimitChatRes)))
      {
        ((IExpandHandler)ExtendFriendResourceDownloader.a(this.a.this$0).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      ExtendFriendResourceDownloader.a(this.a.this$0, localLimitChatRes);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader.3.1
 * JD-Core Version:    0.7.0.1
 */