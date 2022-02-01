package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class NearbyProfileEditTribePanel$16
  implements Runnable
{
  NearbyProfileEditTribePanel$16(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    NearbyProfileEditTribePanel.a((NearbyProfileEditTribePanel)localObject1, (PicInfo)((NearbyProfileEditTribePanel)localObject1).C.poll());
    if (NearbyProfileEditTribePanel.c(this.this$0) == null) {
      return;
    }
    localObject1 = new CompressInfo(NearbyProfileEditTribePanel.c(this.this$0).d, 0);
    ((CompressInfo)localObject1).o = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject1);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Q.nearby_people_card..uploadPhoto(), img_path = ");
      ((StringBuilder)localObject2).append(((CompressInfo)localObject1).l);
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, ((StringBuilder)localObject2).toString());
    }
    if (!StringUtil.isEmpty(((CompressInfo)localObject1).l))
    {
      localObject2 = new TransferRequest();
      ((TransferRequest)localObject2).mIsUp = true;
      ((TransferRequest)localObject2).mLocalPath = ((CompressInfo)localObject1).l;
      ((TransferRequest)localObject2).mFileType = 8;
      ((ITransFileController)this.this$0.A.app.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject2);
      return;
    }
    this.this$0.A.runOnUiThread(new NearbyProfileEditTribePanel.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.16
 * JD-Core Version:    0.7.0.1
 */