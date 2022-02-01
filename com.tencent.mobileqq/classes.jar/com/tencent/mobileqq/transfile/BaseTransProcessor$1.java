package com.tencent.mobileqq.transfile;

import java.util.HashMap;

final class BaseTransProcessor$1
  implements INetEngine.IBreakDownFix
{
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    label8:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (!(paramNetReq instanceof HttpNetReq));
          paramNetReq = (HttpNetReq)paramNetReq;
          paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
          if (0L != paramNetReq.mEndDownOffset) {
            break;
          }
          paramNetResp.mWrittenBlockLen = 0L;
          paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-";
          paramNetReq.mReqProperties.put("Range", paramNetResp);
          paramNetResp = paramNetReq.mReqUrl;
        } while (!paramNetResp.contains("range="));
        paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        paramNetReq.mReqUrl = (paramNetResp + "range=" + paramNetReq.mStartDownOffset);
        return;
      } while ((paramNetReq.mStartDownOffset <= 0L) || (paramNetReq.mEndDownOffset <= 0L) || (paramNetReq.mStartDownOffset >= paramNetReq.mEndDownOffset));
      paramNetResp.mWrittenBlockLen = 0L;
      paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-" + paramNetReq.mEndDownOffset;
      paramNetReq.mReqProperties.put("Range", paramNetResp);
      paramNetResp = paramNetReq.mReqUrl;
    } while (!paramNetResp.contains("range="));
    paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
    paramNetReq.mReqUrl = (paramNetResp + "range=" + paramNetReq.mStartDownOffset + "-" + paramNetReq.mEndDownOffset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessor.1
 * JD-Core Version:    0.7.0.1
 */