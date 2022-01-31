package dov.com.tencent.biz.qqstory.takevideo;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bacm;
import bbmy;
import bedt;
import bgxr;
import bhci;
import bhcm;
import bhcs;
import bhdr;
import bhfm;
import bhnt;
import bhnu;
import bhrr;
import bief;
import bigb;
import bihj;
import bijo;
import bijr;
import bitz;
import biuf;
import bjac;
import bjaf;
import bjeh;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import sfm;
import sqg;
import sqm;
import urk;
import urp;
import urq;
import vlm;
import wed;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements bihj, bjaf
{
  public long a;
  private RelativeLayout a;
  public bigb a;
  protected boolean a;
  
  public EditVideoActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
  }
  
  private void a()
  {
    if (bjeh.f())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303663));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.height = bjeh.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  private boolean a()
  {
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent() != null) && (getIntent().getIntExtra("qqstory_slide_show_scene", -1) == 22)) {}
    for (int i = 1;; i = 0) {
      return (localEditVideoParams != null) && (localEditVideoParams.jdField_a_of_type_Int == 3) && (i == 0);
    }
  }
  
  private void f()
  {
    View localView1 = findViewById(2131298210);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131307115);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void g()
  {
    long l1 = getIntent().getLongExtra("stop_record_time", -1L);
    int j = this.jdField_a_of_type_Bigb.g();
    int k = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      if (l1 <= 0L) {
        break label222;
      }
    }
    label222:
    for (int i = (int)(this.jdField_a_of_type_Long - l1);; i = 0)
    {
      long l2 = this.jdField_a_of_type_Bigb.b();
      urp.b("time_openedit", 1, i, new String[] { urp.b(j), String.valueOf(l2), "", String.valueOf(k) });
      if ((bhnt.c) && (l1 != -1L))
      {
        bhnt.f.b();
        bhnt.f.jdField_a_of_type_Int = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
        bhnt.f.a(0, l1);
        bhnt.f.a(1, this.jdField_a_of_type_Long);
      }
      i = this.jdField_a_of_type_Bigb.i();
      getIntent().putExtra("capture_operation_in", i);
      urp.b("edit_exp", i, 0, new String[] { urp.b(j), "", "", String.valueOf(k) });
      return;
    }
  }
  
  private void h()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    urk.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 10240L)
    {
      urk.d("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((sqm)sqg.a(26)).a(2);
      return;
    }
    ((sqm)sqg.a(26)).a(0);
  }
  
  private void i()
  {
    bedt.jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new EditVideoActivity.6(this), 16, null, true);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  public Intent a(bitz parambitz)
  {
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
    {
      localObject3 = getIntent();
      localObject1 = ((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject3).setClassName(((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      localObject4 = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      if ((parambitz.jdField_a_of_type_Biuf.c) || (!parambitz.jdField_a_of_type_Biuf.jdField_b_of_type_Boolean)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
          ((Intent)localObject3).putExtra("need_combine_gif", parambitz.jdField_a_of_type_Biuf.d);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + parambitz.jdField_a_of_type_Biuf.d);
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString)) {
          break label516;
        }
        ((Intent)localObject3).putExtra("orign_path", localEditLocalGifSource.a());
        ((Intent)localObject3).putExtra("combine_image_path", (String)localObject2);
        ((Intent)localObject3).putExtra("doodle_bitmap_path", parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", parambitz.jdField_a_of_type_Biuf.jdField_b_of_type_Int);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          ((Intent)localObject3).putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        ((ArrayList)localObject4).add(localObject2);
        bacm.a(this, (String)localObject2);
        ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject4);
        ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject4).get(0));
        ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject3).addFlags(603979776);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_FLAG", true);
        return localObject3;
        if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
          if ((localEditLocalGifSource.b != null) && (localEditLocalGifSource.b.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.b.get(0);
          }
        }
        for (;;)
        {
          if (!parambitz.jdField_a_of_type_Biuf.d) {
            ((Intent)localObject3).putExtra("use_orign", true);
          }
          ((Intent)localObject3).putExtra("need_combine_gif", true);
          break;
          localObject1 = "";
          continue;
          if ((localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList != null) && (localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList.get(0);
          } else {
            localObject1 = "";
          }
        }
        localObject2 = parambitz.jdField_a_of_type_Biuf.jdField_b_of_type_JavaLangString;
        ((Intent)localObject3).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        ((Intent)localObject3).putExtra("need_combine_gif", true);
      }
      label516:
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.b);
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("combine_image_path", (String)localObject2);
        ((Intent)localObject3).putExtra("doodle_bitmap_path", parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", parambitz.jdField_a_of_type_Biuf.jdField_b_of_type_Int);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        break;
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidContentIntent == null) {}
    for (Object localObject1 = new Intent();; localObject1 = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidContentIntent)
    {
      ((Intent)localObject1).putExtra("widgetinfo", getIntent().getStringExtra("widgetinfo"));
      localObject3 = null;
      localObject2 = localObject3;
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief != null)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief.a() != null)
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief.a().a() != null) {
            localObject2 = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief.a().a().jdField_a_of_type_JavaUtilArrayList;
          }
        }
      }
      localObject3 = new JSONArray();
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (bijr)((Iterator)localObject2).next();
        if ((((bijr)localObject4).a != null) && (((bijr)localObject4).a.a() != null)) {
          ((JSONArray)localObject3).put(((bijr)localObject4).a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditVideoActivity getPublishIntent, content is: " + ((JSONArray)localObject3).toString());
    }
    ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject3).toString());
    ((Intent)localObject1).putExtra(PublishParam.jdField_a_of_type_JavaLangString, parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
    return localObject1;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public bigb a()
  {
    return this.jdField_a_of_type_Bigb;
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, new Object[] { "finish, publishStoryFlag ", Boolean.valueOf(paramBoolean) });
    }
    dov.com.qq.im.QIMEffectCameraCaptureUnit.w = paramBoolean;
    bhcw.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)
    {
      bjac.a().a(null, this, this.jdField_a_of_type_Bigb.c());
      bjac.a().a(null);
    }
    int i = getIntent().getIntExtra("take_video_entrance_type", 99);
    Intent localIntent = paramIntent;
    if (i == 15)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("take_video_entrance_type", i);
    }
    paramIntent = localIntent;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
    {
      paramBoolean = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
      String str = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      paramIntent = localIntent;
      if (paramBoolean)
      {
        paramIntent = localIntent;
        if (!TextUtils.isEmpty(str))
        {
          paramIntent = localIntent;
          if (localIntent == null) {
            paramIntent = new Intent();
          }
          paramIntent.putExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", str);
        }
      }
    }
    localIntent = paramIntent;
    if (this.jdField_a_of_type_Bigb.e())
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("key_edit_to_photo_list", true);
    }
    setResult(paramInt1, localIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_Bigb.A();
    h();
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bicj != null) {
      ThreadManager.getUIHandler().post(new EditVideoActivity.7(this));
    }
  }
  
  public void c()
  {
    super.c();
    urk.d("Q.qqstory.publish.edit.EditVideoActivity", "onOutOfMemory");
    h();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bigb == null) {
      this.jdField_a_of_type_Bigb = new bigb();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10004)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "quick shoot onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        SessionInfo localSessionInfo = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (localSessionInfo != null) {
          getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo);
        }
        getIntent().putExtra("forward_source_from_shoot_quick", true);
        if (paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0) != 1003) {
          break label185;
        }
        this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Bigb.a();
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Bigb.a(paramInt1, paramInt2, paramIntent);
      urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
      return;
      label185:
      a(paramInt2, paramIntent, 2130772028, 0);
    }
  }
  
  public void doOnBackPressed()
  {
    urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Bigb.d()) {
      super.doOnBackPressed();
    }
    f();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    bjeh.a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    bedt.a();
    bgxr.a();
    urk.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
    d();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    if (!a()) {
      i();
    }
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    ThreadManager.getFileThreadHandler().post(new EditVideoActivity.1(this));
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.2(this));
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent().getBooleanExtra("extra_has_antishake", false)) && (localEditVideoParams != null) && ((localEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)))
    {
      localObject = (EditLocalGifSource)localEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      ((EditLocalGifSource)localObject).b = getIntent().getStringArrayListExtra("extra_antishake_gif_path_list");
      if ((((EditLocalGifSource)localObject).b != null) && (((EditLocalGifSource)localObject).b.size() > 1)) {
        ((EditLocalGifSource)localObject).jdField_a_of_type_Boolean = true;
      }
    }
    urk.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (Object localObject = localEditVideoParams.a(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      bbmy.a(this, ajjy.a(2131638136) + (String)localObject, 0).a();
      finish();
      return true;
    }
    localObject = getIntent().getStringExtra("op_department");
    String str = getIntent().getStringExtra("op_type");
    urk.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str });
    bjeh.a();
    bjeh.c(this);
    bjeh.d(this);
    if (bjeh.f()) {
      bjeh.c(this);
    }
    this.jdField_a_of_type_Bigb.e = true;
    setContentViewC(2131493442);
    a(paramBundle);
    if (isInMultiWindow())
    {
      bbmy.a(this, ajjy.a(2131637917), 0).a();
      finish();
      return true;
    }
    a();
    int i = getIntent().getIntExtra("edit_video_way", 0);
    this.jdField_a_of_type_Bigb.b(i);
    this.jdField_a_of_type_Bigb.a(this, localEditVideoParams);
    paramBundle = (bhdr)bhfm.a(13);
    paramBundle.a(8);
    paramBundle.b(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
    this.jdField_a_of_type_Bigb.j();
    vlm.a(sfm.e);
    urq.jdField_a_of_type_JavaLangString = (String)localObject;
    urq.jdField_b_of_type_JavaLangString = str;
    urq.a("0X80076B5");
    urp.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
    LpReportInfo_pf00064.allReport(628, 1);
    urk.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
    sendBroadcast(new Intent("action_fire_get_config"));
    h();
    ((bhdr)bhfm.a(13)).d(1);
    e();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.3(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    urk.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.jdField_a_of_type_Bigb.o();
    urq.jdField_a_of_type_JavaLangString = "";
    urq.jdField_b_of_type_JavaLangString = "";
    bhnt.d.c();
    ((bhdr)bhfm.a(13)).d(1);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.jdField_a_of_type_Bigb.m();
    ThreadManagerV2.excute(new EditVideoActivity.5(this), 16, null, false);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnRestoreInstanceState");
    this.jdField_a_of_type_Bigb.a(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnResume");
    this.jdField_a_of_type_Bigb.l();
    ThreadManagerV2.excute(new EditVideoActivity.4(this), 16, null, false);
    ((bhdr)bhfm.a(13)).c(1);
    if (Build.VERSION.SDK_INT >= 29) {
      wed.a(getWindow());
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnSaveInstanceState");
    this.jdField_a_of_type_Bigb.b(paramBundle);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStart");
    this.jdField_a_of_type_Bigb.k();
    bhci.a().a();
    bhcm.a().c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    urk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.jdField_a_of_type_Bigb.n();
    bhci.a().b();
    bhcs.a("Q.qqstory.publish.edit.EditVideoActivity", 1, "【doOnStop】");
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_Bigb.c(paramBoolean);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
      bhrr.a();
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    urk.d("Q.qqstory.publish.edit.EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    h();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */