package dov.com.qq.im.ae.album.logic;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$12
  implements VideoPlayerCallback
{
  AEPhotoListLogicBase$12(AEPhotoListLogicBase paramAEPhotoListLogicBase, VideoPlayParam paramVideoPlayParam, String paramString) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AEQLog.d("AEPhotoListLogicBase", "onPlayError---errorType=" + paramInt2 + ", errorCode=" + paramInt3 + ", exInfo=" + paramString + "\nvideoPath=" + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase))) && (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(this.jdField_a_of_type_JavaLangString)))
    {
      paramInt1 = AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase, this.jdField_a_of_type_JavaLangString);
      if (paramInt1 != -1)
      {
        paramString = (AEAbstractPhotoListFragment.PhotoVH)((AEAbstractPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(paramInt1);
        LocalMediaInfo localLocalMediaInfo = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt1);
        AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase, paramInt1, localLocalMediaInfo, paramString);
      }
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    AEQLog.b("AEPhotoListLogicBase", "onStateChange---state=" + paramInt);
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 4: 
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
        AEPhotoListLogicBase.b(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase);
      }
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).a(false);
      return;
    case 6: 
      AEPhotoListLogicBase.c(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).a(true);
      return;
    }
    AEPhotoListLogicBase.c(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.12
 * JD-Core Version:    0.7.0.1
 */