package dov.com.qq.im.capture.paster;

import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class PasterDataManager$3$1
  extends LbsManager.OnLocationListener
{
  PasterDataManager$3$1(PasterDataManager.3 param3, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      SLog.b("PasterDataManager", "onLocationUpdate() latitude=" + paramSosoLbsInfo.mLocation.mLat02 + " longitude=" + paramSosoLbsInfo.mLocation.mLon02);
      PasterDataManager.a(this.a.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager, true);
      PasterDataManager.a(this.a.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager.a(null);
      return;
    }
    SLog.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterDataManager.3.1
 * JD-Core Version:    0.7.0.1
 */