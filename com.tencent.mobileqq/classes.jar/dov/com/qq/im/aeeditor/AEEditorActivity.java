package dov.com.qq.im.aeeditor;

import Override;
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
import android.widget.RelativeLayout;
import bmwb;
import bnlb;
import bnqq;
import bnrh;
import bnri;
import bnsi;
import bnsj;
import bnsm;
import bnur;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.TAVCut;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEEditorActivity
  extends PeakFragmentActivity
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  private bnsm jdField_a_of_type_Bnsm;
  private List<bnsj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  
  private void a()
  {
    if (!bmwb.a()) {
      this.jdField_a_of_type_JavaUtilList.add(new bnsj(this, -1));
    }
    for (;;)
    {
      TAVCut.initTAVCut(getApplicationContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bnsi(this));
      return;
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(AIManager.installDetector(PTFaceDetector.class), -2);
      a(FeatureManager.Features.PAG.init(), -6);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(new bnsj(this, paramInt));
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
        bnsj localbnsj = (bnsj)localIterator.next();
        ((StringBuilder)localObject).append(localbnsj.toString() + "\n");
      }
      localObject = ((StringBuilder)localObject).toString();
      bnrh.d("AEEditorActivity", "checkInitResult--" + (String)localObject);
      return;
    }
    VideoThumbProviderManager.initLruCacheSize(3072);
    Object localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837943);
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
    this.jdField_a_of_type_Bnsm = new bnsm(getSupportFragmentManager());
    this.jdField_a_of_type_Bnsm.a(localBundle);
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("editorType", -1);
    int j = localIntent.getIntExtra("editorFrom", -1);
    if ((j == bnlb.x.a()) || (j == bnlb.z.a())) {
      if (i == 0) {
        bnqq.a().a().b = bnqq.b.longValue();
      }
    }
    for (;;)
    {
      bnqq.a().a().a = bnqq.a().b();
      return;
      if (i == 1)
      {
        bnqq.a().a().b = bnqq.c.longValue();
      }
      else
      {
        bnqq.a().a().b = bnqq.a.longValue();
        continue;
        if ((j == bnlb.y.a()) || (j == bnlb.A.a()))
        {
          if (i == 0) {
            bnqq.a().a().b = bnqq.d.longValue();
          } else if (i == 1) {
            bnqq.a().a().b = bnqq.e.longValue();
          } else {
            bnqq.a().a().b = bnqq.a.longValue();
          }
        }
        else {
          bnqq.a().a().b = bnqq.a.longValue();
        }
      }
    }
  }
  
  public bnsm a()
  {
    return this.jdField_a_of_type_Bnsm;
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
    bnrh.b("AEEditorActivity", "doOnActivityResult---requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    if (this.jdField_a_of_type_Bnsm != null) {
      this.jdField_a_of_type_Bnsm.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Bnsm != null) {
      this.jdField_a_of_type_Bnsm.a(this, true);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    bnri.a();
    this.jdField_a_of_type_Boolean = bnri.a();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    setImmersiveStatus(getResources().getColor(2131165215));
    super.doOnCreate(paramBundle);
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      setContentView(2131558549);
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramBundle = (RelativeLayout)findViewById(2131376947);
        int i = getStatusBarHeight();
        paramBundle.setPadding(paramBundle.getPaddingLeft(), i + paramBundle.getPaddingTop(), paramBundle.getPaddingRight(), paramBundle.getPaddingBottom());
      }
      if (ImmersiveUtils.c()) {
        ImmersiveUtils.a(true, getWindow());
      }
      a();
      c();
      bnur.a();
      e();
      b();
      return true;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bnur.b();
    VideoThumbProviderManager.getInstance().release(String.valueOf(hashCode()));
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      if ((this.jdField_a_of_type_AndroidArchLifecycleViewModelStore != null) && (!isChangingConfigurations())) {
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      VideoThumbProviderManager.getInstance().resume();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      VideoThumbProviderManager.getInstance().pause();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AEEditorActivity", 1, "mLifecycleRegistry 初始化失败");
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorActivity
 * JD-Core Version:    0.7.0.1
 */