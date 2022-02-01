package dov.com.qq.im.ae.gif.giftext.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.data.AEGifMaterialManager.DownloadCallback;
import dov.com.qq.im.ae.download.AEDownloadStateWrapper;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import java.util.HashMap;
import java.util.Map;

public class AEGIFMaterialViewModel
  extends ViewModel
{
  private MutableLiveData<AEDownloadStateWrapper> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, AEGifMaterialManager.DownloadCallback> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public MutableLiveData<AEDownloadStateWrapper> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a(AppInterface paramAppInterface, AEGIFPreviewWrapper paramAEGIFPreviewWrapper)
  {
    AEGIFMaterialViewModel.1 local1 = new AEGIFMaterialViewModel.1(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramAEGIFPreviewWrapper.a.id, local1);
    AEGifMaterialManager.a().a(paramAppInterface, paramAEGIFPreviewWrapper.a, local1);
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel
 * JD-Core Version:    0.7.0.1
 */