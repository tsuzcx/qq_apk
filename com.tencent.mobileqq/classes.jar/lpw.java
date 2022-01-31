import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lpw
  implements aysa
{
  public void onResp(aysx paramaysx)
  {
    Object localObject = (lpx)paramaysx.jdField_a_of_type_Aysw.a();
    lcl.c("EffectBeautyTools", "download file call back. file = " + ((lpx)localObject).a);
    if (paramaysx.jdField_a_of_type_Int != 0)
    {
      lcl.c("EffectBeautyTools", "download file faild. errcode = " + paramaysx.b);
      return;
    }
    if (!((lpx)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c)))
    {
      lcl.c("EffectBeautyTools", "download file faild : md5 is not match.");
      bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      return;
    }
    lcl.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = lco.h();
      bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, (String)localObject, false);
      bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      return;
    }
    catch (IOException paramaysx)
    {
      paramaysx.printStackTrace();
      lcl.c("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpw
 * JD-Core Version:    0.7.0.1
 */