package dov.com.qq.im.ae.gif.giftext.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import dov.com.qq.im.ae.download.AEDownloadStateWrapper;

class AEGIFMaterialViewModel$1$1
  implements Runnable
{
  AEGIFMaterialViewModel$1$1(AEGIFMaterialViewModel.1 param1, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    AEGIFMaterialViewModel.a(this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFMaterialViewModel$1.a).setValue(new AEDownloadStateWrapper(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1.1
 * JD-Core Version:    0.7.0.1
 */