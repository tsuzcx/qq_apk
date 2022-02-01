package dov.com.qq.im.ae.album.logic;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import dov.com.qq.im.ae.album.fragment.AENewPhotoListFragment;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mqq.util.WeakReference;

class AEPhotoListLogicAECircle$3
  implements MovieExporter.VideoCompressListener
{
  AEPhotoListLogicAECircle$3(AEPhotoListLogicAECircle paramAEPhotoListLogicAECircle, long paramLong, LocalMediaInfo paramLocalMediaInfo, int paramInt) {}
  
  public void onCompressCanceled()
  {
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle, false);
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle, false);
    QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131720490, 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  public void onCompressFinish(String paramString)
  {
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle, false);
    if (!AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration))
    {
      AEQLog.d("PhotoListLogicAECircle", "[compressVideoToEdit] compress error");
      onCompressError(null);
      FileUtils.e(paramString);
      return;
    }
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle, 1);
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramString);
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    paramString = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    if (paramString == null)
    {
      paramString = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramString);
    }
    for (;;)
    {
      paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).a.getLayoutManager()).findFirstVisibleItemPosition()));
      paramString = AlbumUtil.sSelectItemAlbum;
      if (!paramString.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localPair);
      }
      int i;
      if (Build.VERSION.SDK_INT >= 23) {
        if (((AENewPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          AEQLog.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          WatermarkDataManager.a().a(new AEPhotoListLogicAECircle.3.1(this));
        }
        AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle);
        this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
        return;
        i = 0;
        continue;
        i = 1;
      }
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    if ((AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle) != null) && (AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle).isShowing()) && (AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle) != null))
    {
      int i = (int)(100.0F * paramFloat);
      AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle).c(i);
      AEPhotoListLogicAECircle.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicAECircle).a(i + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicAECircle.3
 * JD-Core Version:    0.7.0.1
 */