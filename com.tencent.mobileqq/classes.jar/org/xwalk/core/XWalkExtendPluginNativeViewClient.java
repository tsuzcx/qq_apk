package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.FrameLayout;

public class XWalkExtendPluginNativeViewClient
{
  private static final String TAG = "XWalkExtendPluginNativeViewClient";
  private Context mContext;
  private XWalkExtendPluginNativeViewDelegate mDelegate;
  private int mHeight;
  private XWalkExtendPluginNativeViewClient.NativeViewPresentation mNativeViewPresentation;
  private FrameLayout mRootView;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private VirtualDisplay mVirtualDisplay;
  private int mWidth;
  
  public XWalkExtendPluginNativeViewClient(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mSurfaceTexture = paramSurfaceTexture;
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  private void refresh(boolean paramBoolean)
  {
    Object localObject = this.mNativeViewPresentation;
    if (localObject != null) {
      ((XWalkExtendPluginNativeViewClient.NativeViewPresentation)localObject).detach();
    }
    localObject = this.mVirtualDisplay;
    if (localObject != null)
    {
      ((VirtualDisplay)localObject).setSurface(null);
      this.mVirtualDisplay.release();
    }
    this.mSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
    localObject = (DisplayManager)getContext().getSystemService("display");
    int i = getContext().getResources().getDisplayMetrics().densityDpi;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("xweb-vd");
    localStringBuilder.append(hashCode());
    this.mVirtualDisplay = ((DisplayManager)localObject).createVirtualDisplay(localStringBuilder.toString(), this.mWidth, this.mHeight, i, this.mSurface, 0);
    this.mNativeViewPresentation = new XWalkExtendPluginNativeViewClient.NativeViewPresentation(this, getContext(), this.mVirtualDisplay.getDisplay(), false, this);
    this.mNativeViewPresentation.show();
  }
  
  public void dispose()
  {
    Object localObject = this.mDelegate;
    if (localObject != null) {
      ((XWalkExtendPluginNativeViewDelegate)localObject).onDestroy();
    }
    localObject = this.mNativeViewPresentation;
    if (localObject != null)
    {
      ((XWalkExtendPluginNativeViewClient.NativeViewPresentation)localObject).cancel();
      this.mNativeViewPresentation.detach();
    }
    localObject = this.mVirtualDisplay;
    if (localObject != null) {
      ((VirtualDisplay)localObject).release();
    }
  }
  
  public Context getContext()
  {
    XWalkExtendPluginNativeViewDelegate localXWalkExtendPluginNativeViewDelegate = this.mDelegate;
    if (localXWalkExtendPluginNativeViewDelegate != null) {
      return localXWalkExtendPluginNativeViewDelegate.getContext();
    }
    Log.e("XWalkExtendPluginNativeViewClient", "no context");
    return null;
  }
  
  public FrameLayout getRootView()
  {
    return this.mRootView;
  }
  
  public void onNativeViewDestroy(int paramInt) {}
  
  public void onNativeViewReady(int paramInt) {}
  
  public void onNativeViewSizeChanged(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onNativeViewTouch(int paramInt, MotionEvent paramMotionEvent) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    XWalkExtendPluginNativeViewDelegate localXWalkExtendPluginNativeViewDelegate = this.mDelegate;
    if (localXWalkExtendPluginNativeViewDelegate != null) {
      localXWalkExtendPluginNativeViewDelegate.onSizeChanged(paramInt1, paramInt2);
    }
    if ((this.mWidth != paramInt1) || (this.mHeight != paramInt2))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      refresh(false);
    }
  }
  
  public void setDelegate(XWalkExtendPluginNativeViewDelegate paramXWalkExtendPluginNativeViewDelegate)
  {
    this.mDelegate = paramXWalkExtendPluginNativeViewDelegate;
    if (paramXWalkExtendPluginNativeViewDelegate != null)
    {
      this.mRootView = new FrameLayout(paramXWalkExtendPluginNativeViewDelegate.getContext());
      refresh(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendPluginNativeViewClient
 * JD-Core Version:    0.7.0.1
 */