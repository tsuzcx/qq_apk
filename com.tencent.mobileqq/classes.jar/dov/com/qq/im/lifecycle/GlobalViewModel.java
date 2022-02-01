package dov.com.qq.im.lifecycle;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.CallSuper;

public class GlobalViewModel
  extends ViewModel
{
  @CallSuper
  public void onCleared()
  {
    super.onCleared();
    GlobalViewModelFactory.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.lifecycle.GlobalViewModel
 * JD-Core Version:    0.7.0.1
 */