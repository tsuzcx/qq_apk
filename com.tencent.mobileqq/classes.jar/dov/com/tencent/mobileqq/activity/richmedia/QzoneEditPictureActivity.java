package dov.com.tencent.mobileqq.activity.richmedia;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import bheg;
import bosh;
import botf;
import botw;
import bowf;
import bowi;
import bpel;
import bpeq;
import bpip;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class QzoneEditPictureActivity
  extends EditPicActivity
{
  private bpip a;
  
  public static Intent a(Activity paramActivity, String paramString)
  {
    paramActivity = EditPicActivity.a(paramActivity, paramString, true, true, true, true, true, false, false, false, 3, 99, 0, false, null);
    paramActivity.putExtra("TEMP_PARAM", paramActivity.getLongExtra("TEMP_PARAM", 0L) | 0x200);
    return paramActivity;
  }
  
  private void a()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneEditPictureActivity.1(this));
  }
  
  private void b(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_Bpip != null) && (this.jdField_a_of_type_Bpip.f()))
    {
      paramIntent.putExtra("key_content", this.jdField_a_of_type_Bpip.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_priv", this.jdField_a_of_type_Bpip.jdField_c_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", this.jdField_a_of_type_Bpip.a);
      paramIntent.putExtra("key_font_id", this.jdField_a_of_type_Bpip.jdField_d_of_type_Int);
      paramIntent.putExtra("key_font_format_type", this.jdField_a_of_type_Bpip.jdField_e_of_type_Int);
      paramIntent.putExtra("key_font_url", this.jdField_a_of_type_Bpip.jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_super_font_id", this.jdField_a_of_type_Bpip.f);
      paramIntent.putExtra("key_super_font_info", this.jdField_a_of_type_Bpip.jdField_e_of_type_JavaLangString);
      paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_Bpip.g());
      QLog.i("QzoneEditPictureActivit", 2, "EditPic mSetTimerDelete: " + this.jdField_a_of_type_Bpip.g());
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzoneEditPictureActivit", 2, "QzoneEditPictureActivity finish --- resultCode : " + paramInt1);
    }
    if ((paramIntent != null) && (paramInt1 != 0))
    {
      boolean bool = paramIntent.getBooleanExtra("go_publish_activity", false);
      if (paramIntent.getBooleanExtra("extra_directly_back", false))
      {
        paramIntent.setClass(this, NewPhotoListActivity.class);
        paramIntent.addFlags(536870912);
        startActivity(paramIntent);
        setResult(-1);
        super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
        return;
      }
      if (!bool)
      {
        QZoneHelper.launchQZone(this, "", paramIntent, -1);
        super.a(-1, null, 2130772030, 0, paramBoolean);
        return;
      }
      super.a(-1, paramIntent, 2130772030, 0, paramBoolean);
      return;
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
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
        break label316;
      }
      QLog.d("QzoneEditPictureActivit", 1, "send sourcePath");
      localObject2 = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a();
    }
    Object localObject4;
    Object localObject3;
    Object localObject5;
    for (;;)
    {
      localArrayList.add(localObject2);
      localObject4 = null;
      localObject3 = localObject4;
      if (this.jdField_a_of_type_Botw != null)
      {
        localObject3 = localObject4;
        if (this.jdField_a_of_type_Botw.jdField_a_of_type_Botf != null)
        {
          localObject3 = localObject4;
          if (this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a() != null)
          {
            localObject3 = localObject4;
            if (this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a().a() != null) {
              localObject3 = this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a().a().a;
            }
          }
        }
      }
      localObject4 = new JSONArray();
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label390;
      }
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (bowi)((Iterator)localObject3).next();
        if ((((bowi)localObject5).a != null) && (((bowi)localObject5).a.a() != null)) {
          ((JSONArray)localObject4).put(((bowi)localObject5).a.a().toString());
        }
      }
      localObject1 = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidContentIntent;
      break;
      label316:
      localObject2 = parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_JavaLangString;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        FileUtils.deleteFile(parambpel.jdField_a_of_type_Bpeq.a);
        new File(parambpel.jdField_a_of_type_Bpeq.a);
        bheg.a(this, parambpel.jdField_a_of_type_Bpeq.a);
      }
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    }
    label390:
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + ((JSONArray)localObject4).toString());
    }
    if (((JSONArray)localObject4).length() > 0) {
      ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject4).toString());
    }
    ((Intent)localObject1).putExtra(PublishParam.a, parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
    boolean bool;
    if ((parambpel.jdField_a_of_type_Bpeq.c) || (!parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_Boolean))
    {
      bool = true;
      ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool);
      localObject5 = ((Intent)localObject1).getStringExtra("PATH");
      int j = ((Intent)localObject1).getIntExtra("p_e_s_type", -1);
      switch (j)
      {
      case 4: 
      case 5: 
      default: 
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        ((Intent)localObject1).putExtra("go_publish_activity", true);
        label572:
        if (QLog.isColorLevel()) {
          QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus,photoEditSourceType = " + j + ",SINGLE_PHOTO_PATH = " + (String)localArrayList.get(0) + ",PHOTO_PATHS = " + localArrayList);
        }
        ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", false);
        ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
        if (bool) {
          i = 2;
        }
        ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
        ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
        ((Intent)localObject1).putExtra("video_sync_to_story", parambpel.d);
        ((Intent)localObject1).addFlags(603979776);
        if (QLog.isColorLevel()) {
          QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject1).getFlags() + ",data = " + ((Intent)localObject1).getExtras());
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
          QLog.d("QzoneEditPictureActivit", 2, "initclassName:" + (String)localObject2);
        }
        if (localObject2 != null)
        {
          if ((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject2)) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject3))) {
            break label1198;
          }
          ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
        }
        break;
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
      ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription);
      ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude);
      ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude);
      return localObject1;
      bool = false;
      break;
      localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      int k = ((ArrayList)localObject3).indexOf(localObject5);
      if (k != -1) {
        ((ArrayList)localObject3).set(k, localArrayList.get(0));
      }
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("PhotoConst.USE_URL_PATH", true);
      ((Intent)localObject1).putExtra("extra_directly_back", true);
      ((Intent)localObject1).putExtra("DirectBackToQzone", true);
      break label572;
      localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      k = ((ArrayList)localObject3).indexOf(localObject5);
      if (k != -1) {
        ((ArrayList)localObject3).set(k, localArrayList.get(0));
      }
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("extra_directly_back", true);
      ((Intent)localObject1).putExtra("DirectBackToQzone", true);
      break label572;
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      break label572;
      label1198:
      if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str)) {
        ((Intent)localObject1).setClassName("com.tencent.mobileqq", (String)localObject2);
      }
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool;
    if ((getIntent() != null) && (getIntent().getBooleanExtra("go_publish_activity", false)))
    {
      this.jdField_a_of_type_Bpip = new bpip(this, true);
      a(this.jdField_a_of_type_Bpip);
      bool = super.doOnCreate(paramBundle);
      paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((paramBundle == null) || (!bosh.a(paramBundle.jdField_c_of_type_Int, 64))) {
        break label141;
      }
      a();
    }
    label141:
    do
    {
      return bool;
      this.jdField_a_of_type_Bpip = new bpip(this, false);
      a(this.jdField_a_of_type_Bpip);
      QZLog.d("QzoneEditPictureActivit", 2, "doOnCreate do nothing, use original manager " + super.getClass().getName());
      break;
      paramBundle = findViewById(2131374124);
    } while (paramBundle == null);
    paramBundle.setVisibility(8);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity
 * JD-Core Version:    0.7.0.1
 */