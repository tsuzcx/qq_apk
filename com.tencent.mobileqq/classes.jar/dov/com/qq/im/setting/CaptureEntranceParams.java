package dov.com.qq.im.setting;

public class CaptureEntranceParams
{
  public int a;
  private CapturePicParams jdField_a_of_type_DovComQqImSettingCapturePicParams;
  private CaptureVideoParams jdField_a_of_type_DovComQqImSettingCaptureVideoParams;
  public int b;
  public int c;
  
  public CaptureEntranceParams(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public CapturePicParams a()
  {
    return this.jdField_a_of_type_DovComQqImSettingCapturePicParams;
  }
  
  public CaptureVideoParams a()
  {
    return this.jdField_a_of_type_DovComQqImSettingCaptureVideoParams;
  }
  
  public void a(CapturePicParams paramCapturePicParams)
  {
    this.jdField_a_of_type_DovComQqImSettingCapturePicParams = paramCapturePicParams;
    if (this.jdField_a_of_type_DovComQqImSettingCapturePicParams.a() != null) {
      this.b = this.jdField_a_of_type_DovComQqImSettingCapturePicParams.b();
    }
  }
  
  public void a(CaptureVideoParams paramCaptureVideoParams)
  {
    this.jdField_a_of_type_DovComQqImSettingCaptureVideoParams = paramCaptureVideoParams;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.setting.CaptureEntranceParams
 * JD-Core Version:    0.7.0.1
 */