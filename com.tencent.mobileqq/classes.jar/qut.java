import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;

class qut
  implements quj
{
  qut(qun paramqun, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.getProgress();
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 2, "uploadCallback: taskType = " + paramInt + ",isSuccess = " + paramBoolean1 + "isFinish = " + paramBoolean2 + "errorMsg = " + paramString + "progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qut
 * JD-Core Version:    0.7.0.1
 */