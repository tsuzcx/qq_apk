package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import azqo;
import azty;
import bdhb;
import bdhj;
import bjdt;
import bkax;
import bmjk;
import bmlp;
import bmnj;
import bmoj;
import bmqw;
import bmqz;
import bnaz;
import bnbf;
import bnfx;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.DataReporter;
import dov.com.tencent.biz.qqstory.takevideo.DataReporter.Destination;
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
  private bnfx a;
  
  public static Intent a(Activity paramActivity, String paramString)
  {
    paramActivity = EditPicActivity.a(paramActivity, paramString, true, true, true, true, true, false, false, false, 3, 99, 0, false, null);
    paramActivity.putExtra("TEMP_PARAM", paramActivity.getLongExtra("TEMP_PARAM", 0L) & 0xFBFFFFFF & 0xFFFDFFFF & 0xFDFFFFFF | 0x2000);
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
    if ((paramIntent != null) && (this.jdField_a_of_type_Bnfx != null) && (this.jdField_a_of_type_Bnfx.f()))
    {
      paramIntent.putExtra("key_content", this.jdField_a_of_type_Bnfx.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_priv", this.jdField_a_of_type_Bnfx.jdField_c_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", this.jdField_a_of_type_Bnfx.a);
      paramIntent.putExtra("key_font_id", this.jdField_a_of_type_Bnfx.jdField_d_of_type_Int);
      paramIntent.putExtra("key_font_format_type", this.jdField_a_of_type_Bnfx.jdField_e_of_type_Int);
      paramIntent.putExtra("key_font_url", this.jdField_a_of_type_Bnfx.jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_super_font_id", this.jdField_a_of_type_Bnfx.f);
      paramIntent.putExtra("key_super_font_info", this.jdField_a_of_type_Bnfx.jdField_e_of_type_JavaLangString);
      paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_Bnfx.g());
      QLog.i("QzoneEditPictureActivit", 2, "EditPic mSetTimerDelete: " + this.jdField_a_of_type_Bnfx.g());
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
        bjdt.a(this, "", paramIntent, -1);
        super.a(-1, null, 2130772028, 0, paramBoolean);
        return;
      }
      super.a(-1, paramIntent, 2130772028, 0, paramBoolean);
      return;
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public Intent a(bnaz parambnaz)
  {
    boolean bool2 = true;
    Object localObject1;
    String str;
    Object localObject2;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidContentIntent == null)
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
      if ((!parambnaz.jdField_a_of_type_Bnbf.c) && (parambnaz.jdField_a_of_type_Bnbf.jdField_b_of_type_Boolean)) {
        break label298;
      }
      QLog.d("QzoneEditPictureActivit", 1, "send sourcePath");
      localObject2 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      label120:
      localArrayList.add(localObject2);
      if ((this.jdField_a_of_type_Bmnj == null) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp == null) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a() == null) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a().a() == null)) {
        break label1318;
      }
    }
    label539:
    label1312:
    label1318:
    for (Object localObject3 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a().a().a;; localObject3 = null)
    {
      Object localObject4 = new JSONArray();
      Object localObject5;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject5 = (bmqz)((Iterator)localObject3).next();
            if ((((bmqz)localObject5).a != null) && (((bmqz)localObject5).a.a() != null))
            {
              ((JSONArray)localObject4).put(((bmqz)localObject5).a.a().toString());
              continue;
              localObject1 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidContentIntent;
              break;
              label298:
              localObject2 = parambnaz.jdField_a_of_type_Bnbf.jdField_b_of_type_JavaLangString;
              if (getIntent().getIntExtra("camera_type", -1) != -1)
              {
                bdhb.d(parambnaz.jdField_a_of_type_Bnbf.a);
                new File(parambnaz.jdField_a_of_type_Bnbf.a);
                bdhj.a(this, parambnaz.jdField_a_of_type_Bnbf.a);
              }
              ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
              break label120;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + ((JSONArray)localObject4).toString());
      }
      if (((JSONArray)localObject4).length() > 0) {
        ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject4).toString());
      }
      ((Intent)localObject1).putExtra(PublishParam.a, parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
      boolean bool1;
      int i;
      if ((parambnaz.jdField_a_of_type_Bnbf.c) || (!parambnaz.jdField_a_of_type_Bnbf.jdField_b_of_type_Boolean))
      {
        bool1 = true;
        ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool1);
        localObject5 = ((Intent)localObject1).getStringExtra("PATH");
        i = ((Intent)localObject1).getIntExtra("p_e_s_type", -1);
        switch (i)
        {
        case 4: 
        case 5: 
        default: 
          ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
          if (QLog.isColorLevel()) {
            QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus,photoEditSourceType = " + i + ",SINGLE_PHOTO_PATH = " + (String)localArrayList.get(0) + ",PHOTO_PATHS = " + localArrayList);
          }
          ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", false);
          ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
          if (bool1)
          {
            i = 2;
            label635:
            ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
            ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
            ((Intent)localObject1).putExtra("video_sync_to_story", parambnaz.d);
            ((Intent)localObject1).addFlags(603979776);
            if (QLog.isColorLevel()) {
              QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject1).getFlags() + ",data = " + ((Intent)localObject1).getExtras());
            }
            localObject2 = a((Intent)localObject1, this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (String)localObject2);
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
                break label1281;
              }
              ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
            }
            label895:
            ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
            ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription);
            ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude);
            ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude);
            if (parambnaz.e)
            {
              ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
              ((Intent)localObject1).removeExtra("PhotoConst.is_troop_send_mixed_msg");
              parambnaz = ((Intent)localObject1).getStringExtra("uin");
              i = ((Intent)localObject1).getIntExtra("uintype", 0);
              localObject3 = new azty();
              ((azty)localObject3).jdField_d_of_type_JavaLangString = "0X800699A";
              ((azty)localObject3).jdField_e_of_type_JavaLangString = String.valueOf(parambnaz);
              ((azty)localObject3).f = "3";
              ((azty)localObject3).i = "shanzhao";
              localObject2 = DataReporter.a().a(i);
              parambnaz = (bnaz)localObject2;
              if (localObject2 == null) {
                parambnaz = DataReporter.Destination.UNKNOWN;
              }
              ((azty)localObject3).g = parambnaz.toString();
              azqo.b(null, (azty)localObject3);
            }
            if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoj == null) {
              break label1312;
            }
            if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmoj.a(this.jdField_a_of_type_Bmnj.a()) == null) {
              break label1306;
            }
            bool1 = bool2;
          }
          break;
        }
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("VIDEO_HAS_TAG", bool1);
        return localObject1;
        bool1 = false;
        break;
        localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new ArrayList();
        }
        int j = ((ArrayList)localObject3).indexOf(localObject5);
        if (j != -1) {
          ((ArrayList)localObject3).set(j, localArrayList.get(0));
        }
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("PhotoConst.USE_URL_PATH", true);
        break label539;
        localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new ArrayList();
        }
        j = ((ArrayList)localObject3).indexOf(localObject5);
        if (j != -1) {
          ((ArrayList)localObject3).set(j, localArrayList.get(0));
        }
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
        break label539;
        i = 0;
        break label635;
        if (!"com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str)) {
          break label895;
        }
        ((Intent)localObject1).setClassName("com.tencent.mobileqq", (String)localObject2);
        break label895;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, true);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool;
    if ((getIntent() != null) && (getIntent().getBooleanExtra("go_publish_activity", false)))
    {
      this.jdField_a_of_type_Bnfx = new bnfx(this, true);
      a(this.jdField_a_of_type_Bnfx);
      bool = super.doOnCreate(paramBundle);
      paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((paramBundle == null) || (!bmjk.a(paramBundle.jdField_a_of_type_Long, 64))) {
        break label141;
      }
      a();
    }
    label141:
    do
    {
      return bool;
      this.jdField_a_of_type_Bnfx = new bnfx(this, false);
      a(this.jdField_a_of_type_Bnfx);
      QZLog.d("QzoneEditPictureActivit", 2, "doOnCreate do nothing, use original manager " + super.getClass().getName());
      break;
      paramBundle = findViewById(2131373313);
    } while (paramBundle == null);
    paramBundle.setVisibility(8);
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bkax.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity
 * JD-Core Version:    0.7.0.1
 */