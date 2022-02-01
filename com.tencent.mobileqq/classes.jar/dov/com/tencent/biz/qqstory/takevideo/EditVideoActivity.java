package dov.com.tencent.biz.qqstory.takevideo;

import Override;
import aana;
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
import anzj;
import bhmq;
import blfp;
import bocw;
import boem;
import bozr;
import bozv;
import bpam;
import bplq;
import bpty;
import bptz;
import bpxu;
import bqeq;
import bqgk;
import bqhs;
import bqjx;
import bqka;
import bqua;
import bqug;
import bqzz;
import brac;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import win;
import wth;
import wtn;
import yuk;
import yup;
import yuq;
import zom;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements bqhs, brac
{
  public long a;
  private RelativeLayout a;
  public bqgk a;
  protected boolean a;
  
  public EditVideoActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
  }
  
  private boolean a()
  {
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent() != null) && (getIntent().getIntExtra("qqstory_slide_show_scene", -1) == 22)) {}
    for (int i = 1;; i = 0) {
      return (localEditVideoParams != null) && (localEditVideoParams.jdField_a_of_type_Int == 3) && (i == 0);
    }
  }
  
  private void e()
  {
    if (LiuHaiUtils.f())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370081));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  private void f()
  {
    View localView1 = findViewById(2131364054);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131374158);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void g()
  {
    long l1 = getIntent().getLongExtra("stop_record_time", -1L);
    int j = this.jdField_a_of_type_Bqgk.g();
    int k = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      if (l1 <= 0L) {
        break label222;
      }
    }
    label222:
    for (int i = (int)(this.jdField_a_of_type_Long - l1);; i = 0)
    {
      long l2 = this.jdField_a_of_type_Bqgk.b();
      yup.b("time_openedit", 1, i, new String[] { yup.b(j), String.valueOf(l2), "", String.valueOf(k) });
      if ((bpty.c) && (l1 != -1L))
      {
        bpty.f.b();
        bpty.f.jdField_a_of_type_Int = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
        bpty.f.a(0, l1);
        bpty.f.a(1, this.jdField_a_of_type_Long);
      }
      i = this.jdField_a_of_type_Bqgk.i();
      getIntent().putExtra("capture_operation_in", i);
      yup.b("edit_exp", i, 0, new String[] { yup.b(j), "", "", String.valueOf(k) });
      return;
    }
  }
  
  private void h()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    yuk.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 10240L)
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((wtn)wth.a(26)).a(2);
      return;
    }
    ((wtn)wth.a(26)).a(0);
  }
  
  private void i()
  {
    blfp.jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new EditVideoActivity.6(this), 16, null, true);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  public Intent a(bqua parambqua)
  {
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
    {
      localObject3 = getIntent();
      localObject1 = ((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject3).setClassName(((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      localObject4 = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      if ((parambqua.jdField_a_of_type_Bqug.c) || (!parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Boolean)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
          ((Intent)localObject3).putExtra("need_combine_gif", parambqua.jdField_a_of_type_Bqug.d);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + parambqua.jdField_a_of_type_Bqug.d);
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
        ((Intent)localObject3).putExtra("doodle_bitmap_path", parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Int);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          ((Intent)localObject3).putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        ((ArrayList)localObject4).add(localObject2);
        bhmq.a(this, (String)localObject2);
        ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject4);
        ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject4).get(0));
        ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject3).addFlags(603979776);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_FLAG", true);
        return localObject3;
        if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
          if ((localEditLocalGifSource.b != null) && (localEditLocalGifSource.b.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.b.get(0);
          }
        }
        for (;;)
        {
          if (!parambqua.jdField_a_of_type_Bqug.d) {
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
        localObject2 = parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_JavaLangString;
        ((Intent)localObject3).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        ((Intent)localObject3).putExtra("need_combine_gif", true);
      }
      label516:
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.b);
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("combine_image_path", (String)localObject2);
        ((Intent)localObject3).putExtra("doodle_bitmap_path", parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Int);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        break;
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidContentIntent == null) {}
    for (Object localObject1 = new Intent();; localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidContentIntent)
    {
      ((Intent)localObject1).putExtra("widgetinfo", getIntent().getStringExtra("widgetinfo"));
      localObject2 = getIntent().getStringExtra("key_camera_material_name");
      ((Intent)localObject1).putExtra("key_camera_material_name", (String)localObject2);
      bpam.b("EditVideoActivity", "AIO send video---takeSameName=" + (String)localObject2);
      localObject3 = null;
      localObject2 = localObject3;
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq != null)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq.a() != null)
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq.a().a() != null) {
            localObject2 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq.a().a().jdField_a_of_type_JavaUtilArrayList;
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
        localObject4 = (bqka)((Iterator)localObject2).next();
        if ((((bqka)localObject4).a != null) && (((bqka)localObject4).a.a() != null)) {
          ((JSONArray)localObject3).put(((bqka)localObject4).a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditVideoActivity getPublishIntent, content is: " + ((JSONArray)localObject3).toString());
    }
    ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject3).toString());
    ((Intent)localObject1).putExtra(PublishParam.jdField_a_of_type_JavaLangString, parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
    return localObject1;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public bqgk a()
  {
    return this.jdField_a_of_type_Bqgk;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Bqgk == null) {
      this.jdField_a_of_type_Bqgk = new bqgk();
    }
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
    bofh.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)
    {
      bqzz.a().a(null, this, this.jdField_a_of_type_Bqgk.c());
      bqzz.a().a(null);
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
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
    {
      paramBoolean = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
      String str = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
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
    if (this.jdField_a_of_type_Bqgk.e())
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
    this.jdField_a_of_type_Bqgk.A();
    h();
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void c()
  {
    super.c();
    yuk.d("Q.qqstory.publish.edit.EditVideoActivity", "onOutOfMemory");
    h();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
      bpxu.a();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
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
        this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Bqgk.a();
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Bqgk.a(paramInt1, paramInt2, paramIntent);
      yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
      return;
      label185:
      a(paramInt2, paramIntent, 2130772029, 0);
    }
  }
  
  public void doOnBackPressed()
  {
    yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Bqgk.d()) {
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
    blfp.a();
    boem.a();
    yuk.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
    a();
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
    yuk.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (Object localObject = localEditVideoParams.a(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      QQToast.a(this, anzj.a(2131702820) + (String)localObject, 0).a();
      finish();
      return true;
    }
    localObject = getIntent().getStringExtra("op_department");
    String str = getIntent().getStringExtra("op_type");
    yuk.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str });
    LiuHaiUtils.a();
    LiuHaiUtils.c(this);
    LiuHaiUtils.d(this);
    if (LiuHaiUtils.f()) {
      LiuHaiUtils.enableNotch(this);
    }
    this.jdField_a_of_type_Bqgk.e = true;
    setContentViewC(2131559110);
    a(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, anzj.a(2131702601), 0).a();
      finish();
      return true;
    }
    e();
    int i = getIntent().getIntExtra("edit_video_way", 0);
    this.jdField_a_of_type_Bqgk.b(i);
    this.jdField_a_of_type_Bqgk.a(this, localEditVideoParams);
    paramBundle = (bocw)bplq.a(13);
    paramBundle.a(8);
    paramBundle.b(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
    this.jdField_a_of_type_Bqgk.j();
    zom.a(win.e);
    yuq.jdField_a_of_type_JavaLangString = (String)localObject;
    yuq.jdField_b_of_type_JavaLangString = str;
    yuq.a("0X80076B5");
    yup.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
    LpReportInfo_pf00064.allReport(628, 1);
    yuk.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
    sendBroadcast(new Intent("action_fire_get_config"));
    h();
    ((bocw)bplq.a(13)).d(1);
    d();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.3(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    yuk.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.jdField_a_of_type_Bqgk.o();
    yuq.jdField_a_of_type_JavaLangString = "";
    yuq.jdField_b_of_type_JavaLangString = "";
    bpty.d.c();
    ((bocw)bplq.a(13)).d(1);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.jdField_a_of_type_Bqgk.m();
    ThreadManagerV2.excute(new EditVideoActivity.5(this), 16, null, false);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnRestoreInstanceState");
    this.jdField_a_of_type_Bqgk.a(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnResume");
    this.jdField_a_of_type_Bqgk.l();
    ThreadManagerV2.excute(new EditVideoActivity.4(this), 16, null, false);
    ((bocw)bplq.a(13)).c(1);
    if (Build.VERSION.SDK_INT >= 29) {
      aana.a(getWindow());
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnSaveInstanceState");
    this.jdField_a_of_type_Bqgk.b(paramBundle);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStart");
    this.jdField_a_of_type_Bqgk.k();
    bozr.a().a();
    bozv.a().c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    yuk.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.jdField_a_of_type_Bqgk.n();
    bozr.a().b();
    bpam.b("Q.qqstory.publish.edit.EditVideoActivity", "【doOnStop】");
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_Bqgk.c(paramBoolean);
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqcu != null) {
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
    yuk.d("Q.qqstory.publish.edit.EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
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