package dov.com.qq.im.ae.album.logic;

import akmi;
import android.content.Intent;
import bdla;
import bmza;
import bnaa;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class AEPhotoListLogicDefault$2
  implements Runnable
{
  public AEPhotoListLogicDefault$2(bnaa parambnaa, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      PhotoUtils.sendPhoto(((bmza)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Akmi.jdField_a_of_type_JavaUtilHashMap, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType, false);
    }
    for (;;)
    {
      bdla.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      bcwz.b = System.currentTimeMillis();
      return;
      PhotoUtils.sendPhoto(((bmza)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType, this.this$0.jdField_a_of_type_Akmi.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.2
 * JD-Core Version:    0.7.0.1
 */