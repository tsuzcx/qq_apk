import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lrx
  implements baug
{
  public void onResp(bavf parambavf)
  {
    Object localObject = (lry)parambavf.jdField_a_of_type_Bave.a();
    lek.c("EffectBeautyTools", "download file call back. file = " + ((lry)localObject).a);
    if (parambavf.jdField_a_of_type_Int != 0)
    {
      lek.c("EffectBeautyTools", "download file faild. errcode = " + parambavf.b);
      return;
    }
    if (!((lry)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c)))
    {
      lek.c("EffectBeautyTools", "download file faild : md5 is not match.");
      bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      return;
    }
    lek.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = len.h();
      bdhb.a(parambavf.jdField_a_of_type_Bave.c, (String)localObject, false);
      bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      return;
    }
    catch (IOException parambavf)
    {
      parambavf.printStackTrace();
      lek.c("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrx
 * JD-Core Version:    0.7.0.1
 */