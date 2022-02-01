import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class sel
  extends sea
{
  private long jdField_a_of_type_Long;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new sem(this);
  private TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public sel(Context paramContext, QQAppInterface paramQQAppInterface, seb paramseb, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramseb);
    this.d = paramString;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = pkh.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("VideoUploadController", 2, "finish: retCode - " + paramInt + " fileUrl : " + paramString1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(paramInt);
    if (this.jdField_a_of_type_Seb != null) {
      this.jdField_a_of_type_Seb.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "cancelUploadVideo");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null))
    {
      localObject = (BaseTransProcessor)((TransFileController)localObject).findProcessor(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mPeerUin, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq);
      if (localObject != null)
      {
        ((BaseTransProcessor)localObject).cancel();
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = null;
      }
    }
  }
  
  public void a(FileMsg paramFileMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    bigFileUpload.BigFileExtRsp localBigFileExtRsp = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        localBigFileExtRsp.mergeFrom(paramFileMsg.bdhExtendInfo);
        i = localBigFileExtRsp.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_JavaLangString = paramFileMsg.fileMd5;
          if (localBigFileExtRsp.bytes_download_url.has()) {
            this.c = localBigFileExtRsp.bytes_download_url.get().toStringUtf8();
          }
          if (localBigFileExtRsp.bytes_file_name.has()) {
            this.jdField_b_of_type_JavaLangString = localBigFileExtRsp.bytes_file_name.get().toStringUtf8();
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
          {
            boolean bool = TextUtils.isEmpty(this.c);
            if (!bool)
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              a(0, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
            }
          }
        }
        else if ((QLog.isColorLevel()) && (localBigFileExtRsp.bytes_msg.has()))
        {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + localBigFileExtRsp.bytes_msg.get().toStringUtf8());
        }
      }
      catch (Exception paramFileMsg)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("VideoUploadController", 2, "handleMsgStatusSendFinish error = " + paramFileMsg.toString());
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finish with error!");
        a(1004, null, null, null);
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = null;
      }
      i = 0;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.e = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "startUploadVideo path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo empty path!");
      }
      a(1001, null, null, null);
      return;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo file not exist, path=" + paramString);
      }
      a(1002, null, null, null);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      a(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      return;
    }
    TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.getFilter().size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    localTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = new TransferRequest();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mIsUp = true;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mCommandId = 54;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath = paramString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mPeerUin = "0";
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mFileType = 24;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mRichTag = "KandianUGCVideoUpload";
    }
    localTransFileController.transferAsync(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    ThreadManager.executeOnFileThread(new VideoUploadController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sel
 * JD-Core Version:    0.7.0.1
 */