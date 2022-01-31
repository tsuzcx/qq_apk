import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class rjk
  extends rjj
{
  public rjk(APICallback paramAPICallback, long paramLong)
  {
    super(paramAPICallback, 3, paramLong);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.sensor.location", 2, "onLocationFinish: errCode=" + paramInt + ", info=" + paramSosoLbsInfo + ", isActive=" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramInt == 0)
    {
      APIParam localAPIParam = new APIParam();
      localAPIParam.put("nation", paramSosoLbsInfo.a.c);
      localAPIParam.put("province", paramSosoLbsInfo.a.d);
      localAPIParam.put("city", paramSosoLbsInfo.a.e);
      localAPIParam.put("district", paramSosoLbsInfo.a.g);
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, localAPIParam);
      Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "error " + paramInt);
    Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rjk
 * JD-Core Version:    0.7.0.1
 */