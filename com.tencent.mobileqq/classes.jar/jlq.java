import com.tencent.av.AVLog;
import com.tencent.av.opengl.effects.EffectBeautyTools;
import com.tencent.av.opengl.effects.EffectBeautyTools.SkinColorFilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

public class jlq
  implements INetEngine.INetEngineListener
{
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    Object localObject = (EffectBeautyTools.SkinColorFilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    AVLog.c("EffectBeautyTools", "download file call back. file = " + ((EffectBeautyTools.SkinColorFilterDesc)localObject).a);
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      AVLog.c("EffectBeautyTools", "download file faild. errcode = " + paramNetResp.b);
      return;
    }
    if (!((EffectBeautyTools.SkinColorFilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
    {
      AVLog.c("EffectBeautyTools", "download file faild : md5 is not match.");
      FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      return;
    }
    AVLog.c("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = EffectBeautyTools.a();
      FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, (String)localObject, false);
      FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.c("EffectBeautyTools", "unzip file faild.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jlq
 * JD-Core Version:    0.7.0.1
 */