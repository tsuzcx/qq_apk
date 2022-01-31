import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ssm
  implements BusinessObserver
{
  ssm(ssk paramssk, ssj paramssj) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Ssj.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((ssk.a(this.jdField_a_of_type_Ssk) != null) && (ssk.a(this.jdField_a_of_type_Ssk).isResume())) {
      ssk.a(this.jdField_a_of_type_Ssk).b(false);
    }
    if (!paramBoolean) {
      ssk.a(this.jdField_a_of_type_Ssk);
    }
    for (;;)
    {
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
            }
            ssk.b(this.jdField_a_of_type_Ssk, this.jdField_a_of_type_Ssj);
            StructLongMessageDownloadProcessor.a(ssk.a(this.jdField_a_of_type_Ssk), this.jdField_a_of_type_Ssj.a);
            ((bcic)ssk.a(this.jdField_a_of_type_Ssk).getManager(132)).a(this.jdField_a_of_type_Ssj.a);
            return;
          }
          ssk.a(this.jdField_a_of_type_Ssk);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ssm
 * JD-Core Version:    0.7.0.1
 */