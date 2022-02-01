package dov.com.qq.im.ae.album.nocropper;

import com.tencent.tavcut.bean.CropConfig;

public class CropResult
{
  public final CropConfig a;
  public final CropInfo a;
  public final CropState a;
  
  private CropResult(CropConfig paramCropConfig, CropState paramCropState)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanCropConfig = paramCropConfig;
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperCropState = paramCropState;
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperCropInfo = null;
  }
  
  public static CropResult a()
  {
    return new CropResult(null, CropState.d);
  }
  
  public static CropResult a(CropConfig paramCropConfig)
  {
    return new CropResult(paramCropConfig, CropState.b);
  }
  
  public static CropResult a(CropInfo paramCropInfo)
  {
    return new CropResult(null, CropState.b);
  }
  
  public static CropResult b()
  {
    return new CropResult(null, CropState.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.CropResult
 * JD-Core Version:    0.7.0.1
 */