import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class mxg
  implements BusinessObserver
{
  mxg(mxc parammxc) {}
  
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
          mxc.a(this.a);
          return;
        }
        if (paramInt == 58)
        {
          mxc.a(this.a, 2131430041);
          return;
        }
        if (paramInt == 65)
        {
          mxc.a(this.a, 2131430042);
          return;
        }
        mxc.a(this.a, 2131430033);
        return;
        mxc.a(this.a, 2131430033);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxg
 * JD-Core Version:    0.7.0.1
 */