import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lja
  implements Runnable
{
  public lja(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString) {}
  
  public void run()
  {
    if (!new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.getString(2131438884));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic file not exist, path=" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    TransFileController localTransFileController = ReadInJoyCommentComponentFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment).app.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.a.a(new Class[] { BDHCommonUploadProcessor.class });
    localTransFileController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.a);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_c_of_type_Int = 10;
    localTransferRequest.i = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localTransferRequest.jdField_c_of_type_JavaLangString = "0";
    localTransferRequest.b = 24;
    localTransferRequest.jdField_a_of_type_JavaLangString = "KandianUGCPicUpload";
    localTransFileController.a(localTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lja
 * JD-Core Version:    0.7.0.1
 */