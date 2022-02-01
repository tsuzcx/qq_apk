import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;

public class oez
  implements BusinessObserver
{
  public oez(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, "isSuccess: " + paramBoolean);
    }
    if (paramInt != 1) {}
    for (;;)
    {
      return;
      qq_ad.QQAdGetRsp localQQAdGetRsp = new qq_ad.QQAdGetRsp();
      try
      {
        localQQAdGetRsp.mergeFrom(paramBundle.getByteArray("data"));
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopNewPageFragment", 2, "redpoint info: " + oer.a(localQQAdGetRsp.red_point.get()));
        }
        EcshopNewPageFragment.a(this.a, oer.a(localQQAdGetRsp.red_point.get()));
        if (localQQAdGetRsp.qgg_prompt.has())
        {
          oer.a(localQQAdGetRsp.qgg_prompt.get());
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oez
 * JD-Core Version:    0.7.0.1
 */