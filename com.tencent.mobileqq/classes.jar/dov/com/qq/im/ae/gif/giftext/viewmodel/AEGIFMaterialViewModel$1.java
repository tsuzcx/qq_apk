package dov.com.qq.im.ae.gif.giftext.viewmodel;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEGifMaterialManager.DownloadCallback;
import mqq.os.MqqHandler;

class AEGIFMaterialViewModel$1
  implements AEGifMaterialManager.DownloadCallback
{
  AEGIFMaterialViewModel$1(AEGIFMaterialViewModel paramAEGIFMaterialViewModel) {}
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEGIFMaterialViewModel.1.1(this, paramMetaMaterial));
  }
  
  public void a(MetaMaterial paramMetaMaterial, int paramInt) {}
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEGIFMaterialViewModel.1.2(this, paramMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1
 * JD-Core Version:    0.7.0.1
 */