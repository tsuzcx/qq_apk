package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.List;
import java.util.Map;

class DoodleEditView$2
  implements TextFaceEditLayer.LayerListener
{
  DoodleEditView$2(DoodleEditView paramDoodleEditView) {}
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    FaceLayer.FaceItem localFaceItem;
    Object localObject;
    if ((paramZoomItem instanceof FaceLayer.FaceItem))
    {
      localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
      if (localFaceItem.b) {
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))
        {
          localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
          ((FaceLayer)localObject).b.remove(localFaceItem);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c();
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(paramZoomItem, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.p();
      return;
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      break;
      if ((localFaceItem.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
      for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
      {
        localObject = (List)((FaceLayer)localObject).a.get(localFaceItem.d);
        if (localObject == null) {
          break;
        }
        ((List)localObject).remove(localFaceItem.e);
        break;
      }
      if ((paramZoomItem instanceof TextLayer.TextItem)) {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c();
      } else {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c();
      }
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2)
  {
    if (paramZoomItem == null) {}
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e());
      if ((paramZoomItem instanceof TextLayer.TextItem))
      {
        a(paramZoomItem, paramInt1, paramInt2, 0.0F, 0.0F);
        return;
      }
    } while (((!(paramZoomItem instanceof FaceLayer.FaceItem)) && (!(paramZoomItem instanceof FaceLayer.FaceAndTextItem))) || (DoodleEditView.a(this.a) == null));
    DoodleEditView.a(this.a).a(paramZoomItem);
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    int k = 0;
    int j = 0;
    int i;
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      paramZoomItem = ((TextLayer.TextItem)paramZoomItem).a;
      if (paramZoomItem != null)
      {
        i = paramInt2;
        if (!paramZoomItem.a())
        {
          i = paramInt2;
          if (paramInt2 == 0) {
            i = 3;
          }
        }
      }
    }
    switch (i)
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramZoomItem.a();
      paramZoomItem.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
      return;
    case 2: 
      paramZoomItem.a(paramInt1, true);
      if (paramInt1 == -1) {
        paramInt1 = j;
      }
      break;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramZoomItem, paramInt1, 1);
      return;
      if (paramInt1 == -1) {
        paramInt1 = k;
      }
      for (;;)
      {
        paramZoomItem.a(paramInt1, true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramZoomItem, paramInt1, 2);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {}
    while (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {
      return;
    }
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2)
  {
    SLog.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + paramZoomItem);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (paramZoomItem == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (paramZoomItem.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(paramZoomItem, 1);
        if (paramZoomItem.g) {
          this.a.a(paramZoomItem);
        }
      }
    } while (paramZoomItem.g);
    this.a.b(paramZoomItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.2
 * JD-Core Version:    0.7.0.1
 */