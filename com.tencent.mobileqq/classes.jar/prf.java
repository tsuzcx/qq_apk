import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public class prf
{
  private static long jdField_a_of_type_Long = 300000L;
  private static SosoInterface.SosoLbsInfo jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  private static long b;
  
  public static SosoInterface.SosoLbsInfo a()
  {
    long l = System.currentTimeMillis();
    if (l - b > jdField_a_of_type_Long)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = LbsManagerService.getCachedLbsInfo("readinjoy_anti_cheating");
      b = l;
    }
    return jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prf
 * JD-Core Version:    0.7.0.1
 */