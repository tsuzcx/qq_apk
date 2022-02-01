package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class ForwardSdkShareProcessor$GetAppInfoStep$1
  implements BusinessObserver
{
  ForwardSdkShareProcessor$GetAppInfoStep$1(ForwardSdkShareProcessor.GetAppInfoStep paramGetAppInfoStep) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|isSuccess=" + paramBoolean + ",time=" + (System.currentTimeMillis() - ForwardSdkShareProcessor.access$600(this.this$1.this$0)));
    int i = -1;
    paramInt = i;
    if (paramBoolean) {
      paramInt = i;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
        paramInt = i;
        localGetAppinfoResponse.mergeFrom(paramBundle);
        paramInt = i;
        i = localGetAppinfoResponse.ret.get();
        paramInt = i;
        if (QLog.isColorLevel())
        {
          paramInt = i;
          QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|ret=" + i);
        }
        paramInt = i;
        if (i == 0)
        {
          paramInt = i;
          this.this$1.this$0.mAppInfo.sourceIconSmall = Share.a(localGetAppinfoResponse.iconsURL, 16);
          paramInt = i;
          this.this$1.this$0.mAppInfo.sourceIconBig = Share.a(localGetAppinfoResponse.iconsURL, 100);
          paramInt = i;
          if (localGetAppinfoResponse.androidInfo != null)
          {
            paramInt = i;
            paramBundle = localGetAppinfoResponse.androidInfo;
            paramInt = i;
            if (paramBundle.packName.has())
            {
              paramInt = i;
              this.this$1.this$0.mAppInfo.packName = paramBundle.packName.get();
            }
            paramInt = i;
            if (paramBundle.messagetail.has())
            {
              paramInt = i;
              this.this$1.this$0.mAppInfo.sourceName = paramBundle.messagetail.get();
            }
            paramInt = i;
            if (paramBundle.sourceUrl.has())
            {
              paramInt = i;
              if (ForwardSdkShareProcessor.access$400(this.this$1.this$0) != Long.parseLong("1103584836"))
              {
                paramInt = i;
                this.this$1.this$0.mAppInfo.sourceUrl = paramBundle.sourceUrl.get();
              }
            }
          }
          paramInt = i;
          this.this$1.this$0.mAppInfo.status = 1;
          paramInt = i;
          this.this$1.updateMessageRecord();
          paramInt = i;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("Q.share.ForwardSdkShareProcessor", 1, paramBundle, new Object[0]);
      }
      ForwardSdkShareProcessor.GetAppInfoStep.access$800(this.this$1).set(true);
      this.this$1.doNextStep();
    }
    if ((this.this$1.this$0.mAppInfo.status != 1) && (ForwardSdkShareProcessor.GetAppInfoStep.access$700(this.this$1) < 2) && (paramInt != 110507) && (paramInt != 110401))
    {
      ForwardSdkShareProcessor.GetAppInfoStep.access$708(this.this$1);
      this.this$1.process();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetAppInfoStep.1
 * JD-Core Version:    0.7.0.1
 */