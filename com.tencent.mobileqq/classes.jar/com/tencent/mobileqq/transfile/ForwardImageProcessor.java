package com.tencent.mobileqq.transfile;

import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class ForwardImageProcessor
  implements IHttpCommunicatorListener
{
  private QQAppInterface app;
  private String downloadProcessorKey;
  private String filepath;
  private String orgUin;
  private int orgUinType;
  private long orgUniseq;
  private String orgUrl;
  private String targetUin;
  private int targetUinType;
  private TransProcessorHandler thandler = new ForwardImageProcessor.1(this);
  private long uniseq;
  
  public ForwardImageProcessor(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    this.downloadProcessorKey = paramString1;
    this.targetUinType = paramInt1;
    this.targetUin = paramString2;
    this.filepath = paramString3;
    this.orgUin = paramString5;
    this.app = paramQQAppInterface;
    this.uniseq = paramLong1;
    this.orgUrl = paramString4;
    this.orgUniseq = paramLong2;
    this.orgUinType = paramInt2;
    this.thandler.addFilter(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class });
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.thandler);
  }
  
  private void sendReceiveFailToUI()
  {
    stopListening();
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeProcessor(this.targetUin + this.uniseq);
    Message localMessage = new Message();
    localMessage.what = 1005;
    FileMsg localFileMsg = new FileMsg(this.targetUin, this.filepath, 0);
    localFileMsg.fileType = 1;
    localFileMsg.uniseq = this.uniseq;
    localMessage.obj = localFileMsg;
    localMessage.arg1 = 0;
    BaseTransProcessor.sendCustomMessageToUpdateDelay(localMessage, ForwardImageProcessor.class, 0L);
    this.app.getMessageFacade().a(this.targetUin, this.targetUinType, this.uniseq, this.orgUrl, this.orgUin, this.orgUniseq, this.orgUinType);
  }
  
  private void uploadImage()
  {
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeProcessor(this.targetUin + this.uniseq);
    if ((this.targetUinType == 1) || (this.targetUinType == 1001) || (this.targetUinType == 10002) || (this.targetUinType == 3000))
    {
      if (this.targetUinType == 1001) {}
      for (long l = AppSetting.c;; l = PicUploadFileSizeLimit.getLimitGroup())
      {
        int i = (int)l;
        if (new File(this.filepath).length() > i)
        {
          ImageUtil.a(-1L, this.targetUinType, true, "group_compress", "ForwardImageProcessor.uploadImage");
          this.filepath = ImageUtil.a(this.app.getApp().getBaseContext(), this.filepath, i);
        }
        if (ImageUtil.a(null, this.filepath, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
          break;
        }
        return;
      }
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = this.app.getAccount();
    localTransferRequest.mPeerUin = this.targetUin;
    localTransferRequest.mUinType = this.targetUinType;
    localTransferRequest.mFileType = 1;
    localTransferRequest.mUniseq = this.uniseq;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = 1009;
    localTransferRequest.mLocalPath = this.filepath;
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void handleRedirect(String paramString) {}
  
  public void setId(long paramLong)
  {
    this.uniseq = paramLong;
  }
  
  public void startListen()
  {
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).addHandle(this.thandler);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return false;
  }
  
  public void stopListening()
  {
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.thandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardImageProcessor
 * JD-Core Version:    0.7.0.1
 */