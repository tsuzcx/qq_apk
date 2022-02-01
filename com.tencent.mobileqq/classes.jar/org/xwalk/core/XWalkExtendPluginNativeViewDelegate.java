package org.xwalk.core;

import android.content.Context;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public abstract class XWalkExtendPluginNativeViewDelegate
{
  private WeakReference<XWalkExtendPluginNativeViewClient> mClient;
  
  public abstract Context getContext();
  
  public FrameLayout getRootView()
  {
    if (this.mClient.get() != null) {
      return ((XWalkExtendPluginNativeViewClient)this.mClient.get()).getRootView();
    }
    return null;
  }
  
  public abstract void onCreate(int paramInt1, int paramInt2);
  
  public abstract void onDestroy();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public void setClient(XWalkExtendPluginNativeViewClient paramXWalkExtendPluginNativeViewClient)
  {
    this.mClient = new WeakReference(paramXWalkExtendPluginNativeViewClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendPluginNativeViewDelegate
 * JD-Core Version:    0.7.0.1
 */