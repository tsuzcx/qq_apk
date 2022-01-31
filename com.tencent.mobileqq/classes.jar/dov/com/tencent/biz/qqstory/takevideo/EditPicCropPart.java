package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView.CropListener;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.ArrayList;

public class EditPicCropPart
  extends EditVideoPart
  implements View.OnClickListener, CropView.CropListener
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  CropView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[5];
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = false;
  View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean = false;
  View e;
  
  public EditPicCropPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364332));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView = ((CropView)a(2131364376));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.setCropListener(this);
      this.jdField_a_of_type_AndroidViewView = a(2131364374);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131364375);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = a(2131364379);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = a(2131364378);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.e = a(2131364369);
    }
  }
  
  private void k()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setEnabled(false);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
      this.e.setVisibility(0);
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (localBitmap != this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())) {
      localBitmap.recycle();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 7) {
      QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getApplicationContext(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getString(2131438705), 0).a();
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    GeneratePicArgs localGeneratePicArgs = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs;
    localGeneratePicArgs.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      VideoEditReport.b("0X80075E9", VideoEditReport.jdField_a_of_type_Int);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      bool = true;
      VideoEditReport.b("0X80075D5");
    }
    return bool;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    j();
    if (paramInt == 11) {
      if (!this.jdField_b_of_type_Boolean) {
        k();
      }
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    l();
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    switch (paramView.getId())
    {
    case 2131364376: 
    case 2131364377: 
    default: 
    case 2131364374: 
    case 2131364375: 
    case 2131364379: 
      boolean bool2;
      do
      {
        return;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidViewView.setEnabled(false);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_c_of_type_AndroidViewView.setEnabled(false);
        }
        VideoEditReport.b("0X80075D3");
        return;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.a(270);
        VideoEditReport.b("0X80075D4");
        return;
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
        bool2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
        if (QLog.isColorLevel()) {
          QLog.d("EditPicCrop", 2, "crop remove face items" + bool2);
        }
      } while (!bool2);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.remove(FaceLayer.a);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
      VideoFilterTools.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b() == 8)) {
        bool1 = true;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_AndroidGraphicsBitmap, bool1);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.w();
      VideoEditReport.b("0X80075D2");
      GeneratePicArgs.a(this.jdField_a_of_type_ArrayOfInt);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicCropPart
 * JD-Core Version:    0.7.0.1
 */