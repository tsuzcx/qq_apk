import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class qdj
  implements aclm
{
  qdj(qdi paramqdi, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    if ((paramaxqf == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (paramaxqf.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)) {}
    while ((paramaxqf.jdField_b_of_type_Int != 6) && (paramaxqf.jdField_b_of_type_Int != 17) && (paramaxqf.jdField_b_of_type_Int != 9) && (paramaxqf.jdField_b_of_type_Int != 20)) {
      return;
    }
    paramView = new Bundle();
    paramView.putInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS", paramaxqf.d);
    paramView.putString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN", paramaxqf.u);
    paramView.putStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS", paramaxqf.c);
    paramView.putLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ", paramaxqf.jdField_b_of_type_Long);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdj
 * JD-Core Version:    0.7.0.1
 */