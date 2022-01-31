package dov.com.qq.im.aeeditor;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RelativeLayout;
import bkkj;
import bkwm;
import bler;
import blfo;
import blfp;
import blfq;
import blfr;
import bljh;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
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

public class AEEditorActivity
  extends PeakFragmentActivity
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorActivity.class.getSimpleName();
  private blfr jdField_a_of_type_Blfr;
  private List<blfp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  
  private void a()
  {
    if (!bkkj.a()) {
      this.jdField_a_of_type_JavaUtilList.add(new blfp(this, -1));
    }
    for (;;)
    {
      TAVCut.initTAVCut(getApplicationContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new blfo(this));
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
      this.jdField_a_of_type_JavaUtilList.add(new blfp(this, paramInt));
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
  }
  
  private void c()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getExtras() != null) {
      localBundle = getIntent().getExtras();
    }
    this.jdField_a_of_type_Blfr = new blfr(getSupportFragmentManager());
    this.jdField_a_of_type_Blfr.a(localBundle);
  }
  
  private void d()
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("editorType", -1);
    int j = localIntent.getIntExtra("editorFrom", -1);
    if (j == bkwm.x.a()) {
      if (i == 0) {
        bler.a().a().b = bler.b.longValue();
      }
    }
    for (;;)
    {
      bler.a().a().jdField_a_of_type_JavaLangString = bler.a().a();
      return;
      if (i == 1)
      {
        bler.a().a().b = bler.c.longValue();
      }
      else
      {
        bler.a().a().b = bler.a.longValue();
        continue;
        if (j == bkwm.y.a())
        {
          if (i == 0) {
            bler.a().a().b = bler.d.longValue();
          } else if (i == 1) {
            bler.a().a().b = bler.e.longValue();
          } else {
            bler.a().a().b = bler.a.longValue();
          }
        }
        else {
          bler.a().a().b = bler.a.longValue();
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Blfr != null) {
      this.jdField_a_of_type_Blfr.a(this, true);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    if (blfq.a(getIntent())) {
      setImmersiveStatus(getResources().getColor(2131165219));
    }
    for (;;)
    {
      super.doOnCreate(paramBundle);
      setContentView(2131558522);
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramBundle = (RelativeLayout)findViewById(2131375981);
        int i = getStatusBarHeight();
        paramBundle.setPadding(paramBundle.getPaddingLeft(), i + paramBundle.getPaddingTop(), paramBundle.getPaddingRight(), paramBundle.getPaddingBottom());
      }
      if (ImmersiveUtils.c()) {
        ImmersiveUtils.a(false, getWindow());
      }
      a();
      b();
      bljh.a().a();
      c();
      d();
      return true;
      setImmersiveStatus(getResources().getColor(2131165232));
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorActivity
 * JD-Core Version:    0.7.0.1
 */