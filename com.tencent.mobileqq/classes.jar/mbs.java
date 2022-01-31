import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mbs
  implements Runnable
{
  public mbs(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists())
    {
      ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, true);
      ReadInJoyDeliverUGCActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity);
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.getString(2131438908));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic file not exist, path=" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, ((File)localObject1).length());
    ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, NetConnInfoCenter.getServerTimeMillis());
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, "");
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, new CompressInfo(this.jdField_a_of_type_JavaLangString, 0));
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f = 0;
    if (!CompressOperator.a(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity))) {
      ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1001);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic compressPath=" + ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).jdField_e_of_type_JavaLangString + ", path=" + this.jdField_a_of_type_JavaLangString + ", width=" + ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).d + ", height=" + ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).jdField_e_of_type_Int);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity;
    if (TextUtils.isEmpty(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).jdField_e_of_type_JavaLangString)) {}
    for (localObject1 = this.jdField_a_of_type_JavaLangString;; localObject1 = ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).jdField_e_of_type_JavaLangString)
    {
      ReadInJoyDeliverUGCActivity.b((ReadInJoyDeliverUGCActivity)localObject2, (String)localObject1);
      ReadInJoyDeliverUGCActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, new File(ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity)).length());
      ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, NetConnInfoCenter.getServerTimeMillis());
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.app.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.a.a(new Class[] { BDHCommonUploadProcessor.class });
      ((TransFileController)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.a);
      localObject2 = new TransferRequest();
      ((TransferRequest)localObject2).jdField_a_of_type_Boolean = true;
      ((TransferRequest)localObject2).jdField_c_of_type_Int = 10;
      ((TransferRequest)localObject2).i = ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity);
      ((TransferRequest)localObject2).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
      ((TransferRequest)localObject2).jdField_c_of_type_JavaLangString = "0";
      ((TransferRequest)localObject2).b = 24;
      ((TransferRequest)localObject2).jdField_a_of_type_JavaLangString = "KandianUGCPicUpload";
      ((TransFileController)localObject1).a((TransferRequest)localObject2);
      ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, NetConnInfoCenter.getServerTimeMillis());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbs
 * JD-Core Version:    0.7.0.1
 */