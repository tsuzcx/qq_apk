package dov.com.qq.im.ae.album.logic;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.statistics.ReportController;
import dov.com.qq.im.ae.album.fragment.AENewPhotoListFragment;
import java.util.ArrayList;
import mqq.util.WeakReference;

class AEPhotoListLogicDefault$2
  implements Runnable
{
  AEPhotoListLogicDefault$2(AEPhotoListLogicDefault paramAEPhotoListLogicDefault, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      PhotoUtils.sendPhoto(((AENewPhotoListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_JavaUtilHashMap, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType, false);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.b = System.currentTimeMillis();
      return;
      PhotoUtils.sendPhoto(((AENewPhotoListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.2
 * JD-Core Version:    0.7.0.1
 */