package dov.com.qq.im.capture.banner;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class QIMCaptureBannerManager$3$1
  implements INetEngineListener
{
  QIMCaptureBannerManager$3$1(QIMCaptureBannerManager.3 param3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCaptureBannerManager", 2, "onResp url: " + this.a.a.imgUrl + " resultcode: " + paramNetResp.mHttpCode);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3.1
 * JD-Core Version:    0.7.0.1
 */