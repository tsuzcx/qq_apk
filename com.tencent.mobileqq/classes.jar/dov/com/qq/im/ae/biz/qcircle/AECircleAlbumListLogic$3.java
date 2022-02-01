package dov.com.qq.im.ae.biz.qcircle;

import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.biz.qcircle.adapter.AlbumListAdapter;
import mqq.util.WeakReference;

class AECircleAlbumListLogic$3
  implements Runnable
{
  AECircleAlbumListLogic$3(AECircleAlbumListLogic paramAECircleAlbumListLogic, AlbumListAdapter paramAlbumListAdapter, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    LogTag.a();
    QQAlbumInfo localQQAlbumInfo = this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter.b(((AECircleAlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesLimitSize, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesMaxCount, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesLimitWidth, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.isBothwidthheight, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesBlockPaths);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter.c(localQQAlbumInfo);
    LogTag.a("PEAK", "queryRecentBucket");
    LogTag.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.showVideo()))
    {
      localQQAlbumInfo = this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter.a(((AECircleAlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter.e(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    LogTag.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListLogic.3
 * JD-Core Version:    0.7.0.1
 */