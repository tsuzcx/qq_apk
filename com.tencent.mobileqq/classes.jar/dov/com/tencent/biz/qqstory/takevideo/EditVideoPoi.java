package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import dov.com.qq.im.capture.poi.FacePoiManager;
import dov.com.qq.im.capture.poi.FacePoiUI;
import dov.com.qq.im.capture.poi.FacePoiUI.FacePoiUIListener;

public class EditVideoPoi
  extends EditVideoPart
  implements FacePoiUI.FacePoiUIListener
{
  private FacePoiUI a;
  
  public EditVideoPoi(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI = new FacePoiUI();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a(this);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a);
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
  }
  
  public boolean a()
  {
    return b();
  }
  
  public void aC_()
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(false);
  }
  
  public void aD_()
  {
    b();
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.d();
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a();
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(true);
    } while (!(paramObject instanceof EditVideoDoodle.LocationCallback));
    paramObject = (EditVideoDoodle.LocationCallback)paramObject;
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(paramObject.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback, paramObject.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.e();
  }
  
  public void az_()
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(4, this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a());
  }
  
  protected boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a())
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {}
    for (String str = "2";; str = "1")
    {
      localEditVideoPartManager.a("change_poi", 0, 0, new String[] { str });
      VideoEditReport.a("0X80076D0");
      VideoEditReport.b("0X80075E5");
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPoi
 * JD-Core Version:    0.7.0.1
 */