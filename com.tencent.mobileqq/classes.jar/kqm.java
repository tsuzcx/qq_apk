import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.now.PluginRecordHelper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.HostInterface;
import java.net.URL;

public class kqm
  implements Runnable
{
  public kqm(PluginRecordHelper paramPluginRecordHelper, long paramLong, HostInterface paramHostInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.jdField_a_of_type_Boolean = true;
    String str3 = "http://now.qq.com/cgi-bin/now/web/room/get_room_info_v2?room_id=" + this.jdField_a_of_type_Long;
    QLog.i(PluginRecordHelper.jdField_a_of_type_JavaLangString, 1, " 请求录播cgi URL = " + str3 + " time = " + System.currentTimeMillis());
    String str1 = "";
    String str2 = "";
    Object localObject2 = str1;
    if (this.jdField_a_of_type_ComTencentTxproxyHostInterface.useIpDirectConnect())
    {
      localObject2 = str1;
      if (PluginRecordHelper.b()) {}
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
                QLog.d(PluginRecordHelper.jdField_a_of_type_JavaLangString, 2, "use ip:" + str1);
              }
              bool = true;
              localObject2 = localObject1;
              localObject1 = str1;
              long l = System.currentTimeMillis();
              QLog.d(PluginRecordHelper.jdField_a_of_type_JavaLangString, 1, "before downloadBuffer, useIpConn=" + bool);
              if (bool)
              {
                localObject1 = PluginRecordHelper.a(this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper, (String)localObject1, true, (String)localObject2);
                this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
                QLog.d(PluginRecordHelper.jdField_a_of_type_JavaLangString, 1, "end downloadBuffer, timeCost=" + this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.jdField_a_of_type_Long + ", json=" + (String)localObject1);
                PluginRecordHelper.a(this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper, (String)localObject1);
                if (this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.jdField_a_of_type_AndroidOsHandler != null)
                {
                  localObject1 = new Message();
                  ((Message)localObject1).what = 1001;
                  this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
                }
                this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.jdField_a_of_type_Boolean = false;
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
        QLog.e(PluginRecordHelper.jdField_a_of_type_JavaLangString, 2, "hasRecording exp:" + localException.toString());
        localObject1 = str1;
        continue;
        localObject1 = PluginRecordHelper.a(this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper, str3, false, "");
        continue;
      }
      boolean bool = false;
      Object localObject1 = str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqm
 * JD-Core Version:    0.7.0.1
 */