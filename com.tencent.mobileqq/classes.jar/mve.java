import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public final class mve
  implements BusinessObserver
{
  public mve(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
        if ((localGetPublicAccountDetailInfoResponse.ret_info.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0))
        {
          ThreadManager.getSubThreadHandler().postDelayed(new mvf(this, localGetPublicAccountDetailInfoResponse), 10L);
          return;
        }
        PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
        return;
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mve
 * JD-Core Version:    0.7.0.1
 */