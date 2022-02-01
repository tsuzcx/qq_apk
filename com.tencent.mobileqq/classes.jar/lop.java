import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class lop
  implements INetEngine.INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (loq)paramNetResp.mReq.getUserData();
    lba.f("EffectBeautyTools", "download file call back. file = " + ((loq)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      lba.f("EffectBeautyTools", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((loq)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      lba.f("EffectBeautyTools", "download file faild : md5 is not match.");
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    lba.f("EffectBeautyTools", "download file successed.");
    try
    {
      localObject = lbe.h();
      FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      lba.f("EffectBeautyTools", "unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lop
 * JD-Core Version:    0.7.0.1
 */