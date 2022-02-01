import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lou
  implements bdvw
{
  public void onResp(bdwt parambdwt)
  {
    Object localObject = (lov)parambdwt.jdField_a_of_type_Bdws.a();
    lbc.c("EffectBeautyTools", "download file call back. file = " + ((lov)localObject).a);
    if (parambdwt.jdField_a_of_type_Int != 0)
    {
      lbc.c("EffectBeautyTools", "download file faild. errcode = " + parambdwt.b);
      return;
    }
    if (!((lov)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c)))
    {
      lbc.c("EffectBeautyTools", "download file faild : md5 is not match.");
      bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      return;
    }
    lbc.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = lbf.h();
      bgmg.a(parambdwt.jdField_a_of_type_Bdws.c, (String)localObject, false);
      bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      return;
    }
    catch (IOException parambdwt)
    {
      parambdwt.printStackTrace();
      lbc.c("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lou
 * JD-Core Version:    0.7.0.1
 */