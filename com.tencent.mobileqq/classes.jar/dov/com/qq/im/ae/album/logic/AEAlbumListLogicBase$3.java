package dov.com.qq.im.ae.album.logic;

import bhnn;
import bogf;
import bogi;
import boha;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AEAlbumListLogicBase$3
  implements Runnable
{
  public AEAlbumListLogicBase$3(boha paramboha, bogf parambogf, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    bhnn.a();
    QQAlbumInfo localQQAlbumInfo = this.jdField_a_of_type_Bogf.b(((bogi)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitSize, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesMaxCount, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitWidth, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.isBothwidthheight, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesBlockPaths);
    this.jdField_a_of_type_Bogf.c(localQQAlbumInfo);
    bhnn.a("PEAK", "queryRecentBucket");
    bhnn.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.showVideo()))
    {
      localQQAlbumInfo = this.jdField_a_of_type_Bogf.a(((bogi)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_Bogf.e(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    bhnn.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */