package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.io.File;

class DoodleEditView$1
  implements IFaceSelectedListener
{
  DoodleEditView$1(DoodleEditView paramDoodleEditView) {}
  
  private void c(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b()) {
      return;
    }
    paramSegmentKeeper = DoodleUtil.a(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3);
    paramSelectedItem = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(), paramSelectedItem.jdField_a_of_type_JavaLangString, paramSelectedItem.b, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, paramSelectedItem.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c(paramSelectedItem);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c();
  }
  
  public void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(InfomationFacePackage.Item paramItem, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b()) || (paramItem == null)) {
      return;
    }
    Object localObject1 = null;
    SLog.b("DoodleEditView", "addLocationFaceItem:" + paramItem.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      paramItem.d = 0;
      localObject2 = InformationFaceConstant.a(paramItem, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((InfoStickerDrawable)localObject2).a());
      }
      if (localObject1 == null) {
        break label597;
      }
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "[" + ((Drawable)localObject1).getIntrinsicWidth() + "," + ((Drawable)localObject1).getIntrinsicHeight() + "]");
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "x:" + paramFloat1);
      }
      if (!(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a instanceof FaceLayer.FaceItem)) {
        break label665;
      }
      localObject2 = (FaceLayer.FaceItem)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a;
      if (((FaceLayer.FaceItem)localObject2).q > 4.0D) {
        ((FaceLayer.FaceItem)localObject2).q = 1.0F;
      }
      f1 = ((FaceLayer.FaceItem)localObject2).a.x;
      f2 = ((FaceLayer.FaceItem)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((FaceLayer.FaceItem)localObject2).s + (f1 - f2);
      f2 = ((FaceLayer.FaceItem)localObject2).a.x;
      if (f1 >= ScreenUtil.a(23.0F)) {
        break label662;
      }
      f2 = ((FaceLayer.FaceItem)localObject2).a.x - f1 + ScreenUtil.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = paramItem.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof InfoStickerDrawable)) {}
        for (paramItem = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(), paramItem.m, paramString, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, "", paramItem.d, paramItem.a, paramItem.l, ((InfoStickerDrawable)localObject1).c(), this.a.a());; paramItem = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(), paramItem.m, paramString, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, "", paramItem.d, false, paramItem.l, null, this.a.a()))
        {
          if (((paramItem instanceof FaceLayer.FaceItem)) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a instanceof FaceLayer.FaceItem))) {
            ((FaceLayer.FaceItem)paramItem).g = ((FaceLayer.FaceItem)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a).g;
          }
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c(paramItem);
          paramItem.a.x = f2;
          this.a.postInvalidate();
          return;
          paramItem.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          paramItem.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b()) {
      return;
    }
    FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localLayerParams != null) {
      if ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          paramItem = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(), paramItem.g, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, localFile.getAbsolutePath(), paramItem.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c(paramItem);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      SLog.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.1
 * JD-Core Version:    0.7.0.1
 */