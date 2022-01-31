import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;

public class pym
  implements Runnable
{
  public pym(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    Object localObject = DevLittleVideoItemBuilder.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
    DevLittleVideoItemBuilder.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      EncodeVideoTask.ThumbInfo localThumbInfo = new EncodeVideoTask.ThumbInfo(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.mThumbFilePath, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.thumbMD5, null, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.thumbWidth, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.thumbHeight);
      localObject = new EncodeVideoTask(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a, (String)localObject, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.mediacodecEncode, localThumbInfo);
      ((EncodeVideoTask)localObject).a(DevLittleVideoItemBuilder.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder));
      ((EncodeVideoTask)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pym
 * JD-Core Version:    0.7.0.1
 */