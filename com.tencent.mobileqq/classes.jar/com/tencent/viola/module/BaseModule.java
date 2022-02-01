package com.tencent.viola.module;

import android.content.Intent;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaInstance;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class BaseModule
  implements IActivityState
{
  private ArrayList<String> mFunctions = new ArrayList();
  private String mModuleName = "BaseModule";
  private WeakReference<ViolaInstance> mVInstance;
  
  public boolean callbackJavascript(Object paramObject)
  {
    return true;
  }
  
  public String getModuleName()
  {
    return this.mModuleName;
  }
  
  public ViolaInstance getViolaInstance()
  {
    if (this.mVInstance != null) {
      return (ViolaInstance)this.mVInstance.get();
    }
    return null;
  }
  
  public boolean onActivityBack()
  {
    return false;
  }
  
  public void onActivityCreate() {}
  
  public void onActivityDestroy() {}
  
  public void onActivityPause() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume() {}
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void setModuleName(String paramString)
  {
    this.mModuleName = paramString;
  }
  
  public void setViolaInstance(ViolaInstance paramViolaInstance)
  {
    this.mVInstance = new WeakReference(paramViolaInstance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.module.BaseModule
 * JD-Core Version:    0.7.0.1
 */