package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
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
import dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class QzoneEditPictureActivity
  extends EditPicActivity
{
  private QzoneEditPicturePartManager a;
  
  public static Intent a(Activity paramActivity, String paramString)
  {
    paramActivity = EditPicActivity.a(paramActivity, paramString, true, true, true, true, true, false, false, false, 3, 99, 0, false, null);
    paramActivity.putExtra("TEMP_PARAM", paramActivity.getLongExtra("TEMP_PARAM", 0L) | 0x200);
    return paramActivity;
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return EditPicActivity.a(paramActivity, paramString, true, true, true, paramBoolean, true, false, false, false, paramInt1, paramInt2, paramInt3, false, null);
  }
  
  private void a()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneEditPictureActivity.1(this));
  }
  
  private void b(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.f()))
    {
      paramIntent.putExtra("key_content", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_priv", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.jdField_c_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.a);
      paramIntent.putExtra("key_font_id", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.jdField_d_of_type_Int);
      paramIntent.putExtra("key_font_format_type", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.jdField_e_of_type_Int);
      paramIntent.putExtra("key_font_url", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_super_font_id", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.f);
      paramIntent.putExtra("key_super_font_info", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.jdField_e_of_type_JavaLangString);
      paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.g());
      QLog.i("QzoneEditPictureActivit", 2, "EditPic mSetTimerDelete: " + this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager.g());
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
        paramIntent.addFlags(872415232);
        startActivity(paramIntent);
        setResult(-1);
        super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
        return;
      }
      if (!bool)
      {
        QZoneHelper.launchQZone(this, "", paramIntent, -1);
        super.a(-1, null, 2130772034, 0, paramBoolean);
        return;
      }
      super.a(-1, paramIntent, 2130772034, 0, paramBoolean);
      return;
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public Intent a(GenerateContext paramGenerateContext)
  {
    int i = 0;
    Object localObject1;
    String str;
    Object localObject2;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent == null)
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
      if ((!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c) && (paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean)) {
        break label316;
      }
      QLog.d("QzoneEditPictureActivit", 1, "send sourcePath");
      localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a();
    }
    Object localObject4;
    Object localObject3;
    Object localObject5;
    for (;;)
    {
      localArrayList.add(localObject2);
      localObject4 = null;
      localObject3 = localObject4;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager != null)
      {
        localObject3 = localObject4;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
        {
          localObject3 = localObject4;
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a() != null)
          {
            localObject3 = localObject4;
            if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a() != null) {
              localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().a;
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
        localObject5 = (TextLayer.TextItem)((Iterator)localObject3).next();
        if ((((TextLayer.TextItem)localObject5).a != null) && (((TextLayer.TextItem)localObject5).a.a() != null)) {
          ((JSONArray)localObject4).put(((TextLayer.TextItem)localObject5).a.a().toString());
        }
      }
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent;
      break;
      label316:
      localObject2 = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        FileUtils.e(paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.a);
        new File(paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.a);
        ImageUtil.a(this, paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.a);
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
    ((Intent)localObject1).putExtra(PublishParam.a, paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
    boolean bool;
    int j;
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c) || (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean))
    {
      bool = true;
      ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool);
      localObject5 = ((Intent)localObject1).getStringExtra("PATH");
      j = ((Intent)localObject1).getIntExtra("p_e_s_type", -1);
      switch (j)
      {
      case 2: 
      case 4: 
      case 5: 
      case 8: 
      default: 
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus,photoEditSourceType = " + j + ",SINGLE_PHOTO_PATH = " + (String)localArrayList.get(0) + ",PHOTO_PATHS = " + localArrayList);
      }
      ((Intent)localObject1).putExtra("PhotoConst.USE_URL_PATH", true);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", false);
      ((Intent)localObject1).putExtra("PhotoConst.QZONE_SINGLE_PHOTO_PATH_EDITED", (String)localArrayList.get(0));
      ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      if (bool) {
        i = 2;
      }
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
      ((Intent)localObject1).putExtra("video_sync_to_story", paramGenerateContext.d);
      ((Intent)localObject1).addFlags(603979776);
      if (QLog.isColorLevel()) {
        QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject1).getFlags() + ",data = " + ((Intent)localObject1).getExtras());
      }
      localObject2 = a((Intent)localObject1, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (String)localObject2);
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (str.contains("ForwardRecentActivity")) {
          localObject1 = a((Intent)localObject2);
        }
      }
      ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription);
      ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude);
      ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude);
      return localObject1;
      bool = false;
      break;
      ((Intent)localObject1).putExtra("go_publish_activity", true);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      continue;
      localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      int k = ((ArrayList)localObject3).indexOf(localObject5);
      if (k != -1) {
        ((ArrayList)localObject3).set(k, localArrayList.get(0));
      }
      ((Intent)localObject1).putExtra("extra_directly_back", true);
      ((Intent)localObject1).putExtra("DirectBackToQzone", true);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
      continue;
      localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      ((ArrayList)localObject3).addAll(localArrayList);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("go_publish_activity", true);
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
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager = new QzoneEditPicturePartManager(this, true);
      a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager);
      bool = super.doOnCreate(paramBundle);
      if (!EditPicPartManager.a((int)getIntent().getLongExtra("TEMP_PARAM", 0L), 64)) {
        break label128;
      }
      a();
    }
    label128:
    do
    {
      return bool;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager = new QzoneEditPicturePartManager(this, false);
      a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartManager);
      QZLog.d("QzoneEditPictureActivit", 2, "doOnCreate do nothing, use original manager " + super.getClass().getName());
      break;
      paramBundle = findViewById(2131374441);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity
 * JD-Core Version:    0.7.0.1
 */