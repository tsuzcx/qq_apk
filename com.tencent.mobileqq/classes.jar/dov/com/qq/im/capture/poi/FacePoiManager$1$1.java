package dov.com.qq.im.capture.poi;

import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class FacePoiManager$1$1
  extends LbsManager.OnLocationListener
{
  FacePoiManager$1$1(FacePoiManager.1 param1, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_Double = paramSosoLbsInfo.mLocation.mLat02;
      this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.b = paramSosoLbsInfo.mLocation.mLon02;
      SLog.b("FacePoiManager", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_Double + " longitude=" + this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a();
      }
      return;
    }
    this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_Double = 0.0D;
    this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.b = 0.0D;
    SLog.b("FacePoiManager", "onLocationUpdate() error");
    this.a.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener.a(false, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.poi.FacePoiManager.1.1
 * JD-Core Version:    0.7.0.1
 */