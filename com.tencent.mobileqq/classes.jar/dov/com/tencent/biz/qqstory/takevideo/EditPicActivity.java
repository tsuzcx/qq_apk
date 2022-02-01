package dov.com.tencent.biz.qqstory.takevideo;

import Override;
import aana;
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
import anzj;
import aquy;
import bddz;
import bdlh;
import bdnr;
import bhmi;
import bhmq;
import blfp;
import bocw;
import boem;
import bork;
import bozr;
import bozv;
import bpam;
import bplq;
import bqci;
import bqcj;
import bqck;
import bqcl;
import bqeq;
import bqgk;
import bqhk;
import bqhs;
import bqjx;
import bqka;
import bqua;
import bqug;
import bqyo;
import brhj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import yuk;
import yup;
import yuq;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements bqhs
{
  public long a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bqgk a;
  brhj jdField_a_of_type_Brhj = new bqci(this);
  
  public EditPicActivity()
  {
    this.jdField_a_of_type_Bqgk = new bqcl();
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
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt1, paramInt2, 0, false, null, paramBundle);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, HashMap<String, Object> paramHashMap)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt1, paramInt2, 0, false, paramHashMap);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean9, HashMap<String, Object> paramHashMap)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramBoolean8, paramInt1, paramInt2, paramInt3, paramBoolean9, paramHashMap, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean9, HashMap<String, Object> paramHashMap, Bundle paramBundle)
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
      l2 = 0L | 0x20000000;
    }
    long l1 = l2;
    if (paramBoolean2) {
      l1 = l2 | 1L | 0x0;
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
    if (paramBoolean7) {
      l2 = l1 | 0x4000000;
    }
    l1 = l2;
    if (paramBoolean6) {
      l1 = l2 | 0x10000000;
    }
    l2 = l1;
    if (paramBoolean8) {
      l2 = l1 | 0x20000;
    }
    l1 = l2;
    if (paramBoolean5)
    {
      l1 = l2;
      if (Build.VERSION.SDK_INT >= 21) {
        l1 = l2 | 0x40;
      }
    }
    l2 = l1;
    if (paramInt2 == 102) {
      l2 = l1 | 0x800000;
    }
    if (paramInt1 != 2)
    {
      l1 = l2;
      if (paramInt1 != 6) {}
    }
    else
    {
      l1 = l2 | 0x40000000 | 0x2000 | 0x4000;
    }
    if ((paramInt1 != 8) && (paramInt1 != 4))
    {
      l2 = l1;
      if (paramInt1 != 3) {}
    }
    else
    {
      l2 = l1 | 0x2000;
    }
    l1 = l2;
    if (paramInt1 == 1) {
      l1 = l2 | 0x2000000;
    }
    l2 = l1;
    if (paramInt1 == 2) {
      l2 = l1 | 0x0;
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_multi_edit_pic", false))) {
      localIntent.putExtra("key_multi_edit_pic", true);
    }
    l2 |= 0x0;
    l1 = l2;
    if (bddz.l()) {
      l1 = l2 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
    }
    l2 = l1;
    if (paramInt2 == 102) {
      l2 = l1 & 0xFBFFFFFF & 0xFFFDFFFF;
    }
    if ((paramInt2 == 122) || (paramInt2 == 125) || (paramInt2 == 133) || (EditVideoParams.a(paramInt2))) {}
    for (l1 = l2 & 0xFFFFDFFF;; l1 = l2)
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
      localIntent.putExtra("go_publish_activity", paramBoolean9);
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370081));
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
    case 101: 
      String str = ForwardRecentActivity.class.getName();
      paramIntent.putExtra("forward_type", 1);
      paramIntent.putExtra("forward_ability_entrence_show_in_share", true);
      paramIntent.putExtra("k_qzone", true);
      paramIntent.putExtra("k_qqstory", true);
      paramIntent.putExtra("k_smartdevice", false);
      paramIntent.putExtra("k_favorites", false);
      paramIntent.putExtra("k_phonecontacts", false);
      paramIntent.putExtra("forward_filepath", paramString);
      paramIntent.putExtra("forward_extra", paramString);
      paramIntent.putExtra("forward_thumb", paramString);
      paramIntent.putExtra("forward_urldrawable", true);
      paramIntent.putExtra("forward_urldrawable_big_url", paramString);
      paramIntent.putExtra("forward_urldrawable_thumb_url", paramString);
      paramIntent.putExtra("forward_photo_shortvideo_is_edited", true);
      paramIntent.putExtra("forward_source_from_shoot_quick", true);
      paramIntent.setClassName("com.tencent.mobileqq", str);
      return paramIntent;
    }
    paramIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
    return paramIntent;
  }
  
  public Intent a(bqua parambqua)
  {
    boolean bool2 = true;
    Object localObject1;
    String str;
    Object localObject2;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidContentIntent == null)
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
      if ((!parambqua.jdField_a_of_type_Bqug.c) && (parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Boolean)) {
        break label301;
      }
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject2 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      label123:
      localArrayList.add(localObject2);
      if ((this.jdField_a_of_type_Bqgk == null) || (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq == null) || (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq.a() == null) || (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq.a().a() == null)) {
        break label1143;
      }
    }
    label301:
    label838:
    label1104:
    label1109:
    label1133:
    label1138:
    label1143:
    for (Object localObject3 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq.a().a().a;; localObject3 = null)
    {
      JSONArray localJSONArray = new JSONArray();
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            bqka localbqka = (bqka)((Iterator)localObject3).next();
            if ((localbqka.a != null) && (localbqka.a.a() != null))
            {
              localJSONArray.put(localbqka.a.a().toString());
              continue;
              localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidContentIntent;
              break;
              localObject2 = parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_JavaLangString;
              if (getIntent().getIntExtra("camera_type", -1) != -1)
              {
                bhmi.d(parambqua.jdField_a_of_type_Bqug.jdField_a_of_type_JavaLangString);
                new File(parambqua.jdField_a_of_type_Bqug.jdField_a_of_type_JavaLangString);
                bhmq.a(this, parambqua.jdField_a_of_type_Bqug.jdField_a_of_type_JavaLangString);
              }
              ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
              break label123;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + localJSONArray.toString());
      }
      if (localJSONArray.length() > 0) {
        ((Intent)localObject1).putExtra("dynamic_text", localJSONArray.toString());
      }
      ((Intent)localObject1).putExtra(PublishParam.jdField_a_of_type_JavaLangString, parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("input_full_screen_mode", false);
      boolean bool1;
      int i;
      if ((parambqua.jdField_a_of_type_Bqug.c) || (!parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Boolean))
      {
        bool1 = true;
        ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool1);
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
        if (!bool1) {
          break label1104;
        }
        i = 2;
        ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
        ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
        ((Intent)localObject1).putExtra("video_sync_to_story", parambqua.d);
        ((Intent)localObject1).addFlags(603979776);
        if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j()) || (bool3)) {
          ((Intent)localObject1).putExtra("key_multi_edit_source_path", this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject1).getFlags() + ",data = " + ((Intent)localObject1).getExtras());
        }
        localObject2 = a((Intent)localObject1, this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (String)localObject2);
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
            break label1109;
          }
          ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
        }
        ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
        ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription);
        ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude);
        ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude);
        if (parambqua.e)
        {
          ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
          ((Intent)localObject1).removeExtra("PhotoConst.is_troop_send_mixed_msg");
          parambqua = ((Intent)localObject1).getStringExtra("uin");
          i = ((Intent)localObject1).getIntExtra("uintype", 0);
          localObject3 = new bdnr();
          ((bdnr)localObject3).d = "0X800699A";
          ((bdnr)localObject3).e = String.valueOf(parambqua);
          ((bdnr)localObject3).f = "3";
          ((bdnr)localObject3).i = "shanzhao";
          localObject2 = DataReporter.a().a(i);
          parambqua = (bqua)localObject2;
          if (localObject2 == null) {
            parambqua = DataReporter.Destination.UNKNOWN;
          }
          ((bdnr)localObject3).g = parambqua.toString();
          bdlh.b(null, (bdnr)localObject3);
        }
        if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhk == null) {
          break label1138;
        }
        if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqhk.a(this.jdField_a_of_type_Bqgk.a()) == null) {
          break label1133;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("VIDEO_HAS_TAG", bool1);
        parambqua = ((Intent)localObject1).getStringExtra("key_camera_material_name");
        bpam.b("EditPicActivity", "AIO send photo---takeSameName=" + parambqua);
        return localObject1;
        bool1 = false;
        break;
        i = 0;
        break label524;
        if (!"com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str)) {
          break label838;
        }
        ((Intent)localObject1).setClassName("com.tencent.mobileqq", (String)localObject2);
        break label838;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public bqgk a()
  {
    return this.jdField_a_of_type_Bqgk;
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
    dov.com.qq.im.QIMEffectCameraCaptureUnit.w = paramBoolean;
    bofh.a = paramBoolean;
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_Bqgk.A();
  }
  
  public void a(bqgk parambqgk)
  {
    this.jdField_a_of_type_Bqgk = parambqgk;
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bqgk.a(paramInt1, paramInt2, paramIntent);
    yuk.c("EditPicActivity", "doOnActivityResult");
    Intent localIntent;
    Object localObject;
    if (paramInt1 == 666) {
      if (paramInt2 == -1)
      {
        localIntent = getIntent();
        localIntent.setClass(this, EditPicActivity.class);
        if (localIntent.getIntExtra("camera_type", -1) == 103)
        {
          paramIntent = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity", 2, "reset2Camera end shoot " + this + " new path " + paramIntent);
          }
          localObject = paramIntent;
          if (TextUtils.isEmpty(paramIntent))
          {
            localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("edit_pic_new_path", "");
            QLog.d("EditPicActivity", 1, " be killed. read sp " + (String)localObject);
          }
          if (bhmi.a((String)localObject)) {
            break label248;
          }
          QLog.i("EditPicActivity", 1, "recamera file not exist " + (String)localObject);
          QQToast.a(this, anzj.a(2131702566), 0).a();
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
          paramIntent = new EditVideoParams(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int, this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, new EditTakePhotoSource((String)localObject, 2, 0, 0), EditVideoParams.a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()));
          localIntent.putExtra(EditVideoParams.class.getName(), paramIntent);
          finish();
          startActivity(localIntent);
          return;
          yuk.c("EditPicActivity", "recamera cancel, finish");
          finish();
          return;
          if (paramInt1 != 1000) {
            break label443;
          }
        } while (paramInt2 != -1);
        if (paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0) == 1003)
        {
          this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int = 1;
          getIntent().putExtra("main_tab_id", 6);
          getIntent().putExtra("fragment_id", 1);
          getIntent().putExtra("switch_anim", true);
          this.jdField_a_of_type_Bqgk.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Bqgk.a(paramInt1, paramInt2, paramIntent);
          return;
          a(paramInt2, paramIntent, 2130772029, 0);
        }
        if (paramInt1 == 1001)
        {
          a(paramInt2, paramIntent, 2130772029, 0);
          return;
        }
      } while (paramInt1 != 19003);
      if (paramInt2 == -1)
      {
        a(paramInt2, paramIntent, 2130772029, 0);
        return;
      }
    } while ((paramInt2 != 0) || (paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
    label443:
    a(-1, paramIntent, 2130772029, 0);
  }
  
  public void doOnBackPressed()
  {
    yuk.c("EditPicActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Bqgk.d()) {
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
    blfp.a();
    boem.a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    bqcj.a(QQStoryContext.a().a(), this);
    paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    bqyo.a("finish jump activity", bqyo.a(getIntent()));
    yuk.d("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), paramBundle });
    if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a())))
    {
      QQToast.a(this, anzj.a(2131702569), 0).a();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    }
    if (!bhmi.a(paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()))
    {
      QQToast.a(this, anzj.a(2131702570), 0).a();
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("editpic_cameratype", -1);
    if (i == 1)
    {
      bqyo.i();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      i = getIntent().getIntExtra("edit_video_way", 0);
      this.jdField_a_of_type_Bqgk.b(i);
      try
      {
        blfp.a = true;
        bork.c();
        if (VideoEnvironment.a("AVCodec", super.getApplicationContext()) != 0) {
          yuk.e("EditPicActivity", "load AVCodec so failed");
        }
        this.jdField_a_of_type_Bqgk.e = true;
        setContentViewC(2131559100);
        if (isInMultiWindow())
        {
          QQToast.a(this, anzj.a(2131702567), 0).a();
          finish();
          return true;
          if (i != 2) {
            continue;
          }
          bqyo.j();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          yuk.c("EditPicActivity", "load so failed", localException);
        }
        a();
        this.jdField_a_of_type_Bqgk.a(this, paramBundle);
        if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
        {
          this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("FILTER_STRING");
          this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_Int = getIntent().getIntExtra("FILTER_MAXSIDE", 640);
          this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.c = getIntent().getStringExtra("FILTER_LOADING_PATH");
        }
        if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage == null) {
          break label593;
        }
      }
    }
    long l;
    Object localObject;
    boolean bool;
    label586:
    label593:
    int j;
    int k;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqck != null)
    {
      l = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
      localObject = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage;
      if (l > 0L)
      {
        bool = true;
        ((EditPicRawImage)localObject).a = bool;
        localObject = this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqck;
        if (l <= 0L) {
          break label861;
        }
        bool = true;
        ((bqck)localObject).f = bool;
      }
    }
    else
    {
      localObject = (bocw)bplq.a(13);
      ((bocw)localObject).b(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_Bqgk.j();
      PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Brhj, false);
      if (paramBundle.jdField_a_of_type_AndroidOsBundle != null) {
        yuq.a(paramBundle.jdField_a_of_type_AndroidOsBundle.getInt("pic_entrance_type", 0));
      }
      bqug.a(null);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      j = this.jdField_a_of_type_Bqgk.g();
      k = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1)
      {
        l = getIntent().getLongExtra("stop_record_time", -1L);
        if (l <= 0L) {
          break label867;
        }
      }
    }
    label861:
    label867:
    for (i = (int)(this.jdField_a_of_type_Long - l);; i = 0)
    {
      yup.b("time_openedit", 1, i, new String[] { yup.b(j), "0", "", String.valueOf(k) });
      i = this.jdField_a_of_type_Bqgk.i();
      getIntent().putExtra("capture_operation_in", i);
      yup.a("video_edit_new", "edit_exp", i, 0, new String[] { yup.b(j), "", "", String.valueOf(k) });
      ((bocw)localObject).d(1);
      ((bocw)localObject).a(4);
      return true;
      bool = false;
      break;
      bool = false;
      break label586;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    yuk.b("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_Bqgk.o();
    bocw localbocw = (bocw)bplq.a(13);
    if (localbocw != null) {
      localbocw.d(1);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    yuk.c("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_Bqgk.m();
    aquy.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    yuk.c("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_Bqgk.l();
    bqyo.a("resume activity");
    ((bocw)bplq.a(13)).c(1);
    if (Build.VERSION.SDK_INT >= 29) {
      aana.a(getWindow());
    }
    aquy.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    yuk.c("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_Bqgk.k();
    yuq.jdField_a_of_type_JavaLangString = yuq.a(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    yuq.jdField_b_of_type_JavaLangString = "pic_edit";
    bozr.a().a();
    bozv.a().c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Bqgk.n();
    bozr.a().b();
    bpam.b("EditPicActivity", "【doOnStop】");
    yuq.jdField_a_of_type_JavaLangString = "";
    yuq.jdField_b_of_type_JavaLangString = "";
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_Bqgk.c(paramBoolean);
  }
  
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