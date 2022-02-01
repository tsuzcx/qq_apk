package dov.com.qq.im.ae.gif;

import android.arch.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEGifMaterialManager.DownloadCallback;
import dov.com.qq.im.ae.download.AEDownloadStateWrapper;
import mqq.os.MqqHandler;

class AEVideoStoryGIFTplViewModel$1
  implements AEGifMaterialManager.DownloadCallback
{
  AEVideoStoryGIFTplViewModel$1(AEVideoStoryGIFTplViewModel paramAEVideoStoryGIFTplViewModel) {}
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryGIFTplViewModel.1.1(this, paramMetaMaterial));
  }
  
  public void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    AEVideoStoryGIFTplViewModel.a(this.a).postValue(new AEDownloadStateWrapper(paramMetaMaterial, 1, paramInt));
  }
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryGIFTplViewModel.1.2(this, paramMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.1
 * JD-Core Version:    0.7.0.1
 */