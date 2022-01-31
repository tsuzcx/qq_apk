import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.qphone.base.util.QLog;

public class myy
  extends PublicAccountArticleObserver
{
  public myy(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, long paramLong) {}
  
  public void a(boolean paramBoolean, PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(true, this.jdField_a_of_type_Long);
      if (paramPhotoCollectionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + paramPhotoCollectionInfo.a);
        }
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(paramPhotoCollectionInfo, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.b(paramPhotoCollectionInfo);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(false, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myy
 * JD-Core Version:    0.7.0.1
 */