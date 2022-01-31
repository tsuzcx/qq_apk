import com.tencent.av.AVLog;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;

public class jga
  implements INetEngine.INetEngineListener
{
  public jga(EffectFilterTools paramEffectFilterTools) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    FilterItem localFilterItem = (FilterItem)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.jdField_a_of_type_Int != 0) {
      AVLog.c("EffectFilterTools", "download IconFile. errcode = " + paramNetResp.b + "|" + localFilterItem.getId());
    }
    String str;
    do
    {
      return;
      str = SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
    } while (localFilterItem.getIconMd5().equalsIgnoreCase(str));
    AVLog.c("EffectFilterTools", "download IconFile faild : md5 is not match: " + localFilterItem.getIconMd5() + "|" + str);
    FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jga
 * JD-Core Version:    0.7.0.1
 */