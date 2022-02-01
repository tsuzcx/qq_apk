import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.qphone.base.util.QLog;

public class sut
  implements suu
{
  public sut(RunningJob paramRunningJob, StringBuilder paramStringBuilder) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Suo.b = paramString;
  }
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    QLog.d(RunningJob.jdField_a_of_type_JavaLangString, 1, "receive image data error: " + paramInt + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Suo.e = paramInt;
  }
  
  public void onFileDownloadStarted()
  {
    pnj.b(3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Suo);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Suo.d == 0) {
      pnj.b(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Suo);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Suo.i = paramLong;
    QLog.d(RunningJob.jdField_a_of_type_JavaLangString, 1, "receive image data success, total size: " + paramLong + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
  }
  
  public void publishProgress(int paramInt)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(System.currentTimeMillis() + " " + paramInt + " ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sut
 * JD-Core Version:    0.7.0.1
 */