package com.tencent.mobileqq.winkpublish.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;

public class PublishJurisdictionViewModel
  extends BaseViewModel
{
  public MutableLiveData<Boolean> a = new MutableLiveData();
  public MutableLiveData<Boolean> b = new MutableLiveData();
  public boolean c = false;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "0";
  private boolean j = true;
  private boolean k = true;
  
  public String a()
  {
    return null;
  }
  
  public void a(Boolean paramBoolean)
  {
    this.a.postValue(paramBoolean);
    this.j = paramBoolean.booleanValue();
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public void d()
  {
    this.k ^= true;
  }
  
  public void e()
  {
    this.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishJurisdictionViewModel
 * JD-Core Version:    0.7.0.1
 */