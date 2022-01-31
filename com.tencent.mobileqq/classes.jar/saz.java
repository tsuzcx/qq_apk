import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class saz
  implements BusinessObserver
{
  saz(sax paramsax, saw paramsaw) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Saw.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((sax.a(this.jdField_a_of_type_Sax) != null) && (sax.a(this.jdField_a_of_type_Sax).isResume())) {
      sax.a(this.jdField_a_of_type_Sax).b(false);
    }
    if (!paramBoolean) {
      sax.a(this.jdField_a_of_type_Sax);
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
            sax.b(this.jdField_a_of_type_Sax, this.jdField_a_of_type_Saw);
            StructLongMessageDownloadProcessor.a(sax.a(this.jdField_a_of_type_Sax), this.jdField_a_of_type_Saw.a);
            ((baja)sax.a(this.jdField_a_of_type_Sax).getManager(132)).a(this.jdField_a_of_type_Saw.a);
            return;
          }
          sax.a(this.jdField_a_of_type_Sax);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     saz
 * JD-Core Version:    0.7.0.1
 */