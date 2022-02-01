package dov.com.qq.im.ae.camera.ui.topbar;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class AEVideoStoryTopBarViewModel
  extends ViewModel
{
  public final MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> a = new MutableLiveData();
  private MutableLiveData<AEVideoStoryTopBarViewModel.CountDownSetting> b = new MutableLiveData();
  private MutableLiveData<Boolean> c = new MutableLiveData();
  
  public MutableLiveData<AEVideoStoryTopBarViewModel.CountDownSetting> a()
  {
    return this.b;
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel
 * JD-Core Version:    0.7.0.1
 */