import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.qphone.base.util.QLog;

public class soo
  extends nmy
{
  public soo(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, long paramLong) {}
  
  public void a(boolean paramBoolean, sow paramsow, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(true, this.jdField_a_of_type_Long);
      if (paramsow != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + paramsow.a);
        }
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(paramsow, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.b(paramsow);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(false, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     soo
 * JD-Core Version:    0.7.0.1
 */