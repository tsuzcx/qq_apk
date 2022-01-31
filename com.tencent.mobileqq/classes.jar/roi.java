import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class roi
  implements BusinessObserver
{
  roi(rog paramrog, rof paramrof) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Rof.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((rog.a(this.jdField_a_of_type_Rog) != null) && (rog.a(this.jdField_a_of_type_Rog).isResume())) {
      rog.a(this.jdField_a_of_type_Rog).b(false);
    }
    if (!paramBoolean) {
      rog.a(this.jdField_a_of_type_Rog);
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
            rog.b(this.jdField_a_of_type_Rog, this.jdField_a_of_type_Rof);
            StructLongMessageDownloadProcessor.a(rog.a(this.jdField_a_of_type_Rog), this.jdField_a_of_type_Rof.a);
            ((azhx)rog.a(this.jdField_a_of_type_Rog).getManager(132)).a(this.jdField_a_of_type_Rof.a);
            return;
          }
          rog.a(this.jdField_a_of_type_Rog);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     roi
 * JD-Core Version:    0.7.0.1
 */