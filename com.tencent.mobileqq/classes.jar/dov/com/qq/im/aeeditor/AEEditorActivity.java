package dov.com.qq.im.aeeditor;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import boem;
import born;
import bozv;
import bpan;
import bpbg;
import bpbh;
import bpbk;
import bpdp;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.TAVCut;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import vuc;

public class AEEditorActivity
  extends PeakFragmentActivity
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorActivity.class.getSimpleName();
  private bpbk jdField_a_of_type_Bpbk;
  private List<bpbh> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  
  private void a()
  {
    if (!boem.a()) {
      this.jdField_a_of_type_JavaUtilList.add(new bpbh(this, -1));
    }
    for (;;)
    {
      TAVCut.initTAVCut(getApplicationContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bpbg(this));
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
      this.jdField_a_of_type_JavaUtilList.add(new bpbh(this, paramInt));
    }
  }
  
  private void b()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this, "small_world_base");
    VideoReport.setPageParams(this, new vuc().a(jdField_a_of_type_JavaLangString).a());
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getExtras() != null) {
      localBundle = getIntent().getExtras();
    }
    this.jdField_a_of_type_Bpbk = new bpbk(getSupportFragmentManager());
    this.jdField_a_of_type_Bpbk.a(localBundle);
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("editorType", -1);
    int j = localIntent.getIntExtra("editorFrom", -1);
    if ((j == born.x.a()) || (j == born.z.a())) {
      if (i == 0) {
        bozv.a().a().b = bozv.b.longValue();
      }
    }
    for (;;)
    {
      bozv.a().a().jdField_a_of_type_JavaLangString = bozv.a().b();
      return;
      if (i == 1)
      {
        bozv.a().a().b = bozv.c.longValue();
      }
      else
      {
        bozv.a().a().b = bozv.a.longValue();
        continue;
        if ((j == born.y.a()) || (j == born.A.a()))
        {
          if (i == 0) {
            bozv.a().a().b = bozv.d.longValue();
          } else if (i == 1) {
            bozv.a().a().b = bozv.e.longValue();
          } else {
            bozv.a().a().b = bozv.a.longValue();
          }
        }
        else {
          bozv.a().a().b = bozv.a.longValue();
        }
      }
    }
  }
  
  public bpbk a()
  {
    return this.jdField_a_of_type_Bpbk;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Bpbk != null) {
      this.jdField_a_of_type_Bpbk.a(this, true);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    bpan.a();
    this.jdField_a_of_type_Boolean = bpan.a();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    setImmersiveStatus(getResources().getColor(2131165215));
    super.doOnCreate(paramBundle);
    setContentView(2131558539);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramBundle = (RelativeLayout)findViewById(2131376925);
      int i = getStatusBarHeight();
      paramBundle.setPadding(paramBundle.getPaddingLeft(), i + paramBundle.getPaddingTop(), paramBundle.getPaddingRight(), paramBundle.getPaddingBottom());
    }
    if (ImmersiveUtils.c()) {
      ImmersiveUtils.a(true, getWindow());
    }
    a();
    c();
    bpdp.a();
    d();
    e();
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bpdp.b();
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