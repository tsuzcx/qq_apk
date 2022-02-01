package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateLocalVideoSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateThumbArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateThumbSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeMergeThumbSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import java.util.Iterator;
import java.util.List;

public class EditVideoSave
  extends EditVideoPart
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  float b = 3.0F;
  
  public EditVideoSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(a());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, a()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoSave.6(this));
    return localProgressPieDrawable;
  }
  
  private void i()
  {
    ReportController.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    CodecParam.mRecordTime = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    CodecParam.mRecordFrames = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    GenerateContext localGenerateContext;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null)
    {
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();
      CodecParam.mSaveMode = i;
      SLog.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localGenerateContext.b = PublishFileManager.a(2);
      localActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EditVideoPart)((Iterator)localObject).next()).a(0, localGenerateContext);
      }
      i = 0;
      break;
    }
    SLog.d("EditVideoSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131703874), false, 0);
    a(2);
    Stream.of(localGenerateContext).map(new ThreadOffFunction("EditVideoSave", 2)).map(new GenerateThumbSegment()).map((StreamFunction)StoryApi.a(GenerateDoodleImageSegment.class, new Object[] { (EditDoodleExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditDoodleExport.class) })).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoSave.2(this, localGenerateContext));
  }
  
  private void k()
  {
    SLog.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    GenerateContext localGenerateContext;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
      if (MediaCodecDPC.f()) {
        localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (MediaCodecDPC.b() * 1000);
      }
      localGenerateContext.b = PublishFileManager.a(2);
      localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EditVideoPart)((Iterator)localObject1).next()).a(0, localGenerateContext);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    SLog.d("EditVideoSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131703740), false, 0);
    a(2);
    Object localObject2 = Stream.of(localGenerateContext).map(new ThreadOffFunction("EditVideoSave", 2)).map(new GenerateLocalVideoSegment());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(0));
    }
    ((Stream)localObject1).map(new HWEncodeMergeThumbSegment()).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoSave.3(this, localGenerateContext));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a() + ", progress:" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramIntent != null) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId")))));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        d();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131703912));; localStringBuilder = new StringBuilder(HardCodeUtil.a(2131703769)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, localStringBuilder, 0).a();
          return;
        }
      }
    } while (paramInt2 != 0);
    d();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      i();
      return;
    }
    k();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561994);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373545);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371908)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void g()
  {
    d();
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave
 * JD-Core Version:    0.7.0.1
 */