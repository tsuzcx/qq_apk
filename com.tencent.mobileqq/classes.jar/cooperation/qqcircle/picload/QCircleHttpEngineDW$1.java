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
      QLog.i("QCircleFeedPicLoader", 1, "seq = " + this.val$option.getSeq() + " download success return");
      this.val$callBackResult.callBack(this.val$option, true, 0);
    }
    do
    {
      return;
      if ((paramNetResp.mResult == 1) || (paramNetResp.mResult == 2))
      {
        QLog.i("QCircleFeedPicLoader", 1, "seq = " + this.val$option.getSeq() + " download failed return:" + paramNetResp.mErrCode);
        this.val$callBackResult.callBack(this.val$option, false, paramNetResp.mErrCode);
        return;
      }
    } while (paramNetResp.mResult == 3);
    QLog.i("QCircleFeedPicLoader", 1, "seq = " + this.val$option.getSeq() + " download failed return" + paramNetResp.mErrCode);
    this.val$callBackResult.callBack(this.val$option, false, paramNetResp.mErrCode);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpEngineDW.1
 * JD-Core Version:    0.7.0.1
 */