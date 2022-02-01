package com.tencent.mobileqq.location;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.location.ui.LocationPickController;
import com.tencent.mobileqq.location.ui.LocationShareController;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;

public class LocationShareViewBinder
{
  public static void a(LocationPickViewModel paramLocationPickViewModel, LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, LocationPickController paramLocationPickController)
  {
    paramLocationPickViewModel.a();
    paramLocationPickViewModel.a.observe(paramLifeCycleAndViewModelStoreOwner, new LocationShareViewBinder.4(paramLocationPickController));
    paramLocationPickViewModel.b.observe(paramLifeCycleAndViewModelStoreOwner, new LocationShareViewBinder.5(paramLocationPickController));
  }
  
  public static void a(LocationShareViewModel paramLocationShareViewModel, LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, LocationShareController paramLocationShareController)
  {
    paramLocationShareViewModel.a();
    paramLocationShareViewModel.a.observe(paramLifeCycleAndViewModelStoreOwner, new LocationShareViewBinder.1(paramLocationShareController));
    paramLocationShareViewModel.b.observe(paramLifeCycleAndViewModelStoreOwner, new LocationShareViewBinder.2(paramLocationShareController));
    paramLocationShareViewModel.c.observe(paramLifeCycleAndViewModelStoreOwner, new LocationShareViewBinder.3(paramLocationShareController));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareViewBinder
 * JD-Core Version:    0.7.0.1
 */