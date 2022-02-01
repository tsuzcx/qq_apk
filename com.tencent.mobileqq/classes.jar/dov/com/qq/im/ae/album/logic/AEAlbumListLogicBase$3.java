package dov.com.qq.im.ae.album.logic;

import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.album.adapter.AEAlbumListAdapter;
import dov.com.qq.im.ae.album.fragment.AEAbstractAlbumListFragment;
import mqq.util.WeakReference;

class AEAlbumListLogicBase$3
  implements Runnable
{
  AEAlbumListLogicBase$3(AEAlbumListLogicBase paramAEAlbumListLogicBase, AEAlbumListAdapter paramAEAlbumListAdapter, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    LogTag.a();
    QQAlbumInfo localQQAlbumInfo = this.jdField_a_of_type_DovComQqImAeAlbumAdapterAEAlbumListAdapter.b(((AEAbstractAlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitSize, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesMaxCount, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitWidth, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.isBothwidthheight, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesBlockPaths);
    this.jdField_a_of_type_DovComQqImAeAlbumAdapterAEAlbumListAdapter.c(localQQAlbumInfo);
    LogTag.a("PEAK", "queryRecentBucket");
    LogTag.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.showVideo()))
    {
      localQQAlbumInfo = this.jdField_a_of_type_DovComQqImAeAlbumAdapterAEAlbumListAdapter.a(((AEAbstractAlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_DovComQqImAeAlbumAdapterAEAlbumListAdapter.e(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    LogTag.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */