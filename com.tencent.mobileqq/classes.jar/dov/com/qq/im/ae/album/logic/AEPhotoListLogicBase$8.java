package dov.com.qq.im.ae.album.logic;

import aimj;
import android.widget.ImageView;
import bkly;
import bkme;
import bkna;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$8
  implements Runnable
{
  public AEPhotoListLogicBase$8(bkna parambkna, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.h();
    this.this$0.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(this.jdField_a_of_type_JavaLangString, 1440, 1440));
    this.this$0.jdField_a_of_type_Float = ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    this.this$0.b = ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.b();
    int i = ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    this.this$0.b(i);
    bkly localbkly = this.this$0.a(this.jdField_a_of_type_JavaLangString);
    if ((localbkly != null) && (localbkly.a != null) && (bkna.a(this.this$0, this.this$0.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_JavaLangString))) {
      ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageMatrix(localbkly.a);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.b();
      }
      if (!bkna.a(this.this$0)) {
        break;
      }
      ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
    }
    ((bkme)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8
 * JD-Core Version:    0.7.0.1
 */