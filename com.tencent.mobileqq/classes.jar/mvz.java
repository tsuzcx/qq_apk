import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class mvz
  implements BusinessObserver
{
  mvz(mvv parammvv) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "follow success");
          }
          this.a.a = true;
          mvv.a(this.a);
          return;
        }
        if (paramInt == 58)
        {
          mvv.a(this.a, 2131430024);
          return;
        }
        if (paramInt == 65)
        {
          mvv.a(this.a, 2131430025);
          return;
        }
        mvv.a(this.a, 2131430016);
        return;
        mvv.a(this.a, 2131430016);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvz
 * JD-Core Version:    0.7.0.1
 */