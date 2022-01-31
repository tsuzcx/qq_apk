import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.List;

public class ojm
  implements FaceLayer.LayerEventListener
{
  public ojm(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b(1, paramInt);
    }
  }
  
  public void a(FaceLayer.FaceAndTextItem paramFaceAndTextItem)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceAndTextItem = paramFaceAndTextItem;
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null)
    {
      SLog.b("DoodleLayout", "selectLocation: clickItem-->" + paramFaceAndTextItem.toString());
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceAndTextItem.a());
    }
  }
  
  public boolean a(FaceLayer.FaceItem paramFaceItem)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((GestureHelper.ZoomItem)localObject).d = false;
        if (!(localObject instanceof FaceLayer.FaceItem)) {
          break label120;
        }
        FaceLayer localFaceLayer = this.a.a();
        if (localFaceLayer != null) {
          localFaceLayer.a.add((FaceLayer.FaceItem)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramFaceItem);
        paramFaceItem.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
        if ((localObject instanceof TextLayer.TextItem))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((TextLayer)localObject).d();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojm
 * JD-Core Version:    0.7.0.1
 */