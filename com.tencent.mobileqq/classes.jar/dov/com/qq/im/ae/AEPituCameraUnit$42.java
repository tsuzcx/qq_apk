package dov.com.qq.im.ae;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import dov.com.qq.im.ae.gif.AEExpressionRecognizer.RecommendTextCallback;
import dov.com.qq.im.ae.gif.RecognizedEmotionBean;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import dov.com.qq.im.lifecycle.GlobalViewModelFactory;

class AEPituCameraUnit$42
  implements AEExpressionRecognizer.RecommendTextCallback
{
  AEPituCameraUnit$42(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    ((AEGIFRecommandTextViewModel)AEViewModelProviders.a(this.a, GlobalViewModelFactory.a()).get(AEGIFRecommandTextViewModel.class)).a().postValue(paramRecognizedEmotionBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.42
 * JD-Core Version:    0.7.0.1
 */