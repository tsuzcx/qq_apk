import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.now.CgiHelper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.HostInterface;
import java.net.URL;

public class knw
  implements Runnable
{
  public knw(CgiHelper paramCgiHelper, long paramLong, HostInterface paramHostInterface) {}
  
  public void run()
  {
    String str3 = "http://now.qq.com/cgi-bin/now/web/room/get_room_info_v2?room_id=" + this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i(CgiHelper.a, 1, " 请求录播cgi URL = " + str3 + " time = " + System.currentTimeMillis());
    }
    String str1 = "";
    String str2 = "";
    Object localObject2 = str1;
    if (this.jdField_a_of_type_ComTencentTxproxyHostInterface.useIpDirectConnect())
    {
      localObject2 = str1;
      if (CgiHelper.a()) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new URL(str3).getHost();
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if ("now.qq.com".equals(localObject1))
          {
            str1 = this.jdField_a_of_type_ComTencentTxproxyHostInterface.reqDns((String)localObject1);
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(str1))
            {
              str1 = InnerDns.a(str3, str1);
              if (QLog.isColorLevel()) {
                QLog.d(CgiHelper.a, 2, "use ip:" + str1);
              }
              bool = true;
              localObject2 = localObject1;
              localObject1 = str1;
              long l = System.currentTimeMillis();
              QLog.d(CgiHelper.a, 1, "before downloadBuffer, useIpConn=" + bool);
              if (bool)
              {
                localObject2 = CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper, (String)localObject1, true, (String)localObject2);
                localObject1 = localObject2;
                if (TextUtils.isEmpty((CharSequence)localObject2))
                {
                  QLog.d(CgiHelper.a, 1, "try again");
                  localObject1 = CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper, str3, false, "");
                }
                QLog.d(CgiHelper.a, 1, "end downloadBuffer, timeCost=" + (System.currentTimeMillis() - l) + ", json=" + (String)localObject1);
                CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper, (String)localObject1);
                if (CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper) != null)
                {
                  localObject1 = new Message();
                  ((Message)localObject1).what = 1001;
                  CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper).sendMessage((Message)localObject1);
                }
                return;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localObject1 = str1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(CgiHelper.a, 2, "hasRecording exp:" + localException.toString());
        localObject1 = str1;
        continue;
        localObject1 = CgiHelper.a(this.jdField_a_of_type_ComTencentBizNowCgiHelper, str3, false, "");
        continue;
      }
      boolean bool = false;
      Object localObject1 = str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knw
 * JD-Core Version:    0.7.0.1
 */