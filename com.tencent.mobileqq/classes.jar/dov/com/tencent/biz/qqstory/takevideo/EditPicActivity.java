package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import anri;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMMsgReportItem;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements EditVideoPartManager.IEditVideoPartManager, EditVideoUi
{
  private EditVideoPartManager jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = new EditPicPartManager();
  PtvTemplateManager.DoodleInfoLoadObserver jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver = new anri(this);
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, int paramInt1, int paramInt2, int paramInt3)
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
    int j = 0;
    if (paramBoolean1) {
      j = 32;
    }
    int i = j;
    if (paramBoolean2) {
      i = j | 0x8;
    }
    j = i;
    if (paramBoolean3) {
      j = i | 0x2;
    }
    i = j;
    if (paramBoolean4) {
      i = j | 0x40;
    }
    j = i;
    if (paramBoolean6) {
      j = i | 0x4000000;
    }
    i = j;
    if (paramBoolean10) {
      i = j | 0x8000000;
    }
    j = i;
    if (paramBoolean9) {
      j = i | 0x20000000;
    }
    i = j;
    if (paramBoolean11) {
      i = j | 0x20000;
    }
    j = i;
    if (paramBoolean8) {
      j = i | 0x10;
    }
    i = j;
    if (paramBoolean7) {
      i = j | 0x1;
    }
    j = i;
    if (paramInt3 == 1) {
      j = i | 0x800000;
    }
    i = j;
    if (paramInt2 == 102) {
      i = j | 0x1000000;
    }
    j = i;
    if (MediaCodecDPC.l()) {
      j = i & 0xFFFFFFDF & 0xFFFFFFFD & 0xFFFFFEFF & 0xFFFFFFEF & 0xFFFFFFFE;
    }
    i = j;
    if (paramInt2 != 100)
    {
      i = j;
      if (paramInt2 != 102) {
        i = j | 0x8000000 | 0x20000;
      }
    }
    localIntent.putExtra("EDIT_BUSI", paramInt1);
    localIntent.putExtra("entrance_type", paramInt2);
    localIntent.putExtra("pic_entrance_type", paramInt3);
    localIntent.putExtra("TEMP_PARAM", i | 0x2000);
    localIntent.putExtra("PATH", paramString);
    localIntent.putExtra("USE_FILTER", paramBoolean5);
    localIntent.removeExtra("camera_type");
    if (paramActivity.getClass().getName().contains("ForwardRecentActivity")) {
      return a(localIntent);
    }
    return localIntent;
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
  
  public Context a()
  {
    return this;
  }
  
  public Intent a(GenerateContext paramGenerateContext)
  {
    boolean bool2 = true;
    Object localObject2 = getIntent();
    Object localObject3 = ((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    ((Intent)localObject2).setClassName(((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject3);
    ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
    Object localObject4 = new ArrayList();
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) || (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean))
    {
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      ((ArrayList)localObject4).add(localObject1);
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a() == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a() == null)) {
        break label1010;
      }
    }
    label588:
    label732:
    label993:
    label998:
    label1003:
    label1010:
    for (Object localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().a;; localObject1 = null)
    {
      JSONArray localJSONArray = new JSONArray();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject1).next();
            if ((localTextItem.a != null) && (localTextItem.a.a() != null))
            {
              localJSONArray.put(localTextItem.a.a().toString());
              continue;
              localObject1 = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
              if (getIntent().getIntExtra("camera_type", -1) != -1)
              {
                FileUtils.d(paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString);
                new File(paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString);
                ImageUtil.a(this, paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString);
              }
              ((Intent)localObject2).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
              break;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + localJSONArray.toString());
      }
      if (localJSONArray.length() > 0) {
        ((Intent)localObject2).putExtra("dynamic_text", localJSONArray.toString());
      }
      ((Intent)localObject2).putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
      boolean bool1;
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) || (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean))
      {
        bool1 = true;
        ((Intent)localObject2).putExtra("PhotoConst.SEND_ORIGIN", bool1);
        ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject4);
        ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject4).get(0));
        ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject2).putExtra("PhotoConst.SEND_FLAG", true);
        ((Intent)localObject2).addFlags(603979776);
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject2).getFlags() + ",data = " + ((Intent)localObject2).getExtras());
        }
        if (!((String)localObject3).contains("ForwardRecentActivity")) {
          break label1003;
        }
      }
      for (localObject1 = a((Intent)localObject2);; localObject1 = localObject2)
      {
        if ("com.tencent.mobileqq".equals(getPackageName()))
        {
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity", 2, "ISQIM EditPicActivity#getPublishIntent, isQIM = " + bool1);
          }
          ((Intent)localObject1).putExtra("video_send_aio_key_is_qim", bool1);
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          localObject4 = ((Intent)localObject1).getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity", 2, "initclassName:" + (String)localObject2);
          }
          if ((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject2)) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(localObject3)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject4))) {
            break label969;
          }
          ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
          ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription);
          ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude);
          ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude);
          if (paramGenerateContext.e)
          {
            ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
            ((Intent)localObject1).removeExtra("PhotoConst.is_troop_send_mixed_msg");
            paramGenerateContext = ((Intent)localObject1).getStringExtra("uin");
            int i = ((Intent)localObject1).getIntExtra("uintype", 0);
            localObject3 = new QIMMsgReportItem();
            ((QIMMsgReportItem)localObject3).d = "0X800699A";
            ((QIMMsgReportItem)localObject3).e = String.valueOf(paramGenerateContext);
            ((QIMMsgReportItem)localObject3).f = "3";
            ((QIMMsgReportItem)localObject3).i = "shanzhao";
            localObject2 = DataReporter.a().a(i);
            paramGenerateContext = (GenerateContext)localObject2;
            if (localObject2 == null) {
              paramGenerateContext = DataReporter.Destination.UNKNOWN;
            }
            ((QIMMsgReportItem)localObject3).g = paramGenerateContext.toString();
            QIMReportController.b(null, (QIMMsgReportItem)localObject3);
          }
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag == null) {
            break label998;
          }
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) == null) {
            break label993;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("VIDEO_HAS_TAG", bool1);
          return localObject1;
          bool1 = false;
          break;
          bool1 = false;
          break label588;
          if (!"com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(localObject3)) {
            break label732;
          }
          ((Intent)localObject1).setClassName("com.tencent.mobileqq", (String)localObject2);
          break label732;
          bool1 = false;
          continue;
          bool1 = false;
        }
      }
    }
  }
  
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.y();
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    SLog.c("EditPicActivity", "doOnActivityResult");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
    Intent localIntent;
    if (paramInt1 == 666)
    {
      if (paramInt2 != -1) {
        break label317;
      }
      localIntent = getIntent();
      localIntent.setClass(this, EditPicActivity.class);
      if (localIntent.getIntExtra("camera_type", -1) != 103) {
        break label229;
      }
    }
    Object localObject;
    label229:
    for (paramIntent = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();; paramIntent = localIntent.getStringExtra("image_path"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity", 2, "reset2Camera end shoot " + this + " new path " + paramIntent);
      }
      localObject = paramIntent;
      if (TextUtils.isEmpty(paramIntent))
      {
        localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("edit_pic_new_path", "");
        QLog.d("EditPicActivity", 1, " be killed. read sp " + (String)localObject);
      }
      if (FileUtils.a((String)localObject)) {
        break;
      }
      QLog.i("EditPicActivity", 1, "recamera file not exist " + (String)localObject);
      QQToast.a(this, "图片不存在", 0).a();
      finish();
      return;
    }
    paramIntent = new EditVideoParams(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b, new EditTakePhotoSource((String)localObject, 2, 0, 0), EditVideoParams.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()));
    localIntent.putExtra(EditVideoParams.class.getName(), paramIntent);
    finish();
    startActivity(localIntent);
    return;
    label317:
    SLog.c("EditPicActivity", "recamera cancel, finish");
    finish();
  }
  
  public void doOnBackPressed()
  {
    SLog.c("EditPicActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c()) {
      super.doOnBackPressed();
    }
  }
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoModule.init(BaseApplicationImpl.getContext());
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    EditPicConstants.a(QQStoryContext.a().a(), this);
    paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    NewFlowCameraReporter.a("finish jump activity", NewFlowCameraReporter.a(getIntent()));
    SLog.d("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), paramBundle });
    if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a())))
    {
      QQToast.a(this, "图片参数错误", 0).a();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    }
    if (!FileUtils.a(paramBundle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()))
    {
      QQToast.a(this, "图片不存在", 0).a();
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("editpic_cameratype", -1);
    if (i == 1)
    {
      NewFlowCameraReporter.j();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      i = getIntent().getIntExtra("edit_video_way", 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(i);
      try
      {
        PtvFilterSoLoad.a(VideoEnvironment.a(), false);
        if (VideoEnvironment.a("AVCodec", super.getApplicationContext()) != 0) {
          SLog.e("EditPicActivity", "load AVCodec so failed");
        }
        bool = getIntent().getBooleanExtra("extra.AUTO_JUMP_EDIT", false);
        Object localObject = (PasterDataManager)QIMManager.a(4);
        if (bool)
        {
          ((PasterDataManager)localObject).a(2);
          getWindow().addFlags(1024);
          setContentViewC(2130968947);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(this, paramBundle);
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("FILTER_STRING");
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_Int = getIntent().getIntExtra("FILTER_MAXSIDE", 640);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.c = getIntent().getStringExtra("FILTER_LOADING_PATH");
          }
          if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart != null))
          {
            long l = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
            localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage;
            if (l <= 0L) {
              break label613;
            }
            bool = true;
            ((EditPicRawImage)localObject).jdField_a_of_type_Boolean = bool;
            localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart;
            if (l <= 0L) {
              break label618;
            }
            bool = true;
            ((EditPicCropPart)localObject).d = bool;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.i();
          PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver, false);
          if (paramBundle.jdField_a_of_type_AndroidOsBundle != null) {
            VideoEditReport.a(paramBundle.jdField_a_of_type_AndroidOsBundle.getInt("pic_entrance_type", 0));
          }
          GeneratePicArgs.a(null);
          return true;
          if (i != 2) {
            continue;
          }
          NewFlowCameraReporter.k();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          SLog.c("EditPicActivity", "load so failed", localException);
          continue;
          localException.a(1);
          continue;
          label613:
          boolean bool = false;
          continue;
          label618:
          bool = false;
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.b("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.n();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    if (localPasterDataManager != null) {
      localPasterDataManager.a(1);
    }
    ((QIMInformationPasterManager)QIMManager.a().c(12)).a("");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SLog.c("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.l();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SLog.c("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.k();
    NewFlowCameraReporter.a("resume activity");
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SLog.c("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.j();
    VideoEditReport.jdField_a_of_type_JavaLangString = VideoEditReport.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    VideoEditReport.jdField_b_of_type_JavaLangString = "pic_edit";
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    SLog.c("EditPicActivity", "doOnStop");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.m();
    VideoEditReport.jdField_a_of_type_JavaLangString = "";
    VideoEditReport.jdField_b_of_type_JavaLangString = "";
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */