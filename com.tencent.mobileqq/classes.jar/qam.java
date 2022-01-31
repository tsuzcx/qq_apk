import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class qam
  implements Runnable
{
  public qam(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.a(51);
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.a(49);
    for (;;)
    {
      synchronized (localDeviceMsgHandle.a)
      {
        Iterator localIterator = localDeviceMsgHandle.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.thumbFileKey)))
          {
            long l = localSmartDeviceProxyMgr.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.thumbFileKey, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.coverkey2, 2154);
            localDeviceMsgHandle.a.put(Long.valueOf(l), this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qam
 * JD-Core Version:    0.7.0.1
 */