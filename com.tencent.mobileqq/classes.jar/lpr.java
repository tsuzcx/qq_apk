import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lpr
  implements aysc
{
  public void onResp(aysz paramaysz)
  {
    Object localObject = (lps)paramaysz.jdField_a_of_type_Aysy.a();
    lcg.c("EffectBeautyTools", "download file call back. file = " + ((lps)localObject).a);
    if (paramaysz.jdField_a_of_type_Int != 0)
    {
      lcg.c("EffectBeautyTools", "download file faild. errcode = " + paramaysz.b);
      return;
    }
    if (!((lps)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c)))
    {
      lcg.c("EffectBeautyTools", "download file faild : md5 is not match.");
      bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      return;
    }
    lcg.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = lcj.h();
      bbdx.a(paramaysz.jdField_a_of_type_Aysy.c, (String)localObject, false);
      bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      return;
    }
    catch (IOException paramaysz)
    {
      paramaysz.printStackTrace();
      lcg.c("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpr
 * JD-Core Version:    0.7.0.1
 */