package dov.com.qq.im.ae.album.logic;

import aiqy;
import android.widget.ImageView;
import bkqf;
import bkql;
import bkrh;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$8
  implements Runnable
{
  public AEPhotoListLogicBase$8(bkrh parambkrh, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.h();
    this.this$0.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(this.jdField_a_of_type_JavaLangString, 1440, 1440));
    this.this$0.jdField_a_of_type_Float = ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    this.this$0.b = ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.b();
    int i = ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    this.this$0.b(i);
    bkqf localbkqf = this.this$0.a(this.jdField_a_of_type_JavaLangString);
    if ((localbkqf != null) && (localbkqf.a != null) && (bkrh.a(this.this$0, this.this$0.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_JavaLangString))) {
      ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageMatrix(localbkqf.a);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
      }
      if (!bkrh.a(this.this$0)) {
        break;
      }
      ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.this$0.c(this.jdField_a_of_type_JavaLangString);
    }
    ((bkql)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8
 * JD-Core Version:    0.7.0.1
 */