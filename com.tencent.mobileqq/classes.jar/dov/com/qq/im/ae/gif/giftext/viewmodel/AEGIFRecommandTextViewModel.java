package dov.com.qq.im.ae.gif.giftext.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import dov.com.qq.im.ae.gif.RecognizedEmotionBean;
import dov.com.qq.im.lifecycle.GlobalViewModel;

public class AEGIFRecommandTextViewModel
  extends GlobalViewModel
{
  private MutableLiveData<RecognizedEmotionBean> a = new MutableLiveData();
  
  public MutableLiveData<RecognizedEmotionBean> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel
 * JD-Core Version:    0.7.0.1
 */