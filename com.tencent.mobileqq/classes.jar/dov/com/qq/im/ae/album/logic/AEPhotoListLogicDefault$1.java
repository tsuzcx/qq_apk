package dov.com.qq.im.ae.album.logic;

import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;

class AEPhotoListLogicDefault$1
  implements TAVCut.Callback
{
  AEPhotoListLogicDefault$1(AEPhotoListLogicDefault paramAEPhotoListLogicDefault) {}
  
  public void onDone(int paramInt)
  {
    AEQLog.b("AEPhotoListLogicDefault", "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEPhotoListLogicDefault.a(this.a).add(new AEPhotoListLogicDefault.InitResult(this.a, -9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.1
 * JD-Core Version:    0.7.0.1
 */