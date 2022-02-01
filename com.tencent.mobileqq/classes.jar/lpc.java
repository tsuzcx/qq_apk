import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lpc
  implements INetEngine.INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (lpd)paramNetResp.mReq.getUserData();
    lbd.f("EffectBeautyTools", "download file call back. file = " + ((lpd)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      lbd.f("EffectBeautyTools", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((lpd)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      lbd.f("EffectBeautyTools", "download file faild : md5 is not match.");
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    lbd.f("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = lbh.h();
      FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      lbd.f("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpc
 * JD-Core Version:    0.7.0.1
 */