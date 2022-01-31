package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import anzw;
import anzx;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils.WatermarkPicTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.tencent.biz.qqstory.takevideo.interact.EditVideoInteract;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateEditPicDoodleSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.MakeStoryPicSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.MergePicSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class EditPicPartManager
  extends EditVideoPartManager
{
  public int a;
  
  private void A()
  {
    String str1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
    int i;
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      i = 1;
      if (i != 0)
      {
        i = b();
        str2 = a(str1);
        if (!a()) {
          break label75;
        }
      }
    }
    label75:
    for (str1 = "2";; str1 = "1")
    {
      b("pub_changeface", i, 0, new String[] { "1", str2, str1 });
      return;
      i = 0;
      break;
    }
  }
  
  private void a(Observer paramObserver)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.b = PublishFileManager.a(2);
    localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    localGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.actionType = 615;
    localGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.subactionType = 8;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(0, localGenerateContext);
    }
    VideoEditReport.b("0X80076EA");
    SLog.d("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a("请稍候", false, 500L);
    Stream.of(localGenerateContext).map(new ThreadOffFunction(2)).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null)).map(new MergePicSegment(EditPicConstants.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new MakeStoryPicSegment()).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditPicPartManager", 2, "save from manual " + paramString1);
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      if (StringUtil.a(paramString1))
      {
        if (paramBoolean3)
        {
          if (!CameraCompatibleList.d(CameraCompatibleList.j)) {
            break label146;
          }
          ImageUtil.a(paramString2, "Orientation", String.valueOf(6));
        }
        paramString1 = PlayModeUtils.a("", true);
        ThreadManager.executeOnSubThread(new PhotoUtils.WatermarkPicTask(paramString2, paramString1, new anzx(paramString2, paramString1)));
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity.EditPicPartManager", 2, "save from " + paramString2 + " to " + paramString1);
        }
      }
    }
    label146:
    do
    {
      do
      {
        return;
        int i = j;
        switch (paramInt % 360)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          ImageUtil.a(paramString2, "Orientation", String.valueOf(i));
          break;
          i = 6;
          continue;
          i = 3;
          continue;
          i = 8;
        }
      } while (!paramBoolean1);
      if (!StringUtil.a(paramString1))
      {
        com.tencent.mobileqq.utils.FileUtils.d(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity.EditPicPartManager", 2, "save from delete saved file");
        }
      }
    } while (TextUtils.isEmpty(paramString2));
    if (paramBoolean3) {
      ImageUtil.a(paramString2, "Orientation", String.valueOf(0));
    }
    com.tencent.biz.qqstory.utils.FileUtils.b(BaseApplication.getContext(), new File(paramString2));
  }
  
  private void d(int paramInt)
  {
    Object localObject = PlusPanelUtils.a(AppConstants.aW);
    Activity localActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    localActivity.getIntent().putExtra("image_path", (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditPicPartManager", 2, "reset2Camera begin " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() + " new path " + (String)localObject);
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a()).edit().putString("edit_pic_new_path", (String)localObject).commit();
    localObject = Uri.fromFile(new File((String)localObject));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("android.intent.extra.quickCapture", true);
    localIntent.putExtra("output", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
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
      QQToast.a(localActivity, "相机启动失败", 0).a();
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
  
  protected SimpleObserver a()
  {
    return new anzw(this);
  }
  
  public void a()
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
        break label316;
      }
      localObject = "0";
      if (j == -1) {
        break label323;
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
      StatisticCollector.a(BaseApplication.getContext()).a(null, "photo_send_from_shortvideo", true, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.e("EditPicActivity.EditPicPartManager", 2, "[ShortVideoMergeReport] tag=photo_send_from_shortvideo templateId=" + j + " camera=" + i);
      }
      ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity());
      return;
      label316:
      localObject = "1";
      break;
      label323:
      ReportController.b(null, "dc00898", "", "", "0X8007375", "0X8007375", 0, 0, (String)localObject, "" + j, "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2131034158, 0);
      return;
    }
    if (QLog.isColorLevel())
    {
      Object localObject = paramIntent.getComponent();
      String str = ((ComponentName)localObject).getClassName();
      localObject = ((ComponentName)localObject).getPackageName();
      QLog.i("EditPicActivity.EditPicPartManager", 2, String.format(Locale.getDefault(), "gotoActivityForBusiness [%s, %s]", new Object[] { str, localObject }));
    }
    paramIntent.addFlags(603979776);
    paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
    paramActivity.startActivity(paramIntent);
    paramActivity.setResult(-1);
    paramActivity.finish();
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new EditVideoButton(this, paramEditVideoParams.b);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton = ((EditVideoButton)localObject);
    localArrayList.add(localObject);
    localObject = new EditProviderPart(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart = ((EditProviderPart)localObject);
    localArrayList.add(localObject);
    localObject = new EditVideoDoodle(this, paramEditVideoParams.b);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle = ((EditVideoDoodle)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicRawImage(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicCropPart(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart = ((EditPicCropPart)localObject);
    localArrayList.add(localObject);
    localObject = new EditVideoPoi(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoi = ((EditVideoPoi)localObject);
    localArrayList.add(localObject);
    localObject = new EditVideoPoiSearch(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiSearch = ((EditVideoPoiSearch)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.b, 128))
    {
      localObject = new EditVideoArtFilter(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.b, 8192))
    {
      localObject = new EditPicSave(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave = ((EditPicSave)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.b, 134217728))
    {
      localObject = new EditVideoTag(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag = ((EditVideoTag)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.b, 131072))
    {
      localObject = new EditVideoPermission(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPermission = ((EditVideoPermission)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.b, 16777216))
    {
      localObject = new EditVideoShareGroup(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoShareGroup = ((EditVideoShareGroup)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.b, 536870912))
    {
      localObject = new EditVideoVote(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote = ((EditVideoVote)localObject);
      localArrayList.add(localObject);
      localObject = new EditVideoInteract(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract = ((EditVideoInteract)localObject);
      localArrayList.add(localObject);
      localObject = new EditVideoInteractPaster(this, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoInteractPaster = ((EditVideoInteractPaster)localObject);
      localArrayList.add(localObject);
    }
    if ((paramEditVideoParams.jdField_a_of_type_Int == 1) && (a(paramEditVideoParams.b, 131072))) {
      localArrayList.add(new EditSyncQzonePart(this));
    }
    this.jdField_a_of_type_Int = paramEditVideoParams.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public void a(Error paramError)
  {
    SLog.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "图片合成失败，请重试 : " + paramError, 0).a();
  }
  
  public void a(boolean paramBoolean)
  {
    A();
    Object localObject = null;
    if ((this.e) && (paramBoolean)) {}
    for (;;)
    {
      a((Observer)localObject);
      return;
      localObject = a();
    }
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditPicPartManager", 2, "giveUpEditVideo, is from camera" + i + " clear photo " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      }
      new File(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()).delete();
      ImageUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
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
            break label259;
          }
          ReportController.b(null, "dc00898", "", "", "0X80072C6", "0X80072C6", 0, 0, (String)localObject, "" + j, "", "");
        }
        for (;;)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, localIntent, 2131034158, 0);
          return;
          localObject = "1";
          break;
          label259:
          ReportController.b(null, "dc00898", "", "", "0X80072C7", "0X80072C7", 0, 0, (String)localObject, "" + j, "", "");
        }
      }
      d(i);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2131034158, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager
 * JD-Core Version:    0.7.0.1
 */