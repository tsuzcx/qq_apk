package com.tencent.mobileqq.kandian.biz.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.FileUploadController.FileUploadListener;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyUploadAvatarFragment$4
  implements FileUploadController.FileUploadListener
{
  ReadInJoyUploadAvatarFragment$4(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment) {}
  
  public void a() {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = ReadInJoyUploadAvatarFragment.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onFileTransferFinished,retCode:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("  fileUrl:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("  fileMd5:");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("  uuid:");
    ((StringBuilder)localObject2).append(paramString3);
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = this.a.getBaseActivity();
    if (localObject1 == null)
    {
      QLog.e(ReadInJoyUploadAvatarFragment.a, 1, "onFileTransferFinished activity = null");
      return;
    }
    localObject2 = new Bundle();
    int i = 3;
    paramString2 = "";
    if (paramInt != 0)
    {
      switch (paramInt)
      {
      default: 
        paramString1 = ReadInJoyUploadAvatarFragment.a;
        paramString3 = new StringBuilder();
        paramString3.append("onFileTransferFinished no handler, retCode=");
        paramString3.append(paramInt);
        QLog.e(paramString1, 1, paramString3.toString());
        paramString1 = "";
        paramInt = i;
        break;
      case 1004: 
        paramString1 = HardCodeUtil.a(2131712757);
        paramInt = i;
        break;
      case 1003: 
        paramString1 = HardCodeUtil.a(2131712790);
        paramInt = i;
        break;
      case 1002: 
        paramString1 = HardCodeUtil.a(2131712985);
        break;
      case 1001: 
        paramString1 = HardCodeUtil.a(2131713050);
      }
      paramInt = 2;
    }
    else
    {
      paramInt = 0;
      paramString3 = HardCodeUtil.a(2131713045);
      paramString2 = paramString1;
      paramString1 = paramString3;
    }
    ((Bundle)localObject2).putInt("retCode", paramInt);
    ((Bundle)localObject2).putString("msg", paramString1);
    ((Bundle)localObject2).putString("url", paramString2);
    paramString1 = ((Activity)localObject1).getIntent();
    paramString1.putExtra("Bundle", (Bundle)localObject2);
    ((Activity)localObject1).setResult(-1, paramString1);
    ((Activity)localObject1).finish();
  }
  
  public void a(long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment.4
 * JD-Core Version:    0.7.0.1
 */