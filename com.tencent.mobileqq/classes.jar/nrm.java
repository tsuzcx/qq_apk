import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetRefuseFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class nrm
  implements BusinessObserver
{
  nrm(nrc paramnrc, NewIntent paramNewIntent, nrs paramnrs) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, "success:" + String.valueOf(paramBoolean));
    }
    bool = paramBoolean;
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      mobileqq_mp.SetRefuseFollowResponse localSetRefuseFollowResponse = new mobileqq_mp.SetRefuseFollowResponse();
      localSetRefuseFollowResponse.mergeFrom(paramBundle);
      bool = paramBoolean;
      if (localSetRefuseFollowResponse.ret_info.has())
      {
        bool = paramBoolean;
        if (localSetRefuseFollowResponse.ret_info.ret_code.has())
        {
          paramInt = localSetRefuseFollowResponse.ret_info.ret_code.get();
          bool = paramBoolean;
          if (paramInt != 0L) {
            bool = false;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool = false;
      }
    }
    if (this.jdField_a_of_type_Nrs != null) {
      this.jdField_a_of_type_Nrs.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nrm
 * JD-Core Version:    0.7.0.1
 */