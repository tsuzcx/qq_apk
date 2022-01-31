import android.support.v4.util.MQLruCache;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;

public class ncy
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  
  public ncy(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(AppConstants.cu + this.jdField_a_of_type_JavaLangString);
        localObject1 = null;
      }
      catch (Exception localException1)
      {
        FileInputStream localFileInputStream;
        Object localObject1;
        Object localObject2;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "read Exception " + localException1);
      }
      try
      {
        localObject2 = new byte[localFileInputStream.available()];
        localObject1 = localObject2;
        localFileInputStream.read((byte[])localObject2);
        localObject1 = localObject2;
        i = 1;
      }
      catch (Exception localException2)
      {
        i = 0;
      }
    }
    localFileInputStream.close();
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "preloadFileToCache");
      }
      localObject2 = new ArticleComment.GetPhotoCollectionInfoResponse();
      ((ArticleComment.GetPhotoCollectionInfoResponse)localObject2).mergeFrom((byte[])localObject1);
      localObject1 = PublicAccountImageCollectionPreloadManager.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager, (ArticleComment.GetPhotoCollectionInfoResponse)localObject2, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a.put(this.jdField_a_of_type_JavaLangString, localObject1);
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a((PublicAccountImageCollectionUtils.PhotoCollectionInfo)localObject1);
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.b((PublicAccountImageCollectionUtils.PhotoCollectionInfo)localObject1);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncy
 * JD-Core Version:    0.7.0.1
 */