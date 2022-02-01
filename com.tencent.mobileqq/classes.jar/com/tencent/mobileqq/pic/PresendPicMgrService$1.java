package com.tencent.mobileqq.pic;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class PresendPicMgrService$1
  implements UiCallBack
{
  PresendPicMgrService$1(PresendPicMgrService paramPresendPicMgrService, PicReq paramPicReq, PicUploadInfo paramPicUploadInfo) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, PicResult paramPicResult) {}
  
  public void a(int paramInt, ArrayList<PicResult> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, PicResult paramPicResult) {}
  
  public void c(int paramInt, PicResult arg2)
  {
    Object localObject1 = (UpCallBack.SendResult)???.d;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("PresendStatus: destPath:");
    ((StringBuilder)localObject3).append(this.a.g.n);
    ((StringBuilder)localObject3).append(",uuid:");
    ((StringBuilder)localObject3).append(this.a.c);
    ((StringBuilder)localObject3).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0) {
      ??? = "ResultOk";
    } else {
      ??? = "ResultFail";
    }
    ((StringBuilder)localObject3).append(???);
    Logger.a("PresendPicMgrService", "onSend ", ((StringBuilder)localObject3).toString());
    ??? = new StringBuilder();
    ???.append(" SendResult = ");
    ???.append(localObject1);
    Logger.a("PresendPicMgrService", "onSend", ???.toString());
    synchronized (this.c.b)
    {
      if (!this.b.z)
      {
        if (paramInt == 0) {
          this.a.g.h = 1;
        } else {
          this.a.g.h = 2;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SendButton not clicked, add senReq to mUploadFinishList,senReq = ");
        ((StringBuilder)localObject1).append(this.a);
        Logger.a("PresendPicMgrService", "onSend", ((StringBuilder)localObject1).toString());
        this.c.b.add(this.a);
      }
      else if (paramInt != 0) {}
      label393:
      try
      {
        localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(PresendPicMgrService.a(this.c));
        localObject3 = (MessageRecord)this.a.g.i;
        ((IOrderMediaMsgService)((QQAppInterface)localObject1).getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg((MessageRecord)localObject3, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SendButton has been clicked, sendMessage directly! ,senReq = ");
        ((StringBuilder)localObject1).append(this.a);
        Logger.a("PresendPicMgrService", "onSend", ((StringBuilder)localObject1).toString());
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        label327:
        break label327;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
        break label393;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onSend SendResult = ");
          ((StringBuilder)localObject3).append(localObject1);
          ((StringBuilder)localObject3).append(", upload failed");
          QLog.d("PresendPicMgrService", 2, ((StringBuilder)localObject3).toString());
        }
      }
      return;
    }
  }
  
  public void d(int paramInt, PicResult paramPicResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService.1
 * JD-Core Version:    0.7.0.1
 */