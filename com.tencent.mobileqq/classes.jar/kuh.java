import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;

public class kuh
  implements Runnable
{
  public kuh(AdvertisementItem paramAdvertisementItem) {}
  
  public void run()
  {
    try
    {
      String str = MD5Utils.b(DeviceInfoUtil.a());
      if ((this.a.a == null) || (TextUtils.isEmpty(this.a.a.m)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("AdvertisementRecentUserManager", 2, "exporsure failed");
        }
      }
      else
      {
        Object localObject2 = this.a.a.m;
        Object localObject1 = localObject2;
        if (((String)localObject2).contains("__OS__")) {
          localObject1 = ((String)localObject2).replace("__OS__", "0");
        }
        localObject2 = localObject1;
        if (((String)localObject1).contains("__IMEI__")) {
          localObject2 = ((String)localObject1).replace("__IMEI__", str);
        }
        localObject1 = localObject2;
        if (((String)localObject2).contains("__APP__")) {
          localObject1 = ((String)localObject2).replace("__APP__", MD5Utils.b("android_qq"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "exporsure url :" + ((String)localObject1).toString());
        }
        localObject2 = new HttpNetReq();
        ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = AdvertisementItem.a(this.a);
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((HttpNetReq)localObject2).jdField_a_of_type_Int = 0;
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          localObject1 = (QQAppInterface)localObject1;
          ((OldHttpEngine)((QQAppInterface)localObject1).getNetEngine(0)).a((NetReq)localObject2);
          ReportController.a((QQAppInterface)localObject1, "dc00898", "", "", "0X8008FA0", "0X8008FA0", 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AdvertisementRecentUserManager", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kuh
 * JD-Core Version:    0.7.0.1
 */