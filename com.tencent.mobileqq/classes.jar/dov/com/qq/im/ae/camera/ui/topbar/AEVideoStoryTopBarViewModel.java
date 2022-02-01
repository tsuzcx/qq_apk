package dov.com.qq.im.ae.camera.ui.topbar;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import bltn;

public class AEVideoStoryTopBarViewModel
  extends ViewModel
{
  public final MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> a = new MutableLiveData();
  private MutableLiveData<bltn> b = new MutableLiveData();
  private MutableLiveData<Boolean> c = new MutableLiveData();
  
  public MutableLiveData<bltn> a()
  {
    return this.b;
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel
 * JD-Core Version:    0.7.0.1
 */