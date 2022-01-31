import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ret
  extends rer
{
  public ret(APICallback paramAPICallback, long paramLong)
  {
    super(paramAPICallback, 0, paramLong);
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
      double d1 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      double d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
      double d3 = paramSosoLbsInfo.a.jdField_b_of_type_Float;
      double d4 = paramSosoLbsInfo.a.jdField_a_of_type_Float;
      double d5 = paramSosoLbsInfo.a.e;
      paramSosoLbsInfo = new APIParam();
      paramSosoLbsInfo.put("latitude", Double.valueOf(d1));
      paramSosoLbsInfo.put("longitude", Double.valueOf(d2));
      paramSosoLbsInfo.put("speed", Double.valueOf(d3));
      paramSosoLbsInfo.put("accuracy", Double.valueOf(d4));
      paramSosoLbsInfo.put("altitude", Double.valueOf(d5));
      paramSosoLbsInfo.put("verticalAccuracy", Double.valueOf(0.0D));
      paramSosoLbsInfo.put("horizontalAccuracy", Double.valueOf(d4));
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramSosoLbsInfo);
      Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "error " + paramInt);
    Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ret
 * JD-Core Version:    0.7.0.1
 */