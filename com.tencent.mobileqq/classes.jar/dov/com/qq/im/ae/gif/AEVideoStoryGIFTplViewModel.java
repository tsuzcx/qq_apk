package dov.com.qq.im.ae.gif;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.data.AEGifMaterialManager.DownloadCallback;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.download.AEDownloadStateWrapper;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.CaptureContext;
import java.util.HashMap;
import java.util.Map;

public class AEVideoStoryGIFTplViewModel
  extends ViewModel
{
  private MutableLiveData<AEDownloadStateWrapper> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, AEGifMaterialManager.DownloadCallback> jdField_a_of_type_JavaUtilMap = new HashMap();
  private MutableLiveData<AEMaterialWrapper> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private MutableLiveData<String> d = new MutableLiveData();
  
  public MutableLiveData<AEDownloadStateWrapper> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a()
  {
    AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)this.b.getValue();
    AEQLog.b("AEVideoStoryGIFTplViewModel", "[applyGIFTplAgain], lastMaterial=" + localAEMaterialWrapper);
    this.b.postValue(localAEMaterialWrapper);
  }
  
  public void a(AEMaterialWrapper paramAEMaterialWrapper)
  {
    AEVideoStoryGIFTplViewModel.1 local1 = new AEVideoStoryGIFTplViewModel.1(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramAEMaterialWrapper.jdField_a_of_type_JavaLangString, local1);
    AEGifMaterialManager.a().a(CaptureContext.a(), paramAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, local1);
  }
  
  public MutableLiveData<AEMaterialWrapper> b()
  {
    return this.b;
  }
  
  public void b(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    AEQLog.b("AEVideoStoryGIFTplViewModel", "[applyGIFTpl], material=" + paramAEMaterialWrapper);
    AEQLog.b("AEGIFStickerListPart", "[applyGIFTpl], material=" + paramAEMaterialWrapper);
    this.b.postValue(paramAEMaterialWrapper);
  }
  
  public MutableLiveData<String> c()
  {
    return this.c;
  }
  
  public void c(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (paramAEMaterialWrapper != null)
    {
      paramAEMaterialWrapper = (String)paramAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.c.postValue(paramAEMaterialWrapper);
      return;
    }
    this.c.postValue(null);
  }
  
  public MutableLiveData<String> d()
  {
    return this.d;
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel
 * JD-Core Version:    0.7.0.1
 */