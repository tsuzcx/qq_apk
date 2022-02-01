package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ForwardSdkShareProcessor$GetAppInfoStep$1
  implements OpensdkBusinessObserver
{
  ForwardSdkShareProcessor$GetAppInfoStep$1(ForwardSdkShareProcessor.GetAppInfoStep paramGetAppInfoStep) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GetAppInfoStep|isSuccess=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(",time=");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - ForwardSdkShareProcessor.access$600(this.this$1.this$0));
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject).toString());
    int i = -1;
    paramInt = i;
    if (paramBoolean) {
      try
      {
        localObject = paramBundle.getByteArray("data");
        paramInt = i;
        if (localObject != null)
        {
          paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          paramBundle.mergeFrom((byte[])localObject);
          paramInt = paramBundle.ret.get();
          try
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("GetAppInfoStep|ret=");
              ((StringBuilder)localObject).append(paramInt);
              QLog.i("Q.share.ForwardSdkShareProcessor", 2, ((StringBuilder)localObject).toString());
            }
            if (paramInt == 0)
            {
              this.this$1.this$0.mAppInfo.sourceIconSmall = Share.a(paramBundle.iconsURL, 16);
              this.this$1.this$0.mAppInfo.sourceIconBig = Share.a(paramBundle.iconsURL, 100);
              if (paramBundle.androidInfo != null)
              {
                paramBundle = paramBundle.androidInfo;
                if (paramBundle.packName.has()) {
                  this.this$1.this$0.mAppInfo.packName = paramBundle.packName.get();
                }
                if (paramBundle.messagetail.has()) {
                  this.this$1.this$0.mAppInfo.sourceName = paramBundle.messagetail.get();
                }
                if ((paramBundle.sourceUrl.has()) && (ForwardSdkShareProcessor.access$400(this.this$1.this$0) != Long.parseLong("1103584836"))) {
                  this.this$1.this$0.mAppInfo.sourceUrl = paramBundle.sourceUrl.get();
                }
              }
              this.this$1.this$0.mAppInfo.status = 1;
              this.this$1.updateMessageRecord();
            }
          }
          catch (Exception paramBundle) {}
          QLog.e("Q.share.ForwardSdkShareProcessor", 1, paramBundle, new Object[0]);
        }
      }
      catch (Exception paramBundle)
      {
        paramInt = i;
      }
    }
    if ((this.this$1.this$0.mAppInfo.status != 1) && (ForwardSdkShareProcessor.GetAppInfoStep.access$700(this.this$1) < 2) && (paramInt != 110507) && (paramInt != 110401))
    {
      ForwardSdkShareProcessor.GetAppInfoStep.access$708(this.this$1);
      this.this$1.process();
      return;
    }
    ForwardSdkShareProcessor.GetAppInfoStep.access$800(this.this$1).set(true);
    this.this$1.doNextStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetAppInfoStep.1
 * JD-Core Version:    0.7.0.1
 */