import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.qphone.base.util.QLog;

public class myx
  implements Runnable
{
  public myx(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "notifyUIToRefresh articleId=" + this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo.a);
    }
    if (PublicAccountImageCollectionPreloadManager.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager) != null) {
      PublicAccountImageCollectionPreloadManager.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager).a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionUtils$PhotoCollectionInfo);
    }
    PublicAccountImageCollectionPreloadManager.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myx
 * JD-Core Version:    0.7.0.1
 */