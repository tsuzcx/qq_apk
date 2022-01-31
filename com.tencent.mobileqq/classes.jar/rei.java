import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class rei
  implements aenl
{
  rei(reh paramreh, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    if ((parambaoj == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (parambaoj.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)) {}
    while ((parambaoj.jdField_b_of_type_Int != 6) && (parambaoj.jdField_b_of_type_Int != 17) && (parambaoj.jdField_b_of_type_Int != 9) && (parambaoj.jdField_b_of_type_Int != 20)) {
      return;
    }
    paramView = new Bundle();
    paramView.putInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS", parambaoj.d);
    paramView.putString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN", parambaoj.u);
    paramView.putStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS", parambaoj.c);
    paramView.putLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ", parambaoj.jdField_b_of_type_Long);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rei
 * JD-Core Version:    0.7.0.1
 */