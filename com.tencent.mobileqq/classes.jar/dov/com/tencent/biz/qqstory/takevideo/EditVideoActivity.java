package dov.com.tencent.biz.qqstory.takevideo;

import ajyc;
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
import bbdr;
import bcpw;
import bflj;
import bigh;
import biht;
import bizc;
import bizg;
import bizq;
import bjae;
import bjil;
import bjim;
import bjmj;
import bjvc;
import bjww;
import bjye;
import bkaj;
import bkam;
import bkkm;
import bkks;
import bkqo;
import bkqr;
import bkur;
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
import ssi;
import tdc;
import tdi;
import veg;
import vel;
import vem;
import vyi;
import wsu;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements bjye, bkqr
{
  public long a;
  private RelativeLayout a;
  public bjww a;
  protected boolean a;
  
  public EditVideoActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
  }
  
  private void a()
  {
    if (bkur.f())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369333));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.height = bkur.a();
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
    View localView1 = findViewById(2131363765);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131372827);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void g()
  {
    long l1 = getIntent().getLongExtra("stop_record_time", -1L);
    int j = this.jdField_a_of_type_Bjww.g();
    int k = this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      if (l1 <= 0L) {
        break label222;
      }
    }
    label222:
    for (int i = (int)(this.jdField_a_of_type_Long - l1);; i = 0)
    {
      long l2 = this.jdField_a_of_type_Bjww.b();
      vel.b("time_openedit", 1, i, new String[] { vel.b(j), String.valueOf(l2), "", String.valueOf(k) });
      if ((bjil.c) && (l1 != -1L))
      {
        bjil.f.b();
        bjil.f.jdField_a_of_type_Int = this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
        bjil.f.a(0, l1);
        bjil.f.a(1, this.jdField_a_of_type_Long);
      }
      i = this.jdField_a_of_type_Bjww.i();
      getIntent().putExtra("capture_operation_in", i);
      vel.b("edit_exp", i, 0, new String[] { vel.b(j), "", "", String.valueOf(k) });
      return;
    }
  }
  
  private void h()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    veg.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 10240L)
    {
      veg.d("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((tdi)tdc.a(26)).a(2);
      return;
    }
    ((tdi)tdc.a(26)).a(0);
  }
  
  private void i()
  {
    bflj.jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new EditVideoActivity.6(this), 16, null, true);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  public Intent a(bkkm parambkkm)
  {
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if ((this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
    {
      localObject3 = getIntent();
      localObject1 = ((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject3).setClassName(((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      localObject4 = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      if ((parambkkm.jdField_a_of_type_Bkks.c) || (!parambkkm.jdField_a_of_type_Bkks.jdField_b_of_type_Boolean)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
          ((Intent)localObject3).putExtra("need_combine_gif", parambkkm.jdField_a_of_type_Bkks.d);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + parambkkm.jdField_a_of_type_Bkks.d);
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
        ((Intent)localObject3).putExtra("doodle_bitmap_path", parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", parambkkm.jdField_a_of_type_Bkks.jdField_b_of_type_Int);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        if ((this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          ((Intent)localObject3).putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        ((ArrayList)localObject4).add(localObject2);
        bbdr.a(this, (String)localObject2);
        ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject4);
        ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject4).get(0));
        ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject3).addFlags(603979776);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_FLAG", true);
        return localObject3;
        if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
          if ((localEditLocalGifSource.b != null) && (localEditLocalGifSource.b.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.b.get(0);
          }
        }
        for (;;)
        {
          if (!parambkkm.jdField_a_of_type_Bkks.d) {
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
        localObject2 = parambkkm.jdField_a_of_type_Bkks.jdField_b_of_type_JavaLangString;
        ((Intent)localObject3).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        ((Intent)localObject3).putExtra("need_combine_gif", true);
      }
      label516:
      if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.b);
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("combine_image_path", (String)localObject2);
        ((Intent)localObject3).putExtra("doodle_bitmap_path", parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", parambkkm.jdField_a_of_type_Bkks.jdField_b_of_type_Int);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        break;
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_AndroidContentIntent == null) {}
    for (Object localObject1 = new Intent();; localObject1 = this.jdField_a_of_type_Bjww.jdField_a_of_type_AndroidContentIntent)
    {
      ((Intent)localObject1).putExtra("widgetinfo", getIntent().getStringExtra("widgetinfo"));
      localObject3 = null;
      localObject2 = localObject3;
      if (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjvc != null)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjvc.a() != null)
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjvc.a().a() != null) {
            localObject2 = this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjvc.a().a().jdField_a_of_type_JavaUtilArrayList;
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
        localObject4 = (bkam)((Iterator)localObject2).next();
        if ((((bkam)localObject4).a != null) && (((bkam)localObject4).a.a() != null)) {
          ((JSONArray)localObject3).put(((bkam)localObject4).a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditVideoActivity getPublishIntent, content is: " + ((JSONArray)localObject3).toString());
    }
    ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject3).toString());
    ((Intent)localObject1).putExtra(PublishParam.jdField_a_of_type_JavaLangString, parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
    return localObject1;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public bjww a()
  {
    return this.jdField_a_of_type_Bjww;
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
    biim.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)
    {
      bkqo.a().a(null, this, this.jdField_a_of_type_Bjww.c());
      bkqo.a().a(null);
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
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
    {
      paramBoolean = this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
      String str = this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
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
    if (this.jdField_a_of_type_Bjww.e())
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
    this.jdField_a_of_type_Bjww.A();
    h();
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void c()
  {
    super.c();
    veg.d("Q.qqstory.publish.edit.EditVideoActivity", "onOutOfMemory");
    h();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bjww == null) {
      this.jdField_a_of_type_Bjww = new bjww();
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
        this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Bjww.a();
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Bjww.a(paramInt1, paramInt2, paramIntent);
      veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
      return;
      label185:
      a(paramInt2, paramIntent, 2130772028, 0);
    }
  }
  
  public void doOnBackPressed()
  {
    veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Bjww.d()) {
      super.doOnBackPressed();
    }
    f();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    bkur.a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    bflj.a();
    biht.a();
    veg.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
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
    veg.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (Object localObject = localEditVideoParams.a(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      bcpw.a(this, ajyc.a(2131703921) + (String)localObject, 0).a();
      finish();
      return true;
    }
    localObject = getIntent().getStringExtra("op_department");
    String str = getIntent().getStringExtra("op_type");
    veg.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str });
    bkur.a();
    bkur.c(this);
    bkur.d(this);
    if (bkur.f()) {
      bkur.c(this);
    }
    this.jdField_a_of_type_Bjww.e = true;
    setContentViewC(2131559005);
    a(paramBundle);
    if (isInMultiWindow())
    {
      bcpw.a(this, ajyc.a(2131703702), 0).a();
      finish();
      return true;
    }
    a();
    int i = getIntent().getIntExtra("edit_video_way", 0);
    this.jdField_a_of_type_Bjww.b(i);
    this.jdField_a_of_type_Bjww.a(this, localEditVideoParams);
    paramBundle = (bigh)bjae.a(13);
    paramBundle.a(8);
    paramBundle.b(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
    this.jdField_a_of_type_Bjww.j();
    vyi.a(ssi.e);
    vem.jdField_a_of_type_JavaLangString = (String)localObject;
    vem.jdField_b_of_type_JavaLangString = str;
    vem.a("0X80076B5");
    vel.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
    LpReportInfo_pf00064.allReport(628, 1);
    veg.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
    sendBroadcast(new Intent("action_fire_get_config"));
    h();
    ((bigh)bjae.a(13)).d(1);
    e();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.3(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    veg.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.jdField_a_of_type_Bjww.o();
    vem.jdField_a_of_type_JavaLangString = "";
    vem.jdField_b_of_type_JavaLangString = "";
    bjil.d.c();
    ((bigh)bjae.a(13)).d(1);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.jdField_a_of_type_Bjww.m();
    ThreadManagerV2.excute(new EditVideoActivity.5(this), 16, null, false);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnRestoreInstanceState");
    this.jdField_a_of_type_Bjww.a(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnResume");
    this.jdField_a_of_type_Bjww.l();
    ThreadManagerV2.excute(new EditVideoActivity.4(this), 16, null, false);
    ((bigh)bjae.a(13)).c(1);
    if (Build.VERSION.SDK_INT >= 29) {
      wsu.a(getWindow());
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnSaveInstanceState");
    this.jdField_a_of_type_Bjww.b(paramBundle);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStart");
    this.jdField_a_of_type_Bjww.k();
    bizc.a().a();
    bizg.a().c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    veg.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.jdField_a_of_type_Bjww.n();
    bizc.a().b();
    bizq.b("Q.qqstory.publish.edit.EditVideoActivity", "【doOnStop】");
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_Bjww.c(paramBoolean);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
      bjmj.a();
    }
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjtg != null) {
      ThreadManager.getUIHandler().post(new EditVideoActivity.7(this));
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    veg.d("Q.qqstory.publish.edit.EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
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