package dov.com.qq.im.ae.album.logic;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.album.data.AEPhotoCommonDataCreator;
import dov.com.qq.im.ae.album.fragment.AEAbstractAlbumListFragment;
import mqq.util.WeakReference;

public abstract class AEAlbumListLogic<K extends AEAbstractAlbumListFragment>
{
  public static volatile AEAlbumListLogic a;
  public AlbumListBaseData a;
  protected PhotoCommonBaseData a;
  public AEAlbumListLogic.IalbumListAdapterCallBack a;
  public WeakReference<K> a;
  
  protected AEAlbumListLogic(K paramK)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramK);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = AEPhotoCommonDataCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData = new AlbumListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic new，fragment = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
    jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic = null;
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEAlbumListLogic
 * JD-Core Version:    0.7.0.1
 */