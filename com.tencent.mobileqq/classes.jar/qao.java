import com.tencent.device.msg.activities.DevShortVideoItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class qao
  implements Runnable
{
  public qao(DevShortVideoItemBuilder paramDevShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(1, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.b);
    localShortVideoReq.a(ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qao
 * JD-Core Version:    0.7.0.1
 */