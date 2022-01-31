import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.transfile.FileMsg;

class mcl
  implements FileTransferManager.Callback
{
  mcl(mck parammck, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (paramFileMsg.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)) {}
    while ((paramFileMsg.jdField_b_of_type_Int != 6) && (paramFileMsg.jdField_b_of_type_Int != 17) && (paramFileMsg.jdField_b_of_type_Int != 9) && (paramFileMsg.jdField_b_of_type_Int != 20)) {
      return;
    }
    paramView = new Bundle();
    paramView.putInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS", paramFileMsg.d);
    paramView.putString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN", paramFileMsg.u);
    paramView.putStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS", paramFileMsg.c);
    paramView.putLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ", paramFileMsg.jdField_b_of_type_Long);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcl
 * JD-Core Version:    0.7.0.1
 */