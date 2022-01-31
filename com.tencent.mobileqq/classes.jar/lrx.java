import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lrx
  implements bapx
{
  public void onResp(baqw parambaqw)
  {
    Object localObject = (lry)parambaqw.jdField_a_of_type_Baqv.a();
    lek.c("EffectBeautyTools", "download file call back. file = " + ((lry)localObject).a);
    if (parambaqw.jdField_a_of_type_Int != 0)
    {
      lek.c("EffectBeautyTools", "download file faild. errcode = " + parambaqw.b);
      return;
    }
    if (!((lry)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c)))
    {
      lek.c("EffectBeautyTools", "download file faild : md5 is not match.");
      bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      return;
    }
    lek.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = len.h();
      bdcs.a(parambaqw.jdField_a_of_type_Baqv.c, (String)localObject, false);
      bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      return;
    }
    catch (IOException parambaqw)
    {
      parambaqw.printStackTrace();
      lek.c("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrx
 * JD-Core Version:    0.7.0.1
 */