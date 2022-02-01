package com.tencent.viola.vinstance;

import android.content.Context;
import android.os.Looper;
import android.view.View;

public class NVViewModel
  implements VInstanceAction.VInstanceEventListener
{
  private String data;
  private boolean destroy;
  private String id;
  private NVViewModel.NVViewModelEventListener modelEventListener;
  private View nativeVueView;
  
  public NVViewModel(String paramString1, String paramString2)
  {
    this.id = paramString1;
    this.data = paramString2;
    initSync();
  }
  
  public static NVViewModel createSync(String paramString1, String paramString2)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramString1 = new NVViewModel(paramString1, paramString2);
      paramString1.initSync();
      return paramString1;
    }
    throw new IllegalStateException("can not createSync in main thread");
  }
  
  private void initSync()
  {
    VInstanceManager.getInstance().addVInstanceEventListener(this.id, this);
    VInstanceManager.getInstance().createVInstanceSync(this.id, this.data);
  }
  
  public boolean bindData()
  {
    return VInstanceManager.getInstance().bindNativeVueData(this.id, this.data, this.nativeVueView);
  }
  
  public void destroy(String paramString)
  {
    this.destroy = true;
    VInstanceManager.getInstance().removeVInstanceEventListener(this.id);
    VInstanceManager.getInstance().release(this.id, paramString);
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public int getHeight()
  {
    return VInstanceManager.getInstance().getHeight(this.id);
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public View getNativeVueView()
  {
    return this.nativeVueView;
  }
  
  public int getWidth()
  {
    return VInstanceManager.getInstance().getWidth(this.id);
  }
  
  public void initView(Context paramContext)
  {
    this.nativeVueView = VInstanceManager.getInstance().createNativeVueView(this.id, paramContext);
  }
  
  public void onError(String paramString)
  {
    NVViewModel.NVViewModelEventListener localNVViewModelEventListener = this.modelEventListener;
    if (localNVViewModelEventListener != null) {
      localNVViewModelEventListener.onError(paramString, this.data);
    }
  }
  
  public void onRefreshItem(String paramString)
  {
    if ((!this.destroy) && (paramString != null) && (paramString.equals(this.id)))
    {
      bindData();
      paramString = this.modelEventListener;
      if (paramString != null) {
        paramString.onRefresh(this.data, this.nativeVueView);
      }
    }
  }
  
  public void setModelEventListener(NVViewModel.NVViewModelEventListener paramNVViewModelEventListener)
  {
    this.modelEventListener = paramNVViewModelEventListener;
  }
  
  public void update(String paramString)
  {
    VInstanceManager.getInstance().updateInstance(this.id, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.NVViewModel
 * JD-Core Version:    0.7.0.1
 */