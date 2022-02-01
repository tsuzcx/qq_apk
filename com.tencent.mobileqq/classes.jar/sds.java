import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class sds
  implements sdp
{
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  @SuppressLint({"HandlerLeak"})
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new sdt(this);
  private String jdField_a_of_type_JavaLangString;
  private sdo<String> jdField_a_of_type_Sdo;
  
  public sds(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "pause, path=" + this.jdField_a_of_type_JavaLangString + ",uniSeq=" + this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    if (localObject != null)
    {
      localObject = (BaseTransProcessor)((TransFileController)localObject).findProcessor("0", this.jdField_a_of_type_Long);
      if (localObject != null) {
        ((BaseTransProcessor)localObject).pause();
      }
    }
    b();
  }
  
  public void a(String paramString)
  {
    TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.getFilter().size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    localTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 54;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "KandianUGCVideoUpload";
    localTransFileController.transferAsync(localTransferRequest);
    this.jdField_a_of_type_Long = localTransferRequest.mUniseq;
    this.jdField_a_of_type_JavaLangString = paramString;
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "upload, path=" + paramString + ",uniSeq=" + this.jdField_a_of_type_Long);
  }
  
  public void a(sdo<String> paramsdo)
  {
    this.jdField_a_of_type_Sdo = paramsdo;
  }
  
  public void b(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume, uploadKey=" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.getFilter().isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    localTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = paramString.optInt("uniseq", 0);
        this.jdField_a_of_type_JavaLangString = paramString.optString("localPath", "");
        QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume from app reboot");
      }
      paramString = (BaseTransProcessor)localTransFileController.findProcessor("0", this.jdField_a_of_type_Long);
      if (paramString != null)
      {
        paramString.resume();
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "resume, e=" + QLog.getStackTraceString(paramString));
      }
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sds
 * JD-Core Version:    0.7.0.1
 */