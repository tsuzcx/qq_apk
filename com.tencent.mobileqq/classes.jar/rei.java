import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class rei
  implements aesa
{
  rei(reh paramreh, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    if ((parambass == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (parambass.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)) {}
    while ((parambass.jdField_b_of_type_Int != 6) && (parambass.jdField_b_of_type_Int != 17) && (parambass.jdField_b_of_type_Int != 9) && (parambass.jdField_b_of_type_Int != 20)) {
      return;
    }
    paramView = new Bundle();
    paramView.putInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS", parambass.d);
    paramView.putString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN", parambass.u);
    paramView.putStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS", parambass.c);
    paramView.putLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ", parambass.jdField_b_of_type_Long);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rei
 * JD-Core Version:    0.7.0.1
 */