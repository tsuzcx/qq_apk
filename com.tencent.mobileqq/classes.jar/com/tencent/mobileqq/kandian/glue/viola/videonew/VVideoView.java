package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.biz.viola.video.constants.ViolaVideoConstants;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaTopicVideoDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;
import java.util.Map;

public class VVideoView
  extends FrameLayout
  implements ViolaVideoConstants, IVView<VVideo>
{
  public int a;
  private WeakReference<VVideo> b;
  private VVideo c;
  private int d;
  private Boolean e;
  private Boolean f;
  private Boolean g;
  private int h;
  private boolean i;
  private boolean j;
  private VVideoView.OnVideoViewControlListener k;
  private VVideoView.OnVideoViewLifeCycleChangeListener l;
  private int m;
  private ViewGroup.LayoutParams n;
  private Boolean o;
  
  public VVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = Boolean.valueOf(false);
    this.d = 0;
    this.e = paramContext;
    this.f = paramContext;
    this.g = paramContext;
    this.h = 1;
    this.m = 1;
    this.a = 1;
    this.o = paramContext;
  }
  
  public VVideoView(@NonNull Context paramContext, VVideo paramVVideo)
  {
    super(paramContext);
    paramContext = Boolean.valueOf(false);
    this.d = 0;
    this.e = paramContext;
    this.f = paramContext;
    this.g = paramContext;
    this.h = 1;
    this.m = 1;
    this.a = 1;
    this.o = paramContext;
    this.c = paramVVideo;
    setTag("VVideoView");
    addOnLayoutChangeListener(new VVideoView.1(this));
  }
  
  private boolean d()
  {
    if (this.j) {
      return false;
    }
    if (getParent() == null) {
      return true;
    }
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (getComponent() != null)
    {
      if (getComponent().getParent() == null) {
        return false;
      }
      if (getComponent().getParent().getHostView() == localViewGroup) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((VVideo)localObject).getInstance() != null) && (!TextUtils.isEmpty(this.c.getInstance().getUrl())) && (this.c.getInstance().getUrl().contains("VideoFeeds.js")) && (TextUtils.isEmpty(this.c.getInstance().getMasterVideoRef())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      PublicAccountReportUtils.a(null, null, "0X800AF0F", "0X800AF0F", 0, 0, null, null, null, ((StringBuilder)localObject).toString(), false);
      this.c.getInstance().setMasterVideoRef(this.c.getRef());
    }
  }
  
  public void a(int paramInt)
  {
    this.i = true;
    this.m = paramInt;
    this.n = getLayoutParams();
    if ((getComponent() != null) && (getComponent().getInstance() != null) && (getComponent().getInstance().getActivity() != null))
    {
      Object localObject = getComponent().getInstance().getActivity();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if ((getParent() instanceof ViewGroup))
        {
          this.d = ((ViewGroup)getParent()).indexOfChild(this);
          b();
          ((ViewGroup)getParent()).removeView(this);
          c();
        }
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        if ((getComponent() != null) && (getComponent().getInstance() != null) && ((getComponent().getInstance().getFragment() instanceof ViolaFragment)) && (((ViolaFragment)getComponent().getInstance().getFragment()).isSuspension()))
        {
          ((CommonSuspensionGestureLayout)((ViolaFragment)getComponent().getInstance().getFragment()).getCommonSuspensionGestureLayout()).addView(this, localLayoutParams);
          return;
        }
        ((Window)localObject).addContentView(this, localLayoutParams);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString, paramBoolean, false, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (getComponent().getInstance().getActivity() != null)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initView: playerType=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", sceneType=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(",autoAttachVideoView:");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append(",videoToken:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",firstFrameDrawed:");
        ((StringBuilder)localObject).append(this.o);
        ((StringBuilder)localObject).append(",handAttachVideoView:");
        ((StringBuilder)localObject).append(paramBoolean2);
        ((StringBuilder)localObject).append(", usePlayerPool:");
        ((StringBuilder)localObject).append(paramBoolean3);
        QLog.d("VVideoView", 2, ((StringBuilder)localObject).toString());
      }
      this.e = Boolean.valueOf(paramBoolean2);
      this.h = paramInt1;
      if (paramInt1 == 1)
      {
        paramString = new VVideoDelegate(getComponent().getInstance().getActivity(), this, paramInt2, getComponent().getInstance(), paramString, paramBoolean1, paramBoolean3);
        setVideoViewControlListener(paramString);
        localObject = ViolaModuleManager.findModuleMapById(getComponent().getInstance().getInstanceId());
        if (localObject != null)
        {
          localObject = (BaseModule)((Map)localObject).get(BridgeModule.MODULE_NAME);
          if ((localObject instanceof BridgeModule))
          {
            localObject = ((BridgeModule)localObject).getField("predownload");
            if ((localObject instanceof VideoPreDownloadMgr)) {
              paramString.a((IVideoPreDownloadMgr)localObject);
            }
          }
        }
      }
      else
      {
        if (this.a == 1)
        {
          paramString = new ViolaVideoView(getComponent().getInstance().getActivity());
          setVideoViewControlListener(new ViolaVideoDelegate(getComponent().getInstance().getActivity(), paramString, this, getComponent().getInstance()));
          addView(paramString, -1, -1);
          return;
        }
        paramString = new ViolaVideoView(getComponent().getInstance().getActivity());
        localObject = new ViolaTopicVideoDelegate(getComponent().getInstance().getActivity(), paramString, this, getComponent().getInstance());
        setVideoViewControlListener((VVideoView.OnVideoViewControlListener)localObject);
        setVideoViewLifeCycleChangeListener((VVideoView.OnVideoViewLifeCycleChangeListener)localObject);
        addView(paramString, -1, -1);
      }
    }
  }
  
  public void a(VVideo paramVVideo)
  {
    this.b = new WeakReference(paramVVideo);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.c.videoFireEvent(paramString, paramObject);
  }
  
  public void b()
  {
    this.j = true;
    VVideoView.OnVideoViewControlListener localOnVideoViewControlListener = this.k;
    if (localOnVideoViewControlListener != null) {
      localOnVideoViewControlListener.f(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.i = false;
    this.m = paramInt;
    if ((getComponent() != null) && (getComponent().getParent() != null) && (getComponent().getParent().getHostView() != null))
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
      {
        b();
        ((ViewGroup)getParent()).removeView(this);
        c();
      }
      ((ViewGroup)getComponent().getParent().getHostView()).addView(this, this.d, this.n);
    }
  }
  
  public void c()
  {
    this.j = false;
    VVideoView.OnVideoViewControlListener localOnVideoViewControlListener = this.k;
    if (localOnVideoViewControlListener != null) {
      localOnVideoViewControlListener.g(this);
    }
  }
  
  public VVideo getComponent()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      return (VVideo)localWeakReference.get();
    }
    return null;
  }
  
  public int getScreenOrientation()
  {
    return this.m;
  }
  
  public VVideoView.OnVideoViewControlListener getVideoViewControlListener()
  {
    return this.k;
  }
  
  public VVideoView.OnVideoViewLifeCycleChangeListener getVideoViewLifeCycleChangeListener()
  {
    return this.l;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      if ((getVideoViewControlListener() != null) && (!this.f.booleanValue()) && (this.h == 1) && (this.g.booleanValue()) && (d()))
      {
        getVideoViewControlListener().f();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetachedFromWindow error:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VVideoView", 2, localStringBuilder.toString());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.k != null) && (!this.o.booleanValue()) && (!this.e.booleanValue()))
    {
      this.o = Boolean.valueOf(true);
      this.k.j();
    }
  }
  
  public void setAutoDestroy(Boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setBringToRootByAnim(Boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setVideoViewControlListener(VVideoView.OnVideoViewControlListener paramOnVideoViewControlListener)
  {
    this.k = paramOnVideoViewControlListener;
  }
  
  public void setVideoViewLifeCycleChangeListener(VVideoView.OnVideoViewLifeCycleChangeListener paramOnVideoViewLifeCycleChangeListener)
  {
    this.l = paramOnVideoViewLifeCycleChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView
 * JD-Core Version:    0.7.0.1
 */