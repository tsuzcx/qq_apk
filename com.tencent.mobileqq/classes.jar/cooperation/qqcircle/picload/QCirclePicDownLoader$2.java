package cooperation.qqcircle.picload;

import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class QCirclePicDownLoader$2
  implements INetEngine.INetEngineListener
{
  QCirclePicDownLoader$2(QCirclePicDownLoader paramQCirclePicDownLoader, Option paramOption) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 0)
    {
      QLog.i(QCirclePicDownLoader.LOG_TAG, 1, "seq = " + this.val$option.getSeq() + " download success return");
      QCirclePicDownLoader.access$000(this.this$0, this.val$option, true, 0);
    }
    do
    {
      return;
      if ((paramNetResp.mResult == 1) || (paramNetResp.mResult == 2))
      {
        QLog.i(QCirclePicDownLoader.LOG_TAG, 1, "seq = " + this.val$option.getSeq() + " download failed return:" + paramNetResp.mErrCode);
        QCirclePicDownLoader.access$000(this.this$0, this.val$option, false, paramNetResp.mErrCode);
        return;
      }
    } while (paramNetResp.mResult == 3);
    QLog.i(QCirclePicDownLoader.LOG_TAG, 1, "seq = " + this.val$option.getSeq() + " download failed return" + paramNetResp.mErrCode);
    QCirclePicDownLoader.access$000(this.this$0, this.val$option, false, paramNetResp.mErrCode);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCirclePicDownLoader.2
 * JD-Core Version:    0.7.0.1
 */