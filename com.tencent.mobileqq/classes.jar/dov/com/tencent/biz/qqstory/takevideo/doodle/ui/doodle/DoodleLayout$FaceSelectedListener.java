package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class DoodleLayout$FaceSelectedListener
  implements IFaceSelectedListener
{
  private DoodleLayout$FaceSelectedListener(DoodleLayout paramDoodleLayout) {}
  
  private boolean a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper, boolean paramBoolean)
  {
    boolean bool;
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d))
    {
      FaceLayer.LayerParams localLayerParams = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      FaceLayer localFaceLayer = this.a.a();
      Object localObject = localFaceLayer;
      if (paramSelectedItem.jdField_a_of_type_Int == 1) {
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject = localFaceLayer;
          if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject = this.a.a();
        }
      }
      bool = ((FaceLayer)localObject).a(paramSelectedItem.jdField_a_of_type_JavaLangString, paramSelectedItem.b, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, paramString, false, paramSelectedItem.jdField_a_of_type_Int, this.a.d(), paramSegmentKeeper);
      if ((!this.a.b) || (!bool)) {
        break label251;
      }
    }
    label251:
    for (paramBoolean = true;; paramBoolean = false)
    {
      DoodleLayout.c(paramBoolean);
      return bool;
      paramFloat2 = ScreenUtil.b / 2;
      break;
    }
  }
  
  public void a()
  {
    this.a.a().d();
    this.a.a().d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    SLog.b("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramSelectedItem, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    if (a(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, true))
    {
      DoodleLayout.a("clk_oneface");
      VideoEditReport.a("0X80076CA");
      VideoEditReport.b("0X80075DF");
    }
    if (SlideShowPhotoListManager.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 8, 1);
    }
  }
  
  public void a(InfomationFacePackage.Item paramItem, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramItem == null) {
      SLog.e("DoodleLayout", "the item is null.");
    }
    label143:
    label277:
    label356:
    label492:
    label504:
    label507:
    label511:
    for (;;)
    {
      return;
      SLog.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", paramItem.b, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
      this.a.b();
      SLog.b("DoodleLayout", "addLocationFaceItem:" + paramItem.toString());
      boolean bool = this.a.getContext() instanceof EditPicActivity;
      InfoStickerDrawable localInfoStickerDrawable;
      Object localObject1;
      if (bool)
      {
        paramItem.d = 0;
        localInfoStickerDrawable = InformationFaceConstant.a(paramItem, this.a.getContext(), -1L);
        if (!bool) {
          break label474;
        }
        if (localInfoStickerDrawable == null) {
          break label507;
        }
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), localInfoStickerDrawable.a());
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label511;
        }
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "[" + ((Drawable)localObject1).getIntrinsicWidth() + "," + ((Drawable)localObject1).getIntrinsicHeight() + "]");
        }
        FaceLayer.LayerParams localLayerParams;
        Object localObject2;
        int i;
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d))
        {
          localLayerParams = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject2 = this.a.a();
          if ((paramItem.d != 3) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
            break label492;
          }
          i = 3;
          localObject2 = this.a.a();
          if (!TextUtils.isEmpty(paramString)) {
            break label504;
          }
          paramString = paramItem.b;
        }
        for (;;)
        {
          bool = ((FaceLayer)localObject2).a(paramItem.m, paramString, (Drawable)localObject1, localLayerParams, "", paramItem.a, paramItem.l, i, localInfoStickerDrawable.c(), 0, this.a.d());
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "add Face result" + bool);
          }
          if ((this.a.b) && (bool)) {}
          for (bool = true;; bool = false)
          {
            DoodleLayout.c(bool);
            return;
            paramItem.d = 3;
            break;
            localObject1 = localInfoStickerDrawable;
            break label143;
            paramFloat2 = ScreenUtil.b / 2;
            break label277;
            i = 0;
            break label356;
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    SLog.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", paramItem.d, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a(paramItem, paramFloat1, paramFloat2, paramFloat3);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    VideoEditReport.b("0X80075E3");
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    SLog.b("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + paramItem.d);
    this.a.a(paramItem, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    VideoEditReport.b("0X80075E3");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a().a(paramString1, paramString2);
    this.a.a().a(paramString1, paramString2);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void b(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    SLog.b("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramSelectedItem, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    a(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.FaceSelectedListener
 * JD-Core Version:    0.7.0.1
 */