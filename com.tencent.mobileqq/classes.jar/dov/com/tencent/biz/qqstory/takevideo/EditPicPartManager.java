package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.OnSavePhoto;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qqfav.QfavBuilder.OnAddFav;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateEditPicDoodleSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.MakeStoryPicSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.MergePicSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EditPicPartManager
  extends EditVideoPartManager
  implements AIOGalleryUtils.OnSavePhoto, QfavBuilder.OnAddFav
{
  private Intent b;
  
  private void A()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 104) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        StoryReportor.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      if (b()) {
        StoryReportor.a("video_edit", "pub_local", 0, 0, new String[0]);
      }
      return;
    }
  }
  
  private void a(Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(localActivity);
    localActionSheet.addButton(2131693302);
    localActionSheet.addButton(2131693308);
    localActionSheet.addButton(2131693300);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new EditPicPartManager.2(this, localActionSheet, paramIntent, str, localActivity));
    localActionSheet.show();
  }
  
  private void a(Observer<GenerateContext> paramObserver)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.b = PublishFileManager.a(2);
    localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    localGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.actionType = 615;
    localGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.subactionType = 8;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a(0, localGenerateContext);
    }
    localObject = localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!TextUtils.isEmpty(localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
        break label335;
      }
    }
    label335:
    StringBuilder localStringBuilder;
    PublishVideoEntry localPublishVideoEntry;
    for (localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = ((String)localObject);; localPublishVideoEntry.videoDoodleDescription += (String)localObject)
    {
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(f()));
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()));
      VideoEditReport.b("0X80076EA");
      SLog.d("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703705), false, 500L);
      Stream.of(localGenerateContext).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null)).map(new MergePicSegment(EditPicConstants.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new MakeStoryPicSegment()).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
      localStringBuilder = new StringBuilder();
      localPublishVideoEntry = localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    }
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null)
    {
      Activity localActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if (localActivity != null) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new EditPicPartManager.3(this, localActivity), paramLong);
      }
    }
  }
  
  private static void b(EditPicPartManager paramEditPicPartManager)
  {
    for (;;)
    {
      int i;
      try
      {
        paramEditPicPartManager = ((EditDoodleExport)paramEditPicPartManager.a(EditDoodleExport.class)).a();
        int j;
        if (!paramEditPicPartManager.a().a())
        {
          paramEditPicPartManager = paramEditPicPartManager.a.a();
          j = paramEditPicPartManager.a;
          k = paramEditPicPartManager.b;
          i = -1;
        }
        switch (j)
        {
        case 0: 
          ReportController.b(null, "dc00898", "", "", "0X800A7C2", "0X800A7C2", i, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception paramEditPicPartManager)
      {
        int k;
        SLog.d("EditPicActivity.EditPicPartManager", "编辑涂鸦上报失败");
        return;
      }
      switch (k)
      {
      default: 
        break;
      case -1: 
        i = 2;
        break;
      case -2148308: 
        i = 3;
        break;
      case -1009097: 
        i = 4;
        break;
      case -8136876: 
        i = 5;
        break;
      case -13338378: 
        i = 6;
        break;
      case -16777216: 
        i = 12;
        continue;
        i = 1;
        continue;
        switch (k)
        {
        default: 
          break;
        case 1: 
          i = 7;
          break;
        case 2: 
          i = 8;
          break;
        case 3: 
          i = 9;
          break;
        case 4: 
          i = 10;
          break;
        case 5: 
          i = 11;
          continue;
          i = -1;
        }
        break;
      }
    }
  }
  
  private void c(int paramInt)
  {
    String str = PlusPanelUtils.a(AppConstants.SDCARD_IMG_CAMERA);
    Activity localActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    localActivity.getIntent().putExtra("image_path", str);
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditPicPartManager", 2, "reset2Camera begin " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() + " new path " + str);
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a()).edit().putString("edit_pic_new_path", str).commit();
    Intent localIntent = new Intent();
    FileProvider7Helper.setSystemCapture(localActivity, new File(str), localIntent);
    localIntent.putExtra("android.intent.extra.quickCapture", true);
    try
    {
      localActivity.startActivityForResult(localIntent, 666);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      QQToast.a(localActivity, HardCodeUtil.a(2131703711), 0).a();
      localActivity.finish();
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("EditPicActivity.EditPicPartManager", 1, "reset2Camera err", localException1);
      }
    }
  }
  
  protected SimpleObserver<GenerateContext> a()
  {
    return new EditPicPartManager.1(this);
  }
  
  public void a()
  {
    A();
    a(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    if (paramInt1 == 18001) {
      if (paramInt2 == -1) {
        AIOLongShotHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), paramIntent);
      }
    }
    while ((paramInt1 != 18002) || (paramInt2 != -1))
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, this.b, 2130772034, 0, false);
      this.b = null;
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, this.b, 2130772034, 0, false);
    this.b = null;
  }
  
  void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2130772034, 0, true);
      return;
    case 6: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1001);
      return;
    case 103: 
      paramIntent.addFlags(603979776);
      paramIntent.putExtra("sub_business_id", 103);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 8: 
      paramIntent.setClass(paramActivity, ReadInJoyDeliverUGCActivity.class);
      paramIntent.addFlags(603979776);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    }
    paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1050);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent() != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2130772034, 0, true);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramIntent, 2130772034, 0, true);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new EditVideoButton(this, paramEditVideoParams.c);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton = ((EditVideoButton)localObject);
    localArrayList.add(localObject);
    localObject = new EditProviderPart(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart = ((EditProviderPart)localObject);
    localArrayList.add(localObject);
    localObject = new EditVideoDoodle(this, paramEditVideoParams.c);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle = ((EditVideoDoodle)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicRawImage(this, paramEditVideoParams.c);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicCropPart(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart = ((EditPicCropPart)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.c, 512))
    {
      localObject = new EditPicSave(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave = ((EditPicSave)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 4096))
    {
      localObject = new EditVideoLimitRegion(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLimitRegion = ((EditVideoLimitRegion)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 2048))
    {
      localObject = new EditJumpToPtu(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditJumpToPtu = ((EditJumpToPtu)localObject);
      localArrayList.add(localObject);
    }
    if (EditPicMeiHua.a(paramEditVideoParams.c)) {
      localArrayList.add(new EditPicMeiHua(this));
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public void a(Error paramError)
  {
    SLog.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703708) + paramError, 0).a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(1000L);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    int k;
    if ((i == 103) && (i == 103))
    {
      i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
      j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
      k = ((Intent)localObject).getIntExtra("camera_capture_method", -1);
      if (i != 0) {
        break label326;
      }
      localObject = "0";
      if (j == -1) {
        break label334;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007376", "0X8007376", 0, 0, (String)localObject, "" + j, "", "");
      VideoEditReport.b("0X80075E8");
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("cameraFrontBack", "" + i);
      ((HashMap)localObject).put("templateId", "" + j);
      ((HashMap)localObject).put("photoCaptureMethod", "" + k);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "photo_send_from_shortvideo", true, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.e("EditPicActivity.EditPicPartManager", 2, "[ShortVideoMergeReport] tag=photo_send_from_shortvideo templateId=" + j + " camera=" + i);
      }
      ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity());
      return;
      label326:
      localObject = "1";
      break;
      label334:
      ReportController.b(null, "dc00898", "", "", "0X8007375", "0X8007375", 0, 0, (String)localObject, "" + j, "", "");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(1000L);
    }
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditPicPartManager", 2, "giveUpEditVideo, is from camera" + i + " clear photo " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
      }
      new File(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a()).delete();
      ImageUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
      Intent localIntent = new Intent();
      localIntent.putExtra("p_e_r_c", true);
      localIntent.putExtra("camera_type", i);
      if (i == 103)
      {
        i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
        int j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
        if (i == 0)
        {
          localObject = "0";
          if (j == -1) {
            break label265;
          }
          ReportController.b(null, "dc00898", "", "", "0X80072C6", "0X80072C6", 0, 0, (String)localObject, "" + j, "", "");
        }
        for (;;)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, localIntent, 2130772034, 0);
          return;
          localObject = "1";
          break;
          label265:
          ReportController.b(null, "dc00898", "", "", "0X80072C7", "0X80072C7", 0, 0, (String)localObject, "" + j, "", "");
        }
      }
      c(i);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2130772034, 0);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703706), false, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager
 * JD-Core Version:    0.7.0.1
 */