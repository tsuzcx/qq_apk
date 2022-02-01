package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateEditPicDoodleSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.MergePicSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelItemInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class EditPicSave
  extends EditVideoPart
{
  int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new EditPicSave.1(this);
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private SendPanelItemInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 20;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  public EditPicSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
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
    localProgressPieDrawable.a(new EditPicSave.5(this));
    return localProgressPieDrawable;
  }
  
  private String a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
    }
    return "";
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void d()
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.b = PublishFileManager.a(2);
    localGenerateContext.a = new GeneratePicArgs(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(0, localGenerateContext);
    }
    SLog.d("EditPicSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131703719), false, 0);
    a(20);
    Stream.of(localGenerateContext).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new MergePicSegment(EditPicConstants.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new EditPicSave.2(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      VideoEditReport.b("0X80080E1", VideoEditReport.a);
      d();
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = null;
      return;
      this.jdField_c_of_type_Int = paramInt;
    } while (!(paramObject instanceof SendPanelItemInfo));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = ((SendPanelItemInfo)paramObject);
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
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
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = true;
    c();
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave
 * JD-Core Version:    0.7.0.1
 */