package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import dov.com.qq.im.capture.poi.FacePoiSearchUI;
import dov.com.qq.im.capture.poi.FacePoiSearchUI.FacePoiSearchUIListener;

public class EditVideoPoiSearch
  extends EditVideoPart
  implements FacePoiSearchUI.FacePoiSearchUIListener
{
  private FacePoiSearchUI a;
  
  public EditVideoPoiSearch(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI = new FacePoiSearchUI();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(this);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a);
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a();
    if (bool)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(3, this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a());
    }
    return bool;
  }
  
  public void aE_()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.e();
      return;
    }
    if ((paramObject instanceof EditVideoPoiPickerCallback)) {
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a((EditVideoPoiPickerCallback)paramObject);
    }
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a();
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch
 * JD-Core Version:    0.7.0.1
 */