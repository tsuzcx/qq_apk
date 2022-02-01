package com.tencent.mobileqq.wink.pick.circle.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.PhotoListGuideData;

public class PickAlbumViewModel
  extends ViewModel
{
  private boolean a = false;
  private final MutableLiveData<WinkCirclePhotoListLogic.PhotoListGuideData> b = new MutableLiveData();
  
  public LiveData<WinkCirclePhotoListLogic.PhotoListGuideData> a()
  {
    return this.b;
  }
  
  public void a(WinkCirclePhotoListLogic.PhotoListGuideData paramPhotoListGuideData)
  {
    if (!this.a)
    {
      this.b.postValue(paramPhotoListGuideData);
      this.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.model.PickAlbumViewModel
 * JD-Core Version:    0.7.0.1
 */