import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class pyq
  implements Runnable
{
  public pyq(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(0, 4);
    localShortVideoReq.a(ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pyq
 * JD-Core Version:    0.7.0.1
 */