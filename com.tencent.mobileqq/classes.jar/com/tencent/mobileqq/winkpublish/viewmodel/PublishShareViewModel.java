package com.tencent.mobileqq.winkpublish.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;

public class PublishShareViewModel
  extends BaseViewModel
{
  private static final String d;
  public MutableLiveData<Boolean> a = new MutableLiveData();
  public MutableLiveData<Boolean> b = new MutableLiveData();
  public boolean c = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSShareViewModel");
    d = localStringBuilder.toString();
  }
  
  public String a()
  {
    return d;
  }
  
  public void b()
  {
    this.c ^= true;
    this.a.postValue(Boolean.valueOf(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishShareViewModel
 * JD-Core Version:    0.7.0.1
 */