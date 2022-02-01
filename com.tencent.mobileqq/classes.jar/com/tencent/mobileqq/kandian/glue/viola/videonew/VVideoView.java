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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.biz.viola.video.constants.ViolaVideoConstants;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaTopicVideoDelegate;
import com.tencent.mobileqq.qroute.QRoute;
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
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private VVideo jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo;
  private VVideoView.OnVideoViewControlListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewControlListener;
  private VVideoView.OnVideoViewLifeCycleChangeListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewLifeCycleChangeListener;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private WeakReference<VVideo> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Boolean jdField_b_of_type_JavaLangBoolean;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Boolean jdField_c_of_type_JavaLangBoolean;
  private int jdField_d_of_type_Int;
  private Boolean jdField_d_of_type_JavaLangBoolean;
  
  public VVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = Boolean.valueOf(false);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = paramContext;
    this.jdField_b_of_type_JavaLangBoolean = paramContext;
    this.jdField_c_of_type_JavaLangBoolean = paramContext;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Int = 1;
    this.jdField_d_of_type_JavaLangBoolean = paramContext;
  }
  
  public VVideoView(@NonNull Context paramContext, VVideo paramVVideo)
  {
    super(paramContext);
    paramContext = Boolean.valueOf(false);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = paramContext;
    this.jdField_b_of_type_JavaLangBoolean = paramContext;
    this.jdField_c_of_type_JavaLangBoolean = paramContext;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Int = 1;
    this.jdField_d_of_type_JavaLangBoolean = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo = paramVVideo;
    setTag("VVideoView");
    addOnLayoutChangeListener(new VVideoView.1(this));
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (getParent() == null) {
      return true;
    }
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (a() != null)
    {
      if (a().getParent() == null) {
        return false;
      }
      if (a().getParent().getHostView() == localViewGroup) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public VVideo a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (VVideo)localWeakReference.get();
    }
    return null;
  }
  
  public VVideoView.OnVideoViewControlListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewControlListener;
  }
  
  public VVideoView.OnVideoViewLifeCycleChangeListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewLifeCycleChangeListener;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo;
    if ((localObject != null) && (((VVideo)localObject).getInstance() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo.getInstance().getUrl())) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo.getInstance().getUrl().contains("VideoFeeds.js")) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo.getInstance().getMasterVideoRef())))
    {
      localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, null, "0X800AF0F", "0X800AF0F", 0, 0, null, null, null, localStringBuilder.toString(), false);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo.getInstance().setMasterVideoRef(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo.getRef());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = getLayoutParams();
    if ((a() != null) && (a().getInstance() != null) && (a().getInstance().getActivity() != null))
    {
      Object localObject = a().getInstance().getActivity();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if ((getParent() instanceof ViewGroup))
        {
          this.jdField_b_of_type_Int = ((ViewGroup)getParent()).indexOfChild(this);
          b();
          ((ViewGroup)getParent()).removeView(this);
          c();
        }
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        if ((a() != null) && (a().getInstance() != null) && ((a().getInstance().getFragment() instanceof ViolaFragment)) && (((ViolaFragment)a().getInstance().getFragment()).isSuspension()))
        {
          ((CommonSuspensionGestureLayout)((ViolaFragment)a().getInstance().getFragment()).getCommonSuspensionGestureLayout()).addView(this, localLayoutParams);
          return;
        }
        ((Window)localObject).addContentView(this, localLayoutParams);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString, paramBoolean, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a().getInstance().getActivity() != null)
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
        ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangBoolean);
        ((StringBuilder)localObject).append(",handAttachVideoView:");
        ((StringBuilder)localObject).append(paramBoolean2);
        QLog.d("VVideoView", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean2);
      this.jdField_c_of_type_Int = paramInt1;
      if (paramInt1 == 1)
      {
        paramString = new VVideoDelegate(a().getInstance().getActivity(), this, paramInt2, a().getInstance(), paramString, paramBoolean1);
        setVideoViewControlListener(paramString);
        localObject = ViolaModuleManager.findModuleMapById(a().getInstance().getInstanceId());
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
        if (this.jdField_a_of_type_Int == 1)
        {
          paramString = new ViolaVideoView(a().getInstance().getActivity());
          setVideoViewControlListener(new ViolaVideoDelegate(a().getInstance().getActivity(), paramString, this, a().getInstance()));
          addView(paramString, -1, -1);
          return;
        }
        paramString = new ViolaVideoView(a().getInstance().getActivity());
        localObject = new ViolaTopicVideoDelegate(a().getInstance().getActivity(), paramString, this, a().getInstance());
        setVideoViewControlListener((VVideoView.OnVideoViewControlListener)localObject);
        setVideoViewLifeCycleChangeListener((VVideoView.OnVideoViewLifeCycleChangeListener)localObject);
        addView(paramString, -1, -1);
      }
    }
  }
  
  public void a(VVideo paramVVideo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVVideo);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideo.videoFireEvent(paramString, paramObject);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    VVideoView.OnVideoViewControlListener localOnVideoViewControlListener = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewControlListener;
    if (localOnVideoViewControlListener != null) {
      localOnVideoViewControlListener.f(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt;
    if ((a() != null) && (a().getParent() != null) && (a().getParent().getHostView() != null))
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
      {
        b();
        ((ViewGroup)getParent()).removeView(this);
        c();
      }
      ((ViewGroup)a().getParent().getHostView()).addView(this, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    VVideoView.OnVideoViewControlListener localOnVideoViewControlListener = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewControlListener;
    if (localOnVideoViewControlListener != null) {
      localOnVideoViewControlListener.g(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      if ((a() != null) && (!this.jdField_b_of_type_JavaLangBoolean.booleanValue()) && (this.jdField_c_of_type_Int == 1) && (this.jdField_c_of_type_JavaLangBoolean.booleanValue()) && (a()))
      {
        a().f();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewControlListener != null) && (!this.jdField_d_of_type_JavaLangBoolean.booleanValue()) && (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()))
    {
      this.jdField_d_of_type_JavaLangBoolean = Boolean.valueOf(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewControlListener.i();
    }
  }
  
  public void setAutoDestroy(Boolean paramBoolean)
  {
    this.jdField_c_of_type_JavaLangBoolean = paramBoolean;
  }
  
  public void setBringToRootByAnim(Boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangBoolean = paramBoolean;
  }
  
  public void setVideoViewControlListener(VVideoView.OnVideoViewControlListener paramOnVideoViewControlListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewControlListener = paramOnVideoViewControlListener;
  }
  
  public void setVideoViewLifeCycleChangeListener(VVideoView.OnVideoViewLifeCycleChangeListener paramOnVideoViewLifeCycleChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView$OnVideoViewLifeCycleChangeListener = paramOnVideoViewLifeCycleChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView
 * JD-Core Version:    0.7.0.1
 */