package dov.com.tencent.biz.qqstory.takevideo;

import Override;
import amtj;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import blie;
import bljd;
import bmbc;
import bmbg;
import bmbx;
import bmql;
import bmxe;
import bmxf;
import bnar;
import bndn;
import bnee;
import bnew;
import bngn;
import bngq;
import bnot;
import bnub;
import bnue;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sveffects.SvEffectSdkInitor;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import vkm;
import vux;
import vvd;
import xvv;
import xwa;
import xwb;
import ypi;
import zjv;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements bnew, bnue
{
  public long a;
  private RelativeLayout a;
  public bnee a;
  
  public EditVideoActivity()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  private void e()
  {
    if (LiuHaiUtils.f())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370078));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  private void f()
  {
    View localView1 = findViewById(2131364078);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131373901);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void g()
  {
    long l = getIntent().getLongExtra("stop_record_time", -1L);
    int i = this.jdField_a_of_type_Bnee.f();
    int j = this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
    if ((bmxe.c) && (l != -1L))
    {
      bmxe.f.b();
      bmxe.f.jdField_a_of_type_Int = this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
      bmxe.f.a(0, l);
      bmxe.f.a(1, this.jdField_a_of_type_Long);
    }
    int k = this.jdField_a_of_type_Bnee.h();
    getIntent().putExtra("capture_operation_in", k);
    xwa.b("edit_exp", k, 0, new String[] { xwa.b(i), "", "", String.valueOf(j) });
  }
  
  private void h()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    xvv.a("EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 10240L)
    {
      xvv.d("EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((vvd)vux.a(26)).a(2);
      return;
    }
    ((vvd)vux.a(26)).a(0);
  }
  
  private void i()
  {
    SvEffectSdkInitor.isDovCapture = true;
    ThreadManager.excute(new EditVideoActivity.6(this), 16, null, true);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  public Intent a(bnot parambnot)
  {
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidContentIntent == null) {}
    JSONArray localJSONArray;
    for (Intent localIntent = new Intent();; localIntent = this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidContentIntent)
    {
      localIntent.putExtra("widgetinfo", getIntent().getStringExtra("widgetinfo"));
      Object localObject = getIntent().getStringExtra("key_camera_material_name");
      localIntent.putExtra("key_camera_material_name", (String)localObject);
      bmbx.b("EditVideoActivity", "AIO send video---takeSameName=" + (String)localObject);
      localJSONArray = null;
      localObject = localJSONArray;
      if (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn != null)
      {
        localObject = localJSONArray;
        if (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn.a() != null)
        {
          localObject = localJSONArray;
          if (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn.a().a() != null) {
            localObject = this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn.a().a().a;
          }
        }
      }
      localJSONArray = new JSONArray();
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bngq localbngq = (bngq)((Iterator)localObject).next();
        if ((localbngq.a != null) && (localbngq.a.a() != null)) {
          localJSONArray.put(localbngq.a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditVideoActivity getPublishIntent, content is: " + localJSONArray.toString());
    }
    localIntent.putExtra("dynamic_text", localJSONArray.toString());
    localIntent.putExtra(PublishParam.a, parambnot.a);
    return localIntent;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Bnee == null) {
      this.jdField_a_of_type_Bnee = new bnee();
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoActivity", 2, new Object[] { "finish, publishStoryFlag ", Boolean.valueOf(paramBoolean) });
    }
    bljy.e = paramBoolean;
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)
    {
      bnub.a().a(null, this, this.jdField_a_of_type_Bnee.c());
      bnub.a().a(null);
    }
    Intent localIntent = paramIntent;
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
    {
      paramBoolean = this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
      String str = this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      localIntent = paramIntent;
      if (paramBoolean)
      {
        localIntent = paramIntent;
        if (!TextUtils.isEmpty(str))
        {
          localIntent = paramIntent;
          if (paramIntent == null) {
            localIntent = new Intent();
          }
          localIntent.putExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", str);
        }
      }
    }
    paramIntent = localIntent;
    if (this.jdField_a_of_type_Bnee.e())
    {
      paramIntent = localIntent;
      if (localIntent == null) {
        paramIntent = new Intent();
      }
      paramIntent.putExtra("key_edit_to_photo_list", true);
    }
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_Bnee.x();
    h();
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void c()
  {
    super.c();
    xvv.d("EditVideoActivity", "onOutOfMemory");
    h();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
      bnar.a();
    }
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
    this.jdField_a_of_type_Bnee.a(paramInt1, paramInt2, paramIntent);
    xvv.c("EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
  }
  
  public void doOnBackPressed()
  {
    xvv.c("EditVideoActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Bnee.d()) {
      super.doOnBackPressed();
    }
    f();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    LiuHaiUtils.a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    SvEffectSdkInitor.init();
    bljd.a();
    xvv.b("EditVideoActivity", "EditVideoActivity doOnCreate start");
    a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    i();
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    ThreadManager.getFileThreadHandler().post(new EditVideoActivity.1(this));
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.2(this));
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    xvv.d("EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (String str1 = localEditVideoParams.a(); !TextUtils.isEmpty(str1); str1 = "can not find EditVideoParams")
    {
      QQToast.a(this, amtj.a(2131703051) + str1, 0).a();
      finish();
      return true;
    }
    str1 = getIntent().getStringExtra("op_department");
    String str2 = getIntent().getStringExtra("op_type");
    xvv.d("EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), str1, str2 });
    LiuHaiUtils.a();
    LiuHaiUtils.c(this);
    LiuHaiUtils.d(this);
    if (LiuHaiUtils.f()) {
      LiuHaiUtils.enableNotch(this);
    }
    this.jdField_a_of_type_Bnee.d = true;
    setContentViewC(2131559118);
    a(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, amtj.a(2131702836), 0).a();
      finish();
      return true;
    }
    e();
    int i = getIntent().getIntExtra("edit_video_way", 0);
    this.jdField_a_of_type_Bnee.b(i);
    this.jdField_a_of_type_Bnee.a(this, localEditVideoParams);
    paramBundle = (blie)bmql.a(13);
    paramBundle.a(8);
    paramBundle.b(this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
    this.jdField_a_of_type_Bnee.h();
    ypi.a(vkm.e);
    xwb.a = str1;
    xwb.b = str2;
    xwb.a("0X80076B5");
    xwa.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
    LpReportInfo_pf00064.allReport(628, 1);
    xvv.b("EditVideoActivity", "EditVideoActivity doOnCreate end");
    sendBroadcast(new Intent("action_fire_get_config"));
    h();
    ((blie)bmql.a(13)).d(1);
    d();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.3(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    xvv.d("EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.jdField_a_of_type_Bnee.m();
    xwb.a = "";
    xwb.b = "";
    bmxe.d.c();
    ((blie)bmql.a(13)).d(1);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    xvv.c("EditVideoActivity", "doOnPause");
    this.jdField_a_of_type_Bnee.k();
    ThreadManagerV2.excute(new EditVideoActivity.5(this), 16, null, false);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    xvv.c("EditVideoActivity", "doOnRestoreInstanceState");
    this.jdField_a_of_type_Bnee.a(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    xvv.c("EditVideoActivity", "doOnResume");
    this.jdField_a_of_type_Bnee.j();
    ThreadManagerV2.excute(new EditVideoActivity.4(this), 16, null, false);
    ((blie)bmql.a(13)).c(1);
    if (Build.VERSION.SDK_INT >= 29) {
      zjv.a(getWindow());
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    xvv.c("EditVideoActivity", "doOnSaveInstanceState");
    this.jdField_a_of_type_Bnee.b(paramBundle);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    xvv.c("EditVideoActivity", "doOnStart");
    this.jdField_a_of_type_Bnee.i();
    bmbc.a().a();
    bmbg.a().c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    xvv.c("EditVideoActivity", "doOnStop");
    this.jdField_a_of_type_Bnee.l();
    bmbc.a().b();
    bmbx.b("EditVideoActivity", "【doOnStop】");
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_Bnee.c(paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bncy != null) {
      ThreadManager.getUIHandler().post(new EditVideoActivity.7(this));
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    xvv.d("EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    h();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */