import android.app.Activity;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryPageView;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractProgressView;
import com.tencent.common.galleryactivity.AnimationLister;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

public class pjn
  implements AnimationLister
{
  public pjn(AbstractGalleryScene paramAbstractGalleryScene) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetGallery.getVisibility() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    }
    this.a.b();
    if ((this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (!this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
    }
  }
  
  public void c()
  {
    if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    this.a.c();
    if ((this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b();
    }
  }
  
  public void d()
  {
    if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView != null) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(4);
    }
    if ((this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b();
    }
    this.a.d();
    this.a.jdField_a_of_type_ComTencentWidgetGallery.d();
  }
  
  public void e()
  {
    this.a.e();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gallery onExitAnimationEnd ");
      if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() != this.a) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GalleryComponent", 2, bool);
      if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() != this.a) {
        break;
      }
      this.a.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     pjn
 * JD-Core Version:    0.7.0.1
 */