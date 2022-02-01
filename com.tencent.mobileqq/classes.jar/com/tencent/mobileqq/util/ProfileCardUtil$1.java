package com.tencent.mobileqq.util;

import android.content.Intent;
import com.tencent.av.config.ByteBuffer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

final class ProfileCardUtil$1
  implements Runnable
{
  ProfileCardUtil$1(String paramString, Intent paramIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    byte b1 = 0;
    Object localObject3 = new CompressInfo((String)localObject1, 0);
    ((CompressInfo)localObject3).o = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject3);
    localObject1 = this.b;
    Object localObject2;
    boolean bool1;
    if (localObject1 != null)
    {
      boolean bool2 = ((Intent)localObject1).getBooleanExtra("PhotoConst.SYNCQZONE", false);
      localObject2 = this.b.getStringExtra("PhotoConst.SOURCE_FROM");
      if ("FROM_SELECT_PHOTO".equals(localObject2))
      {
        i = 1;
        bool1 = bool2;
        localObject1 = localObject2;
        break label137;
      }
      bool1 = bool2;
      localObject1 = localObject2;
      if ("FROM_TAKE_PHOTO".equals(localObject2))
      {
        i = 2;
        bool1 = bool2;
        localObject1 = localObject2;
        break label137;
      }
    }
    else
    {
      localObject1 = "";
      bool1 = false;
    }
    int i = 3;
    label137:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(".uploadPhoto(), img_path = ");
      ((StringBuilder)localObject2).append(((CompressInfo)localObject3).l);
      ((StringBuilder)localObject2).append(",isSyncQZone=");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, ((StringBuilder)localObject2).toString());
    }
    if (!StringUtil.isEmpty(((CompressInfo)localObject3).l))
    {
      localObject2 = new TransferRequest();
      ((TransferRequest)localObject2).mIsUp = true;
      ((TransferRequest)localObject2).mLocalPath = ((CompressInfo)localObject3).l;
      ((TransferRequest)localObject2).mFileType = 22;
      localObject3 = new ByteBuffer();
      if (bool1) {
        b1 = 1;
      }
      ((ByteBuffer)localObject3).a(b1);
      ((TransferRequest)localObject2).mExtentionInfo = ((ByteBuffer)localObject3).a();
      ((TransferRequest)localObject2).mUpCallBack = new ProfileCardUtil.1.1(this, bool1, (String)localObject1);
      ((ITransFileController)this.c.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject2);
      if (bool1)
      {
        int j = this.b.getIntExtra("PhotoConst.SYNCQZONE_CHECKSTATE", 1);
        ReportController.b(this.c, "dc00898", "", "", "0X8007C16", "0X8007C16", j, 0, "", "", "", "");
      }
      ReportController.b(this.c, "dc00898", "", "", "0X8007C17", "0X8007C17", i, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */