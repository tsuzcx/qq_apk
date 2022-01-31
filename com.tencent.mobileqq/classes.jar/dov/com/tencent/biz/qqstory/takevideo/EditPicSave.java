package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anrl;
import anrn;
import anrp;
import anrq;
import anrr;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateEditPicDoodleSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.MergePicSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class EditPicSave
  extends EditVideoPart
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public ThreadExcutor.IThreadListener a;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 20;
  
  public EditPicSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new anrl(this);
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(a());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, a()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.f(-1);
    localProgressPieDrawable.e(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.g(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new anrr(this));
    return localProgressPieDrawable;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void j()
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.b = PublishFileManager.a(2);
    localGenerateContext.a = new GeneratePicArgs(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a(0, localGenerateContext);
    }
    SLog.d("EditPicSave", "PUBLISH start ...");
    a("正在保存...", false, 0);
    a(20);
    localObject = BitmapFactory.decodeResource(a(), 2130843253);
    Stream.of(localGenerateContext).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null)).map(new ThreadOffFunction(2)).map(new MergePicSegment(EditPicConstants.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, (Bitmap)localObject)).map(new UIThreadOffFunction(this)).subscribe(new anrn(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {
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
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130970895);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363005);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366642)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    a().a().postDelayed(new anrp(this), paramInt);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    VideoEditReport.b("0X80080E1", VideoEditReport.a);
    j();
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new anrq(this), 1000L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void h()
  {
    d();
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave
 * JD-Core Version:    0.7.0.1
 */