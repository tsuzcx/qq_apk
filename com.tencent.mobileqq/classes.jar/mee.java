import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.FileMsg;

class mee
  implements FileTransferManager.Callback
{
  mee(med parammed, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (paramFileMsg.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)) {}
    while ((paramFileMsg.jdField_b_of_type_Int != 6) && (paramFileMsg.jdField_b_of_type_Int != 17) && (paramFileMsg.jdField_b_of_type_Int != 9) && (paramFileMsg.jdField_b_of_type_Int != 20)) {
      return;
    }
    VideoFeedsPlayManager.a(this.jdField_a_of_type_Med.a, paramFileMsg.u, paramFileMsg.c, paramFileMsg.d, paramFileMsg.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mee
 * JD-Core Version:    0.7.0.1
 */