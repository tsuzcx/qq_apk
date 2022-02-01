package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.ocr.OCRPerformUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView.CropListener;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.ArrayList;

public class EditPicCropPart
  extends EditVideoPart
  implements View.OnClickListener, CropNewView.CropListener
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CropNewView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[5];
  public Bitmap b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  boolean f = false;
  
  public EditPicCropPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    } while (!QLog.isColorLevel());
    QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365350));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
        localLayoutParams.bottomMargin = ViewUtils.a(56.5F);
        this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView = ((CropNewView)a(2131365477));
      this.jdField_a_of_type_AndroidViewView = a(2131365473);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131365475);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365348));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = a(2131364366);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365476));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131365474));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131378633));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.setCropListener(this);
    }
  }
  
  private boolean c()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    if (i == 103)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d();
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (!this.f)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      k();
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private boolean d()
  {
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + false);
    }
    return false;
  }
  
  private boolean e()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    if (i == 103)
    {
      bool = true;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.e();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiBackPressed , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698985);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void m() {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_b_of_type_AndroidViewView.setEnabled(false);
    }
    while (paramInt != 2) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    GeneratePicArgs localGeneratePicArgs = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs;
    localGeneratePicArgs.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      VideoEditReport.b("0X80075E9", VideoEditReport.jdField_a_of_type_Int);
      AEBaseReportParam.a().d(true);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    c();
    if (paramInt == 7) {
      if (!this.jdField_b_of_type_Boolean) {
        d();
      }
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (!e()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      }
      VideoEditReport.b("0X80075D5");
      OCRPerformUtil.a("0X800AAE5", 0);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.e = true;
    a(this.e);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.a();
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      if (!this.f) {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 103)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      this.e = false;
      b(this.e);
      VideoEditReport.b("0X80075D3");
      OCRPerformUtil.a("0X800AAE3", 0);
      continue;
      b();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.b();
      VideoEditReport.b("0X80075D4");
      OCRPerformUtil.a("0X800AAE4", 0);
      continue;
      if (!d())
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
        boolean bool = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.c();
        if (QLog.isColorLevel()) {
          QLog.d("EditPicCrop", 2, "crop remove face items" + bool);
        }
        if (bool)
        {
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.remove(FaceLayer.a);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.remove("DynamicFaceLayer");
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.remove(TextLayer.a);
          }
          Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.a();
          if (localBitmap != null)
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
            VideoFilterTools.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_AndroidGraphicsBitmap, false);
            if (!c()) {
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.w();
            }
          }
          VideoEditReport.b("0X80075D2");
          OCRPerformUtil.a("0X800AAE6", 0);
          GeneratePicArgs.a(this.jdField_a_of_type_ArrayOfInt);
          continue;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.c();
          a();
          continue;
          m();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicCropPart
 * JD-Core Version:    0.7.0.1
 */