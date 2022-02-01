package dov.com.qq.im.aeeditor;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleDTParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.TAVCut;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectIpcModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEEditorActivity
  extends PeakFragmentActivity
  implements LifecycleOwner, ViewModelStoreOwner
{
  private final LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  private AEEditorModuleManager jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager;
  private List<AEEditorActivity.InitResult> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  
  private void a()
  {
    if (!AEKitForQQ.a()) {
      this.jdField_a_of_type_JavaUtilList.add(new AEEditorActivity.InitResult(-1));
    }
    for (;;)
    {
      TAVCut.initTAVCut(getApplicationContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AEEditorActivity.1(this));
      return;
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(FeatureManager.Features.LIGHT_SDK.init(), -8);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
  }
  
  private void a(Lifecycle.Event paramEvent)
  {
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(paramEvent);
      return;
    }
    catch (Throwable paramEvent)
    {
      QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(new AEEditorActivity.InitResult(paramInt));
    }
  }
  
  private void b()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this, "small_world_base");
    VideoReport.setPageParams(this, new QCircleDTParamBuilder().setPageSubclass("AEEditorActivity").buildPageParams());
    QLog.i("AEEditorActivity", 1, "reportDaTongRegister  subPage: AEEditorActivity");
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AEEditorActivity.InitResult localInitResult = (AEEditorActivity.InitResult)localIterator.next();
        ((StringBuilder)localObject).append(localInitResult.toString() + "\n");
      }
      localObject = ((StringBuilder)localObject).toString();
      AEQLog.d("AEEditorActivity", "checkInitResult--" + (String)localObject);
      return;
    }
    VideoThumbProviderManager.initLruCacheSize(3072);
    Object localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837974);
    if ((localObject instanceof BitmapDrawable)) {
      VideoThumbProviderManager.getInstance().setDefaultBitmap(((BitmapDrawable)localObject).getBitmap());
    }
    for (;;)
    {
      d();
      return;
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        VideoThumbProviderManager.getInstance().setDefaultBitmap(((SkinnableBitmapDrawable)localObject).getBitmap());
      }
    }
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getExtras() != null) {
      localBundle = getIntent().getExtras();
    }
    this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager = new AEEditorModuleManager(getSupportFragmentManager());
    this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager.a(localBundle);
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("editorType", -1);
    int j = localIntent.getIntExtra("editorFrom", -1);
    if ((j == AECameraEntry.x.a()) || (j == AECameraEntry.z.a())) {
      if (i == 0) {
        AEBaseReportParam.a().a().b = AEBaseReportParam.b.longValue();
      }
    }
    for (;;)
    {
      AEBaseReportParam.a().a().a = AEBaseReportParam.a().b();
      return;
      if (i == 1)
      {
        AEBaseReportParam.a().a().b = AEBaseReportParam.c.longValue();
      }
      else
      {
        AEBaseReportParam.a().a().b = AEBaseReportParam.a.longValue();
        continue;
        if ((j == AECameraEntry.y.a()) || (j == AECameraEntry.A.a()))
        {
          if (i == 0) {
            AEBaseReportParam.a().a().b = AEBaseReportParam.d.longValue();
          } else if (i == 1) {
            AEBaseReportParam.a().a().b = AEBaseReportParam.e.longValue();
          } else {
            AEBaseReportParam.a().a().b = AEBaseReportParam.a.longValue();
          }
        }
        else {
          AEBaseReportParam.a().a().b = AEBaseReportParam.a.longValue();
        }
      }
    }
  }
  
  public AEEditorModuleManager a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    AEQLog.b("AEEditorActivity", "doOnActivityResult---requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    if (this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager != null) {
      this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager != null) {
      this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager.a(this, true);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    AEThemeUtil.a();
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    setImmersiveStatus(getResources().getColor(2131165215));
    super.doOnCreate(paramBundle);
    a(Lifecycle.Event.ON_CREATE);
    setContentView(2131558561);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramBundle = (FrameLayout)findViewById(2131377356);
      int i = getStatusBarHeight();
      paramBundle.setPadding(paramBundle.getPaddingLeft(), i + paramBundle.getPaddingTop(), paramBundle.getPaddingRight(), paramBundle.getPaddingBottom());
    }
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
    a();
    c();
    AEEditorEffectIpcModule.a();
    e();
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    AEEditorEffectIpcModule.b();
    a(Lifecycle.Event.ON_DESTROY);
    VideoThumbProviderManager.getInstance().release(String.valueOf(hashCode()));
    if ((this.jdField_a_of_type_AndroidArchLifecycleViewModelStore != null) && (!isChangingConfigurations())) {
      this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    a(Lifecycle.Event.ON_PAUSE);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a(Lifecycle.Event.ON_RESUME);
    VideoThumbProviderManager.getInstance().resume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    a(Lifecycle.Event.ON_START);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    a(Lifecycle.Event.ON_STOP);
    VideoThumbProviderManager.getInstance().pause();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    AEQLog.b("AEEditorActivity", "doOnWindowFocusChanged isFocused:" + paramBoolean);
    if (this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager != null) {
      this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager.a(paramBoolean);
    }
  }
  
  public Lifecycle getLifecycle()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore == null) {
      this.jdField_a_of_type_AndroidArchLifecycleViewModelStore = new ViewModelStore();
    }
    return this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorActivity
 * JD-Core Version:    0.7.0.1
 */