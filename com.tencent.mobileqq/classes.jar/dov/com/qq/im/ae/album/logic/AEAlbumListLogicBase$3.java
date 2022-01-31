package dov.com.qq.im.ae.album.logic;

import bddw;
import bklw;
import bklz;
import bkmr;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AEAlbumListLogicBase$3
  implements Runnable
{
  public AEAlbumListLogicBase$3(bkmr parambkmr, bklw parambklw, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    bddw.a();
    QQAlbumInfo localQQAlbumInfo = this.jdField_a_of_type_Bklw.b(((bklz)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitSize, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesMaxCount, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitWidth, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.isBothwidthheight, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesBlockPaths);
    this.jdField_a_of_type_Bklw.c(localQQAlbumInfo);
    bddw.a("PEAK", "queryRecentBucket");
    bddw.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.showVideo()))
    {
      localQQAlbumInfo = this.jdField_a_of_type_Bklw.a(((bklz)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_Bklw.e(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    bddw.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */