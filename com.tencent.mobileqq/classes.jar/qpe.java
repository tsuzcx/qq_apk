import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class qpe
  implements acwb
{
  qpe(qpd paramqpd, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    if ((paramayqo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (paramayqo.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)) {}
    while ((paramayqo.jdField_b_of_type_Int != 6) && (paramayqo.jdField_b_of_type_Int != 17) && (paramayqo.jdField_b_of_type_Int != 9) && (paramayqo.jdField_b_of_type_Int != 20)) {
      return;
    }
    paramView = new Bundle();
    paramView.putInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS", paramayqo.d);
    paramView.putString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN", paramayqo.u);
    paramView.putStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS", paramayqo.c);
    paramView.putLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ", paramayqo.jdField_b_of_type_Long);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpe
 * JD-Core Version:    0.7.0.1
 */