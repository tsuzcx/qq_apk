package dov.com.tencent.biz.qqstory.takevideo;

import Override;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anvx;
import aqrl;
import bcwl;
import bheg;
import bmuv;
import bmwb;
import bnky;
import bnqm;
import bnqq;
import bnrh;
import bogd;
import bosd;
import bose;
import bosf;
import bosh;
import botf;
import botw;
import bouo;
import bowf;
import bowi;
import bpel;
import bpeq;
import bpii;
import bpqp;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sveffects.SvEffectSdkInitor;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import ykq;
import ykv;
import ykw;
import zza;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements bouo
{
  public long a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public botw a;
  bpqp jdField_a_of_type_Bpqp = new bosd(this);
  
  public EditPicActivity()
  {
    this.jdField_a_of_type_Botw = new bosh();
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt, 99, 0, false, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt1, paramInt2, 0, false, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, 0, false, null, paramBundle);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, HashMap<String, Object> paramHashMap)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt1, paramInt2, 0, false, paramHashMap);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean6, HashMap<String, Object> paramHashMap, Bundle paramBundle)
  {
    Bundle localBundle = paramActivity.getIntent().getExtras();
    Intent localIntent = new Intent();
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    localIntent.setClass(paramActivity, ArtFilterBridgeActivity.class);
    if (!localIntent.hasExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME")) {
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    }
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    if ((paramActivity instanceof SplashActivity)) {
      localIntent.putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
    }
    localIntent.putExtra("open_chatfragment", true);
    long l2 = 0L;
    if (paramBoolean1) {
      l2 = 0L | 0x400;
    }
    long l1 = l2;
    if (paramBoolean2) {
      l1 = l2 | 1L;
    }
    l2 = l1;
    if (paramBoolean3) {
      l2 = l1 | 0x8;
    }
    l1 = l2;
    if (paramBoolean4) {
      l1 = l2 | 0x4;
    }
    l2 = l1;
    if (paramBoolean5)
    {
      l2 = l1;
      if (Build.VERSION.SDK_INT >= 21) {
        l2 = l1 | 0x40;
      }
    }
    if (paramInt1 != 2)
    {
      l1 = l2;
      if (paramInt1 != 6) {}
    }
    else
    {
      l1 = l2 | 0x800 | 0x200 | 0x20000 | 0x2000;
    }
    if ((paramInt1 != 8) && (paramInt1 != 4))
    {
      l2 = l1;
      if (paramInt1 != 3) {}
    }
    else
    {
      l2 = l1 | 0x200;
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_multi_edit_pic", false))) {
      localIntent.putExtra("key_multi_edit_pic", true);
    }
    l1 = l2 | 0x1000;
    if ((paramInt2 == 122) || (paramInt2 == 125) || (paramInt2 == 133) || (EditVideoParams.a(paramInt2))) {
      l1 &= 0xFFFFFDFF;
    }
    for (;;)
    {
      paramBundle = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
      if (paramBundle != null)
      {
        localIntent.putExtra("uin", paramBundle.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", paramBundle.jdField_a_of_type_Int);
        localIntent.putExtra("troop_uin", paramBundle.c);
        localIntent.putExtra("uinname", paramBundle.jdField_b_of_type_JavaLangString);
      }
      localIntent.putExtra("EDIT_BUSI", paramInt1);
      localIntent.putExtra("entrance_type", paramInt2);
      localIntent.putExtra("pic_entrance_type", paramInt3);
      localIntent.putExtra("TEMP_PARAM", l1);
      localIntent.putExtra("PATH", paramString);
      localIntent.putExtra("go_publish_activity", paramBoolean6);
      if (paramHashMap != null) {
        localIntent.putExtra("user_params", paramHashMap);
      }
      localIntent.removeExtra("camera_type");
      if (paramActivity.getClass().getName().contains("ForwardRecentActivity")) {
        return a(localIntent);
      }
      return localIntent;
    }
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean9, HashMap<String, Object> paramHashMap)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, paramInt3, paramBoolean9, paramHashMap, null);
  }
  
  public static Intent a(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramIntent.getFlags();
      if ((0x80000 & i) > 0) {
        paramIntent.setFlags(i & 0xFFF7FFFF);
      }
    }
    return paramIntent;
  }
  
  private void a()
  {
    if (LiuHaiUtils.f())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370250));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  public Context a()
  {
    return this;
  }
  
  protected Intent a(Intent paramIntent, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return paramIntent;
    }
    paramIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
    return paramIntent;
  }
  
  public Intent a(bpel parambpel)
  {
    int i = 0;
    Object localObject1;
    String str;
    Object localObject2;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidContentIntent == null)
    {
      localObject1 = getIntent();
      str = ((Intent)localObject1).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME");
      if ((str != null) && (localObject2 != null))
      {
        ((Intent)localObject1).setClassName((String)localObject2, str);
        ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
      }
      localArrayList = new ArrayList();
      if ((!parambpel.jdField_a_of_type_Bpeq.c) && (parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_Boolean)) {
        break label319;
      }
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject2 = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    }
    JSONArray localJSONArray;
    Object localObject3;
    for (;;)
    {
      localArrayList.add(localObject2);
      localJSONArray = null;
      localObject3 = localJSONArray;
      if (this.jdField_a_of_type_Botw != null)
      {
        localObject3 = localJSONArray;
        if (this.jdField_a_of_type_Botw.jdField_a_of_type_Botf != null)
        {
          localObject3 = localJSONArray;
          if (this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a() != null)
          {
            localObject3 = localJSONArray;
            if (this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a().a() != null) {
              localObject3 = this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a().a().a;
            }
          }
        }
      }
      localJSONArray = new JSONArray();
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label392;
      }
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bowi localbowi = (bowi)((Iterator)localObject3).next();
        if ((localbowi.a != null) && (localbowi.a.a() != null)) {
          localJSONArray.put(localbowi.a.a().toString());
        }
      }
      localObject1 = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidContentIntent;
      break;
      label319:
      localObject2 = parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_JavaLangString;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        FileUtils.deleteFile(parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_JavaLangString);
        new File(parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_JavaLangString);
        bheg.a(this, parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_JavaLangString);
      }
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    }
    label392:
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + localJSONArray.toString());
    }
    if (localJSONArray.length() > 0) {
      ((Intent)localObject1).putExtra("dynamic_text", localJSONArray.toString());
    }
    ((Intent)localObject1).putExtra(PublishParam.jdField_a_of_type_JavaLangString, parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
    boolean bool2 = ((Intent)localObject1).getBooleanExtra("input_full_screen_mode", false);
    boolean bool1;
    if ((parambpel.jdField_a_of_type_Bpeq.c) || (!parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_Boolean))
    {
      bool1 = true;
      ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool1);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      if (bool1) {
        i = 2;
      }
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
      ((Intent)localObject1).putExtra("video_sync_to_story", parambpel.d);
      ((Intent)localObject1).addFlags(603979776);
      if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h()) || (bool2)) {
        ((Intent)localObject1).putExtra("key_multi_edit_source_path", this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject1).getFlags() + ",data = " + ((Intent)localObject1).getExtras());
      }
      localObject2 = a((Intent)localObject1, this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (String)localObject2);
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (str.contains("ForwardRecentActivity")) {
          localObject1 = a((Intent)localObject2);
        }
      }
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject3 = ((Intent)localObject1).getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity", 2, "initclassName:" + (String)localObject2);
      }
      if (localObject2 != null)
      {
        if (((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject2)) && (!"com.tencent.mobileqq.activity.ChatActivity".equals(localObject2))) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject3))) {
          break label957;
        }
        ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
      ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription);
      ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude);
      ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude);
      parambpel = ((Intent)localObject1).getStringExtra("key_camera_material_name");
      bnrh.b("EditPicActivity", "AIO send photo---takeSameName=" + parambpel);
      return localObject1;
      bool1 = false;
      break;
      label957:
      if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str)) {
        ((Intent)localObject1).setClassName("com.tencent.mobileqq", (String)localObject2);
      }
    }
  }
  
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, new Object[] { "finish, publishStoryFlag", Boolean.valueOf(paramBoolean) });
    }
    bmxa.f = paramBoolean;
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_Botw.x();
  }
  
  public void a(botw parambotw)
  {
    this.jdField_a_of_type_Botw = parambotw;
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
    this.jdField_a_of_type_Botw.a(paramInt1, paramInt2, paramIntent);
    ykq.c("EditPicActivity", "doOnActivityResult");
    Intent localIntent;
    Object localObject;
    if (paramInt1 == 666) {
      if (paramInt2 == -1)
      {
        localIntent = getIntent();
        localIntent.setClass(this, EditPicActivity.class);
        if (localIntent.getIntExtra("camera_type", -1) == 103)
        {
          paramIntent = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity", 2, "reset2Camera end shoot " + this + " new path " + paramIntent);
          }
          localObject = paramIntent;
          if (TextUtils.isEmpty(paramIntent))
          {
            localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("edit_pic_new_path", "");
            QLog.d("EditPicActivity", 1, " be killed. read sp " + (String)localObject);
          }
          if (FileUtils.fileExists((String)localObject)) {
            break label248;
          }
          QLog.i("EditPicActivity", 1, "recamera file not exist " + (String)localObject);
          QQToast.a(this, anvx.a(2131703152), 0).a();
          finish();
        }
      }
    }
    label248:
    do
    {
      do
      {
        do
        {
          return;
          paramIntent = localIntent.getStringExtra("image_path");
          break;
          paramIntent = new EditVideoParams(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int, this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, new EditTakePhotoSource((String)localObject, 2, 0, 0), EditVideoParams.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()));
          localIntent.putExtra(EditVideoParams.class.getName(), paramIntent);
          finish();
          startActivity(localIntent);
          return;
          ykq.c("EditPicActivity", "recamera cancel, finish");
          finish();
          return;
          if (paramInt1 != 1000) {
            break label371;
          }
        } while (paramInt2 != -1);
        a(paramInt2, paramIntent, 2130772030, 0);
        this.jdField_a_of_type_Botw.a(paramInt1, paramInt2, paramIntent);
        return;
        if (paramInt1 == 1001)
        {
          a(paramInt2, paramIntent, 2130772030, 0);
          return;
        }
      } while (paramInt1 != 19003);
      if (paramInt2 == -1)
      {
        a(paramInt2, paramIntent, 2130772030, 0);
        return;
      }
    } while ((paramInt2 != 0) || (paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
    label371:
    a(-1, paramIntent, 2130772030, 0);
  }
  
  public void doOnBackPressed()
  {
    ykq.c("EditPicActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Botw.d()) {
      super.doOnBackPressed();
    }
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    LiuHaiUtils.a();
    LiuHaiUtils.c(this);
    LiuHaiUtils.d(this);
    if (LiuHaiUtils.f()) {
      LiuHaiUtils.enableNotch(this);
    }
    SvEffectSdkInitor.init();
    bmwb.a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    bose.a();
    paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    bpii.a("finish jump activity", bpii.a(getIntent()));
    ykq.d("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), paramBundle });
    if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a())))
    {
      QQToast.a(this, anvx.a(2131703155), 0).a();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    }
    if (!FileUtils.fileExists(paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()))
    {
      QQToast.a(this, anvx.a(2131703156), 0).a();
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("editpic_cameratype", -1);
    if (i == 1)
    {
      bpii.e();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      i = getIntent().getIntExtra("edit_video_way", 0);
      this.jdField_a_of_type_Botw.b(i);
      try
      {
        SvEffectSdkInitor.isDovCapture = true;
        bnky.c();
        if (VideoEnvironment.loadAVCodecSo("AVCodec", super.getApplicationContext()) != 0) {
          ykq.e("EditPicActivity", "load AVCodec so failed");
        }
        this.jdField_a_of_type_Botw.d = true;
        setContentViewC(2131559136);
        if (isInMultiWindow())
        {
          QQToast.a(this, anvx.a(2131703153), 0).a();
          finish();
          return true;
          if (i != 2) {
            continue;
          }
          bpii.f();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ykq.c("EditPicActivity", "load so failed", localException);
        }
        a();
        this.jdField_a_of_type_Botw.a(this, paramBundle);
        if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage == null) {
          break label513;
        }
      }
    }
    Object localObject;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_Bosf != null)
    {
      long l = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
      localObject = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage;
      if (l <= 0L) {
        break label701;
      }
      bool = true;
      ((EditPicRawImage)localObject).a = bool;
      localObject = this.jdField_a_of_type_Botw.jdField_a_of_type_Bosf;
      if (l <= 0L) {
        break label707;
      }
    }
    label513:
    label701:
    label707:
    for (boolean bool = true;; bool = false)
    {
      ((bosf)localObject).f = bool;
      localObject = (bmuv)bogd.a(13);
      ((bmuv)localObject).b(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Botw.h();
      PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Bpqp);
      if (paramBundle.jdField_a_of_type_AndroidOsBundle != null) {
        ykw.a(paramBundle.jdField_a_of_type_AndroidOsBundle.getInt("pic_entrance_type", 0));
      }
      bpeq.a(null);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      i = this.jdField_a_of_type_Botw.f();
      int j = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
      int k = this.jdField_a_of_type_Botw.h();
      getIntent().putExtra("capture_operation_in", k);
      ykv.a("video_edit_new", "edit_exp", k, 0, new String[] { ykv.b(i), "", "", String.valueOf(j) });
      ((bmuv)localObject).d(1);
      ((bmuv)localObject).a(4);
      bcwl.a("0X800B3C4", paramBundle.c());
      return true;
      bool = false;
      break;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ykq.b("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_Botw.m();
    bmuv localbmuv = (bmuv)bogd.a(13);
    if (localbmuv != null) {
      localbmuv.d(1);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ykq.c("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_Botw.k();
    aqrl.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ykq.c("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_Botw.j();
    bpii.a("resume activity");
    ((bmuv)bogd.a(13)).c(1);
    if (Build.VERSION.SDK_INT >= 29) {
      zza.a(getWindow());
    }
    aqrl.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ykq.c("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_Botw.i();
    ykw.jdField_a_of_type_JavaLangString = ykw.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    ykw.jdField_b_of_type_JavaLangString = "pic_edit";
    bnqm.a().a();
    bnqq.a().c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Botw.l();
    bnqm.a().b();
    bnrh.b("EditPicActivity", "【doOnStop】");
    ykw.jdField_a_of_type_JavaLangString = "";
    ykw.jdField_b_of_type_JavaLangString = "";
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_Botw.c(paramBoolean);
  }
  
  public void initNavigationBarColor() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */