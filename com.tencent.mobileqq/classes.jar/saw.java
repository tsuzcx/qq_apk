import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class saw
  implements BusinessObserver
{
  saw(sau paramsau, sat paramsat) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Sat.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((sau.a(this.jdField_a_of_type_Sau) != null) && (sau.a(this.jdField_a_of_type_Sau).isResume())) {
      sau.a(this.jdField_a_of_type_Sau).b(false);
    }
    if (!paramBoolean) {
      sau.a(this.jdField_a_of_type_Sau);
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
            sau.b(this.jdField_a_of_type_Sau, this.jdField_a_of_type_Sat);
            StructLongMessageDownloadProcessor.a(sau.a(this.jdField_a_of_type_Sau), this.jdField_a_of_type_Sat.a);
            ((bajo)sau.a(this.jdField_a_of_type_Sau).getManager(132)).a(this.jdField_a_of_type_Sat.a);
            return;
          }
          sau.a(this.jdField_a_of_type_Sau);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     saw
 * JD-Core Version:    0.7.0.1
 */