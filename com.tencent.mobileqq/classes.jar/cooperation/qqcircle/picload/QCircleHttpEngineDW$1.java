package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class QCircleHttpEngineDW$1
  implements INetEngineListener
{
  QCircleHttpEngineDW$1(QCircleHttpEngineDW paramQCircleHttpEngineDW, Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("seq = ");
      paramNetResp.append(this.val$option.getSeq());
      paramNetResp.append(" download success return");
      QLog.i("QCircleFeedPicLoader", 1, paramNetResp.toString());
      this.val$callBackResult.callBack(this.val$option, true, 0);
      return;
    }
    StringBuilder localStringBuilder;
    if ((paramNetResp.mResult != 1) && (paramNetResp.mResult != 2))
    {
      if (paramNetResp.mResult != 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("seq = ");
        localStringBuilder.append(this.val$option.getSeq());
        localStringBuilder.append(" download failed return");
        localStringBuilder.append(paramNetResp.mErrCode);
        QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
        this.val$callBackResult.callBack(this.val$option, false, paramNetResp.mErrCode);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(this.val$option.getSeq());
      localStringBuilder.append(" download failed return:");
      localStringBuilder.append(paramNetResp.mErrCode);
      QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
      this.val$callBackResult.callBack(this.val$option, false, paramNetResp.mErrCode);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpEngineDW.1
 * JD-Core Version:    0.7.0.1
 */