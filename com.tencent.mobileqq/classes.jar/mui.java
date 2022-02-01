import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class mui
  implements INetEngine.IBreakDownFix
{
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    HttpNetReq localHttpNetReq;
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      localHttpNetReq = (HttpNetReq)paramNetReq;
      localHttpNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
      paramNetResp.mWrittenBlockLen = 0L;
      paramNetResp = "bytes=" + localHttpNetReq.mStartDownOffset + "-";
      localHttpNetReq.mReqProperties.put("Range", paramNetResp);
      paramNetResp = localHttpNetReq.mReqUrl;
      if (paramNetResp.contains("range="))
      {
        paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        localHttpNetReq.mReqUrl = (paramNetResp + "range=" + localHttpNetReq.mStartDownOffset);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "IBreakDownFix. url = " + ((HttpNetReq)paramNetReq).mReqUrl + ", offset=" + localHttpNetReq.mStartDownOffset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mui
 * JD-Core Version:    0.7.0.1
 */