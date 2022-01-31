import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lfe
  implements axrt
{
  public void onResp(axsq paramaxsq)
  {
    Object localObject = (lff)paramaxsq.jdField_a_of_type_Axsp.a();
    krx.c("EffectBeautyTools", "download file call back. file = " + ((lff)localObject).a);
    if (paramaxsq.jdField_a_of_type_Int != 0)
    {
      krx.c("EffectBeautyTools", "download file faild. errcode = " + paramaxsq.b);
      return;
    }
    if (!((lff)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c)))
    {
      krx.c("EffectBeautyTools", "download file faild : md5 is not match.");
      bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      return;
    }
    krx.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = lfd.a();
      bace.a(paramaxsq.jdField_a_of_type_Axsp.c, (String)localObject, false);
      bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      return;
    }
    catch (IOException paramaxsq)
    {
      paramaxsq.printStackTrace();
      krx.c("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfe
 * JD-Core Version:    0.7.0.1
 */