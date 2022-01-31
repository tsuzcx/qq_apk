import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class qph
  implements acwf
{
  qph(qpg paramqpg, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, ayqm paramayqm, int paramInt1, int paramInt2)
  {
    if ((paramayqm == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (paramayqm.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)) {}
    while ((paramayqm.jdField_b_of_type_Int != 6) && (paramayqm.jdField_b_of_type_Int != 17) && (paramayqm.jdField_b_of_type_Int != 9) && (paramayqm.jdField_b_of_type_Int != 20)) {
      return;
    }
    paramView = new Bundle();
    paramView.putInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS", paramayqm.d);
    paramView.putString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN", paramayqm.u);
    paramView.putStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS", paramayqm.c);
    paramView.putLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ", paramayqm.jdField_b_of_type_Long);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qph
 * JD-Core Version:    0.7.0.1
 */