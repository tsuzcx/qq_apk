package dov.com.qq.im.ae.biz.qcircle;

import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;

class AECirclePhotoListLogic$2
  implements TAVCut.Callback
{
  AECirclePhotoListLogic$2(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onDone(int paramInt)
  {
    AEQLog.b("AECirclePhotoListLogic", "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AECirclePhotoListLogic.a(this.a).add(new AECirclePhotoListLogic.InitResult(this.a, -9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic.2
 * JD-Core Version:    0.7.0.1
 */