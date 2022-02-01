import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lph
  implements beuq
{
  public void onResp(bevm parambevm)
  {
    Object localObject = (lpi)parambevm.jdField_a_of_type_Bevl.a();
    lbj.c("EffectBeautyTools", "download file call back. file = " + ((lpi)localObject).a);
    if (parambevm.jdField_a_of_type_Int != 0)
    {
      lbj.c("EffectBeautyTools", "download file faild. errcode = " + parambevm.b);
      return;
    }
    if (!((lpi)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c)))
    {
      lbj.c("EffectBeautyTools", "download file faild : md5 is not match.");
      bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      return;
    }
    lbj.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = lbm.h();
      bhmi.a(parambevm.jdField_a_of_type_Bevl.c, (String)localObject, false);
      bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      return;
    }
    catch (IOException parambevm)
    {
      parambevm.printStackTrace();
      lbj.c("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lph
 * JD-Core Version:    0.7.0.1
 */